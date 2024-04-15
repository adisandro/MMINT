/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.productline.PLFactory
 * @model kind="package"
 * @generated
 */
public interface PLPackage extends EPackage {
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
  String eNS_URI = "model://edu.toronto.cs.se.mmint.productline";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "productline";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PLPackage eINSTANCE = edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl <em>Product Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getProductLine()
   * @generated
   */
  int PRODUCT_LINE = 0;

  /**
   * The feature id for the '<em><b>Features Constraint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE__FEATURES_CONSTRAINT = 0;

  /**
   * The feature id for the '<em><b>Reasoner Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE__REASONER_NAME = 1;

  /**
   * The feature id for the '<em><b>Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE__CLASSES = 2;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE__METAMODEL = 3;

  /**
   * The number of structural features of the '<em>Product Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE_FEATURE_COUNT = 4;

  /**
   * The operation id for the '<em>Get Reasoner</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE___GET_REASONER = 0;

  /**
   * The number of operations of the '<em>Product Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.PLElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.PLElementImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getPLElement()
   * @generated
   */
  int PL_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_ELEMENT__PRESENCE_CONDITION = 0;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_ELEMENT___GET_PRODUCT_LINE = 0;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_ELEMENT___IS_ALWAYS_PRESENT = 1;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = 2;

  /**
   * The number of operations of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_ELEMENT_OPERATION_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.ClassImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getClass_()
   * @generated
   */
  int CLASS = 2;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__PRESENCE_CONDITION = PLPackage.PL_ELEMENT__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ATTRIBUTES = PLPackage.PL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__REFERENCES = PLPackage.PL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__REFERENCES_AS_TARGET = PLPackage.PL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__TYPE = PLPackage.PL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_FEATURE_COUNT = PLPackage.PL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_PRODUCT_LINE = PLPackage.PL_ELEMENT___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___IS_ALWAYS_PRESENT = PLPackage.PL_ELEMENT___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The operation id for the '<em>Get Stream Of Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE = PLPackage.PL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_REFERENCE__EREFERENCE = PLPackage.PL_ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Add Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___ADD_REFERENCE__EREFERENCE_CLASS = PLPackage.PL_ELEMENT_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Set Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___SET_REFERENCE__EREFERENCE_CLASS = PLPackage.PL_ELEMENT_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Stream Of Reference As Target</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_STREAM_OF_REFERENCE_AS_TARGET__EREFERENCE = PLPackage.PL_ELEMENT_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get Reference As Target</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_REFERENCE_AS_TARGET__EREFERENCE = PLPackage.PL_ELEMENT_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Stream Of Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLPackage.PL_ELEMENT_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Get Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_ATTRIBUTE__EATTRIBUTE = PLPackage.PL_ELEMENT_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Add Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.PL_ELEMENT_OPERATION_COUNT + 8;

  /**
   * The operation id for the '<em>Set Attribute</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.PL_ELEMENT_OPERATION_COUNT + 9;

  /**
   * The operation id for the '<em>Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___INSTANCE_OF__ECLASS = PLPackage.PL_ELEMENT_OPERATION_COUNT + 10;

  /**
   * The operation id for the '<em>Get EContainer</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS___GET_ECONTAINER = PLPackage.PL_ELEMENT_OPERATION_COUNT + 11;

  /**
   * The number of operations of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_OPERATION_COUNT = PLPackage.PL_ELEMENT_OPERATION_COUNT + 12;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 3;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__PRESENCE_CONDITION = PLPackage.PL_ELEMENT__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__TARGET = PLPackage.PL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__TYPE = PLPackage.PL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = PLPackage.PL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE___GET_PRODUCT_LINE = PLPackage.PL_ELEMENT___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE___IS_ALWAYS_PRESENT = PLPackage.PL_ELEMENT___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The number of operations of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_OPERATION_COUNT = PLPackage.PL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.AttributeImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 4;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__PRESENCE_CONDITION = PLPackage.PL_ELEMENT__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = PLPackage.PL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = PLPackage.PL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = PLPackage.PL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_PRODUCT_LINE = PLPackage.PL_ELEMENT___GET_PRODUCT_LINE;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___IS_ALWAYS_PRESENT = PLPackage.PL_ELEMENT___IS_ALWAYS_PRESENT;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;

  /**
   * The number of operations of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_OPERATION_COUNT = PLPackage.PL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '<em>MMINT Exception</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.MMINTException
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getMMINTException()
   * @generated
   */
  int MMINT_EXCEPTION = 5;

  /**
   * The meta object id for the '<em>IPL Features Trait</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getIPLFeaturesTrait()
   * @generated
   */
  int IPL_FEATURES_TRAIT = 6;

  /**
   * The meta object id for the '<em>Stream</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.stream.Stream
   * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getStream()
   * @generated
   */
  int STREAM = 7;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.ProductLine <em>Product Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Product Line</em>'.
   * @see edu.toronto.cs.se.mmint.productline.ProductLine
   * @generated
   */
  EClass getProductLine();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getFeaturesConstraint <em>Features Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Features Constraint</em>'.
   * @see edu.toronto.cs.se.mmint.productline.ProductLine#getFeaturesConstraint()
   * @see #getProductLine()
   * @generated
   */
  EAttribute getProductLine_FeaturesConstraint();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getReasonerName <em>Reasoner Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reasoner Name</em>'.
   * @see edu.toronto.cs.se.mmint.productline.ProductLine#getReasonerName()
   * @see #getProductLine()
   * @generated
   */
  EAttribute getProductLine_ReasonerName();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getClasses <em>Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classes</em>'.
   * @see edu.toronto.cs.se.mmint.productline.ProductLine#getClasses()
   * @see #getProductLine()
   * @generated
   */
  EReference getProductLine_Classes();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metamodel</em>'.
   * @see edu.toronto.cs.se.mmint.productline.ProductLine#getMetamodel()
   * @see #getProductLine()
   * @generated
   */
  EReference getProductLine_Metamodel();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getReasoner() <em>Get Reasoner</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Reasoner</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.ProductLine#getReasoner()
   * @generated
   */
  EOperation getProductLine__GetReasoner();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.PLElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see edu.toronto.cs.se.mmint.productline.PLElement
   * @generated
   */
  EClass getPLElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.productline.PLElement#getPresenceCondition <em>Presence Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Presence Condition</em>'.
   * @see edu.toronto.cs.se.mmint.productline.PLElement#getPresenceCondition()
   * @see #getPLElement()
   * @generated
   */
  EAttribute getPLElement_PresenceCondition();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.PLElement#getProductLine() <em>Get Product Line</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Product Line</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.PLElement#getProductLine()
   * @generated
   */
  EOperation getPLElement__GetProductLine();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.PLElement#isAlwaysPresent() <em>Is Always Present</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Always Present</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.PLElement#isAlwaysPresent()
   * @generated
   */
  EOperation getPLElement__IsAlwaysPresent();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.PLElement#getPresenceConditionLabel(boolean) <em>Get Presence Condition Label</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Presence Condition Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.PLElement#getPresenceConditionLabel(boolean)
   * @generated
   */
  EOperation getPLElement__GetPresenceConditionLabel__boolean();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Class
   * @generated
   */
  EClass getClass_();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.productline.Class#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Class#getAttributes()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.productline.Class#getReferences <em>References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>References</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Class#getReferences()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_References();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.productline.Class#getReferencesAsTarget <em>References As Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>References As Target</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Class#getReferencesAsTarget()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_ReferencesAsTarget();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.productline.Class#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Class#getType()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_Type();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#getStreamOfReference(org.eclipse.emf.ecore.EReference) <em>Get Stream Of Reference</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Stream Of Reference</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#getStreamOfReference(org.eclipse.emf.ecore.EReference)
   * @generated
   */
  EOperation getClass__GetStreamOfReference__EReference();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#getReference(org.eclipse.emf.ecore.EReference) <em>Get Reference</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Reference</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#getReference(org.eclipse.emf.ecore.EReference)
   * @generated
   */
  EOperation getClass__GetReference__EReference();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#addReference(org.eclipse.emf.ecore.EReference, edu.toronto.cs.se.mmint.productline.Class) <em>Add Reference</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Add Reference</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#addReference(org.eclipse.emf.ecore.EReference, edu.toronto.cs.se.mmint.productline.Class)
   * @generated
   */
  EOperation getClass__AddReference__EReference_Class();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#setReference(org.eclipse.emf.ecore.EReference, edu.toronto.cs.se.mmint.productline.Class) <em>Set Reference</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Set Reference</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#setReference(org.eclipse.emf.ecore.EReference, edu.toronto.cs.se.mmint.productline.Class)
   * @generated
   */
  EOperation getClass__SetReference__EReference_Class();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#getStreamOfReferenceAsTarget(org.eclipse.emf.ecore.EReference) <em>Get Stream Of Reference As Target</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Stream Of Reference As Target</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#getStreamOfReferenceAsTarget(org.eclipse.emf.ecore.EReference)
   * @generated
   */
  EOperation getClass__GetStreamOfReferenceAsTarget__EReference();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#getReferenceAsTarget(org.eclipse.emf.ecore.EReference) <em>Get Reference As Target</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Reference As Target</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#getReferenceAsTarget(org.eclipse.emf.ecore.EReference)
   * @generated
   */
  EOperation getClass__GetReferenceAsTarget__EReference();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#getStreamOfAttribute(org.eclipse.emf.ecore.EAttribute) <em>Get Stream Of Attribute</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Stream Of Attribute</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#getStreamOfAttribute(org.eclipse.emf.ecore.EAttribute)
   * @generated
   */
  EOperation getClass__GetStreamOfAttribute__EAttribute();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#getAttribute(org.eclipse.emf.ecore.EAttribute) <em>Get Attribute</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Attribute</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#getAttribute(org.eclipse.emf.ecore.EAttribute)
   * @generated
   */
  EOperation getClass__GetAttribute__EAttribute();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#addAttribute(org.eclipse.emf.ecore.EAttribute, java.lang.String) <em>Add Attribute</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Add Attribute</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#addAttribute(org.eclipse.emf.ecore.EAttribute, java.lang.String)
   * @generated
   */
  EOperation getClass__AddAttribute__EAttribute_String();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#setAttribute(org.eclipse.emf.ecore.EAttribute, java.lang.String) <em>Set Attribute</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Set Attribute</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#setAttribute(org.eclipse.emf.ecore.EAttribute, java.lang.String)
   * @generated
   */
  EOperation getClass__SetAttribute__EAttribute_String();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#instanceOf(org.eclipse.emf.ecore.EClass) <em>Instance Of</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instance Of</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#instanceOf(org.eclipse.emf.ecore.EClass)
   * @generated
   */
  EOperation getClass__InstanceOf__EClass();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.productline.Class#getEContainer() <em>Get EContainer</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get EContainer</em>' operation.
   * @see edu.toronto.cs.se.mmint.productline.Class#getEContainer()
   * @generated
   */
  EOperation getClass__GetEContainer();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.productline.Reference#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Reference#getTarget()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Target();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.productline.Reference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Reference#getType()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Type();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.productline.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.productline.Attribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Attribute#getType()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Type();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.MMINTException <em>MMINT Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>MMINT Exception</em>'.
   * @see edu.toronto.cs.se.mmint.MMINTException
   * @model instanceClass="edu.toronto.cs.se.mmint.MMINTException" serializeable="false"
   * @generated
   */
  EDataType getMMINTException();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait <em>IPL Features Trait</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IPL Features Trait</em>'.
   * @see edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait
   * @model instanceClass="edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait" serializeable="false"
   * @generated
   */
  EDataType getIPLFeaturesTrait();

  /**
   * Returns the meta object for data type '{@link java.util.stream.Stream <em>Stream</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Stream</em>'.
   * @see java.util.stream.Stream
   * @model instanceClass="java.util.stream.Stream" serializeable="false" typeParameters="T"
   * @generated
   */
  EDataType getStream();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PLFactory getPLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl <em>Product Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getProductLine()
     * @generated
     */
    EClass PRODUCT_LINE = PLPackage.eINSTANCE.getProductLine();

    /**
     * The meta object literal for the '<em><b>Features Constraint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRODUCT_LINE__FEATURES_CONSTRAINT = PLPackage.eINSTANCE.getProductLine_FeaturesConstraint();

    /**
     * The meta object literal for the '<em><b>Reasoner Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRODUCT_LINE__REASONER_NAME = PLPackage.eINSTANCE.getProductLine_ReasonerName();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCT_LINE__CLASSES = PLPackage.eINSTANCE.getProductLine_Classes();

    /**
     * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCT_LINE__METAMODEL = PLPackage.eINSTANCE.getProductLine_Metamodel();

    /**
     * The meta object literal for the '<em><b>Get Reasoner</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PRODUCT_LINE___GET_REASONER = PLPackage.eINSTANCE.getProductLine__GetReasoner();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.PLElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.PLElementImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getPLElement()
     * @generated
     */
    EClass PL_ELEMENT = PLPackage.eINSTANCE.getPLElement();

    /**
     * The meta object literal for the '<em><b>Presence Condition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PL_ELEMENT__PRESENCE_CONDITION = PLPackage.eINSTANCE.getPLElement_PresenceCondition();

    /**
     * The meta object literal for the '<em><b>Get Product Line</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_ELEMENT___GET_PRODUCT_LINE = PLPackage.eINSTANCE.getPLElement__GetProductLine();

    /**
     * The meta object literal for the '<em><b>Is Always Present</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_ELEMENT___IS_ALWAYS_PRESENT = PLPackage.eINSTANCE.getPLElement__IsAlwaysPresent();

    /**
     * The meta object literal for the '<em><b>Get Presence Condition Label</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = PLPackage.eINSTANCE.getPLElement__GetPresenceConditionLabel__boolean();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.ClassImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getClass_()
     * @generated
     */
    EClass CLASS = PLPackage.eINSTANCE.getClass_();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__ATTRIBUTES = PLPackage.eINSTANCE.getClass_Attributes();

    /**
     * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__REFERENCES = PLPackage.eINSTANCE.getClass_References();

    /**
     * The meta object literal for the '<em><b>References As Target</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__REFERENCES_AS_TARGET = PLPackage.eINSTANCE.getClass_ReferencesAsTarget();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__TYPE = PLPackage.eINSTANCE.getClass_Type();

    /**
     * The meta object literal for the '<em><b>Get Stream Of Reference</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE = PLPackage.eINSTANCE.getClass__GetStreamOfReference__EReference();

    /**
     * The meta object literal for the '<em><b>Get Reference</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___GET_REFERENCE__EREFERENCE = PLPackage.eINSTANCE.getClass__GetReference__EReference();

    /**
     * The meta object literal for the '<em><b>Add Reference</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___ADD_REFERENCE__EREFERENCE_CLASS = PLPackage.eINSTANCE.getClass__AddReference__EReference_Class();

    /**
     * The meta object literal for the '<em><b>Set Reference</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___SET_REFERENCE__EREFERENCE_CLASS = PLPackage.eINSTANCE.getClass__SetReference__EReference_Class();

    /**
     * The meta object literal for the '<em><b>Get Stream Of Reference As Target</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___GET_STREAM_OF_REFERENCE_AS_TARGET__EREFERENCE = PLPackage.eINSTANCE.getClass__GetStreamOfReferenceAsTarget__EReference();

    /**
     * The meta object literal for the '<em><b>Get Reference As Target</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___GET_REFERENCE_AS_TARGET__EREFERENCE = PLPackage.eINSTANCE.getClass__GetReferenceAsTarget__EReference();

    /**
     * The meta object literal for the '<em><b>Get Stream Of Attribute</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE = PLPackage.eINSTANCE.getClass__GetStreamOfAttribute__EAttribute();

    /**
     * The meta object literal for the '<em><b>Get Attribute</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___GET_ATTRIBUTE__EATTRIBUTE = PLPackage.eINSTANCE.getClass__GetAttribute__EAttribute();

    /**
     * The meta object literal for the '<em><b>Add Attribute</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___ADD_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.eINSTANCE.getClass__AddAttribute__EAttribute_String();

    /**
     * The meta object literal for the '<em><b>Set Attribute</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING = PLPackage.eINSTANCE.getClass__SetAttribute__EAttribute_String();

    /**
     * The meta object literal for the '<em><b>Instance Of</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___INSTANCE_OF__ECLASS = PLPackage.eINSTANCE.getClass__InstanceOf__EClass();

    /**
     * The meta object literal for the '<em><b>Get EContainer</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASS___GET_ECONTAINER = PLPackage.eINSTANCE.getClass__GetEContainer();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = PLPackage.eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__TARGET = PLPackage.eINSTANCE.getReference_Target();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__TYPE = PLPackage.eINSTANCE.getReference_Type();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.AttributeImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = PLPackage.eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = PLPackage.eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__TYPE = PLPackage.eINSTANCE.getAttribute_Type();

    /**
     * The meta object literal for the '<em>MMINT Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.MMINTException
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getMMINTException()
     * @generated
     */
    EDataType MMINT_EXCEPTION = PLPackage.eINSTANCE.getMMINTException();

    /**
     * The meta object literal for the '<em>IPL Features Trait</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getIPLFeaturesTrait()
     * @generated
     */
    EDataType IPL_FEATURES_TRAIT = PLPackage.eINSTANCE.getIPLFeaturesTrait();

    /**
     * The meta object literal for the '<em>Stream</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.stream.Stream
     * @see edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl#getStream()
     * @generated
     */
    EDataType STREAM = PLPackage.eINSTANCE.getStream();

  }

} //PLPackage
