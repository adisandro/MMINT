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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MidPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getModelEndpoints <em>Model Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getModelEndpointRefs <em>Model Endpoint Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl#getLinkRefs <em>Link Refs</em>}</li>
 * </ul>
 * </p>
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
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

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
	 * The cached value of the '{@link #getLinkRefs() <em>Link Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkReference> linkRefs;

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
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<Link>(Link.class, this, RelationshipPackage.MODEL_REL__LINKS);
		}
		return links;
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
	public EList<LinkReference> getLinkRefs() {
		if (linkRefs == null) {
			linkRefs = new EObjectContainmentEList<LinkReference>(LinkReference.class, this, RelationshipPackage.MODEL_REL__LINK_REFS);
		}
		return linkRefs;
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
			case RelationshipPackage.MODEL_REL__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				return ((InternalEList<?>)getModelEndpointRefs()).basicRemove(otherEnd, msgs);
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				return ((InternalEList<?>)getLinkRefs()).basicRemove(otherEnd, msgs);
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
			case RelationshipPackage.MODEL_REL__LINKS:
				return getLinks();
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				return getModelEndpointRefs();
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				return getLinkRefs();
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
			case RelationshipPackage.MODEL_REL__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				getModelEndpointRefs().clear();
				getModelEndpointRefs().addAll((Collection<? extends ModelEndpointReference>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				getLinkRefs().clear();
				getLinkRefs().addAll((Collection<? extends LinkReference>)newValue);
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
			case RelationshipPackage.MODEL_REL__LINKS:
				getLinks().clear();
				return;
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				getModelEndpointRefs().clear();
				return;
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				getLinkRefs().clear();
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
			case RelationshipPackage.MODEL_REL__LINKS:
				return links != null && !links.isEmpty();
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				return modelEndpointRefs != null && !modelEndpointRefs.isEmpty();
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				return linkRefs != null && !linkRefs.isEmpty();
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
		if (baseClass == Model.class) {
			switch (baseOperationID) {
				case MidPackage.MODEL___GET_METATYPE: return RelationshipPackage.MODEL_REL___GET_METATYPE;
				case MidPackage.MODEL___GET_SUPERTYPE: return RelationshipPackage.MODEL_REL___GET_SUPERTYPE;
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
			case RelationshipPackage.MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING:
				try {
					return createSubtype((String)arguments.get(0), (Boolean)arguments.get(1), (String)arguments.get(2), (String)arguments.get(3));
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
			case RelationshipPackage.MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL:
				try {
					return createInstance((String)arguments.get(0), (Boolean)arguments.get(1), (ModelOrigin)arguments.get(2), (MultiModel)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_BOOLEAN_MODELORIGIN_ELIST:
				try {
					return createInstanceAndEndpointsAndReferences((String)arguments.get(0), (Boolean)arguments.get(1), (ModelOrigin)arguments.get(2), (EList<Model>)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_REL___COPY_MAVO_INSTANCE__MODELREL_MULTIMODEL:
				try {
					return copyMAVOInstance((ModelRel)arguments.get(0), (MultiModel)arguments.get(1));
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
			case RelationshipPackage.MODEL_REL___OPEN_TYPE:
				try {
					openType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_REL___OPEN_INSTANCE:
				try {
					openInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Do not use it, use the specific one for model relationship types instead.
	 * 
	 * @throws MMINTException
	 *             Always.
	 * @generated NOT
	 */
	@Override
	public Model createSubtype(String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		throw new MMINTException("Wrong function, use the specific one for model relationship types");
	}

	/**
	 * Do not use it, use the specific one for model relationship instances
	 * instead.
	 * 
	 * @throws MMINTException
	 *             Always.
	 * @generated NOT
	 */
	@Override
	public Model createInstance(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException {

		throw new MMINTException("Wrong function, use the specific one for model relationship instances");
	}

	/**
	 * Do not use it, use the specific one for model relationship instances
	 * instead.
	 * 
	 * @throws MMINTException
	 *             Always.
	 * @generated NOT
	 */
	@Override
	public Model createInstanceAndEditor(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException {

		throw new MMINTException("Wrong function, use the specific one for model relationship instances");
	}

	/**
	 * Do not use it, use the specific one for model relationship instances
	 * instead.
	 * 
	 * @throws MMINTException
	 *             Always.
	 * @generated NOT
	 */
	@Override
	public Model createMAVOInstance(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException {

		throw new MMINTException("Wrong function, use the specific one for model relationship instances");
	}

	/**
	 * Do not use it, use the specific one for model relationship instances
	 * instead.
	 * 
	 * @throws MMINTException
	 *             Always.
	 * @generated NOT
	 */
	@Override
	public Model createMAVOInstanceAndEditor(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException {

		throw new MMINTException("Wrong function, use the specific one for model relationship instances");
	}

	/**
	 * Do not use it, use the specific one for model relationship instances
	 * instead.
	 * 
	 * @throws MMINTException
	 *             Always.
	 * @generated NOT
	 */
	@Override
	public Model copyMAVOInstanceAndEditor(Model origModel, String newModelName, boolean copyDiagram, MultiModel containerMultiModel) throws MMINTException {

		throw new MMINTException("Wrong function, use the specific one for model relationship instances");
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
	 * @generated NOT
	 */
	public ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel newModelRelType = (isBinary) ?
			RelationshipFactory.eINSTANCE.createBinaryModelRel() :
			RelationshipFactory.eINSTANCE.createModelRel();
		addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	public ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException {

		ModelRel newModelRelType = createSubtype(
			origModelRelType.getName(),
			(origModelRelType instanceof BinaryModelRel),
			origModelRelType.getConstraint().getLanguage().getLiteral(),
			origModelRelType.getConstraint().getImplementation()
		);

		// model types
		MultiModel multiModel = MultiModelRegistry.getMultiModel(newModelRelType);
		Iterator<ModelEndpoint> origModelTypeEndpointIter = MultiModelTypeHierarchy.getTypeHierarchyIterator(origModelRelType.getModelEndpoints());
		while (origModelTypeEndpointIter.hasNext()) {
			ModelEndpoint origModelTypeEndpoint = origModelTypeEndpointIter.next();
			Model newModelType = MultiModelRegistry.getExtendibleElement(origModelTypeEndpoint.getTargetUri(), multiModel);
			ModelEndpoint modelTypeEndpoint = MultiModelRegistry.getExtendibleElement(origModelTypeEndpoint.getSupertype().getUri(), multiModel);
			ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpoint.getUri(), newModelRelType.getModelEndpointRefs());
			modelTypeEndpoint.createSubtypeAndReference(modelTypeEndpointRef, origModelTypeEndpoint.getName(), newModelType, newModelRelType);
		}
		// model element types
		Iterator<ModelEndpointReference> origModelTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(origModelRelType.getModelEndpointRefs());
		while (origModelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference origModelTypeEndpointRef = origModelTypeEndpointRefIter.next();
			ModelEndpointReference newModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(origModelTypeEndpointRef, newModelRelType.getModelEndpointRefs());
			Iterator<ModelElementReference> origModelElemTypeRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(origModelTypeEndpointRef.getModelElemRefs());
			while (origModelElemTypeRefIter.hasNext()) {
				ModelElementReference origModelElemTypeRef = origModelElemTypeRefIter.next();
				ModelElement modelElemType = MultiModelRegistry.getExtendibleElement(origModelElemTypeRef.getObject().getSupertype().getUri(), multiModel);
				ModelEndpointReference newModelTypeEndpointRefSuper = null;
				ModelElementReference modelElemTypeRef = null;
				if (origModelElemTypeRef.getSupertypeRef() != null) {
					newModelTypeEndpointRefSuper = MultiModelTypeHierarchy.getReference((ModelEndpointReference) origModelElemTypeRef.getSupertypeRef().eContainer(), newModelRelType.getModelEndpointRefs());
					modelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemType.getUri(), newModelTypeEndpointRefSuper.getModelElemRefs());
				}
				modelElemType.createSubtypeAndReference(modelElemTypeRef, origModelElemTypeRef.getUri(), origModelElemTypeRef.getObject().getName(), origModelElemTypeRef.getObject().getEInfo(), newModelTypeEndpointRef);
			}
		}
		// link types
		Iterator<Link> origLinkTypeIter = MultiModelTypeHierarchy.getTypeHierarchyIterator(origModelRelType.getLinks());
		while (origLinkTypeIter.hasNext()) {
			Link origLinkType = origLinkTypeIter.next();
			Link linkType = MultiModelRegistry.getExtendibleElement(origLinkType.getSupertype().getUri(), multiModel);
			LinkReference linkTypeRef = MultiModelTypeHierarchy.getReference(origLinkType.getSupertype().getUri(), newModelRelType.getLinkRefs());
			LinkReference newLinkTypeRef = linkType.createSubtypeAndReference(linkTypeRef, origLinkType.getName(), (origLinkType instanceof BinaryLink), newModelRelType);
			// connect it to model element type references (takes care of binary too)
			LinkReference origLinkTypeRef = MultiModelTypeHierarchy.getReference(newLinkTypeRef, origModelRelType.getLinkRefs());
			Iterator<ModelElementEndpointReference> origModelElemTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(origLinkTypeRef.getModelElemEndpointRefs());
			while (origModelElemTypeEndpointRefIter.hasNext()) {
				ModelElementEndpointReference origModelElemTypeEndpointRef = origModelElemTypeEndpointRefIter.next();
				ModelElementReference origModelElemTypeRef = origModelElemTypeEndpointRef.getModelElemRef();
				ModelEndpointReference newModelTypeEndpointRef = MultiModelTypeHierarchy.getReference((ModelEndpointReference) origModelElemTypeRef.eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference newModelElemTypeRef = MultiModelTypeHierarchy.getReference(origModelElemTypeRef, newModelTypeEndpointRef.getModelElemRefs());
				ModelElementEndpoint modelElemTypeEndpoint = MultiModelRegistry.getExtendibleElement(origModelElemTypeEndpointRef.getObject().getSupertype().getUri(), multiModel);
				LinkReference newLinkTypeRefSuper = MultiModelTypeHierarchy.getReference(((Link) modelElemTypeEndpoint.eContainer()).getUri(), newModelRelType.getLinkRefs());
				ModelElementEndpointReference modelElemTypeEndpointRef = (newLinkTypeRefSuper == null) ?
					null :
					MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), newLinkTypeRefSuper.getModelElemEndpointRefs());
				modelElemTypeEndpoint.createSubtypeAndReference(modelElemTypeEndpointRef, origModelElemTypeEndpointRef.getObject().getName(), newModelElemTypeRef, false, newLinkTypeRef);
			}
		}

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteType() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		// delete the "thing"
		for (ModelEndpoint modelTypeEndpoint : getModelEndpoints()) {
			super.delete(modelTypeEndpoint.getUri(), multiModel);
		}
		for (Link linkType : getLinks()) {
			super.delete(linkType.getUri(), multiModel);
			for (ModelElementEndpoint modelElemTypeEndpoint : linkType.getModelElemEndpoints()) {
				super.delete(modelElemTypeEndpoint.getUri(), multiModel);
			}
		}
		super.deleteType(); // this also deletes the subtypes of the "thing"
	}

	/**
	 * @generated NOT
	 */
	@Override
	public EPackage getEMFTypeRoot() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		return eClass().getEPackage();
	}

	/**
	 * @generated NOT
	 */
	public ModelRel createInstance(String newModelRelUri, boolean isBinary, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel newModelRel = (isBinary) ?
			RelationshipFactory.eINSTANCE.createBinaryModelRel() :
			RelationshipFactory.eINSTANCE.createModelRel();
		super.addInstance(newModelRel, newModelRelUri, origin, containerMultiModel);

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	public ModelRel createInstanceAndEndpointsAndReferences(String newModelRelUri, boolean isBinary, ModelOrigin origin, EList<Model> targetModels) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		if (targetModels.size() == 0) {
			throw new MMINTException("No target models specified");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(targetModels.get(0));
		// create model rel
		ModelRel newModelRel = createInstance(newModelRelUri, isBinary, origin, multiModel);
		// create model rel endpoints
		for (Model targetModel : targetModels) {
			String modelTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, targetModel).get(0);
			ModelEndpoint modelTypeEndpoint = MultiModelTypeRegistry.getType(modelTypeEndpointUri);
			modelTypeEndpoint.createInstanceAndReference(targetModel, newModelRel);
		}

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	public ModelRel copyMAVOInstance(ModelRel origModelRel, MultiModel containerMultiModel) throws MMINTException {

		// create initial empty copy
		ModelRel newModelRel = createInstance(null, (origModelRel instanceof BinaryModelRel), ModelOrigin.CREATED, containerMultiModel);

		// models
		Map<String, ModelElementReference> newModelElemRefs = new HashMap<String, ModelElementReference>();
		for (ModelEndpointReference oldModelEndpointRef : origModelRel.getModelEndpointRefs()) {
			Model newModel = MultiModelRegistry.getExtendibleElement(oldModelEndpointRef.getTargetUri(), containerMultiModel);
			ModelEndpointReference newModelEndpointRef = oldModelEndpointRef.getObject().getMetatype().createInstanceAndReference(newModel, newModelRel);
			// model elements
			for (ModelElementReference oldModelElemRef : oldModelEndpointRef.getModelElemRefs()) {
				EObject newModelObj = oldModelElemRef.getObject().getEMFInstanceObject();
				ModelElementReference newModelElemRef = ModelElementImpl.createMAVOInstanceAndReference(newModelObj, oldModelElemRef.getObject().getName(), newModelEndpointRef);
				newModelElemRefs.put(newModelElemRef.getUri(), newModelElemRef);
			}
		}
		// links
		for (LinkReference oldLinkRef : origModelRel.getLinkRefs()) {
			LinkReference newLinkRef = oldLinkRef.getObject().getMetatype().createInstanceAndReference((oldLinkRef.getObject() instanceof BinaryLink), newModelRel);
			MAVOUtils.copyMAVOElement(oldLinkRef.getObject(), newLinkRef.getObject());
			newLinkRef.getObject().setName(oldLinkRef.getObject().getName());
			for (ModelElementEndpointReference oldModelElemEndpointRef : oldLinkRef.getModelElemEndpointRefs()) {
				ModelElementReference newModelElemRef = newModelElemRefs.get(oldModelElemEndpointRef.getTargetUri());
				oldModelElemEndpointRef.getObject().getMetatype().createInstanceAndReference(newModelElemRef, false, newLinkRef);
			}
		}

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		super.deleteInstance();
	}

	/**
	 * @generated NOT
	 */
	public EObject getEMFInstanceRoot() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		return this;
	}

	/**
	 * Opens this editor.
	 * 
	 * @generated NOT
	 */
	protected void openEditor() {

		// do nothing
	}

	/**
	 * @generated NOT
	 */
	public void openType() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		openEditor();
	}

	/**
	 * @generated NOT
	 */
	public void openInstance() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		openEditor();
	}

	/**
	 * @generated NOT
	 */
	public ResourceSet getOutlineResourceTypes() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

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
	public ResourceSet getOutlineResourceInstances() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		List<Resource> resources = resourceSet.getResources();
		for (ModelEndpointReference modelEndpointRef : getModelEndpointRefs()) {
			Model model = modelEndpointRef.getObject().getTarget();
			resources.add(model.getEMFInstanceRoot().eResource());
		}

		return resourceSet;
	}

} //ModelRelImpl
