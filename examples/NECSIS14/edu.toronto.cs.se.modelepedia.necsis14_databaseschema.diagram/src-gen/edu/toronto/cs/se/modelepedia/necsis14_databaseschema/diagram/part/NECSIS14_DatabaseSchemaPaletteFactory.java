/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class NECSIS14_DatabaseSchemaPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createColumn1CreationTool());
		paletteContainer.add(createTable2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createColumn1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.Messages.Column1CreationTool_title,
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.Messages.Column1CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Column_3001));
		entry.setId("createColumn1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Column_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTable2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.Messages.Table2CreationTool_title,
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.Messages.Table2CreationTool_desc,
				Collections
						.singletonList(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Table_2001));
		entry.setId("createTable2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes
				.getImageDescriptor(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Table_2001));
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
}
