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
package edu.toronto.cs.se.mmtf.mid.mapping;

import edu.toronto.cs.se.mmtf.mid.TypedElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference#getContainedObject <em>Contained Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference#getObject <em>Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getTypedElementReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='oneObject'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot oneObject='referencedObject.oclIsUndefined() xor containedObject.oclIsUndefined()'"
 * @generated
 */
public interface TypedElementReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Object</em>' reference.
	 * @see #setReferencedObject(TypedElement)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getTypedElementReference_ReferencedObject()
	 * @model
	 * @generated
	 */
	TypedElement getReferencedObject();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference#getReferencedObject <em>Referenced Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Object</em>' reference.
	 * @see #getReferencedObject()
	 * @generated
	 */
	void setReferencedObject(TypedElement value);

	/**
	 * Returns the value of the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Object</em>' containment reference.
	 * @see #setContainedObject(TypedElement)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getTypedElementReference_ContainedObject()
	 * @model containment="true"
	 * @generated
	 */
	TypedElement getContainedObject();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference#getContainedObject <em>Contained Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained Object</em>' containment reference.
	 * @see #getContainedObject()
	 * @generated
	 */
	void setContainedObject(TypedElement value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getTypedElementReference_Object()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if containedObject.oclIsUndefined() then referencedObject else containedObject endif'"
	 * @generated
	 */
	TypedElement getObject();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getTypedElementReference_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if object.oclIsUndefined() then \'\' else object.name endif'"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getTypedElementReference_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if object.oclIsUndefined() then \'\' else object.type endif'"
	 * @generated
	 */
	String getType();

} // TypedElementReference
