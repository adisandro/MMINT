import LTS.defs

variable {M : LTS}
set_option pp.beta true 


namespace absent 

def globally (P : formula M) : formula M := 
    ◾ (!P)

def before  (P R : formula M) : formula M := 
    (◆R) ⇒ ((!P) U R)

def after (P Q : formula M)  : formula M := 
    ◾(Q ⇒ ◾!P)

def between (P Q R : formula M) : formula M :=   
    ◾((Q & !R & ◆ R) ⇒ (!P U R))

def after_until (P Q R: formula M) : formula M :=
    ◾((Q & !R) ⇒ ((!P) W R))

end absent


namespace exist 

def globally (P : formula M) : formula M := 
    ◆P

def before (P R : formula M) : formula M := 
    (!R) W (P & !R)

def after (P Q : formula M)  : formula M := 
    (◾(!Q)) ⅋ ◆(Q & ◆ P)

def between (P Q R : formula M) : formula M :=   
    ◾((Q & !R) ⇒ ((!R) W (P & !R)))
    
def after_until (P Q R: formula M) : formula M :=
    ◾((Q & !R) ⇒ (!R U (P & !R)))

end exist


namespace universal 

def globally (P : formula M) : formula M := 
    ◾ P
def before (P R : formula M) : formula M := 
    (◆R) ⇒ (P U R) 
def after (P Q : formula M)  : formula M := 
    ◾(Q ⇒ ◾P)
def between (P Q R : formula M) : formula M :=   
    ◾((Q & !R & ◆R) ⇒ (P U R))
def after_until (P Q R: formula M) : formula M :=
    ◾((Q & !R) ⇒ (P W R))

end universal

namespace precedes 

def globally (S P : formula M) : formula M := 
    (!P) W S

def before (S P R : formula M) : formula M := 
    (◆R) ⇒ ((!P) U (S ⅋ R)) 

def after (S P Q : formula M)  : formula M := 
    (◾!Q) ⅋ ◆(Q & ((!P) W S)) 

def between (S P Q R : formula M) : formula M :=   
    ◾((Q & (!R) & ◆R) ⇒ (!P U (S ⅋ R)))

def after_until (S P Q R: formula M) : formula M :=
    ◾((Q & !R) ⇒ ((!P) W (S ⅋ R)))

end precedes

namespace responds 

def globally (P S : formula M) : formula M := 
    ◾(P ⇒ ◆S)

def before (S P R : formula M) : formula M := 
    (◆R) ⇒ ((P ⇒ (!R U (S & !R))) U R)

def after (S P Q : formula M)  : formula M := 
    ◾(Q ⇒ ◾(P ⇒ ◆S))

def between (S P Q R : formula M) : formula M :=   
    ◾((Q & !R & ◆R) ⇒ (P ⇒ (!R U (S & !R))) U R) 

def after_until (S P Q R: formula M) : formula M :=
    ◾((Q & !R) ⇒ ((P ⇒ (!R U (S & !R))) W R))

end responds

lemma sat_em (P : formula M) (π : path M) :  sat P π → ¬sat ( !P) π := by {intros, rw sat, tidy}


