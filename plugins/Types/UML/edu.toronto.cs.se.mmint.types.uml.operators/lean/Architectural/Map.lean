import tactic 

@[derive inhabited]
inductive Map (α : Type) (β : Type)
  | nil : Map
  | cons (key : α) (value : β) (t : Map) : Map

namespace Map

variables {α : Type} {β : Type}


def insert (m : Map α β) (k : α) (v : β) : Map α β :=
  m.cons k v

def find_entry [decidable_eq α] (a : α) : Map α β → option (α × β)
  | nil         := none
  | (cons k v es) := if k = a then some (k, v) 
                              else find_entry  es

@[reducible]
def find_val [decidable_eq α] (a : α) : Map α β → option β
  | nil         := none
  | (cons k v es) := if k = a then some v
                              else find_val es

def mem [decidable_eq α] (a : α) : Map α β → bool
  | nil         := ff
  | (cons k v es) := (k = a) || mem es

end Map

@[reducible]
def toMap {α : Type } {β : Type} : list (α × β) → Map α β
  | []          := Map.nil
  | ((a,b) :: es) := Map.cons a b (toMap es)

instance {α : Type } {β : Type}: has_coe (list (α × β)) (Map α β) := ⟨toMap⟩ 