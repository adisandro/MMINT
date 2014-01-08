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
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.modelepedia.powerwindow.diagram.providers.PowerWindowElementTypes;

/**
 * @generated
 */
public class PowerWindowPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createControls1Group());
	}

	/**
	 * Creates "Controls" palette tool group
	 * @generated
	 */
	private PaletteContainer createControls1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Controls1Group_title);
		paletteContainer.setId("createControls1Group"); //$NON-NLS-1$
		paletteContainer.add(createInfraredsensor1CreationTool());
		paletteContainer.add(createForceDetectingsensor2CreationTool());
		paletteContainer.add(createLockOutswitch3CreationTool());
		paletteContainer.add(createRockerswitch4CreationTool());
		paletteContainer.add(createPushPullswitch5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInfraredsensor1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Infraredsensor1CreationTool_title,
				Messages.Infraredsensor1CreationTool_desc,
				Collections
						.singletonList(PowerWindowElementTypes.Infrared_2013));
		entry.setId("createInfraredsensor1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PowerWindowElementTypes
				.getImageDescriptor(PowerWindowElementTypes.Infrared_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForceDetectingsensor2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ForceDetectingsensor2CreationTool_title,
				Messages.ForceDetectingsensor2CreationTool_desc,
				Collections
						.singletonList(PowerWindowElementTypes.ForceDetecting_2015));
		entry.setId("createForceDetectingsensor2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PowerWindowElementTypes
				.getImageDescriptor(PowerWindowElementTypes.ForceDetecting_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLockOutswitch3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LockOutswitch3CreationTool_title,
				Messages.LockOutswitch3CreationTool_desc,
				Collections.singletonList(PowerWindowElementTypes.LockOut_2014));
		entry.setId("createLockOutswitch3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PowerWindowElementTypes
				.getImageDescriptor(PowerWindowElementTypes.LockOut_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRockerswitch4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Rockerswitch4CreationTool_title,
				Messages.Rockerswitch4CreationTool_desc,
				Collections.singletonList(PowerWindowElementTypes.Rocker_2012));
		entry.setId("createRockerswitch4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PowerWindowElementTypes
				.getImageDescriptor(PowerWindowElementTypes.Rocker_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPushPullswitch5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PushPullswitch5CreationTool_title,
				Messages.PushPullswitch5CreationTool_desc,
				Collections
						.singletonList(PowerWindowElementTypes.PushPull_2011));
		entry.setId("createPushPullswitch5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PowerWindowElementTypes
				.getImageDescriptor(PowerWindowElementTypes.PushPull_2011));
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
