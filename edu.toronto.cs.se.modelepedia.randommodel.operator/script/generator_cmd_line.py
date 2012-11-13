#File:        generator_cmd_line.py
#Author:      Nathan Robinson
#Contact:     nathan.m.robinson@gmail.com
#Date:        2012-07-09
#Desctiption: A command line processor specific to this graph generator.
#             It uses the system defined in cmd_line.py

import sys
from cmd_line import ArgProcessor, ArgDefinition, FlagDefinition,\
    range_validator, enum_validator, bool_validator, InputException

#This function takes a validator function and arguments and returns a short
#string describing the acceptable values:
def get_value_advice(validator, validator_args):
    if validator == None: return ""
    if validator == range_validator:
        a_type, lb, ub, allow_none, error_msg = validator_args
        if lb == None and ub == None: return ""
        adv_str = 'x'
        if lb != None: adv_str = str(lb) + ' <= ' + adv_str
        if ub != None: adv_str += ' <= ' + str(ub)
        if allow_none: adv_str += ', None'
        return ' {' + adv_str + '}'
    if validator == enum_validator:
        return ' {' + ', '.join(validator_args[0]) + '}'
    if validator == bool_validator:
        return ' {true, false}'
    assert False, "Error, knwnown validator!"

#This function prints a usage message to sys.stdout based on the current
#argument and flag definition. It then exits.
def print_usage(arg_processor):
    min_width = max(map(lambda x : len(x),\
        arg_processor.program_arg_order + arg_processor.program_flag_order))
    print "Usage: python {} ".format(sys.argv[0])
    print "The following flags and argumentscan  be supplied:"
    print "Flags:"
    for flag in arg_processor.program_flag_order:
        print "  {:<{}} : {}".format(flag, min_width,
            arg_processor.program_flags[flag].description)
    print "Arguments:"
    for arg in arg_processor.program_arg_order:
        if arg_processor.program_args[arg].needed:
            print "  {:<{}} : {}{}".format(arg, min_width,
                arg_processor.program_args[arg].description,
                get_value_advice(arg_processor.program_args[arg].validator, 
                arg_processor.program_args[arg].validator_args))
        else:
            print "  {:<{}} : {}{} [optional, default: {})".format(arg, min_width,
                arg_processor.program_args[arg].description,
                get_value_advice(arg_processor.program_args[arg].validator, 
                arg_processor.program_args[arg].validator_args),
                arg_processor.program_args[arg].default_value)
    sys.exit(0)

def print_citation_info(arg_processor):
    print "When citing this planner please use the following publication:"
    print "TBA"
    sys.exit(0)

def process_args():
    arg_processor = ArgProcessor()
    arg_processor.add_program_arg('-input',
        ArgDefinition('input_file_name',
            True,
            None,
            None,
            None,
            "Input file name"))
    arg_processor.add_program_arg('-outgraph',
        ArgDefinition('output_graph_file_name',
            True,
            None,
            None,
            None,
            "Output graph file name"))
    arg_processor.add_program_arg('-outmavoelems',
        ArgDefinition('output_mavoelems_file_name',
            True,
            None,
            None,
            None,
            "Output MAVO elements file name"))
    arg_processor.add_program_arg('-instname',
        ArgDefinition('instance_name',
            True,
            None,
            None,
            None,
            "Instance name"))
    arg_processor.add_program_arg('-outtype',
        ArgDefinition('output_type',
            False,
            enum_validator,
            [['ecore', 'graphviz'], "Error - invalid output type: "],
            'ecore',
            "Output type"))
    arg_processor.add_program_arg('-annotated',
        ArgDefinition('annotated_fraction',
            False,
            range_validator,
            [float, 0, 1, False, "Error - invalid fraction of elements to annotate:"],
            0,
            "Fraction of elements to annotate"))
    arg_processor.add_program_arg('-may',
        ArgDefinition('may_fraction',
            False,
            range_validator,
            [float, 0, 1, False, "Error: invalid fraction of annotated notes with (m)"],
            0,
            "Fraction of annotated nodes with (m)"))
    arg_processor.add_program_arg('-var',
        ArgDefinition('var_fraction',
            False,
            range_validator,
            [float, 0, 1, False, "Error - invalid fraction of annotated notes with (v):"],
            0,
            "Fraction of annotated nodes with (v)"))
    arg_processor.add_program_arg('-set',
        ArgDefinition('set_fraction',
            False,
            range_validator,
            [float, 0, 1, False, "Error - invalid fraction of annotated notes with (s):"],
            0,
            "Fraction of annotated nodes with (s)"))
    arg_processor.add_program_arg('-seed',
        ArgDefinition('initial_seed',
            False,
            None,
            None,
            None,
            "Initial seed for pseudorandom generator"))
    arg_processor.add_program_arg('-state',
        ArgDefinition('state_file',
            False,
            None,
            None,
            None,
            "File name for loading/saving the random generator internal state"))

    arg_processor.add_program_flag('--help',
        FlagDefinition('help',
            print_usage,
            "Display this notice"))
    arg_processor.add_program_flag('--cite',
        FlagDefinition('cite',
            print_citation_info,
            "Display citation information"))
    
    try:
        arg_processor.parse_args()
    except InputException as e:
        print e.message
        print "Use --help flag to display usage information."
        sys.exit(1)
    return arg_processor

