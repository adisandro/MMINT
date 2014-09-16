/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class NewLinkReferenceDialogContentProvider implements ITreeContentProvider {

	private List<String> allowedLinkTypeUris;

	public NewLinkReferenceDialogContentProvider(List<String> allowedLinkTypeUris) {

		this.allowedLinkTypeUris = allowedLinkTypeUris;
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
			List<LinkReference> linkTypeRefs = new ArrayList<LinkReference>();
			for (LinkReference linkTypeRef : ((ModelRel) parentElement).getLinkRefs()) {
				if (allowedLinkTypeUris == null || allowedLinkTypeUris.contains(linkTypeRef.getUri())) {
					linkTypeRefs.add(linkTypeRef);
				}
			}
			return linkTypeRefs.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof LinkReference) {
			return ((LinkReference) element).eContainer();
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof ModelRel) {
			return !((ModelRel) element).getLinkRefs().isEmpty();
		}

		return false;
	}

}
