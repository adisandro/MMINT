/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.mid.productline.MIDPLPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLMappingReference;
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
    return MIDPLPackage.Literals.PL_MAPPING_REFERENCE;
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

} //PLMappingReferenceImpl
