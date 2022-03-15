import Architectural.ArchWithContracts
import Architectural.ArchitectureDecomp
import tactic

variables {Φ Var : Type} [fintype Var] [decidable_eq Var] [AssertionLang Φ Var]

@[reducible]
def list_conj : list Φ → Φ  
| [] := ⊤
| (h::t) := AssertionLang.conj Var (h) (list_conj t)


theorem list_conj_iff (l : list Φ) (σ : Trace Var) : (σ ∈ (@AssertionLang.sem Φ Var _ _ _ (@list_conj Φ Var _ _ _ l))) ↔ (∀ φ ∈ l, σ ∈ (@AssertionLang.sem Φ Var _ _ _ φ)) := 
begin 
  split,
  intro H1,
  intros φ H2,
  induction l with hd tl IH,
  exfalso, assumption,
  cases H2,rw H2,
  unfold list_conj at H1,
  rw AssertionLang.conj_def at H1,
  cases H1 with H11 H22, exact H11,
  apply IH,
  unfold list_conj at H1,
  rw AssertionLang.conj_def at H1,
  exact H1.2, assumption,

  intros H,
  induction l with hd tl IH,
  unfold list_conj, rw AssertionLang.T_def, simp,
  obtain H1 := H hd,
  unfold list_conj,
  rw AssertionLang.conj_def,
  split,
  apply H1,
  simp,
  apply IH,
  intros φ H',
  have : φ ∈ hd::tl, from list.mem_cons_of_mem hd H',
  cases this,
  rw this, apply H, exact list.mem_cons_self hd tl,
  apply H φ, exact list.mem_cons_of_mem hd H',
end 

@[reducible]
def get_nfs {S : Component Var} (A : ArchitectureWithContracts Φ S) : list Φ := 
  (A.subs.map (λ C, (A.contracts.find_val C).iget)).map (λ C, C.nf)


def RPO_fst {S : Component Var} (A : ArchitectureWithContracts Φ S): Prop := 
  ∀ σ , σ ∈ (@AssertionLang.sem Φ Var _ _ _  (@AssertionLang.Impl Φ Var _ _ _ (@list_conj Φ Var _ _ _ (get_nfs A)) (A.parent.nf)))



def RPO_snd {S : Component Var}  (A : ArchitectureWithContracts Φ S) : Prop := 
  ∀ S' ∈ A.subs,
  ∀ σ, σ ∈ (@AssertionLang.sem Φ Var _ _ _
  (@AssertionLang.Impl Φ Var _ _ _  
  (AssertionLang.conj Var A.parent.A (@list_conj Φ Var _ _ _ (list.map (λ C : Component Var,  (A.contracts.find_val C).iget.nf) (A.subs.erase S')))) (A.contracts.find_val S').iget.A)
  )

def RPO {S : Component Var}  (A : ArchitectureWithContracts Φ S) : Prop := RPO_fst A ∧ RPO_snd A

variables S : Component Var 

variables IMPLEMENTATIONS : Π (U : Component Var),  Impl Var

variable CURRENT_ENVIRONMENT : Env Var 

def isCorrectImplementation (C : Component Var) (I : Impl Var) (Ctr : Contract Φ Var) : Claim (Trace Var) := 
{
  X := I, 
  P := λ σ, σ ∈ (@AssertionLang.sem Φ Var _ _ _ Ctr.A) → σ ∈ 
                (@AssertionLang.sem Φ Var _ _ _ Ctr.G)
}

def isGoodEnv (E : Env Var) (C : Contract Φ Var) : Claim (Trace Var) := 
{
  X := E, 
  P := λ s, s ∈ (@AssertionLang.sem Φ Var _ _ _ C.A)
}


namespace Contract 

def to_arch_components 
{S : Component Var} 
 (A : ArchitectureWithContracts Φ S) 
(IMPLEMENTATIONS : Implementations A.to_Architecture) :
Π (a : Component Var), (λ (C : Component Var), C ∈ A.to_Architecture.subs) a → Claim (Trace Var) := 
λ a h, isCorrectImplementation a  (IMPLEMENTATIONS a h) (A.contracts.find_val a).iget


def strategy
 {S : Component Var} 
 (A : ArchitectureWithContracts Φ S)
 (Is : Implementations A.to_Architecture)
 (CURRENT_ENVIRONMENT : Env Var) : Strategy (Trace Var) := 
{ parent := Claim.correctDecomposition A Is CURRENT_ENVIRONMENT,
  decomp := λ _, 
  (@list.pmap (Component Var) (Claim (Trace Var)) (λ C, C ∈ A.subs) 
  (λ a h, isCorrectImplementation a (Is a h) (A.contracts.find_val a).iget) A.subs (by {simp,}))++[isGoodEnv CURRENT_ENVIRONMENT A.parent]

}

def mk_strategy {S : Component Var} 
 (A : ArchitectureWithContracts Φ S) : Strategy (Trace Var) := Contract.strategy A (λ e h, set.univ) (set.univ)

def strat_is_deductive 
{S : Component Var} 
(A : ArchitectureWithContracts Φ S) : Prop := ∀ Is : Implementations A.to_Architecture, ∀ E : Env Var, 
deductive (Trace Var) (Contract.strategy A Is E)


end Contract 


lemma subclaims_meaning_env 
 {S : Component Var} 
 (A : ArchitectureWithContracts Φ S) 
 (IMPLEMENTATIONS : Implementations A.to_Architecture)
 (CURRENT_ENVIRONMENT : Env Var)
 : 
  (∀ clm ∈ (Contract.strategy A IMPLEMENTATIONS CURRENT_ENVIRONMENT).subclaims, ⟦clm⟧) → 
 ⟦isGoodEnv CURRENT_ENVIRONMENT A.parent⟧ := 
begin 
 intros H₁,
 replace H₁ := H₁ (isGoodEnv CURRENT_ENVIRONMENT A.parent),
 rw Contract.strategy at H₁, rw Strategy.subclaims at H₁,
  simp at H₁,
  exact H₁,
end 

lemma subclaims_meaning_impl 
 {S : Component Var} 
 (A : ArchitectureWithContracts Φ S) 
 (IMPLEMENTATIONS : Implementations A.to_Architecture)
 (CURRENT_ENVIRONMENT : Env Var): 
  (∀ clm ∈ (Contract.strategy A IMPLEMENTATIONS CURRENT_ENVIRONMENT).subclaims, ⟦clm⟧) → 
 ∀ C ∈ A.subs, ⟦isCorrectImplementation C (IMPLEMENTATIONS C H) (A.contracts.find_val C).iget⟧ := 
begin 
 intros H₁,
 rw Contract.strategy at H₁, rw Strategy.subclaims at H₁,
 simp at H₁,
 intros C mem, 
 replace H₁ := H₁ (isCorrectImplementation C (IMPLEMENTATIONS C mem) (Map.find_val C A.contracts).iget),
 apply H₁,
 clear H₁,
 left, use C,
 split, refl, assumption,
end 


lemma subclaims_meaning
  {S : Component Var} 
 (A : ArchitectureWithContracts Φ S) 
 (IMPLEMENTATIONS : Implementations A.to_Architecture)
 (CURRENT_ENVIRONMENT : Env Var) : 
  (∀ clm ∈ (Contract.strategy A IMPLEMENTATIONS CURRENT_ENVIRONMENT).subclaims, ⟦clm⟧) → 
  ⟦isGoodEnv CURRENT_ENVIRONMENT A.parent⟧ ∧ 
 ∀ C ∈ A.subs, ⟦isCorrectImplementation C (IMPLEMENTATIONS C H) (A.contracts.find_val C).iget⟧ := 
begin 
  intros H₁,
  split, apply subclaims_meaning_env, assumption,
  apply subclaims_meaning_impl, assumption,
end 

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

-- def LACU_ARCH_WITH_CONTRACTS : ArchitectureWithContracts lt_eq_assertions LACU := 


theorem via_rpo 
{S : Component Var}  
{A : ArchitectureWithContracts Φ S}
(E :  Env Var)
(Is :Implementations A.to_Architecture)
: RPO A → deductive (Trace Var) (Contract.strategy A Is E) := 
begin
  rintros ⟨H₁, H₂⟩,
  intros H,
  replace H := subclaims_meaning _ _  _ H,
  cases H with H₃ H₄,
  intros σ mem,
  rw Contract.strategy, rw Claim.correctDecomposition,
  simp, split, {
  clear H₂ H₃,
  rw Claim.correctDecompositionImpl, simp,
  intros H₂ H₃ H₅,
  rw CompositeImplementation at H₃,
  simp at H₃,
  rw RPO_fst at H₁,
  replace H₁ := H₁ σ,
  rw AssertionLang.impl_def at H₁,
  have : σ ∈ AssertionLang.sem (list_conj (get_nfs A)) := by 
  {
    rw list_conj_iff,
    rw get_nfs,
    simp,
    intros S' Hmem,
    have : Map.find_val S' A.contracts ≠ none, from A.all_components S' Hmem,
    have opt : ∃ C : Contract Φ Var, Map.find_val S' A.contracts = some C, by 
      {exact option.ne_none_iff_exists'.mp this,},
    cases opt with C H₆, 
    have further : (Map.find_val S' A.contracts).iget = C, by {exact (congr_arg option.iget H₆).trans rfl,},
    simp [further] at *,
    replace H₄ := H₄ S' Hmem,
    rw isCorrectImplementation at H₄,
    rw meaning at H₄, simp at H₄,
    replace H₃ := H₃ S' S',
    replace H₄ := H₄ σ (H₃ Hmem),
    have further : (Map.find_val S' A.contracts).iget = C, by {exact (congr_arg option.iget H₆).trans rfl,},
    simp [further] at *, clear further,
    rw AssertionLang.disj_def,
    have EM : σ ∈ @AssertionLang.sem Φ Var _ _ _ (AssertionLang.compl Var C.A) ∨ σ ∉ AssertionLang.sem (AssertionLang.compl Var C.A), from or_not,
    cases EM,
    left, assumption,
    right, apply H₄,
    rw AssertionLang.compl_def at EM,
    simp at EM, exact EM,
  },
  replace H₁ := H₁ this,
  rw AssertionLang.disj_def at H₁,
  cases H₁,
  rw AssertionLang.compl_def at H₁,
  simp at H₁,
  contradiction,
  exact H₁,},
  { clear H₁,
    rw Claim.correctDecompositionEnv,
    intros  _ S' EnvSat H₅ H₈ H₆,
    rw CompositeEnvironment at H₆,
    simp at H₆, cases H₆ with H₆ H₇,
    rw RPO_snd at H₂,
    replace H₂ := H₂ S' EnvSat σ, 
    rw AssertionLang.impl_def at H₂,
    apply H₂, clear H₂, simp,
    rw AssertionLang.conj_def, split,
    rw Env.satisfiesContract at H₅,
    apply H₅, apply H₆,
    rw list_conj_iff,
    dsimp at *,
    intros φ hφ, simp at *,
    cases hφ with w h,
    cases h with h1 h2,
    have opt : ∃ C : Contract Φ Var, Map.find_val w A.contracts = some C, by 
      {exact option.ne_none_iff_exists'.mp (A.all_components w (list.mem_of_mem_erase h1)),},
    cases opt with C H₆, 
    have further : (Map.find_val w A.contracts).iget = C, by {exact (congr_arg option.iget H₆).trans rfl,},
    simp [further] at *,
    rw ← h2, rw AssertionLang.disj_def, tidy,
    replace H₄ := H₄ w (list.mem_of_mem_erase h1),
    rw meaning at H₄, rw isCorrectImplementation at H₄, replace H₄ := H₄ σ,simp at H₄,
    replace H₇ := (H₇ w w (h1)),
    rw H₆_1 at *,
    replace H₄ := H₄ H₇,
    rw AssertionLang.compl_def,
    simp at *,
    rwa ← imp_iff_not_or,
  }
end
