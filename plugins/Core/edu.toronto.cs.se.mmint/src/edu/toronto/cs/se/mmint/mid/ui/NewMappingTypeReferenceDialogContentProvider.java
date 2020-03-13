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

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class NewMappingTypeReferenceDialogContentProvider implements ITreeContentProvider {

	private ModelRel modelRelType;
	private List<String> allowedMappingTypeUris;

	public NewMappingTypeReferenceDialogContentProvider(ModelRel modelRelType, List<String> allowedMappingTypeUris) {

		this.modelRelType = modelRelType;
		this.allowedMappingTypeUris = allowedMappingTypeUris;
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
			List<MappingReference> mappingTypeRefs = new ArrayList<>();
			// add root link ref first
			//TODO MMINT[MODELREL] this won't work for standalone model relationship types (will it ever be a use case?)
			MID typeMID = modelRelType.getMIDContainer();
			ModelRel rootModelRelType = typeMID.getExtendibleElement(MIDTypeHierarchy.getRootTypeUri(modelRelType));
			MappingReference rootMappingTypeRef = rootModelRelType.getMappingRefs().get(0);
			mappingTypeRefs.add(rootMappingTypeRef);
			for (MappingReference mappingTypeRef : ((ModelRel) parentElement).getMappingRefs()) {
				if (allowedMappingTypeUris == null || allowedMappingTypeUris.contains(mappingTypeRef.getUri())) {
					mappingTypeRefs.add(mappingTypeRef);
				}
			}
			return mappingTypeRefs.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof MappingReference) {
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
