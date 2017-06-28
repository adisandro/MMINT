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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.structure.DiagramStructure;

import edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabase;
import edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ColumnNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyForeignColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyTableColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.RelationalDatabaseEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableTableColumnsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class RelationalDatabaseVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.relationaldatabase.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (RelationalDatabaseEditPart.MODEL_ID.equals(view.getType())) {
				return RelationalDatabaseEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				RelationalDatabaseDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (RelationalDatabasePackage.eINSTANCE.getRelationalDatabase()
				.isSuperTypeOf(domainElement.eClass())
				&& isDiagram((RelationalDatabase) domainElement)) {
			return RelationalDatabaseEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
				.getModelID(containerView);
		if (!RelationalDatabaseEditPart.MODEL_ID.equals(containerModelID)
				&& !"relationaldatabase".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (RelationalDatabaseEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RelationalDatabaseEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case RelationalDatabaseEditPart.VISUAL_ID:
			if (RelationalDatabasePackage.eINSTANCE.getTable().isSuperTypeOf(
					domainElement.eClass())) {
				return TableEditPart.VISUAL_ID;
			}
			break;
		case TableTableColumnsCompartmentEditPart.VISUAL_ID:
			if (RelationalDatabasePackage.eINSTANCE.getColumn().isSuperTypeOf(
					domainElement.eClass())) {
				return ColumnEditPart.VISUAL_ID;
			}
			break;
		case TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
			if (RelationalDatabasePackage.eINSTANCE.getForeignKey()
					.isSuperTypeOf(domainElement.eClass())) {
				return ForeignKeyEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
				.getModelID(containerView);
		if (!RelationalDatabaseEditPart.MODEL_ID.equals(containerModelID)
				&& !"relationaldatabase".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (RelationalDatabaseEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RelationalDatabaseEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case RelationalDatabaseEditPart.VISUAL_ID:
			if (TableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TableEditPart.VISUAL_ID:
			if (TableNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TableTableColumnsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TableTableForeignKeysCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ColumnEditPart.VISUAL_ID:
			if (ColumnNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForeignKeyEditPart.VISUAL_ID:
			if (ForeignKeyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TableTableColumnsCompartmentEditPart.VISUAL_ID:
			if (ColumnEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
			if (ForeignKeyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForeignKeyTableColumnEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForeignKeyForeignColumnEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(RelationalDatabase element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case TableTableColumnsCompartmentEditPart.VISUAL_ID:
		case TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case RelationalDatabaseEditPart.VISUAL_ID:
			return false;
		case ColumnEditPart.VISUAL_ID:
		case ForeignKeyEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
