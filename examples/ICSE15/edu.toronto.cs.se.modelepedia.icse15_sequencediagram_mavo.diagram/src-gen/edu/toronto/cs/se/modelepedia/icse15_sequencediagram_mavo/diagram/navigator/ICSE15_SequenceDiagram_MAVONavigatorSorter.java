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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ICSE15_SequenceDiagram_MAVONavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 7003;

	/**
	* @generated
	*/
	private static final int SHORTCUTS_CATEGORY = 7002;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem item = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
