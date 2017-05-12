/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.Solution;
import edu.toronto.cs.se.nlsfung.gsn.ValidityState;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl#getSupports <em>Supports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends GsnElementImpl implements Solution {
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
	 * The cached value of the '{@link #getSupports() <em>Supports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupports()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> supports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GSNPackage.Literals.SOLUTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SOLUTION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getSupports() {
		if (supports == null) {
			supports = new EObjectResolvingEList<Goal>(Goal.class, this, GSNPackage.SOLUTION__SUPPORTS);
		}
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GSNPackage.SOLUTION__STATE:
				return getState();
			case GSNPackage.SOLUTION__SUPPORTS:
				return getSupports();
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
			case GSNPackage.SOLUTION__STATE:
				setState((ValidityState)newValue);
				return;
			case GSNPackage.SOLUTION__SUPPORTS:
				getSupports().clear();
				getSupports().addAll((Collection<? extends Goal>)newValue);
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
			case GSNPackage.SOLUTION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case GSNPackage.SOLUTION__SUPPORTS:
				getSupports().clear();
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
			case GSNPackage.SOLUTION__STATE:
				return state != STATE_EDEFAULT;
			case GSNPackage.SOLUTION__SUPPORTS:
				return supports != null && !supports.isEmpty();
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

} //SolutionImpl
