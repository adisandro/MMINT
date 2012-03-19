package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import edu.toronto.cs.se.mmtf.repository.Extension;
import edu.toronto.cs.se.mmtf.repository.Repository;

public class RepositoryDialogLabelProvider implements ILabelProvider {

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
		return null;
	}

	@Override
	public String getText(Object element) {

		if (element instanceof Repository) {
			return "Repository";
		}
		if (element instanceof Extension) {
			return ((Extension) element).getName();
		}

		return "";
	}

}
