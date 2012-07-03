/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.util;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.TypedElement;

import edu.toronto.cs.se.mmtf.mid.relationship.*;

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
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage
 * @generated
 */
public class RelationshipSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RelationshipPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipSwitch() {
		if (modelPackage == null) {
			modelPackage = RelationshipPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case RelationshipPackage.MODEL_REL: {
				ModelRel modelRel = (ModelRel)theEObject;
				T result = caseModelRel(modelRel);
				if (result == null) result = caseModel(modelRel);
				if (result == null) result = caseExtendibleElement(modelRel);
				if (result == null) result = caseTypedElement(modelRel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.BINARY_MODEL_REL: {
				BinaryModelRel binaryModelRel = (BinaryModelRel)theEObject;
				T result = caseBinaryModelRel(binaryModelRel);
				if (result == null) result = caseModelRel(binaryModelRel);
				if (result == null) result = caseModel(binaryModelRel);
				if (result == null) result = caseExtendibleElement(binaryModelRel);
				if (result == null) result = caseTypedElement(binaryModelRel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.HOMOMORPHISM_MODEL_REL: {
				HomomorphismModelRel homomorphismModelRel = (HomomorphismModelRel)theEObject;
				T result = caseHomomorphismModelRel(homomorphismModelRel);
				if (result == null) result = caseBinaryModelRel(homomorphismModelRel);
				if (result == null) result = caseModelRel(homomorphismModelRel);
				if (result == null) result = caseModel(homomorphismModelRel);
				if (result == null) result = caseExtendibleElement(homomorphismModelRel);
				if (result == null) result = caseTypedElement(homomorphismModelRel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.MODEL_REFERENCE: {
				ModelReference modelReference = (ModelReference)theEObject;
				T result = caseModelReference(modelReference);
				if (result == null) result = caseTypedElementReference(modelReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE: {
				ModelElementReference modelElementReference = (ModelElementReference)theEObject;
				T result = caseModelElementReference(modelElementReference);
				if (result == null) result = caseTypedElementReference(modelElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = caseExtendibleElement(link);
				if (result == null) result = caseTypedElement(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.BINARY_LINK: {
				BinaryLink binaryLink = (BinaryLink)theEObject;
				T result = caseBinaryLink(binaryLink);
				if (result == null) result = caseLink(binaryLink);
				if (result == null) result = caseExtendibleElement(binaryLink);
				if (result == null) result = caseTypedElement(binaryLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.HOMOMORPHISM_LINK: {
				HomomorphismLink homomorphismLink = (HomomorphismLink)theEObject;
				T result = caseHomomorphismLink(homomorphismLink);
				if (result == null) result = caseBinaryLink(homomorphismLink);
				if (result == null) result = caseLink(homomorphismLink);
				if (result == null) result = caseExtendibleElement(homomorphismLink);
				if (result == null) result = caseTypedElement(homomorphismLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE: {
				TypedElementReference typedElementReference = (TypedElementReference)theEObject;
				T result = caseTypedElementReference(typedElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Homomorphism Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Homomorphism Model Rel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHomomorphismModelRel(HomomorphismModelRel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelReference(ModelReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementReference(ModelElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryLink(BinaryLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Homomorphism Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Homomorphism Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHomomorphismLink(HomomorphismLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElementReference(TypedElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
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

} //RelationshipSwitch
