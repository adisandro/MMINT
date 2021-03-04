import LTS property_catalogue.LTL.patterns tactic common_meta

open tactic

variable {M : LTS}

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

meta def solve_by_partition (tok1 tok2 : expr) (s : string) : tactic unit := 
do 
  tactic.interactive.apply ``(by_partition_before_aft %%tok1 %%tok2)
-- t1 ← tok1.log_format, t2 ← tok2.log_format,
--  s.log $ "apply by_partition_before_aft" ++ t1 ++ t2 ++ "\n"


meta def solve (tok : expr) (str : string) : list expr → tactic unit 
| [] :=  return ()
| (h::t) := 
   do typ ← infer_type h,
   match typ with 
   | `(sat (absent.before %%tok %%new) %%path):= solve_by_partition tok new str <|> solve t
   | `(sat (absent.after %%tok %%new) %%path) := solve_by_partition tok new str <|> solve t 
   | _ := do solve t 
   end 


end globally 
end absent 
