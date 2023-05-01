#!/usr/bin/env python3
import shutil
from argparse import ArgumentParser

if __name__ == "__main__":
    parser = ArgumentParser()
    parser.add_argument('model_name')
    parser.add_argument('p_or_pl')
    parser.add_argument('size')
    args = parser.parse_args()
#    IDS = ['J10', 'K10']
#    IDS = ['J10', 'J100', 'K10', 'K100']
    IDS = ['J10', 'J100', 'J500', 'K10', 'K100', 'K500']
    for i, id in enumerate(IDS):
        shutil.move(f'{args.model_name}/experiment{i}/ExperimentOut.properties',
                    f'{args.model_name}/results/{args.p_or_pl}_{args.size}_{id}.properties')
        shutil.rmtree(f'{args.model_name}/experiment{i}')

