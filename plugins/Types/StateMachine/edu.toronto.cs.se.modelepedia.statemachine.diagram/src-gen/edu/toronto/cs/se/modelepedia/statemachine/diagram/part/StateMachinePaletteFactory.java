/*
 * Copyright Text ->
 * 
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
package edu.toronto.cs.se.modelepedia.statemachine.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultNodeToolEntry;

import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;

/**
 * @generated
 */
public class StateMachinePaletteFactory {

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
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createTransition1CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFinalState1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.FinalState1CreationTool_title,
				Messages.FinalState1CreationTool_desc,
				Collections
						.singletonList(StateMachineElementTypes.FinalState_2003));
		entry.setId("createFinalState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.FinalState_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitialState2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.InitialState2CreationTool_title,
				Messages.InitialState2CreationTool_desc,
				Collections
						.singletonList(StateMachineElementTypes.InitialState_2002));
		entry.setId("createInitialState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.InitialState_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createState3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.State3CreationTool_title,
				Messages.State3CreationTool_desc,
				Collections.singletonList(StateMachineElementTypes.State_2001));
		entry.setId("createState3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.State_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStateAction4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.StateAction4CreationTool_title,
				Messages.StateAction4CreationTool_desc,
				Collections
						.singletonList(StateMachineElementTypes.StateAction_3001));
		entry.setId("createStateAction4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.StateAction_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				Messages.Transition1CreationTool_title,
				Messages.Transition1CreationTool_desc,
				Collections
						.singletonList(StateMachineElementTypes.Transition_4001));
		entry.setId("createTransition1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.Transition_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
