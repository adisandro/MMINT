
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
package edu.toronto.cs.se.mmint.mid.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultNodeToolEntry;

import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;

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
		paletteContainer.add(createNewModel1CreationTool());
		paletteContainer.add(createNewBinaryRel2CreationTool());
		paletteContainer.add(createNewNaryRel3CreationTool());
		paletteContainer.add(createConnectModel4CreationTool());
		paletteContainer.add(createNewOperator5CreationTool());
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
		paletteContainer.add(createImportNaryRel2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewModel1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
			Messages.NewModel1CreationTool_title,
			Messages.NewModel1CreationTool_desc,
			Collections.singletonList(MIDElementTypes.Model_2001));
		entry.setId("createNewModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.Model_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewBinaryRel2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
			Messages.NewBinaryRel2CreationTool_title,
			Messages.NewBinaryRel2CreationTool_desc,
			Collections.singletonList(MIDElementTypes.BinaryModelRel_4003));
		entry.setId("createNewBinaryRel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.BinaryModelRel_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewNaryRel3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
			Messages.NewNaryRel3CreationTool_title,
			Messages.NewNaryRel3CreationTool_desc,
			Collections.singletonList(MIDElementTypes.ModelRel_2003));
		entry.setId("createNewNaryRel3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.ModelRel_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnectModel4CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
			Messages.ConnectModel4CreationTool_title,
			Messages.ConnectModel4CreationTool_desc,
			Collections.singletonList(MIDElementTypes.ModelEndpoint_4002));
		entry.setId("createConnectModel4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.ModelEndpoint_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNewOperator5CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
			Messages.NewOperator5CreationTool_title,
			Messages.NewOperator5CreationTool_desc,
			Collections.singletonList(MIDElementTypes.Operator_2005));
		entry.setId("createNewOperator5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.Operator_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImportModel1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
			Messages.ImportModel1CreationTool_title,
			Messages.ImportModel1CreationTool_desc,
			Collections.singletonList(MIDElementTypes.Model_2002));
		entry.setId("createImportModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.Model_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImportNaryRel2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
			Messages.ImportNaryRel2CreationTool_title,
			Messages.ImportNaryRel2CreationTool_desc,
			Collections.singletonList(MIDElementTypes.ModelRel_2004));
		entry.setId("createImportNaryRel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes.getImageDescriptor(MIDElementTypes.ModelRel_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
