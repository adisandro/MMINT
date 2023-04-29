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
import edu.toronto.cs.se.mmint.mid.reasoning.ISATReasoner

/**
 * This can be used to do arbitrary merging of the attributes and references of an Object. Right now it just
 * appends "done" as part of the URI
 */


fun mergeURI(left : String, right : String) :String = left + "_" + right


fun merge(model1: Tree<Object>, model2: Tree<Object>, toMerge: Map<String,String>): Tree<Object> {
    // -1. add roots to merge relation
    val tm : MutableMap<String,String> = toMerge.toMutableMap()
    tm[model1.node().uri] = model2.node().uri

    // 1. Find roots of nonmerged subtrees in model 2
    // has form (container, (parent, node))
    val nonMergedRootsWithContainers = getNonMergedRoots(model2.node().uri, tm, model2)
    // 2. Replace the "parents" of the nonmerge roots in above map to reflect targets in model1
    val withParentsInModel1 = swapParents(nonMergedRootsWithContainers, tm.reverse())
    // 3. Append nonmerge below their parents in model 1
    val withModel2Branches = insertNonMergedObjects(model1, withParentsInModel1, model2)
    // 3. Replace the map (uri1, uri2) to map (uri1, obj2)
    val uri12obj2 = tm.toLList().map { MkProd(it.fst(), model2.getSubObject(it.snd()))} .noJunk()
    // 0. Populate a map from model1/model2 URIs to merged model URIs
    val mergeURImap = getMergeURImap(tm.toLList())
    // 4. iterate through the tree, merging those nodes which are in merge relation
    val mergeModel = withModel2Branches.mapdata { checkAndMerge({ o, p -> Object.union(toMerge, mergeURImap, o,p) }, it, tm, uri12obj2) }
    val mergeObjMap = mergeURImap.map {MkProd(it.fst(), mergeModel.getSubObject(it.snd()))} .noJunk()
    // 5. Iterate through the merged model again, this time replacing referenced objects with merged ones (where applicable)
    Object.replaceRefs(mergeModel, mergeObjMap)
    return mergeModel
}



fun mergePL(model1 : Tree<Object>, model2 : Tree<Object>, toMerge : Map<String,String>, reasoner : ISATReasoner) : Tree<Object> {
    val tm : MutableMap<String,String> = toMerge.toMutableMap()
    tm[model1.node().toString()] = model2.node().toString()
    val mergeURImap = getMergeURImap(tm.toLList())
    val nonMergedRootsWithContainers = getNonMergedRoots(model2.node().toString(), tm, model2)
    val withParentsInModel1 = swapParents(nonMergedRootsWithContainers, tm.reverse())
    val withModel2Branches = insertNonMergedObjects(model1, withParentsInModel1, model2)
    val uri12obj2 = tm.toLList().map { MkProd(it.fst(), model2.getSubObject(it.snd())) } .noJunk()
    val mergeModel =  withModel2Branches.mapdata { checkAndMerge({ o, p -> Object.unionPL(toMerge, mergeURImap, o,p, reasoner) }, it, tm, uri12obj2) }
    val mergeObjMap = mergeURImap.map {MkProd(it.fst(), mergeModel.getSubObject(it.snd()))} .noJunk()
    Object.replaceRefs(mergeModel, mergeObjMap)
    return mergeModel
}
