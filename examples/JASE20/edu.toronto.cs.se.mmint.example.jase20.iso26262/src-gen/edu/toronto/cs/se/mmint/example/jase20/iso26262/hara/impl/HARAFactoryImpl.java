/*******************************************************************************
 * Copyright (c) 2012, 2020 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HARAFactoryImpl extends EFactoryImpl implements HARAFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HARAFactory init() {
    try {
      HARAFactory theHARAFactory = (HARAFactory)EPackage.Registry.INSTANCE.getEFactory(HARAPackage.eNS_URI);
      if (theHARAFactory != null) {
        return theHARAFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new HARAFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HARAFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case HARAPackage.HARA_ROOT: return createHARARoot();
      case HARAPackage.HAZARD: return createHazard();
      case HARAPackage.OPERATIONAL_SITUATION: return createOperationalSituation();
      case HARAPackage.HAZARDOUS_EVENT: return createHazardousEvent();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HARARoot createHARARoot() {
    HARARootImpl haraRoot = new HARARootImpl();
    return haraRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Hazard createHazard() {
    HazardImpl hazard = new HazardImpl();
    return hazard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperationalSituation createOperationalSituation() {
    OperationalSituationImpl operationalSituation = new OperationalSituationImpl();
    return operationalSituation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HazardousEvent createHazardousEvent() {
    HazardousEventImpl hazardousEvent = new HazardousEventImpl();
    return hazardousEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HARAPackage getHARAPackage() {
    return (HARAPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static HARAPackage getPackage() {
    return HARAPackage.eINSTANCE;
  }

} //HARAFactoryImpl
