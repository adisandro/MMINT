/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contextual Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ContextualElement#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getContextualElement()
 * @model abstract="true"
 * @generated
 */
public interface ContextualElement extends ArgumentElement {
	/**
	 * Returns the value of the '<em><b>Context Of</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.InContextOf}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Of</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getContextualElement_ContextOf()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContext
	 * @model opposite="context" required="true"
	 * @generated
	 */
	EList<InContextOf> getContextOf();

} // ContextualElement
