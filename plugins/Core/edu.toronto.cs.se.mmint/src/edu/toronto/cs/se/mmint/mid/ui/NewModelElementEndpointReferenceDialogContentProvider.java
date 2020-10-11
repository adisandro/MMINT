/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;

public class NewModelElementEndpointReferenceDialogContentProvider implements ITreeContentProvider {

	private List<String> allowedModelElemTypeEndpointUris;

	public NewModelElementEndpointReferenceDialogContentProvider(List<String> allowedModelElemTypeEndpointUris) {

		this.allowedModelElemTypeEndpointUris = allowedModelElemTypeEndpointUris;
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

		if (parentElement instanceof Mapping) {
			List<ModelElementEndpointReference> modelElemTypeEndpointRefs = new ArrayList<ModelElementEndpointReference>();
			for (ModelElementEndpointReference modelElemTypeEndpointRef : ((Mapping) parentElement).getModelElemEndpointRefs()) {
				if (allowedModelElemTypeEndpointUris == null || allowedModelElemTypeEndpointUris.contains(modelElemTypeEndpointRef.getUri())) {
					modelElemTypeEndpointRefs.add(modelElemTypeEndpointRef);
				}
			}
			return modelElemTypeEndpointRefs.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof ModelElementEndpointReference) {
			return ((MappingReference) ((ModelElementEndpointReference) element).eContainer()).getObject();
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof Mapping) {
			return !((Mapping) element).getModelElemEndpointRefs().isEmpty();
		}

		return false;
	}

}
