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

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.Link#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.Link#isUnbounded <em>Unbounded</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getLink()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='unboundedLevel'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot unboundedLevel='unbounded = true implies level = MidLevel::TYPES'"
 * @generated
 */
public interface Link extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getLink_Elements()
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElement#getLinks
	 * @model opposite="links"
	 * @generated
	 */
	EList<ModelElement> getElements();

	/**
	 * Returns the value of the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unbounded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unbounded</em>' attribute.
	 * @see #setUnbounded(boolean)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getLink_Unbounded()
	 * @model required="true"
	 * @generated
	 */
	boolean isUnbounded();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.Link#isUnbounded <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unbounded</em>' attribute.
	 * @see #isUnbounded()
	 * @generated
	 */
	void setUnbounded(boolean value);

} // Link
