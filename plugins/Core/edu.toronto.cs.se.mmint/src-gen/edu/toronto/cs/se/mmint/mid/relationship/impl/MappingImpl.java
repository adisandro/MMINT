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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.MappingImpl#getModelElemEndpoints <em>Model Elem Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.MappingImpl#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends ExtendibleElementImpl implements Mapping {
    /**
   * The cached value of the '{@link #getModelElemEndpoints() <em>Model Elem Endpoints</em>}' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getModelElemEndpoints()
   * @generated
   * @ordered
   */
    protected EList<ModelElementEndpoint> modelElemEndpoints;

    /**
   * The cached value of the '{@link #getModelElemEndpointRefs() <em>Model Elem Endpoint Refs</em>}' reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getModelElemEndpointRefs()
   * @generated
   * @ordered
   */
    protected EList<ModelElementEndpointReference> modelElemEndpointRefs;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected MappingImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return RelationshipPackage.Literals.MAPPING;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<ModelElementEndpoint> getModelElemEndpoints() {
    if (modelElemEndpoints == null) {
      modelElemEndpoints = new EObjectContainmentEList<ModelElementEndpoint>(ModelElementEndpoint.class, this, RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS);
    }
    return modelElemEndpoints;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<ModelElementEndpointReference> getModelElemEndpointRefs() {
    if (modelElemEndpointRefs == null) {
      modelElemEndpointRefs = new EObjectResolvingEList<ModelElementEndpointReference>(ModelElementEndpointReference.class, this, RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS);
    }
    return modelElemEndpointRefs;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Mapping getMetatype() {
    ExtendibleElement metatype = super.getMetatype();
    return (metatype == null) ? null : (Mapping) metatype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Mapping getSupertype() {
    ExtendibleElement supertype = super.getSupertype();
    return (supertype == null) ? null : (Mapping) supertype;
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
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS:
        return ((InternalEList<?>)getModelElemEndpoints()).basicRemove(otherEnd, msgs);
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
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS:
        return getModelElemEndpoints();
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS:
        return getModelElemEndpointRefs();
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
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS:
        getModelElemEndpoints().clear();
        getModelElemEndpoints().addAll((Collection<? extends ModelElementEndpoint>)newValue);
        return;
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS:
        getModelElemEndpointRefs().clear();
        getModelElemEndpointRefs().addAll((Collection<? extends ModelElementEndpointReference>)newValue);
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
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS:
        getModelElemEndpoints().clear();
        return;
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS:
        getModelElemEndpointRefs().clear();
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
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS:
        return modelElemEndpoints != null && !modelElemEndpoints.isEmpty();
      case RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS:
        return modelElemEndpointRefs != null && !modelElemEndpointRefs.isEmpty();
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
        case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return RelationshipPackage.MAPPING___GET_METATYPE;
        case MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER: return RelationshipPackage.MAPPING___GET_MID_CONTAINER;
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
      case RelationshipPackage.MAPPING___GET_METATYPE:
        return getMetatype();
      case RelationshipPackage.MAPPING___GET_SUPERTYPE:
        return getSupertype();
      case RelationshipPackage.MAPPING___GET_MID_CONTAINER:
        return getMIDContainer();
      case RelationshipPackage.MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL:
        try {
          return createTypeReference((MappingReference)arguments.get(0), (Boolean)arguments.get(1), (ModelRel)arguments.get(2));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL:
        try {
          return createSubtypeAndReference((MappingReference)arguments.get(0), (String)arguments.get(1), (Boolean)arguments.get(2), (ModelRel)arguments.get(3));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MAPPING___DELETE_TYPE:
        try {
          deleteType();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL:
        try {
          return createInstanceReference((ModelRel)arguments.get(0));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL:
        try {
          return createInstanceAndReference((Boolean)arguments.get(0), (ModelRel)arguments.get(1));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST:
        try {
          return createInstanceAndReferenceAndEndpointsAndReferences((Boolean)arguments.get(0), (EList<ModelElementReference>)arguments.get(1));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MAPPING___DELETE_INSTANCE:
        try {
          deleteInstance();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

    /**
     * Adds a reference to this mapping type to the Type MID.
     *
     * @param newMappingTypeRef
     *            The new reference to this mapping type to be added.
     * @param mappingTypeRef
     *            The reference to the supertype of the mapping type, null if such
     *            reference doesn't exist in the model relationship type
     *            container.
     * @param isModifiable
     *            True if the new reference will allow modifications of the
     *            referenced mapping type, false otherwise.
     * @param containerModelRelType
     *            The model relationship type that will contain the new
     *            reference to the mapping type.
     * @generated NOT
     */
    protected void addTypeReference(MappingReference newMappingTypeRef, MappingReference mappingTypeRef, boolean isModifiable, ModelRel containerModelRelType) {

        super.addTypeReference(newMappingTypeRef, mappingTypeRef, isModifiable, false);
        containerModelRelType.getMappingRefs().add(newMappingTypeRef);
    }

    /**
     * @generated NOT
     */
    @Override
    public MappingReference createTypeReference(MappingReference mappingTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException {

        MMINTException.mustBeType(this);

        MappingReference newMappingTypeRef = super.createThisReferenceEClass();
        this.addTypeReference(newMappingTypeRef, mappingTypeRef, isModifiable, containerModelRelType);

        return newMappingTypeRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public MappingReference createSubtypeAndReference(MappingReference mappingTypeRef, String newMappingTypeName, boolean isBinary, ModelRel containerModelRelType) throws MMINTException {

        MMINTException.mustBeType(this);

        // create the "thing" and the corresponding reference
        Mapping newMappingType = (isBinary) ?
            super.createThisBinaryEClass() :
            super.createThisEClass();
        MID typeMID = containerModelRelType.getMIDContainer();
        super.addSubtype(newMappingType, containerModelRelType, containerModelRelType.getName(), newMappingTypeName);
        MIDTypeFactory.addMappingType(newMappingType, this, containerModelRelType);
        MappingReference newMappingTypeRef = newMappingType.createTypeReference(mappingTypeRef, true, containerModelRelType);
        // create references of the "thing" in subtypes of the container
        for (ModelRel containerModelRelSubtype : MIDTypeHierarchy.getSubtypes(containerModelRelType, typeMID)) {
            MappingReference mappingSubtypeRef = (mappingTypeRef == null) ?
                null :
                MIDRegistry.getReference(mappingTypeRef, containerModelRelSubtype.getMappingRefs());
            newMappingType.createTypeReference(mappingSubtypeRef, false, containerModelRelSubtype);
        }

        return newMappingTypeRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteType() throws MMINTException {

        MMINTException.mustBeType(this);

        super.delete();
        for (ModelElementEndpoint modelElemTypeEndpoint : getModelElemEndpoints()) {
            modelElemTypeEndpoint.deleteType(false);
        }
        ModelRel modelRelType = (ModelRel) eContainer();
        modelRelType.getMappings().remove(this);
    }

    /**
     * Adds a reference to this mapping instance to an Instance MID.
     *
     * @param newMappingRef
     *            The new reference to this mapping to be added.
     * @param containerModelRel
     *            The model relationship that will contain the new reference to
     *            the mapping.
     * @generated NOT
     */
    protected void addInstanceReference(MappingReference newMappingRef, ModelRel containerModelRel) {

        super.addInstanceReference(newMappingRef, false);
        containerModelRel.getMappingRefs().add(newMappingRef);
    }

    /**
     * @generated NOT
     */
    @Override
    public MappingReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

        MMINTException.mustBeInstance(this);

        MappingReference newMappingRef = super.createThisReferenceEClass();
        this.addInstanceReference(newMappingRef, containerModelRel);

        return newMappingRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public MappingReference createInstanceAndReference(boolean isBinary, ModelRel containerModelRel) throws MMINTException {

        MMINTException.mustBeType(this);
        if (!MIDConstraintChecker.getAllowedMappingTypes(containerModelRel.getMetatype(), null, null).contains(this)) {
            throw new MMINTException("This mapping type is not allowed in the container model rel");
        }

        Mapping newMapping = (isBinary) ?
            super.createThisBinaryEClass() :
            super.createThisEClass();
        super.addBasicInstance(newMapping, null, null, MIDLevel.INSTANCES);
        containerModelRel.getMappings().add(newMapping);
        var newMappingRef = newMapping.createInstanceReference(containerModelRel);

        return newMappingRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public MappingReference createInstanceAndReferenceAndEndpointsAndReferences(boolean isBinary, EList<ModelElementReference> targetModelElemRefs) throws MMINTException {

        MMINTException.mustBeType(this);
        if (targetModelElemRefs.size() == 0) {
            throw new MMINTException("No target model element references specified");
        }
        if (isBinary && targetModelElemRefs.size() != 2) {
            throw new MMINTException("A binary mapping must have 2 target model elements");
        }

        var containerModelRel = (ModelRel) targetModelElemRefs.get(0).eContainer().eContainer();
        // create mapping
        var newMappingRef = createInstanceAndReference(isBinary, containerModelRel);
        // create model element endpoints
        for (var targetModelElemRef : targetModelElemRefs) {
            var modelElemTypeEndpointIds = MIDConstraintChecker.getAllowedModelElementEndpointReferences(newMappingRef, null, targetModelElemRef);
            if (modelElemTypeEndpointIds == null) {
                // wrong endpoints, clean up mapping
                newMappingRef.deleteInstanceAndReference();
                throw new MMINTException("Can't find allowed model element type endpoints");
            }
            var modelElemTypeEndpointId = modelElemTypeEndpointIds.get(0);
            var modelElemTypeEndpoint = MIDTypeRegistry.<ModelElementEndpoint>getType(modelElemTypeEndpointId);
            modelElemTypeEndpoint.createInstanceAndReference(targetModelElemRef, newMappingRef);
        }

        return newMappingRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public boolean validateInstanceType(ExtendibleElement type) throws MMINTException {

        MMINTException.mustBeInstance(this);
        MMINTException.mustBeType(type);

        return MIDConstraintChecker.areAllowedModelElementEndpointReferences(this, (Mapping) type);
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteInstance() throws MMINTException {

        MMINTException.mustBeInstance(this);

        ModelRel modelRel = (ModelRel) eContainer();
        modelRel.getMappings().remove(this);
    }

} //MappingImpl
