import Architectural.Architecture
import Architectural.Map
variables {Var : Type} [fintype Var] [decidable_eq Var] 

meta def auto_all_comps : tactic unit :=
   `[ simp,
    repeat {all_goals {split}},
    repeat {exact with_top.coe_ne_top,}]

structure ArchitectureWithContracts  (Φ : Type)  [AssertionLang Φ Var] (S : Component Var) extends Architecture S := 
(parent : Contract Φ Var)
(contracts : Map (Component Var) (Contract Φ Var))
(all_components : ∀ S ∈ subs, contracts.find_val S ≠ none)

instance {Φ : Type} [AssertionLang Φ Var]  {S : Component Var} : has_coe (ArchitectureWithContracts Φ S) (Architecture S)  := 
{ coe := λ A , { ..A} }

