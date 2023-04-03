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

fun bnot(b:Boolean) : Boolean =
    when(b) {
        true ->  false
        false -> true
    }


// Unsafe
public fun <K, V> Map<out K, V>.toLList(): LList<Prod<K, V>> {
    if (this.isEmpty())
        return Nil
    val iterator = entries.iterator()
    if (!iterator.hasNext())
        return Nil
    val first = iterator.next()
    if (!iterator.hasNext())
        return LList.of(MkProd(first.key, first.value))

    var result : LList<Prod<K, V>> = Cons(MkProd(first.key, first.value),Nil)
    do {
        val i = iterator.next()
        result = Cons(MkProd(i.key, i.value), result)
    } while (iterator.hasNext())
    return result
}

fun <K, V>  LList<Prod<K, V>>.toMap(): Map<K, V>  =
     when (this) {
        is Nil -> emptyMap<K, V>()
        is Cons -> {
            val result = Pair(this.head.fst(), this.head.snd())
            this.tail.toMap().plus(result)
        }
    }

// UNSAFE (could be rewritten safely using above, but would add overhead)
fun <K,V> Map<K,LList<V>>.addChild(container : K, new : V) : Map<K, LList<V>> {
    return when (val currentChildren = this[container]) {
        null -> this.plus(container to  Cons(new,Nil))
        else -> this.plus(container to Cons(new,currentChildren))
    }
}
