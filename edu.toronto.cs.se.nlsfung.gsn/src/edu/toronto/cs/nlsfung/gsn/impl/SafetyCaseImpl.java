/**
 */
package edu.toronto.cs.nlsfung.gsn.impl;

import edu.toronto.cs.nlsfung.gsn.BasicLink;
import edu.toronto.cs.nlsfung.gsn.BasicNode;
import edu.toronto.cs.nlsfung.gsn.GsnPackage;
import edu.toronto.cs.nlsfung.gsn.SafetyCase;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SafetyCaseImpl extends MinimalEObjectImpl.Container implements SafetyCase {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicNode> nodes;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicLink> links;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GsnPackage.Literals.SAFETY_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BasicNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<BasicNode>(BasicNode.class, this, GsnPackage.SAFETY_CASE__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BasicLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<BasicLink>(BasicLink.class, this, GsnPackage.SAFETY_CASE__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GsnPackage.SAFETY_CASE__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GsnPackage.SAFETY_CASE__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case GsnPackage.SAFETY_CASE__NODES:
				return getNodes();
			case GsnPackage.SAFETY_CASE__LINKS:
				return getLinks();
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
			case GsnPackage.SAFETY_CASE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends BasicNode>)newValue);
				return;
			case GsnPackage.SAFETY_CASE__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends BasicLink>)newValue);
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
			case GsnPackage.SAFETY_CASE__NODES:
				getNodes().clear();
				return;
			case GsnPackage.SAFETY_CASE__LINKS:
				getLinks().clear();
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
			case GsnPackage.SAFETY_CASE__NODES:
				return nodes != null && !nodes.isEmpty();
			case GsnPackage.SAFETY_CASE__LINKS:
				return links != null && !links.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SafetyCaseImpl
