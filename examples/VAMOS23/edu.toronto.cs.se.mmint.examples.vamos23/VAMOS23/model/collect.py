#!/usr/bin/env python3
import shutil
from argparse import ArgumentParser

if __name__ == "__main__":
    parser = ArgumentParser()
    parser.add_argument('model_name')
    parser.add_argument('instance_name')
    args = parser.parse_args()
    QUERIES = ['PA', 'SAt', 'SAs', 'CA', 'LN']
    for i, query in enumerate(QUERIES):
        shutil.move(f'{args.model_name}/experiment{i}/ExperimentOut.properties',
                    f'{args.model_name}/results/{args.instance_name}_{query}.properties')
        shutil.rmtree(f'{args.model_name}/experiment{i}')
