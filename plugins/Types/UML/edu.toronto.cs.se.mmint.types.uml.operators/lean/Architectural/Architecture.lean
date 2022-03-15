import tactic 

import data.stream.defs 
import data.set.basic 
import data.set.lattice 
import data.list.basic 
import data.list.nodup 
import data.finset.basic
import justification
import tactic 

@[reducible]
def Val : Type := ℕ 
instance : has_lt Val := by {unfold Val, apply_instance}
instance : has_add Val := by {unfold Val, apply_instance}
def State (Var : Type) [fintype Var] [decidable_eq Var] : Type := Var → Val

def Trace (Var : Type) [fintype Var] [decidable_eq Var] : Type := stream (State Var)

class AssertionLang (Assertion : Type) (Var : Type) [fintype Var] [decidable_eq Var] 
extends has_top Assertion := 
(compl : Assertion → Assertion)
(conj : Assertion → Assertion → Assertion)
(disj : Assertion → Assertion → Assertion)
(sem : Assertion → set (Trace Var))
(T_def : sem ⊤ = set.univ)
(compl_def : ∀ A : Assertion, sem (compl A) = set.univ \ (sem A))
(conj_def :  ∀ A B : Assertion, sem (conj A B) =  (sem A) ∩ (sem B))
(disj_def :  ∀ A B : Assertion,  sem (disj A B) =  (sem A) ∪ (sem B))


notation `⦃` Φ `;;`Var `;;` A `⦄` := (AssertionLang.sem Φ Var _ _ _ A)

namespace AssertionLang 

variables {Φ Var : Type} [fintype Var] [decidable_eq Var] [AssertionLang Φ Var]

def Impl : Φ → Φ → Φ := λ P Q, AssertionLang.disj Var (AssertionLang.compl Var P) Q

lemma impl_def {P Q : Φ} {σ : Trace Var} : 
  σ ∈ (@AssertionLang.sem Φ Var _ _ _ (@Impl Φ Var _ _ _ P Q)) ↔ 
  σ ∈ (@AssertionLang.sem Φ Var _ _ _ P) → σ ∈ (@AssertionLang.sem Φ Var _ _ _ Q) := 
begin 
split,
intros h₁ h₂,
rw Impl at h₁,
simp at h₁,
rw disj_def at h₁,
cases h₁,
rw compl_def at h₁,
exfalso, exact set.not_mem_of_mem_diff h₁ h₂, assumption,

intros h,
rw Impl, rw disj_def, simp,
have : σ ∈  (@AssertionLang.sem Φ Var _ _ _ P) ∨ σ ∉  (@AssertionLang.sem Φ Var _ _ _ P), from or_not,
cases this,
right, apply h this,
left,rw compl_def,
exact set.mem_sep trivial this,
end 

end AssertionLang 




@[ext, derive decidable_eq]
structure Component (Var : Type) [fintype Var] [decidable_eq Var] := 
(ports : finset Var)




variables {Var : Type} [fintype Var] [decidable_eq Var]


@[reducible]
def Impl (Var : Type) [fintype Var] [decidable_eq Var] : Type := set (Trace Var)

@[reducible]
def Env (Var : Type) [fintype Var] [decidable_eq Var]: Type := set (Trace Var)

@[derive decidable_eq]
structure Contract (Φ : Type) (Var : Type) 
[fintype Var] [decidable_eq Var] [AssertionLang Φ Var] := 
(A : Φ)
(G : Φ)



variables {Φ : Type} [fintype Var] [decidable_eq Var] [AssertionLang Φ Var]

instance : inhabited (Contract Φ Var) := ⟨{A := ⊤ , G := ⊤}⟩ 

namespace Contract 
@[reducible]
def nf (C : Contract Φ Var) : Φ := AssertionLang.disj Var (AssertionLang.compl Var C.A) C.G 
end Contract 

theorem nf_def {C : Contract Φ Var} {x : Trace Var} : x ∈ (@AssertionLang.sem Φ Var _ _ _ C.nf) ↔ 
x ∈ (@AssertionLang.sem Φ Var _ _ _ C.A) → x ∈ (@AssertionLang.sem Φ Var _ _ _ C.G) := 
begin
rw AssertionLang.disj_def,
rw AssertionLang.compl_def,
rw imp_iff_not_or, simp,
end 

structure ComponentWithContract (Φ : Type) (Var : Type) 
[fintype Var] [decidable_eq Var] [AssertionLang Φ Var] 
extends Component Var := 
(C : Contract Φ Var)

instance : has_coe (ComponentWithContract Φ Var) (Component Var) := ⟨λ C, {..C}⟩ 

namespace Impl 

variables {S : Component Var}


def satisfiesContract (C : Contract Φ Var) : Impl Var → Prop := 
λ I, I ∩ (AssertionLang.sem C.A) ⊆ (AssertionLang.sem C.G)

end Impl

namespace Env 

variables {S : Component Var}


def satisfiesContract (C : Contract Φ Var) : Env Var → Prop := 
λ En, En ⊆ (AssertionLang.sem C.A)

end Env




@[reducible]
def ImplC (S : ComponentWithContract Φ Var) : Type := set (Trace Var)

@[reducible]
def EnvC (S : ComponentWithContract Φ Var) : Type := set (Trace Var)

namespace ImplC

variables {S : ComponentWithContract Φ Var}

def toSet : ImplC S → set (Trace Var) := id 

def satisfiesContract (C : Contract Φ Var) : ImplC S → Prop := 
λ I, (I.toSet) ∩ (AssertionLang.sem C.A) ⊆ (AssertionLang.sem C.G)

end ImplC

namespace EnvC 

variables {S : ComponentWithContract Φ Var}


@[reducible, simp]
def toSet  : EnvC S → set (Trace Var) := id 

instance : has_coe (set (Trace Var)) (EnvC S) := { coe := λ a, a}

def satisfiesContract (C : Contract Φ Var) : EnvC S → Prop := 
λ En, En.toSet ⊆ (AssertionLang.sem C.A)

end EnvC

namespace Contract 

variables {S : Component Var} (C : Contract Φ Var) 

def satisfyingImplentations : set (Impl Var) := 
{I | I.satisfiesContract C}

def satisfyingEnvironments : set (Env Var) := 
{E | E.satisfiesContract C}

end Contract 

@[derive decidable_eq]
structure Architecture (S : Component Var) := 
(subs : list (Component Var))
(delegation : list (Var × Var))


variables {S : Component Var} 

def Implementations (A : Architecture S) : Type := 
  Π (S' : Component Var) (h : S' ∈ A.subs), Impl Var


def CompositeImplementation 
(A : Architecture S)
(Impls : Implementations A) : Impl Var 
:= ⋂ (S' : Component Var) {S' ∈ A.subs} , Impls S' H

open list 
def CompositeEnvironment 
(A : Architecture S)
(U : Component Var) 
(Impls : Implementations A) 
(E : Env Var) : Env Var := 
E ∩ ⋂ (S' : Component Var) {S' ∈ A.subs.erase U}, Impls S' (mem_of_mem_erase H)

