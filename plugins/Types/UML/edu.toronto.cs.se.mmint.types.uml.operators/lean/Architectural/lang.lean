import Architectural.LACU

inductive LANG
| T : LANG
| atom : PORTS → LANG 
| lt : PORTS → PORTS → LANG 
| neg : LANG → LANG 
| conj : LANG → LANG → LANG
| disj : LANG → LANG → LANG
| always : LANG → LANG 

namespace LANG 

instance : has_top LANG := ⟨LANG.T⟩ 

@[simp]
def sem : LANG → set (Trace (PORTS))
| (LANG.atom x) := { σ | (σ 0) x ≠ 0 }
| (LANG.lt x v) := {σ  |  (σ 0) x < (σ 0) v}
| (LANG.neg A) := (set.univ) \ (sem A)
| (LANG.conj A B) := (sem A) ∩ (sem B)
| (LANG.disj A B) := (sem A) ∪ (sem B)
| (LANG.always A) := {σ | ∀ i, (σ.drop i) ∈ (sem A)}
| T := set.univ 

@[simp]
def compl_def : ∀ A : LANG, (sem (neg A)) = (set.univ) \ (sem A) := λ A, rfl 
@[simp]
def conj_def : ∀ A B : LANG,   (sem (conj A B)) =  (sem A) ∩ (sem B) := λ A B, rfl  

@[simp]
def disj_def : ∀ A B : LANG,   (sem (disj A B)) =  (sem A) ∪ (sem B) := λ A B , rfl  

@[simp] theorem disj_comm :  ∀ A B : LANG,  (sem (disj A B)) = sem (disj B A) := 
begin
  intros, rw sem, rw sem, rw set.union_comm, 
end 

@[simp]
def always_def : ∀ A : LANG, sem (A.always) =  {σ | ∀ i, (σ.drop i) ∈ (sem A)} := λ A, rfl  

@[reducible,simp]
def sub (x y : PORTS) : LANG → LANG
| (LANG.atom a) := if a = x then LANG.atom y else LANG.atom a
| (LANG.lt a v) := if a = x then LANG.lt y v else LANG.lt a v
| (LANG.neg A) := LANG.neg (sub A)
| (LANG.conj A B) := LANG.conj (sub A) (sub B)
| (LANG.disj A B) :=  LANG.disj (sub A) (sub B)
| (LANG.always A) :=  (LANG.always (sub A))
| T := ⊤


end LANG 


instance : AssertionLang LANG PORTS := 
{ sem := LANG.sem,
  T_def := by {unfold has_top.top, rw LANG.sem,},
  compl := LANG.neg,
  conj := LANG.conj,
  disj := LANG.disj,
  compl_def := LANG.compl_def,
  conj_def := LANG.conj_def,
  disj_def := LANG.disj_def, }


axiom synchronize {φ : LANG} {σ : Trace PORTS} : ∀ v1 v2 : PORTS, 
(v1,v2) ∈ LACU_ARCH_MODEL.delegation ∨ (v2,v1) ∈ LACU_ARCH_MODEL.delegation → 
σ ∈ (@AssertionLang.sem LANG PORTS _ _ _ φ) ↔ 
σ ∈ (@AssertionLang.sem LANG PORTS _ _ _ (φ.sub v1 v2))


theorem forall_conj_distrib : ∀ A B : LANG,   
(@AssertionLang.sem LANG PORTS _ _ _  (LANG.conj A B).always) = (@AssertionLang.sem LANG PORTS _ _ _  ((A.always).conj (B.always))) :=
begin 
  intros, unfold AssertionLang.sem, simp, rw set.inter_def, simp,
  ext, simp,
  rw forall_and_distrib,
end

theorem forall_conj_distrib_mem {x : Trace PORTS} : ∀ A B : LANG, x ∈ 
(@AssertionLang.sem LANG PORTS _ _ _ (LANG.conj A B).always) ↔ x ∈ (@AssertionLang.sem LANG PORTS _ _ _  ((A.always).conj (B.always))) :=
begin 
  intros, unfold AssertionLang.sem, split, simp, rintros a, split,
   intro i, apply (a i).1, intro i, apply (a i).2,
   simp, intros a b i, split, apply a i, apply b i,
end


theorem forall_conj_distrib' : ∀ A B : LANG,   
(LANG.sem  (LANG.conj A B).always) = (LANG.sem ((A.always).conj (B.always))) :=
begin 
  intros, simp, rw set.inter_def, simp,
  ext, simp,
  rw forall_and_distrib,
end

theorem forall_conj_distrib_mem' {x : Trace PORTS} : ∀ A B : LANG, x ∈ 
(LANG.sem (LANG.conj A B).always) ↔ x ∈ (LANG.sem ((A.always).conj (B.always))) :=
begin 
  intros, split, simp, rintros a, split,
   intro i, apply (a i).1, intro i, apply (a i).2,
   simp, intros a b i, split, apply a i, apply b i,
end