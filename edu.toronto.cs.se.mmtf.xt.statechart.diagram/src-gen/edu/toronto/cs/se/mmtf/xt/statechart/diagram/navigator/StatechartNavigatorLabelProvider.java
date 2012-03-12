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
package edu.toronto.cs.se.mmtf.xt.statechart.diagram.navigator;

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

import edu.toronto.cs.se.mmtf.xt.statechart.SuperState;
import edu.toronto.cs.se.mmtf.xt.statechart.Transition;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.State2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateName2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateNameEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState3EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateName2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateNameEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartVisualIDRegistry;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.providers.StatechartElementTypes;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.providers.StatechartParserProvider;

/**
 * @generated
 */
public class StatechartNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		StatechartDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		StatechartDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof StatechartNavigatorItem
				&& !isOwnView(((StatechartNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof StatechartNavigatorGroup) {
			StatechartNavigatorGroup group = (StatechartNavigatorGroup) element;
			return StatechartDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof StatechartNavigatorItem) {
			StatechartNavigatorItem navigatorItem = (StatechartNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (StatechartVisualIDRegistry.getVisualID(view)) {
		case State2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///edu/toronto/cs/se/mmtf/xt/statechart/model/statechart.ecore?State", StatechartElementTypes.State_3001); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/xt/statechart/model/statechart.ecore?State", StatechartElementTypes.State_2002); //$NON-NLS-1$
		case SuperState3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///edu/toronto/cs/se/mmtf/xt/statechart/model/statechart.ecore?SuperState", StatechartElementTypes.SuperState_3002); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/xt/statechart/model/statechart.ecore?Transition", StatechartElementTypes.Transition_4001); //$NON-NLS-1$
		case SuperState2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/xt/statechart/model/statechart.ecore?SuperState", StatechartElementTypes.SuperState_2001); //$NON-NLS-1$
		case SuperStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///edu/toronto/cs/se/mmtf/xt/statechart/model/statechart.ecore?SuperState", StatechartElementTypes.SuperState_1000); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = StatechartDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& StatechartElementTypes.isKnownElementType(elementType)) {
			image = StatechartElementTypes.getImage(elementType);
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
		if (element instanceof StatechartNavigatorGroup) {
			StatechartNavigatorGroup group = (StatechartNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof StatechartNavigatorItem) {
			StatechartNavigatorItem navigatorItem = (StatechartNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
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
		switch (StatechartVisualIDRegistry.getVisualID(view)) {
		case State2EditPart.VISUAL_ID:
			return getState_3001Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002Text(view);
		case SuperState3EditPart.VISUAL_ID:
			return getSuperState_3002Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		case SuperState2EditPart.VISUAL_ID:
			return getSuperState_2001Text(view);
		case SuperStateEditPart.VISUAL_ID:
			return getSuperState_1000Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getState_3001Text(View view) {
		IParser parser = StatechartParserProvider.getParser(
				StatechartElementTypes.State_3001,
				view.getElement() != null ? view.getElement() : view,
				StatechartVisualIDRegistry
						.getType(StateName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatechartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2002Text(View view) {
		IParser parser = StatechartParserProvider
				.getParser(StatechartElementTypes.State_2002,
						view.getElement() != null ? view.getElement() : view,
						StatechartVisualIDRegistry
								.getType(StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatechartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSuperState_3002Text(View view) {
		IParser parser = StatechartParserProvider.getParser(
				StatechartElementTypes.SuperState_3002,
				view.getElement() != null ? view.getElement() : view,
				StatechartVisualIDRegistry
						.getType(SuperStateName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatechartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		Transition domainModelElement = (Transition) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatechartDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSuperState_2001Text(View view) {
		IParser parser = StatechartParserProvider.getParser(
				StatechartElementTypes.SuperState_2001,
				view.getElement() != null ? view.getElement() : view,
				StatechartVisualIDRegistry
						.getType(SuperStateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatechartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSuperState_1000Text(View view) {
		SuperState domainModelElement = (SuperState) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatechartDiagramEditorPlugin.getInstance().logError(
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
		return SuperStateEditPart.MODEL_ID.equals(StatechartVisualIDRegistry
				.getModelID(view));
	}

}
