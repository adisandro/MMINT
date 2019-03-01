#!/usr/bin/env python3

import os
from jproperties import Properties


def get_values(props_path, var_x, var_y, var_line=None):
    props = Properties()
    with open(props_path, 'rb') as props_file:
        props.load(props_file, 'utf-8')
        value_x, _ = props[var_x]
        value_line = None
        if var_line:
            value_line, _ = props[var_line]
        value_y_avg, _ = props[f'{var_y}.avg']
        value_y_avg = float(value_y_avg) / 1_000_000
        value_y_low, _ = props[f'{var_y}.lower']
        value_y_low = float(value_y_low) / 1_000_000
        value_y_up, _ = props[f'{var_y}.upper']
        value_y_up = float(value_y_up) / 1_000_000
        return {'x': value_x, 'y': (value_y_avg, value_y_low, value_y_up), 'line': value_line}


if __name__ == '__main__':
    for operator in ['filter', 'map', 'reduce']:
        data = {}
        for signature in ['model', 'rel']:
            data[signature] = {}
            path = os.path.join(operator, signature)
            for experiment in os.listdir(path):
                exp_path = os.path.join(path, experiment)
                if not os.path.isdir(exp_path):
                    continue
                props_path = os.path.join(exp_path, 'ExperimentOut.properties')
                values = get_values(props_path, var_x='numSignatureSites', var_y='timeOverhead',
                                    var_line='ratioPolySites')
                x = data[signature].setdefault(values['x'], {})
                x[values['line']] = values['y']
        with open(f'{operator}_10types.dat', 'w') as dat_file:
            # {'model': {100: {0.5: (1,2,3)}}}
            out = ''
            for x in sorted(data['model'].keys()):
                if x == '0':
                    out += '0.1'
                else:
                    out += f'{x}'
                for y in sorted(data['model'][x].keys()):
                    out += ' ' + ' '.join(str(n) for n in data['model'][x][y])
                for y in sorted(data['rel'][x].keys()):
                    out += ' ' + ' '.join(str(n) for n in data['rel'][x][y])
                out += '\n'
            dat_file.write(out)
    with open('all_poly.dat', 'w') as dat_file:
        out = ''
        for num_types in ['1', '2', '5', '10', '20', '30']:
            out += num_types
            for hierarchy in ['', 'deep_']:
                for signature in ['model', 'rel']:
                    for operator in ['map', 'reduce', 'filter']:
                        props_path = os.path.join('poly', f'{hierarchy}{operator}_{signature}_{num_types}',
                                                  'ExperimentOut.properties')
                        if os.path.exists(props_path):
                            values = get_values(props_path, var_x='numPolyTypes', var_y='timeOverhead')
                            out += ' ' + ' '.join(str(n) for n in values['y'])
            out += '\n'
        dat_file.write(out)


