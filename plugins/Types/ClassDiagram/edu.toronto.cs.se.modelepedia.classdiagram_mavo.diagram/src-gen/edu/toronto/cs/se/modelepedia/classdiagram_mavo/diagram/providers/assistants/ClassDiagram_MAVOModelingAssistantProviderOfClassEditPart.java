/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class ClassDiagram_MAVOModelingAssistantProviderOfClassEditPart extends
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Attribute_3001);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Operation_3002);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource(
				(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget(
				(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		} else
			if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		} else if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		} else
			if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget(
				(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003);
		types.add(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource(
				(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		} else
			if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		} else if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		} else
			if (relationshipType == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004) {
			types.add(
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		}
		return types;
	}

}
