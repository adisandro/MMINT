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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

/**
 * The content provider for the Relationship types tree dialog.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipTypesDialogContentProvider implements ITreeContentProvider, MMTFConstants {

	/** The root model relationship. */
	private ModelRel modelRelType;
	private List<String> allowedUris;
	private boolean showRootTypes;

	/**
	 * Constructor: initialises the repository.
	 * 
	 */
	public RelationshipTypesDialogContentProvider(ModelRel modelRelType, List<String> allowedUris, boolean showRootTypes) {

		this.modelRelType = modelRelType;
		this.allowedUris = allowedUris;
		this.showRootTypes = showRootTypes;
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
			List<LinkReference> userLinkTypes = new ArrayList<LinkReference>();
			// add root links
			if (showRootTypes) {
				MultiModel multiModel = (MultiModel) modelRelType.eContainer();
				ModelRel rootModelRelType = MultiModelRegistry.getModelRel(multiModel, ROOT_MODELREL_URI);
				LinkReference rootLinkTypeRef = rootModelRelType.getLinkRefs().get(0);
				userLinkTypes.add(rootLinkTypeRef);
				//TODO MMTF: this won't work for standalone model relationship types (will it ever be a usecase?)
			}
			for (LinkReference linkTypeRef : ((ModelRel) parentElement).getLinkRefs()) {
				String uri = linkTypeRef.getObject().getUri();
				// remove links which are not allowed
				if (allowedUris == null || allowedUris.contains(uri)) {
					userLinkTypes.add(linkTypeRef);
				}
			}
			return userLinkTypes.toArray();
		}
		if (parentElement instanceof Link) {
			List<ModelElementEndpointReference> userEndpointRefs = new ArrayList<ModelElementEndpointReference>();
			for (ModelElementEndpointReference modelElemTypeEndpointRef : ((Link) parentElement).getModelElemEndpointRefs()) {
				// remove model endpoints which are not allowed
				if (allowedUris == null || allowedUris.contains(modelElemTypeEndpointRef.getUri())) {
					userEndpointRefs.add(modelElemTypeEndpointRef);
				}
			}
			return userEndpointRefs.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof LinkReference) {
			return modelRelType;
		}
		if (element instanceof ModelElementEndpointReference) {
			return ((LinkReference) ((ModelElementEndpointReference) element).eContainer()).getObject();
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof ModelRel) {
			if (showRootTypes) {
				return true;
			}
			return !((ModelRel) element).getLinkRefs().isEmpty();
		}
		if (element instanceof Link) {
			return !((Link) element).getModelElemEndpointRefs().isEmpty();
		}

		return false;
	}

}
