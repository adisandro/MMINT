/**
 */
package edu.toronto.cs.se.mmint3.mm;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Instance</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getI <em>I</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance()
 * @model kind="class"
 * @generated
 */
public class ModelInstance extends Model implements Instance {
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
   * The cached value of the '{@link #getRoot() <em>Root</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected EObject root;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected ModelInstance() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MODEL_INSTANCE;
  }

  /**
   * Returns the value of the '<em><b>I</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>I</em>' containment reference.
   * @see #setI(MMInstance)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance_I()
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_INSTANCE__I, oldI,
                                                             newI);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getI <em>I</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>I</em>' containment reference.
   * @see #getI()
   * @generated
   */
  public void setI(MMInstance newI) {
    if (newI != this.i) {
      NotificationChain msgs = null;
      if (this.i != null)
        msgs = this.i.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_INSTANCE__I, null, msgs);
      if (newI != null)
        msgs = newI.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_INSTANCE__I, null, msgs);
      msgs = basicSetI(newI, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_INSTANCE__I, newI, newI));
  }

  /**
   * Returns the value of the '<em><b>Root</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Root</em>' reference.
   * @see #setRoot(EObject)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance_Root()
   * @model
   * @generated
   */
  public EObject getRootGen() {
    if (this.root != null && this.root.eIsProxy()) {
      InternalEObject oldRoot = (InternalEObject) this.root;
      this.root = eResolveProxy(oldRoot);
      if (this.root != oldRoot) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MMPackage.MODEL_INSTANCE__ROOT, oldRoot, this.root));
      }
    }
    return this.root;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public EObject basicGetRoot() {
    return this.root;
  }

  /**
   * @generated NOT
   */
  public EObject getRoot() {
    var root = getRootGen();
    if (root == null) {
      try {
        root = FileUtils.readModelFile(getId(), null, true);
        this.root = root; // bypass EMF notifications and the need for a write transaction
      }
      catch (Exception e) {
      }
    }
    return root;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot <em>Root</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Root</em>' reference.
   * @see #getRoot()
   * @generated
   */
  public void setRoot(EObject newRoot) {
    EObject oldRoot = this.root;
    this.root = newRoot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_INSTANCE__ROOT, oldRoot, this.root));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MODEL_INSTANCE__I:
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
    case MMPackage.MODEL_INSTANCE__I:
      return getI();
    case MMPackage.MODEL_INSTANCE__ROOT:
      if (resolve)
        return getRoot();
      return basicGetRoot();
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
    case MMPackage.MODEL_INSTANCE__I:
      setI((MMInstance) newValue);
      return;
    case MMPackage.MODEL_INSTANCE__ROOT:
      setRoot((EObject) newValue);
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
    case MMPackage.MODEL_INSTANCE__I:
      setI((MMInstance) null);
      return;
    case MMPackage.MODEL_INSTANCE__ROOT:
      setRoot((EObject) null);
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
    case MMPackage.MODEL_INSTANCE__I:
      return this.i != null;
    case MMPackage.MODEL_INSTANCE__ROOT:
      return this.root != null;
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
    if (baseClass == Element.class) {
      switch (baseOperationID) {
      case MMPackage.ELEMENT___GET_ID:
        return MMPackage.MODEL_INSTANCE___GET_ID;
      case MMPackage.ELEMENT___SET_ID__STRING:
        return MMPackage.MODEL_INSTANCE___SET_ID__STRING;
      case MMPackage.ELEMENT___GET_NAME:
        return MMPackage.MODEL_INSTANCE___GET_NAME;
      case MMPackage.ELEMENT___SET_NAME__STRING:
        return MMPackage.MODEL_INSTANCE___SET_NAME__STRING;
      default:
        return -1;
      }
    }
    if (baseClass == Instance.class) {
      switch (baseOperationID) {
      case MMPackage.INSTANCE___GET_TYPE_ID:
        return MMPackage.MODEL_INSTANCE___GET_TYPE_ID;
      case MMPackage.INSTANCE___SET_TYPE_ID__STRING:
        return MMPackage.MODEL_INSTANCE___SET_TYPE_ID__STRING;
      case MMPackage.INSTANCE___GET_TYPE:
        return MMPackage.MODEL_INSTANCE___GET_TYPE;
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
    case MMPackage.MODEL_INSTANCE___GET_TYPE_ID:
      return getTypeId();
    case MMPackage.MODEL_INSTANCE___SET_TYPE_ID__STRING:
      setTypeId((String) arguments.get(0));
      return null;
    case MMPackage.MODEL_INSTANCE___GET_TYPE:
      return getType();
    case MMPackage.MODEL_INSTANCE___GET_ID:
      return getId();
    case MMPackage.MODEL_INSTANCE___SET_ID__STRING:
      setId((String) arguments.get(0));
      return null;
    case MMPackage.MODEL_INSTANCE___GET_NAME:
      return getName();
    case MMPackage.MODEL_INSTANCE___SET_NAME__STRING:
      setName((String) arguments.get(0));
      return null;
    }
    return super.eInvoke(operationID, arguments);
  }

} // ModelInstance
