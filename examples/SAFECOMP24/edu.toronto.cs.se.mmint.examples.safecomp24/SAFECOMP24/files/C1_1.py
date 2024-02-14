import numpy as np
import albumentations
import cv2
from matplotlib import pyplot as plt
import PIL

### This file specifies the transformations

Transformations = []

class Transformation:
    def __init__(self, ID, parameters, param_dist):
        self.ID = ID
        self.parameters = parameters
        assert isinstance(parameters, np.ndarray)
        self.param_dist = param_dist
        assert isinstance(param_dist, np.ndarray)
        assert parameters.shape == param_dist.shape
        
    def random_transform(self, image: PIL.Image.Image) -> PIL.Image.Image:
        raise NotImplementedError()

### Example 
class snow(Transformation):
    def random_transform(self, image: PIL.Image.Image) -> PIL.Image.Image:
        image = np.asarray(image)
        transformation = albumentations.RandomSnow(snow_point_lower=0.1, snow_point_upper=0.3, brightness_coeff=np.random.choice(self.parameters, p =self.param_dist), always_apply=True)
        return PIL.Image.fromarray(transformation(image=image)['image'])

T_snow = snow('snow', np.linspace(0, 2.5, 5), np.zeros(5)+1/5) 
Transformations.append(T_snow)
### Example end


# Tests
if __name__ == '__main__':
    # example usage of the transformation snow
    example_img = '/Users/caroline/Desktop/pedestrian_no_snow.jpeg'
    image = PIL.Image.open(example_img)
    plt.figure(figsize=(10, 10))
    plt.axis('off')
    plt.imshow(np.asarray(image))
    plt.show()
    #image = PIL.Image.fromarray(image)
    new = T_snow.random_transform(image)
    plt.figure(figsize=(10, 10))
    plt.axis('off')
    plt.imshow(np.asarray(new))
    plt.show()


