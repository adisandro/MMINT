import LTS property_catalogue.LTL.patterns tactic common_meta

open tactic

variable {M : LTS}

namespace precedes 

namespace globally

-- precedes.globally P S 
-- i.e. if S happens, P must happen first 


-- Proof 1 : Because S never happens 
lemma vacuous (P S : formula M) (π : path M) : 
 (sat (absent.globally S) π) → sat (precedes.globally P S) π 
:= λ s, or.inl s  

-- Proof 2 : P precedes S because S can't happen before P

lemma by_absent_before (P S : formula M) (π : path M) : 
 (sat (absent.before S P) π) ∧ 
 (sat (exist.globally P) π)  → 
  sat (precedes.globally P S) π := 
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
    (sat (precedes.globally P Q) π ) ∧ 
    (sat (precedes.globally Q R) π) → 
    (sat (precedes.globally P R) π) := 
begin
    rintros ⟨H1, H2⟩,
    cases H2, left, assumption,
    cases H1,
    cases H2 with k H2, replace H1 := (H1 k), replace H2:= H2.1, 
    have := sat_em Q (π.drop k),replace this := this H2,
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
    have := sat_em Q (π.drop w),replace this := this Hw1,
    contradiction,
end 

meta def solve_by_transitive (tok1 tok2 tok3: expr) (str : string): tactic string := 
do
  tactic.interactive.apply ``(by_transitive %%tok1 _ %%tok2), 
  t1 ← tactic_format_expr tok1,
  t2 ← tactic_format_expr tok2,
  t3 ← tactic_format_expr tok3,
  new_str str $
  "apply precedes.globally.by_transitive " ++ 
  t1.to_string ++ " " ++ 
  t3.to_string ++ " " ++ 
  t2.to_string ++ ",\n"

meta def solve_by_absent_before (tok1 tok2 : expr) (str : string) : 
tactic string := 
do  
  tactic.interactive.apply ``(by_absent_before %%tok1 %%tok2),
  t1 ← tactic_format_expr tok1,
  t2 ← tactic_format_expr tok2,
  new_str str $ 
  "apply precedes.globally.by_absent_before " ++ 
  t1.to_string ++ " " ++ 
  t2.to_string ++ ",\n"

meta def solve (tok1 tok2 : expr) (str : string) : list expr → tactic string
| [] :=  return string.empty
| (h::t) := 
do typ ← infer_type h,
   match typ with 
   | `(sat (precedes.globally _ %%new) _) := 
       solve_by_transitive tok1 tok2 new str <|> solve t
   | `(sat (absent.before _ _) _) := 
      solve_by_absent_before tok1 tok2 str  <|> solve t 
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