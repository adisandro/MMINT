/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid.impl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelEndpointReferenceImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MAVOModelEndpointReferenceImpl extends ModelEndpointReferenceImpl implements MAVOModelEndpointReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOModelEndpointReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOMIDPackage.Literals.MAVO_MODEL_ENDPOINT_REFERENCE;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelElementReference createModelElementInstanceAndReference(EObject modelObj, String newModelElemName) throws MMINTException {

		ModelElementReference newMAVOModelElemRef = super.createModelElementInstanceAndReference(modelObj, newModelElemName);
		MAVOUtils.initializeMAVOModelElementReference(modelObj, newMAVOModelElemRef);

		return newMAVOModelElemRef;
	}

} //MAVOModelEndpointReferenceImpl
