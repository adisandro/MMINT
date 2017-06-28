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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class RelationalDatabase_MAVOVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.MODEL_ID
					.equals(view.getType())) {
				return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
						.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
		if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
				.getRelationalDatabase().isSuperTypeOf(domainElement.eClass())
				&& isDiagram(
						(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase) domainElement)) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getModelID(containerView);
		if (!edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.MODEL_ID
				.equals(containerModelID) && !"relationaldatabase_mavo".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
					.getTable().isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
					.getColumn().isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
					.getForeignKey().isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getModelID(containerView);
		if (!edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.MODEL_ID
				.equals(containerModelID) && !"relationaldatabase_mavo".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
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
		if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
				.getTableColumnReference().isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID;
		}
		if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
				.getForeignColumnReference().isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
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
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
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
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			return false;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
