/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNArgumentElement()
   * @generated
   */
  int PLGSN_ARGUMENT_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT__PRESENCE_CONDITION = PLPackage.CLASS__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT__ATTRIBUTES = PLPackage.CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT__REFERENCES = PLPackage.CLASS__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT__REFERENCES_AS_TARGET = PLPackage.CLASS__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT__TYPE = PLPackage.CLASS__TYPE;

  /**
   * The number of structural features of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT_FEATURE_COUNT = PLPackage.CLASS_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_PRODUCT_LINE = PLPackage.CLASS___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___IS_ALWAYS_PRESENT = PLPackage.CLASS___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.CLASS___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_STREAM_OF_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___ADD_REFERENCE__EREFERENCE_CLASS_STRING = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___ADD_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___SET_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_MANY_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_MANY_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Add Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLPackage.CLASS___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLPackage.CLASS___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___INSTANCE_OF__ECLASS = PLPackage.CLASS___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_ECONTAINER = PLPackage.CLASS___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___DELETE = PLPackage.CLASS___DELETE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___INSTANTIATE = PLPackage.CLASS_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___VALIDATE = PLPackage.CLASS_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___GET_IMPACT = PLPackage.CLASS_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Set Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__MAP = PLPackage.CLASS_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Set Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__IMPACTTYPE = PLPackage.CLASS_OPERATION_COUNT + 4;

  /**
   * The number of operations of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ARGUMENT_ELEMENT_OPERATION_COUNT = PLPackage.CLASS_OPERATION_COUNT + 5;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl <em>Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNTemplate()
   * @generated
   */
  int PLGSN_TEMPLATE = 1;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE__PRESENCE_CONDITION = PLPackage.CLASS__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE__ATTRIBUTES = PLPackage.CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE__REFERENCES = PLPackage.CLASS__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE__REFERENCES_AS_TARGET = PLPackage.CLASS__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE__TYPE = PLPackage.CLASS__TYPE;

  /**
   * The number of structural features of the '<em>Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE_FEATURE_COUNT = PLPackage.CLASS_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_PRODUCT_LINE = PLPackage.CLASS___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___IS_ALWAYS_PRESENT = PLPackage.CLASS___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.CLASS___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_REFERENCE__EREFERENCE = PLPackage.CLASS___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS = PLPackage.CLASS___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_MANY_ATTRIBUTE__EATTRIBUTE = PLPackage.CLASS___GET_MANY_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Add Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLPackage.CLASS___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLPackage.CLASS___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___INSTANCE_OF__ECLASS = PLPackage.CLASS___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_ECONTAINER = PLPackage.CLASS___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___DELETE = PLPackage.CLASS___DELETE;

  /**
   * The operation id for the '<em>Get Elements By Id</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___GET_ELEMENTS_BY_ID = PLPackage.CLASS_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___IMPORT____PRODUCTLINE = PLPackage.CLASS_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___INSTANTIATE = PLPackage.CLASS_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___VALIDATE = PLPackage.CLASS_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Next Impact Steps</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___NEXT_IMPACT_STEPS__PLGSNCHANGESTEP = PLPackage.CLASS_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___IMPACT__PLGSNCHANGESTEP = PLPackage.CLASS_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Next Repair Steps</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___NEXT_REPAIR_STEPS__PLGSNCHANGESTEP = PLPackage.CLASS_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Repair</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE___REPAIR__PLGSNCHANGESTEP = PLPackage.CLASS_OPERATION_COUNT + 7;

  /**
   * The number of operations of the '<em>Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_TEMPLATE_OPERATION_COUNT = PLPackage.CLASS_OPERATION_COUNT + 8;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl <em>Analytic Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNAnalyticTemplate()
   * @generated
   */
  int PLGSN_ANALYTIC_TEMPLATE = 2;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE__PRESENCE_CONDITION = PLGSNPackage.PLGSN_TEMPLATE__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE__ATTRIBUTES = PLGSNPackage.PLGSN_TEMPLATE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE__REFERENCES = PLGSNPackage.PLGSN_TEMPLATE__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE__REFERENCES_AS_TARGET = PLGSNPackage.PLGSN_TEMPLATE__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE__TYPE = PLGSNPackage.PLGSN_TEMPLATE__TYPE;

  /**
   * The number of structural features of the '<em>Analytic Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE_FEATURE_COUNT = PLGSNPackage.PLGSN_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_PRODUCT_LINE = PLGSNPackage.PLGSN_TEMPLATE___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___IS_ALWAYS_PRESENT = PLGSNPackage.PLGSN_TEMPLATE___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLGSNPackage.PLGSN_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE = PLGSNPackage.PLGSN_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_REFERENCE__EREFERENCE = PLGSNPackage.PLGSN_TEMPLATE___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING = PLGSNPackage.PLGSN_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS = PLGSNPackage.PLGSN_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS = PLGSNPackage.PLGSN_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.PLGSN_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.PLGSN_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_MANY_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.PLGSN_TEMPLATE___GET_MANY_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLGSNPackage.PLGSN_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Add Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLGSNPackage.PLGSN_TEMPLATE___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLGSNPackage.PLGSN_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLGSNPackage.PLGSN_TEMPLATE___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___INSTANCE_OF__ECLASS = PLGSNPackage.PLGSN_TEMPLATE___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_ECONTAINER = PLGSNPackage.PLGSN_TEMPLATE___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___DELETE = PLGSNPackage.PLGSN_TEMPLATE___DELETE;

  /**
   * The operation id for the '<em>Get Elements By Id</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_ELEMENTS_BY_ID = PLGSNPackage.PLGSN_TEMPLATE___GET_ELEMENTS_BY_ID;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___IMPORT____PRODUCTLINE = PLGSNPackage.PLGSN_TEMPLATE___IMPORT____PRODUCTLINE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___INSTANTIATE = PLGSNPackage.PLGSN_TEMPLATE___INSTANTIATE;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___VALIDATE = PLGSNPackage.PLGSN_TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Next Impact Steps</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___NEXT_IMPACT_STEPS__PLGSNCHANGESTEP = PLGSNPackage.PLGSN_TEMPLATE___NEXT_IMPACT_STEPS__PLGSNCHANGESTEP;

  /**
   * The operation id for the '<em>Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___IMPACT__PLGSNCHANGESTEP = PLGSNPackage.PLGSN_TEMPLATE___IMPACT__PLGSNCHANGESTEP;

  /**
   * The operation id for the '<em>Next Repair Steps</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___NEXT_REPAIR_STEPS__PLGSNCHANGESTEP = PLGSNPackage.PLGSN_TEMPLATE___NEXT_REPAIR_STEPS__PLGSNCHANGESTEP;

  /**
   * The operation id for the '<em>Repair</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___REPAIR__PLGSNCHANGESTEP = PLGSNPackage.PLGSN_TEMPLATE___REPAIR__PLGSNCHANGESTEP;

  /**
   * The operation id for the '<em>Get Analysis</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE___GET_ANALYSIS = PLGSNPackage.PLGSN_TEMPLATE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Analytic Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_ANALYTIC_TEMPLATE_OPERATION_COUNT = PLGSNPackage.PLGSN_TEMPLATE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNRelationshipDecoratorImpl <em>Relationship Decorator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNRelationshipDecoratorImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNRelationshipDecorator()
   * @generated
   */
  int PLGSN_RELATIONSHIP_DECORATOR = 3;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR__PRESENCE_CONDITION = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR__ATTRIBUTES = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR__REFERENCES = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR__REFERENCES_AS_TARGET = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR__TYPE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT__TYPE;

  /**
   * The number of structural features of the '<em>Relationship Decorator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR_FEATURE_COUNT = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_PRODUCT_LINE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___IS_ALWAYS_PRESENT = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_STREAM_OF_REFERENCE__EREFERENCE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_REFERENCE__EREFERENCE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___ADD_REFERENCE__EREFERENCE_CLASS_STRING = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___ADD_REFERENCE__EREFERENCE_CLASS = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___SET_REFERENCE__EREFERENCE_CLASS = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_MANY_ATTRIBUTE__EATTRIBUTE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_MANY_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Add Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Many Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___INSTANCE_OF__ECLASS = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_ECONTAINER = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___DELETE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___DELETE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___INSTANTIATE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___INSTANTIATE;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___VALIDATE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___VALIDATE;

  /**
   * The operation id for the '<em>Get Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___GET_IMPACT = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_IMPACT;

  /**
   * The operation id for the '<em>Set Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___SET_IMPACT__MAP = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__MAP;

  /**
   * The operation id for the '<em>Set Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR___SET_IMPACT__IMPACTTYPE = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__IMPACTTYPE;

  /**
   * The number of operations of the '<em>Relationship Decorator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLGSN_RELATIONSHIP_DECORATOR_OPERATION_COUNT = PLGSNPackage.PLGSN_ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '<em>IPLGSN Analysis</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getIPLGSNAnalysis()
   * @generated
   */
  int IPLGSN_ANALYSIS = 4;

  /**
   * The meta object id for the '<em>Change Step</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNChangeStep()
   * @generated
   */
  int PLGSN_CHANGE_STEP = 5;

  /**
   * The meta object id for the '<em>Optional</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.Optional
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getOptional()
   * @generated
   */
  int OPTIONAL = 6;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Element</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement
   * @generated
   */
  EClass getPLGSNArgumentElement();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#instantiate() <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#instantiate()
   * @generated
   */
  EOperation getPLGSNArgumentElement__Instantiate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#validate() <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#validate()
   * @generated
   */
  EOperation getPLGSNArgumentElement__Validate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#getImpact() <em>Get Impact</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Impact</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#getImpact()
   * @generated
   */
  EOperation getPLGSNArgumentElement__GetImpact();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#setImpact(java.util.Map) <em>Set Impact</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Set Impact</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#setImpact(java.util.Map)
   * @generated
   */
  EOperation getPLGSNArgumentElement__SetImpact__Map();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#setImpact(edu.toronto.cs.se.modelepedia.gsn.ImpactType) <em>Set Impact</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Set Impact</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement#setImpact(edu.toronto.cs.se.modelepedia.gsn.ImpactType)
   * @generated
   */
  EOperation getPLGSNArgumentElement__SetImpact__ImpactType();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate
   * @generated
   */
  EClass getPLGSNTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#getElementsById() <em>Get Elements By Id</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Elements By Id</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#getElementsById()
   * @generated
   */
  EOperation getPLGSNTemplate__GetElementsById();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#validate() <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#validate()
   * @generated
   */
  EOperation getPLGSNTemplate__Validate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#nextImpactSteps(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep) <em>Next Impact Steps</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Next Impact Steps</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#nextImpactSteps(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep)
   * @generated
   */
  EOperation getPLGSNTemplate__NextImpactSteps__PLGSNChangeStep();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#impact(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep) <em>Impact</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Impact</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#impact(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep)
   * @generated
   */
  EOperation getPLGSNTemplate__Impact__PLGSNChangeStep();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#nextRepairSteps(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep) <em>Next Repair Steps</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Next Repair Steps</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#nextRepairSteps(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep)
   * @generated
   */
  EOperation getPLGSNTemplate__NextRepairSteps__PLGSNChangeStep();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#repair(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep) <em>Repair</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Repair</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#repair(edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep)
   * @generated
   */
  EOperation getPLGSNTemplate__Repair__PLGSNChangeStep();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#import_(edu.toronto.cs.se.mmint.productline.ProductLine) <em>Import </em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Import </em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#import_(edu.toronto.cs.se.mmint.productline.ProductLine)
   * @generated
   */
  EOperation getPLGSNTemplate__Import___ProductLine();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#instantiate() <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate#instantiate()
   * @generated
   */
  EOperation getPLGSNTemplate__Instantiate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate <em>Analytic Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analytic Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate
   * @generated
   */
  EClass getPLGSNAnalyticTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate#getAnalysis() <em>Get Analysis</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Analysis</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate#getAnalysis()
   * @generated
   */
  EOperation getPLGSNAnalyticTemplate__GetAnalysis();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNRelationshipDecorator <em>Relationship Decorator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relationship Decorator</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNRelationshipDecorator
   * @generated
   */
  EClass getPLGSNRelationshipDecorator();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis <em>IPLGSN Analysis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IPLGSN Analysis</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis
   * @model instanceClass="edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis"
   * @generated
   */
  EDataType getIPLGSNAnalysis();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep <em>Change Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Change Step</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep
   * @model instanceClass="edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep"
   * @generated
   */
  EDataType getPLGSNChangeStep();

  /**
   * Returns the meta object for data type '{@link java.util.Optional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Optional</em>'.
   * @see java.util.Optional
   * @model instanceClass="java.util.Optional" typeParameters="T"
   * @generated
   */
  EDataType getOptional();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PLGSNFactory getPLGSNFactory();

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
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNArgumentElement()
     * @generated
     */
    EClass PLGSN_ARGUMENT_ELEMENT = PLGSNPackage.eINSTANCE.getPLGSNArgumentElement();
    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_ARGUMENT_ELEMENT___INSTANTIATE = PLGSNPackage.eINSTANCE.getPLGSNArgumentElement__Instantiate();
    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_ARGUMENT_ELEMENT___VALIDATE = PLGSNPackage.eINSTANCE.getPLGSNArgumentElement__Validate();
    /**
     * The meta object literal for the '<em><b>Get Impact</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_ARGUMENT_ELEMENT___GET_IMPACT = PLGSNPackage.eINSTANCE.getPLGSNArgumentElement__GetImpact();
    /**
     * The meta object literal for the '<em><b>Set Impact</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__MAP = PLGSNPackage.eINSTANCE.getPLGSNArgumentElement__SetImpact__Map();
    /**
     * The meta object literal for the '<em><b>Set Impact</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__IMPACTTYPE = PLGSNPackage.eINSTANCE.getPLGSNArgumentElement__SetImpact__ImpactType();
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl <em>Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNTemplate()
     * @generated
     */
    EClass PLGSN_TEMPLATE = PLGSNPackage.eINSTANCE.getPLGSNTemplate();
    /**
     * The meta object literal for the '<em><b>Get Elements By Id</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___GET_ELEMENTS_BY_ID = PLGSNPackage.eINSTANCE.getPLGSNTemplate__GetElementsById();
    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___VALIDATE = PLGSNPackage.eINSTANCE.getPLGSNTemplate__Validate();
    /**
     * The meta object literal for the '<em><b>Next Impact Steps</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___NEXT_IMPACT_STEPS__PLGSNCHANGESTEP = PLGSNPackage.eINSTANCE.getPLGSNTemplate__NextImpactSteps__PLGSNChangeStep();
    /**
     * The meta object literal for the '<em><b>Impact</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___IMPACT__PLGSNCHANGESTEP = PLGSNPackage.eINSTANCE.getPLGSNTemplate__Impact__PLGSNChangeStep();
    /**
     * The meta object literal for the '<em><b>Next Repair Steps</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___NEXT_REPAIR_STEPS__PLGSNCHANGESTEP = PLGSNPackage.eINSTANCE.getPLGSNTemplate__NextRepairSteps__PLGSNChangeStep();
    /**
     * The meta object literal for the '<em><b>Repair</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___REPAIR__PLGSNCHANGESTEP = PLGSNPackage.eINSTANCE.getPLGSNTemplate__Repair__PLGSNChangeStep();
    /**
     * The meta object literal for the '<em><b>Import </b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___IMPORT____PRODUCTLINE = PLGSNPackage.eINSTANCE.getPLGSNTemplate__Import___ProductLine();
    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_TEMPLATE___INSTANTIATE = PLGSNPackage.eINSTANCE.getPLGSNTemplate__Instantiate();
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl <em>Analytic Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNAnalyticTemplate()
     * @generated
     */
    EClass PLGSN_ANALYTIC_TEMPLATE = PLGSNPackage.eINSTANCE.getPLGSNAnalyticTemplate();
    /**
     * The meta object literal for the '<em><b>Get Analysis</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PLGSN_ANALYTIC_TEMPLATE___GET_ANALYSIS = PLGSNPackage.eINSTANCE.getPLGSNAnalyticTemplate__GetAnalysis();
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNRelationshipDecoratorImpl <em>Relationship Decorator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNRelationshipDecoratorImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNRelationshipDecorator()
     * @generated
     */
    EClass PLGSN_RELATIONSHIP_DECORATOR = PLGSNPackage.eINSTANCE.getPLGSNRelationshipDecorator();
    /**
     * The meta object literal for the '<em>IPLGSN Analysis</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getIPLGSNAnalysis()
     * @generated
     */
    EDataType IPLGSN_ANALYSIS = PLGSNPackage.eINSTANCE.getIPLGSNAnalysis();
    /**
     * The meta object literal for the '<em>Change Step</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getPLGSNChangeStep()
     * @generated
     */
    EDataType PLGSN_CHANGE_STEP = PLGSNPackage.eINSTANCE.getPLGSNChangeStep();
    /**
     * The meta object literal for the '<em>Optional</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Optional
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNPackageImpl#getOptional()
     * @generated
     */
    EDataType OPTIONAL = PLGSNPackage.eINSTANCE.getOptional();

  }

} //GSNPLPackage
