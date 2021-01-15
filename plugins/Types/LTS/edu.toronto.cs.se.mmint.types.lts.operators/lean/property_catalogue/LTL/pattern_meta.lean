import property_catalogue.LTL.sat.absent 
import property_catalogue.LTL.sat.precedes 
import common_meta 

meta def switch : tactic unit := 
do 
  tgt ← tactic.target,
  ctx ← tactic.local_context,
  match tgt with
  | `(sat (precedes.globally %%tok1 %%tok2) %%foo) := 
  do 
    precedes.globally.solve tok1 tok2 ctx, by_cases
  | `(sat (absent.globally %%tok1) %%foo) :=  
  do 
    absent.globally.solve tok1 ctx, by_cases
  | _ := return ()
  end 