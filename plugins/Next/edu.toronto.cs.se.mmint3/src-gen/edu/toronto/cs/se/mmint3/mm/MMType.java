/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#isDynamic <em>Dynamic</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#isAbstract <em>Abstract</em>}</li>
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
  protected boolean dynamic = MMType.DYNAMIC_EDEFAULT;

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
  protected boolean abstract_ = MMType.ABSTRACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getSupertype()
   * @generated
   * @ordered
   */
  protected Type supertype;

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
   * Returns the value of the '<em><b>Supertype</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Supertype</em>' reference.
   * @see #setSupertype(Type)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Supertype()
   * @model
   * @generated
   */
  @Override
  public Type getSupertype() {
    if (this.supertype != null && this.supertype.eIsProxy()) {
      InternalEObject oldSupertype = (InternalEObject) this.supertype;
      this.supertype = (Type) eResolveProxy(oldSupertype);
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
  public Type basicGetSupertype() {
    return this.supertype;
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
  public void setSupertype(Type newSupertype) {
    Type oldSupertype = this.supertype;
    this.supertype = newSupertype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_TYPE__SUPERTYPE, oldSupertype, this.supertype));
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
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MMPackage.MM_TYPE__DYNAMIC:
      setDynamic((Boolean) newValue);
      return;
    case MMPackage.MM_TYPE__ABSTRACT:
      setAbstract((Boolean) newValue);
      return;
    case MMPackage.MM_TYPE__SUPERTYPE:
      setSupertype((Type) newValue);
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
      setDynamic(MMType.DYNAMIC_EDEFAULT);
      return;
    case MMPackage.MM_TYPE__ABSTRACT:
      setAbstract(MMType.ABSTRACT_EDEFAULT);
      return;
    case MMPackage.MM_TYPE__SUPERTYPE:
      setSupertype((Type) null);
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
      return this.dynamic != MMType.DYNAMIC_EDEFAULT;
    case MMPackage.MM_TYPE__ABSTRACT:
      return this.abstract_ != MMType.ABSTRACT_EDEFAULT;
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
