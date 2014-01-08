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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class IStar_MAVOModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_2001);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_2002);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_2003);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_2004);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Actor_2005);
			return types;
		}
		if (editPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_3001);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_3002);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_3003);
			types.add(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_3004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) {
			return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin
						.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.IStar_MAVOModelingAssistantProviderMessage);
		dialog.setTitle(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.Messages.IStar_MAVOModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
