/*
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramModelingAssistantProvider;

/**
 * @generated
 */
public class ClassDiagramModelingAssistantProviderOfClassEditPart extends ClassDiagramModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ClassDiagramElementTypes.Attribute_3001);
		types.add(ClassDiagramElementTypes.Operation_3002);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ClassEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(ClassEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(ClassDiagramElementTypes.Association_4001);
		types.add(ClassDiagramElementTypes.Dependency_4002);
		types.add(ClassDiagramElementTypes.ClassNestedIn_4003);
		types.add(ClassDiagramElementTypes.ClassSuperclass_4004);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ClassEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ClassEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ClassEditPart) {
			types.add(ClassDiagramElementTypes.Association_4001);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(ClassDiagramElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(ClassDiagramElementTypes.ClassNestedIn_4003);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(ClassDiagramElementTypes.ClassSuperclass_4004);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ClassEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(ClassEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ClassDiagramElementTypes.Association_4001) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		else if (relationshipType == ClassDiagramElementTypes.Dependency_4002) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		else if (relationshipType == ClassDiagramElementTypes.ClassNestedIn_4003) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		else if (relationshipType == ClassDiagramElementTypes.ClassSuperclass_4004) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((ClassEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(ClassEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(ClassDiagramElementTypes.Association_4001);
		types.add(ClassDiagramElementTypes.Dependency_4002);
		types.add(ClassDiagramElementTypes.ClassNestedIn_4003);
		types.add(ClassDiagramElementTypes.ClassSuperclass_4004);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((ClassEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(ClassEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ClassDiagramElementTypes.Association_4001) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		else if (relationshipType == ClassDiagramElementTypes.Dependency_4002) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		else if (relationshipType == ClassDiagramElementTypes.ClassNestedIn_4003) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		else if (relationshipType == ClassDiagramElementTypes.ClassSuperclass_4004) {
			types.add(ClassDiagramElementTypes.Class_2001);
		}
		return types;
	}

}
