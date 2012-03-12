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
package edu.toronto.cs.se.mmtf.mid.diagram.part;

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

import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class MIDPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createMid1Group());
	}

	/**
	 * Creates "mid" palette tool group
	 * @generated
	 */
	private PaletteContainer createMid1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Mid1Group_title);
		paletteContainer.setId("createMid1Group"); //$NON-NLS-1$
		paletteContainer.add(createNewNarymapping1CreationTool());
		paletteContainer.add(createNewmappingconnection2CreationTool());
		paletteContainer.add(createImportmodel3CreationTool());
		paletteContainer.add(createNewbinarymapping4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewNarymapping1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.NewNarymapping1CreationTool_title,
				Messages.NewNarymapping1CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.MappingReference_2001));
		entry.setId("createNewNarymapping1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.MappingReference_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewmappingconnection2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Newmappingconnection2CreationTool_title,
				Messages.Newmappingconnection2CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.MappingReferenceModels_4001));
		entry.setId("createNewmappingconnection2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.MappingReferenceModels_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImportmodel3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Importmodel3CreationTool_title,
				Messages.Importmodel3CreationTool_desc,
				Collections.singletonList(MIDElementTypes.ModelReference_2002));
		entry.setId("createImportmodel3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.ModelReference_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewbinarymapping4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Newbinarymapping4CreationTool_title,
				Messages.Newbinarymapping4CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.BinaryMappingReference_4002));
		entry.setId("createNewbinarymapping4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.BinaryMappingReference_4002));
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
