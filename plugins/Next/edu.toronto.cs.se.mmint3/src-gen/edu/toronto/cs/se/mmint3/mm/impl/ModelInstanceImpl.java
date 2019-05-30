/**
 */
package edu.toronto.cs.se.mmint3.mm.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint3.mm.Instance;
import edu.toronto.cs.se.mmint3.mm.MMInstance;
import edu.toronto.cs.se.mmint3.mm.MMPackage;
import edu.toronto.cs.se.mmint3.mm.ModelInstance;
import edu.toronto.cs.se.mmint3.mm.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.ModelInstanceImpl#getI <em>I</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.ModelInstanceImpl#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelInstanceImpl extends ModelImpl implements ModelInstance {
  /**
   * The cached value of the '{@link #getI() <em>I</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getI()
   * @generated
   * @ordered
   */
  protected MMInstance i;

  /**
   * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected EObject root;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelInstanceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MODEL_INSTANCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MMInstance getI() {
    return this.i;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setI(MMInstance newI) {
    if (newI != this.i) {
      NotificationChain msgs = null;
      if (this.i != null)
        msgs = ((InternalEObject) this.i).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_INSTANCE__I, null,
                                                    msgs);
      if (newI != null)
        msgs = ((InternalEObject) newI).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_INSTANCE__I, null,
                                                    msgs);
      msgs = basicSetI(newI, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_INSTANCE__I, newI, newI));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * @generated NOT
   */
  @Override
  public EObject getRoot() {
    var root = getRootGen();
    if (root == null) {
      try {
        root = FileUtils.readModelFile(getI().getId(), this.eResource().getResourceSet(), true);
        this.root = root;
      }
      catch (Exception e) {}
    }
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetRoot() {
    return this.root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRoot(EObject newRoot) {
    EObject oldRoot = this.root;
    this.root = newRoot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_INSTANCE__ROOT, oldRoot, this.root));
  }

  /**
   * @generated NOT
   */
  @Override
  public Type getType() {
    return getI().getType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == Instance.class) {
      switch (baseOperationID) {
      case MMPackage.INSTANCE___GET_TYPE:
        return MMPackage.MODEL_INSTANCE___GET_TYPE;
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
    case MMPackage.MODEL_INSTANCE___GET_TYPE:
      return getType();
    }
    return super.eInvoke(operationID, arguments);
  }

} //ModelInstanceImpl
