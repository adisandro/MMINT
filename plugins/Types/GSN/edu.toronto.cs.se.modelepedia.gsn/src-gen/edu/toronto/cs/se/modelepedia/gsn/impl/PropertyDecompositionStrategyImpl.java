/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 *
 */
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IDecompositionTrait;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Decomposition Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl#getReasonerName <em>Reasoner Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDecompositionStrategyImpl extends DecompositionStrategyImpl implements PropertyDecompositionStrategy {
  /**
   * The default value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected static final String REASONER_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected String reasonerName = PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected static final String PROPERTY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected String property = PropertyDecompositionStrategyImpl.PROPERTY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyDecompositionStrategyImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.PROPERTY_DECOMPOSITION_STRATEGY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getReasonerName() {
    return this.reasonerName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReasonerName(String newReasonerName) {
    var oldReasonerName = this.reasonerName;
    this.reasonerName = newReasonerName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME, oldReasonerName, this.reasonerName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getProperty() {
    return this.property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(String newProperty) {
    var oldProperty = this.property;
    this.property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, oldProperty, this.property));
  }

  /**
   * @generated NOT
   */
  private Model getRelatedModel() throws MMINTException {
    // find parent and grandparent goals, to be checked for connections
    var parentGoal = this.getSupports().stream()
      .map(SupportedBy::getSource)
      .filter(g -> g instanceof Goal).map(g -> (Goal) g)
      .findFirst()
      .orElseThrow(() -> new MMINTException("No parent goal found"));
    Goal grandparentGoal = null;
grandparent:
    for (var level1 : parentGoal.getSupports().stream().map(SupportedBy::getSource).collect(Collectors.toList())) {
      if (level1 instanceof Goal) { // direct grandparent (manual decomposition case)
        grandparentGoal = (Goal) level1;
        break;
      }
      else if (level1 instanceof Strategy) { // indirect grandparent (assisted decomposition case)
        for (var level2 : level1.getSupports().stream().map(SupportedBy::getSource).collect(Collectors.toList())) {
          if (level2 instanceof Goal) {
            grandparentGoal = (Goal) level2;
            break grandparent;
          }
        }
      }
    }
    var goalUris = new HashSet<String>();
    goalUris.add(MIDRegistry.getModelElementUri(parentGoal));
    if (grandparentGoal != null) {
      goalUris.add(MIDRegistry.getModelElementUri(grandparentGoal));
    }
    // find the goals in connected rels
    var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(this);
    var modelRels = MIDRegistry.getConnectedModelRels(gsnModel, gsnModel.getMIDContainer());
    //TODO MMINT[GSN]: Ask if there are multiple matches instead of getting the first
    for (var modelRel : modelRels) {
      if (modelRel.getModelEndpoints().size() != 2) { // exclude non-binary
        continue;
      }
      for (var mapping : modelRel.getMappings()) {
        var endpoints = mapping.getModelElemEndpoints();
        if (endpoints.size() != 2) { // exclude non-binary
          continue;
        }
        ModelElement relatedModelElem;
        var uri0 = MIDRegistry.getModelObjectUri(endpoints.get(0).getTarget());
        var uri1 = MIDRegistry.getModelObjectUri(endpoints.get(1).getTarget());
        if (goalUris.contains(uri0)) {
          return (Model) endpoints.get(1).getTarget().eContainer();
        }
        else if (goalUris.contains(uri1)) {
          return (Model) endpoints.get(0).getTarget().eContainer();
        }
      }
    }
    throw new MMINTException("No related model found");
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    var reasonerName = Objects.requireNonNull(getReasonerName(), "Reasoner not specified");
    var reasoner = Objects.requireNonNull(MMINT.getReasoner(reasonerName),
                                          "The reasoner '" + reasonerName + "' is not installed");
    if (!(reasoner instanceof IDecompositionTrait)) {
      throw new MMINTException("The reasoner '" + reasonerName +
                               "' does not have support for GSN property decompositions");
    }
    var property = Objects.requireNonNull(getProperty(), "Property not specified");
    var subProperties = getSupportedBy().stream()
      .map(SupportedBy::getTarget)
      .filter(g -> g instanceof PropertyGoal)
      .filter(g -> ((PropertyGoal) g).getReasonerName().equals(reasonerName))
      .map(g -> ((PropertyGoal) g).getProperty())
      .filter(p -> p != null)
      .collect(Collectors.toList());
    if (subProperties.size() == 0) {
      throw new MMINTException("A property must be decomposed into sub-properties");
    }
    ((IDecompositionTrait) reasoner).validatePropertyDecomposition(getRelatedModel(), property, subProperties);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        return getReasonerName();
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return getProperty();
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
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        setReasonerName((String)newValue);
        return;
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        setProperty((String)newValue);
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
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        setReasonerName(PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT);
        return;
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        setProperty(PropertyDecompositionStrategyImpl.PROPERTY_EDEFAULT);
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
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        return PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT == null ? this.reasonerName != null : !PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT.equals(this.reasonerName);
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return PropertyDecompositionStrategyImpl.PROPERTY_EDEFAULT == null ? this.property != null : !PropertyDecompositionStrategyImpl.PROPERTY_EDEFAULT.equals(this.property);
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
      switch (derivedFeatureID) {
        case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME: return GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__REASONER_NAME;
        case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY: return GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY;
        default: return -1;
      }
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
      switch (baseFeatureID) {
        case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__REASONER_NAME: return GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME;
        case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY: return GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY;
        default: return -1;
      }
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
    result.append(" (reasonerName: ");
    result.append(this.reasonerName);
    result.append(", property: ");
    result.append(this.property);
    result.append(')');
    return result.toString();
  }

} //PropertyDecompositionStrategyImpl
