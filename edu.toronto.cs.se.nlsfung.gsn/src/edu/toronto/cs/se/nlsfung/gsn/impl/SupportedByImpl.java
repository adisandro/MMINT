/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.CoreElement;
import edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.SupportedBy;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supported By</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl#getConclusion <em>Conclusion</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl#getPremises <em>Premises</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupportedByImpl extends MinimalEObjectImpl.Container implements SupportedBy {
	/**
	 * The cached value of the '{@link #getPremises() <em>Premises</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremises()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreElement> premises;

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
	public EList<CoreElement> getPremises() {
		if (premises == null) {
			premises = new EObjectWithInverseResolvingEList.ManyInverse<CoreElement>(CoreElement.class, this, GSNPackage.SUPPORTED_BY__PREMISES, GSNPackage.CORE_ELEMENT__SUPPORTS);
		}
		return premises;
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
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConclusion((DecomposableCoreElement)otherEnd, msgs);
			case GSNPackage.SUPPORTED_BY__PREMISES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPremises()).basicAdd(otherEnd, msgs);
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
			case GSNPackage.SUPPORTED_BY__PREMISES:
				return ((InternalEList<?>)getPremises()).basicRemove(otherEnd, msgs);
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
			case GSNPackage.SUPPORTED_BY__PREMISES:
				return getPremises();
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
			case GSNPackage.SUPPORTED_BY__CONCLUSION:
				setConclusion((DecomposableCoreElement)newValue);
				return;
			case GSNPackage.SUPPORTED_BY__PREMISES:
				getPremises().clear();
				getPremises().addAll((Collection<? extends CoreElement>)newValue);
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
			case GSNPackage.SUPPORTED_BY__PREMISES:
				getPremises().clear();
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
			case GSNPackage.SUPPORTED_BY__PREMISES:
				return premises != null && !premises.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SupportedByImpl
