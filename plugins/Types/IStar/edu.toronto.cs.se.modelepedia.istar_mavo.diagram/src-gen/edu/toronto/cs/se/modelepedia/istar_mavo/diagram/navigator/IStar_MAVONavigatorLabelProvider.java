/*
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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator;

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

/**
 * @generated
 */
public class IStar_MAVONavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem
				&& !isOwnView(
						((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) element)
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
		if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorGroup) element;
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?IStar", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.IStar_1000);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?SoftGoal", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_2001);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Task", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_2002);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Resource", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_2003);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Goal", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_2004);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Actor", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Actor_2005);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?SoftGoal", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_3001);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Task", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_3002);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Resource", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_3003);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Goal", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_3004);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?MeansEnd", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.MeansEnd_4001);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Decomposition", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Decomposition_4002);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?Contribution", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Contribution_4003);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?DependerLink", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependerLink_4004);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar_MAVO?DependeeLink", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependeeLink_4005);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
						.isKnownElementType(elementType)) {
			image = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
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
		if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			return getIStar_1000Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
			return getTask_2002Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
			return getResource_2003Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2004Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2005Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
			return getTask_3002Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
			return getResource_3003Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
			return getGoal_3004Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
			return getContribution_4003Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004Text(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getIStar_1000Text(View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.IStar domainModelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.IStar) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isInc());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSoftGoal_2001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_2001,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTask_2002Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider
				.getParser(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_2002,
						view.getElement() != null ? view.getElement()
								: view,
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
								edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getResource_2003Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_2003,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGoal_2004Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider
				.getParser(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_2004,
						view.getElement() != null ? view.getElement()
								: view,
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
								edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getActor_2005Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider
				.getParser(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Actor_2005,
						view.getElement() != null ? view.getElement()
								: view,
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
								edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSoftGoal_3001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_3001,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTask_3002Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider
				.getParser(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_3002,
						view.getElement() != null ? view.getElement()
								: view,
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
								edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getResource_3003Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_3003,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGoal_3004Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider
				.getParser(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_3004,
						view.getElement() != null ? view.getElement()
								: view,
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
								edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMeansEnd_4001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.MeansEnd_4001,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel10EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDecomposition_4002Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Decomposition_4002,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel11EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getContribution_4003Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Contribution_4003,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel12EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDependerLink_4004Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependerLink_4004,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel13EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDependeeLink_4005Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOParserProvider.getParser(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependeeLink_4005,
				view.getElement() != null ? view.getElement() : view,
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getType(
						edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel14EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6005); //$NON-NLS-1$
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
		return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.MODEL_ID.equals(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getModelID(view));
	}

}
