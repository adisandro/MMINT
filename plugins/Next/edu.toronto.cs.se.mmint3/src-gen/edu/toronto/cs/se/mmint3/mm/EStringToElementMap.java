/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EString To Element Map</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link java.util.Map.Entry#getTypedKey <em>Key</em>}</li>
 * <li>{@link java.util.Map.Entry#getTypedValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEStringToElementMap()
 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true" valueType="edu.toronto.cs.se.mmint3.mm.Element"
 *        valueRequired="true"
 * @generated
 */
public class EStringToElementMap extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String, Element> {
  /**
   * The default value of the '{@link #getTypedKey() <em>Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getTypedKey()
   * @generated
   * @ordered
   */
  protected static final String KEY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypedKey() <em>Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getTypedKey()
   * @generated
   * @ordered
   */
  protected String key = EStringToElementMap.KEY_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getTypedValue()
   * @generated
   * @ordered
   */
  protected Element value;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected EStringToElementMap() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.ESTRING_TO_ELEMENT_MAP;
  }

  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setTypedKey(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEStringToElementMap_Key()
   * @model required="true"
   * @generated
   */
  public String getTypedKey() {
    return this.key;
  }

  /**
   * Sets the value of the '{@link java.util.Map.Entry#getTypedKey <em>Key</em>}' attribute. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Key</em>' attribute.
   * @see #getTypedKey()
   * @generated
   */
  public void setTypedKey(String newKey) {
    String oldKey = this.key;
    this.key = newKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.ESTRING_TO_ELEMENT_MAP__KEY, oldKey, this.key));
  }

  /**
   * Returns the value of the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Value</em>' reference.
   * @see #setTypedValue(Element)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEStringToElementMap_Value()
   * @model required="true"
   * @generated
   */
  public Element getTypedValue() {
    if (this.value != null && this.value.eIsProxy()) {
      InternalEObject oldValue = (InternalEObject) this.value;
      this.value = (Element) eResolveProxy(oldValue);
      if (this.value != oldValue) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MMPackage.ESTRING_TO_ELEMENT_MAP__VALUE, oldValue,
                                        this.value));
      }
    }
    return this.value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public Element basicGetTypedValue() {
    return this.value;
  }

  /**
   * Sets the value of the '{@link java.util.Map.Entry#getTypedValue <em>Value</em>}' reference. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Value</em>' reference.
   * @see #getTypedValue()
   * @generated
   */
  public void setTypedValue(Element newValue) {
    Element oldValue = this.value;
    this.value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.ESTRING_TO_ELEMENT_MAP__VALUE, oldValue, this.value));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MMPackage.ESTRING_TO_ELEMENT_MAP__KEY:
      return getTypedKey();
    case MMPackage.ESTRING_TO_ELEMENT_MAP__VALUE:
      if (resolve)
        return getTypedValue();
      return basicGetTypedValue();
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
    case MMPackage.ESTRING_TO_ELEMENT_MAP__KEY:
      setTypedKey((String) newValue);
      return;
    case MMPackage.ESTRING_TO_ELEMENT_MAP__VALUE:
      setTypedValue((Element) newValue);
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
    case MMPackage.ESTRING_TO_ELEMENT_MAP__KEY:
      setTypedKey(EStringToElementMap.KEY_EDEFAULT);
      return;
    case MMPackage.ESTRING_TO_ELEMENT_MAP__VALUE:
      setTypedValue((Element) null);
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
    case MMPackage.ESTRING_TO_ELEMENT_MAP__KEY:
      return EStringToElementMap.KEY_EDEFAULT == null ? this.key != null : !EStringToElementMap.KEY_EDEFAULT.equals(this.key);
    case MMPackage.ESTRING_TO_ELEMENT_MAP__VALUE:
      return this.value != null;
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
    result.append(" (key: ");
    result.append(this.key);
    result.append(')');
    return result.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected int hash = -1;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getHash() {
    if (this.hash == -1) {
      Object theKey = getKey();
      this.hash = (theKey == null ? 0 : theKey.hashCode());
    }
    return this.hash;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setHash(int hash) {
    this.hash = hash;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getKey() {
    return getTypedKey();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setKey(String key) {
    setTypedKey(key);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Element getValue() {
    return getTypedValue();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Element setValue(Element value) {
    Element oldValue = getValue();
    setTypedValue(value);
    return oldValue;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EMap<String, Element> getEMap() {
    EObject container = eContainer();
    return container == null ? null : (EMap<String, Element>) container.eGet(eContainmentFeature());
  }

} // EStringToElementMap
