/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.mid.impl;

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage;

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
    return ProductLineMIDPackage.Literals.PL_BINARY_MAPPING_REFERENCE;
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

} //PLBinaryMappingReferenceImpl
