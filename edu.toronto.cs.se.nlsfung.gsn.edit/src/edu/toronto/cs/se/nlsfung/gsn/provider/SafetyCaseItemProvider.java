/**
 */
package edu.toronto.cs.se.nlsfung.gsn.provider;


import edu.toronto.cs.se.nlsfung.gsn.GSNFactory;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.SafetyCase;

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
 * This is the item provider adapter for a {@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SafetyCaseItemProvider 
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
	public SafetyCaseItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(GSNPackage.Literals.SAFETY_CASE__GOALS);
			childrenFeatures.add(GSNPackage.Literals.SAFETY_CASE__STRATEGIES);
			childrenFeatures.add(GSNPackage.Literals.SAFETY_CASE__SOLUTIONS);
			childrenFeatures.add(GSNPackage.Literals.SAFETY_CASE__CONTEXTS);
			childrenFeatures.add(GSNPackage.Literals.SAFETY_CASE__ASIL_LEVELS);
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
	 * This returns SafetyCase.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SafetyCase"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SafetyCase_type");
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

		switch (notification.getFeatureID(SafetyCase.class)) {
			case GSNPackage.SAFETY_CASE__GOALS:
			case GSNPackage.SAFETY_CASE__STRATEGIES:
			case GSNPackage.SAFETY_CASE__SOLUTIONS:
			case GSNPackage.SAFETY_CASE__CONTEXTS:
			case GSNPackage.SAFETY_CASE__ASIL_LEVELS:
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
				(GSNPackage.Literals.SAFETY_CASE__GOALS,
				 GSNFactory.eINSTANCE.createGoal()));

		newChildDescriptors.add
			(createChildParameter
				(GSNPackage.Literals.SAFETY_CASE__STRATEGIES,
				 GSNFactory.eINSTANCE.createStrategy()));

		newChildDescriptors.add
			(createChildParameter
				(GSNPackage.Literals.SAFETY_CASE__SOLUTIONS,
				 GSNFactory.eINSTANCE.createSolution()));

		newChildDescriptors.add
			(createChildParameter
				(GSNPackage.Literals.SAFETY_CASE__CONTEXTS,
				 GSNFactory.eINSTANCE.createContext()));

		newChildDescriptors.add
			(createChildParameter
				(GSNPackage.Literals.SAFETY_CASE__CONTEXTS,
				 GSNFactory.eINSTANCE.createASIL()));

		newChildDescriptors.add
			(createChildParameter
				(GSNPackage.Literals.SAFETY_CASE__ASIL_LEVELS,
				 GSNFactory.eINSTANCE.createASIL()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == GSNPackage.Literals.SAFETY_CASE__CONTEXTS ||
			childFeature == GSNPackage.Literals.SAFETY_CASE__ASIL_LEVELS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return edutorontocssenlsfunggsnEditPlugin.INSTANCE;
	}

}
