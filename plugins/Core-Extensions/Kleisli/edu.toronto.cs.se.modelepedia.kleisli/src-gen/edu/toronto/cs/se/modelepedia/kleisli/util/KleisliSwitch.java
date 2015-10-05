/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.kleisli.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

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
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage
 * @generated
 */
public class KleisliSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KleisliPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliSwitch() {
		if (modelPackage == null) {
			modelPackage = KleisliPackage.eINSTANCE;
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
			case KleisliPackage.KLEISLI_MODEL: {
				KleisliModel kleisliModel = (KleisliModel)theEObject;
				T result = caseKleisliModel(kleisliModel);
				if (result == null) result = caseModel(kleisliModel);
				if (result == null) result = caseGenericElement(kleisliModel);
				if (result == null) result = caseExtendibleElement(kleisliModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT: {
				KleisliModelEndpoint kleisliModelEndpoint = (KleisliModelEndpoint)theEObject;
				T result = caseKleisliModelEndpoint(kleisliModelEndpoint);
				if (result == null) result = caseModelEndpoint(kleisliModelEndpoint);
				if (result == null) result = caseExtendibleElementEndpoint(kleisliModelEndpoint);
				if (result == null) result = caseExtendibleElement(kleisliModelEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KleisliPackage.KLEISLI_MODEL_REL: {
				KleisliModelRel kleisliModelRel = (KleisliModelRel)theEObject;
				T result = caseKleisliModelRel(kleisliModelRel);
				if (result == null) result = caseModelRel(kleisliModelRel);
				if (result == null) result = caseModel(kleisliModelRel);
				if (result == null) result = caseGenericElement(kleisliModelRel);
				if (result == null) result = caseExtendibleElement(kleisliModelRel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KleisliPackage.KLEISLI_BINARY_MODEL_REL: {
				KleisliBinaryModelRel kleisliBinaryModelRel = (KleisliBinaryModelRel)theEObject;
				T result = caseKleisliBinaryModelRel(kleisliBinaryModelRel);
				if (result == null) result = caseKleisliModelRel(kleisliBinaryModelRel);
				if (result == null) result = caseBinaryModelRel(kleisliBinaryModelRel);
				if (result == null) result = caseModelRel(kleisliBinaryModelRel);
				if (result == null) result = caseModel(kleisliBinaryModelRel);
				if (result == null) result = caseGenericElement(kleisliBinaryModelRel);
				if (result == null) result = caseExtendibleElement(kleisliBinaryModelRel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT_REFERENCE: {
				KleisliModelEndpointReference kleisliModelEndpointReference = (KleisliModelEndpointReference)theEObject;
				T result = caseKleisliModelEndpointReference(kleisliModelEndpointReference);
				if (result == null) result = caseModelEndpointReference(kleisliModelEndpointReference);
				if (result == null) result = caseExtendibleElementEndpointReference(kleisliModelEndpointReference);
				if (result == null) result = caseExtendibleElementReference(kleisliModelEndpointReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKleisliModel(KleisliModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Rel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKleisliModelRel(KleisliModelRel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKleisliModelEndpoint(KleisliModelEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Model Rel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKleisliBinaryModelRel(KleisliBinaryModelRel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Endpoint Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKleisliModelEndpointReference(KleisliModelEndpointReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extendible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extendible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendibleElement(ExtendibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericElement(GenericElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Rel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelRel(ModelRel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extendible Element Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extendible Element Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendibleElementEndpoint(ExtendibleElementEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelEndpoint(ModelEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Model Rel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryModelRel(BinaryModelRel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extendible Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extendible Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendibleElementReference(ExtendibleElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extendible Element Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extendible Element Endpoint Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendibleElementEndpointReference(ExtendibleElementEndpointReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Endpoint Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelEndpointReference(ModelEndpointReference object) {
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

} //KleisliSwitch
