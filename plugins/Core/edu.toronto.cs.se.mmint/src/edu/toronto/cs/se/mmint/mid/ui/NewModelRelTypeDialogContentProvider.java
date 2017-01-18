/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class NewModelRelTypeDialogContentProvider implements ITreeContentProvider {

	private List<String> allowedModelRelTypeUris;

	public NewModelRelTypeDialogContentProvider(List<String> allowedModelRelTypeUris) {

		this.allowedModelRelTypeUris = allowedModelRelTypeUris;
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

		if (parentElement instanceof MID) {
			List<ModelRel> modelRelTypes = new ArrayList<ModelRel>();
			for (Model modelType : ((MID) parentElement).getModels()) {
				if (!(modelType instanceof ModelRel)) {
					continue;
				}
				if (allowedModelRelTypeUris == null || allowedModelRelTypeUris.contains(modelType.getUri())) {
					modelRelTypes.add((ModelRel) modelType);
				}
			}
			return modelRelTypes.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof ModelRel) {
			return ((ModelRel) element).eContainer();
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof MID) {
			return !((MID) element).getModels().isEmpty();
		}

		return false;
	}

}
