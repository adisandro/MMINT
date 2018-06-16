
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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part;

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
public class ClassDiagram_MAVOPaletteFactory {

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
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createAttribute1CreationTool());
		paletteContainer.add(createClass2CreationTool());
		paletteContainer.add(createOperation3CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Connections" palette tool group
	* @generated
	*/
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createDependency2CreationTool());
		paletteContainer.add(createNestedInReference3CreationTool());
		paletteContainer.add(createSuperclassReference4CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createAttribute1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Attribute1CreationTool_title,
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Attribute1CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Attribute_3001));
		entry.setId("createAttribute1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Attribute_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createClass2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Class2CreationTool_title,
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Class2CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001));
		entry.setId("createClass2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createOperation3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Operation3CreationTool_title,
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Operation3CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Operation_3002));
		entry.setId("createOperation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Operation_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAssociation1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Association1CreationTool_title,
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Association1CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001));
		entry.setId("createAssociation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDependency2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Dependency2CreationTool_title,
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.Dependency2CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004));
		entry.setId("createDependency2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNestedInReference3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.NestedInReference3CreationTool_title,
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.NestedInReference3CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002));
		entry.setId("createNestedInReference3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSuperclassReference4CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.SuperclassReference4CreationTool_title,
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.Messages.SuperclassReference4CreationTool_desc,
				Collections.singletonList(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003));
		entry.setId("createSuperclassReference4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.getImageDescriptor(
								edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
