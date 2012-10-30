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
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;

/**
 * The content provider for the Mid types tree dialog.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MidTypesDialogContentProvider implements ITreeContentProvider, MMTFExtensionPoints {

	/** The root multimodel. */
	private MultiModel multiModel;
	private EList<String> allowedUris;
	private boolean showRoots;
	private boolean showModels;
	private boolean showModelRels;
	/** True if editors are going to be shown. */
	private boolean showEditors;

	/**
	 * Constructor: initialises the repository.
	 * 
	 * @param multiModel
	 *            The repository.
	 * @param showEditors
	 *            True if editors are going to be shown.
	 */
	public MidTypesDialogContentProvider(MultiModel multiModel, EList<String> allowedUris, boolean showRoots, boolean showModels, boolean showModelRels, boolean showEditors) {

		this.multiModel = multiModel;
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
				boolean isRoot = model.getUri().equals(ROOT_MODEL_URI) || model.getUri().equals(ROOT_MODELREL_URI);
				// remove models
				if (!(model instanceof ModelRel) && !showModels) {
					continue;
				}
				// remove model relationships
				if (model instanceof ModelRel && !showModelRels) {
					continue;
				}
				// remove root models
				if (!showRoots && isRoot) {
					continue;
				}
				// remove models which are not allowed
				if ((isRoot && showRoots) || allowedUris == null || allowedUris.contains(model.getUri())) {
					userModels.add(model);
				}
			}
			return userModels.toArray();
		}
		if (parentElement instanceof ModelRel && !showModelRels) {
			EList<ModelEndpointReference> userEndpointRefs = new BasicEList<ModelEndpointReference>();
			for (ModelEndpointReference modelEndpointRef : ((ModelRel) parentElement).getModelEndpointRefs()) {
				// remove model endpoints which are not allowed
				if (allowedUris == null || allowedUris.contains(modelEndpointRef.getUri())) {
					userEndpointRefs.add(modelEndpointRef);
				}
			}
			return userEndpointRefs.toArray();
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
			return multiModel;
		}
		if (element instanceof Editor) {
			return multiModel.getExtendibleTable().get(((Editor) element).getModelUri());
		}
		if (element instanceof ModelEndpointReference) {
			return ((ModelEndpointReference) element).eContainer();
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof MultiModel) {
			return !((MultiModel) element).getModels().isEmpty();
		}
		if (element instanceof ModelRel && !showModelRels) {
			return !((ModelRel) element).getModelEndpointRefs().isEmpty();
		}
		if (element instanceof Model && showEditors) {
			return !((Model) element).getEditors().isEmpty();
		}

		return false;
	}

}
