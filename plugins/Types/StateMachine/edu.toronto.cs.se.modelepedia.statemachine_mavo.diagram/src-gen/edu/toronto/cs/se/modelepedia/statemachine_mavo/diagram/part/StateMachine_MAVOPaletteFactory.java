
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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part;

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
public class StateMachine_MAVOPaletteFactory {

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
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createFinalState1CreationTool());
		paletteContainer.add(createInitialState2CreationTool());
		paletteContainer.add(createState3CreationTool());
		paletteContainer.add(createStateAction4CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Connections" palette tool group
	* @generated
	*/
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createTransition1CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createFinalState1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.FinalState1CreationTool_title,
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.FinalState1CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.FinalState_2003));
		entry.setId("createFinalState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.FinalState_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createInitialState2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.InitialState2CreationTool_title,
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.InitialState2CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.InitialState_2002));
		entry.setId("createInitialState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.InitialState_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createState3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.State3CreationTool_title,
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.State3CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_2001));
		entry.setId("createState3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createStateAction4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.StateAction4CreationTool_title,
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.StateAction4CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.StateAction_3001));
		entry.setId("createStateAction4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.StateAction_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTransition1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.Transition1CreationTool_title,
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.Messages.Transition1CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001));
		entry.setId("createTransition1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
