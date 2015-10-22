/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDModelingAssistantProvider;

/**
 * @generated
 */
public class MIDModelingAssistantProviderOfOperatorEditPart extends MIDModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((OperatorEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(OperatorEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		types.add(MIDElementTypes.ModelEndpoint_4004);
		types.add(MIDElementTypes.ModelEndpoint_4005);
		return types;
	}

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((OperatorEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			OperatorEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof ModelRel2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof OperatorEditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4004);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4004);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4004);
		}
		if (targetEditPart instanceof ModelRel2EditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4004);
		}
		if (targetEditPart instanceof OperatorEditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4004);
		}
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4005);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4005);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4005);
		}
		if (targetEditPart instanceof ModelRel2EditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4005);
		}
		if (targetEditPart instanceof OperatorEditPart) {
			types.add(MIDElementTypes.ModelEndpoint_4005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((OperatorEditPart) sourceEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(OperatorEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementSupertype_4001) {
			types.add(MIDElementTypes.Model_2001);
			types.add(MIDElementTypes.Model_2002);
			types.add(MIDElementTypes.ModelRel_2003);
			types.add(MIDElementTypes.ModelRel_2004);
			types.add(MIDElementTypes.Operator_2005);
		}
		else if (relationshipType == MIDElementTypes.ModelEndpoint_4004) {
			types.add(MIDElementTypes.Model_2001);
			types.add(MIDElementTypes.Model_2002);
			types.add(MIDElementTypes.ModelRel_2003);
			types.add(MIDElementTypes.ModelRel_2004);
			types.add(MIDElementTypes.Operator_2005);
		}
		else if (relationshipType == MIDElementTypes.ModelEndpoint_4005) {
			types.add(MIDElementTypes.Model_2001);
			types.add(MIDElementTypes.Model_2002);
			types.add(MIDElementTypes.ModelRel_2003);
			types.add(MIDElementTypes.ModelRel_2004);
			types.add(MIDElementTypes.Operator_2005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((OperatorEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(OperatorEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		types.add(MIDElementTypes.ModelEndpoint_4002);
		types.add(MIDElementTypes.ModelEndpoint_4004);
		types.add(MIDElementTypes.ModelEndpoint_4005);
		return types;
	}

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((OperatorEditPart) targetEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(OperatorEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementSupertype_4001) {
			types.add(MIDElementTypes.Model_2001);
			types.add(MIDElementTypes.Model_2002);
			types.add(MIDElementTypes.ModelRel_2003);
			types.add(MIDElementTypes.ModelRel_2004);
			types.add(MIDElementTypes.Operator_2005);
		}
		else if (relationshipType == MIDElementTypes.ModelEndpoint_4002) {
			types.add(MIDElementTypes.ModelRel_2003);
			types.add(MIDElementTypes.ModelRel_2004);
		}
		else if (relationshipType == MIDElementTypes.ModelEndpoint_4004) {
			types.add(MIDElementTypes.Operator_2005);
		}
		else if (relationshipType == MIDElementTypes.ModelEndpoint_4005) {
			types.add(MIDElementTypes.Operator_2005);
		}
		return types;
	}

}
