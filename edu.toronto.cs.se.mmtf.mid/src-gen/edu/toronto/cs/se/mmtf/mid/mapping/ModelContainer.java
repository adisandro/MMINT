/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping;

import edu.toronto.cs.se.mmtf.mid.ModelReference;
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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getModel <em>Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getReferencedModel <em>Referenced Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getContainedModel <em>Contained Model</em>}</li>
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
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference}.
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
	EList<ModelElementReference> getElements();

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
	ModelReference getModel();

	/**
	 * Returns the value of the '<em><b>Referenced Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Model</em>' reference.
	 * @see #setReferencedModel(ModelReference)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_ReferencedModel()
	 * @model
	 * @generated
	 */
	ModelReference getReferencedModel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getReferencedModel <em>Referenced Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Model</em>' reference.
	 * @see #getReferencedModel()
	 * @generated
	 */
	void setReferencedModel(ModelReference value);

	/**
	 * Returns the value of the '<em><b>Contained Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Model</em>' containment reference.
	 * @see #setContainedModel(ModelReference)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelContainer_ContainedModel()
	 * @model containment="true"
	 * @generated
	 */
	ModelReference getContainedModel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getContainedModel <em>Contained Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained Model</em>' containment reference.
	 * @see #getContainedModel()
	 * @generated
	 */
	void setContainedModel(ModelReference value);

} // ModelContainer
