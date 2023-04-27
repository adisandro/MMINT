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



sealed class Object {
    override fun toString(): String = this.uri()
}


data class MkObject(val uri : String, val kind: String, val attrs: Map<String, String>, val refs: MutableMap<String, LList<Tree<Object>>>) : Object() {
    override fun toString(): String = uri
    override fun equals(other: Any?): Boolean
    = other is MkObject && uri == other.uri
}

fun Object.uri() : String = when (this) { is MkObject -> this.uri}

fun Object.kind() : String =
    when (this) {
        is MkObject -> this.kind
    }

fun Object.attrs() : Map<String, String> =
    when (this) {
        is MkObject -> this.attrs
    }

fun Object.refs() : MutableMap<String, LList<Tree<Object>>> =
    when (this) {
        is MkObject -> this.refs
    }

fun Object.getAttr(s : String) : String? =
    when (this) {
        is MkObject -> this.attrs[s]
    }

fun Object.setRefs(map: MutableMap<String,LList<Tree<Object>>>) {
    this.refs().putAll(map)
}

