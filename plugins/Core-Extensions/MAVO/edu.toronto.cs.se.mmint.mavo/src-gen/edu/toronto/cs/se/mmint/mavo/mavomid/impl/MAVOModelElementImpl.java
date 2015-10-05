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
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;

import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MAVOModelElementImpl extends ModelElementImpl implements MAVOModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOMIDPackage.Literals.MAVO_MODEL_ELEMENT;
	}

	/**
	 * Creates and adds a model element instance of a type to be automatically
	 * detected and a reference to it to an Instance MID, initializing its MAVO
	 * may/set/var flags.
	 * 
	 * @param modelObj
	 *            The EMF model object to be wrapped by the MMINT new model
	 *            element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param containerModelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the new model element.
	 * @return The created reference to the new model element.
	 * @throws MMINTException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 * @generated NOT
	 */
	public static ModelElementReference createInstanceAndReference(EObject modelObj, String newModelElemName, ModelEndpointReference containerModelEndpointRef) throws MMINTException {

		//TODO MMINT[MAVO] This can't be static for polymorphism to work
		ModelElementReference newMAVOModelElemRef = ModelElementImpl.createInstanceAndReference(modelObj, newModelElemName, containerModelEndpointRef);
		MAVOUtils.initializeMAVOModelElementReference(modelObj, newMAVOModelElemRef);

		return newMAVOModelElemRef;
	}

} //MAVOModelElementImpl
