/*
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
package edu.toronto.cs.se.modelepedia.tutorial.army.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update.DiagramUpdater;

import edu.toronto.cs.se.modelepedia.tutorial.army.Army;
import edu.toronto.cs.se.modelepedia.tutorial.army.Unit;
import edu.toronto.cs.se.modelepedia.tutorial.army.diagram.edit.parts.ArmyEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.army.diagram.edit.parts.UnitEditPart;

/**
 * @generated
 */
public class ArmyDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<ArmyNodeDescriptor> getSemanticChildren(View view) {
		switch (ArmyVisualIDRegistry.getVisualID(view)) {
		case ArmyEditPart.VISUAL_ID:
			return getArmy_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ArmyNodeDescriptor> getArmy_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Army modelElement = (Army) view.getElement();
		LinkedList<ArmyNodeDescriptor> result = new LinkedList<ArmyNodeDescriptor>();
		for (Iterator<?> it = modelElement.getUnits().iterator(); it.hasNext();) {
			Unit childElement = (Unit) it.next();
			int visualID = ArmyVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == UnitEditPart.VISUAL_ID) {
				result.add(new ArmyNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ArmyLinkDescriptor> getContainedLinks(View view) {
		switch (ArmyVisualIDRegistry.getVisualID(view)) {
		case ArmyEditPart.VISUAL_ID:
			return getArmy_1000ContainedLinks(view);
		case UnitEditPart.VISUAL_ID:
			return getUnit_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ArmyLinkDescriptor> getIncomingLinks(View view) {
		switch (ArmyVisualIDRegistry.getVisualID(view)) {
		case UnitEditPart.VISUAL_ID:
			return getUnit_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ArmyLinkDescriptor> getOutgoingLinks(View view) {
		switch (ArmyVisualIDRegistry.getVisualID(view)) {
		case UnitEditPart.VISUAL_ID:
			return getUnit_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ArmyLinkDescriptor> getArmy_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ArmyLinkDescriptor> getUnit_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ArmyLinkDescriptor> getUnit_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ArmyLinkDescriptor> getUnit_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<ArmyNodeDescriptor> getSemanticChildren(View view) {
			return ArmyDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ArmyLinkDescriptor> getContainedLinks(View view) {
			return ArmyDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ArmyLinkDescriptor> getIncomingLinks(View view) {
			return ArmyDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ArmyLinkDescriptor> getOutgoingLinks(View view) {
			return ArmyDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
