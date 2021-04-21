/**
 */
package edu.toronto.cs.se.mmint.productline.provider;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmint.productline.ProductLine} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductLineItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
  IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductLineItemProvider(AdapterFactory adapterFactory) {
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

      addFeaturesPropertyDescriptor(object);
      addClassesPropertyDescriptor(object);
      addReferencesPropertyDescriptor(object);
      addMetamodelPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Features feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFeaturesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_ProductLine_features_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_ProductLine_features_feature",
                                                                       "_UI_ProductLine_type"),
                                                             ProductLinePackage.Literals.PRODUCT_LINE__FEATURES, true,
                                                             false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null, null));
  }

  /**
   * This adds a property descriptor for the Classes feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addClassesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_ProductLine_classes_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_ProductLine_classes_feature",
                                                                       "_UI_ProductLine_type"),
                                                             ProductLinePackage.Literals.PRODUCT_LINE__CLASSES, true,
                                                             false, true, null, null, null));
  }

  /**
   * This adds a property descriptor for the References feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addReferencesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_ProductLine_references_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_ProductLine_references_feature",
                                                                       "_UI_ProductLine_type"),
                                                             ProductLinePackage.Literals.PRODUCT_LINE__REFERENCES, true,
                                                             false, true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Metamodel feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMetamodelPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_ProductLine_metamodel_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_ProductLine_metamodel_feature",
                                                                       "_UI_ProductLine_type"),
                                                             ProductLinePackage.Literals.PRODUCT_LINE__METAMODEL, true,
                                                             false, true, null, null, null));
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
      childrenFeatures.add(ProductLinePackage.Literals.PRODUCT_LINE__CLASSES);
      childrenFeatures.add(ProductLinePackage.Literals.PRODUCT_LINE__REFERENCES);
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
   * This returns ProductLine.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ProductLine"));
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
    String label = ((ProductLine) object).getFeatures();
    return label == null || label.length() == 0 ? getString("_UI_ProductLine_type")
      : getString("_UI_ProductLine_type") + " " + label;
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

    switch (notification.getFeatureID(ProductLine.class)) {
    case ProductLinePackage.PRODUCT_LINE__FEATURES:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
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

    newChildDescriptors.add(createChildParameter(ProductLinePackage.Literals.PRODUCT_LINE__CLASSES,
                                                 ProductLineFactory.eINSTANCE.createClass()));

    newChildDescriptors.add(createChildParameter(ProductLinePackage.Literals.PRODUCT_LINE__REFERENCES,
                                                 ProductLineFactory.eINSTANCE.createReference()));
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
