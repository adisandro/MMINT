/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.impl;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.ModelElement;

import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl;

import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ModelElementEndpointImpl extends ExtendibleElementEndpointImpl implements ModelElementEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.MODEL_ELEMENT_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpoint getSupertype() {
		ExtendibleElementEndpoint supertype = super.getSupertype();
		return (supertype == null) ? null : (ModelElementEndpoint) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getTarget() {
		ExtendibleElement target = super.getTarget();
		return (target == null) ? null : (ModelElement) target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpoint getMetatype() {
		ExtendibleElementEndpoint metatype = super.getMetatype();
		return (metatype == null) ? null : (ModelElementEndpoint) metatype;
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
				case MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE;
				case MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE;
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE:
				return getSupertype();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_TARGET:
				return getTarget();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE:
				return getMetatype();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModelElementEndpointImpl
