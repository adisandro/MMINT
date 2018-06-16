
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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultNodeToolEntry;

/**
 * @generated
 */
public class ICSE15_SequenceDiagram_MAVOPaletteFactory {

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
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createClass1CreationTool());
		paletteContainer.add(createLifeline2CreationTool());
		paletteContainer.add(createMessage3CreationTool());
		paletteContainer.add(createOperation4CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Connections" palette tool group
	* @generated
	*/
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createClassReference1CreationTool());
		paletteContainer.add(createOperationReference2CreationTool());
		paletteContainer.add(createSourceLifelineReference3CreationTool());
		paletteContainer.add(createTargetLifelineReference4CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createClass1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Class1CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Class1CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Class_2002));
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Class_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLifeline2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Lifeline2CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Lifeline2CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Lifeline_2001));
		entry.setId("createLifeline2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Lifeline_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createMessage3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Message3CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Message3CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Message_2003));
		entry.setId("createMessage3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Message_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createOperation4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Operation4CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.Operation4CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Operation_3001));
		entry.setId("createOperation4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Operation_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createClassReference1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.ClassReference1CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.ClassReference1CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.ClassReference_4001));
		entry.setId("createClassReference1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.ClassReference_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createOperationReference2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.OperationReference2CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.OperationReference2CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.OperationReference_4002));
		entry.setId("createOperationReference2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.OperationReference_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSourceLifelineReference3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.SourceLifelineReference3CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.SourceLifelineReference3CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.SourceLifelineReference_4003));
		entry.setId("createSourceLifelineReference3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.SourceLifelineReference_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTargetLifelineReference4CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.TargetLifelineReference4CreationTool_title,
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.TargetLifelineReference4CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.TargetLifelineReference_4004));
		entry.setId("createTargetLifelineReference4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.TargetLifelineReference_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
