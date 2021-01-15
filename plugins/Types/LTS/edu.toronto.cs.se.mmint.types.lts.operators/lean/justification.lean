import data.set

variables {α β: Type}

def Property (α : Type) : Type := α → Prop 

structure Claim (α : Type) :=
(X : set α)
(P : Property α)

def meaning {α : Type} (C : Claim α) : Prop := 
∀ x ∈ C.X, C.P x 

structure strategy (α : Type) : Type :=
(Parent : Claim α)
(Decomp : Claim α → list (Claim α))

def deductive (α : Type) (S : strategy α) : Prop := 
let subclaims := (S.Decomp) S.Parent in 
(∀ clm ∈ subclaims, meaning clm) → meaning S.Parent 

namespace property 

def decomposition 
(Ps : list (Property α)) 
(Clm : Claim α) : list (Claim α) := 
list.map (Claim.mk Clm.X) Ps

structure auxiliary (α : Type) :=
(Clm : Claim α)
(Props : list (Property α))


def justified
(Γ : auxiliary α) : Prop :=
let Xs : fin (Γ.Props.length) → set α := 
λ i, set_of ((Γ.Props.nth_le i.1 ) i.2) in
(⋂ i, Xs i) ⊆ {x | Γ.Clm.P x}


def to_strategy (Γ : auxiliary α) : strategy α := 
strategy.mk Γ.Clm 
  (property.decomposition Γ.Props)


theorem deductive_of_justfd
(Γ : auxiliary α) : 
justified Γ → deductive α (property.to_strategy Γ) :=  
begin 
  rw [justified,deductive, meaning,to_strategy], 
  simp only [fin.val_eq_coe],
  intros H1 H2 x xMem, apply H1,
  simp only [set.mem_Inter, set.mem_set_of_eq],
  intro i, 
  have len : Γ.Props.length = (decomposition Γ.Props Γ.Clm).length, by {rw decomposition, simp},
  replace H2 := H2 ((decomposition Γ.Props Γ.Clm).nth_le i.1 (fin.cast len i).2),
  unfold decomposition at H2,
  simp at H2, apply H2, 
  apply list.nth_le_mem, assumption,
end 


end property 


namespace domain 

def preimages {α β: Type} 
(f : α → β)
(n : ℕ)
(range_sets : fin n → (set β)) 
(Clm : Claim α)
: fin n → set α := 
λ (i : fin n), {x ∈ Clm.X | f x ∈ range_sets i}

def decomposition {α β: Type} 
(f : α → β)
(n : ℕ)
(range_sets : fin n → (set β)) 
(Clm : Claim α) : list (Claim α) :=
list.of_fn (λ i : fin n, Claim.mk (preimages f n range_sets Clm i)  (Clm.P))

structure auxiliary (α β : Type) :=
(Clm : Claim α)
(f : α → β)
(n : ℕ)
(range_sets : fin n → (set β))

def justified (Γ : auxiliary α β) : Prop := 
∀ x ∈ Γ.Clm.X, ∃ d : β, d = Γ.f x

def complete (Γ : auxiliary α β) : Prop := 
 (⋃ i, Γ.range_sets i) = set.univ


def to_strategy (Γ : auxiliary α β) : strategy α := 
strategy.mk (Γ.Clm) (domain.decomposition Γ.f Γ.n Γ.range_sets)

theorem deductive_of_justfd_comp (Γ : auxiliary α β) : justified Γ → complete Γ →  deductive α (to_strategy Γ) :=
begin 
  rw [justified, complete, deductive, meaning, to_strategy], 
  simp only [fin.val_eq_coe],
  intros H1 H2 H3 x xMem,
  unfold decomposition at H3,
  simp at H3,
  have H4 : ∃ j : fin Γ.n, Γ.f x ∈ Γ.range_sets j, from 
    begin
      refine set.mem_Union.mp _,
      rw H2, simp only [set.mem_univ],
    end,
  cases H4 with j H4,
  replace H3 := H3 j, 
  rw meaning at H3, simp at H3,
  apply H3, rw preimages, split, assumption, assumption,
end 

end domain
