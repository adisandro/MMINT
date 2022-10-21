#!/usr/bin/env python3
import shutil
from argparse import ArgumentParser

if __name__ == "__main__":
    parser = ArgumentParser()
    parser.add_argument('model_name')
    parser.add_argument('instance_name')
    args = parser.parse_args()
    shutil.move(f'{args.model_name}/experiment0/ExperimentOut.properties',
                f'{args.model_name}/results/{args.instance_name}_PA.properties')
    shutil.rmtree(f'{args.model_name}/experiment0')
    shutil.move(f'{args.model_name}/experiment1/ExperimentOut.properties',
                f'{args.model_name}/results/{args.instance_name}_SAt.properties')
    shutil.rmtree(f'{args.model_name}/experiment1')
    shutil.move(f'{args.model_name}/experiment2/ExperimentOut.properties',
                f'{args.model_name}/results/{args.instance_name}_SAs.properties')
    shutil.rmtree(f'{args.model_name}/experiment2')
    shutil.move(f'{args.model_name}/experiment3/ExperimentOut.properties',
                f'{args.model_name}/results/{args.instance_name}_CA.properties')
    shutil.rmtree(f'{args.model_name}/experiment3')
    shutil.move(f'{args.model_name}/experiment4/ExperimentOut.properties',
                f'{args.model_name}/results/{args.instance_name}_LN.properties')
    shutil.rmtree(f'{args.model_name}/experiment4')
