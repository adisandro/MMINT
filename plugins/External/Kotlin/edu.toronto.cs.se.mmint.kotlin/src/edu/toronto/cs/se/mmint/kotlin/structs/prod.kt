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


sealed class Prod<out a,out b> {

}

data class MkProd <out a, out b> (val fst : a, val snd :b) : Prod<a,b>() {
    override fun toString(): String = "($fst,$snd)"
}


fun <a, b> Prod<a,b>.fst(): a =
    when (this) {
        is MkProd -> this.fst
    }

fun <a, b> Prod<a,b>.snd(): b =
    when (this) {
        is MkProd -> this.snd
    }
