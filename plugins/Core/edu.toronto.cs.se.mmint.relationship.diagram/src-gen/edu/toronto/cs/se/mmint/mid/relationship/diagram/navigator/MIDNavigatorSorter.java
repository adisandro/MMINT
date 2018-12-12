/*
* Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.mmint.mid.relationship.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class MIDNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 7004;

	/**
	* @generated
	*/
	private static final int SHORTCUTS_CATEGORY = 7003;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof MIDNavigatorItem) {
			MIDNavigatorItem item = (MIDNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return MIDVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
