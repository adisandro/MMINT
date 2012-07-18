/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
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
public class PowerwindowDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<PowerwindowNodeDescriptor> getSemanticChildren(View view) {
		switch (PowerwindowVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getWindow_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowNodeDescriptor> getWindow_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Window modelElement = (Window) view.getElement();
		LinkedList<PowerwindowNodeDescriptor> result = new LinkedList<PowerwindowNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSwitches().iterator(); it
				.hasNext();) {
			Switch childElement = (Switch) it.next();
			int visualID = PowerwindowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PushPullEditPart.VISUAL_ID) {
				result.add(new PowerwindowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RockerEditPart.VISUAL_ID) {
				result.add(new PowerwindowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LockOutEditPart.VISUAL_ID) {
				result.add(new PowerwindowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			Sensor childElement = modelElement.getSensor();
			int visualID = PowerwindowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InfraredEditPart.VISUAL_ID) {
				result.add(new PowerwindowNodeDescriptor(childElement, visualID));
			}
			if (visualID == ForceDetectingEditPart.VISUAL_ID) {
				result.add(new PowerwindowNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getContainedLinks(View view) {
		switch (PowerwindowVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getWindow_1000ContainedLinks(view);
		case PushPullEditPart.VISUAL_ID:
			return getPushPull_2006ContainedLinks(view);
		case RockerEditPart.VISUAL_ID:
			return getRocker_2007ContainedLinks(view);
		case InfraredEditPart.VISUAL_ID:
			return getInfrared_2008ContainedLinks(view);
		case LockOutEditPart.VISUAL_ID:
			return getLockOut_2009ContainedLinks(view);
		case ForceDetectingEditPart.VISUAL_ID:
			return getForceDetecting_2010ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getIncomingLinks(View view) {
		switch (PowerwindowVisualIDRegistry.getVisualID(view)) {
		case PushPullEditPart.VISUAL_ID:
			return getPushPull_2006IncomingLinks(view);
		case RockerEditPart.VISUAL_ID:
			return getRocker_2007IncomingLinks(view);
		case InfraredEditPart.VISUAL_ID:
			return getInfrared_2008IncomingLinks(view);
		case LockOutEditPart.VISUAL_ID:
			return getLockOut_2009IncomingLinks(view);
		case ForceDetectingEditPart.VISUAL_ID:
			return getForceDetecting_2010IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getOutgoingLinks(View view) {
		switch (PowerwindowVisualIDRegistry.getVisualID(view)) {
		case PushPullEditPart.VISUAL_ID:
			return getPushPull_2006OutgoingLinks(view);
		case RockerEditPart.VISUAL_ID:
			return getRocker_2007OutgoingLinks(view);
		case InfraredEditPart.VISUAL_ID:
			return getInfrared_2008OutgoingLinks(view);
		case LockOutEditPart.VISUAL_ID:
			return getLockOut_2009OutgoingLinks(view);
		case ForceDetectingEditPart.VISUAL_ID:
			return getForceDetecting_2010OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getWindow_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getPushPull_2006ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getRocker_2007ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getInfrared_2008ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getLockOut_2009ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getForceDetecting_2010ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getPushPull_2006IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getRocker_2007IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getInfrared_2008IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getLockOut_2009IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getForceDetecting_2010IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getPushPull_2006OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getRocker_2007OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getInfrared_2008OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getLockOut_2009OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PowerwindowLinkDescriptor> getForceDetecting_2010OutgoingLinks(
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
		public List<PowerwindowNodeDescriptor> getSemanticChildren(View view) {
			return PowerwindowDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PowerwindowLinkDescriptor> getContainedLinks(View view) {
			return PowerwindowDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PowerwindowLinkDescriptor> getIncomingLinks(View view) {
			return PowerwindowDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PowerwindowLinkDescriptor> getOutgoingLinks(View view) {
			return PowerwindowDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
