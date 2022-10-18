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
package edu.toronto.cs.se.mmint.productline;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see edu.toronto.cs.se.mmint.productline.ProductLineFactory
 * @model kind="package"
 * @generated
 */
public interface ProductLinePackage extends EPackage {
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
  ProductLinePackage eINSTANCE = edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl <em>Product Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getProductLine()
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
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE__REFERENCES = 3;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE__METAMODEL = 4;

  /**
   * The number of structural features of the '<em>Product Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCT_LINE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.PLElementImpl <em>PL Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.PLElementImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getPLElement()
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
   * The number of structural features of the '<em>PL Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.ClassImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getClass_()
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
  int CLASS__PRESENCE_CONDITION = ProductLinePackage.PL_ELEMENT__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>References As Source</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__REFERENCES_AS_SOURCE = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>References As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__REFERENCES_AS_TARGET = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ATTRIBUTES = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__TYPE = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_FEATURE_COUNT = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getReference()
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
  int REFERENCE__PRESENCE_CONDITION = ProductLinePackage.PL_ELEMENT__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__SOURCE = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__TARGET = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__TYPE = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.impl.AttributeImpl
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getAttribute()
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
  int ATTRIBUTE__PRESENCE_CONDITION = ProductLinePackage.PL_ELEMENT__PRESENCE_CONDITION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = ProductLinePackage.PL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '<em>MMINT Exception</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.MMINTException
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getMMINTException()
   * @generated
   */
  int MMINT_EXCEPTION = 5;

  /**
   * The meta object id for the '<em>IProduct Line Features Trait</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait
   * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getIProductLineFeaturesTrait()
   * @generated
   */
  int IPRODUCT_LINE_FEATURES_TRAIT = 6;

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
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getReferences <em>References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>References</em>'.
   * @see edu.toronto.cs.se.mmint.productline.ProductLine#getReferences()
   * @see #getProductLine()
   * @generated
   */
  EReference getProductLine_References();

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
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.PLElement <em>PL Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Element</em>'.
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
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Class
   * @generated
   */
  EClass getClass_();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.productline.Class#getReferencesAsSource <em>References As Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>References As Source</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Class#getReferencesAsSource()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_ReferencesAsSource();

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
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.productline.Reference#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see edu.toronto.cs.se.mmint.productline.Reference#getSource()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Source();

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
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait <em>IProduct Line Features Trait</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IProduct Line Features Trait</em>'.
   * @see edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait
   * @model instanceClass="edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait" serializeable="false"
   * @generated
   */
  EDataType getIProductLineFeaturesTrait();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ProductLineFactory getProductLineFactory();

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
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getProductLine()
     * @generated
     */
    EClass PRODUCT_LINE = ProductLinePackage.eINSTANCE.getProductLine();

    /**
     * The meta object literal for the '<em><b>Features Constraint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRODUCT_LINE__FEATURES_CONSTRAINT = ProductLinePackage.eINSTANCE.getProductLine_FeaturesConstraint();

    /**
     * The meta object literal for the '<em><b>Reasoner Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRODUCT_LINE__REASONER_NAME = ProductLinePackage.eINSTANCE.getProductLine_ReasonerName();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCT_LINE__CLASSES = ProductLinePackage.eINSTANCE.getProductLine_Classes();

    /**
     * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCT_LINE__REFERENCES = ProductLinePackage.eINSTANCE.getProductLine_References();

    /**
     * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCT_LINE__METAMODEL = ProductLinePackage.eINSTANCE.getProductLine_Metamodel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.PLElementImpl <em>PL Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.PLElementImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getPLElement()
     * @generated
     */
    EClass PL_ELEMENT = ProductLinePackage.eINSTANCE.getPLElement();

    /**
     * The meta object literal for the '<em><b>Presence Condition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PL_ELEMENT__PRESENCE_CONDITION = ProductLinePackage.eINSTANCE.getPLElement_PresenceCondition();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.ClassImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getClass_()
     * @generated
     */
    EClass CLASS = ProductLinePackage.eINSTANCE.getClass_();

    /**
     * The meta object literal for the '<em><b>References As Source</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__REFERENCES_AS_SOURCE = ProductLinePackage.eINSTANCE.getClass_ReferencesAsSource();

    /**
     * The meta object literal for the '<em><b>References As Target</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__REFERENCES_AS_TARGET = ProductLinePackage.eINSTANCE.getClass_ReferencesAsTarget();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__ATTRIBUTES = ProductLinePackage.eINSTANCE.getClass_Attributes();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__TYPE = ProductLinePackage.eINSTANCE.getClass_Type();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = ProductLinePackage.eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__SOURCE = ProductLinePackage.eINSTANCE.getReference_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__TARGET = ProductLinePackage.eINSTANCE.getReference_Target();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__TYPE = ProductLinePackage.eINSTANCE.getReference_Type();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.impl.AttributeImpl
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = ProductLinePackage.eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = ProductLinePackage.eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__TYPE = ProductLinePackage.eINSTANCE.getAttribute_Type();

    /**
     * The meta object literal for the '<em>MMINT Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.MMINTException
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getMMINTException()
     * @generated
     */
    EDataType MMINT_EXCEPTION = ProductLinePackage.eINSTANCE.getMMINTException();

    /**
     * The meta object literal for the '<em>IProduct Line Features Trait</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait
     * @see edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl#getIProductLineFeaturesTrait()
     * @generated
     */
    EDataType IPRODUCT_LINE_FEATURES_TRAIT = ProductLinePackage.eINSTANCE.getIProductLineFeaturesTrait();

  }

} //ProductLinePackage
