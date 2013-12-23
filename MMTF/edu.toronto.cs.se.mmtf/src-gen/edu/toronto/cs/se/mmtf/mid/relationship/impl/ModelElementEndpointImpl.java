/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.impl;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ModelElementEndpointImpl extends ExtendibleElementEndpointImpl implements ModelElementEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.MODEL_ELEMENT_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpoint getSupertype() {
		ExtendibleElementEndpoint supertype = super.getSupertype();
		return (supertype == null) ? null : (ModelElementEndpoint) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getTarget() {
		ExtendibleElement target = super.getTarget();
		return (target == null) ? null : (ModelElement) target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpoint getMetatype() {
		ExtendibleElementEndpoint metatype = super.getMetatype();
		return (metatype == null) ? null : (ModelElementEndpoint) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ExtendibleElementEndpoint.class) {
			switch (baseOperationID) {
				case MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE;
				case MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE:
				return getSupertype();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_TARGET:
				return getTarget();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE:
				return getMetatype();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_TYPE_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE_BOOLEAN_BOOLEAN_LINKREFERENCE:
				try {
					return createTypeReference((ModelElementEndpointReference)arguments.get(0), (ModelElementReference)arguments.get(1), (Boolean)arguments.get(2), (Boolean)arguments.get(3), (LinkReference)arguments.get(4));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE_BOOLEAN_LINKREFERENCE:
				try {
					return createSubtypeAndReference((ModelElementEndpointReference)arguments.get(0), (String)arguments.get(1), (ModelElementReference)arguments.get(2), (Boolean)arguments.get(3), (LinkReference)arguments.get(4));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE_LINKREFERENCE:
				try {
					replaceSubtypeAndReference((ModelElementEndpointReference)arguments.get(0), (ModelElementEndpointReference)arguments.get(1), (String)arguments.get(2), (ModelElementReference)arguments.get(3), (LinkReference)arguments.get(4));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__BOOLEAN_LINKREFERENCE:
				try {
					return createInstanceReference((Boolean)arguments.get(0), (LinkReference)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_LINKREFERENCE:
				try {
					return createInstanceAndReference((ModelElementReference)arguments.get(0), (Boolean)arguments.get(1), (LinkReference)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE:
				try {
					replaceInstanceAndReference((ModelElementEndpointReference)arguments.get(0), (ModelElementReference)arguments.get(1));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createTypeReference(ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference targetModelElemTypeRef, boolean isModifiable, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelElementEndpointReference newModelElemTypeEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		super.addTypeReference(newModelElemTypeEndpointRef, modelElemTypeEndpointRef, isModifiable, false);
		newModelElemTypeEndpointRef.setModelElemRef(targetModelElemTypeRef);
		if (isBinarySrc) {
			containerLinkTypeRef.getModelElemEndpointRefs().add(0, newModelElemTypeEndpointRef);
		}
		else {
			containerLinkTypeRef.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createSubtypeAndReference(ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Link linkType = containerLinkTypeRef.getObject();
		ModelElement targetModelElemType = targetModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) containerLinkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) targetModelElemTypeRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		// create the "thing" and the corresponding reference
		ModelElementEndpoint newModelElemTypeEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		super.addSubtype(newModelElemTypeEndpoint, linkType, linkType.getName() + MMTF.ENDPOINT_SEPARATOR + targetModelElemTypeRef.getObject().getName(), newModelElemTypeEndpointName);
		MultiModelTypeFactory.addModelElementTypeEndpoint(newModelElemTypeEndpoint, targetModelElemType, isBinarySrc, linkType);
		ModelElementEndpointReference newModelElemTypeEndpointRef = newModelElemTypeEndpoint.createTypeReference(modelElemTypeEndpointRef, targetModelElemTypeRef, true, isBinarySrc, containerLinkTypeRef);
		MultiModelTypeFactory.addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, linkType);
		// create references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference containerLinkSubtypeRef = MultiModelTypeHierarchy.getReference(containerLinkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				LinkReference linkTypeRefSuper = (LinkReference) modelElemTypeEndpointRef.eContainer();
				LinkReference linkSubtypeRefSuper = MultiModelTypeHierarchy.getReference(linkTypeRefSuper, modelRelSubtype.getLinkRefs());
				modelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpointRef, linkSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference targetModelElemSubtypeRef = MultiModelTypeHierarchy.getReference(targetModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			newModelElemTypeEndpoint.createTypeReference(modelElemSubtypeEndpointRef, targetModelElemSubtypeRef, false, isBinarySrc, containerLinkSubtypeRef);
		}
		// create references of the "thing" in subtypes of the container
		for (Link linkSubtype : MultiModelTypeHierarchy.getSubtypes(linkType, multiModel)) {
			MultiModelTypeFactory.addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, linkSubtype);
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public void replaceSubtypeAndReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, LinkReference containerLinkTypeRef) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		oldModelElemTypeEndpointRef.deleteTypeAndReference(false);
		ModelElementEndpoint oldModelElemTypeEndpoint = oldModelElemTypeEndpointRef.getObject();
		Link linkType = containerLinkTypeRef.getObject();
		ModelElement newModelElemType = targetModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) containerLinkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) targetModelElemTypeRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerLinkTypeRef);
		// modify the "thing" and the corresponding reference
		super.addSubtype(oldModelElemTypeEndpoint, linkType, linkType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelElemType.getName(), newModelElemTypeEndpointName);
		oldModelElemTypeEndpoint.setTarget(newModelElemType);
		oldModelElemTypeEndpointRef.setModelElemRef(targetModelElemTypeRef);
		if (modelElemTypeEndpointRef != null) {
			oldModelElemTypeEndpointRef.setSupertypeRef(modelElemTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(containerLinkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				LinkReference linkTypeRefSuper = (LinkReference) modelElemTypeEndpointRef.eContainer();
				LinkReference linkSubtypeRefSuper = MultiModelTypeHierarchy.getReference(linkTypeRefSuper, modelRelSubtype.getLinkRefs());
				modelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpointRef, linkSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference newModelElemSubtypeRef = MultiModelTypeHierarchy.getReference(targetModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			ModelElementEndpointReference oldModelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelElemTypeEndpointRef, linkSubtypeRef.getModelElemEndpointRefs());
			oldModelElemTypeEndpointRef.setModelElemRef(newModelElemSubtypeRef);
			oldModelElemSubtypeEndpointRef.setSupertypeRef(modelElemSubtypeEndpointRef);
		}
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createInstanceReference(boolean isBinarySrc, LinkReference containerLinkRef) throws MMTFException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createInstanceAndReference(ModelElementReference targetModelElemRef, boolean isBinarySrc, LinkReference containerLinkRef) throws MMTFException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated NOT
	 */
	public void replaceInstanceAndReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementReference targetModelElemRef) throws MMTFException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //ModelElementEndpointImpl
