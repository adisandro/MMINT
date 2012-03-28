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
package edu.toronto.cs.se.mmtf.xt.graph.diagram.navigator;

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

import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.EdgeEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.EdgeNameEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.GraphEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.NodeEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.NodeNameEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.providers.GraphElementTypes;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.providers.GraphParserProvider;

/**
 * @generated
 */
public class GraphNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		GraphDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		GraphDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof GraphNavigatorItem
				&& !isOwnView(((GraphNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof GraphNavigatorGroup) {
			GraphNavigatorGroup group = (GraphNavigatorGroup) element;
			return GraphDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof GraphNavigatorItem) {
			GraphNavigatorItem navigatorItem = (GraphNavigatorItem) element;
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
		switch (GraphVisualIDRegistry.getVisualID(view)) {
		case NodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/xt/graph/model/graph.ecore?Node", GraphElementTypes.Node_2001); //$NON-NLS-1$
		case GraphEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///edu/toronto/cs/se/mmtf/xt/graph/model/graph.ecore?Graph", GraphElementTypes.Graph_1000); //$NON-NLS-1$
		case EdgeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/xt/graph/model/graph.ecore?Edge", GraphElementTypes.Edge_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = GraphDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& GraphElementTypes.isKnownElementType(elementType)) {
			image = GraphElementTypes.getImage(elementType);
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
		if (element instanceof GraphNavigatorGroup) {
			GraphNavigatorGroup group = (GraphNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof GraphNavigatorItem) {
			GraphNavigatorItem navigatorItem = (GraphNavigatorItem) element;
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
		switch (GraphVisualIDRegistry.getVisualID(view)) {
		case NodeEditPart.VISUAL_ID:
			return getNode_2001Text(view);
		case GraphEditPart.VISUAL_ID:
			return getGraph_1000Text(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getNode_2001Text(View view) {
		IParser parser = GraphParserProvider.getParser(
				GraphElementTypes.Node_2001,
				view.getElement() != null ? view.getElement() : view,
				GraphVisualIDRegistry.getType(NodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			GraphDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGraph_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEdge_4001Text(View view) {
		IParser parser = GraphParserProvider.getParser(
				GraphElementTypes.Edge_4001,
				view.getElement() != null ? view.getElement() : view,
				GraphVisualIDRegistry.getType(EdgeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			GraphDiagramEditorPlugin.getInstance().logError(
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
		return GraphEditPart.MODEL_ID.equals(GraphVisualIDRegistry
				.getModelID(view));
	}

}
