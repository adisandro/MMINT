/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro, Logan Murphy.
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

sealed class Tree<out a> {}

data class MkTree <out a> (val node : a, val contains : Map<String,LList<Tree<a>>>) : Tree<a>(){
    override fun toString(): String {
        return this.node.toString()
    }
}


fun <a> Tree<a>.node() : a = when (this) { is MkTree -> this.node }

fun <a> Tree<a>.contains() : Map<String,LList<Tree<a>>> = when (this) {is MkTree -> this.contains}

fun <a> Tree<a>.children() : LList<Prod<String,LList<Tree<a>>>> =
    when(this) {
        is MkTree -> this.contains.toLList()
    }

fun <a,b> Tree<a>.mapChildren(f : (Tree<a>) -> b) :  LList<Prod<String, LList<b>>> =
    this.children().map { MkProd(it.fst(), it.snd().map(f))}

fun <a,b> Tree<a>.mapAndWrap(f : (Tree<a>) -> b) : Map<String,LList<b>> =
    this.mapChildren(f).toMap()

fun <a,b> Tree<a>.mapdata(f : (a) -> b) : Tree<b> =
    MkTree(f(this.node()), (this.mapAndWrap  {it.mapdata(f)}))

// Parent could be object data
fun <a> Tree<a>.insertUnderNode(x: Tree<a>, container: String, parent: String): Tree<a> =
    if (this.node().toString() == parent) {
         MkTree(this.node(), this.contains().addChild(container, x))
    }
    else
         MkTree(this.node(), (this.mapAndWrap { o -> o.insertUnderNode(x, container, parent) }))

fun <a> Tree<a>.dynamicMaxSubtreesAsEdges(container : String, parent : String, p: (a) -> Boolean) : LList<Prod<String,Prod<String,String>>> {
    val isNonMergeRoot = p(this.node())
    val children = this.children()
    if (isNonMergeRoot) {
        val curr = this.node().toString()
        return Cons(MkProd(container, MkProd(parent, this.node().toString())), Nil)
    }
    else {
        val foo = concatLists(concatLists(children.map { pr ->
            pr.snd().map { it.dynamicMaxSubtreesAsEdges(pr.fst(), this.node().toString(), p) }
        }))
        return foo
    }
}


fun <a> Tree<a>.getSubObject(uri : String) : Option<Tree<a>> =
    when (this) {
        is MkTree -> if (this.node.toString() == uri) Some(this)
        else
            this.children().foldl(
                { p: Prod<String, LList<Tree<a>>>, x: Option<Tree<a>> ->
                    if (x.isSome())
                        x
                    else
                        p.snd().foldl({ it, y: Option<Tree<a>> ->
                            if (y.isSome()) y else
                                it.getSubObject(uri)
                        }, None)
                }, None
            )
    }

//
//fun Tree<Object>.prettyPrint(containmentPath : String) {
//    println("-----Object-------")
//    println(" uri : " + this.node().uri())
//    println(" ancestry : $containmentPath")
//    println(" attrs : " )
//    println(" kind : " + this.node().kind() )
//    val attrIterator = this.node().attrs().entries.iterator()
//    while (attrIterator.hasNext()){
//        val i = attrIterator.next()
//        val k = i.key
//        val v = i.value
//        println(" \t $k : $v ")
//    }
//    println(" refs : ")
//    val refIterator = this.node().refs().entries.iterator()
//    while (refIterator.hasNext()){
//        val i = refIterator.next()
//        val k = i.key
//        val v = i.value.map {it.node().uri()}
//        println(" \t $k : $v ")
//    }
//    println("------------------")
//
//    val childrenIterator = this.contains().entries.iterator()
//    while(childrenIterator.hasNext()){
//        val i = childrenIterator.next()
//        val container = i.key
//        val v = i.value.toList()
//        for(x in v){
//            x.prettyPrint(containmentPath + ":" + this.node().uri() + ":" + container)
//        }
//    }
//}
//
fun Tree<VarObj>.prettyPrintVar(containmentPath : String) {
    println("-----Object-------")
    println(" PC : " + this.node().pcond)
    println(" uri : " + this.node().uri)
    println(" ancestry : $containmentPath")
    println(" attrs : " )
    println(" kind : " + this.node().kind )
    val attrIterator = this.node().attrs.entries.iterator()
    while (attrIterator.hasNext()){
        val i = attrIterator.next()
        val k = i.key
        val v = i.value
        println(" \t $k : $v ")
    }
    println(" refs : ")
    val refIterator = this.node().refs.entries.iterator()
    while (refIterator.hasNext()){
        val i = refIterator.next()
        val k = i.key
        val v = i.value.map {it.node().uri}
        println(" \t $k : $v ")
    }
    println("------------------")

    val childrenIterator = this.contains().entries.iterator()
    while(childrenIterator.hasNext()){
        val i = childrenIterator.next()
        val container = i.key
        val v = i.value.toList()
        for(x in v){
            x.prettyPrintVar(containmentPath + ":" + this.node().uri + ":" + container)
        }
    }
}
