import common_meta LTS.patterns LTS.sat.precedes LTS.sat.absent
open tactic 

meta def switch : tactic unit := 
do 
    tgt ← tactic.target,
    ctx ← tactic.local_context,
    match tgt with
    | `(sat (absent.globally %%tok) %%path) := do
        absent.globally.solve tok ctx
    | `(sat (precedes.globally %%tok1 %%tok2) %%path) := do 
        precedes.globally.solve tok1 tok2 ctx 
  /-  | `(sat (precedes.before %%tok1 %%tok2 %%tok3) %%path) := do 
       precedes.before.solve tok1 tok2 tok3 ctx -/
    | _ := trace  "Don't know what to do."
end 

meta def solve_patterns (n : ℕ) : tactic unit := 
initialize n >> switch >> finish_up
