/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Kleisli version, points to a Kleisli extended model. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#getExtendedTarget <em>Extended Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#getExtendedTargetUri <em>Extended Target Uri</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelEndpoint()
 * @model
 * @generated
 */
public interface KleisliModelEndpoint extends ModelEndpoint {

	/**
	 * Returns the value of the '<em><b>Extended Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Kleisli extended model target (types: extended model type; instances: extended model instance).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Target</em>' containment reference.
	 * @see #setExtendedTarget(KleisliModel)
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelEndpoint_ExtendedTarget()
	 * @model containment="true" required="true"
	 * @generated
	 */
	KleisliModel getExtendedTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#getExtendedTarget <em>Extended Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Target</em>' containment reference.
	 * @see #getExtendedTarget()
	 * @generated
	 */
	void setExtendedTarget(KleisliModel value);

	/**
	 * Returns the value of the '<em><b>Extended Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of the Kleisli extended model target (types: state-relative; instances: workspace-relative).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Target Uri</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelEndpoint_ExtendedTargetUri()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='extendedTarget.uri'"
	 * @generated
	 */
	String getExtendedTargetUri();

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelTypeEndpointNameRequired="true" targetModelTypeRequired="true" isBinarySrcRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	ModelEndpointReference createSubtype(String newModelTypeEndpointName, Model targetModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" oldModelTypeEndpointRequired="true" newModelTypeEndpointNameRequired="true" targetModelTypeRequired="true"
	 * @generated
	 */
	void replaceSubtype(ModelEndpoint oldModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteType(boolean isFullDelete) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" targetModelRequired="true" containerModelRelRequired="true"
	 * @generated
	 */
	ModelEndpointReference createInstance(Model targetModel, ModelRel containerModelRel) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @throws MMINTException
	 *             If a native model endpoint is being replaced with a Kleisli
	 *             one. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" oldModelEndpointRequired="true" targetModelRequired="true"
	 * @generated
	 */
	void replaceInstance(ModelEndpoint oldModelEndpoint, Model targetModel) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteInstance(boolean isFullDelete) throws MMINTException;

} // KleisliModelEndpoint
