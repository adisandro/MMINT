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


sealed class Option<out a> {
    companion object {
        fun <a> isSome(o : Option<a>): Boolean =
            when (o) {
                is None -> false
                is Some -> true
            }
    }
}

object None : Option<Nothing>() {
    override fun toString(): String = "None"
}

data class Some <out a> (val x : a) : Option<a>() {
    override fun toString(): String = "$x"
}

fun <a> getOrDefault(o:Option<a>, default:a) : a =
    when (o) {
        is None -> default
        is Some -> o.x
    }

fun <a> Option<a>.isSome() : Boolean =
    when(this) {
        is None -> false
        is Some -> true
    }
