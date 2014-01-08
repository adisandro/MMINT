/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.kleisli;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Kleisli abstract basic element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliExtendibleElement#getExtendedUri <em>Extended Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliExtendibleElement()
 * @model abstract="true"
 * @generated
 */
public interface KleisliExtendibleElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Extended Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of Kleisli extensions, i.e. directories and files (types: state-relative; instances: workspace-relative).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Uri</em>' attribute.
	 * @see #setExtendedUri(String)
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliExtendibleElement_ExtendedUri()
	 * @model required="true"
	 * @generated
	 */
	String getExtendedUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliExtendibleElement#getExtendedUri <em>Extended Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Uri</em>' attribute.
	 * @see #getExtendedUri()
	 * @generated
	 */
	void setExtendedUri(String value);

} // KleisliExtendibleElement
