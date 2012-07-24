#File:        graph_gen.py
#Author:      Nathan Robinson
#Contact:     nathan.m.robinson@gmail.com
#Date:        2012-07-10
#Desctiption: This program...

import sys, random

from generator_cmd_line import process_args
from xml.dom.minidom import parse

from graph import Graph, Node, Edge
import state_machine, labeled_graph

class GeneratorException(Exception):
    pass

def input_typegraph(quiet, input_file_name):
    try:
        if not quiet: print "Reading input file:", input_file_name
        in_file = file(input_file_name, 'r')
        input_xml = parse(in_file)
        in_file.close()
    except IOError:
        print "Error: cannot read from file:", in_file
        sys.exit(1)
    model = input_xml.getElementsByTagName('randommodel:RandomModel')[0]
    graph = Graph(model.getAttribute('name'),
        model.getAttribute('type'),
        int(model.getAttribute('defaultMinimumNumberOfInstances')),
        int(model.getAttribute('defaultMaximumNumberOfInstances')))
    nodes = input_xml.getElementsByTagName('nodes')
    for node in nodes:
        min_inst = node.getAttribute('minimumNumberOfInstances')
        if min_inst: min_inst = int(min_inst)
        else:        min_inst = graph.default_min_inst
        max_inst = node.getAttribute('maximumNumberOfInstances')
        if max_inst: max_inst = int(max_inst)
        else:        max_inst = graph.default_max_inst
        name_str = node.getAttribute('name')
        graph.nodes[name_str] = Node(name_str, node.getAttribute('type'),
            min_inst, max_inst)
    edges = input_xml.getElementsByTagName('edges')
    for edge in edges:
        min_inst = edge.getAttribute('minimumNumberOfInstances')
        if min_inst: min_inst = int(min_inst)
        else:        min_inst = graph.default_min_inst
        max_inst = edge.getAttribute('maximumNumberOfInstances')
        if max_inst: max_inst = int(max_inst)
        else:        max_inst = graph.default_max_inst
        name_str = edge.getAttribute('name')
        graph.edges[name_str] = Edge(name_str, edge.getAttribute('type'),
            edge.getAttribute('src'), edge.getAttribute('tgt'), min_inst, max_inst)
    return graph

def output_instgraph(quiet, graph, output_file_name):
    try:
        out_file = file(output_file_name, 'w')
    except IOError:
        print "Error: cannot write to file: ", out_file
        sys.exit(1)
    if not quiet: print "Writing output graph:", output_file_name

    print >> out_file, '<?xml version="1.0" encoding="ASCII"?>'
    print >> out_file, '<randommodel:RandomModel'
    print >> out_file, '    xmi:version="2.0"'
    print >> out_file, '    xmlns:xmi="http://www.omg.org/XMI"'
    print >> out_file, '    xmlns:randommodel="http://se.cs.toronto.edu/modelepedia/randommodel"'
    print >> out_file, '    name="{}"'.format(graph.name_str)
    print >> out_file, '    type="{}" >'.format(graph.type_str)
    for node in graph.nodes.itervalues():
        print >> out_file, '  <nodes name="{}"'.format(node.name_str)
        print >> out_file, '      type="{}"'.format(node.type_str),
        if node.may_anno: print >> out_file, '\n      may="true"',
        if node.var_anno: print >> out_file, '\n      var="true"',
        if node.set_anno: print >> out_file, '\n      set="true"',
        print >> out_file, '/>'
    for edge in graph.edges.itervalues():
        print >> out_file, '  <edges name="{}"'.format(edge.name_str)
        print >> out_file, '      type="{}"'.format(edge.type_str)
        if edge.may_anno: print >> out_file, '      may="true"'
        if edge.var_anno: print >> out_file, '      var="true"'
        if edge.set_anno: print >> out_file, '      set="true"'
        print >> out_file, '      src="{}"'.format(edge.src)
        print >> out_file, '      tgt="{}" />'.format(edge.tgt)
    print >> out_file, '</randommodel:RandomModel>'
    out_file.close()

#Output a file in the DOT language showing the graph for reading by Graphviz
def output_graphviz(quiet, graph, output_file_name):
    if not quiet: print "Writing output graph:", output_file_name
    try:
        out_file = file(output_file_name, 'w')
    except IOError:
        print "Error: cannot write to file: ", out_file
        sys.exit(1)
    elem_annotations = {}
    for elem in graph.nodes.values() + graph.edges.values():
        elem_annotations[elem] = elem.name_str
        anno_list = []
        if elem.may_anno: anno_list.append('m')
        if elem.var_anno: anno_list.append('v')
        if elem.set_anno: anno_list.append('s')
        if len(anno_list) > 0:
            elem_annotations[elem] += " ({})".format(', '.join(anno_list))
    print >> out_file, 'digraph S {'
    for node in graph.nodes.itervalues():
        print >> out_file, '  {} [label="{}"];'.\
            format(node.name_str, elem_annotations[node])
    for edge in graph.edges.itervalues():
        print >> out_file, '  "{}" -> "{}" [color="black", label="{}"];'.\
            format(edge.src, edge.tgt, elem_annotations[edge])
    print >> out_file, '}'
    out_file.close()

def generate_graphs(quiet, input_file_name, output_file_name, instance_name,
    output_type, annotated_fraction, may_fraction, var_fraction, set_fraction,
    seed=None):
    random.seed(seed)
    type_graph = input_typegraph(quiet, input_file_name)
    if type_graph.name_str == 'statemachine':
        instance_graph = state_machine.instantiate_graph(quiet, type_graph, instance_name)
        state_machine.annotate_graph(quiet, instance_graph, annotated_fraction,
            may_fraction, var_fraction, set_fraction)
    elif type_graph.name_str == 'LabeledGraph':
        instance_graph = labeled_graph.instantiate_graph(quiet, type_graph, instance_name)
        labeled_graph.annotate_graph(quiet, instance_graph, annotated_fraction,
            may_fraction, var_fraction, set_fraction)
    else:
        raise GeneratorException("Error: unknown type graph name: " + type_graph.name_str)
    if output_type == 'ecore':
        output_instgraph(quiet, instance_graph, output_file_name)
    elif output_type == 'graphviz':
        output_graphviz(quiet, instance_graph, output_file_name)
    else: assert False

if __name__ == '__main__':
    arg_processor = process_args()
    try:
        generate_graphs(arg_processor.quiet, arg_processor.input_file_name,
            arg_processor.output_file_name, arg_processor.instance_name,
            arg_processor.output_type, arg_processor.annotated_fraction,
            arg_processor.may_fraction, arg_processor.var_fraction,
            arg_processor.set_fraction, arg_processor.initial_seed)
    except GeneratorException as e:
        print e.message
        sys.exit(1)

