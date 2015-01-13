/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator;

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
public class NECSIS14_DatabaseSchemaNavigatorLabelProvider extends
		LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem
				&& !isOwnView(((edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem) element)
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
		if (element instanceof edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorGroup) {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorGroup group = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorGroup) element;
			return edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem) {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/NECSIS14_DatabaseSchema?DatabaseSchema", edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.DatabaseSchema_1000); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/NECSIS14_DatabaseSchema?Table", edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Table_2001); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/NECSIS14_DatabaseSchema?Column", edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Column_3001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes
						.isKnownElementType(elementType)) {
			image = edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes
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
		if (element instanceof edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorGroup) {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorGroup group = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem) {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.navigator.NECSIS14_DatabaseSchemaNavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.VISUAL_ID:
			return getDatabaseSchema_1000Text(view);
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return getTable_2001Text(view);
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return getColumn_3001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getDatabaseSchema_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTable_2001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Table_2001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getColumn_3001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Column_3001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
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
		return edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.MODEL_ID
				.equals(edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
						.getModelID(view));
	}

}
