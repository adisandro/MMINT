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
package edu.toronto.cs.se.mmint.mid.impl;

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
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelEndpointImpl extends ExtendibleElementEndpointImpl implements ModelEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MIDPackage.Literals.MODEL_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpoint getSupertype() {
		ExtendibleElementEndpoint supertype = super.getSupertype();
		return (supertype == null) ? null : (ModelEndpoint) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MID getMIDContainer() {
		return (MID) this.eContainer().eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getTarget() {
		ExtendibleElement target = super.getTarget();
		return (target == null) ? null : (Model) target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpoint getMetatype() {
		ExtendibleElementEndpoint metatype = super.getMetatype();
		return (metatype == null) ? null : (ModelEndpoint) metatype;
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
				case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return MIDPackage.MODEL_ENDPOINT___GET_METATYPE;
				case MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER: return MIDPackage.MODEL_ENDPOINT___GET_MID_CONTAINER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ExtendibleElementEndpoint.class) {
			switch (baseOperationID) {
				case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE: return MIDPackage.MODEL_ENDPOINT___GET_METATYPE;
				case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE: return MIDPackage.MODEL_ENDPOINT___GET_SUPERTYPE;
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
			case MIDPackage.MODEL_ENDPOINT___GET_METATYPE:
				return getMetatype();
			case MIDPackage.MODEL_ENDPOINT___GET_SUPERTYPE:
				return getSupertype();
			case MIDPackage.MODEL_ENDPOINT___GET_MID_CONTAINER:
				return getMIDContainer();
			case MIDPackage.MODEL_ENDPOINT___GET_TARGET:
				return getTarget();
			case MIDPackage.MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL:
				try {
					return createTypeReference((Boolean)arguments.get(0), (ModelRel)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODEL_BOOLEAN_MODELREL:
				try {
					return createSubtypeAndReference((String)arguments.get(0), (Model)arguments.get(1), (Boolean)arguments.get(2), (ModelRel)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_STRING_MODEL:
				try {
					replaceSubtypeAndReference((ModelEndpoint)arguments.get(0), (String)arguments.get(1), (Model)arguments.get(2));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN:
				try {
					deleteTypeAndReference((Boolean)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL:
				try {
					return createInstanceReference((ModelRel)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_MODELREL:
				try {
					return createInstanceAndReference((Model)arguments.get(0), (ModelRel)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING:
				try {
					return createInstance((Model)arguments.get(0), (Operator)arguments.get(1), (String)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL:
				try {
					replaceInstanceAndReference((ModelEndpoint)arguments.get(0), (Model)arguments.get(1));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN:
				try {
					deleteInstanceAndReference((Boolean)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Deletes this model type endpoint from the Type MID.
	 * 
	 * @param isFullDelete
	 *            True if this model type endpoint is going to be fully deleted,
	 *            false if it is going to be replaced later.
	 * @throws MMINTException Never thrown.
	 * @generated NOT
	 */
	protected void deleteType(boolean isFullDelete) throws MMINTException {

		super.delete();
		if (isFullDelete) {
			ModelRel modelRelType = (ModelRel) eContainer();
			modelRelType.getModelEndpoints().remove(this);
		}
	}

	/**
	 * Adds a reference to this model type endpoint to the Type MID.
	 * 
	 * @param newModelTypeEndpointRef
	 *            The new reference to this model type endpoint to be added.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced model type endpoint, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the model type endpoint.
	 * @generated NOT
	 */
	protected void addTypeReference(ModelEndpointReference newModelTypeEndpointRef, boolean isModifiable, ModelRel containerModelRelType) {

		ModelEndpointReference modelTypeEndpointRef = (getSupertype() != null) ? // may be root
			MIDTypeHierarchy.getReference(getSupertype().getUri(), containerModelRelType.getModelEndpointRefs()) :
			null;
		MIDTypeFactory.addTypeReference(newModelTypeEndpointRef, this, modelTypeEndpointRef, isModifiable, false);
		containerModelRelType.getModelEndpointRefs().add(newModelTypeEndpointRef);
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createTypeReference(boolean isModifiable, ModelRel containerModelRelType) throws MMINTException {

		MMINTException.mustBeType(this);

		ModelEndpointReference newModelTypeEndpointRef = super.createThisReferenceEClass();
		addTypeReference(newModelTypeEndpointRef, isModifiable, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * Adds a subtype of this model type endpoint and a reference to it to the
	 * Type MID.
	 * 
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint to be added.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param targetModelType
	 *            The model type that is the target of the new model type
	 *            endpoint.
	 * @param isBinarySrc
	 *            (Only for a binary model relationship type container) True if
	 *            the target model type is the source in the binary model
	 *            relationship type container, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMINTException
	 *             If the new model endpoint to be added is a model instance
	 *             endpoint, or if the uri of the new model type endpoint is
	 *             already registered in the Type MID.
	 * @generated NOT
	 */
	protected ModelEndpointReference addSubtypeAndReference(ModelEndpoint newModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMINTException {

		MID typeMID = containerModelRelType.getMIDContainer();
		// create the "thing" and the corresponding reference
		super.addSubtype(newModelTypeEndpoint, containerModelRelType, containerModelRelType.getName() + MMINT.ENDPOINT_SEPARATOR + targetModelType.getName(), newModelTypeEndpointName);
		MIDTypeFactory.addModelTypeEndpoint(newModelTypeEndpoint, targetModelType, isBinarySrc, containerModelRelType);
		ModelEndpointReference newModelTypeEndpointRef = newModelTypeEndpoint.createTypeReference(true, containerModelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(containerModelRelType, typeMID)) {
			newModelTypeEndpoint.createTypeReference(false, modelRelSubtype);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createSubtypeAndReference(String newModelTypeEndpointName, Model targetModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMINTException {

		MMINTException.mustBeType(this);

		if (containerModelRelType instanceof BinaryModelRel) {
			if (containerModelRelType.getModelEndpoints().size() == 2) {
				throw new MMINTException("Can't add more than 2 model type endpoints to a binary model relationship type");
			}
			if (MIDTypeHierarchy.getOverriddenModelTypeEndpoint(containerModelRelType, targetModelType) != this) {
				throw new MMINTException("Invalid overriding of this model type endpoint");
			}
		}

		ModelEndpoint newModelTypeEndpoint = super.createThisEClass();
		ModelEndpointReference newModelTypeEndpointRef = addSubtypeAndReference(newModelTypeEndpoint, newModelTypeEndpointName, targetModelType, isBinarySrc, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType) throws MMINTException {

		MMINTException.mustBeType(this);
		ModelRel containerModelRelType = (ModelRel) oldModelTypeEndpoint.eContainer();
		if (containerModelRelType instanceof BinaryModelRel) {
			if (MIDTypeHierarchy.getOverriddenModelTypeEndpoint(containerModelRelType, targetModelType) != this) {
				throw new MMINTException("Invalid overriding of this model type endpoint");
			}
		}

		MID instanceMID = containerModelRelType.getMIDContainer();
		ModelEndpointReference modelTypeEndpointRef = MIDTypeHierarchy.getReference(getUri(), containerModelRelType.getModelEndpointRefs());
		oldModelTypeEndpoint.deleteTypeAndReference(false);
		// modify the "thing" and the corresponding reference
		super.addSubtype(oldModelTypeEndpoint, containerModelRelType, containerModelRelType.getName() + MMINT.ENDPOINT_SEPARATOR + targetModelType.getName(), newModelTypeEndpointName);
		if (containerModelRelType instanceof BinaryModelRel) {
			boolean isBinarySrc = ((BinaryModelRel) containerModelRelType).getSourceModel() == oldModelTypeEndpoint.getTarget();
			((BinaryModelRel) containerModelRelType).addModelType(targetModelType, isBinarySrc);
		}
		oldModelTypeEndpoint.setTarget(targetModelType);
		if (modelTypeEndpointRef != null) {
			ModelEndpointReference oldModelTypeEndpointRef = MIDTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), containerModelRelType.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(containerModelRelType, instanceMID)) {
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MIDTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelEndpointReference oldModelTypeEndpointRef = MIDTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelSubtypeEndpointRef);
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteTypeAndReference(boolean isFullDelete) throws MMINTException {

		MMINTException.mustBeType(this);

		MID typeMID = this.getMIDContainer();
		// delete the "thing" and the corresponding reference
		ModelRel modelRelType = (ModelRel) eContainer();
		deleteType(isFullDelete);
		ModelEndpointReference modelTypeEndpointRef = MIDTypeHierarchy.getReference(getUri(), modelRelType.getModelEndpointRefs());
		modelTypeEndpointRef.deleteTypeReference(isFullDelete);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
			ModelEndpointReference modelSubtypeEndpointRef = MIDTypeHierarchy.getReference(getUri(), modelRelSubtype.getModelEndpointRefs());
			modelSubtypeEndpointRef.deleteTypeReference(isFullDelete);
		}
	}

	/**
	 * Adds a reference to this model instance endpoint to an Instance MID.
	 * 
	 * @param newModelEndpointRef
	 *            The new reference to this model endpoint to be added.
	 * @param containerModelRel
	 *            The model relationship that will contain the new reference to
	 *            the model endpoint.
	 * @generated NOT
	 */
	protected void addInstanceReference(ModelEndpointReference newModelEndpointRef, ModelRel containerModelRel) {

		super.addInstanceReference(newModelEndpointRef, false);
		containerModelRel.getModelEndpointRefs().add(newModelEndpointRef);
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

		MMINTException.mustBeInstance(this);

		ModelEndpointReference newModelEndpointRef = super.createThisReferenceEClass();
		addInstanceReference(newModelEndpointRef, containerModelRel);

		return newModelEndpointRef;
	}

	/**
	 * Adds a model instance endpoint and a reference to it to an Instance MID (variant for model relationships).
	 * 
	 * @param newModelEndpoint
	 *            The new model endpoint to be added.
	 * @param targetModel
	 *            The model that is the target of the new model endpoint.
	 * @param modelRel
	 *            The model relationship that will contain the new model endpoint.
	 * @return The created reference to the new model endpoint.
	 * @throws MMINTException
	 *             If the new model endpoint is a model type endpoint.
	 * @generated NOT
	 */
	protected ModelEndpointReference addInstanceAndReference(ModelEndpoint newModelEndpoint, Model targetModel, ModelRel containerModelRel) throws MMINTException {

		super.addBasicInstance(newModelEndpoint, null, targetModel.getName());
		super.addInstanceEndpoint(newModelEndpoint, targetModel);
		containerModelRel.getModelEndpoints().add(newModelEndpoint);
		if (containerModelRel instanceof BinaryModelRel) {
			boolean isBinarySrc = containerModelRel.getModelEndpoints().size() == 1;
			if (isBinarySrc) {
				((BinaryModelRel) containerModelRel).setSourceModel(targetModel);
			}
			else {
				((BinaryModelRel) containerModelRel).setTargetModel(targetModel);
			}
		}
		ModelEndpointReference modelEndpointRef = newModelEndpoint.createInstanceReference(containerModelRel);

		return modelEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createInstanceAndReference(Model targetModel, ModelRel containerModelRel) throws MMINTException {

		MMINTException.mustBeType(this);
		if ((containerModelRel instanceof BinaryModelRel) && (containerModelRel.getModelEndpoints().size() == 2)) {
			throw new MMINTException("Can't add more than 2 model endpoints to a binary model relationship");
		}

		ModelEndpoint newModelEndpoint = super.createThisEClass();
		ModelEndpointReference newModelEndpointRef = addInstanceAndReference(newModelEndpoint, targetModel, containerModelRel);

		return newModelEndpointRef;
	}

	/**
	 * Adds a model instance endpoint to an Instance MID (variant for operators).
	 * 
	 * @param newModelEndpoint
	 *            The new model endpoint to be added.
	 * @param targetModel
	 *            The model that is the target of the new model endpoint.
	 * @param containerOperator
	 *            The operator that will contain the new model endpoint.
	 * @param containerFeatureName
	 *            The name of the feature in the operator that will contain the new model endpoint.
	 * @throws MMINTException
	 *             If the feature name is not found in the container operator.
	 * @generated NOT
	 */
	protected void addInstance(ModelEndpoint newModelEndpoint, Model targetModel, Operator containerOperator, String containerFeatureName) throws MMINTException {

		super.addBasicInstance(newModelEndpoint, null, this.getName());
		super.addInstanceEndpoint(newModelEndpoint, targetModel);
		MIDUtils.setModelObjFeature(containerOperator, containerFeatureName, newModelEndpoint);
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpoint createInstance(Model targetModel, Operator containerOperator, String containerFeatureName) throws MMINTException {

		MMINTException.mustBeType(this);

		ModelEndpoint newModelEndpoint = super.createThisEClass();
		addInstance(newModelEndpoint, targetModel, containerOperator, containerFeatureName);

		return newModelEndpoint;
	}

	/**
	 * @generated NOT
	 */
	public void replaceInstanceAndReference(ModelEndpoint oldModelEndpoint, Model targetModel) throws MMINTException {

		MMINTException.mustBeType(this);
		if (this.eClass() != oldModelEndpoint.eClass() && this.eClass().isSuperTypeOf(oldModelEndpoint.eClass())) {
			throw new MMINTException("Can't replace a user-defined model endpoint with a native one");
		}

		ModelRel containerModelRel = (ModelRel) oldModelEndpoint.eContainer();
		oldModelEndpoint.deleteInstanceAndReference(false);
		super.addBasicInstance(oldModelEndpoint, null, targetModel.getName());
		if (containerModelRel instanceof BinaryModelRel) {
			boolean isBinarySrc = ((BinaryModelRel) containerModelRel).getSourceModel() == oldModelEndpoint.getTarget();
			if (isBinarySrc) {
				((BinaryModelRel) containerModelRel).setSourceModel(targetModel);
			}
			else {
				((BinaryModelRel) containerModelRel).setTargetModel(targetModel);
			}
		}
		oldModelEndpoint.setTarget(targetModel);
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstanceAndReference(boolean isFullDelete) throws MMINTException {

		MMINTException.mustBeInstance(this);

		ModelRel containerModelRel = (ModelRel) eContainer();
		ModelEndpointReference modelEndpointRef = null;
		for (ModelEndpointReference modelEndpointRef2 : containerModelRel.getModelEndpointRefs()) {
			if (modelEndpointRef2.getObject() == this) {
				modelEndpointRef = modelEndpointRef2;
				break;
			}
		}
		if (modelEndpointRef == null) {
			throw new MMINTException("No model endpoint reference corresponding to this model endpoint");
		}
		while (modelEndpointRef.getModelElemRefs().size() > 0) {
			modelEndpointRef.getModelElemRefs().get(0).deleteInstanceReference();
		}
		if (isFullDelete) {
			containerModelRel.getModelEndpoints().remove(this);
			containerModelRel.getModelEndpointRefs().remove(modelEndpointRef);
		}
	}

} //ModelEndpointImpl
