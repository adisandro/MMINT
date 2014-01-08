/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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

import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class NewLinkTypeReferenceDialogContentProvider implements ITreeContentProvider {

	private ModelRel modelRelType;
	private List<String> allowedLinkTypeUris;

	public NewLinkTypeReferenceDialogContentProvider(ModelRel modelRelType, List<String> allowedLinkTypeUris) {

		this.modelRelType = modelRelType;
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
			// add root link ref first
			//TODO MMTF: this won't work for standalone model relationship types (will it ever be a usecase?)
			MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
			ModelRel rootModelRelType = MultiModelRegistry.getExtendibleElement(MultiModelTypeHierarchy.getRootTypeUri(modelRelType), multiModel);
			LinkReference rootLinkTypeRef = rootModelRelType.getLinkRefs().get(0);
			linkTypeRefs.add(rootLinkTypeRef);
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
			return modelRelType;
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof ModelRel) {
			return true;
		}

		return false;
	}

}
