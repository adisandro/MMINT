/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.ContextualizableElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Goal</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl#getSupports <em>Supports</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl#getInContextOf <em>In Context Of</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl#getAsil <em>Asil</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GoalImpl extends SupportableImpl implements Goal {
  /**
   * The cached value of the '{@link #getSupports() <em>Supports</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupports()
   * @generated
   * @ordered
   */
  protected EList<SupportedBy> supports;

  /**
   * The cached value of the '{@link #getInContextOf() <em>In Context Of</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInContextOf()
   * @generated
   * @ordered
   */
  protected EList<InContextOf> inContextOf;

  /**
   * The cached value of the '{@link #getAsil() <em>Asil</em>}' containment reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getAsil()
   * @generated
   * @ordered
   */
  protected ASIL asil;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected GoalImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.GOAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SupportedBy> getSupports() {
    if (this.supports == null) {
      this.supports = new EObjectWithInverseResolvingEList<>(SupportedBy.class, this, GSNPackage.GOAL__SUPPORTS, GSNPackage.SUPPORTED_BY__TARGET);
    }
    return this.supports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InContextOf> getInContextOf() {
    if (this.inContextOf == null) {
      this.inContextOf = new EObjectContainmentWithInverseEList<>(InContextOf.class, this, GSNPackage.GOAL__IN_CONTEXT_OF, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF);
    }
    return this.inContextOf;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASIL getAsil() {
    return this.asil;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAsil(ASIL newAsil, NotificationChain msgs) {
    var oldAsil = this.asil;
    this.asil = newAsil;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__ASIL, oldAsil, newAsil);
      if (msgs == null) {
        msgs = notification;
      }
      else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAsil(ASIL newAsil) {
    if (newAsil != this.asil) {
      NotificationChain msgs = null;
      if (this.asil != null) {
        msgs = ((InternalEObject)this.asil).eInverseRemove(this, GSNPackage.ASIL__TARGET, ASIL.class, msgs);
      }
      if (newAsil != null) {
        msgs = ((InternalEObject)newAsil).eInverseAdd(this, GSNPackage.ASIL__TARGET, ASIL.class, msgs);
      }
      msgs = basicSetAsil(newAsil, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__ASIL, newAsil, newAsil));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.GOAL__SUPPORTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupports()).basicAdd(otherEnd, msgs);
      case GSNPackage.GOAL__IN_CONTEXT_OF:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getInContextOf()).basicAdd(otherEnd, msgs);
      case GSNPackage.GOAL__ASIL:
        if (this.asil != null) {
          msgs = ((InternalEObject)this.asil).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.GOAL__ASIL, null, msgs);
        }
        return basicSetAsil((ASIL)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.GOAL__SUPPORTS:
        return ((InternalEList<?>)getSupports()).basicRemove(otherEnd, msgs);
      case GSNPackage.GOAL__IN_CONTEXT_OF:
        return ((InternalEList<?>)getInContextOf()).basicRemove(otherEnd, msgs);
      case GSNPackage.GOAL__ASIL:
        return basicSetAsil(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.GOAL__SUPPORTS:
        return getSupports();
      case GSNPackage.GOAL__IN_CONTEXT_OF:
        return getInContextOf();
      case GSNPackage.GOAL__ASIL:
        return getAsil();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNPackage.GOAL__SUPPORTS:
        getSupports().clear();
        getSupports().addAll((Collection<? extends SupportedBy>)newValue);
        return;
      case GSNPackage.GOAL__IN_CONTEXT_OF:
        getInContextOf().clear();
        getInContextOf().addAll((Collection<? extends InContextOf>)newValue);
        return;
      case GSNPackage.GOAL__ASIL:
        setAsil((ASIL)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case GSNPackage.GOAL__SUPPORTS:
        getSupports().clear();
        return;
      case GSNPackage.GOAL__IN_CONTEXT_OF:
        getInContextOf().clear();
        return;
      case GSNPackage.GOAL__ASIL:
        setAsil((ASIL)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case GSNPackage.GOAL__SUPPORTS:
        return this.supports != null && !this.supports.isEmpty();
      case GSNPackage.GOAL__IN_CONTEXT_OF:
        return this.inContextOf != null && !this.inContextOf.isEmpty();
      case GSNPackage.GOAL__ASIL:
        return this.asil != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == Supporter.class) {
      return switch (derivedFeatureID) {
      case GSNPackage.GOAL__SUPPORTS -> GSNPackage.SUPPORTER__SUPPORTS;
      default -> -1;
      };
    }
    if (baseClass == ContextualizableElement.class) {
      return switch (derivedFeatureID) {
      case GSNPackage.GOAL__IN_CONTEXT_OF -> GSNPackage.CONTEXTUALIZABLE_ELEMENT__IN_CONTEXT_OF;
      default -> -1;
      };
    }
    if (baseClass == ASILfulElement.class) {
      return switch (derivedFeatureID) {
      case GSNPackage.GOAL__ASIL -> GSNPackage.ASI_LFUL_ELEMENT__ASIL;
      default -> -1;
      };
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == Supporter.class) {
      return switch (baseFeatureID) {
      case GSNPackage.SUPPORTER__SUPPORTS -> GSNPackage.GOAL__SUPPORTS;
      default -> -1;
      };
    }
    if (baseClass == ContextualizableElement.class) {
      return switch (baseFeatureID) {
      case GSNPackage.CONTEXTUALIZABLE_ELEMENT__IN_CONTEXT_OF -> GSNPackage.GOAL__IN_CONTEXT_OF;
      default -> -1;
      };
    }
    if (baseClass == ASILfulElement.class) {
      return switch (baseFeatureID) {
      case GSNPackage.ASI_LFUL_ELEMENT__ASIL -> GSNPackage.GOAL__ASIL;
      default -> -1;
      };
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} // GoalImpl
