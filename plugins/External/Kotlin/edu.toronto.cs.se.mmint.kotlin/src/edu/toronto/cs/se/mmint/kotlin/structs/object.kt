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




import edu.toronto.cs.se.mmint.kotlin.operators.merge.mergeAttrs
import edu.toronto.cs.se.mmint.kotlin.operators.merge.mergeAttrsPL
import edu.toronto.cs.se.mmint.kotlin.operators.merge.mergeMaps
import edu.toronto.cs.se.mmint.kotlin.operators.merge.updateMap
import edu.toronto.cs.se.mmint.mid.reasoning.ISATReasoner



sealed class Object(
) {
    abstract val uri: String
    abstract val kind : String
    abstract val attrs : Map<String,String>
    abstract val refs : MutableMap<String, LList<Tree<Object>>>
    override fun toString(): String {
        return uri
    }

    companion object {
         fun union(
            toMerge: Map<String, String>,
            mergedObjs: LList<Prod<String, String>>,
            left: Object,
            right: Object
        ): Object {
            val mergedURI = when (val o = mergedObjs.lookup(left.uri)) {
                is None -> left.uri
                is Some -> o.x
            }
            val mergedKind = if (left.kind == right.kind) left.kind else "KIND_ERROR"
            val mergedAttrs = mergeAttrs(left.attrs, right.attrs)
            val mergedRefs = mergeMaps(left.refs, right.refs, toMerge)
            return MkObj(mergedURI, mergedKind, mergedAttrs, mergedRefs)
        }
         fun unionPL(
            toMerge: Map<String, String>,
            mergedObjs: LList<Prod<String, String>>,
            left: Object,
            right: Object,
            reasoner : ISATReasoner
        ): Object {
            val mergedURI = when (val o = mergedObjs.lookup(left.uri)) {
                is None -> left.uri
                is Some -> o.x
            }
            val mergedKind = if (left.kind == right.kind) left.kind else "KIND_ERROR"
            val mergedAttrs = mergeAttrsPL(left.attrs, right.attrs, reasoner)
            val mergedRefs = mergeMaps(left.refs, right.refs, toMerge)
            return MkObj(mergedURI, mergedKind, mergedAttrs, mergedRefs)
        }

        fun replaceRefs(model: Tree<Object>, mergeMap: LList<Prod<String, Tree<Object>>>): Unit {
            model.node().setRefs(updateMap(model.node().refs, mergeMap))
            model.children().map { it.snd().map { o -> Object.replaceRefs(o, mergeMap) } }
        }
    }
}
data class MkObj(override val uri : String,
                 override val kind : String,
                 override val attrs : Map<String, String>,
                 override val refs : MutableMap<String, LList<Tree<Object>>>) : Object() {
    override fun toString(): String {
        return uri
    } }


fun Object.setRefs(map: MutableMap<String,LList<Tree<Object>>>) {
    this.refs.putAll(map)
}

