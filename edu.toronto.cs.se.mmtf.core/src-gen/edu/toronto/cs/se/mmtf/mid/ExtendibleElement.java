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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getMetatype <em>Metatype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getLevel <em>Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getRuntimeMetatypes <em>Runtime Metatypes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getMetatypeUri <em>Metatype Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='supertypeType typeLevel metatypeType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot supertypeType='not supertype.oclIsUndefined() implies self.oclIsKindOf(supertype.oclType())' typeLevel='level = MidLevel::INSTANCES implies metatype.level = MidLevel::TYPES' metatypeType='not metatype.oclIsUndefined() implies self.oclIsTypeOf(metatype.oclType())'"
 * @generated
 */
public interface ExtendibleElement extends EObject {
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getName <em>Name</em>}' attribute.
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_Metatype()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ExtendibleElement getMetatype();

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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_Level()
	 * @model required="true"
	 * @generated
	 */
	MidLevel getLevel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getLevel <em>Level</em>}' attribute.
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if metatype.oclIsUndefined() then \'\' else metatype.name endif'"
	 * @generated
	 */
	String getType();

	/**
	 * Returns the value of the '<em><b>Runtime Metatypes</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime Metatypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Metatypes</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_RuntimeMetatypes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ExtendibleElement> getRuntimeMetatypes();

	/**
	 * Returns the value of the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metatype Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metatype Uri</em>' attribute.
	 * @see #setMetatypeUri(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getExtendibleElement_MetatypeUri()
	 * @model
	 * @generated
	 */
	String getMetatypeUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getMetatypeUri <em>Metatype Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metatype Uri</em>' attribute.
	 * @see #getMetatypeUri()
	 * @generated
	 */
	void setMetatypeUri(String value);

} // ExtendibleElement
