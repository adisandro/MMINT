/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import edu.toronto.cs.se.modelepedia.powerwindow.Sensor;
import edu.toronto.cs.se.modelepedia.powerwindow.Switch;
import edu.toronto.cs.se.modelepedia.powerwindow.Window;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.ForceDetectingEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.InfraredEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.LockOutEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.PushPullEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.RockerEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.WindowEditPart;

/**
 * @generated
 */
public class PowerWindowDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<PowerWindowNodeDescriptor> getSemanticChildren(View view) {
		switch (PowerWindowVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getWindow_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowNodeDescriptor> getWindow_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Window modelElement = (Window) view.getElement();
		LinkedList<PowerWindowNodeDescriptor> result = new LinkedList<PowerWindowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSwitches().iterator(); it
				.hasNext();) {
			Switch childElement = (Switch) it.next();
			int visualID = PowerWindowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PushPullEditPart.VISUAL_ID) {
				result.add(new PowerWindowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RockerEditPart.VISUAL_ID) {
				result.add(new PowerWindowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LockOutEditPart.VISUAL_ID) {
				result.add(new PowerWindowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			Sensor childElement = modelElement.getSensor();
			int visualID = PowerWindowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InfraredEditPart.VISUAL_ID) {
				result.add(new PowerWindowNodeDescriptor(childElement, visualID));
			}
			if (visualID == ForceDetectingEditPart.VISUAL_ID) {
				result.add(new PowerWindowNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getContainedLinks(View view) {
		switch (PowerWindowVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getWindow_1000ContainedLinks(view);
		case PushPullEditPart.VISUAL_ID:
			return getPushPull_2011ContainedLinks(view);
		case RockerEditPart.VISUAL_ID:
			return getRocker_2012ContainedLinks(view);
		case InfraredEditPart.VISUAL_ID:
			return getInfrared_2013ContainedLinks(view);
		case LockOutEditPart.VISUAL_ID:
			return getLockOut_2014ContainedLinks(view);
		case ForceDetectingEditPart.VISUAL_ID:
			return getForceDetecting_2015ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getIncomingLinks(View view) {
		switch (PowerWindowVisualIDRegistry.getVisualID(view)) {
		case PushPullEditPart.VISUAL_ID:
			return getPushPull_2011IncomingLinks(view);
		case RockerEditPart.VISUAL_ID:
			return getRocker_2012IncomingLinks(view);
		case InfraredEditPart.VISUAL_ID:
			return getInfrared_2013IncomingLinks(view);
		case LockOutEditPart.VISUAL_ID:
			return getLockOut_2014IncomingLinks(view);
		case ForceDetectingEditPart.VISUAL_ID:
			return getForceDetecting_2015IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getOutgoingLinks(View view) {
		switch (PowerWindowVisualIDRegistry.getVisualID(view)) {
		case PushPullEditPart.VISUAL_ID:
			return getPushPull_2011OutgoingLinks(view);
		case RockerEditPart.VISUAL_ID:
			return getRocker_2012OutgoingLinks(view);
		case InfraredEditPart.VISUAL_ID:
			return getInfrared_2013OutgoingLinks(view);
		case LockOutEditPart.VISUAL_ID:
			return getLockOut_2014OutgoingLinks(view);
		case ForceDetectingEditPart.VISUAL_ID:
			return getForceDetecting_2015OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getWindow_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getPushPull_2011ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getRocker_2012ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getInfrared_2013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getLockOut_2014ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getForceDetecting_2015ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getPushPull_2011IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getRocker_2012IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getInfrared_2013IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getLockOut_2014IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getForceDetecting_2015IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getPushPull_2011OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getRocker_2012OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getInfrared_2013OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getLockOut_2014OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerWindowLinkDescriptor> getForceDetecting_2015OutgoingLinks(
			View view) {
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
		public List<PowerWindowNodeDescriptor> getSemanticChildren(View view) {
			return PowerWindowDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PowerWindowLinkDescriptor> getContainedLinks(View view) {
			return PowerWindowDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PowerWindowLinkDescriptor> getIncomingLinks(View view) {
			return PowerWindowDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PowerWindowLinkDescriptor> getOutgoingLinks(View view) {
			return PowerWindowDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
