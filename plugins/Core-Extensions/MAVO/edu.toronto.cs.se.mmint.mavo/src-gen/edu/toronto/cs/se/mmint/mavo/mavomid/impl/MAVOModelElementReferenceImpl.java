/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementReferenceImpl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MAVOModelElementReferenceImpl extends ModelElementReferenceImpl implements MAVOModelElementReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOModelElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOMIDPackage.Literals.MAVO_MODEL_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOModelElement getObject() {
		ExtendibleElement object = super.getObject();
		return (object == null) ? null : (MAVOModelElement) object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ModelElementReference.class) {
			switch (baseOperationID) {
				case RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_OBJECT: return MAVOMIDPackage.MAVO_MODEL_ELEMENT_REFERENCE___GET_OBJECT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT_REFERENCE___GET_OBJECT:
				return getObject();
		}
		return super.eInvoke(operationID, arguments);
	}

} //MAVOModelElementReferenceImpl
