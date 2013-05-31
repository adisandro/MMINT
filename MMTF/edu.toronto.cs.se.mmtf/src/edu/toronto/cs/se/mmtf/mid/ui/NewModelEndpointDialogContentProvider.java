/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class NewModelEndpointDialogContentProvider implements ITreeContentProvider {

	private List<String> allowedModelTypeEndpointUris;

	public NewModelEndpointDialogContentProvider(List<String> allowedModelTypeEndpointUris) {

		this.allowedModelTypeEndpointUris = allowedModelTypeEndpointUris;
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

		if (parentElement instanceof ModelRel) {
			List<ModelEndpointReference> modelTypeEndpointRefs = new ArrayList<ModelEndpointReference>();
			for (ModelEndpointReference modelEndpointTypeRef : ((ModelRel) parentElement).getModelEndpointRefs()) {
				if (allowedModelTypeEndpointUris == null || allowedModelTypeEndpointUris.contains(modelEndpointTypeRef.getUri())) {
					modelTypeEndpointRefs.add(modelEndpointTypeRef);
				}
			}
			return modelTypeEndpointRefs.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

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

		if (element instanceof ModelRel) {
			return !((ModelRel) element).getModelEndpointRefs().isEmpty();
		}

		return false;
	}

}
