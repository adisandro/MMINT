/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmtf.repository.Editor;
import edu.toronto.cs.se.mmtf.repository.Metamodel;
import edu.toronto.cs.se.mmtf.repository.Repository;

/**
 * The content provider for the repository tree dialog.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RepositoryDialogContentProvider implements ITreeContentProvider {

	/** The repository. */
	private Repository repository;

	/**
	 * Constructor: initialises the repository.
	 * 
	 * @param repository
	 *            The repository.
	 */
	public RepositoryDialogContentProvider(Repository repository) {

		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 * This implementation does nothing.
	 */
	@Override
	public void dispose() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * This implementation does nothing.
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object inputElement) {

		return getChildren(inputElement);
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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
