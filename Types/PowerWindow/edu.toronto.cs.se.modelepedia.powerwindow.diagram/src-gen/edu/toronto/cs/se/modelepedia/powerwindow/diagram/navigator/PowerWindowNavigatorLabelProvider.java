/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.navigator;

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

import edu.toronto.cs.se.modelepedia.powerwindow.Window;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.ForceDetectingDelayEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.ForceDetectingEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.InfraredDelayEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.InfraredEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.LockOutEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.LockOutNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.PushPullEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.PushPullNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.RockerEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.RockerNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.WindowEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowDiagramEditorPlugin;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.providers.PowerWindowElementTypes;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.providers.PowerWindowParserProvider;

/**
 * @generated
 */
public class PowerWindowNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PowerWindowDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		PowerWindowDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof PowerWindowNavigatorItem
				&& !isOwnView(((PowerWindowNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof PowerWindowNavigatorGroup) {
			PowerWindowNavigatorGroup group = (PowerWindowNavigatorGroup) element;
			return PowerWindowDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof PowerWindowNavigatorItem) {
			PowerWindowNavigatorItem navigatorItem = (PowerWindowNavigatorItem) element;
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
		switch (PowerWindowVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/PowerWindow?Window", PowerWindowElementTypes.Window_1000); //$NON-NLS-1$
		case PushPullEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/PowerWindow?PushPull", PowerWindowElementTypes.PushPull_2011); //$NON-NLS-1$
		case RockerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/PowerWindow?Rocker", PowerWindowElementTypes.Rocker_2012); //$NON-NLS-1$
		case InfraredEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/PowerWindow?Infrared", PowerWindowElementTypes.Infrared_2013); //$NON-NLS-1$
		case LockOutEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/PowerWindow?LockOut", PowerWindowElementTypes.LockOut_2014); //$NON-NLS-1$
		case ForceDetectingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/PowerWindow?ForceDetecting", PowerWindowElementTypes.ForceDetecting_2015); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PowerWindowDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& PowerWindowElementTypes.isKnownElementType(elementType)) {
			image = PowerWindowElementTypes.getImage(elementType);
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
		if (element instanceof PowerWindowNavigatorGroup) {
			PowerWindowNavigatorGroup group = (PowerWindowNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof PowerWindowNavigatorItem) {
			PowerWindowNavigatorItem navigatorItem = (PowerWindowNavigatorItem) element;
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
		switch (PowerWindowVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getWindow_1000Text(view);
		case PushPullEditPart.VISUAL_ID:
			return getPushPull_2011Text(view);
		case RockerEditPart.VISUAL_ID:
			return getRocker_2012Text(view);
		case InfraredEditPart.VISUAL_ID:
			return getInfrared_2013Text(view);
		case LockOutEditPart.VISUAL_ID:
			return getLockOut_2014Text(view);
		case ForceDetectingEditPart.VISUAL_ID:
			return getForceDetecting_2015Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getWindow_1000Text(View view) {
		Window domainModelElement = (Window) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			PowerWindowDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPushPull_2011Text(View view) {
		IParser parser = PowerWindowParserProvider.getParser(
				PowerWindowElementTypes.PushPull_2011,
				view.getElement() != null ? view.getElement() : view,
				PowerWindowVisualIDRegistry
						.getType(PushPullNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PowerWindowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRocker_2012Text(View view) {
		IParser parser = PowerWindowParserProvider.getParser(
				PowerWindowElementTypes.Rocker_2012,
				view.getElement() != null ? view.getElement() : view,
				PowerWindowVisualIDRegistry
						.getType(RockerNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PowerWindowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInfrared_2013Text(View view) {
		IParser parser = PowerWindowParserProvider.getParser(
				PowerWindowElementTypes.Infrared_2013,
				view.getElement() != null ? view.getElement() : view,
				PowerWindowVisualIDRegistry
						.getType(InfraredDelayEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PowerWindowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLockOut_2014Text(View view) {
		IParser parser = PowerWindowParserProvider.getParser(
				PowerWindowElementTypes.LockOut_2014,
				view.getElement() != null ? view.getElement() : view,
				PowerWindowVisualIDRegistry
						.getType(LockOutNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PowerWindowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForceDetecting_2015Text(View view) {
		IParser parser = PowerWindowParserProvider.getParser(
				PowerWindowElementTypes.ForceDetecting_2015,
				view.getElement() != null ? view.getElement() : view,
				PowerWindowVisualIDRegistry
						.getType(ForceDetectingDelayEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PowerWindowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5015); //$NON-NLS-1$
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
		return WindowEditPart.MODEL_ID.equals(PowerWindowVisualIDRegistry
				.getModelID(view));
	}

}
