import property_catalogue.LTL.sat.absent 
import property_catalogue.LTL.sat.precedes 
import common_meta 

meta def switch (s : string) : tactic string := 
do 
  tgt ← tactic.target, ctx ← tactic.local_context,
  match tgt with
  | `(sat (precedes.globally %%e₁ %%e₂) _) :=  
    precedes.globally.solve e₁ e₂ s ctx
  | `(sat (absent.globally %%e₁) _) :=  
    absent.globally.solve e₁ s ctx 
  | _ := return string.empty
  end 


meta def solve_patterns' (n : ℕ) : tactic (string × string) := 
do 
   let s₁ := string.empty,
   p ← by_induction s₁,
 --  tactic.trace s₂,
   return p 
 --  ((by_induction s₁ >> return s₁) <|>
 --    (switch s₁ >> return s₁) <|> return s₁)