/**
 */
package edu.toronto.cs.se.mmint3.mm.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import edu.toronto.cs.se.mmint3.mm.EditorType;
import edu.toronto.cs.se.mmint3.mm.MMFactory;
import edu.toronto.cs.se.mmint3.mm.MMPackage;

/**
 * This is the item provider adapter for a {@link edu.toronto.cs.se.mmint3.mm.EditorType} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class EditorTypeItemProvider extends EditorItemProvider {
  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public EditorTypeItemProvider(AdapterFactory adapterFactory) {
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

      addWizardIdPropertyDescriptor(object);
      addKindPropertyDescriptor(object);
    }
    return this.itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Wizard Id feature. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addWizardIdPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_EditorType_wizardId_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_EditorType_wizardId_feature",
                                                                       "_UI_EditorType_type"),
                                                             MMPackage.Literals.EDITOR_TYPE__WIZARD_ID, true, false,
                                                             false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Kind feature. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addKindPropertyDescriptor(Object object) {
    this.itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(), getString(
                                                                                             "_UI_EditorType_kind_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_EditorType_kind_feature",
                                                                       "_UI_EditorType_type"),
                                                             MMPackage.Literals.EDITOR_TYPE__KIND, true, false, false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (this.childrenFeatures == null) {
      super.getChildrenFeatures(object);
      this.childrenFeatures.add(MMPackage.Literals.EDITOR_TYPE__T);
    }
    return this.childrenFeatures;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns EditorType.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/EditorType"));
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
    String label = ((EditorType) object).getWizardId();
    return label == null || label.length() == 0 ? getString("_UI_EditorType_type")
      : getString("_UI_EditorType_type") + " " + label;
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

    switch (notification.getFeatureID(EditorType.class)) {
    case MMPackage.EDITOR_TYPE__WIZARD_ID:
    case MMPackage.EDITOR_TYPE__KIND:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case MMPackage.EDITOR_TYPE__T:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

    newChildDescriptors.add(createChildParameter(MMPackage.Literals.EDITOR_TYPE__T, MMFactory.eINSTANCE
                                                                                                       .createMMType()));
  }

}
