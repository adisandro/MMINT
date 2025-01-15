/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.mid.productline.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLMIDPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PL Binary Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PLBinaryMappingReferenceImpl extends BinaryMappingReferenceImpl implements PLBinaryMappingReference {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLBinaryMappingReferenceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMIDPackage.Literals.PL_BINARY_MAPPING_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLBinaryMapping getObject() {
    var object = super.getObject();
    return (object == null) ? null : (PLBinaryMapping) object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == ExtendibleElementReference.class) {
      return switch (baseOperationID) {
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT -> PLMIDPackage.PL_BINARY_MAPPING_REFERENCE___GET_OBJECT;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    if (baseClass == MappingReference.class) {
      return switch (baseOperationID) {
      case RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT -> PLMIDPackage.PL_BINARY_MAPPING_REFERENCE___GET_OBJECT;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    if (baseClass == BinaryMappingReference.class) {
      return switch (baseOperationID) {
      case RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT -> PLMIDPackage.PL_BINARY_MAPPING_REFERENCE___GET_OBJECT;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    if (baseClass == PLMappingReference.class) {
      return switch (baseOperationID) {
      case PLMIDPackage.PL_MAPPING_REFERENCE___GET_OBJECT -> PLMIDPackage.PL_BINARY_MAPPING_REFERENCE___GET_OBJECT;
      default -> -1;
      };
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
    case PLMIDPackage.PL_BINARY_MAPPING_REFERENCE___GET_OBJECT:
      return getObject();
    }
    return super.eInvoke(operationID, arguments);
  }

} //PLBinaryMappingReferenceImpl
