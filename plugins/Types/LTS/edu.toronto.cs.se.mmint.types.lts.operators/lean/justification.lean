import data.set tactic LTS

set_option pp.structure_instances false

def Property (α : Type) : Type := α → Prop 

  structure Claim (α : Type) :=
  (X : set α)
  (P : Property α)

  structure strategy (α : Type) := 
  (Clm : Claim α)
  (Props : list (Property α))

  def justified {α : Type}
  (S : strategy α) : Prop :=
  let Xs : fin (S.Props.length) → set α := 
  λ i, set_of ((S.Props.nth_le i.1) i.2) in
  (⋂ i, Xs i) ⊆ {x | S.Clm.P x}



@[reducible]
def property_Decomposition {α : Type} (S : strategy α) : list (Claim α) := 
list.map (Claim.mk S.Clm.X) S.Props



def meaning {α : Type} (C : Claim α) : Prop := 
∀ x ∈ C.X, C.P x 


@[reducible]
def decomp_meaning {α : Type} (l : list (Claim α )) : Prop := 
∀ (i : fin l.length), meaning (l.nth_le i.1 i.2)

def deductive (α : Type) (S : strategy α) : Prop := 
decomp_meaning (property_Decomposition S) → (meaning S.Clm)

theorem justfd_imp_deductive 
{α : Type} {S : strategy α}
 : justified S → deductive α S:= 
begin
    intros HJ H x xMem,
    rw decomp_meaning at H, rw justified at HJ, simp at HJ,
    apply HJ, simp only [set.mem_Inter],
    intro i,
    have len : S.Props.length  = (property_Decomposition S).length, by {rw property_Decomposition, simp},
    replace H := H (fin.cast len i),
    rw meaning at H, simp at H,
    apply H, repeat {assumption},
end 






















def contra (α : Type)
(S : strategy α ) : Prop := 
∀ x, 
¬(S.Clm.P x) → (∃ i : fin (S.Props.length), (S.Props.nth_le i.1 i.2) x)

def reverse_contra {α : Type} (S : strategy α) : Prop := 
∀ x, 
(∀ i : fin (S.Props.length), ¬(S.Props.nth_le i.1 i.2 x)) → (S.Clm.P x)

lemma contra_iff {α : Type} (S : strategy α) : contra α S ↔ reverse_contra S := 
begin
    split,
    
    rw [contra,reverse_contra], intros H1 x H2,
    contrapose H1,
    simp, use x, split, assumption, assumption,

    rw [contra,reverse_contra],intros H1 x H2,
    replace H1 := H1 x,
    contrapose H1, simp at *, split, assumption, assumption,
end 


@[simp]
def negate_strat {α : Type} (Str : strategy α) : strategy α := 
strategy.mk Str.Clm (Str.Props.map (λ P x, ¬P x))


--theorem contra_justfd {α : Type} (Str : strategy α ) : 
--contra α Str → justified (negate_strat Str) := 
--begin
--    rw [justified,contra], simp, intros H x,
--    replace H := H x, 
--    contrapose H,
--    simp at *,
--    split, exact H.2,
--    have len : (Str.Props.length) = (negate_strat Str).Props.length, by {simp},
--    intro i, apply H.1 (fin.cast len i),
--end 


/-
lemma double_neg_strat {α : Type} (Str : strategy α) : (negate_strat (negate_strat Str)) = Str := 
begin 
    rw negate_strat, dsimp,
    have : Π {P : Property α}, (λ x, ¬ (¬ (P x))) = (λ x, P x) := by {simp},
    simp,
    tidy,
    rw l2strat, cases Str,
    simp,
end 

theorem neg_contra_justfd {α : Type} (Str : strategy α ) : 
contra α (negate_strat Str) → justified (Str) := 
begin
    intros, 
    rw ← double_neg_strat Str,
    apply contra_justfd, assumption
end
-/
