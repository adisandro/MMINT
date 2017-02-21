/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.BasicLink;
import edu.toronto.cs.se.nlsfung.gsn.BasicNode;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.Recommendation;
import edu.toronto.cs.se.nlsfung.gsn.SafetyCase;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

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
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl#getRootBasicNode <em>Root Basic Node</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl#getRootBasicLink <em>Root Basic Link</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl#getRootCommendation <em>Root Commendation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SafetyCaseImpl extends EObjectImpl implements SafetyCase {
	/**
	 * The cached value of the '{@link #getRootBasicNode() <em>Root Basic Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootBasicNode()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicNode> rootBasicNode;

	/**
	 * The cached value of the '{@link #getRootBasicLink() <em>Root Basic Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootBasicLink()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicLink> rootBasicLink;

	/**
	 * The cached value of the '{@link #getRootCommendation() <em>Root Commendation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootCommendation()
	 * @generated
	 * @ordered
	 */
	protected EList<Recommendation> rootCommendation;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
		return GSNPackage.Literals.SAFETY_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BasicNode> getRootBasicNode() {
		if (rootBasicNode == null) {
			rootBasicNode = new EObjectContainmentEList<BasicNode>(BasicNode.class, this, GSNPackage.SAFETY_CASE__ROOT_BASIC_NODE);
		}
		return rootBasicNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BasicLink> getRootBasicLink() {
		if (rootBasicLink == null) {
			rootBasicLink = new EObjectContainmentEList<BasicLink>(BasicLink.class, this, GSNPackage.SAFETY_CASE__ROOT_BASIC_LINK);
		}
		return rootBasicLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Recommendation> getRootCommendation() {
		if (rootCommendation == null) {
			rootCommendation = new EObjectContainmentEList<Recommendation>(Recommendation.class, this, GSNPackage.SAFETY_CASE__ROOT_COMMENDATION);
		}
		return rootCommendation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SAFETY_CASE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SAFETY_CASE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_NODE:
				return ((InternalEList<?>)getRootBasicNode()).basicRemove(otherEnd, msgs);
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_LINK:
				return ((InternalEList<?>)getRootBasicLink()).basicRemove(otherEnd, msgs);
			case GSNPackage.SAFETY_CASE__ROOT_COMMENDATION:
				return ((InternalEList<?>)getRootCommendation()).basicRemove(otherEnd, msgs);
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
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_NODE:
				return getRootBasicNode();
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_LINK:
				return getRootBasicLink();
			case GSNPackage.SAFETY_CASE__ROOT_COMMENDATION:
				return getRootCommendation();
			case GSNPackage.SAFETY_CASE__DESCRIPTION:
				return getDescription();
			case GSNPackage.SAFETY_CASE__ID:
				return getId();
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
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_NODE:
				getRootBasicNode().clear();
				getRootBasicNode().addAll((Collection<? extends BasicNode>)newValue);
				return;
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_LINK:
				getRootBasicLink().clear();
				getRootBasicLink().addAll((Collection<? extends BasicLink>)newValue);
				return;
			case GSNPackage.SAFETY_CASE__ROOT_COMMENDATION:
				getRootCommendation().clear();
				getRootCommendation().addAll((Collection<? extends Recommendation>)newValue);
				return;
			case GSNPackage.SAFETY_CASE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case GSNPackage.SAFETY_CASE__ID:
				setId((String)newValue);
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
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_NODE:
				getRootBasicNode().clear();
				return;
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_LINK:
				getRootBasicLink().clear();
				return;
			case GSNPackage.SAFETY_CASE__ROOT_COMMENDATION:
				getRootCommendation().clear();
				return;
			case GSNPackage.SAFETY_CASE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case GSNPackage.SAFETY_CASE__ID:
				setId(ID_EDEFAULT);
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
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_NODE:
				return rootBasicNode != null && !rootBasicNode.isEmpty();
			case GSNPackage.SAFETY_CASE__ROOT_BASIC_LINK:
				return rootBasicLink != null && !rootBasicLink.isEmpty();
			case GSNPackage.SAFETY_CASE__ROOT_COMMENDATION:
				return rootCommendation != null && !rootCommendation.isEmpty();
			case GSNPackage.SAFETY_CASE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case GSNPackage.SAFETY_CASE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //SafetyCaseImpl
