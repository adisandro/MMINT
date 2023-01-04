/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryModelRel;
import edu.toronto.cs.se.mmint.productline.mid.PLMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLMappingReference;
import edu.toronto.cs.se.mmint.productline.mid.PLModelRel;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDFactory;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductLineMIDFactoryImpl extends EFactoryImpl implements ProductLineMIDFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ProductLineMIDFactory init() {
    try {
      var theProductLineMIDFactory = (ProductLineMIDFactory) EPackage.Registry.INSTANCE.getEFactory(ProductLineMIDPackage.eNS_URI);
      if (theProductLineMIDFactory != null) {
        return theProductLineMIDFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ProductLineMIDFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductLineMIDFactoryImpl() {
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
    case ProductLineMIDPackage.PL_MODEL_REL -> createPLModelRel();
    case ProductLineMIDPackage.PL_BINARY_MODEL_REL -> createPLBinaryModelRel();
    case ProductLineMIDPackage.PL_MAPPING -> createPLMapping();
    case ProductLineMIDPackage.PL_BINARY_MAPPING -> createPLBinaryMapping();
    case ProductLineMIDPackage.PL_MAPPING_REFERENCE -> createPLMappingReference();
    case ProductLineMIDPackage.PL_BINARY_MAPPING_REFERENCE -> createPLBinaryMappingReference();
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
  public ProductLineMIDPackage getProductLineMIDPackage() {
    return (ProductLineMIDPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ProductLineMIDPackage getPackage() {
    return ProductLineMIDPackage.eINSTANCE;
  }

} //ProductLineMIDFactoryImpl
