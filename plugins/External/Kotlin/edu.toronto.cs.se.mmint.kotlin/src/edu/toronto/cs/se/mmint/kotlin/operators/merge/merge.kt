/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro, Logan Murphy.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Logan Murphy - Implementation
 *     Alessio Di Sandro - Integration
 *******************************************************************************/
package edu.toronto.cs.se.mmint.kotlin.operators.merge

import edu.toronto.cs.se.mmint.kotlin.structs.*

/**
 * This is basically modelFactory.create() . It just makes a new model with a fresh URI to indicate that it is a merge node.
 */
fun prepareMerge(src : ObjData) : ObjData =
   MkObjData(src.uri()+"M?", src.kind(), src.attrs(), src.refs())

/**
 * This can be used to do arbitrary merging of the attributes and references of an Object. Right now it just
 * appends "done" as part of the URI
 */

fun mergeAttrs(left : Map<String,String>, right : Map<String,String>) : Map<String,String> = left
fun mergeRefs(left :  Map<String,LList<Object>>, right : Map<String,LList<Object>>) : Map<String, LList<Object>> = left

fun finishMerge(left : ObjData, right : ObjData) : ObjData =
    MkObjData(left.uri()+"_done", left.kind(), left.attrs(), left.refs())


/**
 *  This function corresponds broadly to lines 183-192 of merge.java.
 *  f is some sort of initialization of a merge node. E.g. `prepareMerge` above
 *  x is some source model (right now, model 1)
 *  toMerge is the merge relation (URI to URI)
 *  We return a pair with
 *  a) model x with each subObject which is in toMerge replaced with f(x)
 *  b) A mapping from merge model objects to model 1 objects
 *
 *  This implementation can probably be refactored.
 */

fun emplaceMergeNodesAndGetMapping(f : (ObjData) -> ObjData, x : Object, toMerge : Map<String,String>): Prod<Object, LList<Prod<Object, ObjData>>> =
    when(x) {
        is MkObj -> {
            val mergedNode = if (toMerge.containsKey(x.data().uri())) f(x.data()) else x.data()
            val recurseResults  = x.mapChildren { it -> emplaceMergeNodesAndGetMapping(f,it,toMerge)}
            val children  = recurseResults.map {MkProd(it.fst(), it.snd().unzip().fst())}
            val collectedMapping = concatLists(concatLists(recurseResults.unzip().snd()).unzip().snd())
            val newMapping = if (toMerge.containsKey(x.data().uri())) Cons(MkProd(MkObj(mergedNode, children.toMap()), x.data()), collectedMapping) else collectedMapping
            MkProd(MkObj(mergedNode, children.toMap()), newMapping)
        }
    }


/**
 * This function takes
 *  - mergedObjs, a mapping from MergedObjects to model 1 objects
 *  - toMerge, the original merge specification
 *
 *  For each pair (x, y) of merged objects and model 1 objects, respectively,
 *  get the "partner" z of y in model2.
 *  return list of such (z, x) pairs
 *  i.e. returns a mapping from model2 URIs to mergedObjects
 */
fun getMappingForModel2(mergedObjs : LList<Prod<Object, ObjData>>, toMerge: Map<String, String>) : LList<Prod<String, Object>> =
    when(mergedObjs) {
        is Nil -> Nil
        is Cons -> when(val x : String? = toMerge[mergedObjs.head.snd().uri()]){
            null -> getMappingForModel2(mergedObjs.tail, toMerge) //  Note: Should be unreachable!
            else -> Cons(MkProd(x, mergedObjs.head.fst()), getMappingForModel2(mergedObjs.tail, toMerge))
        }
    }


// NOTE : Right now, this does not consider whether roots need to be merged, since they're always merged.
fun getNonMergedRoots(root : String, dict : Map<String,String>, t : Object) : LList<Prod<String,Prod<String,String>>> =
    concatLists(t.containments().map {c ->  t.collectMaxSubtreesAsEdges(c, root) { !dict.containsValue(it.uri())}})

/**
 * Given
 *  mergedObjs : a mapping from merged objects to model 1 objects, and
 *  toMerge : the merge specification, and
 *  model : an Object,
 *  for each pair (x,y) in mergedObjs, return  (x,y,z), where z is the (internal) data of the object whose URI is associated to y.
 *  This allows us to easily call finishMerge (or whatever function you want) by mapping over the containment structure
 */
fun Merged2Sources(mergedObjs : LList<Prod<Object, ObjData>>, toMerge : Map<String,String>, model : Object) : LList<Prod<ObjData,Prod<ObjData, ObjData>>>  =
    when(mergedObjs) {
        is Nil -> Nil
        is Cons -> when(val x = toMerge[mergedObjs.head.snd().uri()]) {
            null -> Merged2Sources(mergedObjs.tail,toMerge, model)
            else -> when(val o = model.getSubObject(x)) {
                is None -> Merged2Sources(mergedObjs.tail,toMerge, model)
                is Some -> Cons(MkProd(mergedObjs.head.fst().data(), MkProd(mergedObjs.head.snd(), o.x.data())),Merged2Sources(mergedObjs.tail,toMerge, model))
            }
        }
    }

fun insertionAux (p : Prod<String, Prod<String,String>>, t : Object, source: Object) : Object {
    return t.insertUnderNode(source.getSubObject_(p.snd().fst()), p.fst(), p.snd().snd())
}


fun insertNonMergedObjects(tgt : Object, insertions : LList<Prod<String,Prod<String,String>>>, source : Object) : Object =
    insertions.foldl( {p, t -> insertionAux(p,t,source) },tgt)


/**
 * Given
 * l1 : a mapping from model2 URis to merged objects, and
 * l2 : a mapping from container names to URI's belonging to non-merged nodes and their (merge node) parents, respectively,
 * replace the merge node parents in l2 with the corresponding merged object in l1
 */
fun step3Again(l1 : LList<Prod<String, Object>>, l2 :  LList<Prod<String, Prod<String, String>>>) :  LList<Prod<String, Prod<String, String>>> =
    when (l2) {
        is Nil -> Nil
        is Cons -> when(val o : Option<Object> = l1.lookup(l2.head.snd().fst())){
            is None -> step3Again(l1, l2.tail) // Should be unreachable
            is Some -> Cons(
                MkProd(l2.head.fst(), MkProd(l2.head.snd().snd(), o.x.data().uri())), step3Again(l1, l2.tail))
        }
    }

fun finishAux(dict : LList<Prod<ObjData, Prod<ObjData, ObjData>>>, f : (ObjData, ObjData) -> ObjData, curr : ObjData) : ObjData =
    when (val o = dict.lookup(curr)) {
        is None -> curr
        is Some -> f(o.x.fst(),o.x.snd())
    }

fun merge(model1: Object, model2: Object, toMerge: Map<String,String>): Object {
    val init = emplaceMergeNodesAndGetMapping(::prepareMerge, model1, toMerge)
    val mergeModel = init.fst()
    val mergedObjs = init.snd()
    val model2Mapping = getMappingForModel2(mergedObjs, toMerge)
    val nonMergedRootsWithContainers = getNonMergedRoots("root2", toMerge, model2) // TODO: fix this
    val mapping2Merged = step3Again(model2Mapping, nonMergedRootsWithContainers)
    val withNonMergedNodes = insertNonMergedObjects(mergeModel, mapping2Merged, model2)
    val merged2sources = Merged2Sources(mergedObjs, toMerge, model2)
    return withNonMergedNodes.mapdata{ finishAux(merged2sources,::finishMerge,it)}
}
