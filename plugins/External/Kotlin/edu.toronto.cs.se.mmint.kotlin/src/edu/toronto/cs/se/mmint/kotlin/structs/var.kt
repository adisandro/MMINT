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
import edu.toronto.cs.se.mmint.kotlin.operators.merge.mergeMaps
import edu.toronto.cs.se.mmint.mid.reasoning.ISATReasoner


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
            right: VarObj,
            reasoner: ISATReasoner
        ): VarObj {
//            println("here")
            val mergedURI = when (val o = mergedObjs.lookup(left.uri)) {
                is None -> left.uri
                is Some -> o.x
            }
            val mergedKind = if (left.kind == right.kind) left.kind else "KIND_ERROR"
            val mergedAttrs = mergeAttrs(left.attrs, right.attrs)
            val mergedRefs = mergeMaps(left.refs, right.refs, toMerge)
            val mergedPC = reasoner.simplify(reasoner.orSyntax.replace("$1", left.pcond).replace("$2", right.pcond))
            return VarObj(mergedPC, mergedURI, mergedKind, mergedAttrs, mergedRefs)
        }

    fun VarObj.setRefs(map: MutableMap<String,LList<Tree<VarObj>>>) {
            this.refs.putAll(map)
        }


    fun replaceRefsPL(model : Tree<VarObj>, mergeMap : LList<Prod<String,Tree<VarObj>>>) : Unit {
        val refsIt = model.node().refs.entries.iterator()
        val newRefs = mutableMapOf<String,LList<Tree<Object>>>()
        while(refsIt.hasNext()){
            val entry = refsIt.next()
            val objs = entry.value.toList()
            val newObjs : MutableList<Tree<Object>> = mutableListOf()
            for (o in objs){
                when (val new = mergeMap.lookup(o.node().uri)){
                    is None -> newObjs.add(o)
                    is Some -> {
                        newObjs.add(new.x)
                    }
                }
            }
            newRefs[entry.key] = newObjs.toList().toLList()
        }
        model.node().setRefs(newRefs)
        model.children().map { it.snd().map {o -> replaceRefsPL(o, mergeMap) }}
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


fun Tree<Object>.toTreeVarObj() : Tree<VarObj> =
    this.mapdata { it.toVarObj()}

