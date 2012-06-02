/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.petrinet.diagram.navigator;

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

import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.ArcEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.ArcWeightEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.PetriNetEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.PlaceEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.PlaceNameTokensEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.TransitionNameEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetDiagramEditorPlugin;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.providers.PetrinetElementTypes;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.providers.PetrinetParserProvider;

/**
 * @generated
 */
public class PetrinetNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PetrinetDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		PetrinetDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof PetrinetNavigatorItem
				&& !isOwnView(((PetrinetNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof PetrinetNavigatorGroup) {
			PetrinetNavigatorGroup group = (PetrinetNavigatorGroup) element;
			return PetrinetDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof PetrinetNavigatorItem) {
			PetrinetNavigatorItem navigatorItem = (PetrinetNavigatorItem) element;
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
		switch (PetrinetVisualIDRegistry.getVisualID(view)) {
		case PetriNetEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///edu/toronto/cs/se/modelepedia/petrinet/model/petrinet.ecore?PetriNet", PetrinetElementTypes.PetriNet_1000); //$NON-NLS-1$
		case ArcEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/modelepedia/petrinet/model/petrinet.ecore?Arc", PetrinetElementTypes.Arc_4001); //$NON-NLS-1$
		case PlaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/modelepedia/petrinet/model/petrinet.ecore?Place", PetrinetElementTypes.Place_2002); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/modelepedia/petrinet/model/petrinet.ecore?Transition", PetrinetElementTypes.Transition_2001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PetrinetDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& PetrinetElementTypes.isKnownElementType(elementType)) {
			image = PetrinetElementTypes.getImage(elementType);
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
		if (element instanceof PetrinetNavigatorGroup) {
			PetrinetNavigatorGroup group = (PetrinetNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof PetrinetNavigatorItem) {
			PetrinetNavigatorItem navigatorItem = (PetrinetNavigatorItem) element;
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
		switch (PetrinetVisualIDRegistry.getVisualID(view)) {
		case PetriNetEditPart.VISUAL_ID:
			return getPetriNet_1000Text(view);
		case ArcEditPart.VISUAL_ID:
			return getArc_4001Text(view);
		case PlaceEditPart.VISUAL_ID:
			return getPlace_2002Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_2001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPlace_2002Text(View view) {
		IParser parser = PetrinetParserProvider.getParser(
				PetrinetElementTypes.Place_2002,
				view.getElement() != null ? view.getElement() : view,
				PetrinetVisualIDRegistry
						.getType(PlaceNameTokensEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetrinetDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_2001Text(View view) {
		IParser parser = PetrinetParserProvider.getParser(
				PetrinetElementTypes.Transition_2001,
				view.getElement() != null ? view.getElement() : view,
				PetrinetVisualIDRegistry
						.getType(TransitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetrinetDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPetriNet_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getArc_4001Text(View view) {
		IParser parser = PetrinetParserProvider.getParser(
				PetrinetElementTypes.Arc_4001,
				view.getElement() != null ? view.getElement() : view,
				PetrinetVisualIDRegistry.getType(ArcWeightEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetrinetDiagramEditorPlugin.getInstance().logError(
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
		return PetriNetEditPart.MODEL_ID.equals(PetrinetVisualIDRegistry
				.getModelID(view));
	}

}
