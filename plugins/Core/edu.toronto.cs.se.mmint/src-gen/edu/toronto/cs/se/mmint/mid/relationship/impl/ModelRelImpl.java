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
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
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
	public EList<ModelEndpoint> getModelEndpoints() {
		if (modelEndpoints == null) {
			modelEndpoints = new EObjectContainmentEList<ModelEndpoint>(ModelEndpoint.class, this, RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS);
		}
		return modelEndpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, RelationshipPackage.MODEL_REL__MAPPINGS);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelEndpointReference> getModelEndpointRefs() {
		if (modelEndpointRefs == null) {
			modelEndpointRefs = new EObjectContainmentEList<ModelEndpointReference>(ModelEndpointReference.class, this, RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS);
		}
		return modelEndpointRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingReference> getMappingRefs() {
		if (mappingRefs == null) {
			mappingRefs = new EObjectContainmentEList<MappingReference>(MappingReference.class, this, RelationshipPackage.MODEL_REL__MAPPING_REFS);
		}
		return mappingRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRel getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (ModelRel) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
				return modelEndpoints != null && !modelEndpoints.isEmpty();
			case RelationshipPackage.MODEL_REL__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				return modelEndpointRefs != null && !modelEndpointRefs.isEmpty();
			case RelationshipPackage.MODEL_REL__MAPPING_REFS:
				return mappingRefs != null && !mappingRefs.isEmpty();
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
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Model.class) {
			switch (baseOperationID) {
				case MIDPackage.MODEL___GET_METATYPE: return RelationshipPackage.MODEL_REL___GET_METATYPE;
				case MIDPackage.MODEL___GET_SUPERTYPE: return RelationshipPackage.MODEL_REL___GET_SUPERTYPE;
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
			case RelationshipPackage.MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_STRING_STRING_BOOLEAN:
				try {
					return createBinarySubtype((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (Boolean)arguments.get(3));
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
			case RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_ELIST_MID:
				try {
					return createInstanceAndEndpointsAndReferences((String)arguments.get(0), (EList<Model>)arguments.get(1), (MID)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE__STRING_MID:
				try {
					return createBinaryInstance((String)arguments.get(0), (MID)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_MODEL_MODEL_MID:
				try {
					return createBinaryInstanceAndEndpointsAndReferences((String)arguments.get(0), (Model)arguments.get(1), (Model)arguments.get(2), (MID)arguments.get(3));
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
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model relationship type, null if no constraint is
	 *            associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model relationship type, null if no constraint is
	 *            associated.
	 * @throws MMINTException
	 *             If the uri of the new model relationship type is already
	 *             registered in the Type MID.
	 * @generated NOT
	 */
	protected void addSubtype(ModelRel newModelRelType, String newModelRelTypeName, String constraintLanguage, String constraintImplementation) throws MMINTException {

		super.addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation, false);
		MultiModelTypeFactory.addModelRelType(newModelRelType, this);
	}

	/**
	 * Creates and adds a subtype of this model
	 * relationship type to the Type MID.
	 * 
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model relationship type, null if no constraint is
	 *            associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model relationship type, null if no constraint is
	 *            associated.
	 * @param isMetamodelExtension
	 *            Not used.
	 * @return The created model relationship type.
	 * @throws MMINTException
	 *             If this is a model relationship instance, or if the uri of
	 *             the new model relationship type is already registered in the
	 *             Type MID.
	 * @generated NOT
	 */
	@Override
	public Model createSubtype(String newModelRelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MMINTException.mustBeType(this);

		ModelRel newModelRelType = super.createThisEClass();
		this.addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	public BinaryModelRel createBinarySubtype(String newModelRelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MMINTException.mustBeType(this);

		BinaryModelRel newModelRelType = super.createThisBinaryEClass();
		this.addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	public ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException {

		ModelRel newModelRelType = (origModelRelType instanceof BinaryModelRel) ?
			this.createBinarySubtype(origModelRelType.getName(), origModelRelType.getConstraint().getLanguage(), origModelRelType.getConstraint().getImplementation(), false) :
			(ModelRel) this.createSubtype(origModelRelType.getName(), origModelRelType.getConstraint().getLanguage(), origModelRelType.getConstraint().getImplementation(), false);

		// model type endpoints
		MID typeMID = MultiModelRegistry.getMultiModel(newModelRelType);
		if (origModelRelType instanceof BinaryModelRel) { // this is useful only when there are 0 or 1 overridden endpoints, but doesn't hurt in case of 2
			Model newSrcModelType = MultiModelRegistry.getExtendibleElement(((BinaryModelRel) origModelRelType).getSourceModel().getUri(), typeMID);
			((BinaryModelRel) newModelRelType).addModelType(newSrcModelType, true);
			Model newTgtModelType = MultiModelRegistry.getExtendibleElement(((BinaryModelRel) origModelRelType).getTargetModel().getUri(), typeMID);
			((BinaryModelRel) newModelRelType).addModelType(newTgtModelType, false);
		}
		Iterator<ModelEndpoint> origModelTypeEndpointIter = MultiModelTypeHierarchy.getTypeHierarchyIterator(origModelRelType.getModelEndpoints());
		while (origModelTypeEndpointIter.hasNext()) {
			ModelEndpoint origModelTypeEndpoint = origModelTypeEndpointIter.next();
			Model newModelType = MultiModelRegistry.getExtendibleElement(origModelTypeEndpoint.getTargetUri(), typeMID);
			ModelEndpoint modelTypeEndpoint = MultiModelRegistry.getExtendibleElement(origModelTypeEndpoint.getSupertype().getUri(), typeMID);
			boolean isBinarySrc = ((origModelRelType instanceof BinaryModelRel) && (((BinaryModelRel) origModelRelType).getSourceModel() == origModelTypeEndpoint.getTarget())) ?
				true :
				false;
			modelTypeEndpoint.createSubtypeAndReference(origModelTypeEndpoint.getName(), newModelType, isBinarySrc, newModelRelType);
		}
		// model element types
		Iterator<ModelEndpointReference> origModelTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(origModelRelType.getModelEndpointRefs());
		while (origModelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference origModelTypeEndpointRef = origModelTypeEndpointRefIter.next();
			ModelEndpointReference newModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(origModelTypeEndpointRef, newModelRelType.getModelEndpointRefs());
			Iterator<ModelElementReference> origModelElemTypeRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(origModelTypeEndpointRef.getModelElemRefs());
			while (origModelElemTypeRefIter.hasNext()) {
				ModelElementReference origModelElemTypeRef = origModelElemTypeRefIter.next();
				if (!origModelElemTypeRef.isModifiable()) { // already copied by createSubtype()
					continue;
				}
				ModelElement modelElemType = MultiModelRegistry.getExtendibleElement(origModelElemTypeRef.getObject().getSupertype().getUri(), typeMID);
				ModelEndpointReference newModelTypeEndpointRefSuper = null;
				ModelElementReference modelElemTypeRef = null;
				if (origModelElemTypeRef.getSupertypeRef() != null) {
					newModelTypeEndpointRefSuper = MultiModelTypeHierarchy.getReference((ModelEndpointReference) origModelElemTypeRef.getSupertypeRef().eContainer(), newModelRelType.getModelEndpointRefs());
					modelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemType.getUri(), newModelTypeEndpointRefSuper.getModelElemRefs());
				}
				modelElemType.createSubtypeAndReference(modelElemTypeRef, origModelElemTypeRef.getUri(), origModelElemTypeRef.getObject().getName(), origModelElemTypeRef.getObject().getEInfo(), newModelTypeEndpointRef);
			}
		}
		// mapping types
		Iterator<Mapping> origMappingTypeIter = MultiModelTypeHierarchy.getTypeHierarchyIterator(origModelRelType.getMappings());
		while (origMappingTypeIter.hasNext()) {
			Mapping origMappingType = origMappingTypeIter.next();
			MappingReference origMappingTypeRef = MultiModelTypeHierarchy.getReference(origMappingType.getUri(), origModelRelType.getMappingRefs());
			Mapping mappingType = MultiModelRegistry.getExtendibleElement(origMappingType.getSupertype().getUri(), typeMID);
			MappingReference mappingTypeRef = MultiModelTypeHierarchy.getReference(origMappingType.getSupertype().getUri(), newModelRelType.getMappingRefs());
			MappingReference newMappingTypeRef = mappingType.createSubtypeAndReference(mappingTypeRef, origMappingType.getName(), (origMappingType instanceof BinaryMapping), newModelRelType);
			if (origMappingTypeRef instanceof BinaryMappingReference) { // this is useful only when there are 0 or 1 overridden endpoints, but doesn't hurt in case of 2
				ModelElementReference origSrcModelElemTypeRef = ((BinaryMappingReference) origMappingTypeRef).getSourceModelElemRef();
				ModelEndpointReference containerModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(((ModelEndpointReference) origSrcModelElemTypeRef.eContainer()), newModelRelType.getModelEndpointRefs());
				ModelElementReference newSrcModelElemTypeRef = MultiModelTypeHierarchy.getReference(origSrcModelElemTypeRef, containerModelTypeEndpointRef.getModelElemRefs());
				((BinaryMappingReference) newMappingTypeRef).addModelElementTypeReference(newSrcModelElemTypeRef, true);
				ModelElementReference origTgtModelElemTypeRef = ((BinaryMappingReference) origMappingTypeRef).getSourceModelElemRef();
				containerModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(((ModelEndpointReference) origTgtModelElemTypeRef.eContainer()), newModelRelType.getModelEndpointRefs());
				ModelElementReference newTgtModelElemTypeRef = MultiModelTypeHierarchy.getReference(origTgtModelElemTypeRef, containerModelTypeEndpointRef.getModelElemRefs());
				((BinaryMappingReference) newMappingTypeRef).addModelElementTypeReference(newTgtModelElemTypeRef, false);
			}
			Iterator<ModelElementEndpointReference> origModelElemTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(origMappingTypeRef.getModelElemEndpointRefs());
			while (origModelElemTypeEndpointRefIter.hasNext()) {
				ModelElementEndpointReference origModelElemTypeEndpointRef = origModelElemTypeEndpointRefIter.next();
				ModelElementReference origModelElemTypeRef = origModelElemTypeEndpointRef.getModelElemRef();
				ModelEndpointReference newModelTypeEndpointRef = MultiModelTypeHierarchy.getReference((ModelEndpointReference) origModelElemTypeRef.eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference newModelElemTypeRef = MultiModelTypeHierarchy.getReference(origModelElemTypeRef, newModelTypeEndpointRef.getModelElemRefs());
				ModelElementEndpoint modelElemTypeEndpoint = MultiModelRegistry.getExtendibleElement(origModelElemTypeEndpointRef.getObject().getSupertype().getUri(), typeMID);
				boolean isBinarySrc = ((origMappingTypeRef instanceof BinaryMappingReference) && (((BinaryMappingReference) origMappingTypeRef).getSourceModelElemRef() == origModelElemTypeEndpointRef.getModelElemRef())) ?
					true :
					false;
				modelElemTypeEndpoint.createSubtypeAndReference(origModelElemTypeEndpointRef.getObject().getName(), newModelElemTypeRef, isBinarySrc, newMappingTypeRef);
			}
		}

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteType() throws MMINTException {

		MMINTException.mustBeType(this);

		MID typeMID = MultiModelRegistry.getMultiModel(this);
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
	public void openType() throws Exception {

		MMINTException.mustBeType(this);
	}

	/**
	 * Creates and possibly adds a model relationship
	 * instance of this model relationship type to an Instance MID.
	 * 
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model
	 *            relationship is not in a separate file; e.g. a standalone
	 *            model relationship is in its own files, a plain model
	 *            relationship is not.
	 * @param instanceMID
	 *            An Instance MID, null if the model relationship isn't going to
	 *            be added to it.
	 * @return The created model relationship.
	 * @throws MMINTException
	 *             If this is a model relationship instance, or if the uri of
	 *             the new model relationship is already registered in the
	 *             Instance MID.
	 * @generated NOT
	 */
	@Override
	public Model createInstance(String newModelRelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		ModelRel newModelRel = super.createThisEClass();
		super.addInstance(newModelRel, newModelRelUri, ModelOrigin.CREATED, instanceMID);

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	public ModelRel createInstanceAndEndpointsAndReferences(String newModelRelUri, EList<Model> endpointModels, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);
		if (endpointModels.size() == 0) {
			throw new MMINTException("No target models specified");
		}

		// create model rel
		ModelRel newModelRel = (ModelRel) createInstance(newModelRelUri, instanceMID);
		// create model rel endpoints
		for (Model targetModel : endpointModels) {
			String modelTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, null, targetModel).get(0);
			ModelEndpoint modelTypeEndpoint = MultiModelTypeRegistry.getType(modelTypeEndpointUri);
			modelTypeEndpoint.createInstanceAndReference(targetModel, newModelRel);
		}

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	public BinaryModelRel createBinaryInstance(String newModelRelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		BinaryModelRel newModelRel = super.createThisBinaryEClass();
		super.addInstance(newModelRel, newModelRelUri, ModelOrigin.CREATED, instanceMID);

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	public BinaryModelRel createBinaryInstanceAndEndpointsAndReferences(String newModelRelUri, Model endpointSourceModel, Model endpointTargetModel, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		// create model rel
		BinaryModelRel newModelRel = createBinaryInstance(newModelRelUri, instanceMID);
		EList<Model> endpointModels = new BasicEList<>();
		endpointModels.add(endpointSourceModel);
		endpointModels.add(endpointTargetModel);
		// create model rel endpoints
		for (Model targetModel : endpointModels) {
			String modelTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, null, targetModel).get(0);
			ModelEndpoint modelTypeEndpoint = MultiModelTypeRegistry.getType(modelTypeEndpointUri);
			modelTypeEndpoint.createInstanceAndReference(targetModel, newModelRel);
		}

		return newModelRel;
	}

	/**
	 * Creates and adds a model relationship instance of
	 * this model relationship type to an Instance MID, copying its structure
	 * from another model relationship instance (including any MAVO flags).
	 * 
	 * @param origModelRel
	 *            The original model relationship instance to be copied into the
	 *            new one.
	 * @param instanceMID
	 *            An Instance MID, null if the model relationship isn't going to
	 *            be added to it.
	 * @return The created model relationship.
	 * @throws MMINTException
	 *             If this is a model relationship instance, or if the uri of
	 *             the new model relationship is already registered in the
	 *             Instance MID.
	 * @generated NOT
	 */
	@Override
	public Model copyInstance(Model origModelRel, String newModelRelName, MID instanceMID) throws MMINTException {

		// create initial empty copy
		ModelRel newModelRel = (origModelRel instanceof BinaryModelRel) ?
			this.createBinaryInstance(null, instanceMID) :
			(ModelRel) this.createInstance(null, instanceMID);
		newModelRel.setName(newModelRelName);

		// models
		Map<String, ModelElementReference> newModelElemRefs = new HashMap<>();
		for (ModelEndpointReference origModelEndpointRef : ((ModelRel) origModelRel).getModelEndpointRefs()) {
			Model newModel = MultiModelRegistry.getExtendibleElement(origModelEndpointRef.getTargetUri(), instanceMID);
			ModelEndpointReference newModelEndpointRef = origModelEndpointRef.getObject().getMetatype().createInstanceAndReference(newModel, newModelRel);
			// model elements
			for (ModelElementReference origModelElemRef : origModelEndpointRef.getModelElemRefs()) {
				EObject newModelObj = origModelElemRef.getObject().getEMFInstanceObject();
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

		boolean validates = MultiModelConstraintChecker.areAllowedModelEndpoints(this, (ModelRel) type);
		if (!validates) {
			return false;
		}
		for (Mapping mapping : this.getMappings()) {
			validates = false;
			for (Mapping mappingType : ((ModelRel) type).getMappings()) {
				validates = mapping.validateInstanceType(mappingType);
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
	public void deleteInstance() throws MMINTException {

		MMINTException.mustBeInstance(this);

		super.deleteInstance();
	}

	/**
	 * @generated NOT
	 */
	public EObject getEMFInstanceRoot() throws MMINTException {

		MMINTException.mustBeInstance(this);

		return this;
	}

	/**
	 * @generated NOT
	 */
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
	public void openInstance() throws Exception {

		MMINTException.mustBeInstance(this);
	}

} //ModelRelImpl
