/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

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
    @Override
    public ModelEndpoint getSupertype() {
    ExtendibleElementEndpoint supertype = super.getSupertype();
    return (supertype == null) ? null : (ModelEndpoint) supertype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public MID getMIDContainer() {
    return (MID) this.eContainer().eContainer();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Model getTarget() {
    ExtendibleElement target = super.getTarget();
    return (target == null) ? null : (Model) target;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
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
      case MIDPackage.MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL:
        try {
          return createSubtype((String)arguments.get(0), (Model)arguments.get(1), (Boolean)arguments.get(2), (ModelRel)arguments.get(3));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL:
        try {
          replaceSubtype((ModelEndpoint)arguments.get(0), (String)arguments.get(1), (Model)arguments.get(2));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN:
        try {
          deleteType((Boolean)arguments.get(0));
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
      case MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL:
        try {
          return createInstance((Model)arguments.get(0), (ModelRel)arguments.get(1));
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
      case MIDPackage.MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL:
        try {
          replaceInstance((ModelEndpoint)arguments.get(0), (Model)arguments.get(1));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN:
        try {
          deleteInstance((Boolean)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_MODELREL:
        try {
          return createWorkflowInstance((Model)arguments.get(0), (ModelRel)arguments.get(1));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_OPERATOR_STRING:
        try {
          return createWorkflowInstance((Model)arguments.get(0), (Operator)arguments.get(1), (String)arguments.get(2));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ENDPOINT___REPLACE_WORKFLOW_INSTANCE__MODELENDPOINT_MODEL:
        try {
          replaceWorkflowInstance((ModelEndpoint)arguments.get(0), (Model)arguments.get(1));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ENDPOINT___DELETE_WORKFLOW_INSTANCE:
        try {
          deleteWorkflowInstance();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
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
            MIDRegistry.getReference(getSupertype().getUri(), containerModelRelType.getModelEndpointRefs()) :
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
        this.addTypeReference(newModelTypeEndpointRef, isModifiable, containerModelRelType);

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
    public ModelEndpointReference createSubtype(String newModelTypeEndpointName, Model targetModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMINTException {

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
        ModelEndpointReference newModelTypeEndpointRef = this.addSubtypeAndReference(newModelTypeEndpoint, newModelTypeEndpointName, targetModelType, isBinarySrc, containerModelRelType);

        return newModelTypeEndpointRef;
    }

    /**
     * @generated NOT
     */
    public void replaceSubtype(ModelEndpoint oldModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType) throws MMINTException {

        MMINTException.mustBeType(this);
        EObject containerType = oldModelTypeEndpoint.eContainer();
        if (containerType instanceof Operator) {
            throw new MMINTException("Can't use this api with operator types");
        }
        ModelRel containerModelRelType = (ModelRel) containerType;
        if (containerModelRelType instanceof BinaryModelRel) {
            if (MIDTypeHierarchy.getOverriddenModelTypeEndpoint(containerModelRelType, targetModelType) != this) {
                throw new MMINTException("Invalid overriding of this model type endpoint");
            }
        }

        MID instanceMID = containerModelRelType.getMIDContainer();
        ModelEndpointReference modelTypeEndpointRef = MIDRegistry.getReference(getUri(), containerModelRelType.getModelEndpointRefs());
        oldModelTypeEndpoint.deleteType(false);
        // modify the "thing" and the corresponding reference
        super.addSubtype(oldModelTypeEndpoint, containerModelRelType, containerModelRelType.getName() + MMINT.ENDPOINT_SEPARATOR + targetModelType.getName(), newModelTypeEndpointName);
        if (containerModelRelType instanceof BinaryModelRel) {
            boolean isBinarySrc = ((BinaryModelRel) containerModelRelType).getSourceModel() == oldModelTypeEndpoint.getTarget();
            ((BinaryModelRel) containerModelRelType).addModelType(targetModelType, isBinarySrc);
        }
        oldModelTypeEndpoint.setTarget(targetModelType);
        if (modelTypeEndpointRef != null) {
            ModelEndpointReference oldModelTypeEndpointRef = MIDRegistry.getReference(oldModelTypeEndpoint.getUri(), containerModelRelType.getModelEndpointRefs());
            oldModelTypeEndpointRef.setSupertypeRef(modelTypeEndpointRef);
        }
        // modify references of the "thing" in subtypes of the container
        for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(containerModelRelType, instanceMID)) {
            ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
                null :
                MIDRegistry.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
            ModelEndpointReference oldModelTypeEndpointRef = MIDRegistry.getReference(oldModelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
            oldModelTypeEndpointRef.setSupertypeRef(modelSubtypeEndpointRef);
        }
    }

    /**
     * @generated NOT
     */
    public void deleteType(boolean isFullDelete) throws MMINTException {

        MMINTException.mustBeType(this);
        EObject containerType = this.eContainer();
        if (containerType instanceof Operator) {
            throw new MMINTException("Can't use this api with operator types");
        }

        MID typeMID = this.getMIDContainer();
        // delete the "thing" and the corresponding reference
        ModelRel modelRelType = (ModelRel) containerType;
        super.delete();
        if (isFullDelete) {
            modelRelType.getModelEndpoints().remove(this);
        }
        ModelEndpointReference modelTypeEndpointRef = MIDRegistry.getReference(getUri(), modelRelType.getModelEndpointRefs());
        modelTypeEndpointRef.deleteTypeReference(isFullDelete);
        // delete references of the "thing" in subtypes of the container
        for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
            ModelEndpointReference modelSubtypeEndpointRef = MIDRegistry.getReference(getUri(), modelRelSubtype.getModelEndpointRefs());
            modelSubtypeEndpointRef.deleteTypeReference(isFullDelete);
        }
    }

    /**
     * Adds a reference to this model instance endpoint to an Instance MID.
     * 
     * @param newModelEndpointRef
     *            The new reference to this model endpoint to be added.
     * @param containerModelRel
     *            The model relationship that will contain the new reference to the model endpoint.
     * @generated NOT
     */
    protected void addInstanceReference(@NonNull ModelEndpointReference newModelEndpointRef, @NonNull ModelRel containerModelRel) {

        super.addInstanceReference(newModelEndpointRef, false);
        containerModelRel.getModelEndpointRefs().add(newModelEndpointRef);
    }

    /**
     * @generated NOT
     */
    public ModelEndpointReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

        MMINTException.mustBeInstance(this);

        ModelEndpointReference newModelEndpointRef = super.createThisReferenceEClass();
        this.addInstanceReference(newModelEndpointRef, containerModelRel);

        return newModelEndpointRef;
    }

    /**
     * Adds a model instance endpoint of this model type endpoint to an Instance or Workflow MID (variant for model
     * relationships).
     * 
     * @param newModelEndpoint
     *            The new model endpoint to be added.
     * @param targetModel
     *            The model that is the target of the new model endpoint.
     * @param containerModelRel
     *            The model relationship that will contain the new model endpoint.
     * @generated NOT
     */
    protected void addInstance(@NonNull ModelEndpoint newModelEndpoint, @NonNull Model targetModel, @NonNull ModelRel containerModelRel) {

        super.addBasicInstance(newModelEndpoint, null, targetModel.getName(), containerModelRel.getLevel());
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
    }

    /**
     * Adds a model instance endpoint of this model type endpoint and a reference to it to an Instance MID (variant for
     * model relationships).
     * 
     * @param newModelEndpoint
     *            The new model endpoint to be added.
     * @param targetModel
     *            The model that is the target of the new model endpoint.
     * @param containerModelRel
     *            The model relationship that will contain the new model endpoint.
     * @return The created reference to the new model endpoint.
     * @throws MMINTException
     *             If the new model endpoint is not a model instance endpoint.
     * @generated NOT
     */
    protected ModelEndpointReference addInstanceAndReference(@NonNull ModelEndpoint newModelEndpoint, @NonNull Model targetModel, @NonNull ModelRel containerModelRel) throws MMINTException {

        this.addInstance(newModelEndpoint, targetModel, containerModelRel);
        ModelEndpointReference modelEndpointRef = newModelEndpoint.createInstanceReference(containerModelRel);

        return modelEndpointRef;
    }

    /**
     * @generated NOT
     */
    public ModelEndpointReference createInstance(Model targetModel, ModelRel containerModelRel) throws MMINTException {

        MMINTException.mustBeType(this);
        if ((containerModelRel instanceof BinaryModelRel) && (containerModelRel.getModelEndpoints().size() == 2)) {
            throw new MMINTException("Can't add more than 2 model endpoints to a binary model relationship");
        }

        ModelEndpoint newModelEndpoint = super.createThisEClass();
        ModelEndpointReference newModelEndpointRef = this.addInstanceAndReference(newModelEndpoint, targetModel, containerModelRel);

        return newModelEndpointRef;
    }

    /**
     * Adds a model instance endpoint of this model type endpoint to an Instance or Workflow MID (variant for operators).
     * 
     * @param newModelEndpoint
     *            The new model endpoint to be added.
     * @param targetModel
     *            The model that is the target of the new model endpoint.
     * @param containerOperator
     *            The operator that will contain the new model endpoint.
     * @param containerFeatureName
     *            The name of the feature in the operator that will contain the new model endpoint (input or output).
     * @throws MMINTException
     *             If the feature name is not found in the container operator.
     * @generated NOT
     */
    protected void addInstance(@NonNull ModelEndpoint newModelEndpoint, @NonNull Model targetModel, @NonNull Operator containerOperator, @NonNull String containerFeatureName) throws MMINTException {

        super.addBasicInstance(newModelEndpoint, null, this.getName(), containerOperator.getLevel());
        super.addInstanceEndpoint(newModelEndpoint, targetModel);
        FileUtils.setModelObjectFeature(containerOperator, containerFeatureName, newModelEndpoint);
    }

    /**
     * @generated NOT
     */
    public ModelEndpoint createInstance(Model targetModel, Operator containerOperator, String containerFeatureName) throws MMINTException {

        MMINTException.mustBeType(this);

        ModelEndpoint newModelEndpoint = super.createThisEClass();
        this.addInstance(newModelEndpoint, targetModel, containerOperator, containerFeatureName);

        return newModelEndpoint;
    }

    /**
     * Replaces an old model instance endpoint with a new one of this type in an Instance or Workflow MID.
     * 
     * @param oldModelEndpoint
     *            The old model endpoint to be replaced.
     * @param targetModel
     *            The model that is the target of the new model endpoint.
     * @param containerModelRel
     *            The model relationship that will contain the new model endpoint.
     * @generated NOT
     */
    protected void replaceInstance(@NonNull ModelEndpoint oldModelEndpoint, @NonNull Model targetModel, @NonNull ModelRel containerModelRel) {

        super.addBasicInstance(oldModelEndpoint, null, targetModel.getName(), containerModelRel.getLevel());
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
     * Replaces an old model instance endpoint and the reference to it with new ones of this type in an Instance MID.
     * 
     * @param oldModelEndpoint
     *            The old model endpoint to be replaced.
     * @param targetModel
     *            The model that is the target of the new model endpoint.
     * @param containerModelRel
     *            The model relationship that will contain the new model endpoint.
     * @throws MMINTException
     *             If the old model endpoint is not an instance.
     * @generated NOT
     */
    protected void replaceInstanceAndReference(@NonNull ModelEndpoint oldModelEndpoint, @NonNull Model targetModel, @NonNull ModelRel containerModelRel) throws MMINTException {

        oldModelEndpoint.deleteInstance(false);
        this.replaceInstance(oldModelEndpoint, targetModel, containerModelRel);
    }

    /**
     * @generated NOT
     */
    public void replaceInstance(ModelEndpoint oldModelEndpoint, Model targetModel) throws MMINTException {

        MMINTException.mustBeType(this);
        if (this.eClass() != oldModelEndpoint.eClass() && this.eClass().isSuperTypeOf(oldModelEndpoint.eClass())) {
            throw new MMINTException("Can't replace a user-defined model endpoint with a native one");
        }
        EObject container = oldModelEndpoint.eContainer();
        if (container instanceof Operator) {
            throw new MMINTException("Can't use this api with operators");
        }

        this.replaceInstanceAndReference(oldModelEndpoint, targetModel, (ModelRel) container);
    }

    /**
     * Deletes this model instance endpoint from the Instance or Workflow MID that contains it.
     * 
     * @param containerModelRel
     *            The model relationship that contains the model endpoint.
     * @generated NOT
     */
    protected void deleteInstance(@NonNull ModelRel containerModelRel) {

        containerModelRel.getModelEndpoints().remove(this);
    }

    /**
     * Deletes this model instance endpoint and the reference to it from the Instance MID that contains them.
     * 
     * @param isFullDelete
     *            True if this model endpoint is going to be fully deleted, false if it is going to be replaced later.
     * @param containerModelRel
     *            The model relationship that contains the model endpoint.
     * @throws MMINTException
     *             If there is no reference to this model endpoint.
     * @generated NOT
     */
    protected void deleteInstanceAndReference(boolean isFullDelete, @NonNull ModelRel containerModelRel) throws MMINTException {

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
            containerModelRel.getModelEndpointRefs().remove(modelEndpointRef);
            this.deleteInstance(containerModelRel);
        }
    }

    /**
     * @generated NOT
     */
    public void deleteInstance(boolean isFullDelete) throws MMINTException {

        MMINTException.mustBeInstance(this);
        EObject container = this.eContainer();
        if (container instanceof Operator) {
            throw new MMINTException("Can't use this api with operators");
        }

        this.deleteInstanceAndReference(isFullDelete, (ModelRel) container);
    }

    /**
     * @generated NOT
     */
    public ModelEndpoint createWorkflowInstance(Model targetModel, ModelRel containerModelRel) throws MMINTException {

        MMINTException.mustBeType(this);
        if ((containerModelRel instanceof BinaryModelRel) && (containerModelRel.getModelEndpoints().size() == 2)) {
            throw new MMINTException("Can't add more than 2 model endpoints to a binary model relationship");
        }

        ModelEndpoint newModelEndpoint = super.createThisEClass();
        this.addInstance(newModelEndpoint, targetModel, containerModelRel);

        return newModelEndpoint;
    }

    /**
     * @generated NOT
     */
    public ModelEndpoint createWorkflowInstance(Model targetModel, Operator containerOperator, String containerFeatureName) throws MMINTException {

        MMINTException.mustBeType(this);

        ModelEndpoint newModelEndpoint = super.createThisEClass();
        this.addInstance(newModelEndpoint, targetModel, containerOperator, containerFeatureName);

        return newModelEndpoint;
    }

    /**
     * @generated NOT
     */
    public void replaceWorkflowInstance(ModelEndpoint oldModelEndpoint, Model targetModel) throws MMINTException {

        MMINTException.mustBeType(this);
        if (this.eClass() != oldModelEndpoint.eClass() && this.eClass().isSuperTypeOf(oldModelEndpoint.eClass())) {
            throw new MMINTException("Can't replace a user-defined model endpoint with a native one");
        }
        EObject container = oldModelEndpoint.eContainer();
        if (container instanceof Operator) {
            throw new MMINTException("Can't use this api with operators");
        }

        this.replaceInstance(oldModelEndpoint, targetModel, (ModelRel) container);
    }

    /**
     * @generated NOT
     */
    public void deleteWorkflowInstance() throws MMINTException {

        MMINTException.mustBeWorkflow(this);
        EObject container = this.eContainer();
        if (container instanceof Operator) {
            throw new MMINTException("Can't use this api with operators");
        }

        this.deleteInstance((ModelRel) container);
    }

} //ModelEndpointImpl
