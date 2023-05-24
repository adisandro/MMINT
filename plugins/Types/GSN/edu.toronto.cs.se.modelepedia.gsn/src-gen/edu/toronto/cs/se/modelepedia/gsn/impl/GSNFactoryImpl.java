/*******************************************************************************
 * Copyright (c) 2017, 2023 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.ASILLevel;
import edu.toronto.cs.se.modelepedia.gsn.AndSupporter;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.BasicGoal;
import edu.toronto.cs.se.modelepedia.gsn.BasicStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.IndependenceGoal;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.MofNSupporter;
import edu.toronto.cs.se.modelepedia.gsn.OrSupporter;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Template;
import edu.toronto.cs.se.modelepedia.gsn.ValidityValue;
import edu.toronto.cs.se.modelepedia.gsn.XorSupporter;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class GSNFactoryImpl extends EFactoryImpl implements GSNFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static GSNFactory init() {
    try {
      var theGSNFactory = (GSNFactory)EPackage.Registry.INSTANCE.getEFactory(GSNPackage.eNS_URI);
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public GSNFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    return switch (eClass.getClassifierID()) {
    case GSNPackage.SAFETY_CASE -> createSafetyCase();
    case GSNPackage.SUPPORTED_BY -> createSupportedBy();
    case GSNPackage.IN_CONTEXT_OF -> createInContextOf();
    case GSNPackage.BASIC_GOAL -> createBasicGoal();
    case GSNPackage.INDEPENDENCE_GOAL -> createIndependenceGoal();
    case GSNPackage.BASIC_STRATEGY -> createBasicStrategy();
    case GSNPackage.ASIL_DECOMPOSITION_STRATEGY -> createASILDecompositionStrategy();
    case GSNPackage.SOLUTION -> createSolution();
    case GSNPackage.CONTEXT -> createContext();
    case GSNPackage.JUSTIFICATION -> createJustification();
    case GSNPackage.ASSUMPTION -> createAssumption();
    case GSNPackage.ASIL -> createASIL();
    case GSNPackage.IMPACT_ANNOTATION -> createImpactAnnotation();
    case GSNPackage.AND_SUPPORTER -> createAndSupporter();
    case GSNPackage.OR_SUPPORTER -> createOrSupporter();
    case GSNPackage.XOR_SUPPORTER -> createXorSupporter();
    case GSNPackage.MOF_NSUPPORTER -> createMofNSupporter();
    case GSNPackage.TEMPLATE -> createTemplate();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    return switch (eDataType.getClassifierID()) {
    case GSNPackage.ASIL_LEVEL -> createASILLevelFromString(eDataType, initialValue);
    case GSNPackage.VALIDITY_VALUE -> createValidityValueFromString(eDataType, initialValue);
    case GSNPackage.IMPACT_TYPE -> createImpactTypeFromString(eDataType, initialValue);
    case GSNPackage.EXCEPTION -> createExceptionFromString(eDataType, initialValue);
    case GSNPackage.GSN_BUILDER -> createGSNBuilderFromString(eDataType, initialValue);
    default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    return switch (eDataType.getClassifierID()) {
    case GSNPackage.ASIL_LEVEL -> convertASILLevelToString(eDataType, instanceValue);
    case GSNPackage.VALIDITY_VALUE -> convertValidityValueToString(eDataType, instanceValue);
    case GSNPackage.IMPACT_TYPE -> convertImpactTypeToString(eDataType, instanceValue);
    case GSNPackage.EXCEPTION -> convertExceptionToString(eDataType, instanceValue);
    case GSNPackage.GSN_BUILDER -> convertGSNBuilderToString(eDataType, instanceValue);
    default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SafetyCase createSafetyCase() {
    SafetyCaseImpl safetyCase = new SafetyCaseImpl();
    return safetyCase;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SupportedBy createSupportedBy() {
    SupportedByImpl supportedBy = new SupportedByImpl();
    return supportedBy;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InContextOf createInContextOf() {
    InContextOfImpl inContextOf = new InContextOfImpl();
    return inContextOf;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BasicGoal createBasicGoal() {
    BasicGoalImpl basicGoal = new BasicGoalImpl();
    return basicGoal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IndependenceGoal createIndependenceGoal() {
    IndependenceGoalImpl independenceGoal = new IndependenceGoalImpl();
    return independenceGoal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BasicStrategy createBasicStrategy() {
    BasicStrategyImpl basicStrategy = new BasicStrategyImpl();
    return basicStrategy;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASILDecompositionStrategy createASILDecompositionStrategy() {
    ASILDecompositionStrategyImpl asilDecompositionStrategy = new ASILDecompositionStrategyImpl();
    return asilDecompositionStrategy;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution createSolution() {
    SolutionImpl solution = new SolutionImpl();
    return solution;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Context createContext() {
    ContextImpl context = new ContextImpl();
    return context;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Justification createJustification() {
    JustificationImpl justification = new JustificationImpl();
    return justification;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Assumption createAssumption() {
    AssumptionImpl assumption = new AssumptionImpl();
    return assumption;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASIL createASIL() {
    ASILImpl asil = new ASILImpl();
    return asil;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImpactAnnotation createImpactAnnotation() {
    ImpactAnnotationImpl impactAnnotation = new ImpactAnnotationImpl();
    return impactAnnotation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndSupporter createAndSupporter() {
    AndSupporterImpl andSupporter = new AndSupporterImpl();
    return andSupporter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OrSupporter createOrSupporter() {
    OrSupporterImpl orSupporter = new OrSupporterImpl();
    return orSupporter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XorSupporter createXorSupporter() {
    XorSupporterImpl xorSupporter = new XorSupporterImpl();
    return xorSupporter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
  @Override
  public Template createTemplate() {
    TemplateImpl template = new TemplateImpl();
    return template;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ASILLevel createASILLevelFromString(EDataType eDataType, String initialValue) {
    var result = ASILLevel.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertASILLevelToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ValidityValue createValidityValueFromString(EDataType eDataType, String initialValue) {
    var result = ValidityValue.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertValidityValueToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ImpactType createImpactTypeFromString(EDataType eDataType, String initialValue) {
    var result = ImpactType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertImpactTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Exception createExceptionFromString(EDataType eDataType, String initialValue) {
    return (Exception)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertExceptionToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNBuilder createGSNBuilderFromString(EDataType eDataType, String initialValue) {
    return (GSNBuilder)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertGSNBuilderToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPackage getGSNPackage() {
    return (GSNPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GSNPackage getPackage() {
    return GSNPackage.eINSTANCE;
  }

} // GSNFactoryImpl
