#!/usr/bin/env python3
from argparse import ArgumentParser


def read_result(result_file):
    num_results = 0
    time_query = 0
    sat_calls = 0
    time_sat = 0
    for line in result_file.readlines():
        if line.startswith('numResults.avg'):
            num_results = float(line.split('=')[1])
        if line.startswith('timeQuery.avg'):
            time_query = float(line.split('=')[1])
        if line.startswith('satCalls.avg'):
            sat_calls = float(line.split('=')[1])
        if line.startswith('timeSat.avg'):
            time_sat = float(line.split('=')[1])
    return num_results, time_query, sat_calls, time_sat


if __name__ == "__main__":
    parser = ArgumentParser()
    parser.add_argument('model_name')
    args = parser.parse_args()
    NUM_PRODUCTS = 5
    QUERY_NAMES = ['PA', 'SAt', 'SAs', 'CA', 'LN']
    for query_name in QUERY_NAMES:
        print(f'Query {query_name}:')
        num_results_avg = 0
        time_query_avg = 0
        for i in range(NUM_PRODUCTS):
            with open(f'{args.model_name}/results/P{i}_{query_name}.properties') as result_file:
                result = read_result(result_file)
                num_results_avg += result[0]
                time_query_avg += result[1]
        num_results_avg /= NUM_PRODUCTS
        time_query_avg /= NUM_PRODUCTS
        print(f'  P Avg Time: {time_query_avg}')
        print(f'  P Avg # Results: {num_results_avg}')
        with open(f'{args.model_name}/results/PL_{query_name}.properties') as result_file:
            result = read_result(result_file)
            print(f'  PL Time: {result[1]}')
            print(f'  PL # Results: {result[0]}')
            print(f'  PL SAT Time: {result[3]}')
            print(f'  PL # SAT Calls: {result[2]}')

