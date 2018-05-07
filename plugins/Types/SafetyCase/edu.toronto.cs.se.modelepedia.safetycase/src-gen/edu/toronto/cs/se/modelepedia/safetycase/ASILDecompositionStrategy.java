/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>ASIL Decomposition Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy#getSupportedByIndependent <em>Supported By Independent</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASILDecompositionStrategy()
 * @model
 * @generated
 */
public interface ASILDecompositionStrategy extends Strategy {
	/**
	 * Returns the value of the '<em><b>Supported By</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.SupportedByDecomposable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported By</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASILDecompositionStrategy_SupportedBy()
	 * @model containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<SupportedByDecomposable> getSupportedBy();

	/**
	 * Returns the value of the '<em><b>Supported By Independent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported By Independent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported By Independent</em>' reference.
	 * @see #setSupportedByIndependent(SupportedByDecomposable)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASILDecompositionStrategy_SupportedByIndependent()
	 * @model required="true"
	 * @generated
	 */
	SupportedByDecomposable getSupportedByIndependent();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy#getSupportedByIndependent <em>Supported By Independent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supported By Independent</em>' reference.
	 * @see #getSupportedByIndependent()
	 * @generated
	 */
	void setSupportedByIndependent(SupportedByDecomposable value);

} // ASILDecompositionStrategy
