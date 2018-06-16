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

/**
 * @generated
 */
public class RelationalDatabase_MAVODiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			return getRelationalDatabase_1000SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID:
			return getTableTableColumnsCompartment_7001SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
			return getTableTableForeignKeysCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> getRelationalDatabase_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase modelElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getTables().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table childElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> getTableTableColumnsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table modelElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getColumns().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column childElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> getTableTableForeignKeysCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table modelElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getForeignKeys().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey childElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			return getRelationalDatabase_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID:
			return getTableColumnReference_4001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID:
			return getForeignColumnReference_4002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID:
			return getTableColumnReference_4001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID:
			return getForeignColumnReference_4002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID:
			return getTableColumnReference_4001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID:
			return getForeignColumnReference_4002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getRelationalDatabase_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getTable_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getColumn_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getForeignKey_3002ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey modelElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_TableColumnReference_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ForeignColumnReference_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getTableColumnReference_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getForeignColumnReference_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getTable_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getColumn_3001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column modelElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_TableColumnReference_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ForeignColumnReference_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getForeignKey_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getTableColumnReference_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getForeignColumnReference_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getTable_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getColumn_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getForeignKey_3002OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey modelElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_TableColumnReference_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ForeignColumnReference_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getTableColumnReference_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getForeignColumnReference_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_TableColumnReference_4001(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey container) {
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getTableColumn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference link = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.TableColumnReference_4001,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_ForeignColumnReference_4002(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey container) {
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getForeignColumn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference link = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.ForeignColumnReference_4002,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_TableColumnReference_4001(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getTableColumnReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference link = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor(
							src, target, link,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.TableColumnReference_4001,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_ForeignColumnReference_4002(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getForeignColumnReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference link = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor(
							src, target, link,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.ForeignColumnReference_4002,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_TableColumnReference_4001(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey source) {
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey) {
				container = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getTableColumn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference link = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(
					new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.TableColumnReference_4001,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_ForeignColumnReference_4002(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey source) {
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey) {
				container = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getForeignColumn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference link = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(
					new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.ForeignColumnReference_4002,
							edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID));
		}
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

		public List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVONodeDescriptor> getSemanticChildren(
				View view) {
			return RelationalDatabase_MAVODiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getContainedLinks(
				View view) {
			return RelationalDatabase_MAVODiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getIncomingLinks(
				View view) {
			return RelationalDatabase_MAVODiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOLinkDescriptor> getOutgoingLinks(
				View view) {
			return RelationalDatabase_MAVODiagramUpdater.getOutgoingLinks(view);
		}
	};

}
