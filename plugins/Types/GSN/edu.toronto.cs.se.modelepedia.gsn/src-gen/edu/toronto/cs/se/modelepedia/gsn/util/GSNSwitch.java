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
package edu.toronto.cs.se.modelepedia.gsn.util;

import edu.toronto.cs.se.modelepedia.gsn.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage
 * @generated
 */
public class GSNSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GSNPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNSwitch() {
    if (modelPackage == null) {
      modelPackage = GSNPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case GSNPackage.SAFETY_CASE: {
        SafetyCase safetyCase = (SafetyCase)theEObject;
        T result = caseSafetyCase(safetyCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.ARGUMENT_ELEMENT: {
        ArgumentElement argumentElement = (ArgumentElement)theEObject;
        T result = caseArgumentElement(argumentElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.STATEFUL_ELEMENT: {
        StatefulElement statefulElement = (StatefulElement)theEObject;
        T result = caseStatefulElement(statefulElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.ASI_LFUL_ELEMENT: {
        ASILfulElement asiLfulElement = (ASILfulElement)theEObject;
        T result = caseASILfulElement(asiLfulElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.CORE_ELEMENT: {
        CoreElement coreElement = (CoreElement)theEObject;
        T result = caseCoreElement(coreElement);
        if (result == null) result = caseArgumentElement(coreElement);
        if (result == null) result = caseSupporter(coreElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT: {
        DecomposableCoreElement decomposableCoreElement = (DecomposableCoreElement)theEObject;
        T result = caseDecomposableCoreElement(decomposableCoreElement);
        if (result == null) result = caseSupportable(decomposableCoreElement);
        if (result == null) result = caseCoreElement(decomposableCoreElement);
        if (result == null) result = caseSupporter(decomposableCoreElement);
        if (result == null) result = caseArgumentElement(decomposableCoreElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.CONTEXTUAL_ELEMENT: {
        ContextualElement contextualElement = (ContextualElement)theEObject;
        T result = caseContextualElement(contextualElement);
        if (result == null) result = caseArgumentElement(contextualElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.SUPPORTED_BY: {
        SupportedBy supportedBy = (SupportedBy)theEObject;
        T result = caseSupportedBy(supportedBy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.IN_CONTEXT_OF: {
        InContextOf inContextOf = (InContextOf)theEObject;
        T result = caseInContextOf(inContextOf);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.GOAL: {
        Goal goal = (Goal)theEObject;
        T result = caseGoal(goal);
        if (result == null) result = caseDecomposableCoreElement(goal);
        if (result == null) result = caseStatefulElement(goal);
        if (result == null) result = caseASILfulElement(goal);
        if (result == null) result = caseSupportable(goal);
        if (result == null) result = caseCoreElement(goal);
        if (result == null) result = caseSupporter(goal);
        if (result == null) result = caseArgumentElement(goal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.BASIC_GOAL: {
        BasicGoal basicGoal = (BasicGoal)theEObject;
        T result = caseBasicGoal(basicGoal);
        if (result == null) result = caseGoal(basicGoal);
        if (result == null) result = caseDecomposableCoreElement(basicGoal);
        if (result == null) result = caseStatefulElement(basicGoal);
        if (result == null) result = caseASILfulElement(basicGoal);
        if (result == null) result = caseSupportable(basicGoal);
        if (result == null) result = caseCoreElement(basicGoal);
        if (result == null) result = caseSupporter(basicGoal);
        if (result == null) result = caseArgumentElement(basicGoal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.INDEPENDENCE_GOAL: {
        IndependenceGoal independenceGoal = (IndependenceGoal)theEObject;
        T result = caseIndependenceGoal(independenceGoal);
        if (result == null) result = caseGoal(independenceGoal);
        if (result == null) result = caseDecomposableCoreElement(independenceGoal);
        if (result == null) result = caseStatefulElement(independenceGoal);
        if (result == null) result = caseASILfulElement(independenceGoal);
        if (result == null) result = caseSupportable(independenceGoal);
        if (result == null) result = caseCoreElement(independenceGoal);
        if (result == null) result = caseSupporter(independenceGoal);
        if (result == null) result = caseArgumentElement(independenceGoal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.STRATEGY: {
        Strategy strategy = (Strategy)theEObject;
        T result = caseStrategy(strategy);
        if (result == null) result = caseDecomposableCoreElement(strategy);
        if (result == null) result = caseSupportable(strategy);
        if (result == null) result = caseCoreElement(strategy);
        if (result == null) result = caseSupporter(strategy);
        if (result == null) result = caseArgumentElement(strategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.BASIC_STRATEGY: {
        BasicStrategy basicStrategy = (BasicStrategy)theEObject;
        T result = caseBasicStrategy(basicStrategy);
        if (result == null) result = caseStrategy(basicStrategy);
        if (result == null) result = caseDecomposableCoreElement(basicStrategy);
        if (result == null) result = caseSupportable(basicStrategy);
        if (result == null) result = caseCoreElement(basicStrategy);
        if (result == null) result = caseSupporter(basicStrategy);
        if (result == null) result = caseArgumentElement(basicStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.ASIL_DECOMPOSITION_STRATEGY: {
        ASILDecompositionStrategy asilDecompositionStrategy = (ASILDecompositionStrategy)theEObject;
        T result = caseASILDecompositionStrategy(asilDecompositionStrategy);
        if (result == null) result = caseStrategy(asilDecompositionStrategy);
        if (result == null) result = caseDecomposableCoreElement(asilDecompositionStrategy);
        if (result == null) result = caseSupportable(asilDecompositionStrategy);
        if (result == null) result = caseCoreElement(asilDecompositionStrategy);
        if (result == null) result = caseSupporter(asilDecompositionStrategy);
        if (result == null) result = caseArgumentElement(asilDecompositionStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.SOLUTION: {
        Solution solution = (Solution)theEObject;
        T result = caseSolution(solution);
        if (result == null) result = caseCoreElement(solution);
        if (result == null) result = caseStatefulElement(solution);
        if (result == null) result = caseArgumentElement(solution);
        if (result == null) result = caseSupporter(solution);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.CONTEXT: {
        Context context = (Context)theEObject;
        T result = caseContext(context);
        if (result == null) result = caseContextualElement(context);
        if (result == null) result = caseArgumentElement(context);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.JUSTIFICATION: {
        Justification justification = (Justification)theEObject;
        T result = caseJustification(justification);
        if (result == null) result = caseContextualElement(justification);
        if (result == null) result = caseArgumentElement(justification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.ASSUMPTION: {
        Assumption assumption = (Assumption)theEObject;
        T result = caseAssumption(assumption);
        if (result == null) result = caseContextualElement(assumption);
        if (result == null) result = caseArgumentElement(assumption);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.ASIL: {
        ASIL asil = (ASIL)theEObject;
        T result = caseASIL(asil);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.IMPACT_ANNOTATION: {
        ImpactAnnotation impactAnnotation = (ImpactAnnotation)theEObject;
        T result = caseImpactAnnotation(impactAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.SUPPORTABLE: {
        Supportable supportable = (Supportable)theEObject;
        T result = caseSupportable(supportable);
        if (result == null) result = caseSupporter(supportable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.SUPPORTER: {
        Supporter supporter = (Supporter)theEObject;
        T result = caseSupporter(supporter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.SUPPORT_CONNECTOR: {
        SupportConnector supportConnector = (SupportConnector)theEObject;
        T result = caseSupportConnector(supportConnector);
        if (result == null) result = caseSupportable(supportConnector);
        if (result == null) result = caseSupporter(supportConnector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.AND_SUPPORTER: {
        AndSupporter andSupporter = (AndSupporter)theEObject;
        T result = caseAndSupporter(andSupporter);
        if (result == null) result = caseSupportConnector(andSupporter);
        if (result == null) result = caseSupportable(andSupporter);
        if (result == null) result = caseSupporter(andSupporter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.OR_SUPPORTER: {
        OrSupporter orSupporter = (OrSupporter)theEObject;
        T result = caseOrSupporter(orSupporter);
        if (result == null) result = caseSupportConnector(orSupporter);
        if (result == null) result = caseSupportable(orSupporter);
        if (result == null) result = caseSupporter(orSupporter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.XOR_SUPPORTER: {
        XorSupporter xorSupporter = (XorSupporter)theEObject;
        T result = caseXorSupporter(xorSupporter);
        if (result == null) result = caseSupportConnector(xorSupporter);
        if (result == null) result = caseSupportable(xorSupporter);
        if (result == null) result = caseSupporter(xorSupporter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.MOF_NSUPPORTER: {
        MofNSupporter mofNSupporter = (MofNSupporter)theEObject;
        T result = caseMofNSupporter(mofNSupporter);
        if (result == null) result = caseSupportConnector(mofNSupporter);
        if (result == null) result = caseSupportable(mofNSupporter);
        if (result == null) result = caseSupporter(mofNSupporter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.DECOMPOSITION_STRATEGY: {
        DecompositionStrategy decompositionStrategy = (DecompositionStrategy)theEObject;
        T result = caseDecompositionStrategy(decompositionStrategy);
        if (result == null) result = caseStrategy(decompositionStrategy);
        if (result == null) result = caseDecomposableCoreElement(decompositionStrategy);
        if (result == null) result = caseSupportable(decompositionStrategy);
        if (result == null) result = caseCoreElement(decompositionStrategy);
        if (result == null) result = caseSupporter(decompositionStrategy);
        if (result == null) result = caseArgumentElement(decompositionStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.DOMAIN: {
        Domain domain = (Domain)theEObject;
        T result = caseDomain(domain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.INT_DOMAIN: {
        IntDomain intDomain = (IntDomain)theEObject;
        T result = caseIntDomain(intDomain);
        if (result == null) result = caseDomain(intDomain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.REAL_DOMAIN: {
        RealDomain realDomain = (RealDomain)theEObject;
        T result = caseRealDomain(realDomain);
        if (result == null) result = caseDomain(realDomain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.ENUM_DOMAIN: {
        EnumDomain enumDomain = (EnumDomain)theEObject;
        T result = caseEnumDomain(enumDomain);
        if (result == null) result = caseDomain(enumDomain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.VALUE_DOMAIN: {
        ValueDomain valueDomain = (ValueDomain)theEObject;
        T result = caseValueDomain(valueDomain);
        if (result == null) result = caseDomain(valueDomain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.DOMAIN_DECOMPOSITION_ELEMENT: {
        DomainDecompositionElement domainDecompositionElement = (DomainDecompositionElement)theEObject;
        T result = caseDomainDecompositionElement(domainDecompositionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.DOMAIN_DECOMPOSITION_STRATEGY: {
        DomainDecompositionStrategy domainDecompositionStrategy = (DomainDecompositionStrategy)theEObject;
        T result = caseDomainDecompositionStrategy(domainDecompositionStrategy);
        if (result == null) result = caseDecompositionStrategy(domainDecompositionStrategy);
        if (result == null) result = caseDomainDecompositionElement(domainDecompositionStrategy);
        if (result == null) result = caseStrategy(domainDecompositionStrategy);
        if (result == null) result = caseDecomposableCoreElement(domainDecompositionStrategy);
        if (result == null) result = caseSupportable(domainDecompositionStrategy);
        if (result == null) result = caseCoreElement(domainDecompositionStrategy);
        if (result == null) result = caseSupporter(domainDecompositionStrategy);
        if (result == null) result = caseArgumentElement(domainDecompositionStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.DOMAIN_GOAL: {
        DomainGoal domainGoal = (DomainGoal)theEObject;
        T result = caseDomainGoal(domainGoal);
        if (result == null) result = caseGoal(domainGoal);
        if (result == null) result = caseDomainDecompositionElement(domainGoal);
        if (result == null) result = caseDecomposableCoreElement(domainGoal);
        if (result == null) result = caseStatefulElement(domainGoal);
        if (result == null) result = caseASILfulElement(domainGoal);
        if (result == null) result = caseSupportable(domainGoal);
        if (result == null) result = caseCoreElement(domainGoal);
        if (result == null) result = caseSupporter(domainGoal);
        if (result == null) result = caseArgumentElement(domainGoal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT: {
        PropertyDecompositionElement propertyDecompositionElement = (PropertyDecompositionElement)theEObject;
        T result = casePropertyDecompositionElement(propertyDecompositionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY: {
        PropertyDecompositionStrategy propertyDecompositionStrategy = (PropertyDecompositionStrategy)theEObject;
        T result = casePropertyDecompositionStrategy(propertyDecompositionStrategy);
        if (result == null) result = caseDecompositionStrategy(propertyDecompositionStrategy);
        if (result == null) result = casePropertyDecompositionElement(propertyDecompositionStrategy);
        if (result == null) result = caseStrategy(propertyDecompositionStrategy);
        if (result == null) result = caseDecomposableCoreElement(propertyDecompositionStrategy);
        if (result == null) result = caseSupportable(propertyDecompositionStrategy);
        if (result == null) result = caseCoreElement(propertyDecompositionStrategy);
        if (result == null) result = caseSupporter(propertyDecompositionStrategy);
        if (result == null) result = caseArgumentElement(propertyDecompositionStrategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GSNPackage.PROPERTY_GOAL: {
        PropertyGoal propertyGoal = (PropertyGoal)theEObject;
        T result = casePropertyGoal(propertyGoal);
        if (result == null) result = caseGoal(propertyGoal);
        if (result == null) result = casePropertyDecompositionElement(propertyGoal);
        if (result == null) result = caseDecomposableCoreElement(propertyGoal);
        if (result == null) result = caseStatefulElement(propertyGoal);
        if (result == null) result = caseASILfulElement(propertyGoal);
        if (result == null) result = caseSupportable(propertyGoal);
        if (result == null) result = caseCoreElement(propertyGoal);
        if (result == null) result = caseSupporter(propertyGoal);
        if (result == null) result = caseArgumentElement(propertyGoal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Safety Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Safety Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSafetyCase(SafetyCase object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Argument Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgumentElement(ArgumentElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stateful Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stateful Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatefulElement(StatefulElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASI Lful Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASI Lful Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASILfulElement(ASILfulElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Core Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Core Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCoreElement(CoreElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decomposable Core Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decomposable Core Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecomposableCoreElement(DecomposableCoreElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contextual Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contextual Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextualElement(ContextualElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Supported By</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supported By</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupportedBy(SupportedBy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Context Of</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Context Of</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInContextOf(InContextOf object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGoal(Goal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicGoal(BasicGoal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Independence Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Independence Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndependenceGoal(IndependenceGoal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainGoal(DomainGoal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Decomposition Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Decomposition Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDecompositionElement(PropertyDecompositionElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Decomposition Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDecompositionStrategy(PropertyDecompositionStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyGoal(PropertyGoal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStrategy(Strategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicStrategy(BasicStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASIL Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASIL Decomposition Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASILDecompositionStrategy(ASILDecompositionStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Solution</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Solution</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSolution(Solution object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContext(Context object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Justification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Justification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJustification(Justification object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assumption</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assumption</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssumption(Assumption object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASIL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASIL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASIL(ASIL object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Impact Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Impact Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImpactAnnotation(ImpactAnnotation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supportable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupportable(Supportable object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Supporter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supporter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupporter(Supporter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Support Connector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Support Connector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupportConnector(SupportConnector object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Supporter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Supporter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndSupporter(AndSupporter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Supporter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Supporter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrSupporter(OrSupporter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Xor Supporter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Xor Supporter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXorSupporter(XorSupporter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mof NSupporter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mof NSupporter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMofNSupporter(MofNSupporter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decomposition Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecompositionStrategy(DecompositionStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomain(Domain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntDomain(IntDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealDomain(RealDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumDomain(EnumDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueDomain(ValueDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Decomposition Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Decomposition Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainDecompositionElement(DomainDecompositionElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Decomposition Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainDecompositionStrategy(DomainDecompositionStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //GSNSwitch
