import tactic 
import system.io
open tactic 
open io list lean.parser interactive.types

open lean.parser (ident)

meta def set_goal (goal : expr) : tactic unit :=
do
   v <- mk_meta_var goal,
   set_goals (list.cons v list.nil),
   return ()


meta def is_solved : tactic bool :=
done >> return tt <|> return ff

meta def stringifyFmt :  format → tactic string := 
λ f, do return (format.to_string f)

meta def stringOfFormatExpr : expr → tactic string := 
λ e, do 
   fmt ← (tactic_format_expr e >>= stringifyFmt),
   return fmt

meta def read {α : Type}
(f : string)
(p : lean.parser α) : lean.parser α :=
do
  buf ← unsafe_run_io (io.fs.read_file f),
  (a, s) ← with_input p buf.to_string,
  return a


