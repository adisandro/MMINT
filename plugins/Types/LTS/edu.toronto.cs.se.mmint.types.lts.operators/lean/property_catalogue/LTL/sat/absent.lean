import LTS.defs property_catalogue.LTL.patterns tactic proof_state

open tactic

variable {M : LTS}
variable {α : Type}

namespace absent
namespace globally 

lemma by_partition_before_aft {π : path M} (P S : formula M) : 
    (sat (exist.globally S) π ) → (sat (absent.before P S) π) → (sat (absent.after P S) π) → (sat (absent.globally P) π) :=
begin
    intros H1 H2 H3,
    rw absent.globally, rw sat,
    rw exist.globally at H1, rw sat at H1,
    rw absent.before at H2, iterate 3 {rw sat at H2},
    rw absent.after at H3, iterate 3 {rw sat at H3},
    simp at *,
    cases H1 with k H1,
    intro i,
    replace H2 := H2 k,
    replace H2 := H2 H1,
    cases H2 with w H2,
    have EM : (i < w) ∨ ¬ (i < w), from em (i<w),
    cases EM,
    apply H2.2,
    assumption,
    simp at EM,
    replace H3 := H3 w,
    cases H2 with L R,
    replace H3 := H3 L,
    have : ∃ j, i = w + j, from le_iff_exists_add.mp EM,
    cases this with j H4, rw H4,
    replace H3 := H3 j,
    rw path.drop_drop at H3,
    assumption,
end 

meta def solve_by_partition (tok1 tok2 : expr) (ps : proofState α ): tactic (proofState α) := 
do 
  tactic.interactive.apply ``(by_partition_before_aft %%tok1 %%tok2),
  return ps 
-- t1 ← tok1.log_format, t2 ← tok2.log_format,
--  s.log $ "apply by_partition_before_aft" ++ t1 ++ t2 ++ "\n"


meta def solve (tok : expr) (ps : proofState α) : list expr → tactic (proofState α)
| [] :=  return ps
| (h::t) := 
   do typ ← infer_type h,
   match typ with 
   | `(sat (absent.before %%tok %%new) %%path):= 
   do {ps ←  solve_by_partition tok new ps, return ps }<|> solve t
   | `(sat (absent.after %%tok %%new) %%path) := 
   do {ps ← solve_by_partition tok new ps, return ps }<|> solve t 
   | _ := do solve t 
   end 


end globally 


namespace between



theorem absent_between_response {M : LTS} {p : path M} { B I C : formula M} ( A : formula M) : 
(sat (responds.globally  (C) (A) ) p) ∧ 
(sat (absent.between (B) (C) (A)) p) ∧  
(sat (absent.between (B) (A) (I)) p)→ (sat (absent.between (B) (C) (I)) p) := 
begin rintros ⟨ H1, H2, H3⟩,
intro i,
replace H1 := H1 i,
intro Hcond, cases Hcond with L R,
replace H1 := H1 L,
rw absent.between at H2,
have : ((p.drop i) ⊨ (C &  ◆A)), by {rw sat, split,assumption,assumption},
replace H2 := H2 (i) this,
cases H1 with w Hw,
cases R with k Hk,
clear this,
cases H2 with z Hz,
cases Hz with z1 z2,
have : k < z ∨ ¬ (k < z), from or_not,
cases this, 
use k,
split, assumption,
intros j Hj,
have fact : j < z, by omega,
replace z2 := z2 j fact, assumption,
simp at this,
have EM : z = k ∨ z < k, by omega,
clear this,
cases EM, use k,
split, assumption, rw ← EM, assumption,
replace H3 := H3 (i+z),
rw ← path.drop_drop at H3,
have help : (((p.drop i).drop z) ⊨ ◆(I)), by {use (k-z),
rw path.drop_drop, rw path.drop_drop,have : i + (z + (k - z)) = i+k, by omega, rw this, rw ← path.drop_drop, assumption,},
have : ( ((p.drop i).drop z) ⊨  (A &  ◆I)), by {rw sat, split, assumption, assumption,},
clear help, replace H3 := H3 this,
cases H3 with t Ht,
clear this,
cases Ht with Ht Ht',
rw path.drop_drop at *,
use (z+t),split,
assumption,
intros j Hj,
have : j < z ∨ ¬ (j < z), from or_not,
cases this, replace z2 := z2 j this,
assumption,
simp at this,
have EM' : z = j ∨ z < j, by omega,
cases EM', rw EM' at Hj,
replace Ht' := Ht' 0 _,
rw path.drop_drop at Ht',
rw← EM',
simp at Ht', rw path.drop_drop,assumption,
omega,
clear this,
replace Ht' := Ht' (j-z),
rw path.drop_drop at Ht',
have : (i + z + (j - z)) = (i + j), by omega,
rw this at Ht',
rw path.drop_drop,
 apply Ht', omega,
end 



theorem foo {M : LTS} {P Q R : formula M} {x : path M} : (x ⊨ R ⇒ (P W Q)) ↔ (x ⊨ R ⇒ (P U Q)) ∨ (x ⊨ R ⇒ ◾ P) := 
begin 
split,
intro H,
rw sat at H,
rw sat.weak_until at H,
rw imp_or_distrib at H,
cases H,
right, assumption,
left, assumption,
intro H,
rw sat,
rw sat.weak_until,
cases H,
intro Hr, replace H := H Hr,
right, assumption,
intro Hr, replace H := H Hr,left, assumption,
end 

theorem absent_after_between_response {M : LTS} {p : path M} { B I C : formula M} ( A : formula M) : 
(sat (responds.globally  (C) (A) ) p) ∧ 
(sat (absent.between (B) (C) (A)) p) ∧  
(sat (absent.after_until (B) (A) (I)) p)→ (sat (absent.after_until (B) (C) (I)) p) := 
begin
  rintros ⟨H1, H2, H3⟩,
  rw after_until, 
  intro i,
  rw foo, 
  left,
  apply absent_between_response A,split,assumption,
  split,assumption,
  clear H2, clear H1,clear i,
  rw after_until at H3,
  rw between,
  intros i H,
  replace H3 := H3 i H,
  cases H with L R,
  cases H3,
  cases R with w Hw, use w, split, assumption,
  intros i _,
  replace H3 := H3 i, assumption, assumption, 
end 






meta def solve_by_absent_between_response (A : expr) (ps : proofState α): tactic (proofState α) := 
do 
  tactic.interactive.apply ``(absent_between_response %%A),
  repeat1 (applyc `and.intro), `[repeat {assumption}],
  return ps 

meta def solve  (ps : proofState α) : list expr → tactic (proofState α) 
| [] :=  return ps
| (h::t) := 
   do typ ← infer_type h,
   match typ with 
   | `(sat (responds.globally %%C %%A) _):=
    do {ps ← solve_by_absent_between_response A ps, return ps} <|> solve t
   | _ := do solve t 
   end 



end between 


namespace after_until


theorem from_absent_between_response {M : LTS} {p : path M} { B I C : formula M} ( A : formula M) : 
(sat (responds.globally  (C) (A) ) p) ∧ 
(sat (absent.between (B) (C) (A)) p) ∧  
(sat (absent.after_until (B) (A) (I)) p)→ (sat (absent.after_until (B) (C) (I)) p) := 
begin
  rintros ⟨H1, H2, H3⟩,
  rw after_until, 
  intro i,
  rw between.foo, 
  left,
  apply between.absent_between_response A,split,assumption,
  split,assumption,
  clear H2, clear H1,clear i,
  rw after_until at H3,
  rw between,
  intros i H,
  replace H3 := H3 i H,
  cases H with L R,
  cases H3,
  cases R with w Hw, use w, split, assumption,
  intros i _,
  replace H3 := H3 i, assumption, assumption, 
end 


meta def solve_by_absent_between_response (A : expr) (ps : proofState α): tactic (proofState α) := 
do 
  tactic.interactive.apply ``(from_absent_between_response %%A),
  ps ← ps.log "apply absent.after_until.from_absent_between_response",
  let ps := {used := ps.used ++ ["apply absent.after_until.from_absent_between_response"], ..ps},
  repeat1 (applyc `and.intro), `[repeat {assumption}],
  ps ← ps.log "match_premises",
  return {used := ps.used ++ ["match_premises"], ..ps}

meta def solve  (ps : proofState α) : list expr → tactic (proofState α) 
| [] :=  return ps
| (h::t) := 
   do typ ← infer_type h,
   match typ with 
   | `(sat (responds.globally %%C %%A) _):=
     do {ps ← solve_by_absent_between_response A ps, return ps} <|> solve t
   | _ := do solve t 
   end 


end after_until 

end absent 


