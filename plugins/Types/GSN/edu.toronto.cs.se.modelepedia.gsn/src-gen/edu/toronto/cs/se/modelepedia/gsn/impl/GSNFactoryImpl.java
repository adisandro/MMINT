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
package edu.toronto.cs.se.modelepedia.gsn.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.ASILLevel;
import edu.toronto.cs.se.modelepedia.gsn.AndSupporter;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.BasicGoal;
import edu.toronto.cs.se.modelepedia.gsn.BasicStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.DomainGoal;
import edu.toronto.cs.se.modelepedia.gsn.EnumDomain;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.IndependenceGoal;
import edu.toronto.cs.se.modelepedia.gsn.IntDomain;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.MofNSupporter;
import edu.toronto.cs.se.modelepedia.gsn.OrSupporter;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.RealDomain;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.ValidityValue;
import edu.toronto.cs.se.modelepedia.gsn.ValueDomain;
import edu.toronto.cs.se.modelepedia.gsn.XorSupporter;

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
      case GSNPackage.INT_DOMAIN: return createIntDomain();
      case GSNPackage.REAL_DOMAIN: return createRealDomain();
      case GSNPackage.ENUM_DOMAIN: return createEnumDomain();
      case GSNPackage.VALUE_DOMAIN: return createValueDomain();
      case GSNPackage.DOMAIN_DECOMPOSITION_STRATEGY: return createDomainDecompositionStrategy();
      case GSNPackage.DOMAIN_GOAL: return createDomainGoal();
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT: return createPropertyDecompositionElement();
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY: return createPropertyDecompositionStrategy();
      case GSNPackage.PROPERTY_GOAL: return createPropertyGoal();
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
      case GSNPackage.MMINT_EXCEPTION:
        return createMMINTExceptionFromString(eDataType, initialValue);
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
      case GSNPackage.MMINT_EXCEPTION:
        return convertMMINTExceptionToString(eDataType, instanceValue);
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
    var safetyCase = new SafetyCaseImpl();
    return safetyCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SupportedBy createSupportedBy() {
    var supportedBy = new SupportedByImpl();
    return supportedBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InContextOf createInContextOf() {
    var inContextOf = new InContextOfImpl();
    return inContextOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BasicGoal createBasicGoal() {
    var basicGoal = new BasicGoalImpl();
    return basicGoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IndependenceGoal createIndependenceGoal() {
    var independenceGoal = new IndependenceGoalImpl();
    return independenceGoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DomainGoal createDomainGoal() {
    var domainGoal = new DomainGoalImpl();
    return domainGoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyDecompositionElement createPropertyDecompositionElement() {
    var propertyDecompositionElement = new PropertyDecompositionElementImpl();
    return propertyDecompositionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyDecompositionStrategy createPropertyDecompositionStrategy() {
    var propertyDecompositionStrategy = new PropertyDecompositionStrategyImpl();
    return propertyDecompositionStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyGoal createPropertyGoal() {
    var propertyGoal = new PropertyGoalImpl();
    return propertyGoal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BasicStrategy createBasicStrategy() {
    var basicStrategy = new BasicStrategyImpl();
    return basicStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASILDecompositionStrategy createASILDecompositionStrategy() {
    var asilDecompositionStrategy = new ASILDecompositionStrategyImpl();
    return asilDecompositionStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution createSolution() {
    var solution = new SolutionImpl();
    return solution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Context createContext() {
    var context = new ContextImpl();
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Justification createJustification() {
    var justification = new JustificationImpl();
    return justification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Assumption createAssumption() {
    var assumption = new AssumptionImpl();
    return assumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASIL createASIL() {
    var asil = new ASILImpl();
    return asil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImpactAnnotation createImpactAnnotation() {
    var impactAnnotation = new ImpactAnnotationImpl();
    return impactAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndSupporter createAndSupporter() {
    var andSupporter = new AndSupporterImpl();
    return andSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OrSupporter createOrSupporter() {
    var orSupporter = new OrSupporterImpl();
    return orSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XorSupporter createXorSupporter() {
    var xorSupporter = new XorSupporterImpl();
    return xorSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MofNSupporter createMofNSupporter() {
    var mofNSupporter = new MofNSupporterImpl();
    return mofNSupporter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntDomain createIntDomain() {
    var intDomain = new IntDomainImpl();
    return intDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RealDomain createRealDomain() {
    var realDomain = new RealDomainImpl();
    return realDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumDomain createEnumDomain() {
    var enumDomain = new EnumDomainImpl();
    return enumDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueDomain createValueDomain() {
    var valueDomain = new ValueDomainImpl();
    return valueDomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DomainDecompositionStrategy createDomainDecompositionStrategy() {
    var domainDecompositionStrategy = new DomainDecompositionStrategyImpl();
    return domainDecompositionStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASILLevel createASILLevelFromString(EDataType eDataType, String initialValue) {
    var result = ASILLevel.get(initialValue);
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
    var result = ValidityValue.get(initialValue);
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
    var result = ImpactType.get(initialValue);
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
  public MMINTException createMMINTExceptionFromString(EDataType eDataType, String initialValue) {
    return (MMINTException)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMMINTExceptionToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
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
