/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.provider;


import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.MultiModel;

import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmtf.mid.MultiModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiModelItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiModelItemProvider(AdapterFactory adapterFactory) {
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
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
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
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MidPackage.Literals.MULTI_MODEL__MODELS);
			childrenFeatures.add(MidPackage.Literals.MULTI_MODEL__EDITORS);
			childrenFeatures.add(MidPackage.Literals.MULTI_MODEL__OPERATORS);
			childrenFeatures.add(MidPackage.Literals.MULTI_MODEL__EXTENDIBLE_TABLE);
			childrenFeatures.add(MidPackage.Literals.MULTI_MODEL__OPERATOR_TABLE);
		}
		return childrenFeatures;
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
	 * This returns MultiModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MultiModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_MultiModel_type");
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

		switch (notification.getFeatureID(MultiModel.class)) {
			case MidPackage.MULTI_MODEL__MODELS:
			case MidPackage.MULTI_MODEL__EDITORS:
			case MidPackage.MULTI_MODEL__OPERATORS:
			case MidPackage.MULTI_MODEL__EXTENDIBLE_TABLE:
			case MidPackage.MULTI_MODEL__OPERATOR_TABLE:
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
				(MidPackage.Literals.MULTI_MODEL__MODELS,
				 MidFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__MODELS,
				 RelationshipFactory.eINSTANCE.createModelRel()));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__MODELS,
				 RelationshipFactory.eINSTANCE.createBinaryModelRel()));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__MODELS,
				 RelationshipFactory.eINSTANCE.createHomomorphismModelRel()));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__EDITORS,
				 EditorFactory.eINSTANCE.create(EditorPackage.Literals.ESTRING_TO_EDITOR_MAP)));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__OPERATORS,
				 OperatorFactory.eINSTANCE.createOperator()));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__OPERATORS,
				 OperatorFactory.eINSTANCE.createCoercionOperator()));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__EXTENDIBLE_TABLE,
				 MidFactory.eINSTANCE.create(MidPackage.Literals.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP)));

		newChildDescriptors.add
			(createChildParameter
				(MidPackage.Literals.MULTI_MODEL__OPERATOR_TABLE,
				 OperatorFactory.eINSTANCE.create(OperatorPackage.Literals.ESTRING_TO_OPERATOR_MAP)));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MidEditPlugin.INSTANCE;
	}

}
