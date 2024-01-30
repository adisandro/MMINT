/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.Decoratable;
import edu.toronto.cs.se.modelepedia.gsn.DecoratorType;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.RelationshipDecoratorImpl#getInContextOf <em>In Context Of</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.RelationshipDecoratorImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.RelationshipDecoratorImpl#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationshipDecoratorImpl extends SupportableImpl implements RelationshipDecorator {
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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final DecoratorType TYPE_EDEFAULT = DecoratorType.MULTIPLE;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected DecoratorType type = RelationshipDecoratorImpl.TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCardinality()
   * @generated
   * @ordered
   */
  protected static final int CARDINALITY_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCardinality()
   * @generated
   * @ordered
   */
  protected int cardinality = RelationshipDecoratorImpl.CARDINALITY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelationshipDecoratorImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.RELATIONSHIP_DECORATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InContextOf> getInContextOf() {
    if (this.inContextOf == null) {
      this.inContextOf = new EObjectContainmentWithInverseEList<>(InContextOf.class, this, GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF);
    }
    return this.inContextOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DecoratorType getType() {
    return this.type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(DecoratorType newType) {
    var oldType = this.type;
    this.type = newType == null ? RelationshipDecoratorImpl.TYPE_EDEFAULT : newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.RELATIONSHIP_DECORATOR__TYPE, oldType, this.type));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getCardinality() {
    return this.cardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCardinality(int newCardinality) {
    var oldCardinality = this.cardinality;
    this.cardinality = newCardinality;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.RELATIONSHIP_DECORATOR__CARDINALITY, oldCardinality, this.cardinality));
    }
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
      case GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getInContextOf()).basicAdd(otherEnd, msgs);
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
      case GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF:
        return ((InternalEList<?>)getInContextOf()).basicRemove(otherEnd, msgs);
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
      case GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF:
        return getInContextOf();
      case GSNPackage.RELATIONSHIP_DECORATOR__TYPE:
        return getType();
      case GSNPackage.RELATIONSHIP_DECORATOR__CARDINALITY:
        return getCardinality();
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
      case GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF:
        getInContextOf().clear();
        getInContextOf().addAll((Collection<? extends InContextOf>)newValue);
        return;
      case GSNPackage.RELATIONSHIP_DECORATOR__TYPE:
        setType((DecoratorType)newValue);
        return;
      case GSNPackage.RELATIONSHIP_DECORATOR__CARDINALITY:
        setCardinality((Integer)newValue);
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
      case GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF:
        getInContextOf().clear();
        return;
      case GSNPackage.RELATIONSHIP_DECORATOR__TYPE:
        setType(RelationshipDecoratorImpl.TYPE_EDEFAULT);
        return;
      case GSNPackage.RELATIONSHIP_DECORATOR__CARDINALITY:
        setCardinality(RelationshipDecoratorImpl.CARDINALITY_EDEFAULT);
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
      case GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF:
        return this.inContextOf != null && !this.inContextOf.isEmpty();
      case GSNPackage.RELATIONSHIP_DECORATOR__TYPE:
        return this.type != RelationshipDecoratorImpl.TYPE_EDEFAULT;
      case GSNPackage.RELATIONSHIP_DECORATOR__CARDINALITY:
        return this.cardinality != RelationshipDecoratorImpl.CARDINALITY_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == Contextualizable.class) {
      return switch (derivedFeatureID) {
      case GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF -> GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF;
      default -> -1;
      };
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == Contextualizable.class) {
      return switch (baseFeatureID) {
      case GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF -> GSNPackage.RELATIONSHIP_DECORATOR__IN_CONTEXT_OF;
      default -> -1;
      };
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (type: ");
    result.append(this.type);
    result.append(", cardinality: ");
    result.append(this.cardinality);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  private void dropSubtree(ArgumentElement elem, SafetyCase safetyCase) {
    EcoreUtil.remove(elem);
    if (elem instanceof Supportable supportable) {
      supportable.getSupportedBy().forEach(sb -> dropSubtree(sb.getTarget(), safetyCase));
    }
    if (elem instanceof Contextualizable contextualizable) {
      contextualizable.getInContextOf().forEach(ico -> dropSubtree(ico.getContext(), safetyCase));
    }
    if (elem instanceof Decoratable decoratable) {
      decoratable.getDecorators().forEach(d -> dropSubtree(d, safetyCase));
    }
  }

  /**
   * @generated NOT
   */
  private void instantiateOptional(Decoratable decorated, boolean isSupported) {
    var keep = MIDDialogs.getBooleanInput("Instantiate optional sub-tree",
                                          "Keep the optional sub-tree starting below " + decorated.eClass().getName() +
                                          " " + decorated.getId() + "?");
    if (keep) {
      if (isSupported) {
        ((Supportable) decorated).getSupportedBy().addAll(getSupportedBy());
      }
      else {
        ((Contextualizable) decorated).getInContextOf().addAll(getInContextOf());
      }
    }
    else {
      var safetyCase = (SafetyCase) decorated.eContainer();
      if (isSupported) {
        getSupportedBy().forEach(sb -> dropSubtree(sb.getTarget(), safetyCase));
      }
      else {
        getInContextOf().forEach(ico -> dropSubtree(ico.getContext(), safetyCase));
      }
    }
  }

  /**
   * @generated NOT
   */
  private void instantiateChoice(Decoratable decorated, boolean isSupported) throws MMINTException {
    var chosen = 0;
    var max = getCardinality();
    if (max < 0) {
      max = (isSupported) ? getSupportedBy().size() : getInContextOf().size();
    }
    if (isSupported) {
      for (var iter = getSupportedBy().iterator(); iter.hasNext();) {
        var supportedBy = iter.next();
        var elem = supportedBy.getTarget();
        var keep = MIDDialogs.getBooleanInput("Instantiate up to " + max + " sub-trees",
                                              "Keep the sub-tree starting at " + elem.eClass().getName() + " " +
                                              elem.getId() + " (" + chosen + " kept so far)?");
        if (keep) {
          iter.remove();
          ((Supportable) decorated).getSupportedBy().add(supportedBy);
          chosen++;
          if (chosen >= max) {
            break;
          }
        }
        else {
          dropSubtree(elem, (SafetyCase) decorated.eContainer());
        }
      }
    }
    else {
      for (var iter = getInContextOf().iterator(); iter.hasNext();) {
        var inContextOf = iter.next();
        var elem = inContextOf.getContext();
        var keep = MIDDialogs.getBooleanInput("Instantiate up to " + max + " sub-trees",
                                              "Keep the sub-tree starting at " + elem.eClass().getName() + " " +
                                              elem.getId() + " (" + chosen + " kept so far)?");
        if (keep) {
          iter.remove();
          ((Contextualizable) decorated).getInContextOf().add(inContextOf);
          chosen++;
          if (chosen >= max) {
            break;
          }
        }
        else {
          dropSubtree(elem, (SafetyCase) decorated.eContainer());
        }
      }
    }
    if (chosen == 0) {
      throw new MMINTException("At least one sub-tree must be chosen");
    }
  }

  /**
   * @generated NOT
   */
  private void instantiateMultiple(Decoratable decorated, boolean isSupported) throws MMINTException {
    var max = getCardinality();
    var x = (max < 0) ? "any number of" : "up to " + max;
    var n = Integer.parseInt(
      MIDDialogs.getStringInput("Instantiate " + x + " sub-trees", "Multiply the sub-tree starting below " +
                                decorated.eClass().getName() + " " + decorated.getId() + " for how many times?", "1"));
    if (n <= 0) {
      throw new MMINTException("At least 1 sub-tree must be instantiated");
    }
    if (max > 0 && n >= max) {
      throw new MMINTException("A max of " + max + " sub-trees can be instantiated");
    }
    if (n == 1) { // fast path, equivalent to optional
      if (isSupported) {
        ((Supportable) decorated).getSupportedBy().addAll(getSupportedBy());
      }
      else {
        ((Contextualizable) decorated).getInContextOf().addAll(getInContextOf());
      }
    }
    else {
      var safetyCase = (SafetyCase) decorated.eContainer();
      if (isSupported) {
        for (var i = 0; i < n; i++) {
          for (var supportedBy : getSupportedBy()) {
          }
        }
        getSupportedBy().forEach(sb -> dropSubtree(sb.getTarget(), safetyCase));
      }
      else {
        for (var i = 0; i < n; i++) {
        }
        getInContextOf().forEach(ico -> dropSubtree(ico.getContext(), safetyCase));
      }
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var isSupported = !getSupportedBy().isEmpty();
    var decorated = (Decoratable) eContainer();
    switch (this.getType()) {
      case OPTIONAL -> instantiateOptional(decorated, isSupported);
      case CHOICE -> instantiateChoice(decorated, isSupported);
      case MULTIPLE -> instantiateMultiple(decorated, isSupported);
    };
    decorated.getDecorators().remove(this);
    /** TODO:
     *  1) Implement the three cases, removing the decorator and connecting the result to the node (use description as hint):
     *  1c) MULTIPLE: ask for n and copy subbranch n times (append _mX to ids)
     */
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    setValid(false);
    throw new MMINTException("Relationship decorators must be instantiated");
  }

} //RelationshipDecoratorImpl
