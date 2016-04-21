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
package edu.toronto.cs.se.modelepedia.istar.impl;

import edu.toronto.cs.se.modelepedia.istar.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar.DependerLink;
import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.Intention;
import edu.toronto.cs.se.modelepedia.istar.IntentionLink;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intention</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#isFullySatisfied <em>Fully Satisfied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#isPartiallySatisfied <em>Partially Satisfied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#isUnknown <em>Unknown</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#isConflict <em>Conflict</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#isPartiallyDenied <em>Partially Denied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#isFullyDenied <em>Fully Denied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#isNoLabel <em>No Label</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#getLinksAsSrc <em>Links As Src</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#getLinksAsTgt <em>Links As Tgt</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#getDependerLinks <em>Depender Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionImpl#getDependeeLinks <em>Dependee Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IntentionImpl extends DependencyEndpointImpl implements Intention {
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
	 * The default value of the '{@link #isNoLabel() <em>No Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoLabel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_LABEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoLabel() <em>No Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoLabel()
	 * @generated
	 * @ordered
	 */
	protected boolean noLabel = NO_LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinksAsSrc() <em>Links As Src</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinksAsSrc()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentionLink> linksAsSrc;

	/**
	 * The cached value of the '{@link #getLinksAsTgt() <em>Links As Tgt</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinksAsTgt()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentionLink> linksAsTgt;

	/**
	 * The cached value of the '{@link #getDependerLinks() <em>Depender Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependerLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<DependerLink> dependerLinks;

	/**
	 * The cached value of the '{@link #getDependeeLinks() <em>Dependee Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependeeLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<DependeeLink> dependeeLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntentionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStarPackage.Literals.INTENTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTION__FULLY_SATISFIED, oldFullySatisfied, fullySatisfied));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTION__PARTIALLY_SATISFIED, oldPartiallySatisfied, partiallySatisfied));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTION__UNKNOWN, oldUnknown, unknown));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTION__CONFLICT, oldConflict, conflict));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTION__PARTIALLY_DENIED, oldPartiallyDenied, partiallyDenied));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTION__FULLY_DENIED, oldFullyDenied, fullyDenied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoLabel() {
		return noLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoLabel(boolean newNoLabel) {
		boolean oldNoLabel = noLabel;
		noLabel = newNoLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.INTENTION__NO_LABEL, oldNoLabel, noLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntentionLink> getLinksAsSrc() {
		if (linksAsSrc == null) {
			linksAsSrc = new EObjectContainmentWithInverseEList<IntentionLink>(IntentionLink.class, this, IStarPackage.INTENTION__LINKS_AS_SRC, IStarPackage.INTENTION_LINK__SRC);
		}
		return linksAsSrc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntentionLink> getLinksAsTgt() {
		if (linksAsTgt == null) {
			linksAsTgt = new EObjectWithInverseResolvingEList<IntentionLink>(IntentionLink.class, this, IStarPackage.INTENTION__LINKS_AS_TGT, IStarPackage.INTENTION_LINK__TGT);
		}
		return linksAsTgt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependerLink> getDependerLinks() {
		if (dependerLinks == null) {
			dependerLinks = new EObjectContainmentWithInverseEList<DependerLink>(DependerLink.class, this, IStarPackage.INTENTION__DEPENDER_LINKS, IStarPackage.DEPENDER_LINK__DEPENDUM);
		}
		return dependerLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependeeLink> getDependeeLinks() {
		if (dependeeLinks == null) {
			dependeeLinks = new EObjectContainmentWithInverseEList<DependeeLink>(DependeeLink.class, this, IStarPackage.INTENTION__DEPENDEE_LINKS, IStarPackage.DEPENDEE_LINK__DEPENDUM);
		}
		return dependeeLinks;
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
			case IStarPackage.INTENTION__LINKS_AS_SRC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinksAsSrc()).basicAdd(otherEnd, msgs);
			case IStarPackage.INTENTION__LINKS_AS_TGT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinksAsTgt()).basicAdd(otherEnd, msgs);
			case IStarPackage.INTENTION__DEPENDER_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependerLinks()).basicAdd(otherEnd, msgs);
			case IStarPackage.INTENTION__DEPENDEE_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependeeLinks()).basicAdd(otherEnd, msgs);
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
			case IStarPackage.INTENTION__LINKS_AS_SRC:
				return ((InternalEList<?>)getLinksAsSrc()).basicRemove(otherEnd, msgs);
			case IStarPackage.INTENTION__LINKS_AS_TGT:
				return ((InternalEList<?>)getLinksAsTgt()).basicRemove(otherEnd, msgs);
			case IStarPackage.INTENTION__DEPENDER_LINKS:
				return ((InternalEList<?>)getDependerLinks()).basicRemove(otherEnd, msgs);
			case IStarPackage.INTENTION__DEPENDEE_LINKS:
				return ((InternalEList<?>)getDependeeLinks()).basicRemove(otherEnd, msgs);
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
			case IStarPackage.INTENTION__FULLY_SATISFIED:
				return isFullySatisfied();
			case IStarPackage.INTENTION__PARTIALLY_SATISFIED:
				return isPartiallySatisfied();
			case IStarPackage.INTENTION__UNKNOWN:
				return isUnknown();
			case IStarPackage.INTENTION__CONFLICT:
				return isConflict();
			case IStarPackage.INTENTION__PARTIALLY_DENIED:
				return isPartiallyDenied();
			case IStarPackage.INTENTION__FULLY_DENIED:
				return isFullyDenied();
			case IStarPackage.INTENTION__NO_LABEL:
				return isNoLabel();
			case IStarPackage.INTENTION__LINKS_AS_SRC:
				return getLinksAsSrc();
			case IStarPackage.INTENTION__LINKS_AS_TGT:
				return getLinksAsTgt();
			case IStarPackage.INTENTION__DEPENDER_LINKS:
				return getDependerLinks();
			case IStarPackage.INTENTION__DEPENDEE_LINKS:
				return getDependeeLinks();
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
			case IStarPackage.INTENTION__FULLY_SATISFIED:
				setFullySatisfied((Boolean)newValue);
				return;
			case IStarPackage.INTENTION__PARTIALLY_SATISFIED:
				setPartiallySatisfied((Boolean)newValue);
				return;
			case IStarPackage.INTENTION__UNKNOWN:
				setUnknown((Boolean)newValue);
				return;
			case IStarPackage.INTENTION__CONFLICT:
				setConflict((Boolean)newValue);
				return;
			case IStarPackage.INTENTION__PARTIALLY_DENIED:
				setPartiallyDenied((Boolean)newValue);
				return;
			case IStarPackage.INTENTION__FULLY_DENIED:
				setFullyDenied((Boolean)newValue);
				return;
			case IStarPackage.INTENTION__NO_LABEL:
				setNoLabel((Boolean)newValue);
				return;
			case IStarPackage.INTENTION__LINKS_AS_SRC:
				getLinksAsSrc().clear();
				getLinksAsSrc().addAll((Collection<? extends IntentionLink>)newValue);
				return;
			case IStarPackage.INTENTION__LINKS_AS_TGT:
				getLinksAsTgt().clear();
				getLinksAsTgt().addAll((Collection<? extends IntentionLink>)newValue);
				return;
			case IStarPackage.INTENTION__DEPENDER_LINKS:
				getDependerLinks().clear();
				getDependerLinks().addAll((Collection<? extends DependerLink>)newValue);
				return;
			case IStarPackage.INTENTION__DEPENDEE_LINKS:
				getDependeeLinks().clear();
				getDependeeLinks().addAll((Collection<? extends DependeeLink>)newValue);
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
			case IStarPackage.INTENTION__FULLY_SATISFIED:
				setFullySatisfied(FULLY_SATISFIED_EDEFAULT);
				return;
			case IStarPackage.INTENTION__PARTIALLY_SATISFIED:
				setPartiallySatisfied(PARTIALLY_SATISFIED_EDEFAULT);
				return;
			case IStarPackage.INTENTION__UNKNOWN:
				setUnknown(UNKNOWN_EDEFAULT);
				return;
			case IStarPackage.INTENTION__CONFLICT:
				setConflict(CONFLICT_EDEFAULT);
				return;
			case IStarPackage.INTENTION__PARTIALLY_DENIED:
				setPartiallyDenied(PARTIALLY_DENIED_EDEFAULT);
				return;
			case IStarPackage.INTENTION__FULLY_DENIED:
				setFullyDenied(FULLY_DENIED_EDEFAULT);
				return;
			case IStarPackage.INTENTION__NO_LABEL:
				setNoLabel(NO_LABEL_EDEFAULT);
				return;
			case IStarPackage.INTENTION__LINKS_AS_SRC:
				getLinksAsSrc().clear();
				return;
			case IStarPackage.INTENTION__LINKS_AS_TGT:
				getLinksAsTgt().clear();
				return;
			case IStarPackage.INTENTION__DEPENDER_LINKS:
				getDependerLinks().clear();
				return;
			case IStarPackage.INTENTION__DEPENDEE_LINKS:
				getDependeeLinks().clear();
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
			case IStarPackage.INTENTION__FULLY_SATISFIED:
				return fullySatisfied != FULLY_SATISFIED_EDEFAULT;
			case IStarPackage.INTENTION__PARTIALLY_SATISFIED:
				return partiallySatisfied != PARTIALLY_SATISFIED_EDEFAULT;
			case IStarPackage.INTENTION__UNKNOWN:
				return unknown != UNKNOWN_EDEFAULT;
			case IStarPackage.INTENTION__CONFLICT:
				return conflict != CONFLICT_EDEFAULT;
			case IStarPackage.INTENTION__PARTIALLY_DENIED:
				return partiallyDenied != PARTIALLY_DENIED_EDEFAULT;
			case IStarPackage.INTENTION__FULLY_DENIED:
				return fullyDenied != FULLY_DENIED_EDEFAULT;
			case IStarPackage.INTENTION__NO_LABEL:
				return noLabel != NO_LABEL_EDEFAULT;
			case IStarPackage.INTENTION__LINKS_AS_SRC:
				return linksAsSrc != null && !linksAsSrc.isEmpty();
			case IStarPackage.INTENTION__LINKS_AS_TGT:
				return linksAsTgt != null && !linksAsTgt.isEmpty();
			case IStarPackage.INTENTION__DEPENDER_LINKS:
				return dependerLinks != null && !dependerLinks.isEmpty();
			case IStarPackage.INTENTION__DEPENDEE_LINKS:
				return dependeeLinks != null && !dependeeLinks.isEmpty();
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
		result.append(", noLabel: ");
		result.append(noLabel);
		result.append(')');
		return result.toString();
	}

} //IntentionImpl
