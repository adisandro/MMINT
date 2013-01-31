/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.provider;


import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOFactory;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IntentionItemProvider
	extends DependencyEndpointItemProvider
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
	public IntentionItemProvider(AdapterFactory adapterFactory) {
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

			addFullySatisfiedPropertyDescriptor(object);
			addPartiallySatisfiedPropertyDescriptor(object);
			addUnknownPropertyDescriptor(object);
			addConflictPropertyDescriptor(object);
			addPartiallyDeniedPropertyDescriptor(object);
			addFullyDeniedPropertyDescriptor(object);
			addNoLabelPropertyDescriptor(object);
			addLinksAsTgtPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Fully Satisfied feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFullySatisfiedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_fullySatisfied_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_fullySatisfied_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__FULLY_SATISFIED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Partially Satisfied feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPartiallySatisfiedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_partiallySatisfied_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_partiallySatisfied_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__PARTIALLY_SATISFIED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unknown feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUnknownPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_unknown_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_unknown_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__UNKNOWN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Conflict feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConflictPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_conflict_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_conflict_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__CONFLICT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Partially Denied feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPartiallyDeniedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_partiallyDenied_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_partiallyDenied_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__PARTIALLY_DENIED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fully Denied feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFullyDeniedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_fullyDenied_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_fullyDenied_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__FULLY_DENIED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the No Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_noLabel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_noLabel_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__NO_LABEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Links As Tgt feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinksAsTgtPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Intention_linksAsTgt_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Intention_linksAsTgt_feature", "_UI_Intention_type"),
				 IStar_MAVOPackage.Literals.INTENTION__LINKS_AS_TGT,
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
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(IStar_MAVOPackage.Literals.INTENTION__LINKS_AS_SRC);
			childrenFeatures.add(IStar_MAVOPackage.Literals.INTENTION__DEPENDER_LINKS);
			childrenFeatures.add(IStar_MAVOPackage.Literals.INTENTION__DEPENDEE_LINKS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Intention)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Intention_type") :
			getString("_UI_Intention_type") + " " + label;
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

		switch (notification.getFeatureID(Intention.class)) {
			case IStar_MAVOPackage.INTENTION__FULLY_SATISFIED:
			case IStar_MAVOPackage.INTENTION__PARTIALLY_SATISFIED:
			case IStar_MAVOPackage.INTENTION__UNKNOWN:
			case IStar_MAVOPackage.INTENTION__CONFLICT:
			case IStar_MAVOPackage.INTENTION__PARTIALLY_DENIED:
			case IStar_MAVOPackage.INTENTION__FULLY_DENIED:
			case IStar_MAVOPackage.INTENTION__NO_LABEL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IStar_MAVOPackage.INTENTION__LINKS_AS_SRC:
			case IStar_MAVOPackage.INTENTION__DEPENDER_LINKS:
			case IStar_MAVOPackage.INTENTION__DEPENDEE_LINKS:
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
				(IStar_MAVOPackage.Literals.INTENTION__LINKS_AS_SRC,
				 IStar_MAVOFactory.eINSTANCE.createMeansEnd()));

		newChildDescriptors.add
			(createChildParameter
				(IStar_MAVOPackage.Literals.INTENTION__LINKS_AS_SRC,
				 IStar_MAVOFactory.eINSTANCE.createDecomposition()));

		newChildDescriptors.add
			(createChildParameter
				(IStar_MAVOPackage.Literals.INTENTION__LINKS_AS_SRC,
				 IStar_MAVOFactory.eINSTANCE.createContribution()));

		newChildDescriptors.add
			(createChildParameter
				(IStar_MAVOPackage.Literals.INTENTION__DEPENDER_LINKS,
				 IStar_MAVOFactory.eINSTANCE.createDependerLink()));

		newChildDescriptors.add
			(createChildParameter
				(IStar_MAVOPackage.Literals.INTENTION__DEPENDEE_LINKS,
				 IStar_MAVOFactory.eINSTANCE.createDependeeLink()));
	}

}
