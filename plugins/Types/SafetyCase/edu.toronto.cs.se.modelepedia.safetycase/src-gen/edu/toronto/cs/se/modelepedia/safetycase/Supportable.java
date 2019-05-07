/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supportable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.Supportable#getSupportedBy <em>Supported By</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSupportable()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SupportCycle NonSupportableLeaves'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot SupportCycle='self.supportedBy.target -&gt; closure(p | if p.oclIsKindOf(Supportable) then \n\t\t\tp.oclAsType(Supportable).supportedBy.target else \n\t\t\tp.oclAsSet() endif) -&gt; excludes(self)' NonSupportableLeaves='self.supportedBy.target -&gt; size() &gt; 0 and self.supportedBy.target -&gt; excludes(null)'"
 * @generated
 */
public interface Supportable extends Supporter {
	/**
	 * Returns the value of the '<em><b>Supported By</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported By</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSupportable_SupportedBy()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getSource
	 * @model opposite="source" containment="true" required="true"
	 * @generated
	 */
	EList<SupportedBy> getSupportedBy();

} // Supportable
