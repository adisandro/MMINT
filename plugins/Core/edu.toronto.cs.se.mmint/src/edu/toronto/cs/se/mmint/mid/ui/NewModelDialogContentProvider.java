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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class NewModelDialogContentProvider implements ITreeContentProvider {

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

		return this.getChildren(inputElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof MID) {
		    return ((MID) parentElement).getModels().stream()
		        .filter(modelType -> !(modelType instanceof ModelRel))
		        .filter(modelType -> !modelType.isAbstract())
		        .toArray();
		}
		if (parentElement instanceof Model) {
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
			return ((Model) element).eContainer();
		}
		if (element instanceof Editor) {
		    return MIDTypeRegistry.getType(((Editor) element).getModelUri());
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
		if (element instanceof Model) {
			return !((Model) element).getEditors().isEmpty();
		}

		return false;
	}

}
