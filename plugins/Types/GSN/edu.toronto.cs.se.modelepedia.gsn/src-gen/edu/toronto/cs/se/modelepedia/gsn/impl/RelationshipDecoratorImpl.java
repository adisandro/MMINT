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
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.Decoratable;
import edu.toronto.cs.se.modelepedia.gsn.DecoratorType;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Template;

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
  private void _dropSubtree(ArgumentElement elem, SafetyCase safetyCase) {
    if (elem instanceof Supportable supportable) {
      supportable.getSupportedBy().forEach(sb -> dropSubtree(sb.getTarget(), safetyCase));
    }
    if (elem instanceof Contextualizable contextualizable) {
      contextualizable.getInContextOf().forEach(ico -> dropSubtree(ico.getContext(), safetyCase));
    }
    if (elem instanceof Decoratable decoratable) {
      decoratable.getDecorators().forEach(d -> _dropSubtree(d, safetyCase));
    }
  }

  /**
   * @generated NOT
   */
  private void dropSubtree(ArgumentElement elem, SafetyCase safetyCase) {
    EcoreUtil.remove(elem);
    _dropSubtree(elem, safetyCase);
  }

  /**
   * @generated NOT
   */
  private <T extends ArgumentElement> void _copySubtree(T elem, T copyElem, String idSuffix, SafetyCase safetyCase,
                                                        Template template) {
    if (elem instanceof Supportable supportable) {
      for (var i = 0; i < supportable.getSupportedBy().size(); i++) {
        var copySupporter = copySubtree(supportable.getSupportedBy().get(i).getTarget(), idSuffix, safetyCase,
                                        template);
        ((Supportable) copyElem).getSupportedBy().get(i).setTarget(copySupporter);
      }
    }
    if (elem instanceof Contextualizable contextualizable) {
      for (var i = 0; i < contextualizable.getInContextOf().size(); i++) {
        var copyContextual = copySubtree(contextualizable.getInContextOf().get(i).getContext(), idSuffix, safetyCase,
                                         template);
        ((Contextualizable) copyElem).getInContextOf().get(i).setContext(copyContextual);
      }
    }
    if (elem instanceof Decoratable decoratable) {
      for (var i = 0; i < decoratable.getDecorators().size(); i++) {
        _copySubtree(decoratable.getDecorators().get(i), ((Decoratable) copyElem).getDecorators().get(i), idSuffix,
                     safetyCase, template);
      }
    }
  }

  /**
   * @generated NOT
   */
  private <T extends ArgumentElement> T copySubtree(T elem, String idSuffix, SafetyCase safetyCase, Template template) {
    var copyElem = EcoreUtil.copy(elem);
    copyElem.setId(copyElem.getId() + idSuffix);
    switch (copyElem) {
      case Goal g -> safetyCase.getGoals().add(g);
      case Strategy s -> safetyCase.getStrategies().add(s);
      case Solution s -> safetyCase.getSolutions().add(s);
      case Context c -> safetyCase.getContexts().add(c);
      case Justification j -> safetyCase.getJustifications().add(j);
      case Assumption a -> safetyCase.getAssumptions().add(a);
      default -> {}
    }
    template.getElements().add(copyElem);
    if (copyElem instanceof Decoratable decoratable) {
      template.getElements().addAll(decoratable.getDecorators());
    }
    _copySubtree(elem, copyElem, idSuffix, safetyCase, template);

    return copyElem;
  }

  /**
   * @generated NOT
   */
  private void instantiateOptional(Decoratable decorated, boolean isSupported, @Nullable String hint) {
    var msg = "Keep the optional sub-tree starting below " + decorated.eClass().getName() + " " + decorated.getId() +
              "?";
    if (hint != null && !hint.isBlank()) {
      msg += "\nHint: " + hint;
    }
    var keep = MIDDialogs.getBooleanInput("Instantiate optional sub-tree", msg);
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
  private void instantiateChoice(Decoratable decorated, boolean isSupported, @Nullable String hint)
                                throws MMINTException {
    var max = getCardinality();
    if (max < 0) {
      max = (isSupported) ? getSupportedBy().size() : getInContextOf().size();
    }
    var chosen = 0;
    if (isSupported) {
      for (var iter = getSupportedBy().iterator(); iter.hasNext();) {
        var supportedBy = iter.next();
        var elem = supportedBy.getTarget();
        var msg = "Keep the sub-tree starting at " + elem.eClass().getName() + " " + elem.getId() + " (" + chosen +
                  " kept so far)?";
        if (hint != null && !hint.isBlank()) {
          msg += "\nHint: " + hint;
        }
        var keep = MIDDialogs.getBooleanInput("Instantiate up to " + max + " sub-trees", msg);
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
        var msg = "Keep the sub-tree starting at " + elem.eClass().getName() + " " + elem.getId() + " (" + chosen +
                  " kept so far)?";
        if (hint != null && !hint.isBlank()) {
          msg += "\nHint: " + hint;
        }
        var keep = MIDDialogs.getBooleanInput("Instantiate up to " + max + " sub-trees", msg);
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
  private void instantiateMultiple(Decoratable decorated, boolean isSupported, @Nullable String hint, Template template)
                                  throws MMINTException {
    var max = getCardinality();
    var x = (max < 0) ? "any number of" : "up to " + max;
    var msg = "Multiply the sub-tree starting below " + decorated.eClass().getName() + " " + decorated.getId() +
              " for how many times?";
    if (hint != null && !hint.isBlank()) {
      msg += "\nHint: " + hint;
    }
    var n = Integer.parseInt(MIDDialogs.getStringInput("Instantiate " + x + " sub-trees", msg, "1"));
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
          var idSuffix = "." + (i+1);
          getSupportedBy().forEach(sb -> {
            var copySupportedBy = GSNFactory.eINSTANCE.createSupportedBy();
            copySupportedBy.setTarget(copySubtree(sb.getTarget(), idSuffix, safetyCase, template));
            ((Supportable) decorated).getSupportedBy().add(copySupportedBy);
          });
        }
        getSupportedBy().forEach(sb -> dropSubtree(sb.getTarget(), safetyCase));
      }
      else {
        for (var i = 0; i < n; i++) {
          var idSuffix = "." + (i+1);
          getInContextOf().forEach(ico -> {
            var copyInContextOf = GSNFactory.eINSTANCE.createInContextOf();
            copyInContextOf.setContext(copySubtree(ico.getContext(), idSuffix, safetyCase, template));
            ((Contextualizable) decorated).getInContextOf().add(copyInContextOf);
          });
        }
        getInContextOf().forEach(ico -> dropSubtree(ico.getContext(), safetyCase));
      }
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate(Template template) throws Exception {
    var decorated = (Decoratable) eContainer();
    var isSupported = !getSupportedBy().isEmpty();
    var hint = getDescription();
    switch (this.getType()) {
      case OPTIONAL -> instantiateOptional(decorated, isSupported, hint);
      case CHOICE -> instantiateChoice(decorated, isSupported, hint);
      case MULTIPLE -> instantiateMultiple(decorated, isSupported, hint, template);
    };
    decorated.getDecorators().remove(this);
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate(Template template) throws Exception {
    setValid(false);
    throw new MMINTException("Relationship decorators must be instantiated");
  }

} //RelationshipDecoratorImpl
