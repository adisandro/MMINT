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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Homomorphism Link</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getHomomorphismLink()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sameElementTypes'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot sameElementTypes='invalid->forAll(e1 : ModelElement, e2 : ModelElement | e1.pointer.oclType() = e2.pointer.oclType())'"
 * @generated
 */
public interface HomomorphismLink extends BinaryLink {
} // HomomorphismLink
