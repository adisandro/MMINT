import system.io tactic justification LTS property_catalogue.LTL.patterns
open io list lean.parser tactic interactive.types

open lean.parser (ident)


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
   let h : name := ("H" ++ to_string (i+1) : string),
   tactic.interactive.«have» h none ```(H ⟨%%(reflect i), dec_trivial⟩)),
   `[clear H, try {dsimp at *}]

namespace expr 

meta def log_format (e : expr) : tactic string := 
do 
   e_fmt ← tactic_format_expr e,
   pure e.to_string

end expr 

namespace string 

meta def log (s1 s2 : string) : tactic string := 
pure (s1 ++ s2)

end string  


meta def analyze (n : ℕ) : tactic unit := 
do  
  tactic.interactive.apply ``(property.deductive_of_justfd _),
 `[rw property.justified], 
 `[rw set.Inter], 
  x ← get_unused_name `x, H ← get_unused_name `H,
  intro x,  
  intro H, 
  `[simp at *],
  convert_to_premises n,
   `[repeat {rw sat at *}],
   try `[simp at *]



meta def base_case (tgt : expr) : list expr → tactic string
| [] := return string.empty
| (h::t) := 
  (infer_type h >>= unify tgt) >> 
  (do `[exact %%h], h ← h.log_format, 
  return h)
  <|> base_case t


meta def get_index_expr : list expr → tactic  expr
| [] := failed
| (h::t) := do 
            h_t ← infer_type h,
            nnat ← to_expr ``(ℕ),
            unify nnat h_t >> 
            return h <|> get_index_expr t
            

meta def inductive_case  : list expr → tactic (option string)
| [] := return none
| (h ::t) := do 
       h_t ← infer_type h,
       match h_t with 
       | `(∀ i : ℕ, %%body) := 
        (do 
           ii ← local_context >>= get_index_expr,
           let e := expr.mk_app h [ii],
           `[apply %%e],
           h ← h.log_format, ii ← ii.log_format,
           return $ some h)
         <|> inductive_case t
       | _ := inductive_case t
      end

meta def debug (s : string): tactic (string × string) := 
do 
   tgt ← tactic.target,
   match tgt with 
   | `(%%path ⊨ %%e1) := 
      match e1 with 
      | `(formula.neg %%e2) := do  
      let e3 : expr := expr.const `transitions_safe [],
      let e4 : expr := expr.mk_app e3 [e2],
      e2 ← tactic_format_expr e2,
      e4 ← tactic_format_expr e4,
      return $ ⟨s, to_string e4 ++ " " ++ to_string e2⟩
      | _ := return ⟨s, string.empty⟩
      end
   |  _ :=    return ⟨s, string.empty⟩
   end 

meta def by_induction (s : string) : tactic (string × string) := 
do
   analyze 2,
   i ← get_unused_name `i, 
   IH ← get_unused_name `IH,
   `[repeat {rw sat at *}], 
   intro i, 
   `[induction i with i IH], -- fix this, logan!
   s ← pure $ s.append  "by_induction,\n",
   tgt ← target,
   s' ← local_context >>= base_case tgt ,
   s ← pure $ s.append  "base_case " ++ s' ++ ",\n",
   ic_res ← local_context >>= inductive_case,
   match ic_res with 
   | none := debug s
   | (some s'') := 
   do
   s ← pure $ s.append  "inductive_case " ++ s'' ++ ",\n",
   tgt ← target,
   local_context >>= base_case tgt ,
   return ⟨s,string.empty⟩ 
   end 




meta def match_hyps (s : string) : tactic string := 
do  
   repeat1 (applyc `and.intro),
   s.log "repeat {apply and.intro},\n",
   `[repeat {assumption}],
   s.log "repeat {assumption}"


meta def match_premises : tactic unit := 
do  
   repeat1 (applyc `and.intro), `[repeat {assumption}]



open interactive (parse)

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
   analyze 2,
   i ← get_unused_name `i, 
   IH ← get_unused_name `IH,
    `[repeat {rw sat at *}], 
     try `[simp at *],
    intro i, 
   `[induction i with i IH] -- fix this, logan!
