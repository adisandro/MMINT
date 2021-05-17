import data.set data.stream.basic
open stream 

structure LTS:= (S : Type) (Act : Type)(TR : set (S × Act × S))
--structure LTS:= (S : Type) (A : Type) (Δ : set (S × Act × S))

structure path (M : LTS) := 
(init : M.S)
(s : stream (M.Act × M.S))
(sound : ((init, (s 0).1, (s 0).2) ∈ M.TR) ∧ 
          ∀ i : ℕ, ((s i).2, (s (i+1)).1, (s (i+1)).2) ∈ M.TR)

variable {M : LTS}

namespace path 

def index (π : path M) : ℕ+ → (M.Act × M.S)
| (n) := (π.s (n-1))

lemma drop_aux (π : path M) (n : ℕ) : 
    ((π.s n).snd, (drop (n+1) π.s 0).fst, (drop (n+1) π.s 0).snd) ∈ M.TR ∧ ∀ (i : ℕ), ((drop (n+1) π.s i).snd, (stream.drop (n+1) π.s (i + 1)).fst, (drop (n+1) π.s (i + 1)).snd) ∈ M.TR := 
    begin 
         have := π.sound, cases this with L R,
         rw stream.drop,
         dsimp at *, simp at *,
         split,
         apply R n,
         intro i,
         replace R := R (i+n.succ),
         rw add_assoc at R, rw add_comm n.succ 1 at R, rw ← add_assoc at R,
         apply R,
end


def drop (π : path M) : ℕ → path M 
| 0 := π 
| (nat.succ n) := 
    path.mk (π.s n).2 (π.s.drop n.succ) (drop_aux π n)

lemma drop_drop  (π : path M) {i j : ℕ} : 
    (π.drop i).drop j = π.drop (i+j) := 
    begin
        cases i, {rw drop, simp}, 
        cases j, rw [drop,drop],
        rw drop, rw drop, rw drop, simp,
        rw drop_drop, 
         split,
        rw stream.drop,
        simp, rw add_comm,
        rw nat.add_succ,
        rw add_comm, rw nat.add_succ,
        rw add_comm i.succ,
        rw nat.add_succ, rw add_comm,
    end  

end path 


inductive formula (M : LTS) 
| T : formula 
| state_predicate (p : M.S → Prop) : formula
| act_predicate (p : M.Act → Prop) : formula
| state (s : M.S) : formula  
| act (a : M.Act) : formula 
| neg (x : formula) : formula 
| conj (φ₁ φ₂ : formula) : formula 
| disj (φ₁ φ₂ : formula) : formula 
| impl (φ₁ φ₂ : formula) : formula 
| next (φ : formula) : formula 
| always (φ : formula) : formula 
| eventually (φ : formula) : formula 
| until (φ₁ φ₂ : formula) : formula 

def sat {M : LTS} : formula M → path M → Prop 
| formula.T := λ _, true 
| (formula.state s) :=  λ π, π.init = s 
| (formula.act a)  := λ π, (path.index π 1).1 = a 
| (formula.neg φ) := λ π, ¬ (sat φ) π
| (formula.conj φ₁ φ₂) := λ π, sat φ₁ π ∧ sat φ₂ π
| (formula.disj φ₁ φ₂) := λ π, sat φ₁ π ∨ sat φ₂ π
| (formula.impl φ₁ φ₂) := λ π, sat φ₁ π → sat φ₂ π
| (formula.next φ) := λ π, sat φ (π.drop 1)
| (formula.until φ₁ φ₂) := λ π, 
    ∃ j, sat φ₂ (π.drop j) ∧ (∀ i < j, sat φ₁ (π.drop i))
| (formula.always φ) := λ π, ∀ i, sat φ (π.drop i) 
| (formula.eventually φ) := λ π, ∃ i, sat φ (π.drop i)
| (formula.state_predicate p) := λ π, p π.init
| (formula.act_predicate p) := λ π, p (path.index π 1).1 

notation φ ` & ` ψ := formula.conj  φ ψ 
notation φ ` ⅋ ` ψ := formula.disj φ ψ 
notation ` !` φ := formula.neg φ 
notation φ ` U ` ψ := formula.until φ ψ 
notation ` ◆` φ := formula.eventually φ 
notation ` ◾` φ  := formula.always  φ
notation φ ` ⇒ ` ψ := formula.impl φ ψ 
notation π `⊨` P := sat P π 

namespace formula 

def weak_until (φ ψ : formula M) : formula M := 
(◾φ) ⅋ (φ U ψ)

end formula 

notation φ ` W ` ψ := formula.weak_until φ ψ 

namespace sat

lemma  weak_until (φ ψ : formula M) (π : path M) : 
    sat (formula.weak_until φ ψ) π ↔ sat (◾ φ) π ∨ sat (φ U ψ) π :=  
  by {rw formula.weak_until, repeat {rw sat}}

end sat 

lemma push_neg_tok {M : LTS} {π : path M} : ∀ P : formula M,
    ¬ (sat P π) ↔ sat (!P) π := 
by {intro P, refl,}

lemma always_eventually_dual (P : formula M) (π : path M) : 
    sat (◾!P) π ↔ (¬ sat (◆P) π) := 
by {repeat {rw sat}, tidy}

@[simp] lemma succ_add_1 {π : path M} {i : ℕ} : 
 (π.drop i).drop 1 = π.drop (i.succ) := 
 by {rw path.drop_drop}
