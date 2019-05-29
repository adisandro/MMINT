/**
 */
package edu.toronto.cs.se.mmint3.mm.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint3.mm.Instance;
import edu.toronto.cs.se.mmint3.mm.MMInstance;
import edu.toronto.cs.se.mmint3.mm.MMPackage;
import edu.toronto.cs.se.mmint3.mm.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.MMInstanceImpl#getTypeId <em>Type Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MMInstanceImpl extends MMElementImpl implements MMInstance {
  /**
   * The default value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeId()
   * @generated
   * @ordered
   */
  protected static final String TYPE_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeId()
   * @generated
   * @ordered
   */
  protected String typeId = TYPE_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MMInstanceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MM_INSTANCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getTypeId() {
    return typeId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTypeId(String newTypeId) {
    String oldTypeId = typeId;
    typeId = newTypeId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MM_INSTANCE__TYPE_ID, oldTypeId, typeId));
  }

  /**
   * @generated NOT
   */
  @Override
  public Type getType() {
    return MIDTypeRegistry.getType(getTypeId());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MMPackage.MM_INSTANCE__TYPE_ID:
      return getTypeId();
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
    case MMPackage.MM_INSTANCE__TYPE_ID:
      setTypeId((String) newValue);
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
    case MMPackage.MM_INSTANCE__TYPE_ID:
      setTypeId(TYPE_ID_EDEFAULT);
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
    case MMPackage.MM_INSTANCE__TYPE_ID:
      return TYPE_ID_EDEFAULT == null ? typeId != null : !TYPE_ID_EDEFAULT.equals(typeId);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == Instance.class) {
      switch (baseOperationID) {
      case MMPackage.INSTANCE___GET_TYPE:
        return MMPackage.MM_INSTANCE___GET_TYPE;
      default:
        return -1;
      }
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
    case MMPackage.MM_INSTANCE___GET_TYPE:
      return getType();
    }
    return super.eInvoke(operationID, arguments);
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
    result.append(" (typeId: ");
    result.append(typeId);
    result.append(')');
    return result.toString();
  }

} //MMInstanceImpl
