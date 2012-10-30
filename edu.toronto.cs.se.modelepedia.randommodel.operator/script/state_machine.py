#File:        state_machine.py
#Author:      Nathan Robinson
#Contact:     nathan.m.robinson@gmail.com
#Date:        2012-07-10
#Desctiption: This module contains functions to generate and MAVO annotate
#             instances of type graphs that represent state-machines.
#             It implements the following functions:
#             inst_graph = instantiate_graph(quiet, type_graph, name_str)
#             annotate_graph(quiet, instance_graph, annotated_fraction,
#                 may_fraction, var_fraction, set_fraction)

import random
from graph import Graph, Node, Edge

def set_seed(seed):
    random.seed(seed)
    
def instantiate_graph(quiet, type_graph, name_str):
    if not quiet: print "Producing instantiation."
    inst_graph = Graph(name_str, type_graph.name_str)
    nodes_by_type = {}
    for node in type_graph.nodes.itervalues():
        no_insts = random.randint(node.min_inst, node.max_inst)
        nodes_by_type[node.name_str] = []
        for inst in xrange(1,no_insts+1):
            name_str = node.name_str + str(inst)
            i_node = Node(name_str, node.name_str)
            nodes_by_type[node.name_str].append(i_node)
            inst_graph.nodes[name_str] = i_node
    edges_by_type = {}
    for edge in type_graph.edges.itervalues():
        #In this model there is excatly one source and one target for every
        #Transition, so we ignore edge.min_inst and edge.max_inst
        no_insts = len(nodes_by_type['Transition'])
        edges_by_type[edge.name_str] = []
        for inst in xrange(1,no_insts+1):
            name_str = edge.name_str + str(inst)
            i_edge = Edge(name_str, edge.name_str, None, None)
            edges_by_type[edge.name_str].append(i_edge)
            inst_graph.edges[name_str] = i_edge
    #forall(a:Transition).(existsOne(x:source).(x.src=a) and
        #existsOne(y:target).(y.src=a)
    for node in nodes_by_type['Transition']:
       random.choice(filter(lambda x: x.src==None,
           edges_by_type['source'])).src = node.name_str
       random.choice(filter(lambda x: x.src==None,
           edges_by_type['target'])).src = node.name_str
    #forall(x:source).existsOne(t:Transition; s:State).(x.src=t and x.tgt=s)
    for edge in edges_by_type['source']:
        edge.tgt = random.choice(nodes_by_type['State']).name_str
    #forall(x:target).existsOne(t:Transition; s:State).(x.src=t and x.tgt=s)
    for edge in edges_by_type['target']:
        edge.tgt = random.choice(nodes_by_type['State']).name_str
    return inst_graph

#Remove and return a element of the sequence seq, selected uniformly at random
#assumes seq non-empty
def take_random(seq):
    elem = random.choice(seq)
    seq.remove(elem)
    return elem

#This does not currently respect any rules about the placement of annotations
def annotate_graph(quiet, instance_graph, annotated_fraction, may_fraction,
    var_fraction, set_fraction):
    if annotated_fraction == 0: return
    elements = instance_graph.nodes.values() + instance_graph.edges.values()
    to_annotate = []
    for i in xrange(int(round(annotated_fraction * len(elements)))):
        to_annotate.append(take_random(elements))
    to_may = list(to_annotate)
    for i in xrange(int(round(may_fraction * len(to_annotate)))):
        take_random(to_may).may_anno = True
    to_var = list(to_annotate)
    for i in xrange(int(round(var_fraction * len(to_annotate)))):
        take_random(to_var).var_anno = True
    to_set = list(to_annotate)
    for i in xrange(int(round(set_fraction * len(to_annotate)))):
        take_random(to_set).set_anno = True
  
