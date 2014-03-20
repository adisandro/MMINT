/*
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.navigator;

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

import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryLinkReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryLinkReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.LinkReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.LinkReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MidDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MidElementTypes;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MidParserProvider;

/**
 * @generated
 */
public class MidNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MidDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		MidDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof MidNavigatorItem
				&& !isOwnView(((MidNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof MidNavigatorGroup) {
			MidNavigatorGroup group = (MidNavigatorGroup) element;
			return MidDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof MidNavigatorItem) {
			MidNavigatorItem navigatorItem = (MidNavigatorItem) element;
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
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelRelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelRel", MidElementTypes.ModelRel_1000); //$NON-NLS-1$
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelEndpointReference", MidElementTypes.ModelEndpointReference_2007); //$NON-NLS-1$
		case LinkReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?LinkReference", MidElementTypes.LinkReference_2008); //$NON-NLS-1$
		case LinkReference2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?LinkReference", MidElementTypes.LinkReference_2009); //$NON-NLS-1$
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelEndpointReference", MidElementTypes.ModelEndpointReference_2010); //$NON-NLS-1$
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementReference", MidElementTypes.ModelElementReference_3005); //$NON-NLS-1$
		case ModelElementReference2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementReference", MidElementTypes.ModelElementReference_3006); //$NON-NLS-1$
		case ModelElementReference3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementReference", MidElementTypes.ModelElementReference_3007); //$NON-NLS-1$
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?ExtendibleElementReference?supertypeRef", MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010); //$NON-NLS-1$
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementEndpointReference", MidElementTypes.ModelElementEndpointReference_4011); //$NON-NLS-1$
		case BinaryLinkReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?BinaryLinkReference", MidElementTypes.BinaryLinkReference_4012); //$NON-NLS-1$
		case BinaryLinkReference2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?BinaryLinkReference", MidElementTypes.BinaryLinkReference_4013); //$NON-NLS-1$
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementEndpointReference", MidElementTypes.ModelElementEndpointReference_4014); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MidDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& MidElementTypes.isKnownElementType(elementType)) {
			image = MidElementTypes.getImage(elementType);
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
		if (element instanceof MidNavigatorGroup) {
			MidNavigatorGroup group = (MidNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof MidNavigatorItem) {
			MidNavigatorItem navigatorItem = (MidNavigatorItem) element;
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
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_1000Text(view);
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return getModelEndpointReference_2007Text(view);
		case LinkReferenceEditPart.VISUAL_ID:
			return getLinkReference_2008Text(view);
		case LinkReference2EditPart.VISUAL_ID:
			return getLinkReference_2009Text(view);
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return getModelEndpointReference_2010Text(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3005Text(view);
		case ModelElementReference2EditPart.VISUAL_ID:
			return getModelElementReference_3006Text(view);
		case ModelElementReference3EditPart.VISUAL_ID:
			return getModelElementReference_3007Text(view);
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return getExtendibleElementReferenceSupertypeRef_4010Text(view);
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getModelElementEndpointReference_4011Text(view);
		case BinaryLinkReferenceEditPart.VISUAL_ID:
			return getBinaryLinkReference_4012Text(view);
		case BinaryLinkReference2EditPart.VISUAL_ID:
			return getBinaryLinkReference_4013Text(view);
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getModelElementEndpointReference_4014Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getModelRel_1000Text(View view) {
		ModelRel domainModelElement = (ModelRel) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelEndpointReference_2007Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelEndpointReference_2007,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBinaryLinkReference_4013Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.BinaryLinkReference_4013,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel12EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelElementEndpointReference_4011Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelElementEndpointReference_4011,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel8EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBinaryLinkReference_4012Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.BinaryLinkReference_4012,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel9EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelElementReference_3006Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelElementReference_3006,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelElementReference_3005Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelElementReference_3005,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLinkReference_2008Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.LinkReference_2008,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtendibleElementReferenceSupertypeRef_4010Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getModelElementReference_3007Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelElementReference_3007,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel7EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelEndpointReference_2010Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelEndpointReference_2010,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLinkReference_2009Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.LinkReference_2009,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelElementEndpointReference_4014Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelElementEndpointReference_4014,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(WrappingLabel15EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6014); //$NON-NLS-1$
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
		return ModelRelEditPart.MODEL_ID.equals(MidVisualIDRegistry
				.getModelID(view));
	}

}
