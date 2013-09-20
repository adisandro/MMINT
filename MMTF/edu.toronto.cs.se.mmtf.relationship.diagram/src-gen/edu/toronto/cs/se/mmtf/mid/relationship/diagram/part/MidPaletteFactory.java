/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

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

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class MidPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNew1Group());
		paletteRoot.add(createImport2Group());
	}

	/**
	 * Creates "New" palette tool group
	 * @generated
	 */
	private PaletteContainer createNew1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.New1Group_title);
		paletteContainer.setId("createNew1Group"); //$NON-NLS-1$
		paletteContainer.add(createNewBinaryLink1CreationTool());
		paletteContainer.add(createNewNaryLink2CreationTool());
		paletteContainer.add(createConnectModelElement3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Import" palette tool group
	 * @generated
	 */
	private PaletteContainer createImport2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Import2Group_title);
		paletteContainer.setId("createImport2Group"); //$NON-NLS-1$
		paletteContainer.add(createImportModel1CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewBinaryLink1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NewBinaryLink1CreationTool_title,
				Messages.NewBinaryLink1CreationTool_desc,
				Collections
						.singletonList(MidElementTypes.BinaryLinkReference_4012));
		entry.setId("createNewBinaryLink1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MidElementTypes
				.getImageDescriptor(MidElementTypes.BinaryLinkReference_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewNaryLink2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.NewNaryLink2CreationTool_title,
				Messages.NewNaryLink2CreationTool_desc,
				Collections.singletonList(MidElementTypes.LinkReference_2008));
		entry.setId("createNewNaryLink2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MidElementTypes
				.getImageDescriptor(MidElementTypes.LinkReference_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnectModelElement3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ConnectModelElement3CreationTool_title,
				Messages.ConnectModelElement3CreationTool_desc,
				Collections
						.singletonList(MidElementTypes.ModelElementEndpointReference_4011));
		entry.setId("createConnectModelElement3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MidElementTypes
				.getImageDescriptor(MidElementTypes.ModelElementEndpointReference_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImportModel1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ImportModel1CreationTool_title,
				Messages.ImportModel1CreationTool_desc,
				Collections
						.singletonList(MidElementTypes.ModelEndpointReference_2007));
		entry.setId("createImportModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MidElementTypes
				.getImageDescriptor(MidElementTypes.ModelEndpointReference_2007));
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
