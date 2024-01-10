/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
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
package edu.toronto.cs.se.modelepedia.gsn.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.BasicGoal;
import edu.toronto.cs.se.modelepedia.gsn.BasicStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.ContextualElement;
import edu.toronto.cs.se.modelepedia.gsn.ContextualizableElement;
import edu.toronto.cs.se.modelepedia.gsn.Decoratable;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;
import edu.toronto.cs.se.modelepedia.gsn.Template;
import edu.toronto.cs.se.modelepedia.gsn.Undeveloped;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage
 * @generated
 */
public class GSNSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static GSNPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public GSNSwitch() {
    if (GSNSwitch.modelPackage == null) {
      GSNSwitch.modelPackage = GSNPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == GSNSwitch.modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case GSNPackage.SAFETY_CASE: {
        var safetyCase = (SafetyCase)theEObject;
        var result = caseSafetyCase(safetyCase);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.ARGUMENT_ELEMENT: {
        var argumentElement = (ArgumentElement)theEObject;
        var result = caseArgumentElement(argumentElement);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.DECORATABLE: {
        var decoratable = (Decoratable)theEObject;
        var result = caseDecoratable(decoratable);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.SUPPORTABLE: {
        var supportable = (Supportable)theEObject;
        var result = caseSupportable(supportable);
        if (result == null) {
          result = caseArgumentElement(supportable);
        }
        if (result == null) {
          result = caseDecoratable(supportable);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.SUPPORTER: {
        var supporter = (Supporter)theEObject;
        var result = caseSupporter(supporter);
        if (result == null) {
          result = caseArgumentElement(supporter);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.SUPPORTED_BY: {
        var supportedBy = (SupportedBy)theEObject;
        var result = caseSupportedBy(supportedBy);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.CONTEXTUALIZABLE_ELEMENT: {
        var contextualizableElement = (ContextualizableElement)theEObject;
        var result = caseContextualizableElement(contextualizableElement);
        if (result == null) {
          result = caseArgumentElement(contextualizableElement);
        }
        if (result == null) {
          result = caseDecoratable(contextualizableElement);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.CONTEXTUAL_ELEMENT: {
        var contextualElement = (ContextualElement)theEObject;
        var result = caseContextualElement(contextualElement);
        if (result == null) {
          result = caseArgumentElement(contextualElement);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.IN_CONTEXT_OF: {
        var inContextOf = (InContextOf)theEObject;
        var result = caseInContextOf(inContextOf);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.ASI_LFUL_ELEMENT: {
        var asiLfulElement = (ASILfulElement)theEObject;
        var result = caseASILfulElement(asiLfulElement);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.GOAL: {
        var goal = (Goal)theEObject;
        var result = caseGoal(goal);
        if (result == null) {
          result = caseSupportable(goal);
        }
        if (result == null) {
          result = caseSupporter(goal);
        }
        if (result == null) {
          result = caseContextualizableElement(goal);
        }
        if (result == null) {
          result = caseASILfulElement(goal);
        }
        if (result == null) {
          result = caseArgumentElement(goal);
        }
        if (result == null) {
          result = caseDecoratable(goal);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.BASIC_GOAL: {
        var basicGoal = (BasicGoal)theEObject;
        var result = caseBasicGoal(basicGoal);
        if (result == null) {
          result = caseGoal(basicGoal);
        }
        if (result == null) {
          result = caseSupportable(basicGoal);
        }
        if (result == null) {
          result = caseSupporter(basicGoal);
        }
        if (result == null) {
          result = caseContextualizableElement(basicGoal);
        }
        if (result == null) {
          result = caseASILfulElement(basicGoal);
        }
        if (result == null) {
          result = caseArgumentElement(basicGoal);
        }
        if (result == null) {
          result = caseDecoratable(basicGoal);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.STRATEGY: {
        var strategy = (Strategy)theEObject;
        var result = caseStrategy(strategy);
        if (result == null) {
          result = caseSupportable(strategy);
        }
        if (result == null) {
          result = caseSupporter(strategy);
        }
        if (result == null) {
          result = caseContextualizableElement(strategy);
        }
        if (result == null) {
          result = caseArgumentElement(strategy);
        }
        if (result == null) {
          result = caseDecoratable(strategy);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.BASIC_STRATEGY: {
        var basicStrategy = (BasicStrategy)theEObject;
        var result = caseBasicStrategy(basicStrategy);
        if (result == null) {
          result = caseStrategy(basicStrategy);
        }
        if (result == null) {
          result = caseSupportable(basicStrategy);
        }
        if (result == null) {
          result = caseSupporter(basicStrategy);
        }
        if (result == null) {
          result = caseContextualizableElement(basicStrategy);
        }
        if (result == null) {
          result = caseArgumentElement(basicStrategy);
        }
        if (result == null) {
          result = caseDecoratable(basicStrategy);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.SOLUTION: {
        var solution = (Solution)theEObject;
        var result = caseSolution(solution);
        if (result == null) {
          result = caseSupporter(solution);
        }
        if (result == null) {
          result = caseArgumentElement(solution);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.CONTEXT: {
        var context = (Context)theEObject;
        var result = caseContext(context);
        if (result == null) {
          result = caseContextualElement(context);
        }
        if (result == null) {
          result = caseArgumentElement(context);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.JUSTIFICATION: {
        var justification = (Justification)theEObject;
        var result = caseJustification(justification);
        if (result == null) {
          result = caseContextualElement(justification);
        }
        if (result == null) {
          result = caseArgumentElement(justification);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.ASSUMPTION: {
        var assumption = (Assumption)theEObject;
        var result = caseAssumption(assumption);
        if (result == null) {
          result = caseContextualElement(assumption);
        }
        if (result == null) {
          result = caseArgumentElement(assumption);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.UNDEVELOPED: {
        var undeveloped = (Undeveloped)theEObject;
        var result = caseUndeveloped(undeveloped);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.ASIL: {
        var asil = (ASIL)theEObject;
        var result = caseASIL(asil);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.IMPACT_ANNOTATION: {
        var impactAnnotation = (ImpactAnnotation)theEObject;
        var result = caseImpactAnnotation(impactAnnotation);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.TEMPLATE: {
        var template = (Template)theEObject;
        var result = caseTemplate(template);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNPackage.RELATIONSHIP_DECORATOR: {
        var relationshipDecorator = (RelationshipDecorator)theEObject;
        var result = caseRelationshipDecorator(relationshipDecorator);
        if (result == null) {
          result = caseSupportable(relationshipDecorator);
        }
        if (result == null) {
          result = caseContextualizableElement(relationshipDecorator);
        }
        if (result == null) {
          result = caseArgumentElement(relationshipDecorator);
        }
        if (result == null) {
          result = caseDecoratable(relationshipDecorator);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Safety Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgumentElement(ArgumentElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decoratable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decoratable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecoratable(Decoratable object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASI Lful Element</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASI Lful Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASILfulElement(ASILfulElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contextual Element</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supported By</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupportedBy(SupportedBy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contextualizable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contextualizable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextualizableElement(ContextualizableElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Context Of</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicGoal(BasicGoal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Strategy</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicStrategy(BasicStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Solution</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supporter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupporter(Supporter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTemplate(Template object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relationship Decorator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relationship Decorator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationshipDecorator(RelationshipDecorator object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Undeveloped</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Undeveloped</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUndeveloped(Undeveloped object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
   * anyway. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} // GSNSwitch
