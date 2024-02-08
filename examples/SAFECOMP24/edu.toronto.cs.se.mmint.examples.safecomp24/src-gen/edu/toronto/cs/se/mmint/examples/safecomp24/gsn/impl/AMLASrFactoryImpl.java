/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.AMLASrFactory;
import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.AMLASrPackage;
import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.Stage1Template;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AMLASrFactoryImpl extends EFactoryImpl implements AMLASrFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AMLASrFactory init() {
    try {
      var theAMLASrFactory = (AMLASrFactory)EPackage.Registry.INSTANCE.getEFactory(AMLASrPackage.eNS_URI);
      if (theAMLASrFactory != null) {
        return theAMLASrFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AMLASrFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AMLASrFactoryImpl() {
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
    case AMLASrPackage.STAGE1_TEMPLATE -> createStage1Template();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Stage1Template createStage1Template() {
    var stage1Template = new Stage1TemplateImpl();
    return stage1Template;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AMLASrPackage getAMLASrPackage() {
    return (AMLASrPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AMLASrPackage getPackage() {
    return AMLASrPackage.eINSTANCE;
  }

} //AMLASrFactoryImpl
