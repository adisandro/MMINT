/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ASIL Decomposition Strategy</b></em>'. <!--
 * end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASILDecompositionStrategy()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ASILDecompositionIndependence ASILDecompositionComponents ASILDescendants'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot ASILDecompositionIndependence='\n\t\t\tlet children = self.supportedBy.target -&gt; closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif)\n\t\t\tin children -&gt; selectByType(IndependenceGoal) -&gt; size() = 1' ASILDecompositionComponents=' \n\t\t\tlet children = self.supportedBy.target -&gt; closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif)\n\t\t\tin children -&gt; selectByType(BasicGoal) -&gt; size() = 2' ASILDescendants='\n\t\t\tlet goalSeq = self.supportedBy.target -&gt; closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif) -&gt; select(p | p.oclIsTypeOf(BasicGoal)), \n\t\t\tg1Descendants : Set(Supporter) = goalSeq -&gt; at(1) -&gt; closure(c | \n\t\t\t\t\tif c.oclIsKindOf(Supportable) then c.oclAsType(Supportable).supportedBy.target else null endif),\n\t\t\tg2Descendants : Set(Supporter) = goalSeq -&gt; at(2) -&gt; closure(c | \n\t\t\t\t\tif c.oclIsKindOf(Supportable) then c.oclAsType(Supportable).supportedBy.target else null endif) \n\t\t\tin g1Descendants -&gt; intersection(g2Descendants) = Set{}'"
 * @generated
 */
public interface ASILDecompositionStrategy extends Strategy {
} // ASILDecompositionStrategy
