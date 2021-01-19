import property_catalogue.LTL.sat.absent 
import property_catalogue.LTL.sat.precedes 
import common_meta 

meta def switch (str : string) : tactic string := 
do 
  tgt ← tactic.target, ctx ← tactic.local_context,
  match tgt with
  | `(sat (precedes.globally %%tok1 %%tok2) _) :=  precedes.globally.solve tok1 tok2 str ctx
  | `(sat (absent.globally %%tok1) _) :=  absent.globally.solve tok1 str ctx 
  | _ := return string.empty
  end 

meta def solve_patterns (n : ℕ) (S : expr) : tactic string := 
do 
   s₁ ← initialize n S,
   s₂ ← switch s₁,
   by_cases s₂ <|> return s₁
