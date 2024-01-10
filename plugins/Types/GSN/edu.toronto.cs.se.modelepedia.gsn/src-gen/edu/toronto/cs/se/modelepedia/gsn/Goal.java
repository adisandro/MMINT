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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Goal</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getGoal()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ASILInheritance'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot ASILInheritance='let parents : Set(Goal) = self.supports.source -&gt; closure(c | if c.oclIsKindOf(Goal) then c.oclAsSet() else c.oclAsType(gsn::Supporter).supports.source endif) -&gt; selectByKind(Goal) -&gt; asSet() in\n  parents -&gt; forAll(g | if g.asil = null then true else if self.asil = null then false else g.asil.value = ASILLevel::QM or (g.asil.value.toString() &lt;= self.asil.value.toString() and self.asil.value &lt;&gt; ASILLevel::QM) endif endif)'"
 * @generated
 */
public interface Goal extends Supportable, Supporter, ContextualizableElement, ASILfulElement {
} // Goal
