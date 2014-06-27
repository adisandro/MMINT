/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.provider;


import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.provider.MIDEditPlugin;
import edu.toronto.cs.se.mmint.mid.provider.ModelItemProvider;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelRelItemProvider
	extends ModelItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRelItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(RelationshipPackage.Literals.MODEL_REL__MODEL_ENDPOINTS);
			childrenFeatures.add(RelationshipPackage.Literals.MODEL_REL__LINKS);
			childrenFeatures.add(RelationshipPackage.Literals.MODEL_REL__MODEL_ENDPOINT_REFS);
			childrenFeatures.add(RelationshipPackage.Literals.MODEL_REL__LINK_REFS);
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
	 * This returns ModelRel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelRel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ModelRel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ModelRel_type") :
			getString("_UI_ModelRel_type") + " " + label;
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

		switch (notification.getFeatureID(ModelRel.class)) {
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
			case RelationshipPackage.MODEL_REL__LINKS:
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
			case RelationshipPackage.MODEL_REL__LINK_REFS:
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
				(RelationshipPackage.Literals.MODEL_REL__MODEL_ENDPOINTS,
				 MIDFactory.eINSTANCE.createModelEndpoint()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.MODEL_REL__LINKS,
				 RelationshipFactory.eINSTANCE.createLink()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.MODEL_REL__LINKS,
				 RelationshipFactory.eINSTANCE.createBinaryLink()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.MODEL_REL__MODEL_ENDPOINT_REFS,
				 RelationshipFactory.eINSTANCE.createModelEndpointReference()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.MODEL_REL__LINK_REFS,
				 RelationshipFactory.eINSTANCE.createLinkReference()));

		newChildDescriptors.add
			(createChildParameter
				(RelationshipPackage.Literals.MODEL_REL__LINK_REFS,
				 RelationshipFactory.eINSTANCE.createBinaryLinkReference()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MIDEditPlugin.INSTANCE;
	}

}
