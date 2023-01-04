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
package edu.toronto.cs.se.modelepedia.istar.diagram.navigator;

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

import edu.toronto.cs.se.modelepedia.istar.Contribution;
import edu.toronto.cs.se.modelepedia.istar.Decomposition;
import edu.toronto.cs.se.modelepedia.istar.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar.DependerLink;
import edu.toronto.cs.se.modelepedia.istar.MeansEnd;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ContributionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DecompositionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependeeLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependerLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Goal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.IStarEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.MeansEndEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Resource2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Task2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarDiagramEditorPlugin;
import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.istar.diagram.providers.IStarElementTypes;
import edu.toronto.cs.se.modelepedia.istar.diagram.providers.IStarParserProvider;

/**
 * @generated
 */
public class IStarNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		IStarDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		IStarDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof IStarNavigatorItem
				&& !isOwnView(((IStarNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof IStarNavigatorGroup) {
			IStarNavigatorGroup group = (IStarNavigatorGroup) element;
			return IStarDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof IStarNavigatorItem) {
			IStarNavigatorItem navigatorItem = (IStarNavigatorItem) element;
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
		switch (IStarVisualIDRegistry.getVisualID(view)) {
		case Resource2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar?Resource", IStarElementTypes.Resource_3003); //$NON-NLS-1$
		case IStarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/IStar?IStar", IStarElementTypes.IStar_1000); //$NON-NLS-1$
		case MeansEndEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar?MeansEnd", IStarElementTypes.MeansEnd_4001); //$NON-NLS-1$
		case DependerLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar?DependerLink", IStarElementTypes.DependerLink_4004); //$NON-NLS-1$
		case DependeeLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar?DependeeLink", IStarElementTypes.DependeeLink_4005); //$NON-NLS-1$
		case TaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar?Task", IStarElementTypes.Task_2002); //$NON-NLS-1$
		case Goal2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar?Goal", IStarElementTypes.Goal_3004); //$NON-NLS-1$
		case SoftGoal2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar?SoftGoal", IStarElementTypes.SoftGoal_3001); //$NON-NLS-1$
		case SoftGoalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar?SoftGoal", IStarElementTypes.SoftGoal_2001); //$NON-NLS-1$
		case ActorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar?Actor", IStarElementTypes.Actor_2005); //$NON-NLS-1$
		case DecompositionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar?Decomposition", IStarElementTypes.Decomposition_4002); //$NON-NLS-1$
		case GoalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar?Goal", IStarElementTypes.Goal_2004); //$NON-NLS-1$
		case ContributionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/IStar?Contribution", IStarElementTypes.Contribution_4003); //$NON-NLS-1$
		case ResourceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/IStar?Resource", IStarElementTypes.Resource_2003); //$NON-NLS-1$
		case Task2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/IStar?Task", IStarElementTypes.Task_3002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = IStarDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& IStarElementTypes.isKnownElementType(elementType)) {
			image = IStarElementTypes.getImage(elementType);
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
		if (element instanceof IStarNavigatorGroup) {
			IStarNavigatorGroup group = (IStarNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof IStarNavigatorItem) {
			IStarNavigatorItem navigatorItem = (IStarNavigatorItem) element;
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
		switch (IStarVisualIDRegistry.getVisualID(view)) {
		case Resource2EditPart.VISUAL_ID:
			return getResource_3003Text(view);
		case IStarEditPart.VISUAL_ID:
			return getIStar_1000Text(view);
		case MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001Text(view);
		case DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004Text(view);
		case DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005Text(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_2002Text(view);
		case Goal2EditPart.VISUAL_ID:
			return getGoal_3004Text(view);
		case SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001Text(view);
		case SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001Text(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2005Text(view);
		case DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002Text(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2004Text(view);
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003Text(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2003Text(view);
		case Task2EditPart.VISUAL_ID:
			return getTask_3002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getTask_2002Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.Task_2002,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(TaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getResource_2003Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.Resource_2003,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(ResourceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependeeLink_4005Text(View view) {
		DependeeLink domainModelElement = (DependeeLink) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMeansEnd_4001Text(View view) {
		MeansEnd domainModelElement = (MeansEnd) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActor_2005Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.Actor_2005,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(ActorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDependerLink_4004Text(View view) {
		DependerLink domainModelElement = (DependerLink) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoal_2004Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.Goal_2004,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(GoalNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTask_3002Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.Task_3002,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(TaskName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSoftGoal_2001Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.SoftGoal_2001,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(SoftGoalNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoal_3004Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.Goal_3004,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(GoalName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getResource_3003Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.Resource_3003,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(ResourceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDecomposition_4002Text(View view) {
		Decomposition domainModelElement = (Decomposition) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getContribution_4003Text(View view) {
		Contribution domainModelElement = (Contribution) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSoftGoal_3001Text(View view) {
		IParser parser = IStarParserProvider.getParser(
				IStarElementTypes.SoftGoal_3001,
				view.getElement() != null ? view.getElement() : view,
				IStarVisualIDRegistry.getType(SoftGoalName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			IStarDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIStar_1000Text(View view) {
		return ""; //$NON-NLS-1$
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
		return IStarEditPart.MODEL_ID.equals(IStarVisualIDRegistry
				.getModelID(view));
	}

}
