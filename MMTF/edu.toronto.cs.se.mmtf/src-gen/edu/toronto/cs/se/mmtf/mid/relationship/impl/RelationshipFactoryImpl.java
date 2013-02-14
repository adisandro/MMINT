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
package edu.toronto.cs.se.mmtf.mid.relationship.impl;

import edu.toronto.cs.se.mmtf.mid.relationship.*;

import org.eclipse.emf.ecore.EClass;
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
public class RelationshipFactoryImpl extends EFactoryImpl implements RelationshipFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelationshipFactory init() {
		try {
			RelationshipFactory theRelationshipFactory = (RelationshipFactory)EPackage.Registry.INSTANCE.getEFactory("http://se.cs.toronto.edu/mmtf/MID/Relationship"); 
			if (theRelationshipFactory != null) {
				return theRelationshipFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RelationshipFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipFactoryImpl() {
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
			case RelationshipPackage.MODEL_REL: return createModelRel();
			case RelationshipPackage.BINARY_MODEL_REL: return createBinaryModelRel();
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE: return createModelEndpointReference();
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE: return createModelElementReference();
			case RelationshipPackage.LINK: return createLink();
			case RelationshipPackage.BINARY_LINK: return createBinaryLink();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT: return createModelElementEndpoint();
			case RelationshipPackage.LINK_REFERENCE: return createLinkReference();
			case RelationshipPackage.BINARY_LINK_REFERENCE: return createBinaryLinkReference();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE: return createModelElementEndpointReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRel createModelRel() {
		ModelRelImpl modelRel = new ModelRelImpl();
		return modelRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryModelRel createBinaryModelRel() {
		BinaryModelRelImpl binaryModelRel = new BinaryModelRelImpl();
		return binaryModelRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpointReference createModelEndpointReference() {
		ModelEndpointReferenceImpl modelEndpointReference = new ModelEndpointReferenceImpl();
		return modelEndpointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference createModelElementReference() {
		ModelElementReferenceImpl modelElementReference = new ModelElementReferenceImpl();
		return modelElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLink createBinaryLink() {
		BinaryLinkImpl binaryLink = new BinaryLinkImpl();
		return binaryLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpoint createModelElementEndpoint() {
		ModelElementEndpointImpl modelElementEndpoint = new ModelElementEndpointImpl();
		return modelElementEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkReference createLinkReference() {
		LinkReferenceImpl linkReference = new LinkReferenceImpl();
		return linkReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLinkReference createBinaryLinkReference() {
		BinaryLinkReferenceImpl binaryLinkReference = new BinaryLinkReferenceImpl();
		return binaryLinkReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpointReference createModelElementEndpointReference() {
		ModelElementEndpointReferenceImpl modelElementEndpointReference = new ModelElementEndpointReferenceImpl();
		return modelElementEndpointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipPackage getRelationshipPackage() {
		return (RelationshipPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RelationshipPackage getPackage() {
		return RelationshipPackage.eINSTANCE;
	}

} //RelationshipFactoryImpl
