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

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;

public class NewModelDialogContentProvider implements ITreeContentProvider {

	private MultiModel multiModel;

	public NewModelDialogContentProvider(MultiModel multiModel) {

		this.multiModel = multiModel;
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

		if (parentElement instanceof MultiModel) {
			List<Model> modelTypes = new ArrayList<Model>();
			for (Model modelType : ((MultiModel) parentElement).getModels()) {
				if (modelType instanceof ModelRel || modelType.isAbstract()) {
					continue;
				}
				modelTypes.add(modelType);
			}
			return modelTypes.toArray();
		}
		if (parentElement instanceof Model) {
			boolean allowDiagramTypes = (boolean) MMINT.getSetting(MMINTConstants.SETTING_MENU_DIAGRAMS_CREATION_ENABLED);
			if (allowDiagramTypes) {
				return ((Model) parentElement).getEditors().toArray();
			}
			else {
				List<Editor> editorTypes = new ArrayList<Editor>();
				for (Editor editorType : ((Model) parentElement).getEditors()) {
					if (editorType instanceof Diagram) {
						continue;
					}
					editorTypes.add(editorType);
				}
				return editorTypes.toArray();
			}
		}

		return new Object[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {

		if (element instanceof Model) {
			return multiModel;
		}
		if (element instanceof Editor) {
			return multiModel.getExtendibleTable().get(((Editor) element).getModelUri());
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof MultiModel) {
			return !((MultiModel) element).getModels().isEmpty();
		}
		if (element instanceof Model) {
			return !((Model) element).getEditors().isEmpty();
		}

		return false;
	}

}
