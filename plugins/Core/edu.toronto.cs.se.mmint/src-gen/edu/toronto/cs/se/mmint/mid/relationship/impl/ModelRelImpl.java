/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getModelEndpoints <em>Model Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getModelEndpointRefs <em>Model Endpoint Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getMappingRefs <em>Mapping Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelRelImpl extends ModelImpl implements ModelRel {
    /**
   * The cached value of the '{@link #getModelEndpoints() <em>Model Endpoints</em>}' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getModelEndpoints()
   * @generated
   * @ordered
   */
    protected EList<ModelEndpoint> modelEndpoints;

    /**
   * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getMappings()
   * @generated
   * @ordered
   */
    protected EList<Mapping> mappings;

    /**
   * The cached value of the '{@link #getModelEndpointRefs() <em>Model Endpoint Refs</em>}' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getModelEndpointRefs()
   * @generated
   * @ordered
   */
    protected EList<ModelEndpointReference> modelEndpointRefs;

    /**
   * The cached value of the '{@link #getMappingRefs() <em>Mapping Refs</em>}' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getMappingRefs()
   * @generated
   * @ordered
   */
    protected EList<MappingReference> mappingRefs;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected ModelRelImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return RelationshipPackage.Literals.MODEL_REL;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<ModelEndpoint> getModelEndpoints() {
    if (this.modelEndpoints == null) {
      this.modelEndpoints = new EObjectContainmentEList<>(ModelEndpoint.class, this, RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS);
    }
    return this.modelEndpoints;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<Mapping> getMappings() {
    if (this.mappings == null) {
      this.mappings = new EObjectContainmentEList<>(Mapping.class, this, RelationshipPackage.MODEL_REL__MAPPINGS);
    }
    return this.mappings;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<ModelEndpointReference> getModelEndpointRefs() {
    if (this.modelEndpointRefs == null) {
      this.modelEndpointRefs = new EObjectContainmentEList<>(ModelEndpointReference.class, this, RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS);
    }
    return this.modelEndpointRefs;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<MappingReference> getMappingRefs() {
    if (this.mappingRefs == null) {
      this.mappingRefs = new EObjectContainmentEList<>(MappingReference.class, this, RelationshipPackage.MODEL_REL__MAPPING_REFS);
    }
    return this.mappingRefs;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelRel getMetatype() {
    ExtendibleElement metatype = super.getMetatype();
    return (metatype == null) ? null : (ModelRel) metatype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Model getSupertype() {
    ExtendibleElement supertype = super.getSupertype();
    return (supertype == null) ? null : (Model) supertype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public MID getMIDContainer() {
    return (MID) this.eContainer();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
        return ((InternalEList<?>)getModelEndpoints()).basicRemove(otherEnd, msgs);
      case RelationshipPackage.MODEL_REL__MAPPINGS:
        return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
        return ((InternalEList<?>)getModelEndpointRefs()).basicRemove(otherEnd, msgs);
      case RelationshipPackage.MODEL_REL__MAPPING_REFS:
        return ((InternalEList<?>)getMappingRefs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
        return getModelEndpoints();
      case RelationshipPackage.MODEL_REL__MAPPINGS:
        return getMappings();
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
        return getModelEndpointRefs();
      case RelationshipPackage.MODEL_REL__MAPPING_REFS:
        return getMappingRefs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
        getModelEndpoints().clear();
        getModelEndpoints().addAll((Collection<? extends ModelEndpoint>)newValue);
        return;
      case RelationshipPackage.MODEL_REL__MAPPINGS:
        getMappings().clear();
        getMappings().addAll((Collection<? extends Mapping>)newValue);
        return;
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
        getModelEndpointRefs().clear();
        getModelEndpointRefs().addAll((Collection<? extends ModelEndpointReference>)newValue);
        return;
      case RelationshipPackage.MODEL_REL__MAPPING_REFS:
        getMappingRefs().clear();
        getMappingRefs().addAll((Collection<? extends MappingReference>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void eUnset(int featureID) {
    switch (featureID) {
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
        getModelEndpoints().clear();
        return;
      case RelationshipPackage.MODEL_REL__MAPPINGS:
        getMappings().clear();
        return;
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
        getModelEndpointRefs().clear();
        return;
      case RelationshipPackage.MODEL_REL__MAPPING_REFS:
        getMappingRefs().clear();
        return;
    }
    super.eUnset(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean eIsSet(int featureID) {
    switch (featureID) {
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
        return this.modelEndpoints != null && !this.modelEndpoints.isEmpty();
      case RelationshipPackage.MODEL_REL__MAPPINGS:
        return this.mappings != null && !this.mappings.isEmpty();
      case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
        return this.modelEndpointRefs != null && !this.modelEndpointRefs.isEmpty();
      case RelationshipPackage.MODEL_REL__MAPPING_REFS:
        return this.mappingRefs != null && !this.mappingRefs.isEmpty();
    }
    return super.eIsSet(featureID);
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
        case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return RelationshipPackage.MODEL_REL___GET_METATYPE;
        case MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER: return RelationshipPackage.MODEL_REL___GET_MID_CONTAINER;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    if (baseClass == Model.class) {
      switch (baseOperationID) {
        case MIDPackage.MODEL___GET_METATYPE: return RelationshipPackage.MODEL_REL___GET_METATYPE;
        case MIDPackage.MODEL___GET_SUPERTYPE: return RelationshipPackage.MODEL_REL___GET_SUPERTYPE;
        case MIDPackage.MODEL___GET_MID_CONTAINER: return RelationshipPackage.MODEL_REL___GET_MID_CONTAINER;
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
    @SuppressWarnings("unchecked")
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case RelationshipPackage.MODEL_REL___GET_METATYPE:
        return getMetatype();
      case RelationshipPackage.MODEL_REL___GET_SUPERTYPE:
        return getSupertype();
      case RelationshipPackage.MODEL_REL___GET_MID_CONTAINER:
        return getMIDContainer();
      case RelationshipPackage.MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN:
        try {
          return createBinarySubtype((String)arguments.get(0), (Boolean)arguments.get(1));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___COPY_SUBTYPE__MODELREL:
        try {
          return copySubtype((ModelRel)arguments.get(0));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_TYPES:
        try {
          return getOutlineResourceTypes();
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID:
        try {
          return createInstanceAndEndpoints((EObject)arguments.get(0), (String)arguments.get(1), (EList<Model>)arguments.get(2), (MID)arguments.get(3));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID:
        try {
          return createBinaryInstance((EObject)arguments.get(0), (String)arguments.get(1), (MID)arguments.get(2));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID:
        try {
          return createBinaryInstanceAndEndpoints((EObject)arguments.get(0), (String)arguments.get(1), (Model)arguments.get(2), (Model)arguments.get(3), (MID)arguments.get(4));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES:
        try {
          return getOutlineResourceInstances();
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID:
        try {
          return createWorkflowInstanceAndEndpoints((String)arguments.get(0), (EList<Model>)arguments.get(1), (MID)arguments.get(2));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID:
        try {
          return createWorkflowBinaryInstance((String)arguments.get(0), (MID)arguments.get(1));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID:
        try {
          return createWorkflowBinaryInstanceAndEndpoints((String)arguments.get(0), (Model)arguments.get(1), (Model)arguments.get(2), (MID)arguments.get(3));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

    /**
     * Adds a subtype of this model relationship type to the Type MID.
     *
     * @param newModelRelType
     *            The new model relationship type to be added.
     * @param newModelRelTypeName
     *            The name of the new model relationship type.
     * @param isMetamodelExtension
     *            Not used.
     * @throws MMINTException
     *             If the uri of the new model relationship type is already
     *             registered in the Type MID.
     * @generated NOT
     */
    @Override
    protected void addSubtype(Model newModelRelType, String newModelRelTypeName, boolean isMetamodelExtension) throws MMINTException {

        super.addSubtype(newModelRelType, newModelRelTypeName, false);
        MIDTypeFactory.addModelRelType((ModelRel) newModelRelType, this);
    }

    /**
     * @generated NOT
     */
    @Override
    public BinaryModelRel createBinarySubtype(String newModelRelTypeName, boolean isMetamodelExtension) throws MMINTException {

        MMINTException.mustBeType(this);

        BinaryModelRel newModelRelType = super.createThisBinaryEClass();
        this.addSubtype(newModelRelType, newModelRelTypeName, false);

        return newModelRelType;
    }

    /**
     * @generated NOT
     */
    @Override
    public ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException {

        ModelRel newModelRelType = (origModelRelType instanceof BinaryModelRel) ?
            this.createBinarySubtype(origModelRelType.getName(), false) :
            (ModelRel) this.createSubtype(origModelRelType.getName(), false);
        newModelRelType.addTypeConstraint(origModelRelType.getConstraint().getLanguage(), origModelRelType.getConstraint().getImplementation());

        // model type endpoints
        MID typeMID = newModelRelType.getMIDContainer();
        if (origModelRelType instanceof BinaryModelRel) { // this is useful only when there are 0 or 1 overridden endpoints, but doesn't hurt in case of 2
            Model newSrcModelType = typeMID.getExtendibleElement(((BinaryModelRel) origModelRelType).getSourceModel().getUri());
            ((BinaryModelRel) newModelRelType).addModelType(newSrcModelType, true);
            Model newTgtModelType = typeMID.getExtendibleElement(((BinaryModelRel) origModelRelType).getTargetModel().getUri());
            ((BinaryModelRel) newModelRelType).addModelType(newTgtModelType, false);
        }
        Iterator<ModelEndpoint> origModelTypeEndpointIter = MIDTypeHierarchy.getTypeHierarchyIterator(origModelRelType.getModelEndpoints());
        while (origModelTypeEndpointIter.hasNext()) {
            ModelEndpoint origModelTypeEndpoint = origModelTypeEndpointIter.next();
            Model newModelType = typeMID.getExtendibleElement(origModelTypeEndpoint.getTargetUri());
            ModelEndpoint modelTypeEndpoint = typeMID.getExtendibleElement(origModelTypeEndpoint.getSupertype().getUri());
            boolean isBinarySrc = ((origModelRelType instanceof BinaryModelRel) && (((BinaryModelRel) origModelRelType).getSourceModel() == origModelTypeEndpoint.getTarget())) ?
                true :
                false;
            modelTypeEndpoint.createSubtype(origModelTypeEndpoint.getName(), newModelType, isBinarySrc, newModelRelType);
        }
        // model element types
        Iterator<ModelEndpointReference> origModelTypeEndpointRefIter = MIDTypeHierarchy.getTypeRefHierarchyIterator(origModelRelType.getModelEndpointRefs());
        while (origModelTypeEndpointRefIter.hasNext()) {
            ModelEndpointReference origModelTypeEndpointRef = origModelTypeEndpointRefIter.next();
            ModelEndpointReference newModelTypeEndpointRef = MIDRegistry.getReference(origModelTypeEndpointRef, newModelRelType.getModelEndpointRefs());
            Iterator<ModelElementReference> origModelElemTypeRefIter = MIDTypeHierarchy.getTypeRefHierarchyIterator(origModelTypeEndpointRef.getModelElemRefs());
            while (origModelElemTypeRefIter.hasNext()) {
                ModelElementReference origModelElemTypeRef = origModelElemTypeRefIter.next();
                if (!origModelElemTypeRef.isModifiable()) { // already copied by createSubtype()
                    continue;
                }
                ModelElement modelElemType = typeMID.getExtendibleElement(origModelElemTypeRef.getObject().getSupertype().getUri());
                ModelEndpointReference newModelTypeEndpointRefSuper = null;
                ModelElementReference modelElemTypeRef = null;
                if (origModelElemTypeRef.getSupertypeRef() != null) {
                    newModelTypeEndpointRefSuper = MIDRegistry.getReference((ModelEndpointReference) origModelElemTypeRef.getSupertypeRef().eContainer(), newModelRelType.getModelEndpointRefs());
                    modelElemTypeRef = MIDRegistry.getReference(modelElemType.getUri(), newModelTypeEndpointRefSuper.getModelElemRefs());
                }
                modelElemType.createSubtypeAndReference(modelElemTypeRef, origModelElemTypeRef.getUri(), origModelElemTypeRef.getObject().getName(), origModelElemTypeRef.getObject().getEInfo(), newModelTypeEndpointRef);
            }
        }
        // mapping types
        Iterator<Mapping> origMappingTypeIter = MIDTypeHierarchy.getTypeHierarchyIterator(origModelRelType.getMappings());
        while (origMappingTypeIter.hasNext()) {
            Mapping origMappingType = origMappingTypeIter.next();
            MappingReference origMappingTypeRef = MIDRegistry.getReference(origMappingType.getUri(), origModelRelType.getMappingRefs());
            Mapping mappingType = typeMID.getExtendibleElement(origMappingType.getSupertype().getUri());
            MappingReference mappingTypeRef = MIDRegistry.getReference(origMappingType.getSupertype().getUri(), newModelRelType.getMappingRefs());
            MappingReference newMappingTypeRef = mappingType.createSubtypeAndReference(mappingTypeRef, origMappingType.getName(), (origMappingType instanceof BinaryMapping), newModelRelType);
            if (origMappingTypeRef instanceof BinaryMappingReference) { // this is useful only when there are 0 or 1 overridden endpoints, but doesn't hurt in case of 2
                ModelElementReference origSrcModelElemTypeRef = ((BinaryMappingReference) origMappingTypeRef).getSourceModelElemRef();
                ModelEndpointReference containerModelTypeEndpointRef = MIDRegistry.getReference(((ModelEndpointReference) origSrcModelElemTypeRef.eContainer()), newModelRelType.getModelEndpointRefs());
                ModelElementReference newSrcModelElemTypeRef = MIDRegistry.getReference(origSrcModelElemTypeRef, containerModelTypeEndpointRef.getModelElemRefs());
                ((BinaryMappingReference) newMappingTypeRef).addModelElementTypeReference(newSrcModelElemTypeRef, true);
                ModelElementReference origTgtModelElemTypeRef = ((BinaryMappingReference) origMappingTypeRef).getSourceModelElemRef();
                containerModelTypeEndpointRef = MIDRegistry.getReference(((ModelEndpointReference) origTgtModelElemTypeRef.eContainer()), newModelRelType.getModelEndpointRefs());
                ModelElementReference newTgtModelElemTypeRef = MIDRegistry.getReference(origTgtModelElemTypeRef, containerModelTypeEndpointRef.getModelElemRefs());
                ((BinaryMappingReference) newMappingTypeRef).addModelElementTypeReference(newTgtModelElemTypeRef, false);
            }
            Iterator<ModelElementEndpointReference> origModelElemTypeEndpointRefIter = MIDTypeHierarchy.getTypeRefHierarchyIterator(origMappingTypeRef.getModelElemEndpointRefs());
            while (origModelElemTypeEndpointRefIter.hasNext()) {
                ModelElementEndpointReference origModelElemTypeEndpointRef = origModelElemTypeEndpointRefIter.next();
                ModelElementReference origModelElemTypeRef = origModelElemTypeEndpointRef.getModelElemRef();
                ModelEndpointReference newModelTypeEndpointRef = MIDRegistry.getReference((ModelEndpointReference) origModelElemTypeRef.eContainer(), newModelRelType.getModelEndpointRefs());
                ModelElementReference newModelElemTypeRef = MIDRegistry.getReference(origModelElemTypeRef, newModelTypeEndpointRef.getModelElemRefs());
                ModelElementEndpoint modelElemTypeEndpoint = typeMID.getExtendibleElement(origModelElemTypeEndpointRef.getObject().getSupertype().getUri());
                boolean isBinarySrc = ((origMappingTypeRef instanceof BinaryMappingReference) && (((BinaryMappingReference) origMappingTypeRef).getSourceModelElemRef() == origModelElemTypeEndpointRef.getModelElemRef())) ?
                    true :
                    false;
                modelElemTypeEndpoint.createSubtypeAndReference(origModelElemTypeEndpointRef.getObject().getName(), newModelElemTypeRef, isBinarySrc, newMappingTypeRef);
            }
        }

        return newModelRelType;
    }

    /**
     * Deletes this model relationship type from the Type MID.
     *
     * @throws MMINTException
     *             If this is not a model relationship type.
     * @generated NOT
     */
    @Override
    public void deleteType() throws MMINTException {

        MMINTException.mustBeType(this);

        MID typeMID = this.getMIDContainer();
        // delete the "thing"
        for (ModelEndpoint modelTypeEndpoint : getModelEndpoints()) {
            super.delete(modelTypeEndpoint.getUri(), typeMID);
        }
        for (Mapping mappingType : this.getMappings()) {
            super.delete(mappingType.getUri(), typeMID);
            for (ModelElementEndpoint modelElemTypeEndpoint : mappingType.getModelElemEndpoints()) {
                super.delete(modelElemTypeEndpoint.getUri(), typeMID);
            }
        }
        super.deleteType(); // this also deletes the subtypes of the "thing"
    }

    /**
     * @generated NOT
     */
    @Override
    public EPackage getEMFTypeRoot() throws MMINTException {

        MMINTException.mustBeType(this);

        return eClass().getEPackage();
    }

    /**
     * @generated NOT
     */
    @Override
    public ResourceSet getOutlineResourceTypes() throws MMINTException {

        MMINTException.mustBeType(this);

        ResourceSet resourceSet = new ResourceSetImpl();
        List<Resource> resources = resourceSet.getResources();
        for (ModelEndpointReference modelTypeEndpointRef : getModelEndpointRefs()) {
            Model modelType = modelTypeEndpointRef.getObject().getTarget();
            do {
                resources.add(modelType.getEMFTypeRoot().eResource());
                modelType = modelType.getSupertype();
            }
            while (modelType != null && !modelType.isAbstract());
        }

        return resourceSet;
    }

    /**
     * @generated NOT
     */
    @Override
    public void openType() throws Exception {

        MMINTException.mustBeType(this);
    }


    /**
     * Adds an instance of this model relationship type to an Instance or Workflow MID, or simply adds additional info
     * to the model relationship instance.
     *
     * @param newModelRel
     *            The new model relationship to be added.
     * @param newModelRelId
     *            The id of the new model relationship, null if the new model relationship is not in a separate file;
     *            e.g. a standalone model relationship is in its own file, a simple model relationship is not.
     * @param newModelRelName
     *            The name of the new model relationship.
     * @param origin
     *            The origin of the new model relationship.
     * @param fileExtension
     *            The file extension of the new model relationship.
     * @param midLevel
     *            The kind of MID (Instance or Workflow) that could contain the new model relationship, regardless of
     *            whether it is or isn't going to be contained in one.
     * @param instanceMID
     *            An Instance or Workflow MID, null if the model relationship isn't going to be contained in one.
     * @throws MMINTException
     *             If the id of the new model relationship is already registered in the MID.
     * @generated NOT
     */
    @Override
    protected void addInstance(@NonNull Model newModelRel, @Nullable String newModelRelId, @NonNull String newModelRelName, @NonNull ModelOrigin origin, @NonNull String fileExtension, @NonNull MIDLevel midLevel, @Nullable MID instanceMID) throws MMINTException {

        boolean isFile = newModelRelId != null;
        boolean updateMID = instanceMID != null;
        boolean isBasic = !updateMID || !isFile;

        if (isBasic) {
            super.addBasicInstance(newModelRel, newModelRelId, newModelRelName, midLevel);
        }
        else {
            super.addInstance(newModelRel, newModelRelId, newModelRelName, instanceMID);
        }
        if (updateMID) {
            instanceMID.getModels().add(newModelRel);
        }
        newModelRel.setOrigin(origin);
        newModelRel.setFileExtension(fileExtension);
    }

    /**
     * Creates and possibly adds an instance of this model relationship type to an Instance MID.
     * <p>
     * (Support for model relationships in their own ECore file is future work, i.e. rootModelRelObj is always null)
     * <p>
     * Can be invoked in 2 ways:
     * <ol>
     * <li>(null, str, null) model rel file not created, model rel not added to the MID;
     * <li>(null, str, mid) model rel file not created, model rel added to the MID;
     * </ol>
     * </p>
     *
     * @param rootModelRelObj
     *            Always considered to be null.
     * @param newModelRelName
     *            The name for the model relationship.
     * @param instanceMID
     *            An Instance MID. Can be null if the model relationship is not going to be contained in one.
     * @return The created model relationship.
     * @throws MMINTException
     *             If this is not a model relationship type, or if this model relationship type is abstract.
     * @generated NOT
     */
    @Override
    public Model createInstance(EObject rootModelRelObj, String newModelRelName, MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);
        if (this.isAbstract()) {
            throw new MMINTException("Can't instanciate an abstract model relationship type");
        }

        //TODO MMINT[EDITOR] Add editor for modelrel too and relative api?
        ModelRel newModelRel = super.createThisEClass();
        this.addInstance(
            newModelRel,
            null,
            FileUtils.getFileNameFromPath(newModelRelName),
            ModelOrigin.CREATED,
            FileUtils.getFileExtensionFromPath(newModelRelName),
            MIDLevel.INSTANCES,
            instanceMID);

        return newModelRel;
    }

    /**
     * Adds model instance endpoints to a model relationship instance.
     *
     * @param modelRel
     *            The model relationship.
     * @param endpointModels
     *            The model endpoints to be added.
     * @throws MMINTException
     *             If the model endpoints are not allowed for the model relationship.
     * @generated NOT
     */
    protected void addInstanceEndpoints(ModelRel modelRel, EList<Model> endpointModels) throws MMINTException {

        for (Model endpointModel : endpointModels) {
            //TODO MMINT[TYPES] Should either select the most specific through inverse type hierarchy, or ask for a choice
            String modelTypeEndpointId = MIDConstraintChecker.getAllowedModelEndpoints(modelRel, null, endpointModel).get(0);
            ModelEndpoint modelTypeEndpoint = MIDTypeRegistry.getType(modelTypeEndpointId);
            modelTypeEndpoint.createInstance(endpointModel, modelRel);
        }
    }

    /**
     * @generated NOT
     */
    @Override
    public ModelRel createInstanceAndEndpoints(EObject rootModelRelObj, String newModelRelName, EList<Model> endpointModels, MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);
        if (endpointModels.size() == 0) {
            throw new MMINTException("No endpoint models specified");
        }

        ModelRel newModelRel = (ModelRel) this.createInstance(rootModelRelObj, newModelRelName, instanceMID);
        this.addInstanceEndpoints(newModelRel, endpointModels);

        return newModelRel;
    }

    /**
     * @generated NOT
     */
    @Override
    public BinaryModelRel createBinaryInstance(EObject rootModelRelObj, String newModelRelName, MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);
        if (this.isAbstract()) {
            throw new MMINTException("Can't instanciate an abstract model relationship type");
        }

        BinaryModelRel newModelRel = super.createThisBinaryEClass();
        this.addInstance(
            newModelRel,
            null,
            FileUtils.getFileNameFromPath(newModelRelName),
            ModelOrigin.CREATED,
            FileUtils.getFileExtensionFromPath(newModelRelName),
            MIDLevel.INSTANCES,
            instanceMID);

        return newModelRel;
    }

    /**
     * @generated NOT
     */
    @Override
    public BinaryModelRel createBinaryInstanceAndEndpoints(EObject rootModelRelObj, String newModelRelName, Model endpointSourceModel, Model endpointTargetModel, MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);
        if (endpointSourceModel == null || endpointTargetModel == null) {
            throw new MMINTException("One or both endpoint models not specified");
        }

        BinaryModelRel newModelRel = this.createBinaryInstance(rootModelRelObj, newModelRelName, instanceMID);
        EList<Model> endpointModels = new BasicEList<>();
        endpointModels.add(endpointSourceModel);
        endpointModels.add(endpointTargetModel);
        this.addInstanceEndpoints(newModelRel, endpointModels);

        return newModelRel;
    }

    /**
     * Creates and adds a model relationship instance of this model relationship type to an Instance MID, copying its
     * structure from another model relationship instance.
     *
     * @param origModelRel
     *            The original model relationship instance to be copied into the new one.
     * @param newModelRelName The name of the new model relationship.
     * @param instanceMID
     *            An Instance MID, null if the model relationship isn't going to be contained in one.
     * @return The created model relationship.
     * @throws MMINTException
     *             If this is not a model relationship type, or if the uri of the new model relationship is already
     *             registered in the Instance MID.
     * @generated NOT
     */
    @Override
    public Model copyInstance(Model origModelRel, String newModelRelName, MID instanceMID) throws MMINTException {

        // create initial empty copy
        ModelRel newModelRel = (origModelRel instanceof BinaryModelRel) ?
            this.createBinaryInstance(null, newModelRelName, instanceMID) :
            (ModelRel) this.createInstance(null, newModelRelName, instanceMID);

        // models
        Map<String, ModelElementReference> newModelElemRefs = new HashMap<>();
        for (ModelEndpointReference origModelEndpointRef : ((ModelRel) origModelRel).getModelEndpointRefs()) {
            Model newModel = instanceMID.getExtendibleElement(origModelEndpointRef.getTargetUri());
            if (newModel == null) { // the endpoint model is in another MID, just use the original
                newModel = origModelEndpointRef.getObject().getTarget();
            }
            ModelEndpointReference newModelEndpointRef = origModelEndpointRef.getObject().getMetatype().createInstance(newModel, newModelRel);
            // model elements
            for (ModelElementReference origModelElemRef : origModelEndpointRef.getModelElemRefs()) {
                EObject newModelObj = origModelElemRef.getObject().getEMFInstanceObject(null);
                ModelElementReference newModelElemRef = newModelEndpointRef.createModelElementInstanceAndReference(newModelObj, origModelElemRef.getObject().getName());
                newModelElemRefs.put(newModelElemRef.getUri(), newModelElemRef);
            }
        }
        // mappings
        for (MappingReference origMappingRef : ((ModelRel) origModelRel).getMappingRefs()) {
            MappingReference newMappingRef = origMappingRef.getObject().getMetatype().createInstanceAndReference((origMappingRef.getObject() instanceof BinaryMapping), newModelRel);
            newMappingRef.getObject().setName(origMappingRef.getObject().getName());
            for (ModelElementEndpointReference origModelElemEndpointRef : origMappingRef.getModelElemEndpointRefs()) {
                ModelElementReference newModelElemRef = newModelElemRefs.get(origModelElemEndpointRef.getTargetUri());
                origModelElemEndpointRef.getObject().getMetatype().createInstanceAndReference(newModelElemRef, newMappingRef);
            }
        }

        return newModelRel;
    }

    /**
     * @generated NOT
     */
    @Override
    public boolean validateInstanceType(ExtendibleElement type) throws MMINTException {

        MMINTException.mustBeInstance(this);
        MMINTException.mustBeType(type);

        boolean validates = MIDConstraintChecker.areAllowedModelEndpoints(this, (ModelRel) type);
        if (!validates) {
            return false;
        }
        // shortcut for empty model rel types that just take advantage of types of endpoints
        if (((ModelRel) type).getMappingRefs().isEmpty() && MIDTypeHierarchy.isRootType(type.getSupertype())) {
            return super.validateInstanceType(type);
        }
        for (Mapping mapping : this.getMappings()) {
            validates = false;
            for (MappingReference mappingTypeRef : ((ModelRel) type).getMappingRefs()) {
                validates = mapping.validateInstanceType(mappingTypeRef.getObject());
                if (validates) {
                    break;
                }
            }
            if (!validates) {
                return false;
            }
        }

        return super.validateInstanceType(type);
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteInstanceAndFile() throws MMINTException {

        this.deleteInstance();
    }

    /**
     * @generated NOT
     */
    @Override
    public EObject getEMFInstanceRoot() {
        return null;
    }

    /**
     * @generated NOT
     */
    @Override
    public ResourceSet getOutlineResourceInstances() throws MMINTException {

        MMINTException.mustBeInstance(this);

        ResourceSet resourceSet = new ResourceSetImpl();
        List<Resource> resources = resourceSet.getResources();
        for (ModelEndpointReference modelEndpointRef : getModelEndpointRefs()) {
            Model model = modelEndpointRef.getObject().getTarget();
            resources.add(model.getEMFInstanceRoot().eResource());
        }

        return resourceSet;
    }

    /**
     * @generated NOT
     */
    @Override
    public void openInstance() throws Exception {

        MMINTException.mustBeInstance(this);
    }

    /**
     * @generated NOT
     */
    @Override
    public Model createWorkflowInstance(String newModelRelId, MID workflowMID) throws MMINTException {

        MMINTException.mustBeType(this);

        ModelRel newModelRel = super.createThisEClass();
        super.addInstance(
            newModelRel,
            newModelRelId,
            newModelRelId,
            ModelOrigin.CREATED,
            MMINTConstants.EMPTY_MODEL_FILE_EXTENSION,
            MIDLevel.WORKFLOWS,
            workflowMID);

        return newModelRel;
    }

    /**
     * @generated NOT
     */
    @Override
    public ModelRel createWorkflowInstanceAndEndpoints(String newModelRelId, EList<Model> endpointModels, MID workflowMID) throws MMINTException {

        MMINTException.mustBeType(this);
        if (endpointModels.size() == 0) {
            throw new MMINTException("No endpoint models specified");
        }

        // create model rel
        ModelRel newWorkflowModelRel = (ModelRel) this.createWorkflowInstance(newModelRelId, workflowMID);
        // create model rel endpoints
        for (Model endpointModel : endpointModels) {
            String modelTypeEndpointUri = MIDConstraintChecker.getAllowedModelEndpoints(newWorkflowModelRel, null, endpointModel).get(0);
            ModelEndpoint modelTypeEndpoint = MIDTypeRegistry.getType(modelTypeEndpointUri);
            modelTypeEndpoint.createWorkflowInstance(endpointModel, newWorkflowModelRel);
        }

        return newWorkflowModelRel;
    }

    /**
     * @generated NOT
     */
    @Override
    public BinaryModelRel createWorkflowBinaryInstance(String newModelRelId, MID workflowMID) throws MMINTException {

        MMINTException.mustBeType(this);

        BinaryModelRel newModelRel = super.createThisBinaryEClass();
        super.addInstance(
            newModelRel,
            newModelRelId,
            newModelRelId,
            ModelOrigin.CREATED,
            MMINTConstants.EMPTY_MODEL_FILE_EXTENSION,
            MIDLevel.WORKFLOWS,
            workflowMID);

        return newModelRel;
    }

    /**
     * @generated NOT
     */
    @Override
    public BinaryModelRel createWorkflowBinaryInstanceAndEndpoints(String newModelRelId, Model endpointSourceModel, Model endpointTargetModel, MID workflowMID) throws MMINTException {

        MMINTException.mustBeType(this);

        // create model rel
        BinaryModelRel newModelRel = this.createWorkflowBinaryInstance(newModelRelId, workflowMID);
        EList<Model> endpointModels = new BasicEList<>();
        endpointModels.add(endpointSourceModel);
        endpointModels.add(endpointTargetModel);
        // create model rel endpoints
        for (Model endpointModel : endpointModels) {
            String modelTypeEndpointUri = MIDConstraintChecker.getAllowedModelEndpoints(newModelRel, null, endpointModel).get(0);
            ModelEndpoint modelTypeEndpoint = MIDTypeRegistry.getType(modelTypeEndpointUri);
            modelTypeEndpoint.createWorkflowInstance(endpointModel, newModelRel);
        }

        return newModelRel;
    }

} //ModelRelImpl
