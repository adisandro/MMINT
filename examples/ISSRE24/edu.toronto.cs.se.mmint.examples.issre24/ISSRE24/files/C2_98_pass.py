from C2_1 import *
from C1_1 import *
from C2_95 import *
from C2_92_pass import *

# This file specifies the relationship R

def R(satisfied: Callable) -> Callable:
    raise NotImplementedError()

ReqRel = []

for i in range(len(Transformations)):
    t = Transformations[i]
    for rID in RelevantID:
        def R_identity(satisfied: Callable) -> Callable:
            return satisfied
        ReqRel.append((rID, ReqSafe[rID], 'rel_'+rID+'_'+t.ID, R_identity(ReqSafe[rID]), below_t[i]))
