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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class IStar_MAVOPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createActor1CreationTool());
		paletteContainer.add(createGoal2CreationTool());
		paletteContainer.add(createResource3CreationTool());
		paletteContainer.add(createSoftGoal4CreationTool());
		paletteContainer.add(createTask5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createContribution1CreationTool());
		paletteContainer.add(createDecomposition2CreationTool());
		paletteContainer.add(createDependeeLink3CreationTool());
		paletteContainer.add(createDependerLink4CreationTool());
		paletteContainer.add(createMeansEnd5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Actor1CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Actor1CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Actor_2005));
		entry.setId("createActor1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Actor_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGoal2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_2004);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_3004);
		NodeToolEntry entry = new NodeToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Goal2CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Goal2CreationTool_desc,
				types);
		entry.setId("createGoal2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResource3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_2003);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_3003);
		NodeToolEntry entry = new NodeToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Resource3CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Resource3CreationTool_desc,
				types);
		entry.setId("createResource3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSoftGoal4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_2001);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_3001);
		NodeToolEntry entry = new NodeToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.SoftGoal4CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.SoftGoal4CreationTool_desc,
				types);
		entry.setId("createSoftGoal4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTask5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_2002);
		types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_3002);
		NodeToolEntry entry = new NodeToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Task5CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Task5CreationTool_desc,
				types);
		entry.setId("createTask5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createContribution1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Contribution1CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Contribution1CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Contribution_4003));
		entry.setId("createContribution1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Contribution_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDecomposition2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Decomposition2CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.Decomposition2CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Decomposition_4002));
		entry.setId("createDecomposition2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Decomposition_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependeeLink3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.DependeeLink3CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.DependeeLink3CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependeeLink_4005));
		entry.setId("createDependeeLink3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependeeLink_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependerLink4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.DependerLink4CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.DependerLink4CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependerLink_4004));
		entry.setId("createDependerLink4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependerLink_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMeansEnd5CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.MeansEnd5CreationTool_title,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.MeansEnd5CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.MeansEnd_4001));
		entry.setId("createMeansEnd5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.MeansEnd_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
