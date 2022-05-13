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
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class PropertyDecompositionStrategyItemProvider extends DecompositionStrategyItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PropertyDecompositionStrategyItemProvider(AdapterFactory adapterFactory) {
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
      addReasonerNamePropertyDescriptor(object);
    }
    return this.itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Reasoner Name feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addReasonerNamePropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_PropertyDecompositionStrategy_reasonerName_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_PropertyDecompositionStrategy_reasonerName_feature", "_UI_PropertyDecompositionStrategy_type"),
         GSNPackage.Literals.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
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
   * This returns PropertyDecompositionStrategy.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/PropertyDecompositionStrategy"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    var label = ((PropertyDecompositionStrategy)object).getId();
    return label == null || label.length() == 0 ?
      getString("_UI_PropertyDecompositionStrategy_type") :
      getString("_UI_PropertyDecompositionStrategy_type") + " " + label;
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

    switch (notification.getFeatureID(PropertyDecompositionStrategy.class)) {
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
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
