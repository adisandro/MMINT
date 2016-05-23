/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.MIDTypeFactory;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Endpoint</b></em>'.
 * <!-- end-user-doc -->
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
	public MID getMIDContainer() {
		return (MID) this.eContainer().eContainer().eContainer();
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
		if (baseClass == ExtendibleElement.class) {
			switch (baseOperationID) {
				case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE;
				case MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_MID_CONTAINER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE:
				return getMetatype();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE:
				return getSupertype();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_MID_CONTAINER:
				return getMIDContainer();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_TARGET:
				return getTarget();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_TYPE_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE_BOOLEAN_BOOLEAN_MAPPINGREFERENCE:
				try {
					return createTypeReference((ModelElementEndpointReference)arguments.get(0), (ModelElementReference)arguments.get(1), (Boolean)arguments.get(2), (Boolean)arguments.get(3), (MappingReference)arguments.get(4));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODELELEMENTREFERENCE_BOOLEAN_MAPPINGREFERENCE:
				try {
					return createSubtypeAndReference((String)arguments.get(0), (ModelElementReference)arguments.get(1), (Boolean)arguments.get(2), (MappingReference)arguments.get(3));
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE:
				try {
					return createInstanceReference((ModelElementReference)arguments.get(0), (MappingReference)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE:
				try {
					return createInstanceAndReference((ModelElementReference)arguments.get(0), (MappingReference)arguments.get(1));
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
	public ModelElementEndpointReference createTypeReference(ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference targetModelElemTypeRef, boolean isModifiable, boolean isBinarySrc, MappingReference containerMappingTypeRef) throws MMINTException {

		MMINTException.mustBeType(this);

		ModelElementEndpointReference newModelElemTypeEndpointRef = super.createThisReferenceEClass();
		super.addTypeReference(newModelElemTypeEndpointRef, modelElemTypeEndpointRef, isModifiable, false);
		newModelElemTypeEndpointRef.setModelElemRef(targetModelElemTypeRef);
		containerMappingTypeRef.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
		if (containerMappingTypeRef instanceof BinaryMappingReference) {
			((BinaryMappingReference) containerMappingTypeRef).addModelElementTypeReference(targetModelElemTypeRef, isBinarySrc);
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createSubtypeAndReference(String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc, MappingReference containerMappingTypeRef) throws MMINTException {

		MMINTException.mustBeType(this);
		if (containerMappingTypeRef instanceof BinaryMappingReference) {
			if (containerMappingTypeRef.getModelElemEndpointRefs().size() == 2) {
				throw new MMINTException("Can't add more than 2 model element type endpoints to a binary mapping type");
			}
			if (MIDTypeHierarchy.getOverriddenModelElementTypeEndpoint(containerMappingTypeRef, targetModelElemTypeRef) != this) {
				throw new MMINTException("Invalid overriding of this model element type endpoint");
			}
		}

		ModelElementEndpointReference modelElemTypeEndpointRef = MIDTypeHierarchy.getReference(getUri(), containerMappingTypeRef.getModelElemEndpointRefs());
		Mapping mappingType = containerMappingTypeRef.getObject();
		ModelElement targetModelElemType = targetModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) containerMappingTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) targetModelElemTypeRef.eContainer();
		MID typeMID = modelRelType.getMIDContainer();
		// create the "thing" and the corresponding reference
		ModelElementEndpoint newModelElemTypeEndpoint = super.createThisEClass();
		super.addSubtype(newModelElemTypeEndpoint, mappingType, mappingType.getName() + MMINT.ENDPOINT_SEPARATOR + targetModelElemTypeRef.getObject().getName(), newModelElemTypeEndpointName);
		MIDTypeFactory.addModelElementTypeEndpoint(newModelElemTypeEndpoint, targetModelElemType, mappingType);
		ModelElementEndpointReference newModelElemTypeEndpointRef = newModelElemTypeEndpoint.createTypeReference(modelElemTypeEndpointRef, targetModelElemTypeRef, true, isBinarySrc, containerMappingTypeRef);
		MIDTypeFactory.addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, mappingType);
		// create references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
			MappingReference containerMappingSubtypeRef = MIDTypeHierarchy.getReference(containerMappingTypeRef, modelRelSubtype.getMappingRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				MappingReference mappingTypeRefSuper = (MappingReference) modelElemTypeEndpointRef.eContainer();
				MappingReference mappingSubtypeRefSuper = MIDTypeHierarchy.getReference(mappingTypeRefSuper, modelRelSubtype.getMappingRefs());
				modelElemSubtypeEndpointRef = MIDTypeHierarchy.getReference(modelElemTypeEndpointRef, mappingSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MIDTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference targetModelElemSubtypeRef = MIDTypeHierarchy.getReference(targetModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			newModelElemTypeEndpoint.createTypeReference(modelElemSubtypeEndpointRef, targetModelElemSubtypeRef, false, isBinarySrc, containerMappingSubtypeRef);
		}
		// create references of the "thing" in subtypes of the container
		for (Mapping mappingSubtype : MIDTypeHierarchy.getSubtypes(mappingType, typeMID)) {
			MIDTypeFactory.addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, mappingSubtype);
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public void replaceSubtypeAndReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef) throws MMINTException {

		MMINTException.mustBeType(this);
		MappingReference containerMappingTypeRef = (MappingReference) oldModelElemTypeEndpointRef.eContainer();
		if (containerMappingTypeRef instanceof BinaryMappingReference) {
			if (MIDTypeHierarchy.getOverriddenModelElementTypeEndpoint(containerMappingTypeRef, targetModelElemTypeRef) != this) {
				throw new MMINTException("Invalid overriding of this model element type endpoint");
			}
		}

		ModelElementEndpointReference modelElemTypeEndpointRef = MIDTypeHierarchy.getReference(getUri(), containerMappingTypeRef.getModelElemEndpointRefs());
		oldModelElemTypeEndpointRef.deleteTypeAndReference(false);
		ModelElementEndpoint oldModelElemTypeEndpoint = oldModelElemTypeEndpointRef.getObject();
		Mapping mappingType = containerMappingTypeRef.getObject();
		ModelElement newModelElemType = targetModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) containerMappingTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) targetModelElemTypeRef.eContainer();
		MID typeMID = containerMappingTypeRef.getMIDContainer();
		// modify the "thing" and the corresponding reference
		super.addSubtype(oldModelElemTypeEndpoint, mappingType, mappingType.getName() + MMINT.ENDPOINT_SEPARATOR + newModelElemType.getName(), newModelElemTypeEndpointName);
		if (containerMappingTypeRef instanceof BinaryMappingReference) {
			boolean isBinarySrc = ((BinaryMappingReference) containerMappingTypeRef).getSourceModelElemRef() == oldModelElemTypeEndpointRef.getModelElemRef();
			((BinaryMappingReference) containerMappingTypeRef).addModelElementTypeReference(targetModelElemTypeRef, isBinarySrc);
		}
		oldModelElemTypeEndpoint.setTarget(newModelElemType);
		oldModelElemTypeEndpointRef.setModelElemRef(targetModelElemTypeRef);
		if (modelElemTypeEndpointRef != null) {
			oldModelElemTypeEndpointRef.setSupertypeRef(modelElemTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
			MappingReference mappingSubtypeRef = MIDTypeHierarchy.getReference(containerMappingTypeRef, modelRelSubtype.getMappingRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				MappingReference mappingTypeRefSuper = (MappingReference) modelElemTypeEndpointRef.eContainer();
				MappingReference mappingSubtypeRefSuper = MIDTypeHierarchy.getReference(mappingTypeRefSuper, modelRelSubtype.getMappingRefs());
				modelElemSubtypeEndpointRef = MIDTypeHierarchy.getReference(modelElemTypeEndpointRef, mappingSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MIDTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference newModelElemSubtypeRef = MIDTypeHierarchy.getReference(targetModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			ModelElementEndpointReference oldModelElemSubtypeEndpointRef = MIDTypeHierarchy.getReference(oldModelElemTypeEndpointRef, mappingSubtypeRef.getModelElemEndpointRefs());
			oldModelElemTypeEndpointRef.setModelElemRef(newModelElemSubtypeRef);
			oldModelElemSubtypeEndpointRef.setSupertypeRef(modelElemSubtypeEndpointRef);
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteType(boolean isFullDelete) throws MMINTException {

		MMINTException.mustBeType(this);

		super.delete();
		if (isFullDelete) {
			((Mapping) this.eContainer()).getModelElemEndpoints().remove(this);
		}
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createInstanceReference(ModelElementReference targetModelElemRef, MappingReference containerMappingRef) throws MMINTException {

		MMINTException.mustBeInstance(this);

		ModelElementEndpointReference newModelElemEndpointRef = super.createThisReferenceEClass();
		boolean isContainer = containerMappingRef.eContainer().eContainer() == null;
		super.addInstanceReference(newModelElemEndpointRef, isContainer);
		newModelElemEndpointRef.setModelElemRef(targetModelElemRef);
		containerMappingRef.getModelElemEndpointRefs().add(newModelElemEndpointRef);
		if (containerMappingRef instanceof BinaryMappingReference) {
			boolean isBinarySrc = containerMappingRef.getModelElemEndpointRefs().size() == 1;
			if (isBinarySrc) {
				((BinaryMappingReference) containerMappingRef).setSourceModelElemRef(targetModelElemRef);
			}
			else {
				((BinaryMappingReference) containerMappingRef).setTargetModelElemRef(targetModelElemRef);
			}
		}

		return newModelElemEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementEndpointReference createInstanceAndReference(ModelElementReference targetModelElemRef, MappingReference containerMappingRef) throws MMINTException {

		MMINTException.mustBeType(this);
		if ((containerMappingRef instanceof BinaryMappingReference) && (containerMappingRef.getModelElemEndpointRefs().size() == 2)) {
			throw new MMINTException("Can't add more than 2 model element endpoints to a binary mapping");
		}

		ModelElementEndpoint newModelElemEndpoint = super.createThisEClass();
		super.addBasicInstance(newModelElemEndpoint, null, targetModelElemRef.getObject().getName(), MIDLevel.INSTANCES);
		super.addInstanceEndpoint(newModelElemEndpoint, targetModelElemRef.getObject());
		containerMappingRef.getObject().getModelElemEndpoints().add(newModelElemEndpoint);
		ModelElementEndpointReference modelElemEndpointRef = newModelElemEndpoint.createInstanceReference(targetModelElemRef, containerMappingRef);
		containerMappingRef.getObject().getModelElemEndpointRefs().add(modelElemEndpointRef);

		return modelElemEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public void replaceInstanceAndReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementReference targetModelElemRef) throws MMINTException {

		MMINTException.mustBeType(this);

		MappingReference containerMappingRef = (MappingReference) oldModelElemEndpointRef.eContainer();
		oldModelElemEndpointRef.deleteInstanceAndReference(false);
		ModelElementEndpoint oldModelElemEndpoint = oldModelElemEndpointRef.getObject();
		super.addBasicInstance(oldModelElemEndpoint, null, null, MIDLevel.INSTANCES);
		if (containerMappingRef instanceof BinaryMappingReference) {
			boolean isBinarySrc = ((BinaryMappingReference) containerMappingRef).getSourceModelElemRef() == oldModelElemEndpointRef.getModelElemRef();
			if (isBinarySrc) {
				((BinaryMappingReference) containerMappingRef).setSourceModelElemRef(targetModelElemRef);
			}
			else {
				((BinaryMappingReference) containerMappingRef).setTargetModelElemRef(targetModelElemRef);
			}
		}
		oldModelElemEndpoint.setTarget(targetModelElemRef.getObject());
		oldModelElemEndpointRef.setModelElemRef(targetModelElemRef);
	}

} //ModelElementEndpointImpl
