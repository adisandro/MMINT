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


/*****************************/

fun checkAndMerge(f : (Object, Object) -> Object, leftObject : Object, toMerge: Map<String, String>, uri2Obj : LList<Prod<String,Tree<Object>>>) : Object =
    when (toMerge[leftObject.toString()]) {
        null -> leftObject
        else -> when (val o = uri2Obj.lookup(leftObject.toString())){
            is None -> leftObject
            is Some -> f(leftObject, o.x.node())
        }
    }

fun checkAndMergePL(f : (VarObj, VarObj) -> VarObj, leftObject : VarObj, toMerge: Map<String, String>, uri2Obj : LList<Prod<String, Tree<VarObj>>>) : VarObj =
    when (toMerge[leftObject.toString()]) {
        null -> leftObject
        else -> when (val o = uri2Obj.lookup(leftObject.toString())){
            is None -> leftObject
            is Some -> f(leftObject, o.x.node())
        }
    }

fun checkAndMergeVar(f : (Var<Object>, Var<Object>) -> Var<Object>, left : Var<Object>, toMerge : Map<String,String>, uri2Obj : LList<Prod<String, Tree<Var<Object>>>>) : Var<Object> =
    when (toMerge[left.toString()]) {
        null -> left
        else -> when (val o = uri2Obj.lookup(left.toString())){
            is None -> left
            is Some -> f(left, o.x.node())
        }
    }

/*****************************/

fun union(toMerge: Map<String, String>, mergedObjs: LList<Prod<String, String>>, left : Object, right : Object) : Object {
    val mergedURI = when(val o = mergedObjs.lookup(left.uri())) {
        is None -> left.uri()
        is Some -> o.x
    }
    val mergedKind = if (left.kind() == right.kind()) left.kind() else "KIND_ERROR"
    val mergedAttrs = mergeAttrs(left.attrs(),right.attrs())
    val mergedRefs = mergeMaps(left.refs(),right.refs(), toMerge)
    return MkObject(mergedURI, mergedKind, mergedAttrs, mergedRefs)
}

fun unionPL(toMerge: Map<String, String>, mergedObjs: LList<Prod<String, String>>, left : VarObj, right : VarObj, reasoner: ISATReasoner) : VarObj {
    val mergedURI = when(val o = mergedObjs.lookup(left.uri())) {
        is None -> left.uri()
        is Some -> o.x
    }
    val mergedKind = if (left.kind() == right.kind()) left.kind() else "KIND_ERROR"
    val mergedAttrs = mergeAttrs(left.attrs(),right.attrs())
    val mergedRefs = mergeMaps(left.refsPL(),right.refsPL(), toMerge)
    val mergedPC = reasoner.simplify(reasoner.orSyntax.replace("$1", left.pc()).replace("$2", right.pc()))
    return MkVarObj(mergedPC, mergedURI, mergedKind, mergedAttrs, mergedRefs)
}

/*****************************/

fun replaceRefs(model : Tree<Object>, mergeMap : LList<Prod<String,Tree<Object>>>) : Unit {
    model.node().setRefs(updateMap(model.node().refs(), mergeMap))
    model.children().map { it.snd().map {o -> replaceRefs(o, mergeMap) }}
}

fun replaceRefsPL(model : Tree<VarObj>, mergeMap : LList<Prod<String,Tree<VarObj>>>) : Unit {
    model.node().setRefsPL(updateMap(model.node().refsPL(), mergeMap))
    model.children().map { it.snd().map {o -> replaceRefsPL(o, mergeMap) }}
}
/*****************************/
