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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

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
				case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE;
				case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE;
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODELELEMENTREFERENCE_BOOLEAN_LINKREFERENCE:
				try {
					return createSubtypeAndReference((String)arguments.get(0), (ModelElementReference)arguments.get(1), (Boolean)arguments.get(2), (LinkReference)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE:
				try {
					replaceSubtypeAndReference((ModelElementEndpointReference)arguments.get(0), (String)arguments.get(1), (ModelElementReference)arguments.get(2));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___DELETE_TYPE__BOOLEAN:
				try {
					deleteType((Boolean)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELELEMENTREFERENCE_LINKREFERENCE:
				try {
					return createInstanceReference((ModelElementReference)arguments.get(0), (LinkReference)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_LINKREFERENCE:
				try {
					return createInstanceAndReference((ModelElementReference)arguments.get(0), (LinkReference)arguments.get(1));
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
	public ModelElementEndpointReference createTypeReference(ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference targetModelElemTypeRef, boolean isModifiable, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelElementEndpointReference newModelElemTypeEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		super.addTypeReference(newModelElemTypeEndpointRef, modelElemTypeEndpointRef, isModifiable, false);
		newModelElemTypeEndpointRef.setModelElemRef(targetModelElemTypeRef);
		containerLinkTypeRef.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
		if (containerLinkTypeRef instanceof BinaryLinkReference) {
			((BinaryLinkReference) containerLinkTypeRef).addModelElementTypeReference(targetModelElemTypeRef, isBinarySrc);
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createSubtypeAndReference(String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		if (containerLinkTypeRef instanceof BinaryLinkReference) {
			if (containerLinkTypeRef.getModelElemEndpointRefs().size() == 2) {
				throw new MMINTException("Can't add more than 2 model element type endpoints to a binary link type");
			}
			if (MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(containerLinkTypeRef, targetModelElemTypeRef) != this) {
				throw new MMINTException("Invalid overriding of this model element type endpoint");
			}
		}

		ModelElementEndpointReference modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(getUri(), containerLinkTypeRef.getModelElemEndpointRefs());
		Link linkType = containerLinkTypeRef.getObject();
		ModelElement targetModelElemType = targetModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) containerLinkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) targetModelElemTypeRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		// create the "thing" and the corresponding reference
		ModelElementEndpoint newModelElemTypeEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		super.addSubtype(newModelElemTypeEndpoint, linkType, linkType.getName() + MMINT.ENDPOINT_SEPARATOR + targetModelElemTypeRef.getObject().getName(), newModelElemTypeEndpointName);
		MultiModelTypeFactory.addModelElementTypeEndpoint(newModelElemTypeEndpoint, targetModelElemType, linkType);
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
	public void replaceSubtypeAndReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		LinkReference containerLinkTypeRef = (LinkReference) oldModelElemTypeEndpointRef.eContainer();
		if (containerLinkTypeRef instanceof BinaryLinkReference) {
			if (MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(containerLinkTypeRef, targetModelElemTypeRef) != this) {
				throw new MMINTException("Invalid overriding of this model element type endpoint");
			}
		}

		ModelElementEndpointReference modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(getUri(), containerLinkTypeRef.getModelElemEndpointRefs());
		oldModelElemTypeEndpointRef.deleteTypeAndReference(false);
		ModelElementEndpoint oldModelElemTypeEndpoint = oldModelElemTypeEndpointRef.getObject();
		Link linkType = containerLinkTypeRef.getObject();
		ModelElement newModelElemType = targetModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) containerLinkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) targetModelElemTypeRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerLinkTypeRef);
		// modify the "thing" and the corresponding reference
		super.addSubtype(oldModelElemTypeEndpoint, linkType, linkType.getName() + MMINT.ENDPOINT_SEPARATOR + newModelElemType.getName(), newModelElemTypeEndpointName);
		if (containerLinkTypeRef instanceof BinaryLinkReference) {
			boolean isBinarySrc = ((BinaryLinkReference) containerLinkTypeRef).getSourceModelElemRef() == oldModelElemTypeEndpointRef.getModelElemRef();
			((BinaryLinkReference) containerLinkTypeRef).addModelElementTypeReference(targetModelElemTypeRef, isBinarySrc);
		}
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
	public void deleteType(boolean isFullDelete) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		super.deleteType();
		if (isFullDelete) {
			((Link) eContainer()).getModelElemEndpoints().remove(this);
		}
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createInstanceReference(ModelElementReference targetModelElemRef, LinkReference containerLinkRef) throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ModelElementEndpointReference newModelElemEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		boolean isContainer = containerLinkRef.eContainer().eContainer() == null;
		super.addInstanceReference(newModelElemEndpointRef, isContainer);
		newModelElemEndpointRef.setModelElemRef(targetModelElemRef);
		containerLinkRef.getModelElemEndpointRefs().add(newModelElemEndpointRef);
		if (containerLinkRef instanceof BinaryLinkReference) {
			boolean isBinarySrc = containerLinkRef.getModelElemEndpointRefs().size() == 1;
			if (isBinarySrc) {
				((BinaryLinkReference) containerLinkRef).setSourceModelElemRef(targetModelElemRef);
			}
			else {
				((BinaryLinkReference) containerLinkRef).setTargetModelElemRef(targetModelElemRef);
			}
		}

		return newModelElemEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createInstanceAndReference(ModelElementReference targetModelElemRef, LinkReference containerLinkRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		if ((containerLinkRef instanceof BinaryLinkReference) && (containerLinkRef.getModelElemEndpointRefs().size() == 2)) {
			throw new MMINTException("Can't add more than 2 model element endpoints to a binary link");
		}

		ModelElementEndpoint newModelElemEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		super.addBasicInstance(newModelElemEndpoint, null, targetModelElemRef.getObject().getName());
		super.addInstanceEndpoint(newModelElemEndpoint, targetModelElemRef.getObject());
		containerLinkRef.getObject().getModelElemEndpoints().add(newModelElemEndpoint);
		ModelElementEndpointReference modelElemEndpointRef = newModelElemEndpoint.createInstanceReference(targetModelElemRef, containerLinkRef);
		containerLinkRef.getObject().getModelElemEndpointRefs().add(modelElemEndpointRef);

		return modelElemEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public void replaceInstanceAndReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementReference targetModelElemRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		LinkReference containerLinkRef = (LinkReference) oldModelElemEndpointRef.eContainer();
		oldModelElemEndpointRef.deleteInstanceAndReference(false);
		ModelElementEndpoint oldModelElemEndpoint = oldModelElemEndpointRef.getObject();
		super.addBasicInstance(oldModelElemEndpoint, null, null);
		if (containerLinkRef instanceof BinaryLinkReference) {
			boolean isBinarySrc = ((BinaryLinkReference) containerLinkRef).getSourceModelElemRef() == oldModelElemEndpointRef.getModelElemRef();
			if (isBinarySrc) {
				((BinaryLinkReference) containerLinkRef).setSourceModelElemRef(targetModelElemRef);
			}
			else {
				((BinaryLinkReference) containerLinkRef).setTargetModelElemRef(targetModelElemRef);
			}
		}
		oldModelElemEndpoint.setTarget(targetModelElemRef.getObject());
		oldModelElemEndpointRef.setModelElemRef(targetModelElemRef);
	}

} //ModelElementEndpointImpl
