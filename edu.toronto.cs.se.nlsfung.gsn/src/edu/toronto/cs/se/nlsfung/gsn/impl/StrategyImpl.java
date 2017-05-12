/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.Context;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.Strategy;
import edu.toronto.cs.se.nlsfung.gsn.StrategySupporter;
import edu.toronto.cs.se.nlsfung.gsn.ValidityState;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl#getInContextOf <em>In Context Of</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl#getSupports <em>Supports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StrategyImpl extends GsnElementImpl implements Strategy {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ValidityState STATE_EDEFAULT = ValidityState.INVALID;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ValidityState state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<StrategySupporter> supportedBy;

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
	protected Goal supports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GSNPackage.Literals.STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidityState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ValidityState newState) {
		ValidityState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.STRATEGY__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StrategySupporter> getSupportedBy() {
		if (supportedBy == null) {
			supportedBy = new EObjectResolvingEList<StrategySupporter>(StrategySupporter.class, this, GSNPackage.STRATEGY__SUPPORTED_BY);
		}
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getInContextOf() {
		if (inContextOf == null) {
			inContextOf = new EObjectResolvingEList<Context>(Context.class, this, GSNPackage.STRATEGY__IN_CONTEXT_OF);
		}
		return inContextOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal getSupports() {
		if (supports != null && supports.eIsProxy()) {
			InternalEObject oldSupports = (InternalEObject)supports;
			supports = (Goal)eResolveProxy(oldSupports);
			if (supports != oldSupports) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.STRATEGY__SUPPORTS, oldSupports, supports));
			}
		}
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal basicGetSupports() {
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupports(Goal newSupports) {
		Goal oldSupports = supports;
		supports = newSupports;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.STRATEGY__SUPPORTS, oldSupports, supports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GSNPackage.STRATEGY__STATE:
				return getState();
			case GSNPackage.STRATEGY__SUPPORTED_BY:
				return getSupportedBy();
			case GSNPackage.STRATEGY__IN_CONTEXT_OF:
				return getInContextOf();
			case GSNPackage.STRATEGY__SUPPORTS:
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
			case GSNPackage.STRATEGY__STATE:
				setState((ValidityState)newValue);
				return;
			case GSNPackage.STRATEGY__SUPPORTED_BY:
				getSupportedBy().clear();
				getSupportedBy().addAll((Collection<? extends StrategySupporter>)newValue);
				return;
			case GSNPackage.STRATEGY__IN_CONTEXT_OF:
				getInContextOf().clear();
				getInContextOf().addAll((Collection<? extends Context>)newValue);
				return;
			case GSNPackage.STRATEGY__SUPPORTS:
				setSupports((Goal)newValue);
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
			case GSNPackage.STRATEGY__STATE:
				setState(STATE_EDEFAULT);
				return;
			case GSNPackage.STRATEGY__SUPPORTED_BY:
				getSupportedBy().clear();
				return;
			case GSNPackage.STRATEGY__IN_CONTEXT_OF:
				getInContextOf().clear();
				return;
			case GSNPackage.STRATEGY__SUPPORTS:
				setSupports((Goal)null);
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
			case GSNPackage.STRATEGY__STATE:
				return state != STATE_EDEFAULT;
			case GSNPackage.STRATEGY__SUPPORTED_BY:
				return supportedBy != null && !supportedBy.isEmpty();
			case GSNPackage.STRATEGY__IN_CONTEXT_OF:
				return inContextOf != null && !inContextOf.isEmpty();
			case GSNPackage.STRATEGY__SUPPORTS:
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

} //StrategyImpl