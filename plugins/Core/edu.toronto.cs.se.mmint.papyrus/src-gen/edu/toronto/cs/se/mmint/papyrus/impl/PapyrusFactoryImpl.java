/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.papyrus.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.papyrus.PapyrusFactory;
import edu.toronto.cs.se.mmint.papyrus.PapyrusPackage;
import edu.toronto.cs.se.mmint.papyrus.UMLModel;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class PapyrusFactoryImpl extends EFactoryImpl implements PapyrusFactory {
  /**
   * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static PapyrusFactory init() {
    try {
      var thePapyrusFactory = (PapyrusFactory) EPackage.Registry.INSTANCE.getEFactory(PapyrusPackage.eNS_URI);
      if (thePapyrusFactory != null) {
        return thePapyrusFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PapyrusFactoryImpl();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public PapyrusFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case PapyrusPackage.UML_MODEL:
      return createUMLModel();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public UMLModel createUMLModel() {
    UMLModelImpl umlModel = new UMLModelImpl();
    return umlModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public PapyrusPackage getPapyrusPackage() {
    return (PapyrusPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PapyrusPackage getPackage() {
    return PapyrusPackage.eINSTANCE;
  }

} // PapyrusFactoryImpl
