import Architectural.proofObligations
import lacu
import Architectural.lang
import tactic 
import system.io

open LANG PORTS tactic 
open io list lean.parser interactive.types

open lean.parser (ident)

local infix ` OR `:50 := LANG.disj 
local infix ` & `:50 := LANG.conj 

meta def set_goal (goal : expr) : tactic unit :=
do
   v <- mk_meta_var goal,
   set_goals (list.cons v list.nil),
   return ()


meta def is_solved : tactic bool :=
done >> return tt <|> return ff

meta def stringifyFmt :  format → tactic string := 
λ f, do return (format.to_string f)

meta def stringOfFormatExpr : expr → tactic string := 
λ e, do 
   fmt ← (tactic_format_expr e >>= stringifyFmt),
   return fmt


meta def read {α : Type}
(f : string)
(p : lean.parser α) : lean.parser α :=
do
  buf ← unsafe_run_io (io.fs.read_file f),
  (a, s) ← with_input p buf.to_string,
  return a



meta def solve_rpo_fst : tactic unit := do 
  x ← tactic.get_unused_name `x,
  H ← tactic.get_unused_name `H,
  tactic.intro x,
  `[simp],
  `[rw AssertionLang.impl_def],
  tactic.intro H,
  `[rw [list_conj_iff, get_nfs] at H, simp at H, rw toMap at H],
  `[rcases H with ⟨H1,H2,H3⟩],
  tactic.repeat `[rw Map.find_val at H1 H2 H3],
  `[have  distinct1 : armPosition ≠ LAAP, by {dec_trivial,},
  have  distinct2 : armPosition ≠ armController, by {dec_trivial},
  have  distinct3 : armController ≠ LAAP, by {dec_trivial},
  repeat {simp [distinct1, distinct2, distinct3] at *,},
  rw nf_def at *, intro A, simp at *,
  apply (@synchronize (atom fault_PWMFlow_LACU).neg.always x fault_PWMFlow_LACU fault_armFlow_armController).mpr,
  simp,
  apply H3, clear H3,
  rw @forall_conj_distrib_mem x _ _,split,
  rw @forall_conj_distrib_mem' x _ _,split,
  rw @forall_conj_distrib_mem' x _ _,split,
  apply (@synchronize (atom fault_angleSensor_armController).neg.always x fault_angleSensor_armController fault_output_armPosition ).mpr,
  simp,
  apply H1, clear H1,
  rw @forall_conj_distrib_mem x _ _ at A,
  cases A with A1 A2, clear A2,
  rw @forall_conj_distrib_mem' x _ _ at A1,
  cases A1 with A1 A3, clear A3,
  rw @forall_conj_distrib_mem' x _ _ at A1,
  cases A1 with A1 A2, clear A2,
  apply (@synchronize (((atom fault_input2_armPosition).neg OR (atom fault_input1_armPosition).neg).always) x fault_input1_armPosition fault_armPositionAngle1_LACU).mpr,
  apply (@synchronize (((atom fault_input2_armPosition).neg OR (atom fault_armPositionAngle1_LACU).neg).always) x fault_input2_armPosition fault_armPositionAngle2_LACU).mpr,
  simp,
  intros i,
  replace A1 := A1 i, rwa LANG.disj_comm at A1,
  unfold LACU_ARCH_MODEL, simp, unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
  unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
  apply ((@synchronize (atom fault_LAAPActive_armController).neg.always) x fault_LAAPActive_armController fault_LAAPActive_LAAP).mpr,
  simp,
  have : x ∈ AssertionLang.sem ((atom fault_LAAPFlow_LAAP).neg & (atom fault_LAAPActive_LAAP).neg).always → x ∈ ((atom fault_LAAPActive_LAAP).neg).always.sem,
   by {intro h, intro i,
    rw forall_conj_distrib_mem at h,
    cases h with h1 h2,
    apply h2 i,
        },
  apply this, clear this,
  apply H2, clear H2, clear H1,
  apply ((@synchronize ((atom fault_LAAPRequest_LAAP).neg & (atom fault_operatorControlLever_LAAP).neg).always) x fault_operatorControlLever_LAAP fault_operatorControlLever_LACU).mpr,
  simp,
  apply ((@synchronize ((atom fault_LAAPRequest_LAAP).neg & (atom fault_operatorControlLever_LACU).neg).always) x fault_LAAPRequest_LAAP fault_LAAPRequest_LACU).mpr,
  simp,

  rw @forall_conj_distrib_mem x _ _,
  rw @forall_conj_distrib_mem x _ _  at A,
  cases A with A1 A2,
  rw @forall_conj_distrib_mem' x _ _  at A1,
  cases A1 with A1 A3,
  rw @forall_conj_distrib_mem' x _ _  at A1,
  cases A1 with A1 A4,
  split,
  exact A4,
  exact A3,
    unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
    unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
    unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
  apply ((@synchronize (atom fault_LAAPFlow_armController).neg.always) x fault_LAAPFlow_armController fault_LAAPFlow_LAAP).mpr,
  simp,intro i,
  rw @forall_conj_distrib_mem x _ _  at H2,
 have : (x ∈ AssertionLang.sem ((atom fault_LAAPFlow_LAAP).neg & (atom fault_LAAPActive_LAAP).neg).always) → stream.drop i x ∈ (atom fault_LAAPFlow_LAAP).neg.sem,
 by { intros H', rw @forall_conj_distrib_mem x _ _  at H', 
 cases H' with H' H'',
 apply H' i,}, apply this, clear this, apply H2,
  rw @forall_conj_distrib_mem x _ _  at A,
  cases A with A1 A2,
  rw @forall_conj_distrib_mem' x _ _  at A1,
  cases A1 with A1 A3,
  rw @forall_conj_distrib_mem' x _ _  at A1,
  cases A1 with A1 A4,
  split,
  apply (@synchronize (atom fault_LAAPRequest_LAAP).neg.always x fault_LAAPRequest_LAAP fault_LAAPRequest_LACU).mpr,
  simp, apply A4,
    unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
apply (@synchronize (atom fault_operatorControlLever_LAAP).neg.always x fault_operatorControlLever_LAAP fault_operatorControlLever_LACU).mpr,
  simp, apply A3,
    unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
    unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
  rw @forall_conj_distrib_mem x _ _  at A,
  cases A with A1 A2,
  rw @forall_conj_distrib_mem' x _ _  at A1,
  cases A1 with A1 A3,
  rw @forall_conj_distrib_mem' x _ _  at A1,
  cases A1 with A1 A4,
  apply (@synchronize (atom fault_operatorControlLever_armController).neg.always x fault_operatorControlLever_armController fault_operatorControlLever_LACU).mpr,
  simp,
  intro i,
  apply A3 i,  unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
   unfold LACU_ARCH_MODEL, dsimp, dec_trivial],
  return ()

-- meta def get_comp_names : tactic (list (expr × expr)) := 
-- do 

-- meta def get_comp_names : tactic (list (expr × expr)) := 
-- do 


meta def tac1 : tactic unit := 
`[rw AssertionLang.impl_def,
intro Ha,
rw AssertionLang.conj_def at Ha,
cases Ha with Ha Hb,
rw list_conj_iff at Hb,
simp at Hb,
have Hb1 := Hb LAAP (by {rw H, simp,}),
have Hb2 := Hb armController (by {rw H, simp,}),
clear Hb,
simp at *,
rw Map.find_val at *,
rw Map.find_val at *,
rw Map.find_val at *,
simp at *,
rw H,
have  distinct1 : armPosition ≠ LAAP, by {dec_trivial,},
  have  distinct2 : armPosition ≠ armController, by {dec_trivial},
  have  distinct3 : armController ≠ LAAP, by {dec_trivial},
  repeat {simp [distinct1, distinct2, distinct3] at *,}]

meta def tac2 : tactic unit := 
`[rw AssertionLang.impl_def,
intro Ha,
rw AssertionLang.conj_def at Ha,
cases Ha with Ha Hb,
rw list_conj_iff at Hb,
simp at Hb,
have Hb1 := Hb armController (by {rw H, dec_trivial,}),
have Hb2 := Hb armPosition (by {rw H, dec_trivial,}),
clear Hb,
simp at *,
rw Map.find_val at *,
rw Map.find_val at *,
rw Map.find_val at *,
have  distinct1 : armPosition ≠ LAAP, by {dec_trivial,},
  have  distinct2 : armPosition ≠ armController, by {dec_trivial},
  have  distinct3 : armController ≠ LAAP, by {dec_trivial},
  repeat {simp [distinct1, distinct2, distinct3] at *,}]

meta def tac3 : tactic unit := 
`[rw AssertionLang.impl_def,
intro Ha,
rw AssertionLang.conj_def at Ha,
cases Ha with Ha Hb,
rw list_conj_iff at Hb,
simp at Hb,
have Hb1 := Hb LAAP (by {rw H, dec_trivial,}),
have Hb2 := Hb armPosition (by {rw H, dec_trivial,}),
clear Hb,
simp at *,
rw Map.find_val at *,
rw Map.find_val at *,
rw Map.find_val at *,
have  distinct1 : armPosition ≠ LAAP, by {dec_trivial,},
  have  distinct2 : armPosition ≠ armController, by {dec_trivial},
  have  distinct3 : armController ≠ LAAP, by {dec_trivial},
  repeat {simp [distinct1, distinct2, distinct3] at *,}]





meta def solve_rpo_snd : tactic unit := do 
`[rw RPO_snd,
intros S H s,
simp at *,
cases H, 
work_on_goal 0 { tac1, 
  rw @forall_conj_distrib_mem s _ _  at Ha,
  cases Ha with Ha Ha2,
  rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha3,
   rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha4,
  intro i, 
  apply (@synchronize (((atom fault_input2_armPosition).neg OR (atom fault_input1_armPosition).neg).always) s fault_input1_armPosition fault_armPositionAngle1_LACU).mpr,
  apply (@synchronize (((atom fault_input2_armPosition).neg OR (atom fault_armPositionAngle1_LACU).neg).always) s fault_input2_armPosition fault_armPositionAngle2_LACU).mpr,
  simp,
  intro i,
  replace Ha := Ha i, rwa LANG.disj_comm at Ha,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,

  }, 

cases H, tac2, rw H,
  have  distinct1 : armPosition ≠ LAAP, by {dec_trivial,},
  have  distinct2 : armPosition ≠ armController, by {dec_trivial},
  have  distinct3 : armController ≠ LAAP, by {dec_trivial},
  repeat {simp [distinct1, distinct2, distinct3] at *,},
  rw @forall_conj_distrib_mem s _ _  at Ha,
  cases Ha with Ha Ha2,
  rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha3,
   rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha4,
  rw @forall_conj_distrib_mem s _ _ ,
  split,
  apply (@synchronize (atom fault_LAAPRequest_LAAP).neg.always s fault_LAAPRequest_LAAP fault_LAAPRequest_LACU).mpr,
  simp, exact Ha4,
  unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
apply (@synchronize (atom fault_operatorControlLever_LAAP).neg.always s fault_operatorControlLever_LAAP fault_operatorControlLever_LACU).mpr,
simp, assumption,   unfold LACU_ARCH_MODEL, dsimp, dec_trivial,

tac3,
rw H, 
  have  distinct1 : armPosition ≠ LAAP, by {dec_trivial,},
  have  distinct2 : armPosition ≠ armController, by {dec_trivial},
  have  distinct3 : armController ≠ LAAP, by {dec_trivial},
  repeat {simp [distinct1, distinct2, distinct3] at *,},
  rw @forall_conj_distrib_mem s _ _ ,
  split,
  rw @forall_conj_distrib_mem' s _ _ ,
  split,
  rw @forall_conj_distrib_mem' s _ _ ,
  split,
  apply (@synchronize (atom fault_angleSensor_armController).neg.always s fault_angleSensor_armController fault_output_armPosition ).mpr,
  simp,
  rw nf_def at Hb2,
  simp at Hb2, apply Hb2,
 rw @forall_conj_distrib_mem s _ _  at Ha,
  cases Ha with Ha Ha2,
  rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha3,
   rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha4,
  intro i, 
  apply (@synchronize (((atom fault_input2_armPosition).neg OR (atom fault_input1_armPosition).neg).always) s fault_input1_armPosition fault_armPositionAngle1_LACU).mpr,
  apply (@synchronize (((atom fault_input2_armPosition).neg OR (atom fault_armPositionAngle1_LACU).neg).always) s fault_input2_armPosition fault_armPositionAngle2_LACU).mpr,
  simp,
  intro i,
  replace Ha := Ha i, rwa LANG.disj_comm at Ha,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
  apply ((@synchronize (atom fault_LAAPActive_armController).neg.always) s fault_LAAPActive_armController fault_LAAPActive_LAAP).mpr,
  simp, rw nf_def at Hb1,
  simp at Hb1,
  intro i,
   have : (s ∈ AssertionLang.sem ((atom  fault_LAAPFlow_LAAP).neg & (atom fault_LAAPActive_LAAP).neg ).always) → stream.drop i s ∈ (atom fault_LAAPActive_LAAP).neg.sem,
  by { intros H', rw @forall_conj_distrib_mem s _ _  at H', 
 cases H' with H' H'',
 apply H'' i,}, apply this,clear this, 
 apply Hb1,
 rw @forall_conj_distrib_mem s _ _  at Ha,
  cases Ha with Ha Ha2,
  rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha3,
   rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha4,
  apply ((@synchronize ((atom fault_LAAPRequest_LAAP).neg & (atom fault_operatorControlLever_LAAP).neg).always) s fault_operatorControlLever_LAAP fault_operatorControlLever_LACU).mpr,
  simp,
  apply ((@synchronize ((atom fault_LAAPRequest_LAAP).neg & (atom fault_operatorControlLever_LACU).neg).always) s fault_LAAPRequest_LAAP fault_LAAPRequest_LACU).mpr,
  simp,
  intro i, split, apply Ha4 i,
  apply Ha3 i,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      
rw nf_def at Hb1,
  simp at Hb1,

apply ((@synchronize (atom fault_LAAPFlow_armController).neg.always) s fault_LAAPFlow_armController fault_LAAPFlow_LAAP).mpr,
simp,
intro i,
have : (s ∈ AssertionLang.sem ((atom  fault_LAAPFlow_LAAP).neg & (atom fault_LAAPActive_LAAP).neg ).always) → stream.drop i s ∈ (atom fault_LAAPFlow_LAAP).neg.sem,
  by { intros H', rw @forall_conj_distrib_mem s _ _  at H', cases H' with H' H'', apply H' i,},
apply this,
apply Hb1,
 rw @forall_conj_distrib_mem s _ _  at Ha,
  cases Ha with Ha Ha2,
  rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha3,
   rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha4,
  apply ((@synchronize ((atom fault_LAAPRequest_LAAP).neg & (atom fault_operatorControlLever_LAAP).neg).always) s fault_operatorControlLever_LAAP fault_operatorControlLever_LACU).mpr,
  simp,
  apply ((@synchronize ((atom fault_LAAPRequest_LAAP).neg & (atom fault_operatorControlLever_LACU).neg).always) s fault_LAAPRequest_LAAP fault_LAAPRequest_LACU).mpr,
  simp,
  intro i,
  split, apply Ha4 i, apply Ha3 i,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial,



 rw @forall_conj_distrib_mem s _ _  at Ha,
  cases Ha with Ha Ha2,
  rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha3,
   rw @forall_conj_distrib_mem' s _ _  at Ha,
  cases Ha with Ha Ha4,
  apply (@synchronize (atom fault_operatorControlLever_armController).neg.always s fault_operatorControlLever_armController fault_operatorControlLever_LACU).mpr,
 simp,
      apply Ha3,
      unfold LACU_ARCH_MODEL, dsimp, dec_trivial]


meta def solve_rpo : tactic unit := do 
`[split], solve_rpo_fst, solve_rpo_snd


example : RPO
    {ArchitectureWithContracts .
     to_Architecture := LACU_ARCH_MODEL,
     parent := {Contract .
                A := ((atom fault_armPositionAngle1_LACU).neg OR(atom fault_armPositionAngle2_LACU).neg&(atom
                               fault_LAAPRequest_LACU).neg&(atom fault_operatorControlLever_LACU).neg&(atom
                           fault_groundSpeed_LACU).neg).always,
                G := (atom fault_PWMFlow_LACU).neg.always},
     contracts := toMap
                    [(armPosition,
                       {Contract .
                        A := ((atom fault_input2_armPosition).neg OR(atom fault_input1_armPosition).neg).always,
                        G := (atom fault_output_armPosition).neg.always}), (armController,
                       {Contract .
                        A := ((atom fault_angleSensor_armController).neg&(atom fault_LAAPActive_armController).neg&(atom
                                     fault_LAAPFlow_armController).neg&(atom
                                   fault_operatorControlLever_armController).neg).always,
                        G := (atom fault_armFlow_armController).neg.always}), (LAAP,
                       {Contract .
                        A := ((atom fault_LAAPRequest_LAAP).neg&(atom fault_operatorControlLever_LAAP).neg).always,
                        G := ((atom fault_LAAPFlow_LAAP).neg&(atom fault_LAAPActive_LAAP).neg).always})],
     all_components := by {unfold LACU_ARCH_MODEL, auto_all_comps,}}:= 
begin 
solve_rpo,
end 