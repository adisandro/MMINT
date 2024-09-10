import torchvision
import torch
from torchvision import transforms
from C1_1 import *

# This file specifies the oirginal datasets, and then obtains reliability test dataset by transforming the original dataset

testset = ...
SIZE = ... # size of the reliability testing dataset
TransformedData = [] 

#### Example
SIZE = 500
transform_no_T = transforms.Compose([
        transforms.ToTensor(),
        transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2471, 0.2435, 0.2616)),
    ])
testset = torchvision.datasets.CIFAR10(
    root='./data', train=False, download=True, transform=transform_no_T)
TransformedData.append(testset)
subset = list(range(SIZE)) 
testset = torch.utils.data.Subset(testset, subset) # original test set


# generating reliability testing dataset
for T in Transformations:
    transform_test = transforms.Compose([
        transforms.Lambda(T.random_transform),
        transforms.ToTensor(),
        transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2471, 0.2435, 0.2616)),
    ])
    testset = torchvision.datasets.CIFAR10(
        root='./data', train=False, download=True, transform=transform_test)
    subset = list(range(SIZE)) 
    testset = torch.utils.data.Subset(testset, subset)
    TransformedData.append(testset)
#### Example end  


