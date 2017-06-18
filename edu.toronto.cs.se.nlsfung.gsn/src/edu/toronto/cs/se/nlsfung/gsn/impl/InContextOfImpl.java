/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.ContextualElement;
import edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.InContextOf;

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
 * An implementation of the model object '<em><b>In Context Of</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.InContextOfImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.InContextOfImpl#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InContextOfImpl extends MinimalEObjectImpl.Container implements InContextOf {
	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<ContextualElement> contexts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InContextOfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GSNPackage.Literals.IN_CONTEXT_OF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContextualElement> getContexts() {
		if (contexts == null) {
			contexts = new EObjectWithInverseResolvingEList.ManyInverse<ContextualElement>(ContextualElement.class, this, GSNPackage.IN_CONTEXT_OF__CONTEXTS, GSNPackage.CONTEXTUAL_ELEMENT__CONTEXT_OF);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecomposableCoreElement getContextOf() {
		if (eContainerFeatureID() != GSNPackage.IN_CONTEXT_OF__CONTEXT_OF) return null;
		return (DecomposableCoreElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextOf(DecomposableCoreElement newContextOf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContextOf, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextOf(DecomposableCoreElement newContextOf) {
		if (newContextOf != eInternalContainer() || (eContainerFeatureID() != GSNPackage.IN_CONTEXT_OF__CONTEXT_OF && newContextOf != null)) {
			if (EcoreUtil.isAncestor(this, newContextOf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContextOf != null)
				msgs = ((InternalEObject)newContextOf).eInverseAdd(this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, DecomposableCoreElement.class, msgs);
			msgs = basicSetContextOf(newContextOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF, newContextOf, newContextOf));
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
			case GSNPackage.IN_CONTEXT_OF__CONTEXTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContexts()).basicAdd(otherEnd, msgs);
			case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContextOf((DecomposableCoreElement)otherEnd, msgs);
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
			case GSNPackage.IN_CONTEXT_OF__CONTEXTS:
				return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
			case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
				return basicSetContextOf(null, msgs);
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
			case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
				return eInternalContainer().eInverseRemove(this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, DecomposableCoreElement.class, msgs);
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
			case GSNPackage.IN_CONTEXT_OF__CONTEXTS:
				return getContexts();
			case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
				return getContextOf();
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
			case GSNPackage.IN_CONTEXT_OF__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends ContextualElement>)newValue);
				return;
			case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
				setContextOf((DecomposableCoreElement)newValue);
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
			case GSNPackage.IN_CONTEXT_OF__CONTEXTS:
				getContexts().clear();
				return;
			case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
				setContextOf((DecomposableCoreElement)null);
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
			case GSNPackage.IN_CONTEXT_OF__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
				return getContextOf() != null;
		}
		return super.eIsSet(featureID);
	}

} //InContextOfImpl
