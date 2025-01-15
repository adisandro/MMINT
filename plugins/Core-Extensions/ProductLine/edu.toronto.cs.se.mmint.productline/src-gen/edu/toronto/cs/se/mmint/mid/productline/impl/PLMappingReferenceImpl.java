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

import edu.toronto.cs.se.mmint.mid.productline.PLMIDPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.impl.MappingReferenceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PL Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PLMappingReferenceImpl extends MappingReferenceImpl implements PLMappingReference {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLMappingReferenceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMIDPackage.Literals.PL_MAPPING_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLMapping getObject() {
    var object = super.getObject();
    return (object == null) ? null : (PLMapping) object;
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
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT -> PLMIDPackage.PL_MAPPING_REFERENCE___GET_OBJECT;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    if (baseClass == MappingReference.class) {
      return switch (baseOperationID) {
      case RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT -> PLMIDPackage.PL_MAPPING_REFERENCE___GET_OBJECT;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
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
    case PLMIDPackage.PL_MAPPING_REFERENCE___GET_OBJECT:
      return getObject();
    }
    return super.eInvoke(operationID, arguments);
  }

} //PLMappingReferenceImpl
