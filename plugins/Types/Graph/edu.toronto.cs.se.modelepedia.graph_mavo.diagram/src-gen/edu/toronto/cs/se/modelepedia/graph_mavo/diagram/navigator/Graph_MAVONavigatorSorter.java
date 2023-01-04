/*
* Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class Graph_MAVONavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 4003;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem item = (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem) element;
			return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
