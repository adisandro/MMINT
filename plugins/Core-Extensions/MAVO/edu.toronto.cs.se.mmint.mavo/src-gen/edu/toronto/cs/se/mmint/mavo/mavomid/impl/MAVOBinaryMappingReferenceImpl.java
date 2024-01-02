/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOBinaryMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOBinaryMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary MAVO Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MAVOBinaryMappingReferenceImpl extends BinaryMappingReferenceImpl implements MAVOBinaryMappingReference {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MAVOBinaryMappingReferenceImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return MAVOMIDPackage.Literals.MAVO_BINARY_MAPPING_REFERENCE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public MAVOBinaryMapping getObject() {
    ExtendibleElement object = super.getObject();
    return (object == null) ? null : (MAVOBinaryMapping) object;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == ExtendibleElementReference.class) {
      switch (baseOperationID) {
        case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT: return MAVOMIDPackage.MAVO_BINARY_MAPPING_REFERENCE___GET_OBJECT;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    if (baseClass == MappingReference.class) {
      switch (baseOperationID) {
        case RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT: return MAVOMIDPackage.MAVO_BINARY_MAPPING_REFERENCE___GET_OBJECT;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    if (baseClass == BinaryMappingReference.class) {
      switch (baseOperationID) {
        case RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT: return MAVOMIDPackage.MAVO_BINARY_MAPPING_REFERENCE___GET_OBJECT;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    if (baseClass == MAVOMappingReference.class) {
      switch (baseOperationID) {
        case MAVOMIDPackage.MAVO_MAPPING_REFERENCE___GET_OBJECT: return MAVOMIDPackage.MAVO_BINARY_MAPPING_REFERENCE___GET_OBJECT;
        default: return -1;
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
      case MAVOMIDPackage.MAVO_BINARY_MAPPING_REFERENCE___GET_OBJECT:
        return getObject();
    }
    return super.eInvoke(operationID, arguments);
  }

} //MAVOBinaryMappingReferenceImpl
