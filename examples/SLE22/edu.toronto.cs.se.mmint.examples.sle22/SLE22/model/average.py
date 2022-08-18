#!/usr/bin/env python3
from argparse import ArgumentParser


def read_result(result_file):
    num_results = 0
    time_query = 0
    for line in result_file.readlines():
        if line.startswith('numResults.avg'):
            num_results = float(line.split('=')[1])
        if line.startswith('timeQuery.avg'):
            time_query = float(line.split('=')[1])
    return num_results, time_query


if __name__ == "__main__":
    parser = ArgumentParser()
    parser.add_argument('model_name')
    parser.add_argument('query_name')
    args = parser.parse_args()
    NUM_SAMPLES = 5
    num_results_avg = 0
    time_query_avg = 0
    for i in range(NUM_SAMPLES):
        with open(f'{args.model_name}/results/CD{i}_{args.query_name}.properties') as result_file:
            result = read_result(result_file)
            print(result)
            num_results_avg += result[0]
            time_query_avg += result[1]
    num_results_avg /= NUM_SAMPLES
    time_query_avg /= NUM_SAMPLES
    print(f'Avg # Res: {num_results_avg}')
    print(f'Avg Time: {time_query_avg}')
