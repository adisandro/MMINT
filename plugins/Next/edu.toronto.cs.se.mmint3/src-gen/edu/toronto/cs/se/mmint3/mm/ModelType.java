/**
 */
package edu.toronto.cs.se.mmint3.mm;

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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.ModelType#getT <em>T</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelType()
 * @model kind="class"
 * @generated
 */
public class ModelType extends Model implements Type {
  /**
   * The cached value of the '{@link #getT() <em>T</em>}' containment reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getT()
   * @generated
   * @ordered
   */
  protected MMType t;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected ModelType() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MODEL_TYPE;
  }

  /**
   * Returns the value of the '<em><b>T</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>T</em>' containment reference.
   * @see #setT(MMType)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelType_T()
   * @model containment="true" required="true"
   * @generated
   */
  public MMType getT() {
    return this.t;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
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
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.ModelType#getT <em>T</em>}' containment reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>T</em>' containment reference.
   * @see #getT()
   * @generated
   */
  public void setT(MMType newT) {
    if (newT != this.t) {
      NotificationChain msgs = null;
      if (this.t != null)
        msgs = this.t.eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_TYPE__T, null, msgs);
      if (newT != null)
        msgs = newT.eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MMPackage.MODEL_TYPE__T, null, msgs);
      msgs = basicSetT(newT, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.MODEL_TYPE__T, newT, newT));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  public EPackage getPackage() {
    if (!isDynamic()) {
      return EPackage.Registry.INSTANCE.getEPackage(getId());
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model required="true"
   * @generated NOT
   */
  public ModelInstance createInstance(EObject root, String path, boolean serialize, InstanceMegaModel mm) {
    if (isAbstract()) {
      // throw exception
    }
    var name = FileUtils.getFileNameFromPath(path);
    var inst = MMFactory.eINSTANCE.createMMInstance();
    inst.setId(path);
    inst.setName(name);
    inst.setTypeId(getId());
    var model = MMFactory.eINSTANCE.createModelInstance();
    model.setI(inst);
    if (root != null) {
      model.setRoot(root);
      if (serialize) {
        try {
          FileUtils.writeModelFile(root, path, true);
        }
        catch (IOException e) {
        }
      }
    }
    if (mm != null) {
      mm.getModels().add(model);
    }

    return model;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
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
        return MMPackage.MODEL_TYPE___GET_ID;
      case MMPackage.ELEMENT___SET_ID__STRING:
        return MMPackage.MODEL_TYPE___SET_ID__STRING;
      case MMPackage.ELEMENT___GET_NAME:
        return MMPackage.MODEL_TYPE___GET_NAME;
      case MMPackage.ELEMENT___SET_NAME__STRING:
        return MMPackage.MODEL_TYPE___SET_NAME__STRING;
      case MMPackage.ELEMENT___GET_MEGA_MODEL:
        return MMPackage.MODEL_TYPE___GET_MEGA_MODEL;
      default:
        return -1;
      }
    }
    if (baseClass == Type.class) {
      switch (baseOperationID) {
      case MMPackage.TYPE___IS_DYNAMIC:
        return MMPackage.MODEL_TYPE___IS_DYNAMIC;
      case MMPackage.TYPE___SET_DYNAMIC__BOOLEAN:
        return MMPackage.MODEL_TYPE___SET_DYNAMIC__BOOLEAN;
      case MMPackage.TYPE___IS_ABSTRACT:
        return MMPackage.MODEL_TYPE___IS_ABSTRACT;
      case MMPackage.TYPE___SET_ABSTRACT__BOOLEAN:
        return MMPackage.MODEL_TYPE___SET_ABSTRACT__BOOLEAN;
      case MMPackage.TYPE___GET_SUPERTYPE:
        return MMPackage.MODEL_TYPE___GET_SUPERTYPE;
      case MMPackage.TYPE___SET_SUPERTYPE__TYPE:
        return MMPackage.MODEL_TYPE___SET_SUPERTYPE__TYPE;
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
    case MMPackage.MODEL_TYPE___GET_PACKAGE:
      return getPackage();
    case MMPackage.MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL:
      return createInstance((EObject) arguments.get(0), (String) arguments.get(1), (Boolean) arguments.get(2),
                            (InstanceMegaModel) arguments.get(3));
    case MMPackage.MODEL_TYPE___IS_DYNAMIC:
      return isDynamic();
    case MMPackage.MODEL_TYPE___SET_DYNAMIC__BOOLEAN:
      setDynamic((Boolean) arguments.get(0));
      return null;
    case MMPackage.MODEL_TYPE___IS_ABSTRACT:
      return isAbstract();
    case MMPackage.MODEL_TYPE___SET_ABSTRACT__BOOLEAN:
      setAbstract((Boolean) arguments.get(0));
      return null;
    case MMPackage.MODEL_TYPE___GET_SUPERTYPE:
      return getSupertype();
    case MMPackage.MODEL_TYPE___SET_SUPERTYPE__TYPE:
      setSupertype((Type) arguments.get(0));
      return null;
    case MMPackage.MODEL_TYPE___GET_ID:
      return getId();
    case MMPackage.MODEL_TYPE___SET_ID__STRING:
      setId((String) arguments.get(0));
      return null;
    case MMPackage.MODEL_TYPE___GET_NAME:
      return getName();
    case MMPackage.MODEL_TYPE___SET_NAME__STRING:
      setName((String) arguments.get(0));
      return null;
    case MMPackage.MODEL_TYPE___GET_MEGA_MODEL:
      return getMegaModel();
    }
    return super.eInvoke(operationID, arguments);
  }

} // ModelType
