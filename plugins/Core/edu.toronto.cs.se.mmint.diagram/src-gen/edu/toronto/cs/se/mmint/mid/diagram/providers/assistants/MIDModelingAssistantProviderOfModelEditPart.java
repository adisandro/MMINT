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
public class MIDModelingAssistantProviderOfModelEditPart extends MIDModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ModelEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(ModelEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(MIDElementTypes.ExtendibleElementSupertype_4013);
		types.add(MIDElementTypes.BinaryModelRel_4015);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ModelEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ModelEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4013);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4013);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4013);
		}
		if (targetEditPart instanceof ModelRel2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4013);
		}
		if (targetEditPart instanceof OperatorEditPart) {
			types.add(MIDElementTypes.ExtendibleElementSupertype_4013);
		}
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MIDElementTypes.BinaryModelRel_4015);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MIDElementTypes.BinaryModelRel_4015);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MIDElementTypes.BinaryModelRel_4015);
		}
		if (targetEditPart instanceof ModelRel2EditPart) {
			types.add(MIDElementTypes.BinaryModelRel_4015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ModelEditPart) sourceEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(ModelEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementSupertype_4013) {
			types.add(MIDElementTypes.Model_2011);
			types.add(MIDElementTypes.Model_2012);
			types.add(MIDElementTypes.ModelRel_2013);
			types.add(MIDElementTypes.ModelRel_2014);
			types.add(MIDElementTypes.Operator_2015);
		} else if (relationshipType == MIDElementTypes.BinaryModelRel_4015) {
			types.add(MIDElementTypes.Model_2011);
			types.add(MIDElementTypes.Model_2012);
			types.add(MIDElementTypes.ModelRel_2013);
			types.add(MIDElementTypes.ModelRel_2014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((ModelEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(ModelEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(MIDElementTypes.ExtendibleElementSupertype_4013);
		types.add(MIDElementTypes.ModelEndpoint_4014);
		types.add(MIDElementTypes.BinaryModelRel_4015);
		types.add(MIDElementTypes.ModelEndpoint_4018);
		types.add(MIDElementTypes.ModelEndpoint_4019);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((ModelEditPart) targetEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(ModelEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementSupertype_4013) {
			types.add(MIDElementTypes.Model_2011);
			types.add(MIDElementTypes.Model_2012);
			types.add(MIDElementTypes.ModelRel_2013);
			types.add(MIDElementTypes.ModelRel_2014);
			types.add(MIDElementTypes.Operator_2015);
		} else if (relationshipType == MIDElementTypes.ModelEndpoint_4014) {
			types.add(MIDElementTypes.ModelRel_2013);
			types.add(MIDElementTypes.ModelRel_2014);
		} else if (relationshipType == MIDElementTypes.BinaryModelRel_4015) {
			types.add(MIDElementTypes.Model_2011);
			types.add(MIDElementTypes.Model_2012);
			types.add(MIDElementTypes.ModelRel_2013);
			types.add(MIDElementTypes.ModelRel_2014);
		} else if (relationshipType == MIDElementTypes.ModelEndpoint_4018) {
			types.add(MIDElementTypes.Operator_2015);
		} else if (relationshipType == MIDElementTypes.ModelEndpoint_4019) {
			types.add(MIDElementTypes.Operator_2015);
		}
		return types;
	}

}
