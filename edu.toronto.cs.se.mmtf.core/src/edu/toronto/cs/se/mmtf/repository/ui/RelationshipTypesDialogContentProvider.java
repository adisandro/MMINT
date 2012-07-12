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

import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;

/**
 * The content provider for the Relationship types tree dialog.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipTypesDialogContentProvider implements ITreeContentProvider, MMTFExtensionPoints {

	/** The root model relationship. */
	private ModelRel rootModelRel;
	private EList<String> allowedUris;
	private boolean showRoots;

	/**
	 * Constructor: initialises the repository.
	 * 
	 */
	public RelationshipTypesDialogContentProvider(ModelRel rootModelRel, EList<String> allowedUris, boolean showRoots) {

		this.rootModelRel = rootModelRel;
		this.allowedUris = allowedUris;
		this.showRoots = showRoots;
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
			EList<Link> userLinks = new BasicEList<Link>();
			for (Link link : ((ModelRel) parentElement).getLinks()) {
				// remove root links
				if (!showRoots && link.getUri().equals(ROOT_MODELREL_LINK_URI)) {
					continue;
				}
				// remove links which are not allowed
				if (allowedUris == null || allowedUris.contains(link.getUri())) {
					userLinks.add(link);
				}
			}
			return userLinks.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof Link) {
			return rootModelRel;
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof ModelRel  ) {
			return !((ModelRel) element).getLinks().isEmpty();
		}

		return false;
	}

}
