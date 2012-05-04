/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getUri <em>Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getSupertype <em>Supertype</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='supertypeType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot supertypeType='not supertype.oclIsUndefined() implies self.oclIsKindOf(supertype.oclType())'"
 * @generated
 */
public interface ExtendibleElement extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_Uri()
	 * @model required="true"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supertype</em>' reference.
	 * @see #setSupertype(ExtendibleElement)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_Supertype()
	 * @model
	 * @generated
	 */
	ExtendibleElement getSupertype();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getSupertype <em>Supertype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supertype</em>' reference.
	 * @see #getSupertype()
	 * @generated
	 */
	void setSupertype(ExtendibleElement value);

} // ExtendibleElement
