package edu.toronto.cs.se.mmint3.design.dialogs;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import edu.toronto.cs.se.mmint3.mm.Type;
import edu.toronto.cs.se.mmint3.mm.TypeMegaModel;

public class MMLabelProvider implements ILabelProvider {

  private AdapterFactoryLabelProvider labelProvider;

  public MMLabelProvider() {
    var adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
    adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
    this.labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
  }

  @Override
  public void addListener(ILabelProviderListener listener) {
    // do nothing
  }

  @Override
  public void dispose() {
    // do nothing
  }

  @Override
  public boolean isLabelProperty(Object element, String property) {
    return false;
  }

  @Override
  public void removeListener(ILabelProviderListener listener) {
    // do nothing
  }

  @Override
  public Image getImage(Object element) {
    return this.labelProvider.getImage(element);
  }

  @Override
  public String getText(Object element) {
    if (element instanceof TypeMegaModel) {
      return "Type MegaModel";
    }
    if (element instanceof Type) {
      return ((Type) element).getName();
    }
    return "";
  }

}
