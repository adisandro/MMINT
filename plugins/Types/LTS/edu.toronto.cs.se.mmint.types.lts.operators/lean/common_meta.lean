import system.io tactic justification
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


meta def init2 (n : ℕ) : tactic unit := do 
try `[rw justified, simp, rw set.Inter],
   x ← get_unused_name `pth, H ← get_unused_name `H,
   intro x,
   try `[simp],
   intro H >>
   (list.range n).mmap 
   (λ i, do 
   let h : name := ("H" ++ to_string (i+1) : string),
   tactic.interactive.«have» h none ```(H ⟨%%(reflect i), dec_trivial⟩)),
   `[clear H, try {dsimp at *}],
   return ()


meta def test (clm lst : expr) : tactic unit := 
return () <|>
tactic.interactive.apply ``(property.deductive_of_justfd %%clm %%lst)


meta def initialize (n : ℕ) (S : expr) : tactic unit := 
do  tactic.interactive.apply ``(property.deductive_of_justfd %%S),
   try `[rw justified, simp, rw set.Inter],
   x ← get_unused_name `pth, H ← get_unused_name `H,
   intro x,
   try `[simp],
   intro H >>
   (list.range n).mmap 
   (λ i, do 
   let h : name := ("H" ++ to_string (i+1) : string),
   tactic.interactive.«have» h none ```(H ⟨%%(reflect i), dec_trivial⟩)),
   `[clear H, try {dsimp at *}],
   return ()



meta def inductive_solve (n : ℕ) (S : expr) : tactic unit := 
do  
   tactic.interactive.apply ``(property.deductive_of_justfd %%S),
   try `[rw justified, simp, rw set.Inter],
   x ← get_unused_name `pth, H ← get_unused_name `H,
   intro x,
   try `[simp],
   intro H >>
   (list.range n).mmap 
   (λ i, do 
   let h : name := ("H" ++ to_string (i+1) : string),
   tactic.interactive.«have» h none ```(H ⟨%%(reflect i), dec_trivial⟩)),
   `[clear H, try {dsimp at *}]

meta def by_induction : tactic unit := 
do  
try (do
   i ← get_unused_name `i,
   intro i >>
   `[induction i with i IH,
   assumption,
   apply H2, exact IH]),
   res ← is_solved,
   if res then return () else failed

meta def by_cases : tactic unit := 
do  
   try (do repeat (applyc ``and.intro),
    all_goals 
   (`[assumption] <|> return ())),
   res ← is_solved,
   if res then return () else failed 
