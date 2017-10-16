/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.InContextOf;
import edu.toronto.cs.se.nlsfung.gsn.SupportedBy;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decomposable Core Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.DecomposableCoreElementImpl#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.DecomposableCoreElementImpl#getInContextOf <em>In Context Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DecomposableCoreElementImpl extends CoreElementImpl implements DecomposableCoreElement {
	/**
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<SupportedBy> supportedBy;

	/**
	 * The cached value of the '{@link #getInContextOf() <em>In Context Of</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInContextOf()
	 * @generated
	 * @ordered
	 */
	protected EList<InContextOf> inContextOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecomposableCoreElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GSNPackage.Literals.DECOMPOSABLE_CORE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupportedBy> getSupportedBy() {
		if (supportedBy == null) {
			supportedBy = new EObjectContainmentWithInverseEList<SupportedBy>(SupportedBy.class, this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY, GSNPackage.SUPPORTED_BY__CONCLUSION);
		}
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InContextOf> getInContextOf() {
		if (inContextOf == null) {
			inContextOf = new EObjectContainmentWithInverseEList<InContextOf>(InContextOf.class, this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF);
		}
		return inContextOf;
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
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedBy()).basicAdd(otherEnd, msgs);
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInContextOf()).basicAdd(otherEnd, msgs);
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
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return ((InternalEList<?>)getSupportedBy()).basicRemove(otherEnd, msgs);
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return ((InternalEList<?>)getInContextOf()).basicRemove(otherEnd, msgs);
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
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return getSupportedBy();
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
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
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				getSupportedBy().clear();
				getSupportedBy().addAll((Collection<? extends SupportedBy>)newValue);
				return;
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				getInContextOf().clear();
				getInContextOf().addAll((Collection<? extends InContextOf>)newValue);
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
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				getSupportedBy().clear();
				return;
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
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
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return supportedBy != null && !supportedBy.isEmpty();
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return inContextOf != null && !inContextOf.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DecomposableCoreElementImpl
