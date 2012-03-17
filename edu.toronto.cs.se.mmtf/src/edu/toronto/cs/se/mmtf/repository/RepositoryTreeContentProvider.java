package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class RepositoryTreeContentProvider implements ITreeContentProvider {

	private Repository repository;

	public RepositoryTreeContentProvider(Repository repository) {

		this.repository = repository;
	}

	@Override
	public void dispose() {
		// do nothing
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// do nothing
	}

	@Override
	public Object[] getElements(Object inputElement) {

		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof Repository) {
			return ((Repository) parentElement).getMetamodels().values().toArray();
		}
		if (parentElement instanceof Metamodel) {
			return ((Metamodel) parentElement).getEditors().toArray();
		}

		return new Object[] {};
	}

	@Override
	public Object getParent(Object element) {

		if (element instanceof Metamodel) {
			return repository;
		}
		if (element instanceof Editor) {
			return repository.getMetamodels().get(((Editor) element).getMetamodelUri());
		}

		return null;
	}

	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof Repository  ) {
			return !((Repository) element).getMetamodels().isEmpty();
		}
		if (element instanceof Metamodel) {
			return !((Metamodel) element).getEditors().isEmpty();
		}

		return false;
	}

}
