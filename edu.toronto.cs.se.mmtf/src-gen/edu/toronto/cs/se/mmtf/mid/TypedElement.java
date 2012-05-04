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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getMetatype <em>Metatype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getLevel <em>Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getTypedElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='typeLevel'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot typeLevel='level = MidLevel::INSTANCES implies metatype.level = MidLevel::TYPES'"
 * @generated
 */
public interface TypedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getTypedElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metatype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metatype</em>' reference.
	 * @see #setMetatype(TypedElement)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getTypedElement_Metatype()
	 * @model
	 * @generated
	 */
	TypedElement getMetatype();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getMetatype <em>Metatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metatype</em>' reference.
	 * @see #getMetatype()
	 * @generated
	 */
	void setMetatype(TypedElement value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.MidLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
	 * @see #setLevel(MidLevel)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getTypedElement_Level()
	 * @model required="true"
	 * @generated
	 */
	MidLevel getLevel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(MidLevel value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getTypedElement_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if metaType.oclIsUndefined() then \'\' else metaType.name endif'"
	 * @generated
	 */
	String getType();

} // TypedElement
