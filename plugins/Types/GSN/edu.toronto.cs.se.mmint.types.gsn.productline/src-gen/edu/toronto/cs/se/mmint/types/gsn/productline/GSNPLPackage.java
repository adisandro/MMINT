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
package edu.toronto.cs.se.mmint.types.gsn.productline;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmint.productline.PLPackage;

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
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLFactory
 * @model kind="package"
 * @generated
 */
public interface GSNPLPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "productline";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "model://edu.toronto.cs.se.mmint.types.gsn.productline";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gsn.productline";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GSNPLPackage eINSTANCE = edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLArgumentElementImpl <em>Argument Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLArgumentElementImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLArgumentElement()
   * @generated
   */
  int GSNPL_ARGUMENT_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT__PRESENCE_CONDITION = PLPackage.CLASS__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT__ATTRIBUTES = PLPackage.CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT__REFERENCES = PLPackage.CLASS__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT__REFERENCES_AS_TARGET = PLPackage.CLASS__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT__TYPE = PLPackage.CLASS__TYPE;

  /**
   * The number of structural features of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT_FEATURE_COUNT = PLPackage.CLASS_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___GET_PRODUCT_LINE = PLPackage.CLASS___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___IS_ALWAYS_PRESENT = PLPackage.CLASS___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___VALIDATE__GSNPLTEMPLATE = PLPackage.CLASS_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___INSTANTIATE__GSNPLTEMPLATE = PLPackage.CLASS_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT_OPERATION_COUNT = PLPackage.CLASS_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLTemplateImpl <em>Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLTemplate()
   * @generated
   */
  int GSNPL_TEMPLATE = 1;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE__PRESENCE_CONDITION = PLPackage.CLASS__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE__ATTRIBUTES = PLPackage.CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE__REFERENCES = PLPackage.CLASS__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE__REFERENCES_AS_TARGET = PLPackage.CLASS__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE__TYPE = PLPackage.CLASS__TYPE;

  /**
   * The number of structural features of the '<em>Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE_FEATURE_COUNT = PLPackage.CLASS_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___GET_PRODUCT_LINE = PLPackage.CLASS___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___IS_ALWAYS_PRESENT = PLPackage.CLASS___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___VALIDATE = PLPackage.CLASS_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___IMPORT____PRODUCTLINE = PLPackage.CLASS_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___INSTANTIATE = PLPackage.CLASS_OPERATION_COUNT + 2;

  /**
   * The number of operations of the '<em>Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE_OPERATION_COUNT = PLPackage.CLASS_OPERATION_COUNT + 3;

  /**
   * The meta object id for the '<em>Exception</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Exception
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getException()
   * @generated
   */
  int EXCEPTION = 2;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Element</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement
   * @generated
   */
  EClass getGSNPLArgumentElement();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement#validate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate) <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement#validate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate)
   * @generated
   */
  EOperation getGSNPLArgumentElement__Validate__GSNPLTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement#instantiate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate) <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement#instantiate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate)
   * @generated
   */
  EOperation getGSNPLArgumentElement__Instantiate__GSNPLTemplate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate
   * @generated
   */
  EClass getGSNPLTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate#validate() <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate#validate()
   * @generated
   */
  EOperation getGSNPLTemplate__Validate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate#import_(edu.toronto.cs.se.mmint.productline.ProductLine) <em>Import </em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Import </em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate#import_(edu.toronto.cs.se.mmint.productline.ProductLine)
   * @generated
   */
  EOperation getGSNPLTemplate__Import___ProductLine();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate#instantiate() <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate#instantiate()
   * @generated
   */
  EOperation getGSNPLTemplate__Instantiate();

  /**
   * Returns the meta object for data type '{@link java.lang.Exception <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Exception</em>'.
   * @see java.lang.Exception
   * @model instanceClass="java.lang.Exception" serializeable="false"
   * @generated
   */
  EDataType getException();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GSNPLFactory getGSNPLFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLArgumentElementImpl <em>Argument Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLArgumentElementImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLArgumentElement()
     * @generated
     */
    EClass GSNPL_ARGUMENT_ELEMENT = GSNPLPackage.eINSTANCE.getGSNPLArgumentElement();
    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_ARGUMENT_ELEMENT___VALIDATE__GSNPLTEMPLATE = GSNPLPackage.eINSTANCE.getGSNPLArgumentElement__Validate__GSNPLTemplate();
    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_ARGUMENT_ELEMENT___INSTANTIATE__GSNPLTEMPLATE = GSNPLPackage.eINSTANCE.getGSNPLArgumentElement__Instantiate__GSNPLTemplate();
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLTemplateImpl <em>Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLTemplate()
     * @generated
     */
    EClass GSNPL_TEMPLATE = GSNPLPackage.eINSTANCE.getGSNPLTemplate();
    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_TEMPLATE___VALIDATE = GSNPLPackage.eINSTANCE.getGSNPLTemplate__Validate();
    /**
     * The meta object literal for the '<em><b>Import </b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_TEMPLATE___IMPORT____PRODUCTLINE = GSNPLPackage.eINSTANCE.getGSNPLTemplate__Import___ProductLine();
    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_TEMPLATE___INSTANTIATE = GSNPLPackage.eINSTANCE.getGSNPLTemplate__Instantiate();
    /**
     * The meta object literal for the '<em>Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Exception
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getException()
     * @generated
     */
    EDataType EXCEPTION = GSNPLPackage.eINSTANCE.getException();

  }

} //GSNPLPackage
