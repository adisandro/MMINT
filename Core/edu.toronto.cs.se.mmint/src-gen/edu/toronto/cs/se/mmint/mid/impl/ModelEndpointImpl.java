/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MidFactory;
import edu.toronto.cs.se.mmint.mid.MidPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
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
		return MidPackage.Literals.MODEL_ENDPOINT;
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
		if (baseClass == ExtendibleElementEndpoint.class) {
			switch (baseOperationID) {
				case MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE: return MidPackage.MODEL_ENDPOINT___GET_METATYPE;
				case MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE: return MidPackage.MODEL_ENDPOINT___GET_SUPERTYPE;
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
			case MidPackage.MODEL_ENDPOINT___GET_SUPERTYPE:
				return getSupertype();
			case MidPackage.MODEL_ENDPOINT___GET_TARGET:
				return getTarget();
			case MidPackage.MODEL_ENDPOINT___GET_METATYPE:
				return getMetatype();
			case MidPackage.MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL:
				try {
					return createTypeReference((Boolean)arguments.get(0), (ModelRel)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODEL_MODELREL:
				try {
					return createSubtypeAndReference((String)arguments.get(0), (Model)arguments.get(1), (ModelRel)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_STRING_MODEL_MODELREL:
				try {
					replaceSubtypeAndReference((ModelEndpoint)arguments.get(0), (String)arguments.get(1), (Model)arguments.get(2), (ModelRel)arguments.get(3));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN:
				try {
					deleteTypeAndReference((Boolean)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL:
				try {
					return createInstanceReference((ModelRel)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_MODELREL:
				try {
					return createInstanceAndReference((Model)arguments.get(0), (ModelRel)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL_MODELREL:
				try {
					replaceInstanceAndReference((ModelEndpoint)arguments.get(0), (Model)arguments.get(1), (ModelRel)arguments.get(2));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN:
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

		super.deleteType();
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
			MultiModelTypeHierarchy.getReference(getSupertype().getUri(), containerModelRelType.getModelEndpointRefs()) :
			null;
		MultiModelTypeFactory.addTypeReference(newModelTypeEndpointRef, this, modelTypeEndpointRef, isModifiable, false);
		containerModelRelType.getModelEndpointRefs().add(newModelTypeEndpointRef);
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createTypeReference(boolean isModifiable, ModelRel containerModelRelType) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelEndpointReference newModelTypeEndpointRef = RelationshipFactory.eINSTANCE.createModelEndpointReference();
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
	protected ModelEndpointReference addSubtypeAndReference(ModelEndpoint newModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType, ModelRel containerModelRelType) throws MMINTException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerModelRelType);
		// create the "thing" and the corresponding reference
		super.addSubtype(newModelTypeEndpoint, containerModelRelType, containerModelRelType.getName() + MMINT.ENDPOINT_SEPARATOR + targetModelType.getName(), newModelTypeEndpointName);
		MultiModelTypeFactory.addModelTypeEndpoint(newModelTypeEndpoint, targetModelType, containerModelRelType);
		ModelEndpointReference newModelTypeEndpointRef = newModelTypeEndpoint.createTypeReference(true, containerModelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(containerModelRelType, multiModel)) {
			newModelTypeEndpoint.createTypeReference(false, modelRelSubtype);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createSubtypeAndReference(String newModelTypeEndpointName, Model targetModelType, ModelRel containerModelRelType) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		if (containerModelRelType instanceof BinaryModelRel) {
			if (containerModelRelType.getModelEndpoints().size() == 2) {
				throw new MMINTException("Can't add more than 2 model type endpoints to a binary model relationship type");
			}
			if (MultiModelTypeHierarchy.getOverriddenModelTypeEndpoint(containerModelRelType, targetModelType) != this) {
				throw new MMINTException("Invalid overriding of this model type endpoint");
			}
		}

		ModelEndpoint newModelTypeEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		ModelEndpointReference newModelTypeEndpointRef = addSubtypeAndReference(newModelTypeEndpoint, newModelTypeEndpointName, targetModelType, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType, ModelRel containerModelRelType) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerModelRelType);
		ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(getUri(), containerModelRelType.getModelEndpointRefs());
		oldModelTypeEndpoint.deleteTypeAndReference(false);
		// modify the "thing" and the corresponding reference
		super.addSubtype(oldModelTypeEndpoint, containerModelRelType, containerModelRelType.getName() + MMINT.ENDPOINT_SEPARATOR + targetModelType.getName(), newModelTypeEndpointName);
		if (containerModelRelType instanceof BinaryModelRel) {
			if (((BinaryModelRel) containerModelRelType).getSourceModel() == oldModelTypeEndpoint.getTarget()) {
				((BinaryModelRel) containerModelRelType).setSourceModel(targetModelType);
			}
			else {
				((BinaryModelRel) containerModelRelType).setTargetModel(targetModelType);
			}
		}
		oldModelTypeEndpoint.setTarget(targetModelType);
		if (modelTypeEndpointRef != null) {
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), containerModelRelType.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(containerModelRelType, multiModel)) {
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelSubtypeEndpointRef);
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteTypeAndReference(boolean isFullDelete) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		// delete the "thing" and the corresponding reference
		ModelRel modelRelType = (ModelRel) eContainer();
		deleteType(isFullDelete);
		ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(getUri(), modelRelType.getModelEndpointRefs());
		modelTypeEndpointRef.deleteTypeReference(isFullDelete);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(getUri(), modelRelSubtype.getModelEndpointRefs());
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

		boolean isContainer = (containerModelRel.eContainer() == null);
		super.addInstanceReference(newModelEndpointRef, isContainer);
		containerModelRel.getModelEndpointRefs().add(newModelEndpointRef);
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ModelEndpointReference newModelEndpointRef = RelationshipFactory.eINSTANCE.createModelEndpointReference();
		addInstanceReference(newModelEndpointRef, containerModelRel);

		return newModelEndpointRef;
	}

	/**
	 * Adds a model instance endpoint and a reference to it to an Instance MID.
	 * 
	 * @param newModelEndpoint
	 *            The new model endpoint to be added.
	 * @param targetModel
	 *            The model that is the target of the new model endpoint.
	 * @param modelRel
	 *            The model relationship that will contain the new model
	 *            endpoint.
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
			if (containerModelRel.getModelEndpoints().size() == 1) {
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

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		if ((containerModelRel instanceof BinaryModelRel) && (containerModelRel.getModelEndpoints().size() == 2)) {
			throw new MMINTException("Can't add more than 2 model endpoints to a binary model relationship");
		}

		ModelEndpoint newModelEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		ModelEndpointReference newModelEndpointRef = addInstanceAndReference(newModelEndpoint, targetModel, containerModelRel);

		return newModelEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public void replaceInstanceAndReference(ModelEndpoint oldModelEndpoint, Model targetModel, ModelRel containerModelRel) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		if (this.eClass() != oldModelEndpoint.eClass() && this.eClass().isSuperTypeOf(oldModelEndpoint.eClass())) {
			throw new MMINTException("Can't replace a user-defined model endpoint with a native one");
		}

		oldModelEndpoint.deleteInstanceAndReference(false);
		super.addBasicInstance(oldModelEndpoint, null, null);
		if (containerModelRel instanceof BinaryModelRel) {
			if (((BinaryModelRel) containerModelRel).getSourceModel() == oldModelEndpoint.getTarget()) {
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

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

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
