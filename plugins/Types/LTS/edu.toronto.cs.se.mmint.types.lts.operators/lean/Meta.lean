import system.io tactic justification sat
open io list lean.parser tactic interactive.types

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


meta def initialize (n : ℕ) : tactic unit := 
do tactic.interactive.apply ``(justfd_imp_deductive _),
   try `[rw justified, simp, rw set.Inter],
   x ← get_unused_name `pth, H ← get_unused_name `H,
   intro x,
   try `[simp],
   intro H >>
   (list.range n).mmap 
   (λ i, do 
   let h : name := ("H" ++ to_string (i+1) : string),
   tactic.interactive.«have» h none ```(H ⟨%%(reflect i), dec_trivial⟩)),
   `[clear H, try {simp at *}],
return ()


meta def switch : tactic unit := 
do 
    tgt ← target,
    ctx ← local_context,
    match tgt with
    | `(sat (absent.globally %%tok) %%path) := do
        absent.globally.solve tok ctx
    | `(sat (precedes.globally %%tok1 %%tok2) %%path) := do 
        precedes.globally.solve tok1 tok2 ctx 
  /-  | `(sat (precedes.before %%tok1 %%tok2 %%tok3) %%path) := do 
       precedes.before.solve tok1 tok2 tok3 ctx -/
    | _ := trace  "Don't know what to do."
end 

meta def finish_up : tactic unit := 
do  
   repeat (applyc ``and.intro),
    all_goals 
   (`[assumption] <|> do trace "Try adding this", target >>= trace), 
return ()

meta def solve_patterns (n : ℕ) : tactic unit := 
initialize n >> switch >> finish_up
