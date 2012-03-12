/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.xt.statechart.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.mmtf.xt.statechart.diagram.providers.StatechartElementTypes;

/**
 * @generated
 */
public class StatechartPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createStatechart1Group());
	}

	/**
	 * Creates "statechart" palette tool group
	 * @generated
	 */
	private PaletteContainer createStatechart1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Statechart1Group_title);
		paletteContainer.setId("createStatechart1Group"); //$NON-NLS-1$
		paletteContainer.add(createState1CreationTool());
		paletteContainer.add(createSuperState2CreationTool());
		paletteContainer.add(createTransition3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createState1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatechartElementTypes.State_3001);
		types.add(StatechartElementTypes.State_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.State1CreationTool_title,
				Messages.State1CreationTool_desc, types);
		entry.setId("createState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatechartElementTypes
				.getImageDescriptor(StatechartElementTypes.State_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSuperState2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StatechartElementTypes.SuperState_2001);
		types.add(StatechartElementTypes.SuperState_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SuperState2CreationTool_title,
				Messages.SuperState2CreationTool_desc, types);
		entry.setId("createSuperState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatechartElementTypes
				.getImageDescriptor(StatechartElementTypes.SuperState_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Transition3CreationTool_title,
				Messages.Transition3CreationTool_desc,
				Collections
						.singletonList(StatechartElementTypes.Transition_4001));
		entry.setId("createTransition3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StatechartElementTypes
				.getImageDescriptor(StatechartElementTypes.Transition_4001));
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
