/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;

/**
 * The content provider for the repository tree dialog.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RepositoryDialogContentProvider implements ITreeContentProvider, MMTFExtensionPoints {

	/** The repository. */
	private MultiModel repository;
	private EList<String> allowedUris;
	private boolean showRoots;
	private boolean showModels;
	private boolean showModelRels;
	/** True if editors are going to be shown. */
	private boolean showEditors;

	/**
	 * Constructor: initialises the repository.
	 * 
	 * @param repository
	 *            The repository.
	 * @param showEditors
	 *            True if editors are going to be shown.
	 */
	public RepositoryDialogContentProvider(MultiModel repository, EList<String> allowedUris, boolean showRoots, boolean showModels, boolean showModelRels, boolean showEditors) {

		this.repository = repository;
		this.allowedUris = allowedUris;
		this.showRoots = showRoots;
		this.showModels = showModels;
		this.showModelRels = showModelRels;
		this.showEditors = showEditors;
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

		if (parentElement instanceof MultiModel) {
			EList<Model> userModels = new BasicEList<Model>();
			for (Model model : ((MultiModel) parentElement).getModels()) {
				// remove models
				if (!(model instanceof ModelRel) && !showModels) {
					continue;
				}
				// remove model relationships
				if (model instanceof ModelRel && !showModelRels) {
					continue;
				}
				// remove root models
				if (!showRoots && (model.getUri().equals(ROOT_MODEL_URI) || model.getUri().equals(ROOT_RELATIONSHIP_URI))) {
					continue;
				}
				// remove models which are not allowed
				if (allowedUris == null || allowedUris.contains(model.getUri())) {
					userModels.add(model);
				}
			}
			return userModels.toArray();
		}
		if (parentElement instanceof Model && showEditors) {
			return ((Model) parentElement).getEditors().toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof Model) {
			return repository;
		}
		if (element instanceof Editor) {
			return repository.getExtendibleTable().get(((Editor) element).getModelUri());
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof MultiModel  ) {
			return !((MultiModel) element).getModels().isEmpty();
		}
		if (element instanceof Model && showEditors) {
			return !((Model) element).getEditors().isEmpty();
		}

		return false;
	}

}
