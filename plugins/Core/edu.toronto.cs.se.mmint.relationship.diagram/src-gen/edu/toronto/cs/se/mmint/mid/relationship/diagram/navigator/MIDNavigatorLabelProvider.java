/*
* Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryMappingReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel17EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel21EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel25EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDParserProvider;

/**
 * @generated
 */
public class MIDNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		MIDDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		MIDDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof MIDNavigatorItem && !isOwnView(((MIDNavigatorItem) element).getView())) {
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
			return MIDDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
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
		case ModelRelEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelRel", //$NON-NLS-1$
					MIDElementTypes.ModelRel_1000);
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelEndpointReference", //$NON-NLS-1$
					MIDElementTypes.ModelEndpointReference_2001);
		case MappingReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?MappingReference", //$NON-NLS-1$
					MIDElementTypes.MappingReference_2002);
		case MappingReference2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?MappingReference", //$NON-NLS-1$
					MIDElementTypes.MappingReference_2003);
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelEndpointReference", //$NON-NLS-1$
					MIDElementTypes.ModelEndpointReference_2004);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementReference", //$NON-NLS-1$
					MIDElementTypes.ModelElementReference_3001);
		case ModelElementReference2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementReference", //$NON-NLS-1$
					MIDElementTypes.ModelElementReference_3002);
		case ModelElementReference3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementReference", //$NON-NLS-1$
					MIDElementTypes.ModelElementReference_3003);
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?ExtendibleElementReference?supertypeRef", //$NON-NLS-1$
					MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementEndpointReference", //$NON-NLS-1$
					MIDElementTypes.ModelElementEndpointReference_4002);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?BinaryMappingReference", //$NON-NLS-1$
					MIDElementTypes.BinaryMappingReference_4003);
		case BinaryMappingReference2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?BinaryMappingReference", //$NON-NLS-1$
					MIDElementTypes.BinaryMappingReference_4004);
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelElementEndpointReference", //$NON-NLS-1$
					MIDElementTypes.ModelElementEndpointReference_4005);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MIDDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && MIDElementTypes.isKnownElementType(elementType)) {
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
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_1000Text(view);
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return getModelEndpointReference_2001Text(view);
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2002Text(view);
		case MappingReference2EditPart.VISUAL_ID:
			return getMappingReference_2003Text(view);
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return getModelEndpointReference_2004Text(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3001Text(view);
		case ModelElementReference2EditPart.VISUAL_ID:
			return getModelElementReference_3002Text(view);
		case ModelElementReference3EditPart.VISUAL_ID:
			return getModelElementReference_3003Text(view);
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return getExtendibleElementReferenceSupertypeRef_4001Text(view);
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getModelElementEndpointReference_4002Text(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4003Text(view);
		case BinaryMappingReference2EditPart.VISUAL_ID:
			return getBinaryMappingReference_4004Text(view);
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getModelElementEndpointReference_4005Text(view);
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
			MIDDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getModelEndpointReference_2001Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.ModelEndpointReference_2001,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMappingReference_2002Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.MappingReference_2002,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMappingReference_2003Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.MappingReference_2003,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getModelEndpointReference_2004Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.ModelEndpointReference_2004,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel7EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getModelElementReference_3001Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.ModelElementReference_3001,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel9EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getModelElementReference_3002Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.ModelElementReference_3002,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel11EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getModelElementReference_3003Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.ModelElementReference_3003,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel13EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getExtendibleElementReferenceSupertypeRef_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getModelElementEndpointReference_4002Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.ModelElementEndpointReference_4002,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel15EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBinaryMappingReference_4003Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.BinaryMappingReference_4003,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel17EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBinaryMappingReference_4004Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.BinaryMappingReference_4004,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel21EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getModelElementEndpointReference_4005Text(View view) {
		IParser parser = MIDParserProvider.getParser(MIDElementTypes.ModelElementEndpointReference_4005,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel25EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6011); //$NON-NLS-1$
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
		return ModelRelEditPart.MODEL_ID.equals(MIDVisualIDRegistry.getModelID(view));
	}

}
