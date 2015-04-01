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
package edu.toronto.cs.se.mmint.mid.relationship.util;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.*;
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
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage
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
				if (result == null) result = caseGenericElement(modelRel);
				if (result == null) result = caseMAVOModel(modelRel);
				if (result == null) result = caseExtendibleElement(modelRel);
				if (result == null) result = caseMAVOElement(modelRel);
				if (result == null) result = caseLogicElement(modelRel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.BINARY_MODEL_REL: {
				BinaryModelRel binaryModelRel = (BinaryModelRel)theEObject;
				T result = caseBinaryModelRel(binaryModelRel);
				if (result == null) result = caseModelRel(binaryModelRel);
				if (result == null) result = caseModel(binaryModelRel);
				if (result == null) result = caseGenericElement(binaryModelRel);
				if (result == null) result = caseMAVOModel(binaryModelRel);
				if (result == null) result = caseExtendibleElement(binaryModelRel);
				if (result == null) result = caseMAVOElement(binaryModelRel);
				if (result == null) result = caseLogicElement(binaryModelRel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE: {
				ExtendibleElementReference extendibleElementReference = (ExtendibleElementReference)theEObject;
				T result = caseExtendibleElementReference(extendibleElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE: {
				ExtendibleElementEndpointReference extendibleElementEndpointReference = (ExtendibleElementEndpointReference)theEObject;
				T result = caseExtendibleElementEndpointReference(extendibleElementEndpointReference);
				if (result == null) result = caseExtendibleElementReference(extendibleElementEndpointReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE: {
				ModelEndpointReference modelEndpointReference = (ModelEndpointReference)theEObject;
				T result = caseModelEndpointReference(modelEndpointReference);
				if (result == null) result = caseExtendibleElementEndpointReference(modelEndpointReference);
				if (result == null) result = caseExtendibleElementReference(modelEndpointReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE: {
				ModelElementReference modelElementReference = (ModelElementReference)theEObject;
				T result = caseModelElementReference(modelElementReference);
				if (result == null) result = caseExtendibleElementReference(modelElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = caseExtendibleElement(link);
				if (result == null) result = caseMAVOElement(link);
				if (result == null) result = caseLogicElement(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.BINARY_LINK: {
				BinaryLink binaryLink = (BinaryLink)theEObject;
				T result = caseBinaryLink(binaryLink);
				if (result == null) result = caseLink(binaryLink);
				if (result == null) result = caseExtendibleElement(binaryLink);
				if (result == null) result = caseMAVOElement(binaryLink);
				if (result == null) result = caseLogicElement(binaryLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT: {
				ModelElementEndpoint modelElementEndpoint = (ModelElementEndpoint)theEObject;
				T result = caseModelElementEndpoint(modelElementEndpoint);
				if (result == null) result = caseExtendibleElementEndpoint(modelElementEndpoint);
				if (result == null) result = caseExtendibleElement(modelElementEndpoint);
				if (result == null) result = caseMAVOElement(modelElementEndpoint);
				if (result == null) result = caseLogicElement(modelElementEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.LINK_REFERENCE: {
				LinkReference linkReference = (LinkReference)theEObject;
				T result = caseLinkReference(linkReference);
				if (result == null) result = caseExtendibleElementReference(linkReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.BINARY_LINK_REFERENCE: {
				BinaryLinkReference binaryLinkReference = (BinaryLinkReference)theEObject;
				T result = caseBinaryLinkReference(binaryLinkReference);
				if (result == null) result = caseLinkReference(binaryLinkReference);
				if (result == null) result = caseExtendibleElementReference(binaryLinkReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE: {
				ModelElementEndpointReference modelElementEndpointReference = (ModelElementEndpointReference)theEObject;
				T result = caseModelElementEndpointReference(modelElementEndpointReference);
				if (result == null) result = caseExtendibleElementEndpointReference(modelElementEndpointReference);
				if (result == null) result = caseExtendibleElementReference(modelElementEndpointReference);
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementEndpoint(ModelElementEndpoint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkReference(LinkReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Link Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryLinkReference(BinaryLinkReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Endpoint Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementEndpointReference(ModelElementEndpointReference object) {
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
	public T caseMAVOModel(MAVOModel object) {
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
