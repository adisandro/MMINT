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
package edu.toronto.cs.se.modelepedia.classdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedAttributes <em>Owned Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attributes</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramPackage#getClass_OwnedAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getOwnedAttributes();

} // Class
