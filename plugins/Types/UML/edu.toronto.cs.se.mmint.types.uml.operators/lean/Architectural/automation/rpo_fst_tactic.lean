import Architectural.proofObligations
import Architectural.lang
import Architectural.Architecture
import Architectural.automation.util
import Architectural.ArchWithContracts
import tactic 

open LANG PORTS tactic 

local infix ` OR `:50 := LANG.disj 
local infix ` & `:50 := LANG.conj 
variables {Var : Type} [fintype Var] [decidable_eq Var] [Var]
variable [has_reflect Var]

theorem unpack_lang (x : Trace PORTS) {A : LANG} : x ∈ (@AssertionLang.sem LANG PORTS _ _ _ A) ↔ x ∈ LANG.sem A := by {refl,}

theorem lang_conj_always_distrib (x : Trace PORTS) (A B : LANG) : x ∈ LANG.sem (A & B).always ↔ x ∈ LANG.sem (A).always ∧ x ∈ LANG.sem (B).always := 
begin
simp, rw forall_and_distrib, 
end 

theorem disj_comm_guarded (x : Trace PORTS) (A B : LANG) : x ∈ LANG.sem (A OR B).always ↔ x ∈ LANG.sem (B OR A).always := 
begin
simp,
end 
theorem conj_comm_guarded (x : Trace PORTS) (A B : LANG) : x ∈ LANG.sem (A & B).always ↔ x ∈ LANG.sem (B & A).always := 
begin
split, all_goals {intros h i, replace h := h i, cases h, split, assumption, assumption,},
end 

theorem unpack_lang_conj_always {x : Trace PORTS} (A B : LANG) : x ∈ LANG.sem (A & B) ↔ x ∈ LANG.sem A ∧ x ∈ LANG.sem B := 
begin
rw conj_def, simp, 
end 

theorem double_conj_unpack {x : Trace PORTS} (A B C D : LANG) : 
                            x ∈ LANG.sem ((A & B & C).always & D.always) 
              ↔  
                            x ∈ LANG.sem (((A & B).always &C.always) & D.always)  := 
begin 
repeat {rw unpack_lang_conj_always,  rw unpack_lang_conj_always,},
split,finish,
rw lang_conj_always_distrib,
rw lang_conj_always_distrib,
finish,
end 

theorem portation_left {x : Trace PORTS} (A B : LANG) : (x ∈ @AssertionLang.sem LANG PORTS _ _ _ (A & B).always) → x ∈ (A).always.sem := 
begin 
intro h, intro i, rw forall_conj_distrib_mem at h, cases h with h1 h2, apply h1 i,
end 

theorem portation_right {x : Trace PORTS} (A B : LANG) : (x ∈ @AssertionLang.sem LANG PORTS _ _ _ (A & B).always) → x ∈ (B).always.sem := 
begin 
intro h, intro i, rw forall_conj_distrib_mem at h, cases h with h1 h2, apply h2 i,
end 


------



meta def preprocess_rpo_fst : tactic (name × name) := do 
  x ← tactic.get_unused_name `x,
  H ← tactic.get_unused_name `H,
  tactic.intro x,
  `[simp],
  `[rw AssertionLang.impl_def],
  tactic.intro H,
  `[rw [list_conj_iff, get_nfs] at H, simp at H, rw toMap at H],
  return ⟨x, H⟩


meta def decompose_conj : expr →  expr → tactic (unit)
| h `(and %%left %%right) := do 
    left_nm ← get_unused_name,
    right_nm ← get_unused_name,
    cases_core h [left_nm, right_nm] transparency.semireducible,
    right_e ← get_local right_nm,
    decompose_conj right_e right
| _ _ := do return ()

meta def decompose_conj_left : expr →  expr → tactic (unit)
| h `(and %%left %%right) := do 
    left_nm ← get_unused_name,
    right_nm ← get_unused_name,
    cases_core h [left_nm, right_nm] transparency.semireducible,
    left_e ← get_local left_nm,
    decompose_conj left_e left
| _ _ := do return ()




meta def collect_assertions : list expr → tactic (list expr) 
| (h::t ) := do 
  τ ← infer_type h,
  match τ with 
  | `(_ ∈ _) := do 
                l ← collect_assertions t,
                return $ [h]++l
  | `(_ ∈ _ → _) := do 
                l ← collect_assertions t,
                return $ [h]++l
  | _ := collect_assertions t
  end 
| [] := return []


theorem  IFf_pos (c : Prop) (H : decidable c) : ∀ {α : Type} {t e  :α}, c → ite c t e = t := by {intros a b c h, apply if_pos h,}
theorem  IFf_neg  : Π (c : Prop) [H : decidable c], ∀ {α : Type} {t e  :α}, ¬c → (@ite _ c H t e) = e := by {intros a b c h a f, apply if_neg, exact f}


meta def get_conds_aux : expr → tactic (list expr)
| `(@ite %%A %%B %%C %%D %%E) := do 
        let cond := [B],
        r ← get_conds_aux E,
        return $ cond ++ r
| _ := return []



meta def get_conds : expr → tactic (list expr)
| `(%%x ∈ AssertionLang.sem (%%E)) :=
  match E with 
    | `(Contract.nf (option.iget %%Y)) := get_conds_aux Y
    | `(Contract.A (option.iget %%Y)) := get_conds_aux Y
    | _ := return []
  end 
| `(_ → %%x ∈ AssertionLang.sem (%%E)) :=
  match E with 
    | `(Contract.nf (option.iget %%Y)) := get_conds_aux Y
    | _ := return []
  end 
| x :=  return []

meta def get_conds_expr : list expr → tactic (list (list expr))
| (h::t) := do 
    l← get_conds h, t ← get_conds_expr t, return (l::t)
| _ := do return []


meta def take_equals : list expr → list (expr × bool) 
| [] :=  []
| (h::t) := match h with 
           | `(eq %%A %%B) := 
              if B = A then  ([(h,tt)]++(take_equals t)) else ([(h,ff)]++(take_equals t))
           | _ :=  []
          end 

-- 
-- 
-- 
-- 
meta def sjdioaf (hyp : expr) : list (expr × bool) → tactic unit
| [] := return ()
| ((e, b)::t) := do 
                  if b then do 
                  let ef := expr.mk_app `(IFf_pos) [e],
                  rewrite_hyp ef hyp, return  () 
                  else do 
                  sjdioaf t

-- 
-- 
-- 
-- 
meta def suihfa : list (expr × list (expr × bool)) → tactic unit
| [] := return ()
| ((e, l)::xs) := do a ← sjdioaf e l,
                  suihfa xs
-- 
-- 
-- 
-- 
meta def extract_contracts : expr →  tactic unit := λ h, do 
  infer_type h >>= decompose_conj h, dedup,
  tactic.repeat `[rw Map.find_val at *],
  xs ← local_context >>= collect_assertions,
  l ← xs.mmap infer_type >>= get_conds_expr,
  let ls := xs.zip (l.map take_equals),
  suihfa ls,
  iterate `[rw if_neg at *],
  any_goals `[dec_trivial],
  `[rw nf_def at *, simp at *], 
  return ()


meta def collect_consequents : list (expr × expr) → (list (expr × expr)) 
| []   := []
| ((h, τ)::t) := match τ with 
                | `(%%P → %%Q) := (collect_consequents t).cons (h,Q) 
                | _ := collect_consequents t
                end 

meta def collect_vars_aux : expr → list expr 
| `(LANG.atom %%a) := [a]
| `(LANG.lt %%a %%v) := [a,v]
| `(LANG.neg %%A) := collect_vars_aux A
| `(LANG.conj %%A %%B) := collect_vars_aux A ++ collect_vars_aux B
| `(LANG.disj %%A %%B) := collect_vars_aux A ++ collect_vars_aux B
| `(LANG.always %%A) := collect_vars_aux A
|_ := []

meta def collect_vars : expr → list expr 
| `(_ ∈ AssertionLang.sem %%P) := collect_vars_aux P 
| _ := []

meta def find_matches_aux : expr → list (expr × expr) → list (expr × expr) 
| h ((a,b)::l) := if h=a then [(b,h)] else if h=b then [(a,h)]else (find_matches_aux h l)
| _ _ := []

meta def find_matches (del : list (expr × expr))  : list expr → list (expr × expr) 
| [] := []
| (h::t) := find_matches_aux h del++(find_matches t )
-- find_matches_aux es del 


open tactic.interactive («have»)

meta def mk_sync_apply (x : expr) : (expr × expr) →  tactic unit 
| (a,b) := do 
 -- ((synchronize' x fault_PWMFlow_LACU fault_armFlow_armController) (atom fault_PWMFlow_LACU).neg.always).mpr
 `(_ ∈ AssertionLang.sem %%FOO) ← target,
 let e := expr.mk_app `(synchronize') [x, b, a, FOO],
--  tactic.trace e,
 τ ← infer_type e,
 match τ with 
 | `(%%GOAL → %%FOO) := do 
   h ← get_unused_name `h,
   «have» h ``(%%GOAL) ``(by dec_trivial),
   h_e ← get_local h,
   let e' := expr.mk_app e [h_e],
    τ ← infer_type e',
   match τ  with 
   | `(%%l ↔ %%r) := do 
   let e'' := `(@iff.mpr %%l %%r %%e'),
   apply e'',
   `[simp],
   clear h_e,
   return ()
   | _ :=  return ()
   end 
 | _ := return ()
 end 

meta def try_application : list expr → tactic unit 
| [] := return ()
| (h::t) :=  (do apply h, return ()) <|> try_application t


meta def synchronize_ports (x : name) (Γ : model_info): tactic unit := do 
  tgt ← target, 
  let cs := collect_vars tgt,
  let ls := find_matches Γ.del cs, -- vars to sub will be on LEFT
  x ← get_local x,
  ls.mmap (mk_sync_apply x),
  return ()

meta def decompose_env_assumptions (x_nm : name) : tactic unit := do
  A ← get_unused_name `A,
  intro A,
  A_e ← get_local A, x ← get_local x_nm,
  let e := expr.mk_app `(unpack_lang) [x],
  tactic.rewrite_hyp e A_e,
  let e' := expr.mk_app `(lang_conj_always_distrib) [x],
  tactic.repeat (do A_e ← get_local A,tactic.rewrite_hyp e' A_e, return ()),
  A_e ← get_local A,
  tactic.repeat (do A_e ← get_local A, cases_core A_e [A] transparency.semireducible, return ()),
  return ()

meta def try_rewrites : expr → tactic unit  
| `(_ ∈ AssertionLang.sem _) := do `[rw unpack_lang],  tactic.repeat (`[rw lang_conj_always_distrib]), return ()
| _ := do tactic.repeat (`[rw lang_conj_always_distrib]), return ()


meta def check_for_portation_aux (e : expr) : list expr → tactic unit 
| (h::t) := match h with 
            | `(_ → (_ ∈ AssertionLang.sem (%%A & %%B).always)) := 
              if A = e then do `[apply portation_left], return () 
              else if B = e then do `[apply portation_right], return ()
              else check_for_portation_aux t
            | _ := check_for_portation_aux t
            end 
| [] := return ()

meta def check_for_portation_aux' (e : expr) : list expr → tactic unit 
| (h::t) := match h with 
            | `(_ → _ → (_ ∈ AssertionLang.sem (%%A & %%B).always)) := 
              if A = e then do `[apply portation_left], return () 
              else if B = e then do `[apply portation_right], return ()
              else check_for_portation_aux' t
            | _ := check_for_portation_aux' t
            end 
| [] := return ()

meta def check_for_portation : tactic unit := do 
`(_ ∈ LANG.sem (LANG.always %%FOO)) ← target,
local_context >>= (list.mmap infer_type) >>= check_for_portation_aux FOO

meta def check_for_portation' : tactic unit := do 
`(_ ∈ LANG.sem (LANG.always %%FOO)) ← target,
local_context >>= (list.mmap infer_type) >>= check_for_portation_aux' FOO

meta def find_assumption : list expr → tactic bool 
| [] := return ff 
| (h::t) := do apply h >> return tt <|> find_assumption t 

meta def try_terminal_rws : tactic unit := do 
 `[rwa disj_comm_guarded] <|> `[rwa conj_comm_guarded] <|> failure

meta def core_rpo_loop (x : name) (Γ : model_info) : tactic unit := do 
try check_for_portation,
local_context >>= try_application,
return ()

-- synchronize_ports x Γ, 
-- target >>= try_rewrites,
-- b ← local_context >>= find_assumption,
-- if !b then try_terminal_rws else return ()

meta def solve_rpo_fst (Γ : model_info) : tactic unit := do 
  ⟨x, H⟩ ← preprocess_rpo_fst,
  get_local H >>= extract_contracts,
  decompose_env_assumptions x,
  synchronize_ports x Γ,
  local_context >>= try_application,
  synchronize_ports x Γ,
  target >>= try_rewrites,
  repeat `[split],
  all_goals $ core_rpo_loop x Γ,
  all_goals $ try (do synchronize_ports x Γ, try `[rw unpack_lang], try `[rw lang_conj_always_distrib], 
                     try_terminal_rws <|> (do repeat `[split], repeat `[assumption])), 
  return ()

meta def make_cases (H : name) : tactic unit := do 
  H_e ← get_local H,
  τ ← infer_type H_e,
  match τ with 
  |`(or _ _) := do cases_core H_e [] transparency.semireducible, 
                   all_goals (make_cases ),
                   return ()
  | _ := return ()
  end 

meta def find_this_component (Γ : model_info) : list expr → tactic expr 
| [] := return default 
| (h::t) := do 
            τ ← infer_type h,
            match τ with 
            | `(_ = %%FOO) := 
                  if FOO ∈ Γ.comps then return FOO else find_this_component t 
            | _ := find_this_component t 
            end 

meta def get_comp_contract (H : expr)  (comp : expr): tactic unit := do 
  h ← get_unused_name,
  let e : expr := (expr.mk_app H [comp]),
  τ ← infer_type e,
  tactic.local_proof h (τ) (tactic.exact e),
  return ()

meta def get_other_comp_contracts (Γ : model_info) (H2 : expr) : tactic expr := do 
  e ← local_context >>= find_this_component Γ,
  let l := Γ.comps.erase e,
  l.mmap (get_comp_contract H2),
  return e

meta def rewrite_this_comp  (comp : expr ) : list expr → tactic unit 
| (h::t) := do 
          τ ← infer_type h,
          match τ with 
          | `(_ = %%FOO) := if FOO = comp then subst h else rewrite_this_comp t 
          | _ := rewrite_this_comp t 
          end
| [] := return ()

meta def decompose_fst_hyp (Γ : model_info) : tactic unit := do 
  Ha ← tactic.get_unused_name `Ha,
  `[rw AssertionLang.impl_def], 
  tactic.intro Ha, 
  `[rw AssertionLang.conj_def at *],
  H_e ← get_local Ha, 
  H1 ← get_unused_name `H1,
  H2 ← get_unused_name `H2,
  cases_core H_e [H1,H2] transparency.semireducible,
  `[rw list_conj_iff at *, simp only [list.mem_map, forall_exists_index, and_imp, forall_apply_eq_imp_iff₂] at *],  
   this_comp ← get_local H2 >>= get_other_comp_contracts Γ,
   local_context >>= rewrite_this_comp this_comp,
   H1_e ← get_local H1,
   tactic.rewrite_hyp `(unpack_lang) H1_e,
   repeat `[rw lang_conj_always_distrib at *],
  tactic.iterate (do H1_e ← get_local H1, cases_core H1_e [H1] transparency.semireducible),
  return ()

meta def clear_goal_rewrites_aux : expr → tactic unit 
| `(ite (%%X = %%Y) %%B %%C) :=  if X = Y then do `[rw if_pos] else do `[rw if_neg], clear_goal_rewrites_aux C
| _ := do  return ()

meta def clear_goal_of_rewrites : tactic unit := do 
 tgt ← target,
 match tgt with 
 | `(_ ∈ AssertionLang.sem (Contract.A (option.iget (%%FOO)))) := clear_goal_rewrites_aux FOO  
 | _ := do tactic.trace "hmm", return ()
 end 

meta def rpo_snd_core : tactic unit := do 
  repeat (`[rw Map.find_val at *]),
  clear_goal_of_rewrites,
  xs ← local_context >>= collect_assertions,
  l ← xs.mmap infer_type >>= get_conds_expr,
  let ls := xs.zip (l.map take_equals),
  suihfa ls,
  clear_goal_of_rewrites,
  iterate `[rw if_neg at *],
  any_goals `[dec_trivial],
  `[rw nf_def at *, simp only [Map.find_val] at *],
  try (`[rw unpack_lang, repeat {rw lang_conj_always_distrib}, rw ← unpack_lang, repeat {split}]),
  return ()

meta def check_for_semantic_unfolding : expr → tactic unit 
| `(_ ∈ AssertionLang.sem _) := do return ()
| _ := do try `[rw ← unpack_lang] 

meta def finish_conjunctions : tactic unit := do 
 any_goals $ `[rw lang_conj_always_distrib],
 any_goals $ split,
 any_goals $ assumption,
 any_goals $ `[rw ← unpack_lang], assumption,
 return ()

meta def new_tac_finisher (x : name) (Γ : model_info) : tactic unit := do 
  synchronize_ports x Γ,
  `[rw unpack_lang],
  try_terminal_rws,
  return ()

meta def solve_rpo_snd (Γ : model_info) : tactic unit := do 
  S ← tactic.get_unused_name `S,
  H ← tactic.get_unused_name `H,
  x ← tactic.get_unused_name `x,
  tactic.intro S, tactic.intro H, tactic.intro x,
  `[simp at *],
  make_cases H,
  all_goals $ decompose_fst_hyp Γ,
  all_goals $ rpo_snd_core, 
  all_goals $ try $ `[rw ← unpack_lang],
  all_goals (do x_e ← get_local x,synchronize_ports x Γ),
  all_goals $ `[rw unpack_lang],
  all_goals $ local_context >>= try_application,
  any_goals `[dec_trivial],
  any_goals $ try_terminal_rws,
  all_goals $ try (check_for_portation'),
  all_goals $ local_context >>= try_application,
  any_goals $ `[dec_trivial],
  all_goals $ new_tac_finisher x Γ,
  all_goals $ (do `[rw lang_conj_always_distrib, split], assumption <|> `[rw ← unpack_lang], assumption),
  return ()


meta def solve_rpos (Γ : model_info) : tactic string := do 
tgt ← target, 
match tgt with 
| `(RPO_fst _) := do solve_rpo_fst Γ, b ← is_solved, if b then return "solve_rpo_fst" else return "sorry"
| `(RPO_snd _) := do solve_rpo_snd Γ, b ← is_solved, if b then return "solve_rpo_snd" else return "sorry"
| _ := return "input fail"
end 
