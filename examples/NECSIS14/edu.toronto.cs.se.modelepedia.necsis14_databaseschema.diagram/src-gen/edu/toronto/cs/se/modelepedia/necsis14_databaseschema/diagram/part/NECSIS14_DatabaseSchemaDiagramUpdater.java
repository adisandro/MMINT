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
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class NECSIS14_DatabaseSchemaDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.VISUAL_ID:
			return getDatabaseSchema_1000SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID:
			return getTableTableColumnsCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor> getDatabaseSchema_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.necsis14_databaseschema.DatabaseSchema modelElement = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.DatabaseSchema) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTables().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Table childElement = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Table) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor> getTableTableColumnsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Table modelElement = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Table) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor>();
		for (Iterator<?> it = modelElement.getColumns().iterator(); it
				.hasNext();) {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Column childElement = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Column) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.VISUAL_ID:
			return getDatabaseSchema_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getDatabaseSchema_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getTable_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getColumn_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getTable_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getColumn_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getTable_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getColumn_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaNodeDescriptor> getSemanticChildren(
				View view) {
			return NECSIS14_DatabaseSchemaDiagramUpdater
					.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getContainedLinks(
				View view) {
			return NECSIS14_DatabaseSchemaDiagramUpdater
					.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getIncomingLinks(
				View view) {
			return NECSIS14_DatabaseSchemaDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaLinkDescriptor> getOutgoingLinks(
				View view) {
			return NECSIS14_DatabaseSchemaDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
