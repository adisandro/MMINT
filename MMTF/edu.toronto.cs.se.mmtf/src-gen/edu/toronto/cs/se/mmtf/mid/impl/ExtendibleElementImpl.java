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
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extendible Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#getMetatype <em>Metatype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#getMetatypeUri <em>Metatype Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExtendibleElementImpl extends MAVOElementImpl implements ExtendibleElement {
	/**
	 * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupertype()
	 * @generated
	 * @ordered
	 */
	protected ExtendibleElement supertype;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final MidLevel LEVEL_EDEFAULT = MidLevel.INSTANCES;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected MidLevel level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetatypeUri() <em>Metatype Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetatypeUri()
	 * @generated
	 * @ordered
	 */
	protected static final String METATYPE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetatypeUri() <em>Metatype Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetatypeUri()
	 * @generated
	 * @ordered
	 */
	protected String metatypeUri = METATYPE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamic = DYNAMIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected ExtendibleElementConstraint constraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendibleElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidPackage.Literals.EXTENDIBLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement getSupertype() {
		if (supertype != null && supertype.eIsProxy()) {
			InternalEObject oldSupertype = (InternalEObject)supertype;
			supertype = (ExtendibleElement)eResolveProxy(oldSupertype);
			if (supertype != oldSupertype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE, oldSupertype, supertype));
			}
		}
		return supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement basicGetSupertype() {
		return supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupertype(ExtendibleElement newSupertype) {
		ExtendibleElement oldSupertype = supertype;
		supertype = newSupertype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE, oldSupertype, supertype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement getMetatype() {
		ExtendibleElement metatype = basicGetMetatype();
		return metatype != null && metatype.eIsProxy() ? (ExtendibleElement)eResolveProxy((InternalEObject)metatype) : metatype;
	}

	/**
	 * Uses metatype uri to get static metatype.
	 * 
	 * @generated NOT
	 */
	public ExtendibleElement basicGetMetatype() {

		return MultiModelTypeIntrospection.getType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidLevel getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(MidLevel newLevel) {
		MidLevel oldLevel = level;
		level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetatypeUri() {
		return metatypeUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetatypeUri(String newMetatypeUri) {
		String oldMetatypeUri = metatypeUri;
		metatypeUri = newMetatypeUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI, oldMetatypeUri, metatypeUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamic(boolean newDynamic) {
		boolean oldDynamic = dynamic;
		dynamic = newDynamic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__DYNAMIC, oldDynamic, dynamic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElementConstraint getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraint(ExtendibleElementConstraint newConstraint, NotificationChain msgs) {
		ExtendibleElementConstraint oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, oldConstraint, newConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(ExtendibleElementConstraint newConstraint) {
		if (newConstraint != constraint) {
			NotificationChain msgs = null;
			if (constraint != null)
				msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, null, msgs);
			if (newConstraint != null)
				msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, null, msgs);
			msgs = basicSetConstraint(newConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, newConstraint, newConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
				return basicSetConstraint(null, msgs);
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
			case MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				if (resolve) return getSupertype();
				return basicGetSupertype();
			case MidPackage.EXTENDIBLE_ELEMENT__METATYPE:
				if (resolve) return getMetatype();
				return basicGetMetatype();
			case MidPackage.EXTENDIBLE_ELEMENT__URI:
				return getUri();
			case MidPackage.EXTENDIBLE_ELEMENT__NAME:
				return getName();
			case MidPackage.EXTENDIBLE_ELEMENT__LEVEL:
				return getLevel();
			case MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				return getMetatypeUri();
			case MidPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				return isDynamic();
			case MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
				return getConstraint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				setSupertype((ExtendibleElement)newValue);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__URI:
				setUri((String)newValue);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__LEVEL:
				setLevel((MidLevel)newValue);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				setMetatypeUri((String)newValue);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				setDynamic((Boolean)newValue);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
				setConstraint((ExtendibleElementConstraint)newValue);
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
			case MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				setSupertype((ExtendibleElement)null);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__URI:
				setUri(URI_EDEFAULT);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				setMetatypeUri(METATYPE_URI_EDEFAULT);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				setDynamic(DYNAMIC_EDEFAULT);
				return;
			case MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
				setConstraint((ExtendibleElementConstraint)null);
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
			case MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				return supertype != null;
			case MidPackage.EXTENDIBLE_ELEMENT__METATYPE:
				return basicGetMetatype() != null;
			case MidPackage.EXTENDIBLE_ELEMENT__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case MidPackage.EXTENDIBLE_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MidPackage.EXTENDIBLE_ELEMENT__LEVEL:
				return level != LEVEL_EDEFAULT;
			case MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				return METATYPE_URI_EDEFAULT == null ? metatypeUri != null : !METATYPE_URI_EDEFAULT.equals(metatypeUri);
			case MidPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				return dynamic != DYNAMIC_EDEFAULT;
			case MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
				return constraint != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (uri: ");
		result.append(uri);
		result.append(", name: ");
		result.append(name);
		result.append(", level: ");
		result.append(level);
		result.append(", metatypeUri: ");
		result.append(metatypeUri);
		result.append(", dynamic: ");
		result.append(dynamic);
		result.append(')');
		return result.toString();
	}

	/**
	 * Gets the base uri of a type by cutting its last fragment.
	 * 
	 * @param type
	 *            The type.
	 * @return The base uri of the type.
	 * @generated NOT
	 */
	private String getTypeBaseUri(ExtendibleElement type) {

		String baseUri = type.getUri();
		int cut = baseUri.lastIndexOf(MMTF.URI_SEPARATOR);
		if (cut == -1) {
			cut = type.getUri().length();
		}
		baseUri = type.getUri().substring(0, cut);

		return baseUri;
	}

	/**
	 * Creates a uri for a new subtype (the base uri + the possible uri fragment
	 * + the name of the new type).
	 * 
	 * @param baseType
	 *            The base type from which the uri of the new type will be
	 *            constructed.
	 * @param newTypeFragmentUri
	 *            The uri fragment to be appended as part of the uri of the new
	 *            type, can be null.
	 * @param newTypeName
	 *            The name of the new type.
	 * @return The uri of the new type.
	 * @generated NOT
	 */
	private String createNewSubtypeUri(ExtendibleElement baseType, String newTypeFragmentUri, String newTypeName) {

		String baseUri = getTypeBaseUri(baseType);
		String newTypeUri = (newTypeFragmentUri == null) ?
			baseUri + MMTF.URI_SEPARATOR + newTypeName :
			baseUri + MMTF.URI_SEPARATOR + newTypeFragmentUri + MMTF.URI_SEPARATOR + newTypeName;

		return newTypeUri;
	}

	/**
	 * Adds a subtype of this type to the Type MID.
	 * 
	 * @param newType
	 *            The new type to be added.
	 * @param baseType
	 *            The base type from which the uri of the new type will be
	 *            constructed.
	 * @param newTypeFragmentUri
	 *            The uri fragment to be appended as part of the uri of the new
	 *            type, can be null.
	 * @param newTypeName
	 *            The name of the new type.
	 * @throws MMTFException
	 *             If the uri of the new type is already registered in the Type
	 *             MID.
	 * @generated NOT
	 */
	protected void addSubtype(ExtendibleElement newType, ExtendibleElement baseType, String newTypeFragmentUri, String newTypeName) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		String newTypeUri = createNewSubtypeUri(baseType, newTypeFragmentUri, newTypeName);
		MultiModelTypeFactory.addType(newType, this, newTypeUri, newTypeName, multiModel);
		newType.setDynamic(true);
	}

	/**
	 * Deletes an extendible element from a multimodel.
	 * 
	 * @param uri
	 *            The uri of the extendible element to delete.
	 * @param multiModel
	 *            The multimodel that contains the extendible element.
	 * @return The deleted extendible element, null if its uri was not
	 *         registered in the multimodel.
	 */
	protected ExtendibleElement delete(String uri, MultiModel multiModel) {

		return multiModel.getExtendibleTable().removeKey(getUri());
	}

	/**
	 * Deletes this type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel that contains the type.
	 * @return The deleted type, null if its uri was not registered in the
	 *         multimodel.
	 * @generated NOT
	 */
	protected ExtendibleElement deleteType(MultiModel multiModel) {

		//TODO MMTF[OO] obtain multimodel and remove it from arguments
		return delete(getUri(), multiModel);
	}

	/**
	 * Adds an instance of this type to an Instance MID without registering its
	 * uri.
	 * 
	 * @param newInstance
	 *            The new instance to be added.
	 * @param newInstanceUri
	 *            The uri of the new instance.
	 * @param newInstanceName
	 *            The name of the new instance.
	 * @generated NOT
	 */
	protected void addBasicInstance(ExtendibleElement newInstance, String newInstanceUri, String newInstanceName) {

		if (newInstanceUri == null) {
			newInstanceUri = MultiModelInstanceFactory.EMPTY_URI;
		}
		newInstance.setUri(newInstanceUri);
		if (newInstanceName == null) {
			newInstanceName = MultiModelInstanceFactory.EMPTY_NAME;
		}
		newInstance.setName(newInstanceName);
		newInstance.setLevel(MidLevel.INSTANCES);
		newInstance.setDynamic(true);
		newInstance.setSupertype(null);
		newInstance.setMetatypeUri(getUri());
	}

	/**
	 * Adds an instance of this type to an Instance MID.
	 * 
	 * @param newInstance
	 *            The new instance to be added.
	 * @param newInstanceUri
	 *            The uri of the new instance.
	 * @param newInstanceName
	 *            The name of the new instance.
	 * @param multiModel
	 *            An Instance MID.
	 * @throws MMTFException
	 *             If the uri of the new instance is already registered in the
	 *             Instance MID.
	 * @generated NOT
	 */
	protected void addInstance(ExtendibleElement newInstance, String newInstanceUri, String newInstanceName, MultiModel multiModel) throws MMTFException {

		if (multiModel.getExtendibleTable().containsKey(newInstanceUri)) {
			throw new MMTFException("Instance with uri " + newInstanceUri + " is already registered");
		}
		multiModel.getExtendibleTable().put(newInstanceUri, newInstance);

		addBasicInstance(newInstance, newInstanceUri, newInstanceName);
	}

	/**
	 * Deletes this instance from the Instance MID that contains it.
	 * 
	 * @param multiModel
	 *            The Instance MID that contains the instance.
	 * @return The deleted instance, null if the uri was not registered in the
	 *         Instance MID.
	 * @generated NOT
	 */
	protected ExtendibleElement deleteInstance(MultiModel multiModel) {

		//TODO MMTF[OO] obtain multimodel and remove it from arguments
		return delete(getUri(), multiModel);
	}

} //ExtendibleElementImpl
