import justification tactic LTS

variable {α : Type}

meta structure PROOF_STATE (α : Type) := 
(init_goal : expr := default expr)
(input : property.input α := default (property.input α))
(input_string : string := string.empty)
(strat_expr : expr := default expr)
(solved : bool := ff)
(originals : list (string × expr) := [])
(total : list expr := [])
(used : list string := [])
(PROPS : expr := default expr)
(tscript : list string := [])
(hints : list string := [])
(unused : string := string.empty)

meta def originals_aux : expr → list expr  
| `(list.cons %%h %%t) := match h with 
   | `(λ x, x ⊨ %%prop) := do [prop] ++ originals_aux t
   | _ := originals_aux t  
   end 
| _ := []

meta def get_originals (ps : PROOF_STATE α) : (PROOF_STATE α) := 
 let l := originals_aux ps.PROPS in 
 let l':= (list.range l.length).map 
 (λ i, ("P" ++ to_string (i+1) : string)) in 
 {originals := list.zip l' l ..ps}

namespace PROOF_STATE 


meta def log (ps : PROOF_STATE α) (s : string) : tactic (PROOF_STATE α):= 
return { tscript := ps.tscript ++ [s] ..ps}

meta def fill_props : list expr → tactic (list expr)
| [] := return []
| (h::t) := do h_t ← tactic.infer_type h, 
            match h_t with 
            | `(sat %%foo %%bar) := 
            do et ← fill_props t, return ([h] ++ et)
            | _ := fill_props t  
            end 

end PROOF_STATE