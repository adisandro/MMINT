/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.InContextOf;
import edu.toronto.cs.se.nlsfung.gsn.SupportedBy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected SupportedBy supportedBy;

	/**
	 * The cached value of the '{@link #getInContextOf() <em>In Context Of</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInContextOf()
	 * @generated
	 * @ordered
	 */
	protected InContextOf inContextOf;

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
	public SupportedBy getSupportedBy() {
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSupportedBy(SupportedBy newSupportedBy, NotificationChain msgs) {
		SupportedBy oldSupportedBy = supportedBy;
		supportedBy = newSupportedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY, oldSupportedBy, newSupportedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedBy(SupportedBy newSupportedBy) {
		if (newSupportedBy != supportedBy) {
			NotificationChain msgs = null;
			if (supportedBy != null)
				msgs = ((InternalEObject)supportedBy).eInverseRemove(this, GSNPackage.SUPPORTED_BY__CONCLUSION, SupportedBy.class, msgs);
			if (newSupportedBy != null)
				msgs = ((InternalEObject)newSupportedBy).eInverseAdd(this, GSNPackage.SUPPORTED_BY__CONCLUSION, SupportedBy.class, msgs);
			msgs = basicSetSupportedBy(newSupportedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY, newSupportedBy, newSupportedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InContextOf getInContextOf() {
		return inContextOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInContextOf(InContextOf newInContextOf, NotificationChain msgs) {
		InContextOf oldInContextOf = inContextOf;
		inContextOf = newInContextOf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, oldInContextOf, newInContextOf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInContextOf(InContextOf newInContextOf) {
		if (newInContextOf != inContextOf) {
			NotificationChain msgs = null;
			if (inContextOf != null)
				msgs = ((InternalEObject)inContextOf).eInverseRemove(this, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF, InContextOf.class, msgs);
			if (newInContextOf != null)
				msgs = ((InternalEObject)newInContextOf).eInverseAdd(this, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF, InContextOf.class, msgs);
			msgs = basicSetInContextOf(newInContextOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, newInContextOf, newInContextOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				if (supportedBy != null)
					msgs = ((InternalEObject)supportedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY, null, msgs);
				return basicSetSupportedBy((SupportedBy)otherEnd, msgs);
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				if (inContextOf != null)
					msgs = ((InternalEObject)inContextOf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, null, msgs);
				return basicSetInContextOf((InContextOf)otherEnd, msgs);
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
				return basicSetSupportedBy(null, msgs);
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return basicSetInContextOf(null, msgs);
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				setSupportedBy((SupportedBy)newValue);
				return;
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				setInContextOf((InContextOf)newValue);
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
				setSupportedBy((SupportedBy)null);
				return;
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				setInContextOf((InContextOf)null);
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
				return supportedBy != null;
			case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return inContextOf != null;
		}
		return super.eIsSet(featureID);
	}

} //DecomposableCoreElementImpl
