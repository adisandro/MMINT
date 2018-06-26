/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid;

import edu.toronto.cs.se.mmint.MMINTException;

import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAVO Model Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MAVO version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage#getMAVOModelEndpointReference()
 * @model
 * @generated
 */
public interface MAVOModelEndpointReference extends ModelEndpointReference {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * {@inheritDoc}<br />
     * Gets the referenced MAVO model endpoint.
     * <!-- end-model-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement object = super.getObject();\nreturn (object == null) ? null : (MAVOModelEndpoint) object;'"
     * @generated
     */
	MAVOModelEndpoint getObject();

	/**
     * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelObjRequired="true" newModelElemNameRequired="true"
     * @generated
     */
	ModelElementReference createModelElementInstanceAndReference(EObject modelObj, String newModelElemName) throws MMINTException;

} // MAVOModelEndpointReference
