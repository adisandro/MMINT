/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 * 
 */
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNFactoryImpl extends EFactoryImpl implements GSNFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GSNFactory init() {
    try {
      GSNFactory theGSNFactory = (GSNFactory)EPackage.Registry.INSTANCE.getEFactory(GSNPackage.eNS_URI);
      if (theGSNFactory != null) {
        return theGSNFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GSNFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case GSNPackage.SAFETY_CASE: return createSafetyCase();
      case GSNPackage.SUPPORTED_BY: return createSupportedBy();
      case GSNPackage.IN_CONTEXT_OF: return createInContextOf();
      case GSNPackage.BASIC_GOAL: return createBasicGoal();
      case GSNPackage.INDEPENDENCE_GOAL: return createIndependenceGoal();
      case GSNPackage.DOMAIN_GOAL: return createDomainGoal();
      case GSNPackage.BASIC_STRATEGY: return createBasicStrategy();
      case GSNPackage.ASIL_DECOMPOSITION_STRATEGY: return createASILDecompositionStrategy();
      case GSNPackage.SOLUTION: return createSolution();
      case GSNPackage.CONTEXT: return createContext();
      case GSNPackage.JUSTIFICATION: return createJustification();
      case GSNPackage.ASSUMPTION: return createAssumption();
      case GSNPackage.ASIL: return createASIL();
      case GSNPackage.IMPACT_ANNOTATION: return createImpactAnnotation();
      case GSNPackage.AND_SUPPORTER: return createAndSupporter();
      case GSNPackage.OR_SUPPORTER: return createOrSupporter();
      case GSNPackage.XOR_SUPPORTER: return createXorSupporter();
      case GSNPackage.MOF_NSUPPORTER: return createMofNSupporter();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case GSNPackage.ASIL_LEVEL:
        return createASILLevelFromString(eDataType, initialValue);
      case GSNPackage.VALIDITY_VALUE:
        return createValidityValueFromString(eDataType, initialValue);
      case GSNPackage.IMPACT_TYPE:
        return createImpactTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case GSNPackage.ASIL_LEVEL:
        return convertASILLevelToString(eDataType, instanceValue);
      case GSNPackage.VALIDITY_VALUE:
        return convertValidityValueToString(eDataType, instanceValue);
      case GSNPackage.IMPACT_TYPE:
        return convertImpactTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SafetyCase createSafetyCase() {
    SafetyCaseImpl safetyCase = new SafetyCaseImpl();
    return safetyCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SupportedBy createSupportedBy() {
    SupportedByImpl supportedBy = new SupportedByImpl();
    return supportedBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InContextOf createInContextOf() {
    InContextOfImpl inContextOf = new InContextOfImpl();
    return inContextOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BasicGoal createBasicGoal() {
    BasicGoalImpl basicGoal = new BasicGoalImpl();
    return basicGoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IndependenceGoal createIndependenceGoal() {
    IndependenceGoalImpl independenceGoal = new IndependenceGoalImpl();
    return independenceGoal;
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
  public BasicStrategy createBasicStrategy() {
    BasicStrategyImpl basicStrategy = new BasicStrategyImpl();
    return basicStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASILDecompositionStrategy createASILDecompositionStrategy() {
    ASILDecompositionStrategyImpl asilDecompositionStrategy = new ASILDecompositionStrategyImpl();
    return asilDecompositionStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution createSolution() {
    SolutionImpl solution = new SolutionImpl();
    return solution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Context createContext() {
    ContextImpl context = new ContextImpl();
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Justification createJustification() {
    JustificationImpl justification = new JustificationImpl();
    return justification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Assumption createAssumption() {
    AssumptionImpl assumption = new AssumptionImpl();
    return assumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASIL createASIL() {
    ASILImpl asil = new ASILImpl();
    return asil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImpactAnnotation createImpactAnnotation() {
    ImpactAnnotationImpl impactAnnotation = new ImpactAnnotationImpl();
    return impactAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndSupporter createAndSupporter() {
    AndSupporterImpl andSupporter = new AndSupporterImpl();
    return andSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OrSupporter createOrSupporter() {
    OrSupporterImpl orSupporter = new OrSupporterImpl();
    return orSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XorSupporter createXorSupporter() {
    XorSupporterImpl xorSupporter = new XorSupporterImpl();
    return xorSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MofNSupporter createMofNSupporter() {
    MofNSupporterImpl mofNSupporter = new MofNSupporterImpl();
    return mofNSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASILLevel createASILLevelFromString(EDataType eDataType, String initialValue) {
    ASILLevel result = ASILLevel.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertASILLevelToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValidityValue createValidityValueFromString(EDataType eDataType, String initialValue) {
    ValidityValue result = ValidityValue.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertValidityValueToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImpactType createImpactTypeFromString(EDataType eDataType, String initialValue) {
    ImpactType result = ImpactType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImpactTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPackage getGSNPackage() {
    return (GSNPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GSNPackage getPackage() {
    return GSNPackage.eINSTANCE;
  }

} //GSNFactoryImpl
