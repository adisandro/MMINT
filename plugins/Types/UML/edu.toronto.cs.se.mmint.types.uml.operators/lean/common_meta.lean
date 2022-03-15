import system.io tactic justification LTS property_catalogue.LTL.patterns property_catalogue.LTL.pattern_meta

open io list lean.parser tactic interactive.types

open lean.parser (ident)

variable {α : Type}

meta def auto_all_comps : tactic unit := 
   `[ simp,
    repeat {all_goals {split}},
    repeat {exact with_top.coe_ne_top,}]

def tscript_string : list string → string 
| [] := string.empty 
| [x] := x ++ ","
| (h::t) := h ++ ", \n " ++ tscript_string t 

def unused_string : list string → string 
| [] := string.empty 
| (h::t) :="\n-- " ++ h ++ unused_string t 

def hints_string : list string → string 
| [] := "-/" 
| (h::t) := h ++ hints_string t 


meta def foo  : list string → list (string × expr) →  list expr
| [] _ := []
| _ [] := []
| (a::s) (b::t) := if (a = b.1) then [b.2] ++ (foo s t) 
                   else if (a ∈ (b::t).unzip.1) then 
                            foo (a::s) (t)
                        else foo s (b::t)


meta def stringify : list expr → tactic string 
| [] := return string.empty 
| (h::t) := do  
               h ← tactic_format_expr h,
               return ("--" ++ h.to_string ++"\n")


meta def get_unused (ps : proofState α) : tactic string := 
 let l := foo ps.used ps.originals in 
 stringify (list.diff ps.originals.unzip.2 l)
 


meta def read {α : Type}
(f : string)
(p : lean.parser α) : lean.parser α :=
do
  buf ← unsafe_run_io (io.fs.read_file f),
  (a, s) ← with_input p buf.to_string,
  return a


meta def set_goal (goal : expr) : tactic unit :=
do
   v <- mk_meta_var goal,
   set_goals (list.cons v nil),
   return ()


meta def is_solved : tactic bool :=
done >> return tt <|> return ff

meta def try_tactic_on_goal (tac: tactic unit)
(goal : expr) : tactic bool := 
set_goal goal >> tac >> is_solved

meta def convert_to_premises (n : ℕ) : tactic unit := 
do 
   (list.range n).mmap 
   (λ i, do 
   let h : name := ("P" ++ to_string (i+1) : string),
   tactic.interactive.«have» h none ```(H ⟨%%(reflect i), dec_trivial⟩)),
   `[clear H, try {dsimp at *}]

meta def load_properties : list expr → tactic (list expr)
| [] := return []
| (a::l) := do t ←  infer_type a,
            let b : bool := (t.list_local_consts = []),
            if !b then do ls ← load_properties l, return (a::ls)
            else load_properties l 
             

meta def analyze (ps : property.proofState α) : tactic (property.proofState α) := 
 do 
   tactic.interactive.apply ``(property.deductive_of_justfd _),
 `[rw property.justified], `[rw set.Inter], 
  x ← get_unused_name `x, H ← get_unused_name `H,
  intro x, intro H, 
  `[simp at *],
  convert_to_premises ps.input.length,
   `[repeat {rw sat at *}], try `[simp at *], 
   return ps 


meta def base_case (ps : proofState α) (tgt : expr) : list expr → tactic (proofState α)
| [] := return ps
| (h::t) := do 
   h_t ← infer_type h,
  (unify h_t tgt) >> 
          (do `[exact %%h], 
           h' ← tactic_format_expr h,
           ps ← ps.log $ "base_case " ++ h'.to_string,
            return { used := ps.used ++ [h'.to_string] ..ps})
  <|> base_case t

namespace proofState 

meta def try_resolve_IH (Γ : proofState α) (subclaim : string)  : tactic (proofState α) := 
do 
   result ← try_or_report_error (`[exact IH]),
   match result with 
   | sum.inl () := 
      Γ.log_used_tactic_subclaim "inductive_case" subclaim  
   | sum.inr data := 
      Γ.log_hint data
   end 
end proofState
-- meta def check_remaining_prems (tgt : expr) (subclaim : string) (Γ : proofState α) : list expr → tactic (proofState α × bool)
-- | [] := return ⟨Γ, false⟩
-- | (h::t) := do 
--    h_t ← infer_type h,
--   (unify h_t tgt) >> (
--    do `[exact %%h],
--    Γ.log_used_tactic_subclaim "inductive_case " subclaim, return ⟨Γ,true⟩ )
--   <|> check_remaining_prems t


meta def get_index_expr : list expr → tactic  expr
| [] := failed
| (h::t) := do 
            h_t ← infer_type h,
            nnat ← to_expr ``(ℕ),
            unify nnat h_t >> 
            return h <|> get_index_expr t


meta def stringifyFmt :  format → tactic string := 
λ f, do return (format.to_string f)

meta def stringOfFormatExpr : expr → tactic string := 
λ e, do 
   fmt ← (tactic_format_expr e >>= stringifyFmt),
   return fmt


meta def inductive_case (Γ : proofState α)  : 
list expr →  tactic (proofState α) := 
λ premises, match premises with 
| [] := return Γ 
| (h ::t) := do 
       τ ← infer_type h,
       match τ with 
       | `(∀ i : ℕ, %%body) := 
        do 
            index_expr ← local_context >>= get_index_expr,
            let e := expr.mk_app h [index_expr],
            tactic.apply e,
            tgt ← target,
            subclaim ← (stringOfFormatExpr h),
            Γ ← Γ.try_resolve_IH subclaim, 
            return Γ
            -- Try remaining premises.
        <|> inductive_case t
       | _ := inductive_case t
      end
end 

meta def by_induction (ps : proofState α) : tactic (proofState α) := 
do  
   `[repeat {rw sat at *}], 
   i ← get_unused_name `i,  
   IH ← get_unused_name `IH,
   intro i, `[induction i with i IH], -- fix this, logan!
   ps ← ps.log "by_induction",
   tgt ← target,
   p₁ ← local_context >>= base_case ps tgt,
   p₂ ← local_context >>= inductive_case p₁,
   `[repeat {rw sat at *}],
   return p₂



meta def solve_inductive (ps : proofState α) : tactic (proofState α) := 
do 
   p ← by_induction ps,
   b ← is_solved, 
   if !b then do 
   h ← debug_inductive,
   return {hints := p.hints ++ [h] ..p} else 
   return {solved := b, ..p} 


-- meta def Switch (ps : proofState α) : tactic (proofState α) := 
-- do
--    let n := ps.input.length,
--    let chr := repr n,
--    ps ← ps.log ("analyze " ++ chr),
--    ps ← @switch α ps,
--    b ← is_solved, 
--    return {solved := b, ..ps}

-- meta def SOLVE (ps : proofState α ) : tactic (proofState α) := 
-- do 
--    analyze ps,
--    l ← local_context >>= load_properties,
--    let ps := {total := l ..ps},
--    ps ← Switch ps,
--    if ps.solved then return ps else do  
--    ps ← solve_inductive {tscript := [], used := [], ..ps},
--    return ps 

     

meta def match_premises : tactic unit := 
do  repeat1 (applyc `and.intro), `[repeat {assumption}]

open interactive (parse)


meta def tactic.interactive.match_premises : tactic unit := 
do  repeat1 (applyc `and.intro), `[repeat {assumption}]

meta def tactic.interactive.analyze (n : ℕ) : tactic unit := 
do 
   tactic.interactive.apply ``(property.deductive_of_justfd _),
 `[rw property.justified], `[rw set.Inter], 
  x ← get_unused_name `x, H ← get_unused_name `H,
  intro x, intro H, 
  `[simp at *],
  convert_to_premises n,
  `[repeat {rw sat at *}], try `[simp at *]
   
meta def tactic.interactive.base_case (H : parse ident) : tactic unit := 
do   
   e ← get_local H,
   tactic.exact e


meta def tactic.interactive.inductive_case (H : parse ident) : tactic unit := 
do   
   e ← get_local H,
    ii ← local_context >>= get_index_expr,
           let e := expr.mk_app e [ii],
         `[apply %%e],
         `[assumption]

meta def tactic.interactive.by_induction : tactic unit := 
do 
   tactic.interactive.analyze 2,
   i ← get_unused_name `i, 
   IH ← get_unused_name `IH,
    `[repeat {rw sat at *}], 
     try `[simp at *],
    intro i, 
   `[induction i with i IH] -- TODO: fix this to avoid name capture!
