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

import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Parameter2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ParameterEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ParameterName2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ParameterNameEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDParserProvider;

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
		case MultiModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/mmint/MID?MultiModel", MIDElementTypes.MultiModel_1000); //$NON-NLS-1$
		case ModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID?Model", MIDElementTypes.Model_2011); //$NON-NLS-1$
		case Model2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID?Model", MIDElementTypes.Model_2012); //$NON-NLS-1$
		case ModelRelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelRel", MIDElementTypes.ModelRel_2013); //$NON-NLS-1$
		case ModelRel2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Relationship?ModelRel", MIDElementTypes.ModelRel_2014); //$NON-NLS-1$
		case OperatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/mmint/MID/Operator?Operator", MIDElementTypes.Operator_2015); //$NON-NLS-1$
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID?ExtendibleElement?supertype", MIDElementTypes.ExtendibleElementSupertype_4013); //$NON-NLS-1$
		case ModelEndpointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID?ModelEndpoint", MIDElementTypes.ModelEndpoint_4014); //$NON-NLS-1$
		case BinaryModelRelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Relationship?BinaryModelRel", MIDElementTypes.BinaryModelRel_4015); //$NON-NLS-1$
		case ParameterEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Operator?Parameter", MIDElementTypes.Parameter_4016); //$NON-NLS-1$
		case Parameter2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/mmint/MID/Operator?Parameter", MIDElementTypes.Parameter_4017); //$NON-NLS-1$
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
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000Text(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_2011Text(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2012Text(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2013Text(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2014Text(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2015Text(view);
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return getExtendibleElementSupertype_4013Text(view);
		case ModelEndpointEditPart.VISUAL_ID:
			return getModelEndpoint_4014Text(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4015Text(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_4016Text(view);
		case Parameter2EditPart.VISUAL_ID:
			return getParameter_4017Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMultiModel_1000Text(View view) {
		MultiModel domainModelElement = (MultiModel) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isInc());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_2011Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.Model_2011,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_2012Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.Model_2012,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelRel_2013Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.ModelRel_2013,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelRel_2014Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.ModelRel_2014,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperator_2015Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.Operator_2015,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtendibleElementSupertype_4013Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getModelEndpoint_4014Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.ModelEndpoint_4014,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBinaryModelRel_4015Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.BinaryModelRel_4015,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(WrappingLabel7EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getParameter_4016Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.Parameter_4016,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(ParameterNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getParameter_4017Text(View view) {
		IParser parser = MIDParserProvider.getParser(
				MIDElementTypes.Parameter_4017,
				view.getElement() != null ? view.getElement() : view,
				MIDVisualIDRegistry.getType(ParameterName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MIDDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6016); //$NON-NLS-1$
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
		return MultiModelEditPart.MODEL_ID.equals(MIDVisualIDRegistry
				.getModelID(view));
	}

}
