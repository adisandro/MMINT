/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.util;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.modelepedia.istar_mavo.*;

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
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage
 * @generated
 */
public class IStar_MAVOSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IStar_MAVOPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStar_MAVOSwitch() {
		if (modelPackage == null) {
			modelPackage = IStar_MAVOPackage.eINSTANCE;
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
			case IStar_MAVOPackage.ISTAR: {
				IStar iStar = (IStar)theEObject;
				T result = caseIStar(iStar);
				if (result == null) result = caseMAVORoot(iStar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.ACTOR: {
				Actor actor = (Actor)theEObject;
				T result = caseActor(actor);
				if (result == null) result = caseDependencyEndpoint(actor);
				if (result == null) result = caseMAVOElement(actor);
				if (result == null) result = caseLogicElement(actor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.INTENTION: {
				Intention intention = (Intention)theEObject;
				T result = caseIntention(intention);
				if (result == null) result = caseDependencyEndpoint(intention);
				if (result == null) result = caseMAVOElement(intention);
				if (result == null) result = caseLogicElement(intention);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseIntention(task);
				if (result == null) result = caseDependencyEndpoint(task);
				if (result == null) result = caseMAVOElement(task);
				if (result == null) result = caseLogicElement(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseIntention(resource);
				if (result == null) result = caseDependencyEndpoint(resource);
				if (result == null) result = caseMAVOElement(resource);
				if (result == null) result = caseLogicElement(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.GOAL: {
				Goal goal = (Goal)theEObject;
				T result = caseGoal(goal);
				if (result == null) result = caseIntention(goal);
				if (result == null) result = caseDependencyEndpoint(goal);
				if (result == null) result = caseMAVOElement(goal);
				if (result == null) result = caseLogicElement(goal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.SOFT_GOAL: {
				SoftGoal softGoal = (SoftGoal)theEObject;
				T result = caseSoftGoal(softGoal);
				if (result == null) result = caseGoal(softGoal);
				if (result == null) result = caseIntention(softGoal);
				if (result == null) result = caseDependencyEndpoint(softGoal);
				if (result == null) result = caseMAVOElement(softGoal);
				if (result == null) result = caseLogicElement(softGoal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.DEPENDENCY_ENDPOINT: {
				DependencyEndpoint dependencyEndpoint = (DependencyEndpoint)theEObject;
				T result = caseDependencyEndpoint(dependencyEndpoint);
				if (result == null) result = caseMAVOElement(dependencyEndpoint);
				if (result == null) result = caseLogicElement(dependencyEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.INTENTION_LINK: {
				IntentionLink intentionLink = (IntentionLink)theEObject;
				T result = caseIntentionLink(intentionLink);
				if (result == null) result = caseMAVOElement(intentionLink);
				if (result == null) result = caseLogicElement(intentionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.MEANS_END: {
				MeansEnd meansEnd = (MeansEnd)theEObject;
				T result = caseMeansEnd(meansEnd);
				if (result == null) result = caseIntentionLink(meansEnd);
				if (result == null) result = caseMAVOElement(meansEnd);
				if (result == null) result = caseLogicElement(meansEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.DECOMPOSITION: {
				Decomposition decomposition = (Decomposition)theEObject;
				T result = caseDecomposition(decomposition);
				if (result == null) result = caseIntentionLink(decomposition);
				if (result == null) result = caseMAVOElement(decomposition);
				if (result == null) result = caseLogicElement(decomposition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.CONTRIBUTION: {
				Contribution contribution = (Contribution)theEObject;
				T result = caseContribution(contribution);
				if (result == null) result = caseIntentionLink(contribution);
				if (result == null) result = caseMAVOElement(contribution);
				if (result == null) result = caseLogicElement(contribution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.DEPENDER_LINK: {
				DependerLink dependerLink = (DependerLink)theEObject;
				T result = caseDependerLink(dependerLink);
				if (result == null) result = caseMAVOElement(dependerLink);
				if (result == null) result = caseLogicElement(dependerLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IStar_MAVOPackage.DEPENDEE_LINK: {
				DependeeLink dependeeLink = (DependeeLink)theEObject;
				T result = caseDependeeLink(dependeeLink);
				if (result == null) result = caseMAVOElement(dependeeLink);
				if (result == null) result = caseLogicElement(dependeeLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IStar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IStar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIStar(IStar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActor(Actor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intention</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intention</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntention(Intention object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Soft Goal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Soft Goal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSoftGoal(SoftGoal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyEndpoint(DependencyEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intention Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intention Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntentionLink(IntentionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Means End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Means End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeansEnd(MeansEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decomposition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecomposition(Decomposition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContribution(Contribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Depender Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depender Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependerLink(DependerLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependee Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependee Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependeeLink(DependeeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAVORoot(MAVORoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicElement(LogicElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAVOElement(MAVOElement object) {
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

} //IStar_MAVOSwitch
