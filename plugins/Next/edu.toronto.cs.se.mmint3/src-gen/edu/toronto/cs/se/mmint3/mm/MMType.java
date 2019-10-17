/**
 */
package edu.toronto.cs.se.mmint3.mm;

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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#isDynamic <em>Dynamic</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#isAbstract <em>Abstract</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes <em>Subtypes</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype <em>Supertype</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType()
 * @model kind="class"
 * @generated
 */
public class MMType extends MMElement implements Type {
  /**
   * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #isDynamic()
   * @generated
   * @ordered
   */
  protected static final boolean DYNAMIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #isDynamic()
   * @generated
   * @ordered
   */
  protected boolean dynamic = DYNAMIC_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getSubtypes()
   * @generated
   * @ordered
   */
  protected EList<MMType> subtypes;

  /**
   * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getSupertype()
   * @generated
   * @ordered
   */
  protected MMType supertype;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected MMType() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MM_TYPE;
  }

  /**
   * Returns the value of the '<em><b>Dynamic</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Dynamic</em>' attribute.
   * @see #setDynamic(boolean)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Dynamic()
   * @model required="true"
   * @generated
   */
  @Override
  public boolean isDynamic() {
    return this.dynamic;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMType#isDynamic <em>Dynamic</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Dynamic</em>' attribute.
   * @see #isDynamic()
   * @generated
   */
  @Override
  public void setDynamic(boolean newDynamic) {
    boolean oldDynamic = this.dynamic;
    this.dynamic = newDynamic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__DYNAMIC, oldDynamic, this.dynamic));
  }

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Abstract()
   * @model required="true"
   * @generated
   */
  @Override
  public boolean isAbstract() {
    return this.abstract_;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMType#isAbstract <em>Abstract</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  @Override
  public void setAbstract(boolean newAbstract) {
    boolean oldAbstract = this.abstract_;
    this.abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__ABSTRACT, oldAbstract, this.abstract_));
  }

  /**
   * Returns the value of the '<em><b>Subtypes</b></em>' reference list. The list contents are of type
   * {@link edu.toronto.cs.se.mmint3.mm.MMType}. It is bidirectional and its opposite is
   * '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype <em>Supertype</em>}'. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the value of the '<em>Subtypes</em>' reference list.
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Subtypes()
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSupertype
   * @model opposite="supertype"
   * @generated
   */
  @Override
  public EList<MMType> getSubtypes() {
    if (this.subtypes == null) {
      this.subtypes = new EObjectWithInverseResolvingEList<>(MMType.class, this, MMPackage.MM_TYPE__SUBTYPES,
                                                              MMPackage.MM_TYPE__SUPERTYPE);
    }
    return this.subtypes;
  }

  /**
   * Returns the value of the '<em><b>Supertype</b></em>' reference. It is bidirectional and its opposite is
   * '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes <em>Subtypes</em>}'. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the value of the '<em>Supertype</em>' reference.
   * @see #setSupertype(MMType)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Supertype()
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes
   * @model opposite="subtypes"
   * @generated
   */
  @Override
  public MMType getSupertype() {
    if (this.supertype != null && this.supertype.eIsProxy()) {
      InternalEObject oldSupertype = this.supertype;
      this.supertype = (MMType) eResolveProxy(oldSupertype);
      if (this.supertype != oldSupertype) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MMPackage.MM_TYPE__SUPERTYPE, oldSupertype,
                                        this.supertype));
      }
    }
    return this.supertype;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public MMType basicGetSupertype() {
    return this.supertype;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetSupertype(MMType newSupertype, NotificationChain msgs) {
    MMType oldSupertype = this.supertype;
    this.supertype = newSupertype;
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
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype <em>Supertype</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Supertype</em>' reference.
   * @see #getSupertype()
   * @generated
   */
  @Override
  public void setSupertype(MMType newSupertype) {
    if (newSupertype != this.supertype) {
      NotificationChain msgs = null;
      if (this.supertype != null)
        msgs = this.supertype.eInverseRemove(this, MMPackage.MM_TYPE__SUBTYPES, MMType.class, msgs);
      if (newSupertype != null)
        msgs = newSupertype.eInverseAdd(this, MMPackage.MM_TYPE__SUBTYPES, MMType.class, msgs);
      msgs = basicSetSupertype(newSupertype, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__SUPERTYPE, newSupertype, newSupertype));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MM_TYPE__SUBTYPES:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubtypes()).basicAdd(otherEnd, msgs);
    case MMPackage.MM_TYPE__SUPERTYPE:
      if (this.supertype != null)
        msgs = this.supertype.eInverseRemove(this, MMPackage.MM_TYPE__SUBTYPES, MMType.class, msgs);
      return basicSetSupertype((MMType) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MM_TYPE__SUBTYPES:
      return ((InternalEList<?>) getSubtypes()).basicRemove(otherEnd, msgs);
    case MMPackage.MM_TYPE__SUPERTYPE:
      return basicSetSupertype(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MMPackage.MM_TYPE__DYNAMIC:
      return isDynamic();
    case MMPackage.MM_TYPE__ABSTRACT:
      return isAbstract();
    case MMPackage.MM_TYPE__SUBTYPES:
      return getSubtypes();
    case MMPackage.MM_TYPE__SUPERTYPE:
      if (resolve)
        return getSupertype();
      return basicGetSupertype();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MMPackage.MM_TYPE__DYNAMIC:
      setDynamic((Boolean) newValue);
      return;
    case MMPackage.MM_TYPE__ABSTRACT:
      setAbstract((Boolean) newValue);
      return;
    case MMPackage.MM_TYPE__SUBTYPES:
      getSubtypes().clear();
      getSubtypes().addAll((Collection<? extends MMType>) newValue);
      return;
    case MMPackage.MM_TYPE__SUPERTYPE:
      setSupertype((MMType) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case MMPackage.MM_TYPE__DYNAMIC:
      setDynamic(DYNAMIC_EDEFAULT);
      return;
    case MMPackage.MM_TYPE__ABSTRACT:
      setAbstract(ABSTRACT_EDEFAULT);
      return;
    case MMPackage.MM_TYPE__SUBTYPES:
      getSubtypes().clear();
      return;
    case MMPackage.MM_TYPE__SUPERTYPE:
      setSupertype((MMType) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MMPackage.MM_TYPE__DYNAMIC:
      return this.dynamic != DYNAMIC_EDEFAULT;
    case MMPackage.MM_TYPE__ABSTRACT:
      return this.abstract_ != ABSTRACT_EDEFAULT;
    case MMPackage.MM_TYPE__SUBTYPES:
      return this.subtypes != null && !this.subtypes.isEmpty();
    case MMPackage.MM_TYPE__SUPERTYPE:
      return this.supertype != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (dynamic: ");
    result.append(this.dynamic);
    result.append(", abstract: ");
    result.append(this.abstract_);
    result.append(')');
    return result.toString();
  }

} // MMType
