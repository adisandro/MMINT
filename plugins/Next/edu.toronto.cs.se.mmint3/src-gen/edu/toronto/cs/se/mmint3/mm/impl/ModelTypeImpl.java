/**
 */
package edu.toronto.cs.se.mmint3.mm.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint3.mm.InstanceMegaModel;
import edu.toronto.cs.se.mmint3.mm.MMFactory;
import edu.toronto.cs.se.mmint3.mm.MMPackage;
import edu.toronto.cs.se.mmint3.mm.MMType;
import edu.toronto.cs.se.mmint3.mm.ModelInstance;
import edu.toronto.cs.se.mmint3.mm.ModelType;
import edu.toronto.cs.se.mmint3.mm.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.ModelTypeImpl#getT <em>T</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelTypeImpl extends ModelImpl implements ModelType {
  /**
   * The cached value of the '{@link #getT() <em>T</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getT()
   * @generated
   * @ordered
   */
  protected MMType t;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MODEL_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MMType getT() {
    return this.t;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetT(MMType newT, NotificationChain msgs) {
    MMType oldT = this.t;
    this.t = newT;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_TYPE__T, oldT,
                                                             newT);
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
  public void setT(MMType newT) {
    if (newT != this.t) {
      NotificationChain msgs = null;
      if (this.t != null)
        msgs = ((InternalEObject) this.t).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_TYPE__T, null, msgs);
      if (newT != null)
        msgs = ((InternalEObject) newT).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_TYPE__T, null, msgs);
      msgs = basicSetT(newT, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_TYPE__T, newT, newT));
  }

  /**
   * @generated NOT
   */
  @Override
  public EPackage getPackage() {
    if (!isDynamic()) {
      return EPackage.Registry.INSTANCE.getEPackage(getT().getId());
    }
    return null;
  }

  /**
   * @generated NOT
   */
  @Override
  public ModelInstance createInstance(EObject root, String path, boolean serialize, InstanceMegaModel mm) {
    if (isAbstract()) {
      // throw exception
    }
    var name = FileUtils.getFileNameFromPath(path);
    var inst = MMFactory.eINSTANCE.createMMInstance();
    inst.setId(path);
    inst.setName(name);
    inst.setTypeId(getT().getId());
    var model = MMFactory.eINSTANCE.createModelInstance();
    model.setI(inst);
    if (root != null) {
      model.setRoot(root);
      if (serialize) {
        try {
          FileUtils.writeModelFile(root, path, true);
        }
        catch (IOException e) {}
      }
    }
    if (mm != null) {
      mm.getModels().add(model);
    }

    return model;
  }

  /**
   * @generated NOT
   */
  @Override
  public boolean isDynamic() {
    return getT().isDynamic();
  }

  /**
   * @generated NOT
   */
  @Override
  public boolean isAbstract() {
    return getT().isAbstract();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MODEL_TYPE__T:
      return basicSetT(null, msgs);
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
    case MMPackage.MODEL_TYPE__T:
      return getT();
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
    case MMPackage.MODEL_TYPE__T:
      setT((MMType) newValue);
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
    case MMPackage.MODEL_TYPE__T:
      setT((MMType) null);
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
    case MMPackage.MODEL_TYPE__T:
      return this.t != null;
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
    if (baseClass == Type.class) {
      switch (baseOperationID) {
      case MMPackage.TYPE___IS_DYNAMIC:
        return MMPackage.MODEL_TYPE___IS_DYNAMIC;
      case MMPackage.TYPE___IS_ABSTRACT:
        return MMPackage.MODEL_TYPE___IS_ABSTRACT;
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
    case MMPackage.MODEL_TYPE___GET_PACKAGE:
      return getPackage();
    case MMPackage.MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL:
      return createInstance((EObject) arguments.get(0), (String) arguments.get(1), (Boolean) arguments.get(2),
                            (InstanceMegaModel) arguments.get(3));
    case MMPackage.MODEL_TYPE___IS_DYNAMIC:
      return isDynamic();
    case MMPackage.MODEL_TYPE___IS_ABSTRACT:
      return isAbstract();
    }
    return super.eInvoke(operationID, arguments);
  }

} //ModelTypeImpl
