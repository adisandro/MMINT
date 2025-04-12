
from C1_1 import *
from C2_2 import *

# This file specifies threshold and gets relData below threshold

Delta = ...
t = [] # should be same length as all transformatons (Transformations)
below_t = [] # should be same length as all transformatons (Transformations)

# Example: using mean_squared_error as the Delta function
from skimage.metrics import mean_squared_error
Delta = mean_squared_error


# Find data below this threshold
def get_data_below_t(T, t): 
    orig_iterator = iter(testset)
    t_iterator = iter(relData)
    id_keep = []
    for i in range(SIZE):
        orig_ID, (orig_image, orig_label) = next(enumerate(orig_iterator))
        t_ID, (t_image, t_label) = next(enumerate(t_iterator))
        if mean_squared_error(orig_image.numpy(), t_image.numpy()) <= t:
            id_keep.append(i)
    below_t = torch.utils.data.Subset(relData, id_keep) # original test set
    return below_t

t = [1.0]

for i in range(len(Transformations)):
    T = Transformations[i]
    relData = TransformedData[i]
    below_t.append(get_data_below_t(T, t))



