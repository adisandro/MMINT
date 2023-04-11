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

fun finishMerge(left : ObjData, right : ObjData) : ObjData {
    val mergedURI = left.uri() + "_" + right.uri()
    val mergedKind = if (left.kind() == right.kind()) left.kind() else "KIND_ERROR"
    val mergedAttrs = left.attrs() + right.attrs()
    val mergedRefs = left.refs() + right.refs()
    return MkObjData(mergedURI, mergedKind, mergedAttrs, mergedRefs)
}

fun finishMergePL(left : ObjData, right : ObjData) : ObjData {
    val mergedURI = left.uri() + "_" + right.uri()
    val mergedKind = if (left.kind() == right.kind()) left.kind() else "KIND_ERROR"
    val leftPC = left.getAttr("presenceCondition")
    val rightPC = right.getAttr("presenceCondition")
    val newPC = "$leftPC | $rightPC"
    val mergedAttrs = (left.attrs() + right.attrs()).toMutableMap()
    mergedAttrs["presenceCondition"] = newPC
    val mergedRefs = left.refs() + right.refs()
    return MkObjData(mergedURI, mergedKind, mergedAttrs, mergedRefs)
}


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
    concatLists(t.children().map {c ->  concatLists(c.snd().map {it.dynamicMaxSubtreesAsEdges(c.fst(), root) {o-> !dict.containsValue(o.uri())}})})



fun swapParents(l : LList<Prod<String, Prod<String, String>>>, toMerge: Map<String, String>) :  LList<Prod<String, Prod<String, String>>> =
    when(l){
        is Nil -> Nil
        is Cons -> when (val h = l.head){
            is MkProd -> when (val o = toMerge[h.snd().fst()]){
                null -> Cons(h, swapParents(l.tail, toMerge))
                else -> Cons(MkProd(h.fst(), MkProd(o, h.snd().snd())), swapParents(l.tail, toMerge))
            }
        }
    }

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
    return t.insertUnderNode(source.getSubObject_(p.snd().snd()), p.fst(), p.snd().fst())
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

fun finishAux(f : (ObjData,ObjData) -> ObjData, leftObjData : ObjData, toMerge: Map<String, String>, uri2Obj : LList<Prod<String,Object>>) : ObjData =
    when (toMerge[leftObjData.uri()]) {
        null -> leftObjData
        else -> when (val o = uri2Obj.lookup(leftObjData.uri())){
            is None -> leftObjData
            is Some -> f(leftObjData, o.x.data())
        }
    }


// 3. replace the map (uri1, uri2) to map (uri1, obj2)
// 4. iterate through the tree, merging those nodes.

fun merge(model1: Object, model2: Object, toMerge: Map<String,String>): Object {
    // 1. Find roots of nonmerged subtrees in model 2
    val nonMergedRootsWithContainers = getNonMergedRoots(model2.data().uri(), toMerge, model2)
    // 2. Replace the "parents" of the nonmerge roots in above map to reflect targets in model1
    val withParentsInModel1 = swapParents(nonMergedRootsWithContainers, toMerge.reverse())
    // 3. Append nonmerge below their parents in model 1
    val withModel2Branches = insertNonMergedObjects(model1, withParentsInModel1, model2)
    // 3. Replace the map (uri1, uri2) to map (uri1, obj2)
    val uri12obj2 = toMerge.toLList().map { MkProd(it.fst(), model2.getSubObject_(it.snd()))}
    // 4. iterate through the tree, merging those nodes which are in merge relation
    return withModel2Branches.mapdata { finishAux(::finishMerge, it, toMerge, uri12obj2) }
}

fun mergePL(model1 : Object, model2 : Object, toMerge : Map<String,String>) : Object {
    val nonMergedRootsWithContainers = getNonMergedRoots(model2.data().uri(), toMerge, model2)
    val withParentsInModel1 = swapParents(nonMergedRootsWithContainers, toMerge.reverse())
    val withModel2Branches = insertNonMergedObjects(model1, withParentsInModel1, model2)
    val uri12obj2 = toMerge.toLList().map { MkProd(it.fst(), model2.getSubObject_(it.snd()))}
    return withModel2Branches.mapdata { finishAux(::finishMergePL, it, toMerge, uri12obj2) }
}

