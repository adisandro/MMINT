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
package edu.toronto.cs.se.mmint.kotlin.structs

//sealed class PC() {
//    override fun toString(): String {
//        when(this) {
//            is Atom -> return this.a
//            is Or ->  {
//                val left = this.a
//                val right = this.b
//                return "$left | $right"
//            }
//        }
//    }
//}
//
//data class Atom(val a : String) : PC()
//data class Or(val a: PC, val b : PC) : PC() {
//    override fun toString(): String {
//        return "$a | $b"
//    }
//}

sealed class Var<out a> {
    override fun toString(): String {
        return when (this) {
            is MkVar -> this.x.toString()
        }
    }
}


data class MkVar<out a> (val pcond : String, val x : a) : Var<a>()

//fun <a> Var<a>.pc() : PC =
//    when (this){
//        is MkVar -> this.pcond
//    }


sealed class VarObj {
    override fun toString(): String {
        return when(this) {
            is MkVarObj -> this.uri
        }
    }
}
//data class MkVarObj(val pcond : PC, val x : Object) : VarObj() {
//    override fun toString(): String {
//        return this.x.toString()
//    }
//
//    override fun equals(other: Any?): Boolean
//    = other is MkVarObj && other.x == x
//
//}

data class MkVarObj(val pcond : String, val uri : String, val kind: String, val attrs: MutableMap<String, String>, val refs: MutableMap<String, LList<Tree<VarObj>>>) : VarObj() {
    override fun toString(): String = uri
    override fun equals(other: Any?): Boolean
            = other is MkVarObj && uri == other.uri
}

fun <a> Var<a>.pc() : String = when (this) { is MkVar -> this.pcond }
fun <a> Var<a>.value() : a = when (this) { is MkVar -> this.x }

fun Or(left : String, right : String) : String = "$left | $right"


fun VarObj.pc() : String = when (this) {is MkVarObj -> this.pcond}

fun VarObj.uri() : String = when (this) { is MkVarObj -> this.uri}

fun VarObj.kind() : String =
    when (this) {
        is MkVarObj -> this.kind
    }

fun VarObj.attrs() : MutableMap<String, String> =
    when (this) {
        is MkVarObj -> this.attrs
    }

fun VarObj.refsPL() : MutableMap<String, LList<Tree<VarObj>>> =
    when (this) {
        is MkVarObj -> this.refs
    }

fun VarObj.getAttr(s : String) : String? =
    when (this) {
        is MkVarObj -> this.attrs[s]
    }

fun VarObj.setRefsPL(map: MutableMap<String,LList<Tree<VarObj>>>) {
    this.refsPL().putAll(map)
}

fun VarObj.toObject() : Object {
    val attrs = this.attrs()
    attrs["presenceCondition"] = this.pc()
    return MkObject(
        this.uri(),
        this.kind(),
        attrs,
        this.refsPL().toLList().map { p -> MkProd(p.fst(), p.snd().map { it.mapdata { x -> x.toObject() } }) }.toMap()
            .toMutableMap())
}

fun Object.toVarObj() : VarObj {
    when(this){
        is MkObject ->
            if (this.attrs().containsKey("presenceCondition")){
                val pc = this.attrs()["presenceCondition"]
                return when(pc) {
                    null -> MkVarObj("true", this.uri(), this.kind(), this.attrs().toMutableMap(),this.refs().toLList().map { p -> MkProd(p.fst(), p.snd().map {it.mapdata { x -> x.toVarObj() }})} .toMap().toMutableMap())
                    else -> {
                        this.attrs().minus("presenceCondition")
                        MkVarObj(pc, this.uri(), this.kind(), this.attrs().toMutableMap(),this.refs().toLList().map {p -> MkProd(p.fst(), p.snd().map {it.mapdata { x -> x.toVarObj() }})} .toMap().toMutableMap())
                    }
                }

            }
        else {
               return MkVarObj("true", this.uri(), this.kind(), this.attrs().toMutableMap(),this.refs().toLList().map { p -> MkProd(p.fst(), p.snd().map {it.mapdata { x -> x.toVarObj() }})} .toMap().toMutableMap())
            }
    }
}
//
//fun toVarObject(pc : String, obj : Object) : VarObj =
//    MkVarObj(pc, obj.uri(), obj.kind(), obj.attrs().toMutableMap(), obj.refs().toMutableMap())

fun Tree<VarObj>.toTreeObj() : Tree<Object> =
    this.mapdata { it.toObject() }

fun Tree<Object>.toTreeVarObj() : Tree<VarObj> =
    this.mapdata { it.toVarObj()}

