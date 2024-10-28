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
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNFactory
 * @model kind="package"
 * @generated
 */
public interface PLGSNPackage extends EPackage {
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
  PLGSNPackage eINSTANCE = edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNArgumentElementImpl <em>Argument Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNArgumentElementImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getGSNPLArgumentElement()
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
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.CLASS___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___GET_STREAM_OF_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___GET_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___ADD_REFERENCE__EREFERENCE_CLASS_STRING = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___ADD_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___SET_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___GET_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___INSTANCE_OF__ECLASS = PLPackage.CLASS___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___GET_ECONTAINER = PLPackage.CLASS___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ARGUMENT_ELEMENT___DELETE = PLPackage.CLASS___DELETE;

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
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl <em>Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getGSNPLTemplate()
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
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.CLASS___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___GET_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___INSTANCE_OF__ECLASS = PLPackage.CLASS___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___GET_ECONTAINER = PLPackage.CLASS___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_TEMPLATE___DELETE = PLPackage.CLASS___DELETE;

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
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl <em>Analytic Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getGSNPLAnalyticTemplate()
   * @generated
   */
  int GSNPL_ANALYTIC_TEMPLATE = 2;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE__PRESENCE_CONDITION = PLGSNPackage.GSNPL_TEMPLATE__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE__ATTRIBUTES = PLGSNPackage.GSNPL_TEMPLATE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE__REFERENCES = PLGSNPackage.GSNPL_TEMPLATE__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE__REFERENCES_AS_TARGET = PLGSNPackage.GSNPL_TEMPLATE__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE__TYPE = PLGSNPackage.GSNPL_TEMPLATE__TYPE;

  /**
   * The number of structural features of the '<em>Analytic Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE_FEATURE_COUNT = PLGSNPackage.GSNPL_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_PRODUCT_LINE = PLGSNPackage.GSNPL_TEMPLATE___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___IS_ALWAYS_PRESENT = PLGSNPackage.GSNPL_TEMPLATE___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLGSNPackage.GSNPL_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE = PLGSNPackage.GSNPL_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_REFERENCE__EREFERENCE = PLGSNPackage.GSNPL_TEMPLATE___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING = PLGSNPackage.GSNPL_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS = PLGSNPackage.GSNPL_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS = PLGSNPackage.GSNPL_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.GSNPL_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.GSNPL_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLGSNPackage.GSNPL_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLGSNPackage.GSNPL_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___INSTANCE_OF__ECLASS = PLGSNPackage.GSNPL_TEMPLATE___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_ECONTAINER = PLGSNPackage.GSNPL_TEMPLATE___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___DELETE = PLGSNPackage.GSNPL_TEMPLATE___DELETE;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___VALIDATE = PLGSNPackage.GSNPL_TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___IMPORT____PRODUCTLINE = PLGSNPackage.GSNPL_TEMPLATE___IMPORT____PRODUCTLINE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___INSTANTIATE = PLGSNPackage.GSNPL_TEMPLATE___INSTANTIATE;

  /**
   * The operation id for the '<em>Get Analysis</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE___GET_ANALYSIS = PLGSNPackage.GSNPL_TEMPLATE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Analytic Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYTIC_TEMPLATE_OPERATION_COUNT = PLGSNPackage.GSNPL_TEMPLATE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '<em>IGSNPL Analysis</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getIGSNPLAnalysis()
   * @generated
   */
  int IGSNPL_ANALYSIS = 3;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Element</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement
   * @generated
   */
  EClass getGSNPLArgumentElement();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#validate(edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate) <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#validate(edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate)
   * @generated
   */
  EOperation getGSNPLArgumentElement__Validate__GSNPLTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#instantiate(edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate) <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#instantiate(edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate)
   * @generated
   */
  EOperation getGSNPLArgumentElement__Instantiate__GSNPLTemplate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate
   * @generated
   */
  EClass getGSNPLTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#validate() <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#validate()
   * @generated
   */
  EOperation getGSNPLTemplate__Validate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#import_(edu.toronto.cs.se.mmint.productline.ProductLine) <em>Import </em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Import </em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#import_(edu.toronto.cs.se.mmint.productline.ProductLine)
   * @generated
   */
  EOperation getGSNPLTemplate__Import___ProductLine();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#instantiate() <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#instantiate()
   * @generated
   */
  EOperation getGSNPLTemplate__Instantiate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate <em>Analytic Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analytic Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate
   * @generated
   */
  EClass getGSNPLAnalyticTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate#getAnalysis() <em>Get Analysis</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Analysis</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate#getAnalysis()
   * @generated
   */
  EOperation getGSNPLAnalyticTemplate__GetAnalysis();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis <em>IGSNPL Analysis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IGSNPL Analysis</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis
   * @model instanceClass="edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IGSNPLAnalysis"
   * @generated
   */
  EDataType getIGSNPLAnalysis();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PLGSNFactory getGSNPLFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNArgumentElementImpl <em>Argument Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNArgumentElementImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getGSNPLArgumentElement()
     * @generated
     */
    EClass GSNPL_ARGUMENT_ELEMENT = PLGSNPackage.eINSTANCE.getGSNPLArgumentElement();
    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_ARGUMENT_ELEMENT___VALIDATE__GSNPLTEMPLATE = PLGSNPackage.eINSTANCE.getGSNPLArgumentElement__Validate__GSNPLTemplate();
    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_ARGUMENT_ELEMENT___INSTANTIATE__GSNPLTEMPLATE = PLGSNPackage.eINSTANCE.getGSNPLArgumentElement__Instantiate__GSNPLTemplate();
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl <em>Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getGSNPLTemplate()
     * @generated
     */
    EClass GSNPL_TEMPLATE = PLGSNPackage.eINSTANCE.getGSNPLTemplate();
    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_TEMPLATE___VALIDATE = PLGSNPackage.eINSTANCE.getGSNPLTemplate__Validate();
    /**
     * The meta object literal for the '<em><b>Import </b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_TEMPLATE___IMPORT____PRODUCTLINE = PLGSNPackage.eINSTANCE.getGSNPLTemplate__Import___ProductLine();
    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_TEMPLATE___INSTANTIATE = PLGSNPackage.eINSTANCE.getGSNPLTemplate__Instantiate();
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl <em>Analytic Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getGSNPLAnalyticTemplate()
     * @generated
     */
    EClass GSNPL_ANALYTIC_TEMPLATE = PLGSNPackage.eINSTANCE.getGSNPLAnalyticTemplate();
    /**
     * The meta object literal for the '<em><b>Get Analysis</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_ANALYTIC_TEMPLATE___GET_ANALYSIS = PLGSNPackage.eINSTANCE.getGSNPLAnalyticTemplate__GetAnalysis();
    /**
     * The meta object literal for the '<em>IGSNPL Analysis</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getIGSNPLAnalysis()
     * @generated
     */
    EDataType IGSNPL_ANALYSIS = PLGSNPackage.eINSTANCE.getIGSNPLAnalysis();

  }

} //GSNPLPackage
