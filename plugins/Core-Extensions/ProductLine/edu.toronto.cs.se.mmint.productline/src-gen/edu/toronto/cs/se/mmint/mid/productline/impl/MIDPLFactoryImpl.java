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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.mid.productline.MIDPLFactory;
import edu.toronto.cs.se.mmint.mid.productline.MIDPLPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLModelRel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MIDPLFactoryImpl extends EFactoryImpl implements MIDPLFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MIDPLFactory init() {
    try {
      var theMIDPLFactory = (MIDPLFactory) EPackage.Registry.INSTANCE.getEFactory(MIDPLPackage.eNS_URI);
      if (theMIDPLFactory != null) {
        return theMIDPLFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MIDPLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MIDPLFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    return switch (eClass.getClassifierID()) {
    case MIDPLPackage.PL_MODEL_REL -> createPLModelRel();
    case MIDPLPackage.PL_BINARY_MODEL_REL -> createPLBinaryModelRel();
    case MIDPLPackage.PL_MAPPING -> createPLMapping();
    case MIDPLPackage.PL_BINARY_MAPPING -> createPLBinaryMapping();
    case MIDPLPackage.PL_MAPPING_REFERENCE -> createPLMappingReference();
    case MIDPLPackage.PL_BINARY_MAPPING_REFERENCE -> createPLBinaryMappingReference();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLModelRel createPLModelRel() {
    PLModelRelImpl plModelRel = new PLModelRelImpl();
    return plModelRel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLBinaryModelRel createPLBinaryModelRel() {
    PLBinaryModelRelImpl plBinaryModelRel = new PLBinaryModelRelImpl();
    return plBinaryModelRel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLMapping createPLMapping() {
    PLMappingImpl plMapping = new PLMappingImpl();
    return plMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLBinaryMapping createPLBinaryMapping() {
    PLBinaryMappingImpl plBinaryMapping = new PLBinaryMappingImpl();
    return plBinaryMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLMappingReference createPLMappingReference() {
    PLMappingReferenceImpl plMappingReference = new PLMappingReferenceImpl();
    return plMappingReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLBinaryMappingReference createPLBinaryMappingReference() {
    PLBinaryMappingReferenceImpl plBinaryMappingReference = new PLBinaryMappingReferenceImpl();
    return plBinaryMappingReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MIDPLPackage getMIDPLPackage() {
    return (MIDPLPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MIDPLPackage getPackage() {
    return MIDPLPackage.eINSTANCE;
  }

} //MIDPLFactoryImpl
