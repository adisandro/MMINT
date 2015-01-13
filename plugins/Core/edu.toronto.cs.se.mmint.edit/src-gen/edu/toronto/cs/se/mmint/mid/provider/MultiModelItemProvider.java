/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.provider;


import edu.toronto.cs.se.mavo.provider.MAVOModelItemProvider;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmint.mid.MultiModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiModelItemProvider
	extends MAVOModelItemProvider {
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

			addLevelPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiModel_level_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiModel_level_feature", "_UI_MultiModel_type"),
				 MIDPackage.Literals.MULTI_MODEL__LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(MIDPackage.Literals.MULTI_MODEL__MODELS);
			childrenFeatures.add(MIDPackage.Literals.MULTI_MODEL__EDITORS);
			childrenFeatures.add(MIDPackage.Literals.MULTI_MODEL__OPERATORS);
			childrenFeatures.add(MIDPackage.Literals.MULTI_MODEL__EXTENDIBLE_TABLE);
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
		MultiModel multiModel = (MultiModel)object;
		return getString("_UI_MultiModel_type") + " " + multiModel.isInc();
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
			case MIDPackage.MULTI_MODEL__LEVEL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MIDPackage.MULTI_MODEL__MODELS:
			case MIDPackage.MULTI_MODEL__EDITORS:
			case MIDPackage.MULTI_MODEL__OPERATORS:
			case MIDPackage.MULTI_MODEL__EXTENDIBLE_TABLE:
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
				(MIDPackage.Literals.MULTI_MODEL__MODELS,
				 MIDFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__MODELS,
				 RelationshipFactory.eINSTANCE.createModelRel()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__MODELS,
				 RelationshipFactory.eINSTANCE.createBinaryModelRel()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__EDITORS,
				 EditorFactory.eINSTANCE.createEditor()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__EDITORS,
				 EditorFactory.eINSTANCE.createDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__OPERATORS,
				 OperatorFactory.eINSTANCE.createOperator()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__OPERATORS,
				 OperatorFactory.eINSTANCE.createConversionOperator()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__OPERATORS,
				 OperatorFactory.eINSTANCE.createRandomOperator()));

		newChildDescriptors.add
			(createChildParameter
				(MIDPackage.Literals.MULTI_MODEL__EXTENDIBLE_TABLE,
				 MIDFactory.eINSTANCE.create(MIDPackage.Literals.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP)));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ((IChildCreationExtender)adapterFactory).getResourceLocator();
	}

}
