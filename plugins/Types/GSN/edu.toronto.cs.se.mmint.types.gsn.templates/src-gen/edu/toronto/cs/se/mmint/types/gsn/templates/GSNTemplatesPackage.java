/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesFactory
 * @model kind="package"
 * @generated
 */
public interface GSNTemplatesPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "templates";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "model://edu.toronto.cs.se.mmint.types.gsn.templates";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gsn.templates";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GSNTemplatesPackage eINSTANCE = edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DecompositionTemplateImpl <em>Decomposition Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DecompositionTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDecompositionTemplate()
   * @generated
   */
  int DECOMPOSITION_TEMPLATE = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE__ELEMENTS = GSNPackage.TEMPLATE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE__ID = GSNPackage.TEMPLATE__ID;

  /**
   * The number of structural features of the '<em>Decomposition Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE_FEATURE_COUNT = GSNPackage.TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE___VALIDATE = GSNPackage.TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE___IMPORT____SAFETYCASE = GSNPackage.TEMPLATE___IMPORT____SAFETYCASE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE___INSTANTIATE = GSNPackage.TEMPLATE___INSTANTIATE;

  /**
   * The operation id for the '<em>Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE___IMPACT__IMPACTSTEP_OBJECT = GSNPackage.TEMPLATE___IMPACT__IMPACTSTEP_OBJECT;

  /**
   * The operation id for the '<em>Decompose</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER = GSNPackage.TEMPLATE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Decomposition Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_TEMPLATE_OPERATION_COUNT = GSNPackage.TEMPLATE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 1;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = 0;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN___VALIDATE_DECOMPOSITION__ELIST = 0;

  /**
   * The number of operations of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.IntDomainImpl <em>Int Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.IntDomainImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getIntDomain()
   * @generated
   */
  int INT_DOMAIN = 2;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN__LOWER_BOUND = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN__UPPER_BOUND = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Int Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN_FEATURE_COUNT = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNTemplatesPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Int Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN_OPERATION_COUNT = GSNTemplatesPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.RealDomainImpl <em>Real Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.RealDomainImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getRealDomain()
   * @generated
   */
  int REAL_DOMAIN = 3;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN__LOWER_BOUND = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN__UPPER_BOUND = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Real Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN_FEATURE_COUNT = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNTemplatesPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Real Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN_OPERATION_COUNT = GSNTemplatesPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.EnumDomainImpl <em>Enum Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.EnumDomainImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getEnumDomain()
   * @generated
   */
  int ENUM_DOMAIN = 4;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN__VALUES = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN_FEATURE_COUNT = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNTemplatesPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Enum Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN_OPERATION_COUNT = GSNTemplatesPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.ValueDomainImpl <em>Value Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.ValueDomainImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getValueDomain()
   * @generated
   */
  int VALUE_DOMAIN = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN__VALUE = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Value Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN_FEATURE_COUNT = GSNTemplatesPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNTemplatesPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Value Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN_OPERATION_COUNT = GSNTemplatesPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionElementImpl <em>Domain Decomposition Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionElementImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainDecompositionElement()
   * @generated
   */
  int DOMAIN_DECOMPOSITION_ELEMENT = 6;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN = 0;

  /**
   * The number of structural features of the '<em>Domain Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Domain Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionStrategyImpl <em>Domain Decomposition Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionStrategyImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainDecompositionStrategy()
   * @generated
   */
  int DOMAIN_DECOMPOSITION_STRATEGY = 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__ID = GSNPackage.STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__DESCRIPTION = GSNPackage.STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__STATUS = GSNPackage.STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__TEMPLATES = GSNPackage.STRATEGY__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__VALID = GSNPackage.STRATEGY__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__DECORATORS = GSNPackage.STRATEGY__DECORATORS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__SUPPORTED_BY = GSNPackage.STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__UNDEVELOPED = GSNPackage.STRATEGY__UNDEVELOPED;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__SUPPORTS = GSNPackage.STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = GSNPackage.STRATEGY__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN = GSNPackage.STRATEGY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY_FEATURE_COUNT = GSNPackage.STRATEGY_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY___VALIDATE__TEMPLATE = GSNPackage.STRATEGY___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY___INSTANTIATE__TEMPLATE = GSNPackage.STRATEGY___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Domain Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY_OPERATION_COUNT = GSNPackage.STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainGoalImpl <em>Domain Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainGoalImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainGoal()
   * @generated
   */
  int DOMAIN_GOAL = 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__ID = GSNPackage.GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__DESCRIPTION = GSNPackage.GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__STATUS = GSNPackage.GOAL__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__TEMPLATES = GSNPackage.GOAL__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__VALID = GSNPackage.GOAL__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__DECORATORS = GSNPackage.GOAL__DECORATORS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__SUPPORTED_BY = GSNPackage.GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__UNDEVELOPED = GSNPackage.GOAL__UNDEVELOPED;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__SUPPORTS = GSNPackage.GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__IN_CONTEXT_OF = GSNPackage.GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__ASIL = GSNPackage.GOAL__ASIL;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__DOMAIN = GSNPackage.GOAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL_FEATURE_COUNT = GSNPackage.GOAL_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL___VALIDATE__TEMPLATE = GSNPackage.GOAL___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL___INSTANTIATE__TEMPLATE = GSNPackage.GOAL___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Domain Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL_OPERATION_COUNT = GSNPackage.GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionTemplateImpl <em>Domain Decomposition Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainDecompositionTemplate()
   * @generated
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE = 9;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE__ELEMENTS = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE__ID = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE__ID;

  /**
   * The number of structural features of the '<em>Domain Decomposition Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE_FEATURE_COUNT = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE___VALIDATE = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE___IMPORT____SAFETYCASE = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___IMPORT____SAFETYCASE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE___INSTANTIATE = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___INSTANTIATE;

  /**
   * The operation id for the '<em>Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE___IMPACT__IMPACTSTEP_OBJECT = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___IMPACT__IMPACTSTEP_OBJECT;

  /**
   * The operation id for the '<em>Decompose</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER;

  /**
   * The number of operations of the '<em>Domain Decomposition Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_TEMPLATE_OPERATION_COUNT = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 10;

  /**
   * The feature id for the '<em><b>Formal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__FORMAL = 0;

  /**
   * The feature id for the '<em><b>Informal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__INFORMAL = 1;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionElementImpl <em>Property Decomposition Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionElementImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyDecompositionElement()
   * @generated
   */
  int PROPERTY_DECOMPOSITION_ELEMENT = 11;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY = 0;

  /**
   * The number of structural features of the '<em>Property Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Property Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionStrategyImpl <em>Property Decomposition Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionStrategyImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyDecompositionStrategy()
   * @generated
   */
  int PROPERTY_DECOMPOSITION_STRATEGY = 12;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__ID = GSNPackage.STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__DESCRIPTION = GSNPackage.STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__STATUS = GSNPackage.STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__TEMPLATES = GSNPackage.STRATEGY__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__VALID = GSNPackage.STRATEGY__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__DECORATORS = GSNPackage.STRATEGY__DECORATORS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__SUPPORTED_BY = GSNPackage.STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__UNDEVELOPED = GSNPackage.STRATEGY__UNDEVELOPED;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__SUPPORTS = GSNPackage.STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = GSNPackage.STRATEGY__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY = GSNPackage.STRATEGY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Reasoner Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME = GSNPackage.STRATEGY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Property Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY_FEATURE_COUNT = GSNPackage.STRATEGY_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY___VALIDATE__TEMPLATE = GSNPackage.STRATEGY___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY___INSTANTIATE__TEMPLATE = GSNPackage.STRATEGY___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Property Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY_OPERATION_COUNT = GSNPackage.STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyGoalImpl <em>Property Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyGoalImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyGoal()
   * @generated
   */
  int PROPERTY_GOAL = 13;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__ID = GSNPackage.GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__DESCRIPTION = GSNPackage.GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__STATUS = GSNPackage.GOAL__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__TEMPLATES = GSNPackage.GOAL__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__VALID = GSNPackage.GOAL__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__DECORATORS = GSNPackage.GOAL__DECORATORS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__SUPPORTED_BY = GSNPackage.GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__UNDEVELOPED = GSNPackage.GOAL__UNDEVELOPED;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__SUPPORTS = GSNPackage.GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__IN_CONTEXT_OF = GSNPackage.GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__ASIL = GSNPackage.GOAL__ASIL;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__PROPERTY = GSNPackage.GOAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Hint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__HINT = GSNPackage.GOAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Property Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL_FEATURE_COUNT = GSNPackage.GOAL_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL___VALIDATE__TEMPLATE = GSNPackage.GOAL___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL___INSTANTIATE__TEMPLATE = GSNPackage.GOAL___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Property Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL_OPERATION_COUNT = GSNPackage.GOAL_OPERATION_COUNT + 0;


  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionTemplateImpl <em>Property Decomposition Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyDecompositionTemplate()
   * @generated
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE = 14;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE__ELEMENTS = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE__ID = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE__ID;

  /**
   * The number of structural features of the '<em>Property Decomposition Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE_FEATURE_COUNT = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE___VALIDATE = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE___IMPORT____SAFETYCASE = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___IMPORT____SAFETYCASE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE___INSTANTIATE = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___INSTANTIATE;

  /**
   * The operation id for the '<em>Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE___IMPACT__IMPACTSTEP_OBJECT = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___IMPACT__IMPACTSTEP_OBJECT;

  /**
   * The operation id for the '<em>Decompose</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER;

  /**
   * The number of operations of the '<em>Property Decomposition Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_TEMPLATE_OPERATION_COUNT = GSNTemplatesPackage.DECOMPOSITION_TEMPLATE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.FilesContextImpl <em>Files Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.FilesContextImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getFilesContext()
   * @generated
   */
  int FILES_CONTEXT = 15;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT__ID = GSNPackage.CONTEXT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT__DESCRIPTION = GSNPackage.CONTEXT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT__STATUS = GSNPackage.CONTEXT__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT__TEMPLATES = GSNPackage.CONTEXT__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT__VALID = GSNPackage.CONTEXT__VALID;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT__CONTEXT_OF = GSNPackage.CONTEXT__CONTEXT_OF;

  /**
   * The feature id for the '<em><b>Paths</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT__PATHS = GSNPackage.CONTEXT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Files Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT_FEATURE_COUNT = GSNPackage.CONTEXT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT___VALIDATE__TEMPLATE = GSNPackage.CONTEXT___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT___INSTANTIATE__TEMPLATE = GSNPackage.CONTEXT___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Files Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILES_CONTEXT_OPERATION_COUNT = GSNPackage.CONTEXT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalyticTemplateImpl <em>Analytic Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalyticTemplateImpl
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getAnalyticTemplate()
   * @generated
   */
  int ANALYTIC_TEMPLATE = 16;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE__ELEMENTS = GSNPackage.TEMPLATE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE__ID = GSNPackage.TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Analysis Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE__ANALYSIS_PATH = GSNPackage.TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Loader Bundle Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE__LOADER_BUNDLE_NAME = GSNPackage.TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Analytic Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE_FEATURE_COUNT = GSNPackage.TEMPLATE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE___VALIDATE = GSNPackage.TEMPLATE___VALIDATE;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE___IMPORT____SAFETYCASE = GSNPackage.TEMPLATE___IMPORT____SAFETYCASE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE___INSTANTIATE = GSNPackage.TEMPLATE___INSTANTIATE;

  /**
   * The operation id for the '<em>Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE___IMPACT__IMPACTSTEP_OBJECT = GSNPackage.TEMPLATE___IMPACT__IMPACTSTEP_OBJECT;

  /**
   * The operation id for the '<em>Get Analysis</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE___GET_ANALYSIS = GSNPackage.TEMPLATE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Analytic Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYTIC_TEMPLATE_OPERATION_COUNT = GSNPackage.TEMPLATE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '<em>Builder</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getGSNTemplatesBuilder()
   * @generated
   */
  int GSN_TEMPLATES_BUILDER = 17;

  /**
   * The meta object id for the '<em>IAnalysis</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getIAnalysis()
   * @generated
   */
  int IANALYSIS = 18;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionTemplate <em>Decomposition Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decomposition Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionTemplate
   * @generated
   */
  EClass getDecompositionTemplate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionTemplate#decompose(edu.toronto.cs.se.modelepedia.gsn.Goal, edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder) <em>Decompose</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Decompose</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionTemplate#decompose(edu.toronto.cs.se.modelepedia.gsn.Goal, edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder)
   * @generated
   */
  EOperation getDecompositionTemplate__Decompose__Goal_GSNTemplatesBuilder();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.Domain#validateDecomposition(org.eclipse.emf.common.util.EList) <em>Validate Decomposition</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate Decomposition</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.Domain#validateDecomposition(org.eclipse.emf.common.util.EList)
   * @generated
   */
  EOperation getDomain__ValidateDecomposition__EList();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain <em>Int Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Domain</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain
   * @generated
   */
  EClass getIntDomain();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain#getLowerBound()
   * @see #getIntDomain()
   * @generated
   */
  EAttribute getIntDomain_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain#getUpperBound()
   * @see #getIntDomain()
   * @generated
   */
  EAttribute getIntDomain_UpperBound();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain <em>Real Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Domain</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain
   * @generated
   */
  EClass getRealDomain();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain#getLowerBound()
   * @see #getRealDomain()
   * @generated
   */
  EAttribute getRealDomain_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain#getUpperBound()
   * @see #getRealDomain()
   * @generated
   */
  EAttribute getRealDomain_UpperBound();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain <em>Enum Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Domain</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain
   * @generated
   */
  EClass getEnumDomain();

  /**
   * Returns the meta object for the attribute list '{@link edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain#getValues()
   * @see #getEnumDomain()
   * @generated
   */
  EAttribute getEnumDomain_Values();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain <em>Value Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Domain</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain
   * @generated
   */
  EClass getValueDomain();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain#getValue()
   * @see #getValueDomain()
   * @generated
   */
  EAttribute getValueDomain_Value();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement <em>Domain Decomposition Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Decomposition Element</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement
   * @generated
   */
  EClass getDomainDecompositionElement();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement#getDomain()
   * @see #getDomainDecompositionElement()
   * @generated
   */
  EReference getDomainDecompositionElement_Domain();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy <em>Domain Decomposition Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Decomposition Strategy</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy
   * @generated
   */
  EClass getDomainDecompositionStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal <em>Domain Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Goal</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal
   * @generated
   */
  EClass getDomainGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionTemplate <em>Domain Decomposition Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Decomposition Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionTemplate
   * @generated
   */
  EClass getDomainDecompositionTemplate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.Property#getFormal <em>Formal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Formal</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.Property#getFormal()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Formal();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.Property#getInformal <em>Informal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Informal</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.Property#getInformal()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Informal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement <em>Property Decomposition Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Decomposition Element</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement
   * @generated
   */
  EClass getPropertyDecompositionElement();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement#getProperty()
   * @see #getPropertyDecompositionElement()
   * @generated
   */
  EReference getPropertyDecompositionElement_Property();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy <em>Property Decomposition Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Decomposition Strategy</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy
   * @generated
   */
  EClass getPropertyDecompositionStrategy();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy#getReasonerName <em>Reasoner Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reasoner Name</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy#getReasonerName()
   * @see #getPropertyDecompositionStrategy()
   * @generated
   */
  EAttribute getPropertyDecompositionStrategy_ReasonerName();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal <em>Property Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Goal</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal
   * @generated
   */
  EClass getPropertyGoal();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal#getHint <em>Hint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hint</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal#getHint()
   * @see #getPropertyGoal()
   * @generated
   */
  EAttribute getPropertyGoal_Hint();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionTemplate <em>Property Decomposition Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Decomposition Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionTemplate
   * @generated
   */
  EClass getPropertyDecompositionTemplate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext <em>Files Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Files Context</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext
   * @generated
   */
  EClass getFilesContext();

  /**
   * Returns the meta object for the attribute list '{@link edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext#getPaths <em>Paths</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Paths</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext#getPaths()
   * @see #getFilesContext()
   * @generated
   */
  EAttribute getFilesContext_Paths();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate <em>Analytic Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analytic Template</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate
   * @generated
   */
  EClass getAnalyticTemplate();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysisPath <em>Analysis Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Analysis Path</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysisPath()
   * @see #getAnalyticTemplate()
   * @generated
   */
  EAttribute getAnalyticTemplate_AnalysisPath();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getLoaderBundleName <em>Loader Bundle Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Loader Bundle Name</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getLoaderBundleName()
   * @see #getAnalyticTemplate()
   * @generated
   */
  EAttribute getAnalyticTemplate_LoaderBundleName();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysis() <em>Get Analysis</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Analysis</em>' operation.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysis()
   * @generated
   */
  EOperation getAnalyticTemplate__GetAnalysis();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder <em>Builder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Builder</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder
   * @model instanceClass="edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder"
   * @generated
   */
  EDataType getGSNTemplatesBuilder();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis <em>IAnalysis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IAnalysis</em>'.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis
   * @model instanceClass="edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis"
   * @generated
   */
  EDataType getIAnalysis();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GSNTemplatesFactory getGSNTemplatesFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DecompositionTemplateImpl <em>Decomposition Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DecompositionTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDecompositionTemplate()
     * @generated
     */
    EClass DECOMPOSITION_TEMPLATE = GSNTemplatesPackage.eINSTANCE.getDecompositionTemplate();

    /**
     * The meta object literal for the '<em><b>Decompose</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER = GSNTemplatesPackage.eINSTANCE.getDecompositionTemplate__Decompose__Goal_GSNTemplatesBuilder();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = GSNTemplatesPackage.eINSTANCE.getDomain();

    /**
     * The meta object literal for the '<em><b>Validate Decomposition</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNTemplatesPackage.eINSTANCE.getDomain__ValidateDecomposition__EList();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.IntDomainImpl <em>Int Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.IntDomainImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getIntDomain()
     * @generated
     */
    EClass INT_DOMAIN = GSNTemplatesPackage.eINSTANCE.getIntDomain();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_DOMAIN__LOWER_BOUND = GSNTemplatesPackage.eINSTANCE.getIntDomain_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_DOMAIN__UPPER_BOUND = GSNTemplatesPackage.eINSTANCE.getIntDomain_UpperBound();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.RealDomainImpl <em>Real Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.RealDomainImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getRealDomain()
     * @generated
     */
    EClass REAL_DOMAIN = GSNTemplatesPackage.eINSTANCE.getRealDomain();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_DOMAIN__LOWER_BOUND = GSNTemplatesPackage.eINSTANCE.getRealDomain_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_DOMAIN__UPPER_BOUND = GSNTemplatesPackage.eINSTANCE.getRealDomain_UpperBound();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.EnumDomainImpl <em>Enum Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.EnumDomainImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getEnumDomain()
     * @generated
     */
    EClass ENUM_DOMAIN = GSNTemplatesPackage.eINSTANCE.getEnumDomain();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_DOMAIN__VALUES = GSNTemplatesPackage.eINSTANCE.getEnumDomain_Values();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.ValueDomainImpl <em>Value Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.ValueDomainImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getValueDomain()
     * @generated
     */
    EClass VALUE_DOMAIN = GSNTemplatesPackage.eINSTANCE.getValueDomain();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_DOMAIN__VALUE = GSNTemplatesPackage.eINSTANCE.getValueDomain_Value();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionElementImpl <em>Domain Decomposition Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionElementImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainDecompositionElement()
     * @generated
     */
    EClass DOMAIN_DECOMPOSITION_ELEMENT = GSNTemplatesPackage.eINSTANCE.getDomainDecompositionElement();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN = GSNTemplatesPackage.eINSTANCE.getDomainDecompositionElement_Domain();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionStrategyImpl <em>Domain Decomposition Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionStrategyImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainDecompositionStrategy()
     * @generated
     */
    EClass DOMAIN_DECOMPOSITION_STRATEGY = GSNTemplatesPackage.eINSTANCE.getDomainDecompositionStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainGoalImpl <em>Domain Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainGoalImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainGoal()
     * @generated
     */
    EClass DOMAIN_GOAL = GSNTemplatesPackage.eINSTANCE.getDomainGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionTemplateImpl <em>Domain Decomposition Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getDomainDecompositionTemplate()
     * @generated
     */
    EClass DOMAIN_DECOMPOSITION_TEMPLATE = GSNTemplatesPackage.eINSTANCE.getDomainDecompositionTemplate();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = GSNTemplatesPackage.eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Formal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__FORMAL = GSNTemplatesPackage.eINSTANCE.getProperty_Formal();

    /**
     * The meta object literal for the '<em><b>Informal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__INFORMAL = GSNTemplatesPackage.eINSTANCE.getProperty_Informal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionElementImpl <em>Property Decomposition Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionElementImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyDecompositionElement()
     * @generated
     */
    EClass PROPERTY_DECOMPOSITION_ELEMENT = GSNTemplatesPackage.eINSTANCE.getPropertyDecompositionElement();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY = GSNTemplatesPackage.eINSTANCE.getPropertyDecompositionElement_Property();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionStrategyImpl <em>Property Decomposition Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionStrategyImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyDecompositionStrategy()
     * @generated
     */
    EClass PROPERTY_DECOMPOSITION_STRATEGY = GSNTemplatesPackage.eINSTANCE.getPropertyDecompositionStrategy();

    /**
     * The meta object literal for the '<em><b>Reasoner Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME = GSNTemplatesPackage.eINSTANCE.getPropertyDecompositionStrategy_ReasonerName();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyGoalImpl <em>Property Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyGoalImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyGoal()
     * @generated
     */
    EClass PROPERTY_GOAL = GSNTemplatesPackage.eINSTANCE.getPropertyGoal();

    /**
     * The meta object literal for the '<em><b>Hint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_GOAL__HINT = GSNTemplatesPackage.eINSTANCE.getPropertyGoal_Hint();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionTemplateImpl <em>Property Decomposition Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getPropertyDecompositionTemplate()
     * @generated
     */
    EClass PROPERTY_DECOMPOSITION_TEMPLATE = GSNTemplatesPackage.eINSTANCE.getPropertyDecompositionTemplate();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.FilesContextImpl <em>Files Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.FilesContextImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getFilesContext()
     * @generated
     */
    EClass FILES_CONTEXT = GSNTemplatesPackage.eINSTANCE.getFilesContext();

    /**
     * The meta object literal for the '<em><b>Paths</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILES_CONTEXT__PATHS = GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalyticTemplateImpl <em>Analytic Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalyticTemplateImpl
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getAnalyticTemplate()
     * @generated
     */
    EClass ANALYTIC_TEMPLATE = GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate();

    /**
     * The meta object literal for the '<em><b>Analysis Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANALYTIC_TEMPLATE__ANALYSIS_PATH = GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_AnalysisPath();

    /**
     * The meta object literal for the '<em><b>Loader Bundle Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANALYTIC_TEMPLATE__LOADER_BUNDLE_NAME = GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_LoaderBundleName();

    /**
     * The meta object literal for the '<em><b>Get Analysis</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ANALYTIC_TEMPLATE___GET_ANALYSIS = GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate__GetAnalysis();

    /**
     * The meta object literal for the '<em>Builder</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getGSNTemplatesBuilder()
     * @generated
     */
    EDataType GSN_TEMPLATES_BUILDER = GSNTemplatesPackage.eINSTANCE.getGSNTemplatesBuilder();

    /**
     * The meta object literal for the '<em>IAnalysis</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis
     * @see edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesPackageImpl#getIAnalysis()
     * @generated
     */
    EDataType IANALYSIS = GSNTemplatesPackage.eINSTANCE.getIAnalysis();

  }

} //GSNTemplatesPackage
