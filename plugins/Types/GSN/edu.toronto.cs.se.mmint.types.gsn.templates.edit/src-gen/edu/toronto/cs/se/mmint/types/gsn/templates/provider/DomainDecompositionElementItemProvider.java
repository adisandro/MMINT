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
package edu.toronto.cs.se.mmint.types.gsn.templates.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesFactory;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.provider.TemplateElementItemProvider;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainDecompositionElementItemProvider
  extends TemplateElementItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainDecompositionElementItemProvider(AdapterFactory adapterFactory) {
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
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (this.childrenFeatures == null) {
      super.getChildrenFeatures(object);
      this.childrenFeatures.add(GSNTemplatesPackage.Literals.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN);
    }
    return this.childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    var label = ((DomainDecompositionElement)object).getId();
    return label == null || label.length() == 0 ?
      getString("_UI_DomainDecompositionElement_type") :
      getString("_UI_DomainDecompositionElement_type") + " " + label;
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

    switch (notification.getFeatureID(DomainDecompositionElement.class)) {
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
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

    newChildDescriptors.add
      (createChildParameter
        (GSNTemplatesPackage.Literals.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN,
         GSNTemplatesFactory.eINSTANCE.createIntDomain()));

    newChildDescriptors.add
      (createChildParameter
        (GSNTemplatesPackage.Literals.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN,
         GSNTemplatesFactory.eINSTANCE.createRealDomain()));

    newChildDescriptors.add
      (createChildParameter
        (GSNTemplatesPackage.Literals.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN,
         GSNTemplatesFactory.eINSTANCE.createEnumDomain()));

    newChildDescriptors.add
      (createChildParameter
        (GSNTemplatesPackage.Literals.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN,
         GSNTemplatesFactory.eINSTANCE.createValueDomain()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return GSNTemplatesEditPlugin.INSTANCE;
  }

}
