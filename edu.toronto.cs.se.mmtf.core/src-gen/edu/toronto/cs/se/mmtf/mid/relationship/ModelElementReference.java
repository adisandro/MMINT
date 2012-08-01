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
package edu.toronto.cs.se.mmtf.mid.relationship;

import edu.toronto.cs.se.mmtf.mid.ModelElement;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelElementReference()
 * @model
 * @generated
 */
public interface ModelElementReference extends ExtendibleElementReference {
	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.Link}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getElementRefs <em>Element Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelElementReference_Links()
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#getElementRefs
	 * @model opposite="elementRefs"
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement object = super.getObject();\nreturn (object == null) ? null : (ModelElement) object;'"
	 * @generated
	 */
	ModelElement getObject();

} // ModelElementReference
