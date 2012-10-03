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
import edu.toronto.cs.se.modelepedia.istar.IntentionalElement;
import edu.toronto.cs.se.modelepedia.istar.IstarPackage;
import edu.toronto.cs.se.modelepedia.istar.SoftGoal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.ContributionImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.ContributionImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.ContributionImpl#getContributee <em>Contributee</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContributionImpl extends EObjectImpl implements Contribution {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContributor() <em>Contributor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected IntentionalElement contributor;

	/**
	 * The cached value of the '{@link #getContributee() <em>Contributee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributee()
	 * @generated
	 * @ordered
	 */
	protected SoftGoal contributee;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IstarPackage.Literals.CONTRIBUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.CONTRIBUTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionalElement getContributor() {
		if (contributor != null && contributor.eIsProxy()) {
			InternalEObject oldContributor = (InternalEObject)contributor;
			contributor = (IntentionalElement)eResolveProxy(oldContributor);
			if (contributor != oldContributor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IstarPackage.CONTRIBUTION__CONTRIBUTOR, oldContributor, contributor));
			}
		}
		return contributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionalElement basicGetContributor() {
		return contributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContributor(IntentionalElement newContributor, NotificationChain msgs) {
		IntentionalElement oldContributor = contributor;
		contributor = newContributor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IstarPackage.CONTRIBUTION__CONTRIBUTOR, oldContributor, newContributor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributor(IntentionalElement newContributor) {
		if (newContributor != contributor) {
			NotificationChain msgs = null;
			if (contributor != null)
				msgs = ((InternalEObject)contributor).eInverseRemove(this, IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR, IntentionalElement.class, msgs);
			if (newContributor != null)
				msgs = ((InternalEObject)newContributor).eInverseAdd(this, IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR, IntentionalElement.class, msgs);
			msgs = basicSetContributor(newContributor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.CONTRIBUTION__CONTRIBUTOR, newContributor, newContributor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftGoal getContributee() {
		if (contributee != null && contributee.eIsProxy()) {
			InternalEObject oldContributee = (InternalEObject)contributee;
			contributee = (SoftGoal)eResolveProxy(oldContributee);
			if (contributee != oldContributee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IstarPackage.CONTRIBUTION__CONTRIBUTEE, oldContributee, contributee));
			}
		}
		return contributee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftGoal basicGetContributee() {
		return contributee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContributee(SoftGoal newContributee, NotificationChain msgs) {
		SoftGoal oldContributee = contributee;
		contributee = newContributee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IstarPackage.CONTRIBUTION__CONTRIBUTEE, oldContributee, newContributee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributee(SoftGoal newContributee) {
		if (newContributee != contributee) {
			NotificationChain msgs = null;
			if (contributee != null)
				msgs = ((InternalEObject)contributee).eInverseRemove(this, IstarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE, SoftGoal.class, msgs);
			if (newContributee != null)
				msgs = ((InternalEObject)newContributee).eInverseAdd(this, IstarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE, SoftGoal.class, msgs);
			msgs = basicSetContributee(newContributee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.CONTRIBUTION__CONTRIBUTEE, newContributee, newContributee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IstarPackage.CONTRIBUTION__CONTRIBUTOR:
				if (contributor != null)
					msgs = ((InternalEObject)contributor).eInverseRemove(this, IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR, IntentionalElement.class, msgs);
				return basicSetContributor((IntentionalElement)otherEnd, msgs);
			case IstarPackage.CONTRIBUTION__CONTRIBUTEE:
				if (contributee != null)
					msgs = ((InternalEObject)contributee).eInverseRemove(this, IstarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE, SoftGoal.class, msgs);
				return basicSetContributee((SoftGoal)otherEnd, msgs);
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
			case IstarPackage.CONTRIBUTION__CONTRIBUTOR:
				return basicSetContributor(null, msgs);
			case IstarPackage.CONTRIBUTION__CONTRIBUTEE:
				return basicSetContributee(null, msgs);
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
			case IstarPackage.CONTRIBUTION__TYPE:
				return getType();
			case IstarPackage.CONTRIBUTION__CONTRIBUTOR:
				if (resolve) return getContributor();
				return basicGetContributor();
			case IstarPackage.CONTRIBUTION__CONTRIBUTEE:
				if (resolve) return getContributee();
				return basicGetContributee();
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
			case IstarPackage.CONTRIBUTION__TYPE:
				setType((String)newValue);
				return;
			case IstarPackage.CONTRIBUTION__CONTRIBUTOR:
				setContributor((IntentionalElement)newValue);
				return;
			case IstarPackage.CONTRIBUTION__CONTRIBUTEE:
				setContributee((SoftGoal)newValue);
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
			case IstarPackage.CONTRIBUTION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case IstarPackage.CONTRIBUTION__CONTRIBUTOR:
				setContributor((IntentionalElement)null);
				return;
			case IstarPackage.CONTRIBUTION__CONTRIBUTEE:
				setContributee((SoftGoal)null);
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
			case IstarPackage.CONTRIBUTION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case IstarPackage.CONTRIBUTION__CONTRIBUTOR:
				return contributor != null;
			case IstarPackage.CONTRIBUTION__CONTRIBUTEE:
				return contributee != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ContributionImpl
