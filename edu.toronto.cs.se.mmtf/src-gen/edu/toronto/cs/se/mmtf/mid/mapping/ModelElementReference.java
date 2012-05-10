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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElementReference()
 * @model
 * @generated
 */
public interface ModelElementReference extends TypedElementReference {
	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.Link}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmtf.mid.mapping.Link#getElementRefs <em>Element Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElementReference_Links()
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.Link#getElementRefs
	 * @model opposite="elementRefs"
	 * @generated
	 */
	EList<Link> getLinks();

} // ModelElementReference
