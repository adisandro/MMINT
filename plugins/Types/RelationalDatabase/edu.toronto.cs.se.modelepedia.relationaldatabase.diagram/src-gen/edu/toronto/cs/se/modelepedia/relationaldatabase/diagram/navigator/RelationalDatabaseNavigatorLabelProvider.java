/*
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
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

import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ColumnNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyForeignColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyTableColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.RelationalDatabaseEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseDiagramEditorPlugin;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers.RelationalDatabaseElementTypes;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers.RelationalDatabaseParserProvider;

/**
 * @generated
 */
public class RelationalDatabaseNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		RelationalDatabaseDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		RelationalDatabaseDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof RelationalDatabaseNavigatorItem
				&& !isOwnView(((RelationalDatabaseNavigatorItem) element)
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
		if (element instanceof RelationalDatabaseNavigatorGroup) {
			RelationalDatabaseNavigatorGroup group = (RelationalDatabaseNavigatorGroup) element;
			return RelationalDatabaseDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof RelationalDatabaseNavigatorItem) {
			RelationalDatabaseNavigatorItem navigatorItem = (RelationalDatabaseNavigatorItem) element;
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
		switch (RelationalDatabaseVisualIDRegistry.getVisualID(view)) {
		case ForeignKeyTableColumnEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/RelationalDatabase?ForeignKey?tableColumn", RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001); //$NON-NLS-1$
		case ColumnEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/RelationalDatabase?Column", RelationalDatabaseElementTypes.Column_3001); //$NON-NLS-1$
		case ForeignKeyForeignColumnEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/RelationalDatabase?ForeignKey?foreignColumn", RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002); //$NON-NLS-1$
		case RelationalDatabaseEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/RelationalDatabase?RelationalDatabase", RelationalDatabaseElementTypes.RelationalDatabase_1000); //$NON-NLS-1$
		case ForeignKeyEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/RelationalDatabase?ForeignKey", RelationalDatabaseElementTypes.ForeignKey_3002); //$NON-NLS-1$
		case TableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/RelationalDatabase?Table", RelationalDatabaseElementTypes.Table_2001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = RelationalDatabaseDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& RelationalDatabaseElementTypes
						.isKnownElementType(elementType)) {
			image = RelationalDatabaseElementTypes.getImage(elementType);
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
		if (element instanceof RelationalDatabaseNavigatorGroup) {
			RelationalDatabaseNavigatorGroup group = (RelationalDatabaseNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof RelationalDatabaseNavigatorItem) {
			RelationalDatabaseNavigatorItem navigatorItem = (RelationalDatabaseNavigatorItem) element;
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
		switch (RelationalDatabaseVisualIDRegistry.getVisualID(view)) {
		case ForeignKeyTableColumnEditPart.VISUAL_ID:
			return getForeignKeyTableColumn_4001Text(view);
		case ColumnEditPart.VISUAL_ID:
			return getColumn_3001Text(view);
		case ForeignKeyForeignColumnEditPart.VISUAL_ID:
			return getForeignKeyForeignColumn_4002Text(view);
		case RelationalDatabaseEditPart.VISUAL_ID:
			return getRelationalDatabase_1000Text(view);
		case ForeignKeyEditPart.VISUAL_ID:
			return getForeignKey_3002Text(view);
		case TableEditPart.VISUAL_ID:
			return getTable_2001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getForeignKeyTableColumn_4001Text(View view) {
		IParser parser = RelationalDatabaseParserProvider.getParser(
				RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RelationalDatabaseDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getColumn_3001Text(View view) {
		IParser parser = RelationalDatabaseParserProvider.getParser(
				RelationalDatabaseElementTypes.Column_3001,
				view.getElement() != null ? view.getElement() : view,
				RelationalDatabaseVisualIDRegistry
						.getType(ColumnNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RelationalDatabaseDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForeignKeyForeignColumn_4002Text(View view) {
		IParser parser = RelationalDatabaseParserProvider.getParser(
				RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RelationalDatabaseDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRelationalDatabase_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getForeignKey_3002Text(View view) {
		IParser parser = RelationalDatabaseParserProvider.getParser(
				RelationalDatabaseElementTypes.ForeignKey_3002, view
						.getElement() != null ? view.getElement() : view,
				RelationalDatabaseVisualIDRegistry
						.getType(ForeignKeyNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RelationalDatabaseDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTable_2001Text(View view) {
		IParser parser = RelationalDatabaseParserProvider.getParser(
				RelationalDatabaseElementTypes.Table_2001,
				view.getElement() != null ? view.getElement() : view,
				RelationalDatabaseVisualIDRegistry
						.getType(TableNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RelationalDatabaseDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
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
		return RelationalDatabaseEditPart.MODEL_ID
				.equals(RelationalDatabaseVisualIDRegistry.getModelID(view));
	}

}
