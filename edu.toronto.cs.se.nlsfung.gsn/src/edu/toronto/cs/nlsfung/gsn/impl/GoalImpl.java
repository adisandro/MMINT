/**
 */
package edu.toronto.cs.nlsfung.gsn.impl;

import edu.toronto.cs.nlsfung.gsn.Context;
import edu.toronto.cs.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.nlsfung.gsn.Goal;
import edu.toronto.cs.nlsfung.gsn.GoalSupport;
import edu.toronto.cs.nlsfung.gsn.TruthState;

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
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl#getInContextOf <em>In Context Of</em>}</li>
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
	protected GoalSupport supportedBy;

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
	public GoalSupport getSupportedBy() {
		if (supportedBy != null && supportedBy.eIsProxy()) {
			InternalEObject oldSupportedBy = (InternalEObject)supportedBy;
			supportedBy = (GoalSupport)eResolveProxy(oldSupportedBy);
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
	public GoalSupport basicGetSupportedBy() {
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedBy(GoalSupport newSupportedBy) {
		GoalSupport oldSupportedBy = supportedBy;
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
				setSupportedBy((GoalSupport)newValue);
				return;
			case GSNPackage.GOAL__IN_CONTEXT_OF:
				getInContextOf().clear();
				getInContextOf().addAll((Collection<? extends Context>)newValue);
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
				setSupportedBy((GoalSupport)null);
				return;
			case GSNPackage.GOAL__IN_CONTEXT_OF:
				getInContextOf().clear();
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
