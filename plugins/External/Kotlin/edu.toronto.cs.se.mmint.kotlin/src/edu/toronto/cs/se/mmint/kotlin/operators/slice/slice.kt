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
package edu.toronto.cs.se.mmint.kotlin.operators.slice

import edu.toronto.cs.se.mmint.kotlin.structs.*


enum class SliceRule {
    Children
}

fun SliceRule.toSlice(o : Object) : LList<Object> =
    when (this) {
        SliceRule.Children ->
                concatLists(o.children().map { p -> p.snd()})
    }

fun predCons (p: (ObjData) -> Boolean, o : Object, l : LList<ObjData>) : LList<ObjData> =
    if (p(o.data()))
        Cons(o.data(), l)
    else
        l


fun Object.slice(rule : SliceRule, p : (ObjData) -> Boolean) : LList<ObjData> {
    val newChildren = rule.toSlice(this)
    val newChildrenSet = newChildren.map {it.data()} .filter(p)
    return append(newChildrenSet, concatLists(newChildren.map {it.slice(rule,p)}))
}

fun slice(model : Object, init : LList<Object>, rule : SliceRule, p : (ObjData) -> Boolean) : LList<ObjData> {
    val initDataSet = init.map {it.data()}
    val sliceSetsPerObj = init.map {it.slice(rule,p)}
    return append(initDataSet, concatLists(sliceSetsPerObj))
}

