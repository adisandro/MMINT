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
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update.DiagramUpdater;

import edu.toronto.cs.se.modelepedia.relationaldatabase.Column;
import edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey;
import edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabase;
import edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage;
import edu.toronto.cs.se.modelepedia.relationaldatabase.Table;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyForeignColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyTableColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.RelationalDatabaseEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableTableColumnsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers.RelationalDatabaseElementTypes;

/**
 * @generated
 */
public class RelationalDatabaseDiagramUpdater {

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
	public static List<RelationalDatabaseNodeDescriptor> getSemanticChildren(
			View view) {
		switch (RelationalDatabaseVisualIDRegistry.getVisualID(view)) {
		case RelationalDatabaseEditPart.VISUAL_ID:
			return getRelationalDatabase_1000SemanticChildren(view);
		case TableTableColumnsCompartmentEditPart.VISUAL_ID:
			return getTableTableColumnsCompartment_7001SemanticChildren(view);
		case TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
			return getTableTableForeignKeysCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseNodeDescriptor> getRelationalDatabase_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RelationalDatabase modelElement = (RelationalDatabase) view
				.getElement();
		LinkedList<RelationalDatabaseNodeDescriptor> result = new LinkedList<RelationalDatabaseNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTables().iterator(); it.hasNext();) {
			Table childElement = (Table) it.next();
			int visualID = RelationalDatabaseVisualIDRegistry.getNodeVisualID(
					view, childElement);
			if (visualID == TableEditPart.VISUAL_ID) {
				result.add(new RelationalDatabaseNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseNodeDescriptor> getTableTableColumnsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Table modelElement = (Table) containerView.getElement();
		LinkedList<RelationalDatabaseNodeDescriptor> result = new LinkedList<RelationalDatabaseNodeDescriptor>();
		for (Iterator<?> it = modelElement.getColumns().iterator(); it
				.hasNext();) {
			Column childElement = (Column) it.next();
			int visualID = RelationalDatabaseVisualIDRegistry.getNodeVisualID(
					view, childElement);
			if (visualID == ColumnEditPart.VISUAL_ID) {
				result.add(new RelationalDatabaseNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseNodeDescriptor> getTableTableForeignKeysCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Table modelElement = (Table) containerView.getElement();
		LinkedList<RelationalDatabaseNodeDescriptor> result = new LinkedList<RelationalDatabaseNodeDescriptor>();
		for (Iterator<?> it = modelElement.getForeignKeys().iterator(); it
				.hasNext();) {
			ForeignKey childElement = (ForeignKey) it.next();
			int visualID = RelationalDatabaseVisualIDRegistry.getNodeVisualID(
					view, childElement);
			if (visualID == ForeignKeyEditPart.VISUAL_ID) {
				result.add(new RelationalDatabaseNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getContainedLinks(
			View view) {
		switch (RelationalDatabaseVisualIDRegistry.getVisualID(view)) {
		case RelationalDatabaseEditPart.VISUAL_ID:
			return getRelationalDatabase_1000ContainedLinks(view);
		case TableEditPart.VISUAL_ID:
			return getTable_2001ContainedLinks(view);
		case ColumnEditPart.VISUAL_ID:
			return getColumn_3001ContainedLinks(view);
		case ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getIncomingLinks(
			View view) {
		switch (RelationalDatabaseVisualIDRegistry.getVisualID(view)) {
		case TableEditPart.VISUAL_ID:
			return getTable_2001IncomingLinks(view);
		case ColumnEditPart.VISUAL_ID:
			return getColumn_3001IncomingLinks(view);
		case ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (RelationalDatabaseVisualIDRegistry.getVisualID(view)) {
		case TableEditPart.VISUAL_ID:
			return getTable_2001OutgoingLinks(view);
		case ColumnEditPart.VISUAL_ID:
			return getColumn_3001OutgoingLinks(view);
		case ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getRelationalDatabase_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getTable_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getColumn_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getForeignKey_3002ContainedLinks(
			View view) {
		ForeignKey modelElement = (ForeignKey) view.getElement();
		LinkedList<RelationalDatabaseLinkDescriptor> result = new LinkedList<RelationalDatabaseLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ForeignKey_TableColumn_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ForeignKey_ForeignColumn_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getTable_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getColumn_3001IncomingLinks(
			View view) {
		Column modelElement = (Column) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<RelationalDatabaseLinkDescriptor> result = new LinkedList<RelationalDatabaseLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ForeignKey_TableColumn_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ForeignKey_ForeignColumn_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getForeignKey_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getTable_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getColumn_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RelationalDatabaseLinkDescriptor> getForeignKey_3002OutgoingLinks(
			View view) {
		ForeignKey modelElement = (ForeignKey) view.getElement();
		LinkedList<RelationalDatabaseLinkDescriptor> result = new LinkedList<RelationalDatabaseLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ForeignKey_TableColumn_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ForeignKey_ForeignColumn_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RelationalDatabaseLinkDescriptor> getIncomingFeatureModelFacetLinks_ForeignKey_TableColumn_4001(
			Column target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RelationalDatabaseLinkDescriptor> result = new LinkedList<RelationalDatabaseLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RelationalDatabasePackage.eINSTANCE
					.getForeignKey_TableColumn()) {
				result.add(new RelationalDatabaseLinkDescriptor(
						setting.getEObject(),
						target,
						RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001,
						ForeignKeyTableColumnEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RelationalDatabaseLinkDescriptor> getIncomingFeatureModelFacetLinks_ForeignKey_ForeignColumn_4002(
			Column target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<RelationalDatabaseLinkDescriptor> result = new LinkedList<RelationalDatabaseLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RelationalDatabasePackage.eINSTANCE
					.getForeignKey_ForeignColumn()) {
				result.add(new RelationalDatabaseLinkDescriptor(
						setting.getEObject(),
						target,
						RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002,
						ForeignKeyForeignColumnEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RelationalDatabaseLinkDescriptor> getOutgoingFeatureModelFacetLinks_ForeignKey_TableColumn_4001(
			ForeignKey source) {
		LinkedList<RelationalDatabaseLinkDescriptor> result = new LinkedList<RelationalDatabaseLinkDescriptor>();
		Column destination = source.getTableColumn();
		if (destination == null) {
			return result;
		}
		result.add(new RelationalDatabaseLinkDescriptor(source, destination,
				RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001,
				ForeignKeyTableColumnEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<RelationalDatabaseLinkDescriptor> getOutgoingFeatureModelFacetLinks_ForeignKey_ForeignColumn_4002(
			ForeignKey source) {
		LinkedList<RelationalDatabaseLinkDescriptor> result = new LinkedList<RelationalDatabaseLinkDescriptor>();
		Column destination = source.getForeignColumn();
		if (destination == null) {
			return result;
		}
		result.add(new RelationalDatabaseLinkDescriptor(source, destination,
				RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002,
				ForeignKeyForeignColumnEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<RelationalDatabaseNodeDescriptor> getSemanticChildren(
				View view) {
			return RelationalDatabaseDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<RelationalDatabaseLinkDescriptor> getContainedLinks(
				View view) {
			return RelationalDatabaseDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<RelationalDatabaseLinkDescriptor> getIncomingLinks(View view) {
			return RelationalDatabaseDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<RelationalDatabaseLinkDescriptor> getOutgoingLinks(View view) {
			return RelationalDatabaseDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
