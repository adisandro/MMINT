/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.mid.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.provider.ModelRelItemProvider;
import edu.toronto.cs.se.mmint.productline.mid.PLModelRel;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDFactory;
import edu.toronto.cs.se.mmint.productline.provider.ProductLineEditPlugin;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmint.productline.mid.PLModelRel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PLModelRelItemProvider extends ModelRelItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLModelRelItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (this.itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

    }
    return this.itemPropertyDescriptors;
  }

  /**
   * This returns PLModelRel.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/PLModelRel"));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean shouldComposeCreationImage() {
    return true;
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    var label = ((PLModelRel) object).getName();
    return label == null || label.length() == 0 ? getString("_UI_PLModelRel_type")
      : getString("_UI_PLModelRel_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add(createChildParameter(RelationshipPackage.Literals.MODEL_REL__MAPPINGS,
                                                 ProductLineMIDFactory.eINSTANCE.createPLMapping()));

    newChildDescriptors.add(createChildParameter(RelationshipPackage.Literals.MODEL_REL__MAPPINGS,
                                                 ProductLineMIDFactory.eINSTANCE.createPLBinaryMapping()));

    newChildDescriptors.add(createChildParameter(RelationshipPackage.Literals.MODEL_REL__MAPPING_REFS,
                                                 ProductLineMIDFactory.eINSTANCE.createPLMappingReference()));

    newChildDescriptors.add(createChildParameter(RelationshipPackage.Literals.MODEL_REL__MAPPING_REFS,
                                                 ProductLineMIDFactory.eINSTANCE.createPLBinaryMappingReference()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return ProductLineEditPlugin.INSTANCE;
  }

}
