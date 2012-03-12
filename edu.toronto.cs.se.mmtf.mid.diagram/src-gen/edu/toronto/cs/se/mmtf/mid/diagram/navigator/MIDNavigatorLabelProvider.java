/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.navigator;

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

import edu.toronto.cs.se.mmtf.mid.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDParserProvider;

/**
 * @generated
 */
public class MIDNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MIDDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		MIDDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof MIDNavigatorItem
				&& !isOwnView(((MIDNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof MIDNavigatorGroup) {
			MIDNavigatorGroup group = (MIDNavigatorGroup) element;
			return MIDDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof MIDNavigatorItem) {
			MIDNavigatorItem navigatorItem = (MIDNavigatorItem) element;
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
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MappingReferenceModelsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore?MappingReference?models", MIDElementTypes.MappingReferenceModels_4001); //$NON-NLS-1$
		case ModelReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore?ModelReference", MIDElementTypes.ModelReference_2002); //$NON-NLS-1$
		case MappingReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore?MappingReference", MIDElementTypes.MappingReference_2001); //$NON-NLS-1$
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore?BinaryMappingReference", MIDElementTypes.BinaryMappingReference_4002); //$NON-NLS-1$
		case MultiModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore?MultiModel", MIDElementTypes.MultiModel_1000); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MIDDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& MIDElementTypes.isKnownElementType(elementType)) {
			image = MIDElementTypes.getImage(elementType);
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
		if (element instanceof MIDNavigatorGroup) {
			MIDNavigatorGroup group = (MIDNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof MIDNavigatorItem) {
			MIDNavigatorItem navigatorItem = (MIDNavigatorItem) element;
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
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MappingReferenceModelsEditPart.VISUAL_ID:
			return getMappingReferenceModels_4001Text(view);
		case ModelReferenceEditPart.VISUAL_ID:
			return getModelReference_2002Text(view);
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2001Text(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4002Text(view);
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getBinaryMappingReference_4002Text(View view) {
		BinaryMappingReference domainModelElement = (BinaryMappingReference) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiModel_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getModelReference_2002Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.ModelReference_2002,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry
						.getType(ModelReferenceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMappingReference_2001Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.MappingReference_2001,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry
						.getType(MappingReferenceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMappingReferenceModels_4001Text(View view) {
		return ""; //$NON-NLS-1$
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
		return MultiModelEditPart.MODEL_ID.equals(MIDVisualIDRegistry
				.getModelID(view));
	}

}
