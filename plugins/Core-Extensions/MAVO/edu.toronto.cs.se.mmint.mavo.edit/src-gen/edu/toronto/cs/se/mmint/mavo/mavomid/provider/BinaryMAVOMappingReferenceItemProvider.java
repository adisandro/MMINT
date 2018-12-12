/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid.provider;


import edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory;

import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import edu.toronto.cs.se.mmint.mid.relationship.provider.BinaryMappingReferenceItemProvider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BinaryMAVOMappingReferenceItemProvider extends BinaryMappingReferenceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryMAVOMappingReferenceItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns BinaryMAVOMappingReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BinaryMAVOMappingReference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		BinaryMAVOMappingReference binaryMAVOMappingReference = (BinaryMAVOMappingReference)object;
		return getString("_UI_BinaryMAVOMappingReference_type") + " " + binaryMAVOMappingReference.isModifiable();
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

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT,
				 MAVOMIDFactory.eINSTANCE.createMAVOModel()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT,
				 MAVOMIDFactory.eINSTANCE.createMAVOModelElement()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT,
				 MAVOMIDFactory.eINSTANCE.createMAVOModelRel()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT,
				 MAVOMIDFactory.eINSTANCE.createBinaryMAVOModelRel()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT,
				 MAVOMIDFactory.eINSTANCE.createMAVOModelEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT,
				 MAVOMIDFactory.eINSTANCE.createMAVOMapping()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT,
				 MAVOMIDFactory.eINSTANCE.createBinaryMAVOMapping()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MAVOMIDEditPlugin.INSTANCE;
	}

}
