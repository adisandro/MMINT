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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesFactory;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;

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
    case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_TEMPLATE -> createDomainDecompositionTemplate();
    case GSNTemplatesPackage.PROPERTY -> createProperty();
    case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY -> createPropertyDecompositionStrategy();
    case GSNTemplatesPackage.PROPERTY_GOAL -> createPropertyGoal();
    case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_TEMPLATE -> createPropertyDecompositionTemplate();
    case GSNTemplatesPackage.FILES_CONTEXT -> createFilesContext();
    case GSNTemplatesPackage.ANALYTIC_TEMPLATE -> createAnalyticTemplate();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    return switch (eDataType.getClassifierID()) {
    case GSNTemplatesPackage.GSN_TEMPLATES_BUILDER -> createGSNTemplatesBuilderFromString(eDataType, initialValue);
    case GSNTemplatesPackage.IANALYSIS -> createIAnalysisFromString(eDataType, initialValue);
    default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    return switch (eDataType.getClassifierID()) {
    case GSNTemplatesPackage.GSN_TEMPLATES_BUILDER -> convertGSNTemplatesBuilderToString(eDataType, instanceValue);
    case GSNTemplatesPackage.IANALYSIS -> convertIAnalysisToString(eDataType, instanceValue);
    default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
  public DomainDecompositionTemplate createDomainDecompositionTemplate() {
    DomainDecompositionTemplateImpl domainDecompositionTemplate = new DomainDecompositionTemplateImpl();
    return domainDecompositionTemplate;
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
  public PropertyDecompositionTemplate createPropertyDecompositionTemplate() {
    PropertyDecompositionTemplateImpl propertyDecompositionTemplate = new PropertyDecompositionTemplateImpl();
    return propertyDecompositionTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FilesContext createFilesContext() {
    FilesContextImpl filesContext = new FilesContextImpl();
    return filesContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AnalyticTemplate createAnalyticTemplate() {
    AnalyticTemplateImpl analyticTemplate = new AnalyticTemplateImpl();
    return analyticTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNTemplatesBuilder createGSNTemplatesBuilderFromString(EDataType eDataType, String initialValue) {
    return (GSNTemplatesBuilder)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertGSNTemplatesBuilderToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IAnalysis createIAnalysisFromString(EDataType eDataType, String initialValue) {
    return (IAnalysis)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIAnalysisToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
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
