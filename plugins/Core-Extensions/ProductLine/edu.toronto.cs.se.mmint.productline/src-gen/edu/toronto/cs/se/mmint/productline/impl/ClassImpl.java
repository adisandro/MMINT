/**
 */
package edu.toronto.cs.se.mmint.productline.impl;

import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.Reference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getReferencesAsSource <em>References As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getReferencesAsTargets <em>References As Targets</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends PLElementImpl implements edu.toronto.cs.se.mmint.productline.Class {
  /**
   * The cached value of the '{@link #getReferencesAsSource() <em>References As Source</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencesAsSource()
   * @generated
   * @ordered
   */
  protected EList<Reference> referencesAsSource;

  /**
   * The cached value of the '{@link #getReferencesAsTargets() <em>References As Targets</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencesAsTargets()
   * @generated
   * @ordered
   */
  protected EList<Reference> referencesAsTargets;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EClass type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ProductLinePackage.Literals.CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Reference> getReferencesAsSource() {
    if (referencesAsSource == null) {
      referencesAsSource = new EObjectWithInverseResolvingEList<Reference>(Reference.class, this,
                                                                           ProductLinePackage.CLASS__REFERENCES_AS_SOURCE,
                                                                           ProductLinePackage.REFERENCE__SOURCE);
    }
    return referencesAsSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Reference> getReferencesAsTargets() {
    if (referencesAsTargets == null) {
      referencesAsTargets = new EObjectWithInverseResolvingEList.ManyInverse<Reference>(Reference.class, this,
                                                                                        ProductLinePackage.CLASS__REFERENCES_AS_TARGETS,
                                                                                        ProductLinePackage.REFERENCE__TARGETS);
    }
    return referencesAsTargets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Attribute> getAttributes() {
    if (attributes == null) {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ProductLinePackage.CLASS__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getType() {
    if (type != null && type.eIsProxy()) {
      InternalEObject oldType = (InternalEObject) type;
      type = (EClass) eResolveProxy(oldType);
      if (type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductLinePackage.CLASS__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass basicGetType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(EClass newType) {
    EClass oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.CLASS__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getReferencesAsSource()).basicAdd(otherEnd, msgs);
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGETS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getReferencesAsTargets()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return ((InternalEList<?>) getReferencesAsSource()).basicRemove(otherEnd, msgs);
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGETS:
      return ((InternalEList<?>) getReferencesAsTargets()).basicRemove(otherEnd, msgs);
    case ProductLinePackage.CLASS__ATTRIBUTES:
      return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return getReferencesAsSource();
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGETS:
      return getReferencesAsTargets();
    case ProductLinePackage.CLASS__ATTRIBUTES:
      return getAttributes();
    case ProductLinePackage.CLASS__TYPE:
      if (resolve)
        return getType();
      return basicGetType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      getReferencesAsSource().clear();
      getReferencesAsSource().addAll((Collection<? extends Reference>) newValue);
      return;
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGETS:
      getReferencesAsTargets().clear();
      getReferencesAsTargets().addAll((Collection<? extends Reference>) newValue);
      return;
    case ProductLinePackage.CLASS__ATTRIBUTES:
      getAttributes().clear();
      getAttributes().addAll((Collection<? extends Attribute>) newValue);
      return;
    case ProductLinePackage.CLASS__TYPE:
      setType((EClass) newValue);
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      getReferencesAsSource().clear();
      return;
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGETS:
      getReferencesAsTargets().clear();
      return;
    case ProductLinePackage.CLASS__ATTRIBUTES:
      getAttributes().clear();
      return;
    case ProductLinePackage.CLASS__TYPE:
      setType((EClass) null);
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return referencesAsSource != null && !referencesAsSource.isEmpty();
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGETS:
      return referencesAsTargets != null && !referencesAsTargets.isEmpty();
    case ProductLinePackage.CLASS__ATTRIBUTES:
      return attributes != null && !attributes.isEmpty();
    case ProductLinePackage.CLASS__TYPE:
      return type != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassImpl
