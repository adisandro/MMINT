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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;

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
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisTemplateImpl <em>Analysis Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLAnalysisTemplate()
   * @generated
   */
  int GSNPL_ANALYSIS_TEMPLATE = 2;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE__PRESENCE_CONDITION = GSNPLPackage.GSNPL_TEMPLATE__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE__ATTRIBUTES = GSNPLPackage.GSNPL_TEMPLATE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE__REFERENCES = GSNPLPackage.GSNPL_TEMPLATE__REFERENCES;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE__REFERENCES_AS_TARGET = GSNPLPackage.GSNPL_TEMPLATE__REFERENCES_AS_TARGET;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE__TYPE = GSNPLPackage.GSNPL_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Runner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE__RUNNER = GSNPLPackage.GSNPL_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Analysis Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE_FEATURE_COUNT = GSNPLPackage.GSNPL_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___GET_PRODUCT_LINE = GSNPLPackage.GSNPL_TEMPLATE___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___IS_ALWAYS_PRESENT = GSNPLPackage.GSNPL_TEMPLATE___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = GSNPLPackage.GSNPL_TEMPLATE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE = GSNPLPackage.GSNPL_TEMPLATE___GET_STREAM_OF_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___GET_REFERENCE__EREFERENCE = GSNPLPackage.GSNPL_TEMPLATE___GET_REFERENCE__EREFERENCE;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING = GSNPLPackage.GSNPL_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS_STRING;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS = GSNPLPackage.GSNPL_TEMPLATE___ADD_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS = GSNPLPackage.GSNPL_TEMPLATE___SET_REFERENCE__EREFERENCE_CLASS;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = GSNPLPackage.GSNPL_TEMPLATE___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE = GSNPLPackage.GSNPL_TEMPLATE___GET_ATTRIBUTE__EATTRIBUTE;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING = GSNPLPackage.GSNPL_TEMPLATE___ADD_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING = GSNPLPackage.GSNPL_TEMPLATE___SET_ATTRIBUTE__EATTRIBUTE_STRING;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___INSTANCE_OF__ECLASS = GSNPLPackage.GSNPL_TEMPLATE___INSTANCE_OF__ECLASS;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___GET_ECONTAINER = GSNPLPackage.GSNPL_TEMPLATE___GET_ECONTAINER;

  /**
   * The operation id for the '<em>Delete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___DELETE = GSNPLPackage.GSNPL_TEMPLATE___DELETE;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___VALIDATE = GSNPLPackage.GSNPL_TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___IMPORT____PRODUCTLINE = GSNPLPackage.GSNPL_TEMPLATE___IMPORT____PRODUCTLINE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE___INSTANTIATE = GSNPLPackage.GSNPL_TEMPLATE___INSTANTIATE;

  /**
   * The number of operations of the '<em>Analysis Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_TEMPLATE_OPERATION_COUNT = GSNPLPackage.GSNPL_TEMPLATE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisRunnerImpl <em>Analysis Runner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisRunnerImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLAnalysisRunner()
   * @generated
   */
  int GSNPL_ANALYSIS_RUNNER = 3;

  /**
   * The number of structural features of the '<em>Analysis Runner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_RUNNER_FEATURE_COUNT = GSNTemplatesPackage.ANALYSIS_RUNNER_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_RUNNER___INSTANTIATE__ANALYSISTEMPLATE = GSNTemplatesPackage.ANALYSIS_RUNNER___INSTANTIATE__ANALYSISTEMPLATE;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_RUNNER___VALIDATE__ANALYSISTEMPLATE = GSNTemplatesPackage.ANALYSIS_RUNNER___VALIDATE__ANALYSISTEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_RUNNER___INSTANTIATE__GSNPLANALYSISTEMPLATE = GSNTemplatesPackage.ANALYSIS_RUNNER_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_RUNNER___VALIDATE__GSNPLANALYSISTEMPLATE = GSNTemplatesPackage.ANALYSIS_RUNNER_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>Analysis Runner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSNPL_ANALYSIS_RUNNER_OPERATION_COUNT = GSNTemplatesPackage.ANALYSIS_RUNNER_OPERATION_COUNT + 2;

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
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate <em>Analysis Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate
   * @generated
   */
  EClass getGSNPLAnalysisTemplate();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate#getRunner <em>Runner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Runner</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate#getRunner()
   * @see #getGSNPLAnalysisTemplate()
   * @generated
   */
  EReference getGSNPLAnalysisTemplate_Runner();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner <em>Analysis Runner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Runner</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner
   * @generated
   */
  EClass getGSNPLAnalysisRunner();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner#instantiate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate) <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner#instantiate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate)
   * @generated
   */
  EOperation getGSNPLAnalysisRunner__Instantiate__GSNPLAnalysisTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner#validate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate) <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner#validate(edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate)
   * @generated
   */
  EOperation getGSNPLAnalysisRunner__Validate__GSNPLAnalysisTemplate();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisTemplateImpl <em>Analysis Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLAnalysisTemplate()
     * @generated
     */
    EClass GSNPL_ANALYSIS_TEMPLATE = GSNPLPackage.eINSTANCE.getGSNPLAnalysisTemplate();
    /**
     * The meta object literal for the '<em><b>Runner</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GSNPL_ANALYSIS_TEMPLATE__RUNNER = GSNPLPackage.eINSTANCE.getGSNPLAnalysisTemplate_Runner();
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisRunnerImpl <em>Analysis Runner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisRunnerImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLPackageImpl#getGSNPLAnalysisRunner()
     * @generated
     */
    EClass GSNPL_ANALYSIS_RUNNER = GSNPLPackage.eINSTANCE.getGSNPLAnalysisRunner();
    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_ANALYSIS_RUNNER___INSTANTIATE__GSNPLANALYSISTEMPLATE = GSNPLPackage.eINSTANCE.getGSNPLAnalysisRunner__Instantiate__GSNPLAnalysisTemplate();
    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation GSNPL_ANALYSIS_RUNNER___VALIDATE__GSNPLANALYSISTEMPLATE = GSNPLPackage.eINSTANCE.getGSNPLAnalysisRunner__Validate__GSNPLAnalysisTemplate();

  }

} //GSNPLPackage
