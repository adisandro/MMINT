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
import org.eclipse.gef.palette.PaletteDrawer;
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
		paletteRoot.add(createModels1Group());
		paletteRoot.add(createMappings2Group());
	}

	/**
	 * Creates "Models" palette tool group
	 * @generated
	 */
	private PaletteContainer createModels1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Models1Group_title);
		paletteContainer.setId("createModels1Group"); //$NON-NLS-1$
		paletteContainer.add(createImportmodel1CreationTool());
		paletteContainer.add(createCreatemodel2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Mappings" palette tool group
	 * @generated
	 */
	private PaletteContainer createMappings2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Mappings2Group_title);
		paletteContainer.setId("createMappings2Group"); //$NON-NLS-1$
		paletteContainer.add(createImportNarymapping1CreationTool());
		paletteContainer.add(createCreatebinarymapping2CreationTool());
		paletteContainer.add(createCreateNarymapping3CreationTool());
		paletteContainer.add(createCreateNarymappingconnection4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImportmodel1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Importmodel1CreationTool_title,
				Messages.Importmodel1CreationTool_desc,
				Collections.singletonList(MIDElementTypes.ModelReference_2002));
		entry.setId("createImportmodel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.ModelReference_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreatemodel2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Createmodel2CreationTool_title,
				Messages.Createmodel2CreationTool_desc,
				Collections.singletonList(MIDElementTypes.ModelReference_2003));
		entry.setId("createCreatemodel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.ModelReference_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImportNarymapping1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ImportNarymapping1CreationTool_title,
				Messages.ImportNarymapping1CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.MappingReference_2005));
		entry.setId("createImportNarymapping1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.MappingReference_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreatebinarymapping2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Createbinarymapping2CreationTool_title,
				Messages.Createbinarymapping2CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.BinaryMappingReference_4004));
		entry.setId("createCreatebinarymapping2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.BinaryMappingReference_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreateNarymapping3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CreateNarymapping3CreationTool_title,
				Messages.CreateNarymapping3CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.MappingReference_2004));
		entry.setId("createCreateNarymapping3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.MappingReference_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreateNarymappingconnection4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.CreateNarymappingconnection4CreationTool_title,
				Messages.CreateNarymappingconnection4CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.MappingReferenceModels_4003));
		entry.setId("createCreateNarymappingconnection4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.MappingReferenceModels_4003));
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
