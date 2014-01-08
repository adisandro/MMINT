/*
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
package edu.toronto.cs.se.mmtf.mid.ui;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

public class MultiModelTreeSelectionDialog extends ElementTreeSelectionDialog {

	ITreeContentProvider contentProvider;
	Object input;

	public MultiModelTreeSelectionDialog(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider, Object input) {

		super(parent, labelProvider, contentProvider);
		this.contentProvider = contentProvider;
		this.input = input;
		setInput(input);
	}

	public Object getOnlyResult() {

		Object[] results = contentProvider.getElements(input);
		if (results.length == 1 && !contentProvider.hasChildren(results[0])) {
			return results[0];
		}

		return null;
	}

}
