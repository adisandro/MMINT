/*
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

public class MIDTreeSelectionDialog extends ElementTreeSelectionDialog {

	ITreeContentProvider contentProvider;
	Object input;

    public MIDTreeSelectionDialog(ILabelProvider labelProvider, ITreeContentProvider contentProvider, Object input) {

        super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), labelProvider, contentProvider);
        this.contentProvider = contentProvider;
        this.input = input;
        this.setInput(input);
    }

	public Object getUniqueResult() {

		Object[] results = this.contentProvider.getElements(this.input);
		if (results.length == 1 && !this.contentProvider.hasChildren(results[0])) {
			return results[0];
		}

		return null;
	}

}
