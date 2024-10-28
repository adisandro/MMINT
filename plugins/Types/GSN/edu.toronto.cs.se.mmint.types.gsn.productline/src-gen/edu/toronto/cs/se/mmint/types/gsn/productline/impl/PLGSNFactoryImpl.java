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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNFactory;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLGSNFactoryImpl extends EFactoryImpl implements PLGSNFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PLGSNFactory init() {
    try {
      var thePLGSNFactory = (PLGSNFactory)EPackage.Registry.INSTANCE.getEFactory(PLGSNPackage.eNS_URI);
      if (thePLGSNFactory != null) {
        return thePLGSNFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PLGSNFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLGSNFactoryImpl() {
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
    case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT -> createPLGSNArgumentElement();
    case PLGSNPackage.PLGSN_TEMPLATE -> createPLGSNTemplate();
    case PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE -> createPLGSNAnalyticTemplate();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    return switch (eDataType.getClassifierID()) {
    case PLGSNPackage.IPLGSN_ANALYSIS -> createIPLGSNAnalysisFromString(eDataType, initialValue);
    default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    return switch (eDataType.getClassifierID()) {
    case PLGSNPackage.IPLGSN_ANALYSIS -> convertIPLGSNAnalysisToString(eDataType, instanceValue);
    default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLGSNArgumentElement createPLGSNArgumentElement() {
    PLGSNArgumentElementImpl plgsnArgumentElement = new PLGSNArgumentElementImpl();
    return plgsnArgumentElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLGSNTemplate createPLGSNTemplate() {
    PLGSNTemplateImpl plgsnTemplate = new PLGSNTemplateImpl();
    return plgsnTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLGSNAnalyticTemplate createPLGSNAnalyticTemplate() {
    PLGSNAnalyticTemplateImpl plgsnAnalyticTemplate = new PLGSNAnalyticTemplateImpl();
    return plgsnAnalyticTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IPLGSNAnalysis createIPLGSNAnalysisFromString(EDataType eDataType, String initialValue) {
    return (IPLGSNAnalysis)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIPLGSNAnalysisToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLGSNPackage getPLGSNPackage() {
    return (PLGSNPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PLGSNPackage getPackage() {
    return PLGSNPackage.eINSTANCE;
  }

} //GSNPLFactoryImpl
