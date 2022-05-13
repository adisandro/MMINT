/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.modelepedia.gsn.PropertyGoal} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class PropertyGoalItemProvider extends GoalItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PropertyGoalItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (this.itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addPropertyPropertyDescriptor(object);
      addValidPropertyDescriptor(object);
      addHintPropertyDescriptor(object);
    }
    return this.itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Property feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addPropertyPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_PropertyDecompositionElement_property_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_PropertyDecompositionElement_property_feature", "_UI_PropertyDecompositionElement_type"),
         GSNPackage.Literals.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY,
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Valid feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addValidPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_PropertyGoal_valid_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_PropertyGoal_valid_feature", "_UI_PropertyGoal_type"),
         GSNPackage.Literals.PROPERTY_GOAL__VALID,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Hint feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addHintPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_PropertyGoal_hint_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_PropertyGoal_hint_feature", "_UI_PropertyGoal_type"),
         GSNPackage.Literals.PROPERTY_GOAL__HINT,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This returns PropertyGoal.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/PropertyGoal"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    var label = ((PropertyGoal)object).getId();
    return label == null || label.length() == 0 ?
      getString("_UI_PropertyGoal_type") :
      getString("_UI_PropertyGoal_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(PropertyGoal.class)) {
      case GSNPackage.PROPERTY_GOAL__PROPERTY:
      case GSNPackage.PROPERTY_GOAL__VALID:
      case GSNPackage.PROPERTY_GOAL__HINT:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

}
