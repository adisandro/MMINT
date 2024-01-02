/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramFactory;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.modelepedia.classdiagram.Class} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassItemProvider extends TypeableItemProvider {
	/**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ClassItemProvider(AdapterFactory adapterFactory) {
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

      addDependenciesAsDependeePropertyDescriptor(object);
      addDependenciesAsDependerPropertyDescriptor(object);
      addNestedInPropertyDescriptor(object);
      addNestedPropertyDescriptor(object);
      addSuperclassPropertyDescriptor(object);
      addSubclassesPropertyDescriptor(object);
      addAssociationsAsSourcePropertyDescriptor(object);
      addAssociationsAsTargetPropertyDescriptor(object);
      addCompositionsAsConstituentPropertyDescriptor(object);
      addCompositionsAsCompositePropertyDescriptor(object);
    }
    return this.itemPropertyDescriptors;
  }

	/**
   * This adds a property descriptor for the Dependencies As Dependee feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addDependenciesAsDependeePropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_dependenciesAsDependee_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_dependenciesAsDependee_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__DEPENDENCIES_AS_DEPENDEE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Dependencies As Depender feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addDependenciesAsDependerPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_dependenciesAsDepender_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_dependenciesAsDepender_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__DEPENDENCIES_AS_DEPENDER,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Nested In feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addNestedInPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_nestedIn_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_nestedIn_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__NESTED_IN,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Nested feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addNestedPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_nested_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_nested_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__NESTED,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Superclass feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addSuperclassPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_superclass_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_superclass_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__SUPERCLASS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Subclasses feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addSubclassesPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_subclasses_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_subclasses_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__SUBCLASSES,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Associations As Source feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addAssociationsAsSourcePropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_associationsAsSource_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_associationsAsSource_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__ASSOCIATIONS_AS_SOURCE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Associations As Target feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addAssociationsAsTargetPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_associationsAsTarget_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_associationsAsTarget_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__ASSOCIATIONS_AS_TARGET,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Compositions As Constituent feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addCompositionsAsConstituentPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_compositionsAsConstituent_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_compositionsAsConstituent_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__COMPOSITIONS_AS_CONSTITUENT,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
   * This adds a property descriptor for the Compositions As Composite feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addCompositionsAsCompositePropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Class_compositionsAsComposite_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Class_compositionsAsComposite_feature", "_UI_Class_type"),
         ClassDiagramPackage.Literals.CLASS__COMPOSITIONS_AS_COMPOSITE,
         true,
         false,
         true,
         null,
         null,
         null));
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
      this.childrenFeatures.add(ClassDiagramPackage.Literals.CLASS__OWNED_ATTRIBUTES);
      this.childrenFeatures.add(ClassDiagramPackage.Literals.CLASS__OWNED_OPERATIONS);
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
   * This returns Class.gif.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Class"));
  }

	/**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String getText(Object object) {
    var label = ((edu.toronto.cs.se.modelepedia.classdiagram.Class)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_Class_type") :
      getString("_UI_Class_type") + " " + label;
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

    switch (notification.getFeatureID(edu.toronto.cs.se.modelepedia.classdiagram.Class.class)) {
      case ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES:
      case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
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
        (ClassDiagramPackage.Literals.CLASS__OWNED_ATTRIBUTES,
         ClassDiagramFactory.eINSTANCE.createAttribute()));

    newChildDescriptors.add
      (createChildParameter
        (ClassDiagramPackage.Literals.CLASS__OWNED_OPERATIONS,
         ClassDiagramFactory.eINSTANCE.createOperation()));
  }

}
