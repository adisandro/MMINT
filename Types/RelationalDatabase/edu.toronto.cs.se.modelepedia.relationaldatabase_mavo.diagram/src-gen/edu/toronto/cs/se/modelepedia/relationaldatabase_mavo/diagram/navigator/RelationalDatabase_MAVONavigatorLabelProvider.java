/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class RelationalDatabase_MAVONavigatorLabelProvider extends
		LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem
				&& !isOwnView(((edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorGroup) element;
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/RelationalDatabase_MAVO?TableColumnReference", edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.TableColumnReference_4001); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/RelationalDatabase_MAVO?Table", edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.Table_2001); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/RelationalDatabase_MAVO?ForeignKey", edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.ForeignKey_3002); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/RelationalDatabase_MAVO?Column", edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.Column_3001); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/RelationalDatabase_MAVO?ForeignColumnReference", edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.ForeignColumnReference_4002); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/RelationalDatabase_MAVO?RelationalDatabase", edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.RelationalDatabase_1000); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes
						.isKnownElementType(elementType)) {
			image = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes
					.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVONavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID:
			return getTableColumnReference_4001Text(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001Text(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002Text(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001Text(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID:
			return getForeignColumnReference_4002Text(view);
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			return getRelationalDatabase_1000Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getTableColumnReference_4001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.TableColumnReference_4001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTable_2001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.Table_2001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForeignKey_3002Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.ForeignKey_3002,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getColumn_3001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.Column_3001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForeignColumnReference_4002Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.ForeignColumnReference_4002,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRelationalDatabase_1000Text(View view) {
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase domainModelElement = (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isInc());
		} else {
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.MODEL_ID
				.equals(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
						.getModelID(view));
	}

}
