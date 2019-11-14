/**
 */
package edu.toronto.cs.se.mmint3.mm.provider;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import edu.toronto.cs.se.mmint3.mm.MMPackage;

/**
 * This is the item provider adapter for a {@link java.util.Map.Entry} object. <!-- begin-user-doc --> <!-- end-user-doc
 * -->
 *
 * @generated
 */
public class EStringToElementMapItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
  IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public EStringToElementMapItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (this.itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addKeyPropertyDescriptor(object);
      addValuePropertyDescriptor(object);
    }
    return this.itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Key feature. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addKeyPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_EStringToElementMap_key_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_EStringToElementMap_key_feature",
                                                                       "_UI_EStringToElementMap_type"),
                                                             MMPackage.Literals.ESTRING_TO_ELEMENT_MAP__KEY, true,
                                                             false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null, null));
  }

  /**
   * This adds a property descriptor for the Value feature. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addValuePropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_EStringToElementMap_value_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_EStringToElementMap_value_feature",
                                                                       "_UI_EStringToElementMap_type"),
                                                             MMPackage.Literals.ESTRING_TO_ELEMENT_MAP__VALUE, true,
                                                             false, true, null, null, null));
  }

  /**
   * This returns EStringToElementMap.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/EStringToElementMap"));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected boolean shouldComposeCreationImage() {
    return true;
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getText(Object object) {
    Map.Entry<?, ?> eStringToElementMap = (Map.Entry<?, ?>) object;
    return "" + eStringToElementMap.getKey() + " -> " + eStringToElementMap.getValue();
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating a
   * viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(Map.Entry.class)) {
    case MMPackage.ESTRING_TO_ELEMENT_MAP__KEY:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created under
   * this object. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

  /**
   * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return ((IChildCreationExtender) this.adapterFactory).getResourceLocator();
  }

}