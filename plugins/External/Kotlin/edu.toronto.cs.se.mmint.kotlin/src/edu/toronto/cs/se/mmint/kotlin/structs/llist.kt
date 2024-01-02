/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro, Logan Murphy.
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


sealed class LList<out a> {
    companion object {
        fun <a> of(vararg args: a): LList<a> {
            val tail = args.sliceArray(1 until args.size)
            return if (args.isEmpty()) Nil else Cons(args[0], of(*tail))
        }
    }
}



object Nil : LList<Nothing>() {
    override fun toString(): String = ""
}
data class Cons <out a> (val head : a, val tail : LList<a>) : LList<a>() {
    override fun toString(): String =
        when(tail) {
            is Nil -> "$head"
            is Cons -> "$head:$tail"
        }
}

fun <a> LList<a>.length() : Int =
    when (this){
        is Nil -> 0
        is Cons -> 1 + this.tail.length()
    }

// unsafe
fun <a> LList<a>.toList() : List<a> {
    return when (this) {
        is Nil -> mutableListOf<a>()
        is Cons -> mutableListOf<a>(this.head) + this.tail.toList()
    }
}

// unsafe
fun <a> List<a>.toLList() : LList<a> {
    if (this.isEmpty()) return Nil
    else
       return Cons(this[0], this.drop(1).toLList())
}

fun <a> LList<a>.filter(p : (a) -> Boolean) : LList<a> =
    when(this) {
        is Nil -> Nil
        is Cons -> if (p(this.head)) Cons(this.head, this.tail.filter(p))
                   else this.tail.filter(p)
    }


// List operators

fun <a> append(list1 : LList<a>, list2 : LList<a>) : LList<a> =
    when(list1) {
        is Nil -> list2
        is Cons -> Cons(list1.head, append(list1.tail, list2))
    }

fun <a, b> LList<a>.map(f: (a) -> b): LList<b> =
    when (this) {
        is Nil -> Nil
        is Cons -> Cons(f(this.head), this.tail.map(f))
    }

fun <a, b> LList<a>.foldr(f : (a,b) -> b, init : b ): b =
    when (this) {
        is Nil -> init
        is Cons -> f(this.head, this.tail.foldr(f,init))
    }

fun <a, b> LList<a>.foldl(f : (a,b) -> b, init : b): b =
    when (this) {
        is Nil -> init
        is Cons -> this.tail.foldl(f, f(this.head, init))
    }


// Dict/Map/AssocList operators

fun <a,b>  LList<Prod<a,b>>.unzip() : Prod<LList<a>,LList<b>> =
    this.foldr({a: Prod<a,b>, b: Prod<LList<a>,LList<b>> -> MkProd(Cons(a.fst(),b.fst()),Cons(a.snd(),b.snd()))},MkProd(Nil,Nil))

fun <a> concatLists(lists : LList<LList<a>>) : LList<a> =
    lists.foldr(::append, Nil)

fun <a,b> LList<Prod<a,b>>.lookup(key:a) : Option<b> =
    when (this) {
        is Cons -> if (this.head.fst() == key) Some(this.head.snd()) else this.tail.lookup(key)
        is Nil -> None
    }

fun <a,b> LList<Prod<a,b>>.lookupVal( v:b) : Option<a> =
    when (this) {
        is Cons -> if (v == this.head.snd()) Some(this.head.fst()) else this.tail.lookupVal(v)
        is Nil -> None
    }

fun <a,b> LList<Prod<a,b>>.existsKey(key:a) : Boolean =
    when (this) {
        is Cons -> if (this.head.fst() == key) true else this.tail.existsKey(key)
        is Nil -> false
    }

fun <a,b> LList<Prod<a,b>>.existsVal(v:b) : Boolean =
    when (this) {
        is Cons -> if (this.head.snd() == v) true else this.tail.existsVal(v)
        is Nil -> false
    }

fun <a,b,c> LList<Prod<a,b>>.join(l : LList<Prod<b,c>>) : LList<Prod<a,c>> =
    when (this) {
        is Nil -> Nil
        is Cons -> when(val o = l.lookup(this.head.snd())) {
            is None -> this.tail.join(l)
            is Some -> Cons(MkProd(this.head.fst(), o.x), this.tail.join(l))
        }
    }

fun <a> LList<a>.contains(elt : a) : Boolean {
    return when (this) {
        is Nil -> false
        is Cons -> (this.head == elt) || this.tail.contains(elt)
    }
}


fun <a> LList<Option<a>>.values() : LList<a> =
    when (this) {
        is Nil -> Nil
        is Cons -> when(this.head) {
            is Some -> Cons(this.head.x, this.tail.values())
            is None -> this.tail.values()
        }
    }
