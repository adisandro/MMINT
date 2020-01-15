/**
 */
package edu.toronto.cs.se.mmint3.mm;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Editor Instance</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.EditorInstance#getI <em>I</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditorInstance()
 * @model kind="class"
 * @generated
 */
public class EditorInstance extends Editor implements Instance {
  /**
   * The cached value of the '{@link #getI() <em>I</em>}' containment reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getI()
   * @generated
   * @ordered
   */
  protected MMInstance i;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected EditorInstance() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.EDITOR_INSTANCE;
  }

  /**
   * Returns the value of the '<em><b>I</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>I</em>' containment reference.
   * @see #setI(MMInstance)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditorInstance_I()
   * @model containment="true" required="true"
   * @generated
   */
  public MMInstance getI() {
    return this.i;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetI(MMInstance newI, NotificationChain msgs) {
    MMInstance oldI = this.i;
    this.i = newI;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MMPackage.EDITOR_INSTANCE__I, oldI,
                                                             newI);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.EditorInstance#getI <em>I</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param newI
   *          the new value of the '<em>I</em>' containment reference.
   * @see #getI()
   * @generated
   */
  public void setI(MMInstance newI) {
    if (newI != this.i) {
      NotificationChain msgs = null;
      if (this.i != null)
        msgs = this.i.eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MMPackage.EDITOR_INSTANCE__I, null, msgs);
      if (newI != null)
        msgs = newI.eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MMPackage.EDITOR_INSTANCE__I, null, msgs);
      msgs = basicSetI(newI, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.EDITOR_INSTANCE__I, newI, newI));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.EDITOR_INSTANCE__I:
      return basicSetI(null, msgs);
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
    case MMPackage.EDITOR_INSTANCE__I:
      return getI();
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
    case MMPackage.EDITOR_INSTANCE__I:
      setI((MMInstance) newValue);
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
    case MMPackage.EDITOR_INSTANCE__I:
      setI((MMInstance) null);
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
    case MMPackage.EDITOR_INSTANCE__I:
      return this.i != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == InternalEObject.class) {
      switch (baseOperationID) {
      default:
        return -1;
      }
    }
    if (baseClass == Element.class) {
      switch (baseOperationID) {
      case MMPackage.ELEMENT___GET_ID:
        return MMPackage.EDITOR_INSTANCE___GET_ID;
      case MMPackage.ELEMENT___SET_ID__STRING:
        return MMPackage.EDITOR_INSTANCE___SET_ID__STRING;
      case MMPackage.ELEMENT___GET_NAME:
        return MMPackage.EDITOR_INSTANCE___GET_NAME;
      case MMPackage.ELEMENT___SET_NAME__STRING:
        return MMPackage.EDITOR_INSTANCE___SET_NAME__STRING;
      case MMPackage.ELEMENT___GET_MEGA_MODEL:
        return MMPackage.EDITOR_INSTANCE___GET_MEGA_MODEL;
      default:
        return -1;
      }
    }
    if (baseClass == Instance.class) {
      switch (baseOperationID) {
      case MMPackage.INSTANCE___GET_TYPE_ID:
        return MMPackage.EDITOR_INSTANCE___GET_TYPE_ID;
      case MMPackage.INSTANCE___SET_TYPE_ID__STRING:
        return MMPackage.EDITOR_INSTANCE___SET_TYPE_ID__STRING;
      case MMPackage.INSTANCE___GET_TYPE:
        return MMPackage.EDITOR_INSTANCE___GET_TYPE;
      default:
        return -1;
      }
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
    case MMPackage.EDITOR_INSTANCE___GET_TYPE_ID:
      return getTypeId();
    case MMPackage.EDITOR_INSTANCE___SET_TYPE_ID__STRING:
      setTypeId((String) arguments.get(0));
      return null;
    case MMPackage.EDITOR_INSTANCE___GET_TYPE:
      return getType();
    case MMPackage.EDITOR_INSTANCE___GET_ID:
      return getId();
    case MMPackage.EDITOR_INSTANCE___SET_ID__STRING:
      setId((String) arguments.get(0));
      return null;
    case MMPackage.EDITOR_INSTANCE___GET_NAME:
      return getName();
    case MMPackage.EDITOR_INSTANCE___SET_NAME__STRING:
      setName((String) arguments.get(0));
      return null;
    case MMPackage.EDITOR_INSTANCE___GET_MEGA_MODEL:
      return getMegaModel();
    }
    return super.eInvoke(operationID, arguments);
  }

} // EditorInstance
