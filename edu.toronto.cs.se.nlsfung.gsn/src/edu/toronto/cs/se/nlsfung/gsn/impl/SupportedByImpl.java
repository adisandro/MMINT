/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.CoreElement;
import edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.SupportedBy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supported By</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl#getConclusion <em>Conclusion</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl#getPremise <em>Premise</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupportedByImpl extends MinimalEObjectImpl.Container implements SupportedBy {
	/**
	 * The cached value of the '{@link #getPremise() <em>Premise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremise()
	 * @generated
	 * @ordered
	 */
	protected CoreElement premise;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SupportedByImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GSNPackage.Literals.SUPPORTED_BY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecomposableCoreElement getConclusion() {
		if (eContainerFeatureID() != GSNPackage.SUPPORTED_BY__CONCLUSION) return null;
		return (DecomposableCoreElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConclusion(DecomposableCoreElement newConclusion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConclusion, GSNPackage.SUPPORTED_BY__CONCLUSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConclusion(DecomposableCoreElement newConclusion) {
		if (newConclusion != eInternalContainer() || (eContainerFeatureID() != GSNPackage.SUPPORTED_BY__CONCLUSION && newConclusion != null)) {
			if (EcoreUtil.isAncestor(this, newConclusion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConclusion != null)
				msgs = ((InternalEObject)newConclusion).eInverseAdd(this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY, DecomposableCoreElement.class, msgs);
			msgs = basicSetConclusion(newConclusion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTED_BY__CONCLUSION, newConclusion, newConclusion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreElement getPremise() {
		if (premise != null && premise.eIsProxy()) {
			InternalEObject oldPremise = (InternalEObject)premise;
			premise = (CoreElement)eResolveProxy(oldPremise);
			if (premise != oldPremise) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.SUPPORTED_BY__PREMISE, oldPremise, premise));
			}
		}
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreElement basicGetPremise() {
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremise(CoreElement newPremise, NotificationChain msgs) {
		CoreElement oldPremise = premise;
		premise = newPremise;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTED_BY__PREMISE, oldPremise, newPremise);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremise(CoreElement newPremise) {
		if (newPremise != premise) {
			NotificationChain msgs = null;
			if (premise != null)
				msgs = ((InternalEObject)premise).eInverseRemove(this, GSNPackage.CORE_ELEMENT__SUPPORTS, CoreElement.class, msgs);
			if (newPremise != null)
				msgs = ((InternalEObject)newPremise).eInverseAdd(this, GSNPackage.CORE_ELEMENT__SUPPORTS, CoreElement.class, msgs);
			msgs = basicSetPremise(newPremise, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTED_BY__PREMISE, newPremise, newPremise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConclusion((DecomposableCoreElement)otherEnd, msgs);
			case GSNPackage.SUPPORTED_BY__PREMISE:
				if (premise != null)
					msgs = ((InternalEObject)premise).eInverseRemove(this, GSNPackage.CORE_ELEMENT__SUPPORTS, CoreElement.class, msgs);
				return basicSetPremise((CoreElement)otherEnd, msgs);
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
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				return basicSetConclusion(null, msgs);
			case GSNPackage.SUPPORTED_BY__PREMISE:
				return basicSetPremise(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				return eInternalContainer().eInverseRemove(this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY, DecomposableCoreElement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				return getConclusion();
			case GSNPackage.SUPPORTED_BY__PREMISE:
				if (resolve) return getPremise();
				return basicGetPremise();
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
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				setConclusion((DecomposableCoreElement)newValue);
				return;
			case GSNPackage.SUPPORTED_BY__PREMISE:
				setPremise((CoreElement)newValue);
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
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				setConclusion((DecomposableCoreElement)null);
				return;
			case GSNPackage.SUPPORTED_BY__PREMISE:
				setPremise((CoreElement)null);
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
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				return getConclusion() != null;
			case GSNPackage.SUPPORTED_BY__PREMISE:
				return premise != null;
		}
		return super.eIsSet(featureID);
	}

} //SupportedByImpl
