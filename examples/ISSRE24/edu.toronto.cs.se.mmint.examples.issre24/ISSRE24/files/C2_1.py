import numpy as np
import torch

import torchvision
from torchvision import transforms
from typing import Callable

# This file specifies the satisfied() function for all safety requirements

ReqSafe= {}

def satisfied(data: torch.utils.data.Dataset, model: torch.nn.Module, metric: Callable) -> bool:
    raise NotImplementedError()

### Example
def model_accuracy(testloader, model):
    model.eval()
    device = 'cuda' if torch.cuda.is_available() else 'cpu'
    correct = 0
    total = 0
    with torch.no_grad():
        for batch_idx, (inputs, targets) in enumerate(testloader):
            inputs, targets = inputs.to(device), targets.to(device)
            outputs = model(inputs)
            _, predicted = outputs.max(1)
            #print(outputs)
            total += targets.size(0)
            correct += predicted.eq(targets).sum().item()
    acc = 100.*correct/total
    print(acc)
    return acc

def example_satisfied_1(data, model, metric): # req_safe: model accuracy should be >0.50 #SAT
    dataloader = torch.utils.data.DataLoader(data, batch_size=100, shuffle=False, num_workers=1)
    model_acc = metric(dataloader, model)
    return model_acc > 50

def example_satisfied_2(data, model, metric): # req_safe: model accuracy should be >0.90 #UNSAT
    dataloader = torch.utils.data.DataLoader(data, batch_size=100, shuffle=False, num_workers=1)
    model_acc = metric(dataloader, model)
    return model_acc > 90


ReqSafe['req_safe_1'] = example_satisfied_1
ReqSafe['req_safe_2'] = example_satisfied_2
### Example end 

# Tests, ignore
if __name__ == '__main__':
    from models import resnet18
    model = resnet18(pretrained=True)

    transform_test = transforms.Compose([
        transforms.ToTensor(),
        transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2471, 0.2435, 0.2616)),
    ])
    testset = torchvision.datasets.CIFAR10(
        root='./data', train=False, download=True, transform=transform_test)
    
    print(example_satisfied_1(testset, model, model_accuracy))
