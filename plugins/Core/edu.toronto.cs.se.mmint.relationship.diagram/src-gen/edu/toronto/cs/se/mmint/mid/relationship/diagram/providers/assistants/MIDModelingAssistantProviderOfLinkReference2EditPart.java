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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.LinkReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.LinkReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDModelingAssistantProvider;

/**
 * @generated
 */
public class MIDModelingAssistantProviderOfLinkReference2EditPart extends
		MIDModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((LinkReference2EditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(
			LinkReference2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		types.add(MIDElementTypes.ModelElementEndpointReference_4011);
		types.add(MIDElementTypes.ModelElementEndpointReference_4014);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(LinkReference2EditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			LinkReference2EditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ModelEndpointReferenceEditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof LinkReferenceEditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof LinkReference2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelEndpointReference2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReferenceEditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReferenceEditPart) {
			types.add(MIDElementTypes.ModelElementEndpointReference_4011);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MIDElementTypes.ModelElementEndpointReference_4011);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MIDElementTypes.ModelElementEndpointReference_4011);
		}
		if (targetEditPart instanceof ModelElementReferenceEditPart) {
			types.add(MIDElementTypes.ModelElementEndpointReference_4014);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MIDElementTypes.ModelElementEndpointReference_4014);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MIDElementTypes.ModelElementEndpointReference_4014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((LinkReference2EditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			LinkReference2EditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010) {
			types.add(MIDElementTypes.ModelEndpointReference_2007);
			types.add(MIDElementTypes.LinkReference_2008);
			types.add(MIDElementTypes.LinkReference_2009);
			types.add(MIDElementTypes.ModelEndpointReference_2010);
			types.add(MIDElementTypes.ModelElementReference_3005);
			types.add(MIDElementTypes.ModelElementReference_3006);
			types.add(MIDElementTypes.ModelElementReference_3007);
		} else if (relationshipType == MIDElementTypes.ModelElementEndpointReference_4011) {
			types.add(MIDElementTypes.ModelElementReference_3005);
			types.add(MIDElementTypes.ModelElementReference_3006);
			types.add(MIDElementTypes.ModelElementReference_3007);
		} else if (relationshipType == MIDElementTypes.ModelElementEndpointReference_4014) {
			types.add(MIDElementTypes.ModelElementReference_3005);
			types.add(MIDElementTypes.ModelElementReference_3006);
			types.add(MIDElementTypes.ModelElementReference_3007);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((LinkReference2EditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			LinkReference2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((LinkReference2EditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			LinkReference2EditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4010) {
			types.add(MIDElementTypes.ModelEndpointReference_2007);
			types.add(MIDElementTypes.LinkReference_2008);
			types.add(MIDElementTypes.LinkReference_2009);
			types.add(MIDElementTypes.ModelEndpointReference_2010);
			types.add(MIDElementTypes.ModelElementReference_3005);
			types.add(MIDElementTypes.ModelElementReference_3006);
			types.add(MIDElementTypes.ModelElementReference_3007);
		}
		return types;
	}

}
