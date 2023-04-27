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


fun mergeAttrs(left : Map<String,String>, right : Map<String,String>) : MutableMap<String,String> {
    val leftIt = left.entries.iterator()
    val newAttrs = mutableMapOf<String,String>()
    while(leftIt.hasNext()){
        val entry = leftIt.next()
        val v1 = entry.value
        val newv = when (val v2 = right[entry.key]) {
            null -> v1
            else -> v1+"_"+v2
        }
        newAttrs[entry.key]=newv
    }
    val rightIt = right.entries.iterator()
    while (rightIt.hasNext()){
        val entry = rightIt.next()
        if (!left.containsKey(entry.key))
            newAttrs[entry.key] = entry.value
    }
    return newAttrs
}

fun getMergeURImap(dict : LList<Prod<String,String>>) : LList<Prod<String,String>> =
    when (dict) {
        is Nil -> Nil
        is Cons ->
            Cons(MkProd(dict.head.fst(), mergeURI(dict.head.fst(),dict.head.snd())), Cons(MkProd(dict.head.snd(), mergeURI(dict.head.fst(),dict.head.snd())), getMergeURImap(dict.tail)))
    }

fun <a> LList<MkProd<String, Option<a>>>.noJunk() :  LList<MkProd<String,a>> =
    when (this){
        is Nil -> Nil
        is Cons -> when (val o = this.head.snd()) {
            is None -> this.tail.noJunk()
            is Some -> Cons(MkProd(this.head.fst,o.x) , this.tail.noJunk())
        }
    }
