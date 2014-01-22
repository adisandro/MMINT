/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.kleisli;

import edu.toronto.cs.se.mmtf.MMTFException;

import edu.toronto.cs.se.mmtf.mid.ModelElement;

import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Kleisli version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference#getExtendedTargetUri <em>Extended Target Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelEndpointReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='kleisliModelEndpoint'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot kleisliModelEndpoint='object.oclIsKindOf(kleisli::KleisliModelEndpoint)'"
 * @generated
 */
public interface KleisliModelEndpointReference extends ModelEndpointReference {
	/**
	 * Returns the value of the '<em><b>Extended Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of the referenced Kleisli extended model target (types: state-relative; instances: workspace-relative).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Target Uri</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelEndpointReference_ExtendedTargetUri()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='object.oclAsType(kleisli::KleisliModelEndpoint).extendedTargetUri'"
	 * @generated
	 */
	String getExtendedTargetUri();

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" metamodelObjRequired="true"
	 * @generated
	 */
	boolean acceptModelElementType(EObject metamodelObj) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" modelObjRequired="true"
	 * @generated
	 */
	ModelElement acceptModelElementInstance(EObject modelObj) throws MMTFException;

} // KleisliModelEndpointReference
