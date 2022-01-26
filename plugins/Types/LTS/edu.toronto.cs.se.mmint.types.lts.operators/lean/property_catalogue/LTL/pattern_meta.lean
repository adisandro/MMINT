import property_catalogue.LTL.sat.absent 
import property_catalogue.LTL.sat.precedes 
import proof_state tactic 

variable {α : Type}

def is_even (n : ℕ) : Prop := ∃ k : ℕ, 2 * k = n 

lemma double_even : ∀ n : ℕ, is_even (2 * n)  := 
  λ n, Exists.intro n (rfl)

theorem four_is_even : is_even 14 := 
begin
  apply double_even 7, 
end 


meta def switch (ps : proofState α) : tactic (proofState α) := 
do 
  tgt ← tactic.target, ctx ← tactic.local_context,
  match tgt with
  -- need to update 
  -- | `(sat (precedes.globally %%e₁ %%e₂) _) :=  
  --   precedes.globally.solve e₁ e₂ ps ctx
  | `(sat (absent.globally %%e₁) _) :=  do 
    ps ← absent.globally.solve e₁ ps ctx, return ps 
  | `(sat (absent.between %%e1 %%e2 %%e3) _) := do
   ps ← absent.between.solve ps ctx, return ps 
  | `(sat (absent.after_until %%e1 %%e2 %%e3) _) := 
  do 
    ps ← absent.after_until.solve ps ctx, 
    return ps
  | _ := return ps
  end 


meta def debug_inductive : tactic (string) := 
do 
   tgt ← tactic.target,

   match tgt with 
   | `(¬(%%path ⊨ %%e1)) := 
      do  
      let e3 : expr := expr.const `transitions_safe [],
      let e4 : expr := expr.mk_app e3 [e1],
      e2 ← tactic_format_expr e1,
      e4 ← tactic_format_expr e4,
      return $ to_string e4 ++ " " ++ to_string e2
   |  _ :=    return string.empty
   end 
