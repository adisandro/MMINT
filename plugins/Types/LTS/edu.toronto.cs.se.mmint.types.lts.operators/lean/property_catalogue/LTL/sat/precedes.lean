import LTS property_catalogue.LTL.patterns tactic common_meta

open tactic

variable {M : LTS}

namespace precedes 

namespace globally


-- Proof 1 : Because S never happens 
lemma vacuous (P S : formula M) (π : path M) : 
 (sat (absent.globally S) π) → sat (precedes.globally P S) π 
:= λ s, or.inl s  

-- Proof 2 : P precedes S because S can't happen before P

local notation π `⊨ `P := sat P π 

variables (P Q R : formula M) (π : path M)

lemma by_absent_before (P Q : formula M) (π : path M) : 
 (π ⊨ absent.before Q P) ∧ (π ⊨ exist.globally P ) → 
 (π ⊨ precedes.globally P Q)  := 
begin 
 rintros ⟨H1,H2⟩,
 rw precedes.globally, 
 rw [absent.before, sat, imp_iff_not_or] at H1,
 cases H1,
 left, rw always_eventually_dual, contradiction,
 right, assumption,
end 

-- Proof 3 : P precedes R because P precedes Q and Q precedes R 


lemma by_transitive (P Q R : formula M) (π : path M) : 
    (π ⊨ precedes.globally P R) ∧ (π ⊨ precedes.globally R Q) → 
    (π ⊨ precedes.globally P Q) := 
begin
    rintros ⟨H1, H2⟩,
    cases H2, left, assumption,
    cases H1,
    cases H2 with k H2, replace H1 := (H1 k), replace H2:= H2.1, 
    have := sat_em R (π.drop k),replace this := this H2,
    contradiction,
    rcases H1 with ⟨k,Hk1,Hk2⟩,
    rcases H2 with ⟨w, Hw1, Hw2⟩,
    right, use k,
    split, assumption,
    intros i Hi, apply Hw2,
    have EM : (k < w) ∨ ¬ (k < w), from em (k < w),
    cases EM,
    apply lt_trans Hi, assumption,
    simp at EM,
     have EM2 : (k = w) ∨ ¬ (k = w), from em (k = w),
    cases EM2,
    rw ← EM2, assumption,
    have : w < k, by omega,
    replace Hk2 := Hk2 w this,
    have := sat_em R (π.drop w),replace this := this Hw1,
    contradiction,
end 

meta def solve_by_transitive (e₁ e₂ e₃ : expr) (s : string): tactic unit := 
do
  tactic.interactive.apply ``(by_transitive %%e₁  %%e₂  %%e₃) 
 -- e₁ ← tactic_format_expr e₁,
  --  e₂ ← tactic_format_expr e₂,
 --   e₃ ← tactic_format_expr e₃,

--  return $  s.append $
 -- "apply precedes.globally.by_transitive " ++ 
 --  e₁.to_string  ++ " " ++ e₂.to_string  ++ " " ++ e₃.to_string  ++ ",\n"

meta def solve_by_absent_before (e₁ e₂ : expr) (s : string) : 
tactic unit := 
do  
  tactic.interactive.apply ``(by_absent_before %%e₁ %%e₂)
--  e₁ ← e₁.log_format,
--  e₂ ← e₂.log_format,
--  s.log $ 
--  "apply precedes.globally.by_absent_before " ++ 
--  e₁ ++ " " ++ e₂ ++ ",\n"

meta def solve (e₁  e₂ : expr) (s : string) : list expr → tactic unit
| [] :=  return ()
| (h::t) := 
do typ ← infer_type h,
   match typ with 
   | `(sat (precedes.globally _ %%new) _) := 
       solve_by_transitive e₁ e₂ new s <|> solve t
   | `(sat (absent.before _ _) _) := 
      solve_by_absent_before e₁ e₂ s  <|> solve t 
   | _ := solve t 
end 

end globally

namespace before 

-- (◆R) ⇒ ((!P) U (S ⅋ R)) 

lemma vacuous (P R S: formula M) (π : path M) : 
  sat (absent.globally S) π → sat (precedes.before P R S) π := 
by {intro H, rw [precedes.before,sat,imp_iff_not_or, 
    ← always_eventually_dual], left, assumption}


lemma by_absent_before (P R S: formula M) (π : path M) : 
    sat (exist.globally (P ⅋ S)) π 
    ∧ sat (absent.before R (P ⅋ S)) π → sat (precedes.before P R S) π 
:= 
begin
    rintros ⟨L,R⟩,
    replace R := R L, 
    rw [precedes.before, sat, imp_iff_not_or], 
    exact or.inr R,
end 

end before 



namespace after
--  (◾!Q) ⅋ ◆(Q & ((!P) W S)) 

end after 


namespace between 
-- ◾((Q & (!R) & ◆R) ⇒ (!P U (S ⅋ R)))



end between 
end precedes 