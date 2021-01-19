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

meta def deconstruct_hyp (n : ℕ) : tactic unit := 
do 
   (list.range n).mmap 
   (λ i, do 
   let h : name := ("H" ++ to_string (i+1) : string),
   tactic.interactive.«have» h none ```(H ⟨%%(reflect i), dec_trivial⟩)),
   `[clear H, try {dsimp at *}]

meta def new_str (s1 s2 : string) : tactic string := 
pure (s1 ++ s2)


meta def initialize (n : ℕ) (S : expr) : tactic string := 
do  
  let s : string := string.empty,
  tactic.interactive.apply ``(property.deductive_of_justfd %%S),
  e ←  tactic_format_expr S,
  s ← new_str s ("apply property.deductive_of_justfd " ++ (format.to_string e) ++ ",\n"),
 `[rw property.justified],  s ← new_str s "rw property.justified,\n",
 `[simp], s ← new_str s "simp,\n",
 `[rw set.Inter], s ← new_str s "rw set.Inter,\n",
  x ← get_unused_name `x, H ← get_unused_name `H,
  intro x,  s ← new_str s  "intro x,\n",
  n_str ← pure (repr n),
 `[simp], s ← new_str s "simp,\n",
  intro H, s ← new_str s  "intro H,\n",
  deconstruct_hyp n,
  s ← new_str s ("deconstruct_hyp " ++ n_str ++ ", \n"),
  return s


meta def by_induction (s : string) : tactic string := 
do
   i ← get_unused_name `i,
   intro i, s ← new_str s  "intro i,\n",
   `[induction i with i IH],
   s ← new_str s  "induction i with i IH,\n",
   assumption,
   s ← new_str s  "assumption,\n",
   `[apply H2],
    s ← new_str s  "apply H2,\n",
   `[exact IH],
   new_str s "exact IH"

meta def by_cases (s : string) : tactic string := 
do  
   repeat1 (applyc `and.intro),
   s ← new_str s "repeat {apply and.intro},\n",
   `[repeat {assumption}],
   new_str s "repeat {assumption}"

meta def solve_hardcoded (n : ℕ) (S : expr) : tactic string := 
do 
   s₁ ← initialize n S,
   s₂ ← (by_induction s₁ <|> by_cases s₁ <|> return string.empty),
   return s₂
