#!/usr/bin/env python3
from argparse import ArgumentParser
from pathlib import Path


def read_result(file):
    time_merge = 0
    for line in file.readlines():
        match line.partition('='):
            case ('Merge.timeMerge.avg', eq, val):
                time_merge = float(val)
            case _:
                pass
    return time_merge


if __name__ == "__main__":
    parser = ArgumentParser()
    parser.add_argument('model_name')
    args = parser.parse_args()
    SIZES = ['orig', '1k', '5k']
    IDS = ['10', '100', '500']
    PRODUCTS = {'GPL': 840, 'Automata': 2016, 'bCMS-SPL-PC': 15360, 'crom_l1': 2395000}
    for size in SIZES:
        latex = ''
        for id in IDS:
            try:
                with open(f'{args.model_name}/results/P_{size}_J{id}.properties') as result_file:
                    result = read_result(result_file)
                    time_merge_p = result
                with open(f'{args.model_name}/results/PL_{size}_K{id}.properties') as result_file:
                    result = read_result(result_file)
                    time_merge_pl = result
                speedup = round(time_merge_p * PRODUCTS[args.model_name] / time_merge_pl, 2)
                if speedup < 1:
                    speedup = - round(time_merge_pl / (time_merge_p * PRODUCTS[args.model_name]), 2)
                print(f'{args.model_name} {size}_{id}:')
                print(f'  K/J Speedup: {speedup}')
                latex += f' & {speedup}'
            except:
                latex += f' & -'
        print(f'Latex {args.model_name} {size}: {latex}')

