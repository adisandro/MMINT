import Architectural.ArchWithContracts

variables {Φ Var : Type} [fintype Var] [decidable_eq Var] [AssertionLang Φ Var]

def isCorrectDecompositionImpl 
{S : Component Var} 
(A : ArchitectureWithContracts Φ  S)
(Is : Implementations A.to_Architecture)
  : Prop := 
(∀ (S' : Component Var) (h : S' ∈ A.subs), (Is S' h).satisfiesContract (A.contracts.find_val S').iget)
   → (@CompositeImplementation Var _ _ _ _ S {..A} Is).satisfiesContract A.parent

def isCorrectDecompositionEnv 
{S : Component Var}
(A : ArchitectureWithContracts Φ  S)
(Is : Implementations A.to_Architecture)
(E : Env Var) : Prop := 
∀ (S'' : Component Var) (h'': S'' ∈ A.subs) , 
(E.satisfiesContract A.parent ∧ 
(∀ (S' : Component Var) {S' ∈ A.subs.erase S''}, (Is S' (list.mem_of_mem_erase H)).satisfiesContract (A.contracts.find_val S').iget) → 
(CompositeEnvironment A.to_Architecture S'' Is E).satisfiesContract (A.contracts.find_val S'').iget)


def isCorrectDecomposition 
{S : Component Var}
(A : ArchitectureWithContracts Φ S)
(Is : Implementations A.to_Architecture)
(E : Env Var) := 
isCorrectDecompositionImpl A Is ∧ 
isCorrectDecompositionEnv A Is E 

namespace Claim 


def correctDecompositionImpl 
{S : Component Var} 
(A : ArchitectureWithContracts Φ S)
(Is :Implementations A.to_Architecture)
(σ : Trace Var) : Prop := 
(∀ (S' : Component Var) {S' ∈ A.subs}, ∀ σ',(σ' ∈ (Is S' H) ∧ 
(σ' ∈ (@AssertionLang.sem Φ Var _ _ _ (A.contracts.find_val S').iget.A))) → 
(σ' ∈ (@AssertionLang.sem Φ Var _ _ _ (A.contracts.find_val S').iget.G))) → ( (σ ∈ (@CompositeImplementation Var _ _ _ _ S ↑A Is) ∧ (σ ∈ (@AssertionLang.sem Φ Var _ _ _ A.parent.A))) → (σ ∈ (@AssertionLang.sem Φ Var _ _ _ A.parent.G)))


-- example {C : Contract Φ Var} {σ : Trace Var}  :
-- (σ ∈ (@AssertionLang.sem Φ Var _ _ _ C.A)) → (σ ∈ (@AssertionLang.sem Φ Var _ _ _ C.G))
-- ↔ (σ ∈ (@AssertionLang.sem Φ Var _ _ _ C.nf)) := 
-- begin
--   split,
--   intro H,
--   rw AssertionLang.disj_def,
--   rw AssertionLang.compl_def,
--   simp,
--   rw ← imp_iff_not_or, exact H, 
--    intro H,
--   rw AssertionLang.disj_def at H,
--   rw AssertionLang.compl_def at H,
--   simp at H,
--   rw ← imp_iff_not_or at H, exact H,
-- end 

def correctDecompositionImpl' 
{S : Component Var} 
(A : ArchitectureWithContracts Φ  S)
(Is :Implementations A.to_Architecture)
(σ : Trace Var) : Prop := 
(∀ (S' : Component Var) {S' ∈ A.subs}, ∀ σ',(σ' ∈ (Is S' H) ∧ 
(σ' ∈ (@AssertionLang.sem Φ Var _ _ _ (A.contracts.find_val S').iget.A))) → 
(σ' ∈ (@AssertionLang.sem Φ Var _ _ _ (A.contracts.find_val S').iget.G))) → 
( (σ ∈ (@CompositeImplementation Var _ _ _ _ S ↑A Is) ∧ (σ ∈ (@AssertionLang.sem Φ Var _ _ _ A.parent.A))) → (σ ∈ (@AssertionLang.sem Φ Var _ _ _ A.parent.G)))

def correctDecompositionEnv 
{S : Component Var}
(A : ArchitectureWithContracts Φ  S)
(Is :Implementations A.to_Architecture)
(E : Env Var) (σ : Trace Var) : Prop := 
∀ (S'' : Component Var) {S'' ∈ A.subs},
E.satisfiesContract A.parent → 
(∀ (S' : Component Var) {S' ∈ A.subs.erase S''}, (Is S' (list.mem_of_mem_erase H)).satisfiesContract (A.contracts.find_val S').iget) → 
(σ ∈ (CompositeEnvironment A.to_Architecture S'' Is E)) → σ ∈ (@AssertionLang.sem Φ Var _ _ _ ((A.contracts.find_val S'').iget).A)


def correctDecomposition 
{S : Component Var}
(A : ArchitectureWithContracts Φ S)
(Is : Implementations A.to_Architecture)
(E : Env Var) : Claim (Trace Var) := 
{
  X := set.univ, 
  P := 
  λ σ, correctDecompositionImpl A Is σ ∧ correctDecompositionEnv A Is E σ 
}

end Claim 
-- def correctDecompositionImplProperty
-- (A : ArchWithContracts S)
-- (Is : Implementations A)  : Property (Trace Var) := λ σ,
-- (∀ (S' : Component Var) {S' ∈ A.subs}, 
--     (∀ σ', σ' ∈ (Is S' H) ∧ σ' ∈ $\llparenthesis$(A.contracts.get S').A$\rrparenthesis$ 
--   → (σ' ∈ $\llparenthesis$(A.contracts.get S').G$\rrparenthesis$))  
-- → ((σ ∈ CompositeImplementation A Is ∧ σ ∈ $\llparenthesis$S.C.A$\rrparenthesis$) 
-- → σ ∈ $\llparenthesis$S.C.G$\rrparenthesis$)

-- def correctDecompositionEnvProperty
-- {S : ComponentWithContract Φ Var}
-- (A : ArchWithContracts S)
-- (Is :Implementations A) 
-- (E : Env Var)  : Property (Trace Var) :=λ σ, 
-- ∀ (S'' : Component Var),
--   E.satisfiesContract S.C → 
--   (∀ (S' : Component Var) {S' ∈ A.subs}, 
--   (Is S' H).satisfies (A.contracts.get S')) → 
--  (σ ∈ CompositeEnvironment A S'' Is E) → 
--  σ ∈ {{((A.contracts.get S'')).A}}
theorem  
claim_imp_correctDecomp
{S : Component Var}
(A : ArchitectureWithContracts Φ  S)
(Is : Implementations A.to_Architecture)
(E : Env Var) : 
⟦Claim.correctDecomposition A Is E⟧ → isCorrectDecomposition A Is E := 
begin
  intro clm, 
  rw meaning at clm, split, {
    intro h,
    intro s,
    replace clm := clm s, 
    rw [Claim.correctDecomposition] at clm,
    simp at clm, replace clm := clm.1,
    intro h',
    cases h' with h₂ h₃,
    rw Claim.correctDecompositionImpl at clm,
    apply clm,
    intros S' S'' hMem, 
    replace h := h S'',
    rw Impl.satisfiesContract at h,
    rw CompositeImplementation at h₂, simp at h₂, 
    intro h'', apply h,split, exact h₂,
    exact h₃,
  }, 
  {
    rintros S'' h₄ ⟨h₅, h₆⟩ s,
    replace clm := clm s, rw [Claim.correctDecomposition] at clm, 
    simp at clm, replace clm := clm.2 S'' h₅ h₆, exact clm,
    rw Claim.correctDecompositionEnv at clm, assumption,
}
end 



theorem decompCorrectImpClaim 
{S : Component Var}
(A : ArchitectureWithContracts Φ  S)
(Is : Implementations A.to_Architecture)
(E : Env Var) : 
isCorrectDecomposition A Is E → 
⟦Claim.correctDecomposition A Is  E⟧ := 
begin 
  intro h,
  rw Claim.correctDecomposition, rw meaning, simp,
  rw forall_and_distrib,
  split, 
  { 
    intro s, 
    rw Claim.correctDecompositionImpl,
    revert s,simp,
    replace h := h.1,
    rw isCorrectDecompositionImpl at h,
    intros σ' h₂ h₃,
    rw CompositeImplementation at h₃,
    intros h₄,
    rw Impl.satisfiesContract at h,
    simp at h,
    apply h,
    intros S' h',
    replace h₂ := h₂ S' h',
    intros σ h₅, cases h₅ with L R,
    replace h₂ := h₂ σ L R, simp, 
    apply h₂,split, rw CompositeImplementation, apply h₃, assumption,
  },
  {
    intros σ, intros _, intros S'' mem, 
    replace h := h.2,
    rw isCorrectDecompositionEnv at h,
    simp at h,
    replace h := h S'' mem, 
    intros s smem, rw Env.satisfiesContract at h, 
    simp at h,
    apply h,
    intros h₂, apply s, exact smem, 
  }

end

theorem decompositionCorrectAsClaim 
{S : Component Var}
(A : ArchitectureWithContracts Φ  S)
(Is : Implementations A.to_Architecture)
(E : Env Var) : 
isCorrectDecomposition A Is E ↔ ⟦Claim.correctDecomposition A Is E⟧ := 
iff.intro (decompCorrectImpClaim A Is  E) (claim_imp_correctDecomp A Is  E)

