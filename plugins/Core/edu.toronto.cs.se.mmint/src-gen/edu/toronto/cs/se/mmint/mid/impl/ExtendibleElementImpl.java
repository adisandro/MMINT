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
package edu.toronto.cs.se.mmint.mid.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.validation.IValidationContext;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extendible Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl#getMetatypeUri <em>Metatype Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ExtendibleElementImpl extends MinimalEObjectImpl.Container implements ExtendibleElement {
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
	protected static final MIDLevel LEVEL_EDEFAULT = MIDLevel.INSTANCES;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected MIDLevel level = LEVEL_EDEFAULT;

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
		return MIDPackage.Literals.EXTENDIBLE_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__URI, oldUri, uri));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE, oldSupertype, supertype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE, oldSupertype, supertype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MIDLevel getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(MIDLevel newLevel) {
		MIDLevel oldLevel = level;
		level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__LEVEL, oldLevel, level));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__METATYPE_URI, oldMetatypeUri, metatypeUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__DYNAMIC, oldDynamic, dynamic));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, oldConstraint, newConstraint);
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
				msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, null, msgs);
			if (newConstraint != null)
				msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, null, msgs);
			msgs = basicSetConstraint(newConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT, newConstraint, newConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
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
			case MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				if (resolve) return getSupertype();
				return basicGetSupertype();
			case MIDPackage.EXTENDIBLE_ELEMENT__URI:
				return getUri();
			case MIDPackage.EXTENDIBLE_ELEMENT__NAME:
				return getName();
			case MIDPackage.EXTENDIBLE_ELEMENT__LEVEL:
				return getLevel();
			case MIDPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				return getMetatypeUri();
			case MIDPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				return isDynamic();
			case MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
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
			case MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				setSupertype((ExtendibleElement)newValue);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__URI:
				setUri((String)newValue);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__LEVEL:
				setLevel((MIDLevel)newValue);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				setMetatypeUri((String)newValue);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				setDynamic((Boolean)newValue);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
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
			case MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				setSupertype((ExtendibleElement)null);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__URI:
				setUri(URI_EDEFAULT);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				setMetatypeUri(METATYPE_URI_EDEFAULT);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				setDynamic(DYNAMIC_EDEFAULT);
				return;
			case MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
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
			case MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE:
				return supertype != null;
			case MIDPackage.EXTENDIBLE_ELEMENT__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case MIDPackage.EXTENDIBLE_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MIDPackage.EXTENDIBLE_ELEMENT__LEVEL:
				return level != LEVEL_EDEFAULT;
			case MIDPackage.EXTENDIBLE_ELEMENT__METATYPE_URI:
				return METATYPE_URI_EDEFAULT == null ? metatypeUri != null : !METATYPE_URI_EDEFAULT.equals(metatypeUri);
			case MIDPackage.EXTENDIBLE_ELEMENT__DYNAMIC:
				return dynamic != DYNAMIC_EDEFAULT;
			case MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT:
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE:
				return getMetatype();
			case MIDPackage.EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING:
				return createSubtypeUri((String)arguments.get(0), (String)arguments.get(1));
			case MIDPackage.EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES:
				try {
					return getRuntimeTypes();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT:
				try {
					return validateInstanceType((ExtendibleElement)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE:
				try {
					return validateInstance();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT:
				try {
					return validateInstanceInEditor((IValidationContext)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toStringGen() {
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
	 * @generated NOT
	 */
	@Override
	public String toString() {

		String label = (getName() == null) ? "" : getName();
		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			ExtendibleElement type = getMetatype();
			String typeLabel = (type == null) ? "NOTYPE" : type.getName();
			label += " : " + typeLabel;
		}

		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement getMetatype() {
		return MultiModelTypeRegistry.getType(getMetatypeUri());
	}

	/**
	 * Gets the base uri of this type by cutting its last fragment.
	 * 
	 * @return The base uri of this type.
	 * @generated NOT
	 */
	private String getTypeBaseUri() {

		String baseUri = getUri();
		int cut = baseUri.lastIndexOf(MMINT.URI_SEPARATOR);
		if (cut == -1) {
			cut = getUri().length();
		}
		baseUri = getUri().substring(0, cut);

		return baseUri;
	}

	/**
	 * @generated NOT
	 */
	public String createSubtypeUri(String newTypeFragmentUri, String newTypeName) {

		String baseUri = getTypeBaseUri();
		String newTypeUri = (newTypeFragmentUri == null) ?
			baseUri + MMINT.URI_SEPARATOR + newTypeName :
			baseUri + MMINT.URI_SEPARATOR + newTypeFragmentUri + MMINT.URI_SEPARATOR + newTypeName;

		return newTypeUri;
	}

	/**
	 * Filters a list of subtypes of a type to contain only direct and metamodel-compatible subtypes.
	 * 
	 * @param type The type at the top of the inheritance tree.
	 * @param subtypes All the subtypes of the type.
	 * @return The list of filtered subtypes.
	 * @generated NOT
	 */
	private <T extends ExtendibleElement> List<T> filterSubtypes(T type, List<T> subtypes) {

		List<T> filteredSubtypes = new ArrayList<T>();

		// only direct subtypes
		for (T subtype : subtypes) {
			if (!subtype.getSupertype().getUri().equals(type.getUri())) {
				continue;
			}
			//TODO MMINT[INTROSPECTION] Fix the following problem in the proper way, maybe in the subtype table directly
			if (!(type instanceof ModelRel) && subtype instanceof ModelRel) { // root model rel is not a subtype of root model here
				continue;
			}
			filteredSubtypes.add(subtype);
		}

		if (type instanceof Model && !(type instanceof ModelRel)) { // explore metamodel-compatible supertrees and subtrees
			List<T> metamodelSubtypes = new ArrayList<T>();
			EPackage rootStaticModelTypeObj;
			try {
				rootStaticModelTypeObj = ((Model) this).getMetatype().getEMFTypeRoot();
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "Can't get model root, skipping subtypes filtering", e);
				return metamodelSubtypes;
			}
			String metamodelUri = rootStaticModelTypeObj.getNsURI();
			for (T filteredSubtype : filteredSubtypes) {
				if (
					metamodelUri.equals(filteredSubtype.getUri()) ||
					MultiModelTypeHierarchy.isSubtypeOf(filteredSubtype.getUri(), metamodelUri) ||
					MultiModelTypeHierarchy.isSubtypeOf(metamodelUri, filteredSubtype.getUri())
				) {
					metamodelSubtypes.add(filteredSubtype);
				}
				else { // try multiple inheritance
					//TODO MMINT[MID] this is too tailored for UML_MAVO
					for (String multipleInheritanceUri : MultiModelTypeHierarchy.getMultipleInheritanceUris(metamodelUri)) {
						if (
							multipleInheritanceUri.equals(filteredSubtype.getUri()) ||
							MultiModelTypeHierarchy.isSubtypeOf(filteredSubtype.getUri(), multipleInheritanceUri) ||
							MultiModelTypeHierarchy.isSubtypeOf(multipleInheritanceUri, filteredSubtype.getUri())
						) {
							metamodelSubtypes.add(filteredSubtype);
						}
					}
				}
			}
			return metamodelSubtypes;
		}

		return filteredSubtypes;
	}

	/**
	 * Adds a polymorphic runtime type for this instance.
	 * 
	 * @param type The type being checked to be a valid polymorphic type.
	 * @param types The list of polymorphic runtime types so far, used as return value.
	 * @generated NOT
	 */
	private <T extends ExtendibleElement> void getRuntimeTypes(T type, List<T> types) {

		// no need to validate root type
		if (MultiModelTypeHierarchy.isRootType(type)) {
			types.add(type);
			// first stop condition: model relationship or mapping, without endpoints
			if (this instanceof ModelRel && ((ModelRel) this).getModelEndpoints().isEmpty()) {
				return;
			}
			if (this instanceof Mapping && ((Mapping) this).getModelElemEndpoints().isEmpty()) {
				return;
			}
			// second stop condition: endpoints
			//TODO MMINT[OVERRIDE] needs container type + to be refined with override semantics
			if (this instanceof ModelEndpoint || this instanceof ModelElementEndpoint) {
				return;
			}
		}
		else {
			// third stop condition: validation
			try {
				if (!this.validateInstanceType(type)) {
					return;
				}
			}
			catch (MMINTException e) {
				return;
			}
			types.add(type);
		}

		// recurse for each subtype
		List<T> subtypes = this.filterSubtypes(type, MultiModelTypeHierarchy.getSubtypes(type));
		for (T subtype : subtypes) {
			this.getRuntimeTypes(subtype, types);
		}
	}

	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public <T extends ExtendibleElement> EList<T> getRuntimeTypes() throws MMINTException {

		MMINTException.mustBeInstance(this);

		List<T> cachedTypes = (List<T>) MultiModelTypeHierarchy.getCachedRuntimeTypes(this);
		if (cachedTypes != null) {
			return new BasicEList<T>(cachedTypes);
		}

		EList<T> types = new BasicEList<>();
		if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_ENABLED))) {
			// start from root
			T rootType = MultiModelTypeRegistry.getType(MultiModelTypeHierarchy.getRootTypeUri(this));
			this.getRuntimeTypes(rootType, types);
		}
		else {
			types.add((T) this.getMetatype());
		}
		MultiModelTypeHierarchy.setCachedRuntimeTypes(this, types);

		return types;
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
	 * @throws MMINTException
	 *             If the uri of the new type is already registered in the Type
	 *             MID.
	 * @generated NOT
	 */
	protected void addSubtype(ExtendibleElement newType, ExtendibleElement baseType, String newTypeFragmentUri, String newTypeName) throws MMINTException {

		String newTypeUri = baseType.createSubtypeUri(newTypeFragmentUri, newTypeName);
		addSubtype(newType, newTypeUri, newTypeName);
	}

	/**
	 * TODO MMINT[MODELELEMENT] unify with the other
	 * @generated NOT
	 */
	protected void addSubtype(ExtendibleElement newType, String newTypeUri, String newTypeName) throws MMINTException {

		MID typeMID = MultiModelRegistry.getMultiModel(this);
		MultiModelTypeFactory.addType(newType, this, newTypeUri, newTypeName, typeMID);
		newType.setDynamic(true);
	}

	/**
	 * Adds a reference to this type to the Type MID.
	 * 
	 * @param newTypeRef
	 *            The new reference being added.
	 * @param typeRef
	 *            The reference to the supertype of this type, null if such
	 *            reference doesn't exist.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced type, false otherwise.
	 * @param isContainer
	 *            True if the new reference is also the actual container of the
	 *            new type and not just a pointer to it, false otherwise.
	 * @generated NOT
	 */
	protected void addTypeReference(ExtendibleElementReference newTypeRef, ExtendibleElementReference typeRef, boolean isModifiable, boolean isContainer) {

		if (isContainer) {
			newTypeRef.setContainedObject(this);
		}
		else {
			newTypeRef.setReferencedObject(this);
		}
		newTypeRef.setModifiable(isModifiable);
		newTypeRef.setSupertypeRef(typeRef);
	}

	/**
	 * Deletes an extendible element from a MID.
	 * 
	 * @param uri
	 *            The uri of the extendible element to delete.
	 * @param mid
	 *            The MID that contains the extendible element.
	 * @return The deleted extendible element, null if its uri was not
	 *         registered in the MID.
	 * @generated NOT
	 */
	protected ExtendibleElement delete(String uri, MID mid) {

		return mid.getExtendibleTable().removeKey(uri);
	}

	/**
	 * Deletes this type from the Type MID.
	 * 
	 * @throws MMINTException
	 *             Never thrown.
	 * @generated NOT
	 */
	protected void deleteType() throws MMINTException {

		MID typeMID = MultiModelRegistry.getMultiModel(this);
		this.delete(getUri(), typeMID);
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
			newInstanceUri = MMINT.EMPTY_URI;
		}
		newInstance.setUri(newInstanceUri);
		if (newInstanceName == null) {
			newInstanceName = MMINT.EMPTY_NAME;
		}
		newInstance.setName(newInstanceName);
		newInstance.setLevel(MIDLevel.INSTANCES);
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
	 * @param instanceMID
	 *            An Instance MID.
	 * @throws MMINTException
	 *             If the uri of the new instance is already registered in the
	 *             Instance MID.
	 * @generated NOT
	 */
	protected void addInstance(ExtendibleElement newInstance, String newInstanceUri, String newInstanceName, MID instanceMID) throws MMINTException {

		if (instanceMID.getExtendibleTable().containsKey(newInstanceUri)) {
			throw new MMINTException("An instance with uri " + newInstanceUri + " is already present in this Instance MID");
		}
		instanceMID.getExtendibleTable().put(newInstanceUri, newInstance);

		addBasicInstance(newInstance, newInstanceUri, newInstanceName);
	}

	/**
	 * Adds a reference to this instance to an Instance MID.
	 * 
	 * @param newInstanceRef
	 *            The new reference being added.
	 * @param isContainer
	 *            True if the new reference is also the actual container of the
	 *            new instance and not just a pointer to it, false otherwise.
	 * @generated NOT
	 */
	protected void addInstanceReference(ExtendibleElementReference newInstanceRef, boolean isContainer) {

		if (isContainer) {
			newInstanceRef.setContainedObject(this);
		}
		else {
			newInstanceRef.setReferencedObject(this);
		}
		newInstanceRef.setModifiable(true);
		newInstanceRef.setSupertypeRef(null);
	}

	/**
	 * @generated NOT
	 */
	public boolean validateInstanceType(ExtendibleElement type) throws MMINTException {

		MMINTException.mustBeInstance(this);
		MMINTException.mustBeType(type);

		return true;
	}

	/**
	 * @generated NOT
	 */
	public boolean validateInstance() throws MMINTException {

		return this.validateInstanceType(this.getMetatype());
	}

	/**
	 * @generated NOT
	 */
	public IStatus validateInstanceInEditor(IValidationContext context) throws MMINTException {

		MMINTException.mustBeInstance(this);

		boolean validates = this.validateInstance();
		IStatus status = (validates) ?
			status = context.createSuccessStatus() :
			context.createFailureStatus(
				"",
				this.getName(),
				this.getMetatype().getName());

		return status;
	}

	/**
	 * Deletes this instance from the Instance MID that contains it.
	 * 
	 * @throws MMINTException
	 *             Never thrown.
	 * @generated NOT
	 */
	protected void deleteInstance() throws MMINTException {

		MID instanceMID = MultiModelRegistry.getMultiModel(this);
		delete(getUri(), instanceMID);
	}

} //ExtendibleElementImpl
