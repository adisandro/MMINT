/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
public class MIDModelingAssistantProviderOfModel2EditPart extends MIDModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((Model2EditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(Model2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		types.add(MIDElementTypes.BinaryModelRel_4003);
		return types;
	}

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((Model2EditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(Model2EditPart source, IGraphicalEditPart targetEditPart) {
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
			types.add(MIDElementTypes.BinaryModelRel_4003);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MIDElementTypes.BinaryModelRel_4003);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MIDElementTypes.BinaryModelRel_4003);
		}
		if (targetEditPart instanceof ModelRel2EditPart) {
			types.add(MIDElementTypes.BinaryModelRel_4003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((Model2EditPart) sourceEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(Model2EditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementSupertype_4001) {
			types.add(MIDElementTypes.Model_2001);
			types.add(MIDElementTypes.Model_2002);
			types.add(MIDElementTypes.ModelRel_2003);
			types.add(MIDElementTypes.ModelRel_2004);
			types.add(MIDElementTypes.Operator_2005);
		}
		else if (relationshipType == MIDElementTypes.BinaryModelRel_4003) {
			types.add(MIDElementTypes.Model_2001);
			types.add(MIDElementTypes.Model_2002);
			types.add(MIDElementTypes.ModelRel_2003);
			types.add(MIDElementTypes.ModelRel_2004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((Model2EditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(Model2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(MIDElementTypes.ExtendibleElementSupertype_4001);
		types.add(MIDElementTypes.ModelEndpoint_4002);
		types.add(MIDElementTypes.BinaryModelRel_4003);
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
		return doGetTypesForSource((Model2EditPart) targetEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(Model2EditPart target, IElementType relationshipType) {
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
		else if (relationshipType == MIDElementTypes.BinaryModelRel_4003) {
			types.add(MIDElementTypes.Model_2001);
			types.add(MIDElementTypes.Model_2002);
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
