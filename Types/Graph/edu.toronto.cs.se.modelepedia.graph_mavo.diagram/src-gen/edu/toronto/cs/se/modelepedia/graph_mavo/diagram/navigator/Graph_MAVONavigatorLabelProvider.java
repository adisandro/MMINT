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
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator;

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
public class Graph_MAVONavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem
				&& !isOwnView(((edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem) element)
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
		if (element instanceof edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorGroup) element;
			return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/Graph_MAVO?Graph", edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Graph_1000); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/Graph_MAVO?Node", edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Node_2001); //$NON-NLS-1$
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/Graph_MAVO?Edge", edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Edge_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes
						.isKnownElementType(elementType)) {
			image = edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes
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
		if (element instanceof edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.navigator.Graph_MAVONavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.VISUAL_ID:
			return getGraph_1000Text(view);
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID:
			return getNode_2001Text(view);
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID:
			return getEdge_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getGraph_1000Text(View view) {
		edu.toronto.cs.se.modelepedia.graph_mavo.Graph domainModelElement = (edu.toronto.cs.se.modelepedia.graph_mavo.Graph) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isInc());
		} else {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNode_2001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Node_2001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEdge_4001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Edge_4001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
								.getType(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6001); //$NON-NLS-1$
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
		return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.MODEL_ID
				.equals(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
						.getModelID(view));
	}

}
