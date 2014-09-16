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
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part;

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

import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers.RelationalDatabaseElementTypes;

/**
 * @generated
 */
public class RelationalDatabasePaletteFactory {

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
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createColumn1CreationTool());
		paletteContainer.add(createForeignKey2CreationTool());
		paletteContainer.add(createTable3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createForeignColumn1CreationTool());
		paletteContainer.add(createTableColumn2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createColumn1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Column1CreationTool_title,
				Messages.Column1CreationTool_desc,
				Collections
						.singletonList(RelationalDatabaseElementTypes.Column_3001));
		entry.setId("createColumn1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RelationalDatabaseElementTypes
				.getImageDescriptor(RelationalDatabaseElementTypes.Column_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForeignKey2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ForeignKey2CreationTool_title,
				Messages.ForeignKey2CreationTool_desc,
				Collections
						.singletonList(RelationalDatabaseElementTypes.ForeignKey_3002));
		entry.setId("createForeignKey2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RelationalDatabaseElementTypes
				.getImageDescriptor(RelationalDatabaseElementTypes.ForeignKey_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTable3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Table3CreationTool_title,
				Messages.Table3CreationTool_desc,
				Collections
						.singletonList(RelationalDatabaseElementTypes.Table_2001));
		entry.setId("createTable3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RelationalDatabaseElementTypes
				.getImageDescriptor(RelationalDatabaseElementTypes.Table_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForeignColumn1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ForeignColumn1CreationTool_title,
				Messages.ForeignColumn1CreationTool_desc,
				Collections
						.singletonList(RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002));
		entry.setId("createForeignColumn1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RelationalDatabaseElementTypes
				.getImageDescriptor(RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTableColumn2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.TableColumn2CreationTool_title,
				Messages.TableColumn2CreationTool_desc,
				Collections
						.singletonList(RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001));
		entry.setId("createTableColumn2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RelationalDatabaseElementTypes
				.getImageDescriptor(RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001));
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
