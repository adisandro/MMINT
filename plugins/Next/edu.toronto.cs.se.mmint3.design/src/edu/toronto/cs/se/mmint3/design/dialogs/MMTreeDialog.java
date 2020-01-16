package edu.toronto.cs.se.mmint3.design.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

public class MMTreeDialog extends ElementTreeSelectionDialog {

  private ITreeContentProvider contentProvider;
  private Object input;

  public MMTreeDialog(ILabelProvider labelProvider, ITreeContentProvider contentProvider, Object input) {
    super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), labelProvider, contentProvider);
    this.contentProvider = contentProvider;
    this.input = input;
    this.setInput(input);
  }

  public Object getSoleResult() {
    Object[] results = this.contentProvider.getElements(this.input);
    if (results.length == 1 && !this.contentProvider.hasChildren(results[0])) {
      return results[0];
    }
    return null;
  }

}
