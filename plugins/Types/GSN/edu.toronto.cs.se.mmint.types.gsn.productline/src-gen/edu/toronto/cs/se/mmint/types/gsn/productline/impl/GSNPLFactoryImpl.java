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
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLFactory;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNPLFactoryImpl extends EFactoryImpl implements GSNPLFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GSNPLFactory init() {
    try {
      var theGSNPLFactory = (GSNPLFactory)EPackage.Registry.INSTANCE.getEFactory(GSNPLPackage.eNS_URI);
      if (theGSNPLFactory != null) {
        return theGSNPLFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GSNPLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNPLFactoryImpl() {
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
    case GSNPLPackage.GSNPL_ARGUMENT_ELEMENT -> createGSNPLArgumentElement();
    case GSNPLPackage.GSNPL_TEMPLATE -> createGSNPLTemplate();
    case GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE -> createGSNPLAnalysisTemplate();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPLArgumentElement createGSNPLArgumentElement() {
    GSNPLArgumentElementImpl gsnplArgumentElement = new GSNPLArgumentElementImpl();
    return gsnplArgumentElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPLTemplate createGSNPLTemplate() {
    GSNPLTemplateImpl gsnplTemplate = new GSNPLTemplateImpl();
    return gsnplTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPLAnalysisTemplate createGSNPLAnalysisTemplate() {
    GSNPLAnalysisTemplateImpl gsnplAnalysisTemplate = new GSNPLAnalysisTemplateImpl();
    return gsnplAnalysisTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPLPackage getGSNPLPackage() {
    return (GSNPLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GSNPLPackage getPackage() {
    return GSNPLPackage.eINSTANCE;
  }

} //GSNPLFactoryImpl
