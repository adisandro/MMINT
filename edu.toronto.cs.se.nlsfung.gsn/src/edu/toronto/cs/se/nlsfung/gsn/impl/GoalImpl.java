/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.Context;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.GoalSupporter;
import edu.toronto.cs.se.nlsfung.gsn.Strategy;
import edu.toronto.cs.se.nlsfung.gsn.TruthState;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl#getInContextOf <em>In Context Of</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl#getSupports <em>Supports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalImpl extends GsnElementImpl implements Goal {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final TruthState STATE_EDEFAULT = TruthState.FALSE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected TruthState state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected GoalSupporter supportedBy;

	/**
	 * The cached value of the '{@link #getInContextOf() <em>In Context Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInContextOf()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> inContextOf;

	/**
	 * The cached value of the '{@link #getSupports() <em>Supports</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupports()
	 * @generated
	 * @ordered
	 */
	protected Strategy supports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GSNPackage.Literals.GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TruthState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(TruthState newState) {
		TruthState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalSupporter getSupportedBy() {
		if (supportedBy != null && supportedBy.eIsProxy()) {
			InternalEObject oldSupportedBy = (InternalEObject)supportedBy;
			supportedBy = (GoalSupporter)eResolveProxy(oldSupportedBy);
			if (supportedBy != oldSupportedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.GOAL__SUPPORTED_BY, oldSupportedBy, supportedBy));
			}
		}
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalSupporter basicGetSupportedBy() {
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedBy(GoalSupporter newSupportedBy) {
		GoalSupporter oldSupportedBy = supportedBy;
		supportedBy = newSupportedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__SUPPORTED_BY, oldSupportedBy, supportedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getInContextOf() {
		if (inContextOf == null) {
			inContextOf = new EObjectResolvingEList<Context>(Context.class, this, GSNPackage.GOAL__IN_CONTEXT_OF);
		}
		return inContextOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy getSupports() {
		if (supports != null && supports.eIsProxy()) {
			InternalEObject oldSupports = (InternalEObject)supports;
			supports = (Strategy)eResolveProxy(oldSupports);
			if (supports != oldSupports) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.GOAL__SUPPORTS, oldSupports, supports));
			}
		}
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy basicGetSupports() {
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupports(Strategy newSupports) {
		Strategy oldSupports = supports;
		supports = newSupports;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__SUPPORTS, oldSupports, supports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GSNPackage.GOAL__STATE:
				return getState();
			case GSNPackage.GOAL__SUPPORTED_BY:
				if (resolve) return getSupportedBy();
				return basicGetSupportedBy();
			case GSNPackage.GOAL__IN_CONTEXT_OF:
				return getInContextOf();
			case GSNPackage.GOAL__SUPPORTS:
				if (resolve) return getSupports();
				return basicGetSupports();
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
			case GSNPackage.GOAL__STATE:
				setState((TruthState)newValue);
				return;
			case GSNPackage.GOAL__SUPPORTED_BY:
				setSupportedBy((GoalSupporter)newValue);
				return;
			case GSNPackage.GOAL__IN_CONTEXT_OF:
				getInContextOf().clear();
				getInContextOf().addAll((Collection<? extends Context>)newValue);
				return;
			case GSNPackage.GOAL__SUPPORTS:
				setSupports((Strategy)newValue);
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
			case GSNPackage.GOAL__STATE:
				setState(STATE_EDEFAULT);
				return;
			case GSNPackage.GOAL__SUPPORTED_BY:
				setSupportedBy((GoalSupporter)null);
				return;
			case GSNPackage.GOAL__IN_CONTEXT_OF:
				getInContextOf().clear();
				return;
			case GSNPackage.GOAL__SUPPORTS:
				setSupports((Strategy)null);
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
			case GSNPackage.GOAL__STATE:
				return state != STATE_EDEFAULT;
			case GSNPackage.GOAL__SUPPORTED_BY:
				return supportedBy != null;
			case GSNPackage.GOAL__IN_CONTEXT_OF:
				return inContextOf != null && !inContextOf.isEmpty();
			case GSNPackage.GOAL__SUPPORTS:
				return supports != null;
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
		result.append(" (state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} //GoalImpl
