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
package edu.toronto.cs.se.mmint.mid.operator.impl;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GenericEndpointImpl extends ExtendibleElementEndpointImpl implements GenericEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorPackage.Literals.GENERIC_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericEndpoint getSupertype() {
		ExtendibleElementEndpoint supertype = super.getSupertype();
		return (supertype == null) ? null : (GenericEndpoint) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericElement getTarget() {
		ExtendibleElement target = super.getTarget();
		return (target == null) ? null : (GenericElement) target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericEndpoint getMetatype() {
		ExtendibleElementEndpoint metatype = super.getMetatype();
		return (metatype == null) ? null : (GenericEndpoint) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ExtendibleElementEndpoint.class) {
			switch (baseOperationID) {
				case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE: return OperatorPackage.GENERIC_ENDPOINT___GET_METATYPE;
				case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE: return OperatorPackage.GENERIC_ENDPOINT___GET_SUPERTYPE;
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
			case OperatorPackage.GENERIC_ENDPOINT___GET_SUPERTYPE:
				return getSupertype();
			case OperatorPackage.GENERIC_ENDPOINT___GET_TARGET:
				return getTarget();
			case OperatorPackage.GENERIC_ENDPOINT___GET_METATYPE:
				return getMetatype();
		}
		return super.eInvoke(operationID, arguments);
	}

} //GenericEndpointImpl
