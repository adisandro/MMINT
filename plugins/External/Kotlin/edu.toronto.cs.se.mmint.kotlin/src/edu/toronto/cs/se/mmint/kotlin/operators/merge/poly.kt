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

fun <a> getNonMergedRoots(root : String, dict : Map<String,String>, t : Tree<a>) : LList<Prod<String, Prod<String, String>>> =
    concatLists(t.children().map {c ->  concatLists(c.snd().map {it.dynamicMaxSubtreesAsEdges(c.fst(), root) {o-> !dict.containsValue(o.toString())}}) })

fun swapParents(l : LList<Prod<String, Prod<String, String>>>, toMerge: Map<String, String>) : LList<Prod<String, Prod<String, String>>> =
    when(l){
        is Nil -> Nil
        is Cons -> when (val h = l.head){
            is MkProd -> when (val o = toMerge[h.snd().fst()]){
                null -> Cons(h, swapParents(l.tail, toMerge))
                else -> Cons(MkProd(h.fst(), MkProd(o, h.snd().snd())), swapParents(l.tail, toMerge))
            }
        }
    }


fun <a> insertionAux (p : Prod<String, Prod<String, String>>, t : Tree<a>, source: Tree<a>) : Tree<a> =
    when(val o = source.getSubObject(p.snd().snd())) {
        is None -> source
        is Some -> {
            val op = p.snd().snd()
            val tgt = p.snd().fst()
            t.insertUnderNode(o.x, p.fst(),p.snd().fst())
        }
    }


fun <a> insertNonMergedObjects(tgt : Tree<a>, insertions : LList<Prod<String, Prod<String, String>>>, source : Tree<a>) : Tree<a> =
    insertions.foldl( {p, t -> insertionAux(p,t,source) },tgt)


fun <a> mergeMaps(left : MutableMap<String, LList<a>>, right : MutableMap<String, LList<a>>, cover : Map<String,String>) : MutableMap<String, LList<a>> {
    val coverRev = cover.reverse()
    val leftIt = left.entries.iterator()
    val merged = mutableMapOf<String, LList<a>>()
    while(leftIt.hasNext()){
        val entry = leftIt.next()
        val v1 = entry.value
        var newval = v1
        when (val v2 = right[entry.key]){
            null -> {newval = v1}
            else -> {
                for (o in v2.toList()){
                    if (!coverRev.containsKey(o.toString())){
                        newval = Cons(o,newval)
                    }
                }
            }
        }
        merged[entry.key]=newval
    }
    val rightIt = right.entries.iterator()
    while (rightIt.hasNext()){
        val entry = rightIt.next()
        if (!left.containsKey(entry.key))
            merged[entry.key] = entry.value
    }
    return merged
}

fun <a,b> updateMap(map : MutableMap<a,LList<b>>, from : LList<Prod<a, b>>):  MutableMap<a,LList<b>> {
    val refsIt = map.entries.iterator()
    val newRefs = mutableMapOf<a,LList<b>>()
    while(refsIt.hasNext()){
        val entry = refsIt.next()
        val objs = entry.value.toList()
        val newObjs : MutableList<b> = mutableListOf()
        for (o in objs){
            when (val new = from.lookup(o.toString())){
                is None -> newObjs.add(o)
                is Some -> {
                    newObjs.add(new.x)
                }
            }
        }
        newRefs[entry.key] = newObjs.toList().toLList()
    }
    return newRefs
}

fun <a> checkAndMerge(
    f: (a, a) -> a,
    leftObject: a,
    toMerge: Map<String, String>,
    uri2Obj: LList<Prod<String, Tree<a>>>
): a {
    val v = leftObject.toString()
    return when (toMerge[leftObject.toString()]) {
        null -> leftObject
        else -> when (val o = uri2Obj.lookup(leftObject.toString())) {
            is None -> leftObject
            is Some -> f(leftObject, o.x.node())
        }
    }
}
