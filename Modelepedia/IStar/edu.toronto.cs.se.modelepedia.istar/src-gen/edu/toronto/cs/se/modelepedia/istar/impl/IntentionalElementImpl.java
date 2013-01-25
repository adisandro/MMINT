/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.impl;

import edu.toronto.cs.se.modelepedia.istar.Contribution;
import edu.toronto.cs.se.modelepedia.istar.Dependency;
import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.IntentionalElement;
import edu.toronto.cs.se.modelepedia.istar.Task;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intentional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#getContributionsAsContributor <em>Contributions As Contributor</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#isFullySatisfied <em>Fully Satisfied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#isPartiallySatisfied <em>Partially Satisfied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#isUnknown <em>Unknown</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#isConflict <em>Conflict</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#isPartiallyDenied <em>Partially Denied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#isFullyDenied <em>Fully Denied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#isNothing <em>Nothing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IntentionalElementImpl extends DependencyEndpointImpl implements IntentionalElement {
	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

	/**
	 * The cached value of the '{@link #getComposite() <em>Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposite()
	 * @generated
	 * @ordered
	 */
	protected Task composite;

	/**
	 * The cached value of the '{@link #getContributionsAsContributor() <em>Contributions As Contributor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributionsAsContributor()
	 * @generated
	 * @ordered
	 */
	protected EList<Contribution> contributionsAsContributor;

	/**
	 * The default value of the '{@link #isFullySatisfied() <em>Fully Satisfied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullySatisfied()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FULLY_SATISFIED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFullySatisfied() <em>Fully Satisfied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullySatisfied()
	 * @generated
	 * @ordered
	 */
	protected boolean fullySatisfied = FULLY_SATISFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #isPartiallySatisfied() <em>Partially Satisfied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartiallySatisfied()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARTIALLY_SATISFIED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPartiallySatisfied() <em>Partially Satisfied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartiallySatisfied()
	 * @generated
	 * @ordered
	 */
	protected boolean partiallySatisfied = PARTIALLY_SATISFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #isUnknown() <em>Unknown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnknown()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNKNOWN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnknown() <em>Unknown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnknown()
	 * @generated
	 * @ordered
	 */
	protected boolean unknown = UNKNOWN_EDEFAULT;

	/**
	 * The default value of the '{@link #isConflict() <em>Conflict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConflict()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONFLICT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConflict() <em>Conflict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConflict()
	 * @generated
	 * @ordered
	 */
	protected boolean conflict = CONFLICT_EDEFAULT;

	/**
	 * The default value of the '{@link #isPartiallyDenied() <em>Partially Denied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartiallyDenied()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARTIALLY_DENIED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPartiallyDenied() <em>Partially Denied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartiallyDenied()
	 * @generated
	 * @ordered
	 */
	protected boolean partiallyDenied = PARTIALLY_DENIED_EDEFAULT;

	/**
	 * The default value of the '{@link #isFullyDenied() <em>Fully Denied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullyDenied()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FULLY_DENIED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFullyDenied() <em>Fully Denied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullyDenied()
	 * @generated
	 * @ordered
	 */
	protected boolean fullyDenied = FULLY_DENIED_EDEFAULT;

	/**
	 * The default value of the '{@link #isNothing() <em>Nothing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNothing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NOTHING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNothing() <em>Nothing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNothing()
	 * @generated
	 * @ordered
	 */
	protected boolean nothing = NOTHING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntentionalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStarPackage.Literals.INTENTIONAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCIES, IStarPackage.DEPENDENCY__DEPENDUM);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getComposite() {
		if (composite != null && composite.eIsProxy()) {
			InternalEObject oldComposite = (InternalEObject)composite;
			composite = (Task)eResolveProxy(oldComposite);
			if (composite != oldComposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE, oldComposite, composite));
			}
		}
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetComposite() {
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComposite(Task newComposite, NotificationChain msgs) {
		Task oldComposite = composite;
		composite = newComposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE, oldComposite, newComposite);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposite(Task newComposite) {
		if (newComposite != composite) {
			NotificationChain msgs = null;
			if (composite != null)
				msgs = ((InternalEObject)composite).eInverseRemove(this, IStarPackage.TASK__COMPONENTS, Task.class, msgs);
			if (newComposite != null)
				msgs = ((InternalEObject)newComposite).eInverseAdd(this, IStarPackage.TASK__COMPONENTS, Task.class, msgs);
			msgs = basicSetComposite(newComposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE, newComposite, newComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributionsAsContributor() {
		if (contributionsAsContributor == null) {
			contributionsAsContributor = new EObjectWithInverseResolvingEList<Contribution>(Contribution.class, this, IStarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR, IStarPackage.CONTRIBUTION__CONTRIBUTOR);
		}
		return contributionsAsContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFullySatisfied() {
		return fullySatisfied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullySatisfied(boolean newFullySatisfied) {
		boolean oldFullySatisfied = fullySatisfied;
		fullySatisfied = newFullySatisfied;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__FULLY_SATISFIED, oldFullySatisfied, fullySatisfied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartiallySatisfied() {
		return partiallySatisfied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartiallySatisfied(boolean newPartiallySatisfied) {
		boolean oldPartiallySatisfied = partiallySatisfied;
		partiallySatisfied = newPartiallySatisfied;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED, oldPartiallySatisfied, partiallySatisfied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnknown() {
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnknown(boolean newUnknown) {
		boolean oldUnknown = unknown;
		unknown = newUnknown;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__UNKNOWN, oldUnknown, unknown));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConflict() {
		return conflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConflict(boolean newConflict) {
		boolean oldConflict = conflict;
		conflict = newConflict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__CONFLICT, oldConflict, conflict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartiallyDenied() {
		return partiallyDenied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartiallyDenied(boolean newPartiallyDenied) {
		boolean oldPartiallyDenied = partiallyDenied;
		partiallyDenied = newPartiallyDenied;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_DENIED, oldPartiallyDenied, partiallyDenied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFullyDenied() {
		return fullyDenied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullyDenied(boolean newFullyDenied) {
		boolean oldFullyDenied = fullyDenied;
		fullyDenied = newFullyDenied;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__FULLY_DENIED, oldFullyDenied, fullyDenied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNothing() {
		return nothing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNothing(boolean newNothing) {
		boolean oldNothing = nothing;
		nothing = newNothing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTIONAL_ELEMENT__NOTHING, oldNothing, nothing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependencies()).basicAdd(otherEnd, msgs);
			case IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				if (composite != null)
					msgs = ((InternalEObject)composite).eInverseRemove(this, IStarPackage.TASK__COMPONENTS, Task.class, msgs);
				return basicSetComposite((Task)otherEnd, msgs);
			case IStarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContributionsAsContributor()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return basicSetComposite(null, msgs);
			case IStarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return ((InternalEList<?>)getContributionsAsContributor()).basicRemove(otherEnd, msgs);
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
			case IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return getDependencies();
			case IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				if (resolve) return getComposite();
				return basicGetComposite();
			case IStarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return getContributionsAsContributor();
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_SATISFIED:
				return isFullySatisfied();
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED:
				return isPartiallySatisfied();
			case IStarPackage.INTENTIONAL_ELEMENT__UNKNOWN:
				return isUnknown();
			case IStarPackage.INTENTIONAL_ELEMENT__CONFLICT:
				return isConflict();
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_DENIED:
				return isPartiallyDenied();
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_DENIED:
				return isFullyDenied();
			case IStarPackage.INTENTIONAL_ELEMENT__NOTHING:
				return isNothing();
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
			case IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Dependency>)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				setComposite((Task)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				getContributionsAsContributor().clear();
				getContributionsAsContributor().addAll((Collection<? extends Contribution>)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_SATISFIED:
				setFullySatisfied((Boolean)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED:
				setPartiallySatisfied((Boolean)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__UNKNOWN:
				setUnknown((Boolean)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__CONFLICT:
				setConflict((Boolean)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_DENIED:
				setPartiallyDenied((Boolean)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_DENIED:
				setFullyDenied((Boolean)newValue);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__NOTHING:
				setNothing((Boolean)newValue);
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
			case IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				getDependencies().clear();
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				setComposite((Task)null);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				getContributionsAsContributor().clear();
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_SATISFIED:
				setFullySatisfied(FULLY_SATISFIED_EDEFAULT);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED:
				setPartiallySatisfied(PARTIALLY_SATISFIED_EDEFAULT);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__UNKNOWN:
				setUnknown(UNKNOWN_EDEFAULT);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__CONFLICT:
				setConflict(CONFLICT_EDEFAULT);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_DENIED:
				setPartiallyDenied(PARTIALLY_DENIED_EDEFAULT);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_DENIED:
				setFullyDenied(FULLY_DENIED_EDEFAULT);
				return;
			case IStarPackage.INTENTIONAL_ELEMENT__NOTHING:
				setNothing(NOTHING_EDEFAULT);
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
			case IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case IStarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return composite != null;
			case IStarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return contributionsAsContributor != null && !contributionsAsContributor.isEmpty();
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_SATISFIED:
				return fullySatisfied != FULLY_SATISFIED_EDEFAULT;
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED:
				return partiallySatisfied != PARTIALLY_SATISFIED_EDEFAULT;
			case IStarPackage.INTENTIONAL_ELEMENT__UNKNOWN:
				return unknown != UNKNOWN_EDEFAULT;
			case IStarPackage.INTENTIONAL_ELEMENT__CONFLICT:
				return conflict != CONFLICT_EDEFAULT;
			case IStarPackage.INTENTIONAL_ELEMENT__PARTIALLY_DENIED:
				return partiallyDenied != PARTIALLY_DENIED_EDEFAULT;
			case IStarPackage.INTENTIONAL_ELEMENT__FULLY_DENIED:
				return fullyDenied != FULLY_DENIED_EDEFAULT;
			case IStarPackage.INTENTIONAL_ELEMENT__NOTHING:
				return nothing != NOTHING_EDEFAULT;
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
		result.append(" (fullySatisfied: ");
		result.append(fullySatisfied);
		result.append(", partiallySatisfied: ");
		result.append(partiallySatisfied);
		result.append(", unknown: ");
		result.append(unknown);
		result.append(", conflict: ");
		result.append(conflict);
		result.append(", partiallyDenied: ");
		result.append(partiallyDenied);
		result.append(", fullyDenied: ");
		result.append(fullyDenied);
		result.append(", nothing: ");
		result.append(nothing);
		result.append(')');
		return result.toString();
	}

} //IntentionalElementImpl
