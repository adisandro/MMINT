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
package edu.toronto.cs.se.modelepedia.tutorial.state.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update.DiagramUpdater;

import edu.toronto.cs.se.modelepedia.tutorial.state.City;
import edu.toronto.cs.se.modelepedia.tutorial.state.Region;
import edu.toronto.cs.se.modelepedia.tutorial.state.State;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.CityEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.RegionEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.RegionRegionCitiesCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.StateEditPart;

/**
 * @generated
 */
public class StateDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<StateNodeDescriptor> getSemanticChildren(View view) {
		switch (StateVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_1000SemanticChildren(view);
		case RegionRegionCitiesCompartmentEditPart.VISUAL_ID:
			return getRegionRegionCitiesCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateNodeDescriptor> getState_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		State modelElement = (State) view.getElement();
		LinkedList<StateNodeDescriptor> result = new LinkedList<StateNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRegions().iterator(); it
				.hasNext();) {
			Region childElement = (Region) it.next();
			int visualID = StateVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RegionEditPart.VISUAL_ID) {
				result.add(new StateNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateNodeDescriptor> getRegionRegionCitiesCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Region modelElement = (Region) containerView.getElement();
		LinkedList<StateNodeDescriptor> result = new LinkedList<StateNodeDescriptor>();
		for (Iterator<?> it = modelElement.getCities().iterator(); it.hasNext();) {
			City childElement = (City) it.next();
			int visualID = StateVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CityEditPart.VISUAL_ID) {
				result.add(new StateNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getContainedLinks(View view) {
		switch (StateVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_1000ContainedLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001ContainedLinks(view);
		case CityEditPart.VISUAL_ID:
			return getCity_3001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getIncomingLinks(View view) {
		switch (StateVisualIDRegistry.getVisualID(view)) {
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001IncomingLinks(view);
		case CityEditPart.VISUAL_ID:
			return getCity_3001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getOutgoingLinks(View view) {
		switch (StateVisualIDRegistry.getVisualID(view)) {
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001OutgoingLinks(view);
		case CityEditPart.VISUAL_ID:
			return getCity_3001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getState_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getRegion_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getCity_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getRegion_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getCity_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getRegion_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateLinkDescriptor> getCity_3001OutgoingLinks(View view) {
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
		public List<StateNodeDescriptor> getSemanticChildren(View view) {
			return StateDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateLinkDescriptor> getContainedLinks(View view) {
			return StateDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateLinkDescriptor> getIncomingLinks(View view) {
			return StateDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateLinkDescriptor> getOutgoingLinks(View view) {
			return StateDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
