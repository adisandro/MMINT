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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.LinkImpl#getModelElemEndpoints <em>Model Elem Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.LinkImpl#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends ExtendibleElementImpl implements Link {
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
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementEndpoint> getModelElemEndpoints() {
		if (modelElemEndpoints == null) {
			modelElemEndpoints = new EObjectContainmentEList<ModelElementEndpoint>(ModelElementEndpoint.class, this, RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS);
		}
		return modelElemEndpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementEndpointReference> getModelElemEndpointRefs() {
		if (modelElemEndpointRefs == null) {
			modelElemEndpointRefs = new EObjectResolvingEList<ModelElementEndpointReference>(ModelElementEndpointReference.class, this, RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS);
		}
		return modelElemEndpointRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (Link) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (Link) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				return getModelElemEndpoints();
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				getModelElemEndpoints().clear();
				getModelElemEndpoints().addAll((Collection<? extends ModelElementEndpoint>)newValue);
				return;
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				getModelElemEndpoints().clear();
				return;
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				return modelElemEndpoints != null && !modelElemEndpoints.isEmpty();
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RelationshipPackage.LINK___GET_METATYPE:
				return getMetatype();
			case RelationshipPackage.LINK___GET_SUPERTYPE:
				return getSupertype();
			case RelationshipPackage.LINK___CREATE_TYPE_REFERENCE__LINKREFERENCE_BOOLEAN_MODELREL:
				try {
					return createTypeReference((LinkReference)arguments.get(0), (Boolean)arguments.get(1), (ModelRel)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK___CREATE_SUBTYPE_AND_REFERENCE__LINKREFERENCE_STRING_BOOLEAN_MODELREL:
				try {
					return createSubtypeAndReference((LinkReference)arguments.get(0), (String)arguments.get(1), (Boolean)arguments.get(2), (ModelRel)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK___CREATE_INSTANCE_REFERENCE__MODELREL:
				try {
					return createInstanceReference((ModelRel)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL:
				try {
					return createInstanceAndReference((Boolean)arguments.get(0), (ModelRel)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST:
				try {
					return createInstanceAndReferenceAndEndpointsAndReferences((Boolean)arguments.get(0), (EList<ModelElementReference>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK___DELETE_INSTANCE:
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
	 * Adds a reference to this link type to the Type MID.
	 * 
	 * @param newLinkTypeRef
	 *            The new reference to this link type to be added.
	 * @param linkTypeRef
	 *            The reference to the supertype of the link type, null if such
	 *            reference doesn't exist in the model relationship type
	 *            container.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced link type, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the link type.
	 * @generated NOT
	 */
	protected void addTypeReference(LinkReference newLinkTypeRef, LinkReference linkTypeRef, boolean isModifiable, ModelRel containerModelRelType) {

		super.addTypeReference(newLinkTypeRef, linkTypeRef, isModifiable, false);
		containerModelRelType.getLinkRefs().add(newLinkTypeRef);
	}

	/**
	 * @generated NOT
	 */
	public LinkReference createTypeReference(LinkReference linkTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		LinkReference newLinkTypeRef = RelationshipFactory.eINSTANCE.createLinkReference();
		addTypeReference(newLinkTypeRef, linkTypeRef, isModifiable, containerModelRelType);

		return newLinkTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public LinkReference createSubtypeAndReference(LinkReference linkTypeRef, String newLinkTypeName, boolean isBinary, ModelRel containerModelRelType) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		// create the "thing" and the corresponding reference
		Link newLinkType = (isBinary) ?
			RelationshipFactory.eINSTANCE.createBinaryLink() :
			RelationshipFactory.eINSTANCE.createLink();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerModelRelType);
		super.addSubtype(newLinkType, containerModelRelType, containerModelRelType.getName(), newLinkTypeName);
		MultiModelTypeFactory.addLinkType(newLinkType, this, containerModelRelType);
		LinkReference newLinkTypeRef = newLinkType.createTypeReference(linkTypeRef, true, containerModelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel containerModelRelSubtype : MultiModelTypeHierarchy.getSubtypes(containerModelRelType, multiModel)) {
			LinkReference linkSubtypeRef = (linkTypeRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(linkTypeRef, containerModelRelSubtype.getLinkRefs());
			newLinkType.createTypeReference(linkSubtypeRef, false, containerModelRelSubtype);
		}

		return newLinkTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		super.deleteType();
		for (ModelElementEndpoint modelElemTypeEndpoint : getModelElemEndpoints()) {
			modelElemTypeEndpoint.deleteType(false);
		}
		ModelRel modelRelType = (ModelRel) eContainer();
		modelRelType.getLinks().remove(this);
	}

	/**
	 * Adds a reference to this link instance to an Instance MID.
	 * 
	 * @param newLinkRef
	 *            The new reference to this link to be added.
	 * @param containerModelRel
	 *            The model relationship that will contain the new reference to
	 *            the link.
	 * @generated NOT
	 */
	protected void addInstanceReference(LinkReference newLinkRef, ModelRel containerModelRel) {

		super.addInstanceReference(newLinkRef, false);
		containerModelRel.getLinkRefs().add(newLinkRef);
	}

	/**
	 * @generated NOT
	 */
	public LinkReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		LinkReference newLinkRef = RelationshipFactory.eINSTANCE.createLinkReference();
		addInstanceReference(newLinkRef, containerModelRel);

		return newLinkRef;
	}

	/**
	 * @generated NOT
	 */
	public LinkReference createInstanceAndReference(boolean isBinary, ModelRel containerModelRel) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Link newLink = (isBinary) ?
			RelationshipFactory.eINSTANCE.createBinaryLink() :
			RelationshipFactory.eINSTANCE.createLink();
		super.addBasicInstance(newLink, null, null);
		containerModelRel.getLinks().add(newLink);
		LinkReference newLinkRef = newLink.createInstanceReference(containerModelRel);

		return newLinkRef;
	}

	/**
	 * @generated NOT
	 */
	public LinkReference createInstanceAndReferenceAndEndpointsAndReferences(boolean isBinary, EList<ModelElementReference> targetModelElemRefs) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}
		if (targetModelElemRefs.size() == 0) {
			throw new MMINTException("No target model element references specified");
		}

		ModelRel containerModelRel = (ModelRel) targetModelElemRefs.get(0).eContainer().eContainer();
		// create link
		LinkReference newLinkRef = createInstanceAndReference(isBinary, containerModelRel);
		// create model element endpoints
		for (ModelElementReference targetModelElemRef : targetModelElemRefs) {
			String modelElemTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(newLinkRef, null, targetModelElemRef).get(0);
			ModelElementEndpoint modelElemTypeEndpoint = MultiModelTypeRegistry.getType(modelElemTypeEndpointUri);
			modelElemTypeEndpoint.createInstanceAndReference(targetModelElemRef, newLinkRef);
		}

		return newLinkRef;
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ModelRel modelRel = (ModelRel) eContainer();
		modelRel.getLinks().remove(this);
	}

} //LinkImpl
