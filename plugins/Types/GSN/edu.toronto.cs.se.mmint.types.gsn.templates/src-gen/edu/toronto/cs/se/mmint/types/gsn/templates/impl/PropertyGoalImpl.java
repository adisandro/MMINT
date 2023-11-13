/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNDecompositionTrait;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder.PropertyTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.DecompositionUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyGoalImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyGoalImpl#getHint <em>Hint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyGoalImpl extends GoalImpl implements PropertyGoal {
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected Property property;

  /**
   * The default value of the '{@link #getHint() <em>Hint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHint()
   * @generated
   * @ordered
   */
  protected static final String HINT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getHint() <em>Hint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHint()
   * @generated
   * @ordered
   */
  protected String hint = PropertyGoalImpl.HINT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyGoalImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.PROPERTY_GOAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Property getProperty() {
    return this.property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
    var oldProperty = this.property;
    this.property = newProperty;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY, oldProperty, newProperty);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(Property newProperty) {
    if (newProperty != this.property) {
      NotificationChain msgs = null;
      if (this.property != null)
        msgs = ((InternalEObject)this.property).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY, null, msgs);
      if (newProperty != null)
        msgs = ((InternalEObject)newProperty).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY, null, msgs);
      msgs = basicSetProperty(newProperty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY, newProperty, newProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getHint() {
    return this.hint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHint(String newHint) {
    var oldHint = this.hint;
    this.hint = newHint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.PROPERTY_GOAL__HINT, oldHint, this.hint));
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    // the validity of this goal is managed by its supporting strategy
    var strategy = (PropertyDecompositionStrategy) DecompositionUtils.moveOneStrategyUp(this);
    strategy.validate();
  }

  /**
   * @generated NOT
   */
  private void instantiateWithNewProperty(IGSNDecompositionTrait reasoner) throws Exception {
    var title = "Property Decomposition";
    var reasonerName = reasoner.getName();
    var templates = Map.<String, List<PropertyTemplate>>of();
    var modelObjs = Map.<EClass, List<EObject>>of();
    var relatedModelOpt = DecompositionUtils.getRelatedModel(this);
    if (!relatedModelOpt.isEmpty()) {
      var relatedModel = relatedModelOpt.get();
      try {
        templates = reasoner.getPropertyTemplates(relatedModel);
        modelObjs = DecompositionUtils.categorizeModelObjects(relatedModel, templates);
      }
      catch (MMINTException e) {
        // do nothing
      }
    }
    var template = DecompositionUtils.selectPropertyTemplate(title, "Select the property to be decomposed", templates);
    Property property;
    List<String> propQueries = List.of();
    if (template == PropertyTemplate.CUSTOM) {
      var builder = new GSNTemplatesBuilder((SafetyCase) eContainer());
      property = builder.createProperty(title, "Insert the " + reasonerName + " property to be decomposed",
                                        "Insert a description for the custom property");
    }
    else {
      var result = template.bindVariables(title, modelObjs, Map.of());
      property = result.property();
      propQueries = result.queries();
    }
    setProperty(property);
    setDescription(property.getInformal());
    //TODO MMINT[GSN] Manage query context nodes (previous and current)
  }

  /**
   * @generated NOT
   */
  private void instantiateWithHint(String hint) {
    getProperty().setFormal(hint);
    setHint(null);
    //TODO MMINT[GSN] Create interface to figure out goal description from hint
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var propStrategy = (PropertyDecompositionStrategy) DecompositionUtils.moveOneStrategyUp(this);
    var reasonerName = propStrategy.getReasonerName();
    var reasoner = Objects.requireNonNull(MMINT.getReasoner(reasonerName),
                                          "The reasoner '" + reasonerName + "' is not installed");
    if (!(reasoner instanceof IGSNDecompositionTrait gsnReasoner)) {
      throw new MMINTException("The reasoner '" + reasonerName + "' does not support GSN property decompositions");
    }
    var hint = getHint();
    if (hint == null || hint.isBlank()) {
      instantiateWithNewProperty(gsnReasoner);
    }
    else {
      instantiateWithHint(hint);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY:
        return basicSetProperty(null, msgs);
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
      case GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY:
        return getProperty();
      case GSNTemplatesPackage.PROPERTY_GOAL__HINT:
        return getHint();
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
      case GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY:
        setProperty((Property)newValue);
        return;
      case GSNTemplatesPackage.PROPERTY_GOAL__HINT:
        setHint((String)newValue);
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
      case GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY:
        setProperty((Property)null);
        return;
      case GSNTemplatesPackage.PROPERTY_GOAL__HINT:
        setHint(PropertyGoalImpl.HINT_EDEFAULT);
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
      case GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY:
        return this.property != null;
      case GSNTemplatesPackage.PROPERTY_GOAL__HINT:
        return PropertyGoalImpl.HINT_EDEFAULT == null ? this.hint != null : !PropertyGoalImpl.HINT_EDEFAULT.equals(this.hint);
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
    if (baseClass == PropertyDecompositionElement.class) {
      return switch (derivedFeatureID) {
      case GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY -> GSNTemplatesPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY;
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
    if (baseClass == PropertyDecompositionElement.class) {
      return switch (baseFeatureID) {
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY -> GSNTemplatesPackage.PROPERTY_GOAL__PROPERTY;
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
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (hint: ");
    result.append(this.hint);
    result.append(')');
    return result.toString();
  }
} //PropertyGoalImpl
