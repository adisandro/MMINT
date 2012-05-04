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

import edu.toronto.cs.se.mmtf.mid.Model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getReferencedModel <em>Referenced Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getContainedModel <em>Contained Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getModel <em>Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='oneModel'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot oneModel='referencedModel.oclIsUndefined() xor containedModel.oclIsUndefined()'"
 * @generated
 */
public interface ModelContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if model.oclIsUndefined() then \'\' else model.name endif'"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if model.oclIsUndefined() then \'\' else model.type endif'"
	 * @generated
	 */
	String getType();

	/**
	 * Returns the value of the '<em><b>Referenced Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Model</em>' reference.
	 * @see #setReferencedModel(Model)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_ReferencedModel()
	 * @model
	 * @generated
	 */
	Model getReferencedModel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getReferencedModel <em>Referenced Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Model</em>' reference.
	 * @see #getReferencedModel()
	 * @generated
	 */
	void setReferencedModel(Model value);

	/**
	 * Returns the value of the '<em><b>Contained Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Model</em>' containment reference.
	 * @see #setContainedModel(Model)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_ContainedModel()
	 * @model containment="true"
	 * @generated
	 */
	Model getContainedModel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getContainedModel <em>Contained Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained Model</em>' containment reference.
	 * @see #getContainedModel()
	 * @generated
	 */
	void setContainedModel(Model value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_Model()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if containedModel.oclIsUndefined() then referencedModel else containedModel endif'"
	 * @generated
	 */
	Model getModel();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElement> getElements();

} // ModelContainer
