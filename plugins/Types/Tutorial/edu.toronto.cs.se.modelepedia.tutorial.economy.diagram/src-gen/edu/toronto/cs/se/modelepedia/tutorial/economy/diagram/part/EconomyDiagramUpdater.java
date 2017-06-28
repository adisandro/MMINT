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
package edu.toronto.cs.se.modelepedia.tutorial.economy.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update.DiagramUpdater;

import edu.toronto.cs.se.modelepedia.tutorial.economy.Economy;
import edu.toronto.cs.se.modelepedia.tutorial.economy.Gold;
import edu.toronto.cs.se.modelepedia.tutorial.economy.diagram.edit.parts.EconomyEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.economy.diagram.edit.parts.GoldEditPart;

/**
 * @generated
 */
public class EconomyDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<EconomyNodeDescriptor> getSemanticChildren(View view) {
		switch (EconomyVisualIDRegistry.getVisualID(view)) {
		case EconomyEditPart.VISUAL_ID:
			return getEconomy_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EconomyNodeDescriptor> getEconomy_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Economy modelElement = (Economy) view.getElement();
		LinkedList<EconomyNodeDescriptor> result = new LinkedList<EconomyNodeDescriptor>();
		for (Iterator<?> it = modelElement.getGold().iterator(); it.hasNext();) {
			Gold childElement = (Gold) it.next();
			int visualID = EconomyVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == GoldEditPart.VISUAL_ID) {
				result.add(new EconomyNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EconomyLinkDescriptor> getContainedLinks(View view) {
		switch (EconomyVisualIDRegistry.getVisualID(view)) {
		case EconomyEditPart.VISUAL_ID:
			return getEconomy_1000ContainedLinks(view);
		case GoldEditPart.VISUAL_ID:
			return getGold_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EconomyLinkDescriptor> getIncomingLinks(View view) {
		switch (EconomyVisualIDRegistry.getVisualID(view)) {
		case GoldEditPart.VISUAL_ID:
			return getGold_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EconomyLinkDescriptor> getOutgoingLinks(View view) {
		switch (EconomyVisualIDRegistry.getVisualID(view)) {
		case GoldEditPart.VISUAL_ID:
			return getGold_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EconomyLinkDescriptor> getEconomy_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EconomyLinkDescriptor> getGold_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EconomyLinkDescriptor> getGold_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EconomyLinkDescriptor> getGold_2001OutgoingLinks(
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
		public List<EconomyNodeDescriptor> getSemanticChildren(View view) {
			return EconomyDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<EconomyLinkDescriptor> getContainedLinks(View view) {
			return EconomyDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<EconomyLinkDescriptor> getIncomingLinks(View view) {
			return EconomyDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<EconomyLinkDescriptor> getOutgoingLinks(View view) {
			return EconomyDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
