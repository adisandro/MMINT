import justification tactic LTS

variable {α : Type}

meta structure proof_data (α : Type) := 
(init_goal : expr := default)
(input_string : string := string.empty)
(strat_expr : expr := default )
(solved : bool := ff)
(originals : list (string × expr) := [])
(total : list expr := [])
(used : list string := [])
(PROPS : expr := default )
(tscript : list string := [])
(hints : list string := [])
(unused : string := string.empty)
(used_expr : list expr := [])
(cur_goal : expr := default)

meta structure property_proof_data (α : Type) extends proof_data α := 
(input : property.input α := default)

meta def originals_aux : expr → list expr  
| `(list.cons %%h %%t) := match h with 
   | `(λ x, x ⊨ %%prop) := do [prop] ++ originals_aux t
   | _ := originals_aux t  
   end 
| _ := []

meta def get_originals (ps : proof_data α) : (proof_data α) := 
 let l := originals_aux ps.PROPS in 
 let l':= (list.range l.length).map 
 (λ i, ("P" ++ to_string (i+1) : string)) in 
 {originals := list.zip l' l ..ps}

namespace proof_data 

meta def log (ps : proof_data α) (s : string) : tactic (proof_data α):= 
return { tscript := ps.tscript ++ [s] ..ps}


meta def log_hint (ps : proof_data α) (s : string) : tactic (proof_data α):= 
return { hints := ps.hints ++ [s] ..ps}


meta def log_used_tactic_subclaim (ps : proof_data α) (s c : string) : tactic (proof_data α) := 
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

end proof_data

namespace property_proof_data 


meta def get_originals (ps : property_proof_data α) : (property_proof_data α) := 
 let l := originals_aux ps.PROPS in 
 let l':= (list.range l.length).map 
 (λ i, ("P" ++ to_string (i+1) : string)) in 
 {originals := list.zip l' l ..ps}


meta def log (ps : property_proof_data α) (s : string) : tactic (property_proof_data α):= 
return { tscript := ps.tscript ++ [s] ..ps}

meta def log_tactic (ps : property_proof_data α) (l : list string) : tactic (property_proof_data α) := 
return {tscript := ps.tscript ++ l, ..ps}


meta def log_hint (ps : property_proof_data α) (s : string) : tactic (property_proof_data α):= 
return { hints := ps.hints ++ [s] ..ps}


meta def log_used_tactic_subclaim (ps : property_proof_data α) (s c : string) : tactic (property_proof_data α) := 
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


end property_proof_data
