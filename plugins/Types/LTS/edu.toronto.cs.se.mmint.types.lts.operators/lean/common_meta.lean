import system.io tactic justification LTS property_catalogue.LTL.patterns
open io list lean.parser tactic interactive.types

open lean.parser (ident)

variable {α : Type}

meta structure PROOF_STATE (α : Type) := 
(init_goal : expr := default expr)
(input : property.input α := default (property.input α))
(input_string : string := string.empty)
(strat_expr : expr := default expr)
(solved : bool := ff)
(originals : list (string × expr) := [])
(total : list expr := [])
(used : list string := [])
(PROPS : expr := default expr)
(tscript : list string := [])
(hints : list string := [])
(unused : string := string.empty)

meta def originals_aux : expr → list expr  
| `(list.cons %%h %%t) := match h with 
   | `(λ x, x ⊨ %%prop) := do [prop] ++ originals_aux t
   | _ := originals_aux t  
   end 
| _ := []

meta def get_originals (ps : PROOF_STATE α) : (PROOF_STATE α) := 
 let l := originals_aux ps.PROPS in 
 let l':= (list.range l.length).map 
 (λ i, ("P" ++ to_string (i+1) : string)) in 
 {originals := list.zip l' l ..ps}

namespace PROOF_STATE 


meta def log (ps : PROOF_STATE α) (s : string) : tactic (PROOF_STATE α):= 
return { tscript := ps.tscript ++ [s] ..ps}

meta def fill_props : list expr → tactic (list expr)
| [] := return []
| (h::t) := do h_t ← infer_type h, 
            match h_t with 
            | `(sat %%foo %%bar) := 
            do et ← fill_props t, return ([h] ++ et)
            | _ := fill_props t  
            end 

end PROOF_STATE


def tscript_string : list string → string 
| [] := string.empty 
| [x] := x ++ ","
| (h::t) := h ++ ", \n " ++ tscript_string t 

def unused_string : list string → string 
| [] := string.empty 
| (h::t) :="\n-- " ++ h ++ unused_string t 

def hints_string : list string → string 
| [] := string.empty 
| (h::t) := "\n--HINT " ++ h ++ hints_string t 


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


meta def get_unused (ps : PROOF_STATE α) : tactic string := 
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
             

meta def analyze (ps : PROOF_STATE α) : tactic (PROOF_STATE α) := 
 do 
   tactic.interactive.apply ``(property.deductive_of_justfd _),
 `[rw property.justified], `[rw set.Inter], 
  x ← get_unused_name `x, H ← get_unused_name `H,
  intro x, intro H, 
  `[simp at *],
  convert_to_premises ps.input.length,
   `[repeat {rw sat at *}], try `[simp at *], 
   return ps 


meta def base_case (ps : PROOF_STATE α) (tgt : expr) : list expr → tactic (PROOF_STATE α)
| [] := return ps
| (h::t) := do 
   h_t ← infer_type h,
  (unify h_t tgt) >> (do `[exact %%h], 
           h' ← tactic_format_expr h,
           ps ← ps.log $ "base_case " ++ h'.to_string,
            return { used := ps.used ++ [h'.to_string] ..ps})
  <|> base_case t


meta def Inductive_hyp (tgt : expr) : list expr → tactic unit
| [] := return ()
| (h::t) := do 
   h_t ← infer_type h,
  (unify h_t tgt) >> (do `[exact %%h], return ())
  <|> Inductive_hyp t


meta def get_index_expr : list expr → tactic  expr
| [] := failed
| (h::t) := do 
            h_t ← infer_type h,
            nnat ← to_expr ``(ℕ),
            unify nnat h_t >> 
            return h <|> get_index_expr t
            

meta def inductive_case  (ps : PROOF_STATE α)  : list expr → tactic (PROOF_STATE α)
| [] := return ps 
| (h ::t) := do 
       h_t ← infer_type h,
       match h_t with 
       | `(∀ i : ℕ, %%body) := 
        (do 
           ii ← local_context >>= get_index_expr,
           let e := expr.mk_app h [ii],
           `[apply %%e], 
           h' ← tactic_format_expr h,
           ps ← ps.log $ "inductive_case " ++ h'.to_string,
           return {used := ps.used ++ [h'.to_string] ..ps})
         <|> inductive_case t
       | _ := inductive_case t
end

meta def by_induction (ps : PROOF_STATE α) : tactic (PROOF_STATE α) := 
do
   analyze ps,
   l ← local_context >>= load_properties,
   let ps := {total := l ..ps},  `[repeat {rw sat at *}], 
   i ← get_unused_name `i,  IH ← get_unused_name `IH,
   intro i, 
   `[induction i with i IH], -- fix this, logan!
   ps ← ps.log "by_induction",
   tgt ← target,
   p₁ ← local_context >>= base_case ps tgt,
   p₂ ← local_context >>= inductive_case p₁,
   tgt ← target,
   local_context >>= Inductive_hyp tgt ,
   `[repeat {rw sat at *}], 
   return p₂

meta def match_premises : tactic unit := 
do  repeat1 (applyc `and.intro), `[repeat {assumption}]

open interactive (parse)


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
   `[induction i with i IH] -- fix this, logan!
