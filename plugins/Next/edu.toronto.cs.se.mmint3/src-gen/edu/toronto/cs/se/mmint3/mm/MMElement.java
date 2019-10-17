/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMElement#getId <em>Id</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class MMElement extends MinimalEObjectImpl.Container implements Element {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected MMElement() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MM_ELEMENT;
  }

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement_Id()
   * @model required="true"
   * @generated
   */
  @Override
  public String getId() {
    return this.id;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getId <em>Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  @Override
  public void setId(String newId) {
    String oldId = this.id;
    this.id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_ELEMENT__ID, oldId, this.id));
  }

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement_Name()
   * @model required="true"
   * @generated
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getName <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  @Override
  public void setName(String newName) {
    String oldName = this.name;
    this.name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_ELEMENT__NAME, oldName, this.name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MMPackage.MM_ELEMENT__ID:
      return getId();
    case MMPackage.MM_ELEMENT__NAME:
      return getName();
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
    case MMPackage.MM_ELEMENT__ID:
      setId((String) newValue);
      return;
    case MMPackage.MM_ELEMENT__NAME:
      setName((String) newValue);
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
    case MMPackage.MM_ELEMENT__ID:
      setId(ID_EDEFAULT);
      return;
    case MMPackage.MM_ELEMENT__NAME:
      setName(NAME_EDEFAULT);
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
    case MMPackage.MM_ELEMENT__ID:
      return ID_EDEFAULT == null ? this.id != null : !ID_EDEFAULT.equals(this.id);
    case MMPackage.MM_ELEMENT__NAME:
      return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
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
    result.append(" (id: ");
    result.append(this.id);
    result.append(", name: ");
    result.append(this.name);
    result.append(')');
    return result.toString();
  }

} // MMElement
