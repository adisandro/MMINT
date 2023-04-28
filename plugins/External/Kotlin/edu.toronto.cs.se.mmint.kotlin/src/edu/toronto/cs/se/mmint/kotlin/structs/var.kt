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


import edu.toronto.cs.se.mmint.kotlin.operators.merge.mergeAttrs
import edu.toronto.cs.se.mmint.kotlin.operators.merge.mergeMaps

//

fun Or(left : String, right : String) : String = "$left | $right"


data class VarObj(val pcond : String,
                   override val uri: String,
                   override val kind: String,
                   override val attrs : Map<String,String>,
                   override val refs: MutableMap<String, LList<Tree<Object>>>
                  ) :
                  Object() {
    override fun toString(): String {
        return uri
    }
    companion object {
        fun unionPL(
            toMerge: Map<String, String>,
            mergedObjs: LList<Prod<String, String>>,
            left: VarObj,
            right: VarObj
        ): VarObj {
            val mergedURI = when (val o = mergedObjs.lookup(left.uri)) {
                is None -> left.uri
                is Some -> o.x
            }
            val mergedKind = if (left.kind == right.kind) left.kind else "KIND_ERROR"
            val mergedAttrs = mergeAttrs(left.attrs, right.attrs)
            val mergedRefs = mergeMaps(left.refs, right.refs, toMerge)
            return VarObj(
                Or(left.pcond, right.pcond),
                mergedURI, mergedKind, mergedAttrs, mergedRefs
            )
        }
    }
}



fun Object.toVarObj() : VarObj {

            if (this.attrs.containsKey("presenceCondition")){
                val pc = this.attrs["presenceCondition"]
                return when(pc) {
                    null -> VarObj("true", uri, kind, attrs.minus("presenceCondition").toMutableMap(),
                        refs.toLList().map { p -> MkProd(p.fst(), p.snd().map {it.mapdata { x -> x.toVarObj() }})} .toMap().toMutableMap())
                    else -> {
                        this.attrs.minus("presenceCondition")
                        VarObj(pc, uri, kind, attrs.minus("presenceCondition").toMutableMap(),
                            refs.toLList().map { p -> MkProd(p.fst(), p.snd().map {it.mapdata { x -> x.toVarObj() }})} .toMap().toMutableMap())
                    }
                }

            }
        else {
               return VarObj("true", uri, kind, attrs.minus("presenceCondition").toMutableMap(),
                   refs.toLList().map { p -> MkProd(p.fst(), p.snd().map {it.mapdata { x -> x.toVarObj() }})} .toMap().toMutableMap())
            }
    }
//

fun Tree<Object>.toTreeVarObj() : Tree<VarObj> =
    this.mapdata { it.toVarObj()}


