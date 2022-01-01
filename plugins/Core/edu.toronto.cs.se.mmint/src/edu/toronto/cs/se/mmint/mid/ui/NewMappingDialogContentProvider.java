/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class NewMappingDialogContentProvider implements ITreeContentProvider {

    private ModelRel modelRelType;
    private ModelElementReference srcModelElemRef;
    private ModelElementReference tgtModelElemRef;
	private List<Mapping> allowedMappingTypes;

	public NewMappingDialogContentProvider(@NonNull ModelRel modelRelType,
	                                       @Nullable ModelElementReference srcModelElemRef,
	                                       @Nullable ModelElementReference tgtModelElemRef) {

	    this.modelRelType = modelRelType;
	    this.srcModelElemRef = srcModelElemRef;
	    this.tgtModelElemRef = tgtModelElemRef;
		this.allowedMappingTypes = MIDConstraintChecker.getAllowedMappingTypes(modelRelType, this.srcModelElemRef,
                                                                               this.tgtModelElemRef);
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
		    return this.allowedMappingTypes.toArray();
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof Mapping) {
		    return this.modelRelType;
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof ModelRel) {
			return !this.allowedMappingTypes.isEmpty();
		}

		return false;
	}

}
