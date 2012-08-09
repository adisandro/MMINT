#File:        graph.py
#Author:      Nathan Robinson
#Contact:     nathan.m.robinson@gmail.com
#Date:        2012-07-10
#Desctiption: An simple MAV annotated digraph model. This model is used to
#             represent both type graphs and MAV annotated instances of type
#             graphs.

class Graph:
    def __init__(self, name_str, type_str, default_min_inst=0, default_max_inst=0):
        self.name_str = name_str
        self.type_str = type_str
        self.default_min_inst = default_min_inst
        self.default_max_inst = default_max_inst
        self.nodes = {}
        self.edges = {}

class Node:
    def __init__(self, name_str, type_str, min_inst=0, max_inst=0):
        self.name_str = name_str
        self.type_str = type_str
        self.min_inst = min_inst
        self.max_inst = max_inst
        self.may_anno = False
        self.var_anno = False
        self.set_anno = False

class Edge:
    def __init__(self, name_str, type_str, src, tgt, min_inst=0, max_inst=0):
        self.name_str = name_str
        self.type_str = type_str
        self.src = src
        self.tgt = tgt
        self.min_inst = min_inst
        self.max_inst = max_inst
        self.may_anno = False
        self.var_anno = False
        self.set_anno = False

