package edu.toronto.cs.se.mmint3.design.dialogs;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

/**
 * A dialog to select elements from a tree. If only a single element can be selected, defaults to it without displaying
 * the dialog.
 * @author Alessio Di Sandro
 */
public class MMTreeDialog extends ElementTreeSelectionDialog {

  private ITreeContentProvider contentProvider;
  private Object input;

  /**
   * Initializes the dialog.
   * @param labelProvider The provider of labels for the tree elements.
   * @param contentProvider The provider of content for the tree elements.
   * @param input The initial input, i.e. the root of the tree.
   */
  public MMTreeDialog(ILabelProvider labelProvider, ITreeContentProvider contentProvider, Object input) {
    super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), labelProvider, contentProvider);
    this.contentProvider = contentProvider;
    this.input = input;
    this.setInput(input);
  }

  /**
   * Gets the only element that can be selected from the dialog.
   * @return The only element that can be selected, null if no element or more than one element can be selected.
   */
  public @Nullable Object getSoleResult() {
    Object[] results = this.contentProvider.getElements(this.input);
    if (results.length == 1 && !this.contentProvider.hasChildren(results[0])) {
      return results[0];
    }
    return null;
  }

}
