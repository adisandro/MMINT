/*
 * Copyright Text ->
 * 
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine.diagram.navigator;

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

import edu.toronto.cs.se.modelepedia.statemachine.FinalState;
import edu.toronto.cs.se.modelepedia.statemachine.InitialState;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.FinalStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.InitialStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateActionTriggerActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateMachineEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateNameEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.TransitionTriggerActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineDiagramEditorPlugin;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineParserProvider;

/**
 * @generated
 */
public class StateMachineNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		StateMachineDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		StateMachineDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof StateMachineNavigatorItem
				&& !isOwnView(((StateMachineNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof StateMachineNavigatorGroup) {
			StateMachineNavigatorGroup group = (StateMachineNavigatorGroup) element;
			return StateMachineDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof StateMachineNavigatorItem) {
			StateMachineNavigatorItem navigatorItem = (StateMachineNavigatorItem) element;
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
		switch (StateMachineVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/StateMachine?StateMachine", StateMachineElementTypes.StateMachine_1000); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/StateMachine?State", StateMachineElementTypes.State_2001); //$NON-NLS-1$
		case InitialStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/StateMachine?InitialState", StateMachineElementTypes.InitialState_2002); //$NON-NLS-1$
		case FinalStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/StateMachine?FinalState", StateMachineElementTypes.FinalState_2003); //$NON-NLS-1$
		case StateActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/StateMachine?StateAction", StateMachineElementTypes.StateAction_3001); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/StateMachine?Transition", StateMachineElementTypes.Transition_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = StateMachineDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& StateMachineElementTypes.isKnownElementType(elementType)) {
			image = StateMachineElementTypes.getImage(elementType);
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
		if (element instanceof StateMachineNavigatorGroup) {
			StateMachineNavigatorGroup group = (StateMachineNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof StateMachineNavigatorItem) {
			StateMachineNavigatorItem navigatorItem = (StateMachineNavigatorItem) element;
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
		switch (StateMachineVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_1000Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2001Text(view);
		case InitialStateEditPart.VISUAL_ID:
			return getInitialState_2002Text(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2003Text(view);
		case StateActionEditPart.VISUAL_ID:
			return getStateAction_3001Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getStateMachine_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getState_2001Text(View view) {
		IParser parser = StateMachineParserProvider.getParser(
				StateMachineElementTypes.State_2001,
				view.getElement() != null ? view.getElement() : view,
				StateMachineVisualIDRegistry
						.getType(StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateMachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInitialState_2002Text(View view) {
		InitialState domainModelElement = (InitialState) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StateMachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFinalState_2003Text(View view) {
		FinalState domainModelElement = (FinalState) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StateMachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateAction_3001Text(View view) {
		IParser parser = StateMachineParserProvider.getParser(
				StateMachineElementTypes.StateAction_3001,
				view.getElement() != null ? view.getElement() : view,
				StateMachineVisualIDRegistry
						.getType(StateActionTriggerActionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateMachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		IParser parser = StateMachineParserProvider.getParser(
				StateMachineElementTypes.Transition_4001,
				view.getElement() != null ? view.getElement() : view,
				StateMachineVisualIDRegistry
						.getType(TransitionTriggerActionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StateMachineDiagramEditorPlugin.getInstance().logError(
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
		return StateMachineEditPart.MODEL_ID
				.equals(StateMachineVisualIDRegistry.getModelID(view));
	}

}
