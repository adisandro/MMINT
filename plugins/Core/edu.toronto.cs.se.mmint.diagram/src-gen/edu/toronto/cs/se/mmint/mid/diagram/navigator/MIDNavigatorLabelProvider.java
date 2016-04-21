/*
* Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.mmint.mid.diagram.navigator;

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

import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointName2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointNameEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDParserProvider;

/**
 * @generated
 */
public class MIDNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MIDDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?UnknownElement", //$NON-NLS-1$
			ImageDescriptor.getMissingImageDescriptor());
		MIDDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?ImageNotFound", //$NON-NLS-1$
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
			case MIDEditPart.VISUAL_ID:
				return getImage("Navigator?Diagram?http://se.cs.toronto.edu/mmint/MID?MID", MIDElementTypes.MID_1000); //$NON-NLS-1$
			case ModelEditPart.VISUAL_ID:
				return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID?Model", //$NON-NLS-1$
					MIDElementTypes.Model_2001);
			case Model2EditPart.VISUAL_ID:
				return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID?Model", //$NON-NLS-1$
					MIDElementTypes.Model_2002);
			case ModelRelEditPart.VISUAL_ID:
				return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelRel", //$NON-NLS-1$
					MIDElementTypes.ModelRel_2003);
			case ModelRel2EditPart.VISUAL_ID:
				return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelRel", //$NON-NLS-1$
					MIDElementTypes.ModelRel_2004);
			case OperatorEditPart.VISUAL_ID:
				return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Operator?Operator", //$NON-NLS-1$
					MIDElementTypes.Operator_2005);
			case ExtendibleElementSupertypeEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID?ExtendibleElement?supertype", //$NON-NLS-1$
					MIDElementTypes.ExtendibleElementSupertype_4001);
			case ModelEndpointEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID?ModelEndpoint", //$NON-NLS-1$
					MIDElementTypes.ModelEndpoint_4002);
			case BinaryModelRelEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?BinaryModelRel", //$NON-NLS-1$
					MIDElementTypes.BinaryModelRel_4003);
			case ModelEndpoint2EditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID?ModelEndpoint", //$NON-NLS-1$
					MIDElementTypes.ModelEndpoint_4004);
			case ModelEndpoint3EditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID?ModelEndpoint", //$NON-NLS-1$
					MIDElementTypes.ModelEndpoint_4005);
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
			case MIDEditPart.VISUAL_ID:
				return getMID_1000Text(view);
			case ModelEditPart.VISUAL_ID:
				return getModel_2001Text(view);
			case Model2EditPart.VISUAL_ID:
				return getModel_2002Text(view);
			case ModelRelEditPart.VISUAL_ID:
				return getModelRel_2003Text(view);
			case ModelRel2EditPart.VISUAL_ID:
				return getModelRel_2004Text(view);
			case OperatorEditPart.VISUAL_ID:
				return getOperator_2005Text(view);
			case ExtendibleElementSupertypeEditPart.VISUAL_ID:
				return getExtendibleElementSupertype_4001Text(view);
			case ModelEndpointEditPart.VISUAL_ID:
				return getModelEndpoint_4002Text(view);
			case BinaryModelRelEditPart.VISUAL_ID:
				return getBinaryModelRel_4003Text(view);
			case ModelEndpoint2EditPart.VISUAL_ID:
				return getModelEndpoint_4004Text(view);
			case ModelEndpoint3EditPart.VISUAL_ID:
				return getModelEndpoint_4005Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMID_1000Text(View view) {
		edu.toronto.cs.se.mmint.mid.MID domainModelElement = (edu.toronto.cs.se.mmint.mid.MID) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getLevel());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_2001Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.Model_2001,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_2002Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.Model_2002,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelRel_2003Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.ModelRel_2003,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelRel_2004Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.ModelRel_2004,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(WrappingLabel7EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperator_2005Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.Operator_2005,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(WrappingLabel9EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtendibleElementSupertype_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getModelEndpoint_4002Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.ModelEndpoint_4002,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(WrappingLabel10EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBinaryModelRel_4003Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.BinaryModelRel_4003,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(WrappingLabel12EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelEndpoint_4004Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.ModelEndpoint_4004,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(ModelEndpointNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelEndpoint_4005Text(View view) {
		IParser parser = MIDParserProvider.getParser(
			MIDElementTypes.ModelEndpoint_4005,
			view.getElement() != null ? view.getElement() : view,
			MIDVisualIDRegistry.getType(ModelEndpointName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			MIDDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6008); //$NON-NLS-1$
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
		return MIDEditPart.MODEL_ID.equals(MIDVisualIDRegistry.getModelID(view));
	}

}
