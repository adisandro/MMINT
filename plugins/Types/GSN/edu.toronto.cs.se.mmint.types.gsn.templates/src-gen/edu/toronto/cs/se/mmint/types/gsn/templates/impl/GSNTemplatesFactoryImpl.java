/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesFactory;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNTemplatesFactoryImpl extends EFactoryImpl implements GSNTemplatesFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GSNTemplatesFactory init() {
    try {
      var theGSNTemplatesFactory = (GSNTemplatesFactory)EPackage.Registry.INSTANCE.getEFactory(GSNTemplatesPackage.eNS_URI);
      if (theGSNTemplatesFactory != null) {
        return theGSNTemplatesFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GSNTemplatesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNTemplatesFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    return switch (eClass.getClassifierID()) {
    case GSNTemplatesPackage.INT_DOMAIN -> createIntDomain();
    case GSNTemplatesPackage.REAL_DOMAIN -> createRealDomain();
    case GSNTemplatesPackage.ENUM_DOMAIN -> createEnumDomain();
    case GSNTemplatesPackage.VALUE_DOMAIN -> createValueDomain();
    case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY -> createDomainDecompositionStrategy();
    case GSNTemplatesPackage.DOMAIN_GOAL -> createDomainGoal();
    case GSNTemplatesPackage.DOMAIN_TEMPLATE -> createDomainTemplate();
    case GSNTemplatesPackage.PROPERTY -> createProperty();
    case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY -> createPropertyDecompositionStrategy();
    case GSNTemplatesPackage.PROPERTY_GOAL -> createPropertyGoal();
    case GSNTemplatesPackage.PROPERTY_TEMPLATE -> createPropertyTemplate();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntDomain createIntDomain() {
    IntDomainImpl intDomain = new IntDomainImpl();
    return intDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RealDomain createRealDomain() {
    RealDomainImpl realDomain = new RealDomainImpl();
    return realDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumDomain createEnumDomain() {
    EnumDomainImpl enumDomain = new EnumDomainImpl();
    return enumDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueDomain createValueDomain() {
    ValueDomainImpl valueDomain = new ValueDomainImpl();
    return valueDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DomainDecompositionStrategy createDomainDecompositionStrategy() {
    DomainDecompositionStrategyImpl domainDecompositionStrategy = new DomainDecompositionStrategyImpl();
    return domainDecompositionStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DomainGoal createDomainGoal() {
    DomainGoalImpl domainGoal = new DomainGoalImpl();
    return domainGoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DomainTemplate createDomainTemplate() {
    DomainTemplateImpl domainTemplate = new DomainTemplateImpl();
    return domainTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Property createProperty() {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyDecompositionStrategy createPropertyDecompositionStrategy() {
    PropertyDecompositionStrategyImpl propertyDecompositionStrategy = new PropertyDecompositionStrategyImpl();
    return propertyDecompositionStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyGoal createPropertyGoal() {
    PropertyGoalImpl propertyGoal = new PropertyGoalImpl();
    return propertyGoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyTemplate createPropertyTemplate() {
    PropertyTemplateImpl propertyTemplate = new PropertyTemplateImpl();
    return propertyTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNTemplatesPackage getGSNTemplatesPackage() {
    return (GSNTemplatesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GSNTemplatesPackage getPackage() {
    return GSNTemplatesPackage.eINSTANCE;
  }

} //GSNTemplatesFactoryImpl
