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
package edu.toronto.cs.se.mmtf.mid;

import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getUri <em>Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getRoot <em>Root</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getOrigin <em>Origin</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelReference()
 * @model
 * @generated
 */
public interface ModelReference extends NamedElement {
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelReference_Uri()
	 * @model required="true"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(EObject)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelReference_Root()
	 * @model required="true"
	 * @generated
	 */
	EObject getRoot();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(EObject value);

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin
	 * @see #setOrigin(ModelReferenceOrigin)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelReference_Origin()
	 * @model required="true"
	 * @generated
	 */
	ModelReferenceOrigin getOrigin();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(ModelReferenceOrigin value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(ModelContainer)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelReference_Container()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelContainer getContainer();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(ModelContainer value);

} // ModelReference
