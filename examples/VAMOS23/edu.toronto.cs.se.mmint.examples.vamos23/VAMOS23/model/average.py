#!/usr/bin/env python3
from argparse import ArgumentParser
from pathlib import Path


def read_result(file):
    num_results = 0
    time_query = 0
    sat_calls = 0
    time_sat = 0
    for line in file.readlines():
        match line.partition('='):
            case ('numResults.avg', eq, val):
                num_results = float(val)
            case ('timeQuery.avg', eq, val):
                time_query = float(val)
            case ('satCalls.avg', eq, val):
                sat_calls = float(val)
            case ('timeSat.avg', eq, val):
                time_sat = float(val)
            case _:
                pass
    return num_results, time_query, sat_calls, time_sat


if __name__ == "__main__":
    parser = ArgumentParser()
    parser.add_argument('model_name')
    args = parser.parse_args()
    QUERIES = ['PA', 'SAt', 'SAs', 'CA', 'LN']
    for query in QUERIES:
        print(f'Query {query}:')
        num_results_avg = 0
        time_query_avg = 0
        i = 0
        while True:
            result_path = Path(f'{args.model_name}/results/P{i}_{query}.properties')
            if not result_path.exists():
                break
            with open(result_path) as result_file:
                result = read_result(result_file)
                num_results_avg += result[0]
                time_query_avg += result[1]
            i += 1
        num_results_avg /= i
        time_query_avg /= i
        print(f'  P Avg Time: {time_query_avg}')
        print(f'  P Avg # Results: {num_results_avg}')
        with open(f'{args.model_name}/results/PL_{query}.properties') as result_file:
            result = read_result(result_file)
            print(f'  PL Time: {result[1]}')
            print(f'  PL # Results: {result[0]}')
            print(f'  PL SAT Time: {result[3]}')
            print(f'  PL # SAT Calls: {result[2]}')

