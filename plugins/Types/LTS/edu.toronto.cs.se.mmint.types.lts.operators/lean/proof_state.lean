import justification tactic LTS.defs

variable {α : Type}

meta structure proofState (α : Type) := 
(init_goal : expr := default)
(input : property.input α := default)
(input_string : string := string.empty)
(strat_expr : expr := default)
(solved : bool := ff)
(originals : list (string × expr) := [])
(total : list expr := [])
(used : list string := [])
(PROPS : expr := default)
(tscript : list string := [])
(hints : list string := [])
(unused : string := string.empty)

meta def originals_aux : expr → list expr  
| `(list.cons %%h %%t) := match h with 
   | `(λ x, x ⊨ %%prop) := do [prop] ++ originals_aux t
   | _ := originals_aux t  
   end 
| _ := []

meta def get_originals (ps : proofState α) : (proofState α) := 
 let l := originals_aux ps.PROPS in 
 let l':= (list.range l.length).map 
 (λ i, ("P" ++ to_string (i+1) : string)) in 
 {originals := list.zip l' l ..ps}

namespace proofState 

meta def log (ps : proofState α) (s : string) : tactic (proofState α):= 
return { tscript := ps.tscript ++ [s] ..ps}


meta def log_hint (ps : proofState α) (s : string) : tactic (proofState α):= 
return { hints := ps.hints ++ [s] ..ps}


meta def log_used_tactic_subclaim (ps : proofState α) (s c : string) : tactic (proofState α) := 
return {
   tscript := ps.tscript.concat(s ++ c), 
   used := ps.used ++ [c], ..ps}

meta def fill_props : list expr → tactic (list expr)
| [] := return []
| (h::t) := do h_t ← tactic.infer_type h, 
            match h_t with 
            | `(sat %%foo %%bar) := 
            do et ← fill_props t, return ([h] ++ et)
            | _ := fill_props t  
            end 

end proofState