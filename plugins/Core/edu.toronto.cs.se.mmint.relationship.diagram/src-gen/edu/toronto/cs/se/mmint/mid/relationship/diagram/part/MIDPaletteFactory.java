
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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultNodeToolEntry;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class MIDPaletteFactory {

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
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.New1Group_title);
		paletteContainer.setId("createNew1Group"); //$NON-NLS-1$
		paletteContainer.add(createNewBinaryMapping1CreationTool());
		paletteContainer.add(createNewNaryMapping2CreationTool());
		paletteContainer.add(createConnectModelElement3CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Import" palette tool group
	* @generated
	*/
	private PaletteContainer createImport2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Import2Group_title);
		paletteContainer.setId("createImport2Group"); //$NON-NLS-1$
		paletteContainer.add(createImportModel1CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createNewBinaryMapping1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.NewBinaryMapping1CreationTool_title,
				Messages.NewBinaryMapping1CreationTool_desc,
				Collections.singletonList(MIDElementTypes.BinaryMappingReference_4003));
		entry.setId("createNewBinaryMapping1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.BinaryMappingReference_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNewNaryMapping2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.NewNaryMapping2CreationTool_title,
				Messages.NewNaryMapping2CreationTool_desc,
				Collections.singletonList(MIDElementTypes.MappingReference_2002));
		entry.setId("createNewNaryMapping2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.MappingReference_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createConnectModelElement3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.ConnectModelElement3CreationTool_title,
				Messages.ConnectModelElement3CreationTool_desc,
				Collections.singletonList(MIDElementTypes.ModelElementEndpointReference_4002));
		entry.setId("createConnectModelElement3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.ModelElementEndpointReference_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createImportModel1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ImportModel1CreationTool_title,
				Messages.ImportModel1CreationTool_desc,
				Collections.singletonList(MIDElementTypes.ModelEndpointReference_2001));
		entry.setId("createImportModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.ModelEndpointReference_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
