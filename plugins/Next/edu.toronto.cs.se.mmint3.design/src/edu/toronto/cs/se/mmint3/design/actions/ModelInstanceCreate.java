package edu.toronto.cs.se.mmint3.design.actions;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import edu.toronto.cs.se.mmint3.MMINT;
import edu.toronto.cs.se.mmint3.design.dialogs.MMLabelProvider;
import edu.toronto.cs.se.mmint3.design.dialogs.MMTreeDialog;
import edu.toronto.cs.se.mmint3.mm.EditorType;
import edu.toronto.cs.se.mmint3.mm.InstanceMegaModel;
import edu.toronto.cs.se.mmint3.mm.ModelType;
import edu.toronto.cs.se.mmint3.mm.TypeMegaModel;

/**
 * The Sirius action handler to create a model instance from an Instance MegaModel.
 * @author Alessio Di Sandro
 */
public class ModelInstanceCreate extends AbstractExternalJavaAction {

  /**
   * Checks whether the model instance can be created.
   * @param arg0 The following collection: [instance megamodel].
   * @return Always true.
   */
  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  /**
   * Creates a model instance from an Instance MegaModel.
   * @param arg0 The following collection: [instance megamodel].
   * @param arg1 Not used.
   */
  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var mm = (InstanceMegaModel) arg0.stream().findFirst().orElseThrow();
    var dialog = new MMTreeDialog(new MMLabelProvider(), new ContentProvider(), MMINT.I.getTypeMegaModel());
    dialog.setValidator(new Validator());
    dialog.setTitle("Create new model");
    dialog.setMessage("Choose editor to create model");
    dialog.setAllowMultiple(false);
    if (dialog.open() == Window.CANCEL) {
      return;
    }
    var selection = (EditorType) dialog.getFirstResult();
    if (selection == null) {
      return;
    }
    ModelType modelT = MMINT.I.getType("edu.toronto.cs.se.mmint3.mm");
    var modelPath = "/next/model.xmi";
    var model = modelT.createInstance(null, modelPath, false, mm);
  }

  private class ContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
      return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
      if (parentElement instanceof TypeMegaModel) {
        return ((TypeMegaModel) parentElement).getModels().stream()
          .filter(ModelType.class::isInstance)
          .map(ModelType.class::cast)
          .filter(modelT -> !modelT.isAbstract())
          .toArray();
      }
      if (parentElement instanceof ModelType) {
        return ((ModelType) parentElement).getEditors().toArray();
      }
      return new Object[] {};
    }

    @Override
    public @Nullable Object getParent(Object element) {
      if (element instanceof ModelType || element instanceof EditorType) {
        return ((EObject) element).eContainer();
      }
      return null;
    }

    @Override
    public boolean hasChildren(Object element) {
      if (element instanceof TypeMegaModel) {
        return !((TypeMegaModel) element).getModels().isEmpty();
      }
      if (element instanceof ModelType) {
        return !((ModelType) element).getEditors().isEmpty();
      }
      return false;
    }
  }

  private class Validator implements ISelectionStatusValidator {

    @Override
    public IStatus validate(Object[] selection) {
      if (Stream.of(selection).anyMatch(ModelType.class::isInstance)) {
        return new Status(IStatus.ERROR, "edu.toronto.cs.se.mmint3", "Please select an editor");
      }
      return new Status(IStatus.OK, "edu.toronto.cs.se.mmint3", "");
    }
  }

}
