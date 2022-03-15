import Architectural.Architecture common_meta
import Architectural.Map
variables {Var : Type} [fintype Var] [decidable_eq Var] 

structure ArchitectureWithContracts  (Φ : Type)  [AssertionLang Φ Var] (S : Component Var) extends Architecture S := 
(parent : Contract Φ Var)
(contracts : Map (Component Var) (Contract Φ Var))
(all_components : ∀ S ∈ subs, contracts.find_val S ≠ none := by {auto_all_comps, assumption,})

instance {Φ : Type} [AssertionLang Φ Var]  {S : Component Var} : has_coe (ArchitectureWithContracts Φ S) (Architecture S)  := 
{ coe := λ A , { ..A} }


-- def Construct 
-- (Φ : Type)  [AssertionLang Φ Var] 
-- (S : Component Var)
-- (SC : Contract Φ Var)
-- (A : Architecture S)
-- (contracts : Map (Component Var) (Contract Φ Var))
-- (all_components : ∀ S ∈ A.subs, contracts.find_val S ≠ none) : 

-- ArchitectureWithContracts Φ ⟨S,SC⟩ 
--  := ArchitectureWithContracts.mk {subs := A.subs} contracts all_components
