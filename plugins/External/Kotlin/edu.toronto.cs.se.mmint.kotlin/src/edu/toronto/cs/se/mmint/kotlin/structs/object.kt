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

sealed class ObjData {
    override fun toString(): String = this.uri()
}

sealed class VarObject : Object() {}

data class MkObjData(val uri : String, val kind: String, val attrs: Map<String, String>, val refs: Map<String, LList<Object>>) : ObjData() {
    override fun toString(): String = "URI: "+ this.uri() + ", KIND : " + this.kind() + ", ATTRS : " + this.attrs() + ", REFS : " + this.refs()
}

fun ObjData.uri() : String = when (this) { is MkObjData -> this.uri}

fun ObjData.kind() : String =
    when (this) {
        is MkObjData -> this.kind
    }

fun ObjData.attrs() : Map<String, String> =
    when (this) {
        is MkObjData -> this.attrs
    }

fun ObjData.refs() : Map<String, LList<Object>> =
    when (this) {
        is MkObjData -> this.refs
    }

fun ObjData.getAttr(s : String) : String? =
    when (this) {
        is MkObjData -> this.attrs[s]
    }

sealed class Object {
//    override fun toString(): String = "(" + this.data().uri() + "," + this.contains().toString()
}

data class MkObj(val data : ObjData, val contains : Map<String, LList<Object>>) : Object()
{
    override fun toString(): String = "(" + this.data().toString() + ", CHILDREN : " + this.contains().toString() + ")"
}

fun Object.data() : ObjData = when (this) { is MkObj -> this.data }

fun Object.contains() : Map<String,LList<Object>> = when (this) {is MkObj -> this.contains}

fun Object.children() : LList<Prod<String,LList<Object>>> =
    when(this) {
        is MkObj -> this.contains.toLList()
    }

fun Object.childrenFrom(container : String) : LList<Object> =
    when(val x = this.contains()[container]) {
        null -> Nil
        else -> x
    }

fun <a> Object.mapChildren(f : (Object) -> a) :  LList<Prod<String, LList<a>>> =
    this.children().map { MkProd(it.fst(), it.snd().map(f))}

fun <a> Object.mapAndWrap(f : (Object) -> a) : Map<String,LList<a>> =
    this.mapChildren(f).toMap()

fun Object.mapdata(f : (ObjData) -> ObjData) : Object =
    MkObj(f(this.data()), (this.mapAndWrap { x -> x.mapdata(f) }))

fun <a> Object.fold(f : (ObjData, LList<a>) -> a) : a  =
    f( this.data(), concatLists( this.children().map { it.snd()}).map { it.fold(f)})

fun Object.insertUnderNode(x: Object, container: String, parentURI: String): Object {
    if (this.data().uri() == parentURI) {
        val xURI = x.data().uri()
        println("inserting $xURI under parent $parentURI in container $container")
        return MkObj(this.data(), this.contains().addChild(container, x))
    }
    else
        return MkObj(this.data(), (this.mapAndWrap { o -> o.insertUnderNode(x, container, parentURI) }))
}

fun <a> Object.recurseOnChildrenToList(f : (Object) -> LList<a>) : LList<a> =
    concatLists(this.children().map { it -> concatLists(it.snd().map {o -> f(o) })} )


// TODO: refactor
fun Object.dynamicMaxSubtreesAsEdges(container : String, parent : String, p: (ObjData) -> Boolean) : LList<Prod<String,Prod<String,String>>> {
    val isNonMergeRoot = p(this.data())
    val children = this.children()
    if (isNonMergeRoot) {
        val curr = this.data().uri()
        return Cons(MkProd(container, MkProd(parent, this.data().uri())), Nil)
    }
    else {
        val foo = concatLists(concatLists(children.map { pr ->
            pr.snd().map { it.dynamicMaxSubtreesAsEdges(pr.fst(), this.data().uri(), p) }
        }))
        return foo
    }
}




fun Object.replaceNode(new : Object, oldURI : String) : Object =
    if (this.data().uri() == oldURI)
        new
    else
        MkObj(this.data(), this.mapAndWrap { it.replaceNode(new, oldURI) })

fun Object.getSubObject_(uri : String) : Object =
    when (val o = this.getSubObject(uri)) {
        is None -> MkObj(MkObjData("ERROR", "ERROR", mapOf(), mapOf()), mapOf())
        is Some -> o.x
    }

// Todo -- rewrite this
fun Object.getSubObject(uri : String) : Option<Object> =
     when (this) {
        is MkObj -> if (this.data.uri() == uri) Some(this)
        else
            this.children().foldl(
                { p: Prod<String, LList<Object>>, x: Option<Object> ->
                    if (x.isSome())
                        x
                    else
                        p.snd().foldl({ it, y: Option<Object> ->
                            if (y.isSome()) y else
                                it.getSubObject(uri)
                        }, None)
                }, None
            )
    }

fun Object.prettyPrint(containmentPath : String) {
    println("-----Object-------")
    println(" uri : " + this.data().uri())
    println(" ancestry : $containmentPath")
    println(" attrs : " )
    val attrIterator = this.data().attrs().entries.iterator()
    while (attrIterator.hasNext()){
        val i = attrIterator.next()
        val k = i.key
        val v = i.value
        println(" \t $k : $v ")
    }
    println(" refs : ")
    val refIterator = this.data().refs().entries.iterator()
    while (refIterator.hasNext()){
        val i = refIterator.next()
        val k = i.key
        val v = i.value.map {it.data().uri()}
        println(" \t $k : $v ")
    }
    println("------------------")

    val childrenIterator = this.contains().entries.iterator()
    while(childrenIterator.hasNext()){
        val i = childrenIterator.next()
        val container = i.key
        val v = i.value.toList()
        for(x in v){
            x.prettyPrint(containmentPath + ":" + this.data().uri() + ":" + container)
        }
    }
}
