-- import LACU ArchitectureDecomp

-- variables IMPLEMENTATIONS : Π (U : Component PORTS),  Impl U

-- variable CURRENT_ENVIRONMENT : EnvC LACU_with_Contract


-- def isCorrectImplementation {C : Component PORTS} (I : Impl C) (Ctr : Contract lt_eq_assertions PORTS) : Claim (Trace PORTS) := 
-- {
--   X := I, 
--   P := λ σ, σ ∈ (lt_eq_assertions.sem Ctr.A) → σ ∈ (lt_eq_assertions.sem Ctr.G)
-- }

-- def isGoodEnv (E : EnvC LACU_with_Contract) : Claim (Trace PORTS) := 
-- {
--   X := E, 
--   P := λ s, s ∈ (lt_eq_assertions.sem LACU_with_Contract.C.A)
-- }


-- namespace Contract 

-- def strategy : Strategy (Trace PORTS) := 
-- { parent := Claim.correctDecomposition LACU_With_Subcontracts IMPLEMENTATIONS CURRENT_ENVIRONMENT,
--   decomp := λ C, 
--   LACU_ARCH_MODEL.subs.map (λ C, isCorrectImplementation (IMPLEMENTATIONS C) (LACU_With_Subcontracts.contracts.find_val C).iget) ++ [isGoodEnv CURRENT_ENVIRONMENT]
--    }

-- end Contract 


-- lemma subclaims_meaning_env : 
--   (∀ clm ∈ (Contract.strategy IMPLEMENTATIONS CURRENT_ENVIRONMENT).subclaims, ⟦clm⟧) → 
--  ⟦isGoodEnv CURRENT_ENVIRONMENT⟧ := 
-- begin 
--  intros H₁,
--  replace H₁ := H₁ (isGoodEnv CURRENT_ENVIRONMENT),
--  rw Contract.strategy at H₁, rw Strategy.subclaims at H₁,
--   simp at H₁,
--   exact H₁,
-- end 

-- lemma subclaims_meaning_impl : 
--   (∀ clm ∈ (Contract.strategy IMPLEMENTATIONS CURRENT_ENVIRONMENT).subclaims, ⟦clm⟧) → 
--  ∀ C ∈ LACU_ARCH_MODEL.subs, ⟦isCorrectImplementation (IMPLEMENTATIONS C) (LACU_With_Subcontracts.contracts.find_val C).iget⟧ := 
-- begin 
--  intros H₁,
--  rw Contract.strategy at H₁, rw Strategy.subclaims at H₁,
--  simp at H₁,
--  intros C mem, 
--  replace H₁ := H₁ (isCorrectImplementation (IMPLEMENTATIONS C) (Map.find_val C LACU_With_Subcontracts.contracts).iget),
--  apply H₁,
--  clear H₁,
--  left, use C,
--  split,assumption,refl,
-- end 


-- lemma subclaims_meaning: 
--   (∀ clm ∈ (Contract.strategy IMPLEMENTATIONS CURRENT_ENVIRONMENT).subclaims, ⟦clm⟧) → 
--   ⟦isGoodEnv CURRENT_ENVIRONMENT⟧ ∧ 
--  ∀ C ∈ LACU_ARCH_MODEL.subs, ⟦isCorrectImplementation (IMPLEMENTATIONS C) (LACU_With_Subcontracts.contracts.find_val C).iget⟧ := 
-- begin 
--   intros H₁,
--   split, apply subclaims_meaning_env, assumption,
--   apply subclaims_meaning_impl, assumption,
-- end 

-- theorem validity : deductive (Trace PORTS) (Contract.strategy IMPLEMENTATIONS CURRENT_ENVIRONMENT) := 
-- begin
--   intro H,
--   replace H := subclaims_meaning _ _ H,
--   cases H with Henv Himpl,
--   rw Contract.strategy,
--   simp,
--   rw Claim.correctDecomposition,
--   rw meaning, 
--   simp,
--   intros σ, 
--   split, {
--     rw Claim.correctDecompositionImpl,
--     intros H₁ H₂,
--     rw CI at H₂,
--     simp at H₂,
--     sorry 
--   }
-- end 



-- -- theorem LACU_Decomp_Correct : 
-- -- isCorrectDecomposition LACU_ARCH_MODEL IMPLEMENTATIONS CURRENT_ENVIRONMENT :=
-- -- begin
-- --   intro E,
-- --   rw isCorrectArchitecture, 
-- --   split,
-- --   rw CompositeImplementation,
-- --   rw Impl.satisfiesContract,
-- --   simp,
-- --   rw set.subset_def,
-- --   simp,
-- --   intros σ σ' h₁ h₂ h₃,
-- --   rw Impl.toSet at h₁, simp at h₁, 
-- -- end 