/**
 */
package edu.toronto.cs.se.mmint3.mm.impl;

import edu.toronto.cs.se.mmint3.mm.MMPackage;
import edu.toronto.cs.se.mmint3.mm.MMType;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MMTypeImpl extends MMElementImpl implements MMType {
  /**
   * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamic()
   * @generated
   * @ordered
   */
  protected static final boolean DYNAMIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamic()
   * @generated
   * @ordered
   */
  protected boolean dynamic = DYNAMIC_EDEFAULT;

  /**
   * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupertype()
   * @generated
   * @ordered
   */
  protected MMType supertype;

  /**
   * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtypes()
   * @generated
   * @ordered
   */
  protected EList<MMType> subtypes;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MMTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MM_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDynamic() {
    return dynamic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDynamic(boolean newDynamic) {
    boolean oldDynamic = dynamic;
    dynamic = newDynamic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__DYNAMIC, oldDynamic, dynamic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MMType getSupertype() {
    if (supertype != null && supertype.eIsProxy()) {
      InternalEObject oldSupertype = (InternalEObject) supertype;
      supertype = (MMType) eResolveProxy(oldSupertype);
      if (supertype != oldSupertype) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MMPackage.MM_TYPE__SUPERTYPE, oldSupertype,
                                        supertype));
      }
    }
    return supertype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMType basicGetSupertype() {
    return supertype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSupertype(MMType newSupertype, NotificationChain msgs) {
    MMType oldSupertype = supertype;
    supertype = newSupertype;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__SUPERTYPE,
                                                             oldSupertype, newSupertype);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSupertype(MMType newSupertype) {
    if (newSupertype != supertype) {
      NotificationChain msgs = null;
      if (supertype != null)
        msgs = ((InternalEObject) supertype).eInverseRemove(this, MMPackage.MM_TYPE__SUBTYPES, MMType.class, msgs);
      if (newSupertype != null)
        msgs = ((InternalEObject) newSupertype).eInverseAdd(this, MMPackage.MM_TYPE__SUBTYPES, MMType.class, msgs);
      msgs = basicSetSupertype(newSupertype, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__SUPERTYPE, newSupertype, newSupertype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MMType> getSubtypes() {
    if (subtypes == null) {
      subtypes = new EObjectWithInverseResolvingEList<MMType>(MMType.class, this, MMPackage.MM_TYPE__SUBTYPES,
                                                              MMPackage.MM_TYPE__SUPERTYPE);
    }
    return subtypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAbstract() {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAbstract(boolean newAbstract) {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__ABSTRACT, oldAbstract, abstract_));
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
    case MMPackage.MM_TYPE__SUPERTYPE:
      if (supertype != null)
        msgs = ((InternalEObject) supertype).eInverseRemove(this, MMPackage.MM_TYPE__SUBTYPES, MMType.class, msgs);
      return basicSetSupertype((MMType) otherEnd, msgs);
    case MMPackage.MM_TYPE__SUBTYPES:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubtypes()).basicAdd(otherEnd, msgs);
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
    case MMPackage.MM_TYPE__SUPERTYPE:
      return basicSetSupertype(null, msgs);
    case MMPackage.MM_TYPE__SUBTYPES:
      return ((InternalEList<?>) getSubtypes()).basicRemove(otherEnd, msgs);
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
    case MMPackage.MM_TYPE__DYNAMIC:
      return isDynamic();
    case MMPackage.MM_TYPE__SUPERTYPE:
      if (resolve)
        return getSupertype();
      return basicGetSupertype();
    case MMPackage.MM_TYPE__SUBTYPES:
      return getSubtypes();
    case MMPackage.MM_TYPE__ABSTRACT:
      return isAbstract();
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
    case MMPackage.MM_TYPE__DYNAMIC:
      setDynamic((Boolean) newValue);
      return;
    case MMPackage.MM_TYPE__SUPERTYPE:
      setSupertype((MMType) newValue);
      return;
    case MMPackage.MM_TYPE__SUBTYPES:
      getSubtypes().clear();
      getSubtypes().addAll((Collection<? extends MMType>) newValue);
      return;
    case MMPackage.MM_TYPE__ABSTRACT:
      setAbstract((Boolean) newValue);
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
    case MMPackage.MM_TYPE__DYNAMIC:
      setDynamic(DYNAMIC_EDEFAULT);
      return;
    case MMPackage.MM_TYPE__SUPERTYPE:
      setSupertype((MMType) null);
      return;
    case MMPackage.MM_TYPE__SUBTYPES:
      getSubtypes().clear();
      return;
    case MMPackage.MM_TYPE__ABSTRACT:
      setAbstract(ABSTRACT_EDEFAULT);
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
    case MMPackage.MM_TYPE__DYNAMIC:
      return dynamic != DYNAMIC_EDEFAULT;
    case MMPackage.MM_TYPE__SUPERTYPE:
      return supertype != null;
    case MMPackage.MM_TYPE__SUBTYPES:
      return subtypes != null && !subtypes.isEmpty();
    case MMPackage.MM_TYPE__ABSTRACT:
      return abstract_ != ABSTRACT_EDEFAULT;
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
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (dynamic: ");
    result.append(dynamic);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(')');
    return result.toString();
  }

} //MMTypeImpl
