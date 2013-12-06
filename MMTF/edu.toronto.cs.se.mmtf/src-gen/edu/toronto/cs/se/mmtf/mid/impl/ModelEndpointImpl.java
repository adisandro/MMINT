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
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

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
			case MidPackage.MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELENDPOINTREFERENCE_STRING_MODEL_BOOLEAN_MODELREL:
				try {
					return createSubtypeAndReference((ModelEndpointReference)arguments.get(0), (String)arguments.get(1), (Model)arguments.get(2), (Boolean)arguments.get(3), (ModelRel)arguments.get(4));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_MODELENDPOINTREFERENCE_STRING_MODEL_MODELREL:
				try {
					replaceSubtypeAndReference((ModelEndpoint)arguments.get(0), (ModelEndpointReference)arguments.get(1), (String)arguments.get(2), (Model)arguments.get(3), (ModelRel)arguments.get(4));
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
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Adds a subtype of this model type endpoint and a reference to it to the
	 * Type MID.
	 * 
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint to be added.
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param isBinarySrc
	 *            True if the model type endpoint is the source in the binary
	 *            model relationship type container, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the model type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the Type MID.
	 * @generated NOT
	 */
	protected ModelEndpointReference addSubtypeAndReference(ModelEndpoint newModelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerModelRelType);
		// create the "thing" and the corresponding reference
		MultiModelLightTypeFactory.addLightType(newModelTypeEndpoint, this, containerModelRelType, containerModelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		MultiModelTypeFactory.addModelTypeEndpoint(newModelTypeEndpoint, newModelType, isBinarySrc, containerModelRelType);
		ModelEndpointReference newModelTypeEndpointRef = MultiModelTypeFactory.createModelTypeEndpointReference(newModelTypeEndpoint, modelTypeEndpointRef, true, isBinarySrc, containerModelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(containerModelRelType, multiModel)) {
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			MultiModelTypeFactory.createModelTypeEndpointReference(newModelTypeEndpoint, modelSubtypeEndpointRef, false, isBinarySrc, modelRelSubtype);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * Creates and adds a subtype of this model type endpoint and a reference to
	 * it to the Type MID.
	 * 
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param isBinarySrc
	 *            True if the model type endpoint is the source in the binary
	 *            model relationship type container, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the model type endpoint.
	 * @throws MMTFException
	 *             If this model relationship is at the INSTANCES level, or if
	 *             the uri of the new model type endpoint is already registered
	 *             in the Type MID.
	 * @generated NOT
	 */
	public ModelEndpointReference createSubtypeAndReference(ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelEndpoint newModelTypeEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		ModelEndpointReference newModelTypeEndpointRef = addSubtypeAndReference(newModelTypeEndpoint, modelTypeEndpointRef, newModelTypeEndpointName, newModelType, isBinarySrc, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * Replaces an old subtype of this model type endpoint and a reference to it
	 * with new ones in the Type MID.
	 * 
	 * @param oldModelTypeEndpoint
	 *            The old model type endpoint to be replaced.
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @throws MMTFException
	 *             If this model relationship is at the INSTANCES level, or if
	 *             the uri of the new model type endpoint is already registered
	 *             in the Type MID.
	 * @generated NOT
	 */
	public void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, ModelRel containerModelRelType) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerModelRelType);
		// modify the "thing" and the corresponding reference
		MultiModelLightTypeFactory.addLightType(oldModelTypeEndpoint, this, containerModelRelType, containerModelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		oldModelTypeEndpoint.setTarget(newModelType);
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
	 * Deletes this model type endpoint and all references to it from the Type
	 * MID.
	 * 
	 * @param isFullDelete
	 *            True if this model type endpoint is going to be fully deleted,
	 *            false if it is going to be replaced later.
	 * @throws MMTFException
	 *             If this model relationship is at the INSTANCES level.
	 * @generated NOT
	 */
	public void deleteTypeAndReference(boolean isFullDelete) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		// delete the "thing" and the corresponding reference
		MultiModelTypeFactory.removeModelTypeEndpoint(this, isFullDelete);
		ModelRel modelRelType = (ModelRel) eContainer();
		ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(getUri(), modelRelType.getModelEndpointRefs());
		MultiModelTypeFactory.removeModelTypeEndpointReference(modelTypeEndpointRef, isFullDelete);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(getUri(), modelRelSubtype.getModelEndpointRefs());
			MultiModelTypeFactory.removeModelTypeEndpointReference(modelSubtypeEndpointRef, isFullDelete);
		}
	}

} //ModelEndpointImpl
