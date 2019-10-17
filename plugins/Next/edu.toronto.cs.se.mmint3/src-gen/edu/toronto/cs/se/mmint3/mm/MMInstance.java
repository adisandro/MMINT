/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Instance</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId <em>Type Id</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMInstance()
 * @model kind="class"
 * @generated
 */
public class MMInstance extends MMElement implements Instance {
  /**
   * The default value of the '{@link #getTypeId() <em>Type Id</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getTypeId()
   * @generated
   * @ordered
   */
  protected static final String TYPE_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeId() <em>Type Id</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getTypeId()
   * @generated
   * @ordered
   */
  protected String typeId = TYPE_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected MMInstance() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MM_INSTANCE;
  }

  /**
   * Returns the value of the '<em><b>Type Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type Id</em>' attribute.
   * @see #setTypeId(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMInstance_TypeId()
   * @model required="true"
   * @generated
   */
  @Override
  public String getTypeId() {
    return this.typeId;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId <em>Type Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Type Id</em>' attribute.
   * @see #getTypeId()
   * @generated
   */
  @Override
  public void setTypeId(String newTypeId) {
    String oldTypeId = this.typeId;
    this.typeId = newTypeId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_INSTANCE__TYPE_ID, oldTypeId, this.typeId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MMPackage.MM_INSTANCE__TYPE_ID:
      return getTypeId();
    case MMPackage.MM_INSTANCE__TYPE:
      if (resolve)
        return getType();
      return basicGetType();
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
    case MMPackage.MM_INSTANCE__TYPE_ID:
      setTypeId((String) newValue);
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
    case MMPackage.MM_INSTANCE__TYPE_ID:
      setTypeId(TYPE_ID_EDEFAULT);
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
    case MMPackage.MM_INSTANCE__TYPE_ID:
      return TYPE_ID_EDEFAULT == null ? this.typeId != null : !TYPE_ID_EDEFAULT.equals(this.typeId);
    case MMPackage.MM_INSTANCE__TYPE:
      return basicGetType() != null;
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
    result.append(" (typeId: ");
    result.append(this.typeId);
    result.append(')');
    return result.toString();
  }

} // MMInstance
