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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Editor Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.EditorType#getWizardId <em>Wizard Id</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.EditorType#getT <em>T</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.EditorType#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditorType()
 * @model kind="class"
 * @generated
 */
public class EditorType extends Editor implements Type {
  /**
   * The default value of the '{@link #getWizardId() <em>Wizard Id</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getWizardId()
   * @generated
   * @ordered
   */
  protected static final String WIZARD_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWizardId() <em>Wizard Id</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getWizardId()
   * @generated
   * @ordered
   */
  protected String wizardId = EditorType.WIZARD_ID_EDEFAULT;

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
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final EditorKind KIND_EDEFAULT = EditorKind.EMF;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected EditorKind kind = EditorType.KIND_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected EditorType() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.EDITOR_TYPE;
  }

  /**
   * Returns the value of the '<em><b>Wizard Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Wizard Id</em>' attribute.
   * @see #setWizardId(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditorType_WizardId()
   * @model
   * @generated
   */
  public String getWizardId() {
    return this.wizardId;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.EditorType#getWizardId <em>Wizard Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param newWizardId
   *          the new value of the '<em>Wizard Id</em>' attribute.
   * @see #getWizardId()
   * @generated
   */
  public void setWizardId(String newWizardId) {
    String oldWizardId = this.wizardId;
    this.wizardId = newWizardId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.EDITOR_TYPE__WIZARD_ID, oldWizardId, this.wizardId));
  }

  /**
   * Returns the value of the '<em><b>T</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>T</em>' containment reference.
   * @see #setT(MMType)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditorType_T()
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MMPackage.EDITOR_TYPE__T, oldT,
                                                             newT);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.EditorType#getT <em>T</em>}' containment reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param newT
   *          the new value of the '<em>T</em>' containment reference.
   * @see #getT()
   * @generated
   */
  public void setT(MMType newT) {
    if (newT != this.t) {
      NotificationChain msgs = null;
      if (this.t != null)
        msgs = this.t.eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MMPackage.EDITOR_TYPE__T, null, msgs);
      if (newT != null)
        msgs = newT.eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MMPackage.EDITOR_TYPE__T, null, msgs);
      msgs = basicSetT(newT, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.EDITOR_TYPE__T, newT, newT));
  }

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute. The literals are from the enumeration
   * {@link edu.toronto.cs.se.mmint3.mm.EditorKind}. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Kind</em>' attribute.
   * @see edu.toronto.cs.se.mmint3.mm.EditorKind
   * @see #setKind(EditorKind)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditorType_Kind()
   * @model required="true"
   * @generated
   */
  public EditorKind getKind() {
    return this.kind;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.EditorType#getKind <em>Kind</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param newKind
   *          the new value of the '<em>Kind</em>' attribute.
   * @see edu.toronto.cs.se.mmint3.mm.EditorKind
   * @see #getKind()
   * @generated
   */
  public void setKind(EditorKind newKind) {
    EditorKind oldKind = this.kind;
    this.kind = newKind == null ? EditorType.KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.EDITOR_TYPE__KIND, oldKind, this.kind));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.EDITOR_TYPE__T:
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
    case MMPackage.EDITOR_TYPE__WIZARD_ID:
      return getWizardId();
    case MMPackage.EDITOR_TYPE__T:
      return getT();
    case MMPackage.EDITOR_TYPE__KIND:
      return getKind();
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
    case MMPackage.EDITOR_TYPE__WIZARD_ID:
      setWizardId((String) newValue);
      return;
    case MMPackage.EDITOR_TYPE__T:
      setT((MMType) newValue);
      return;
    case MMPackage.EDITOR_TYPE__KIND:
      setKind((EditorKind) newValue);
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
    case MMPackage.EDITOR_TYPE__WIZARD_ID:
      setWizardId(EditorType.WIZARD_ID_EDEFAULT);
      return;
    case MMPackage.EDITOR_TYPE__T:
      setT((MMType) null);
      return;
    case MMPackage.EDITOR_TYPE__KIND:
      setKind(EditorType.KIND_EDEFAULT);
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
    case MMPackage.EDITOR_TYPE__WIZARD_ID:
      return EditorType.WIZARD_ID_EDEFAULT == null ? this.wizardId != null : !EditorType.WIZARD_ID_EDEFAULT.equals(this.wizardId);
    case MMPackage.EDITOR_TYPE__T:
      return this.t != null;
    case MMPackage.EDITOR_TYPE__KIND:
      return this.kind != EditorType.KIND_EDEFAULT;
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
        return MMPackage.EDITOR_TYPE___GET_ID;
      case MMPackage.ELEMENT___SET_ID__STRING:
        return MMPackage.EDITOR_TYPE___SET_ID__STRING;
      case MMPackage.ELEMENT___GET_NAME:
        return MMPackage.EDITOR_TYPE___GET_NAME;
      case MMPackage.ELEMENT___SET_NAME__STRING:
        return MMPackage.EDITOR_TYPE___SET_NAME__STRING;
      case MMPackage.ELEMENT___GET_MEGA_MODEL:
        return MMPackage.EDITOR_TYPE___GET_MEGA_MODEL;
      default:
        return -1;
      }
    }
    if (baseClass == Type.class) {
      switch (baseOperationID) {
      case MMPackage.TYPE___IS_DYNAMIC:
        return MMPackage.EDITOR_TYPE___IS_DYNAMIC;
      case MMPackage.TYPE___SET_DYNAMIC__BOOLEAN:
        return MMPackage.EDITOR_TYPE___SET_DYNAMIC__BOOLEAN;
      case MMPackage.TYPE___IS_ABSTRACT:
        return MMPackage.EDITOR_TYPE___IS_ABSTRACT;
      case MMPackage.TYPE___SET_ABSTRACT__BOOLEAN:
        return MMPackage.EDITOR_TYPE___SET_ABSTRACT__BOOLEAN;
      case MMPackage.TYPE___GET_SUPERTYPE:
        return MMPackage.EDITOR_TYPE___GET_SUPERTYPE;
      case MMPackage.TYPE___SET_SUPERTYPE__TYPE:
        return MMPackage.EDITOR_TYPE___SET_SUPERTYPE__TYPE;
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
    case MMPackage.EDITOR_TYPE___IS_DYNAMIC:
      return isDynamic();
    case MMPackage.EDITOR_TYPE___SET_DYNAMIC__BOOLEAN:
      setDynamic((Boolean) arguments.get(0));
      return null;
    case MMPackage.EDITOR_TYPE___IS_ABSTRACT:
      return isAbstract();
    case MMPackage.EDITOR_TYPE___SET_ABSTRACT__BOOLEAN:
      setAbstract((Boolean) arguments.get(0));
      return null;
    case MMPackage.EDITOR_TYPE___GET_SUPERTYPE:
      return getSupertype();
    case MMPackage.EDITOR_TYPE___SET_SUPERTYPE__TYPE:
      setSupertype((Type) arguments.get(0));
      return null;
    case MMPackage.EDITOR_TYPE___GET_ID:
      return getId();
    case MMPackage.EDITOR_TYPE___SET_ID__STRING:
      setId((String) arguments.get(0));
      return null;
    case MMPackage.EDITOR_TYPE___GET_NAME:
      return getName();
    case MMPackage.EDITOR_TYPE___SET_NAME__STRING:
      setName((String) arguments.get(0));
      return null;
    case MMPackage.EDITOR_TYPE___GET_MEGA_MODEL:
      return getMegaModel();
    }
    return super.eInvoke(operationID, arguments);
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
    result.append(" (wizardId: ");
    result.append(this.wizardId);
    result.append(", kind: ");
    result.append(this.kind);
    result.append(')');
    return result.toString();
  }

} // EditorType
