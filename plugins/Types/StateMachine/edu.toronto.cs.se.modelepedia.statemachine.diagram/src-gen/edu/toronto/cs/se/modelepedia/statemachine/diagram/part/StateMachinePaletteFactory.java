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
package edu.toronto.cs.se.modelepedia.statemachine.diagram.part;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

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
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StateMachineElementTypes.FinalState_2002);
		types.add(StateMachineElementTypes.FinalState_3002);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.FinalState1CreationTool_title,
				Messages.FinalState1CreationTool_desc, types);
		entry.setId("createFinalState1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.FinalState_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitialState2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StateMachineElementTypes.InitialState_2001);
		types.add(StateMachineElementTypes.InitialState_3001);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.InitialState2CreationTool_title,
				Messages.InitialState2CreationTool_desc, types);
		entry.setId("createInitialState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.InitialState_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createState3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(StateMachineElementTypes.State_2003);
		types.add(StateMachineElementTypes.State_3003);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.State3CreationTool_title,
				Messages.State3CreationTool_desc, types);
		entry.setId("createState3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(StateMachineElementTypes
				.getImageDescriptor(StateMachineElementTypes.State_2003));
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
