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
package edu.toronto.cs.se.mmint.examples.safecomp24.gsn;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.examples.safecomp24.gsn.AMLASrFactory
 * @model kind="package"
 * @generated
 */
public interface AMLASrPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gsn";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "model://edu.toronto.cs.se.mmint.examples.safecomp24.gsn";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "safecomp24.gsn";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AMLASrPackage eINSTANCE = edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl.AMLASrPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl.Stage2TemplateImpl <em>Stage2 Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl.Stage2TemplateImpl
   * @see edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl.AMLASrPackageImpl#getStage2Template()
   * @generated
   */
  int STAGE2_TEMPLATE = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAGE2_TEMPLATE__ELEMENTS = GSNPackage.TEMPLATE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAGE2_TEMPLATE__ID = GSNPackage.TEMPLATE__ID;

  /**
   * The number of structural features of the '<em>Stage2 Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAGE2_TEMPLATE_FEATURE_COUNT = GSNPackage.TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAGE2_TEMPLATE___VALIDATE = GSNPackage.TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAGE2_TEMPLATE___IMPORT____SAFETYCASE = GSNPackage.TEMPLATE___IMPORT____SAFETYCASE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAGE2_TEMPLATE___INSTANTIATE = GSNPackage.TEMPLATE___INSTANTIATE;

  /**
   * The number of operations of the '<em>Stage2 Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAGE2_TEMPLATE_OPERATION_COUNT = GSNPackage.TEMPLATE_OPERATION_COUNT + 0;


  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.examples.safecomp24.gsn.Stage2Template <em>Stage2 Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stage2 Template</em>'.
   * @see edu.toronto.cs.se.mmint.examples.safecomp24.gsn.Stage2Template
   * @generated
   */
  EClass getStage2Template();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AMLASrFactory getAMLASrFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl.Stage2TemplateImpl <em>Stage2 Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl.Stage2TemplateImpl
     * @see edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl.AMLASrPackageImpl#getStage2Template()
     * @generated
     */
    EClass STAGE2_TEMPLATE = AMLASrPackage.eINSTANCE.getStage2Template();

  }

} //AMLASrPackage
