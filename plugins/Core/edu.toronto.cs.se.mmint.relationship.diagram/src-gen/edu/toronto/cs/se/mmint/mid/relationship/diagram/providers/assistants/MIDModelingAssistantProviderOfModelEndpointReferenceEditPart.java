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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReferenceEditPart;
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
public class MIDModelingAssistantProviderOfModelEndpointReferenceEditPart extends MIDModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(MIDElementTypes.ModelElementReference_3001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ModelEndpointReferenceEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(ModelEndpointReferenceEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ModelEndpointReferenceEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ModelEndpointReferenceEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ModelEndpointReferenceEditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		}
		if (targetEditPart instanceof MappingReferenceEditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		}
		if (targetEditPart instanceof MappingReference2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		}
		if (targetEditPart instanceof ModelEndpointReference2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		}
		if (targetEditPart instanceof ModelElementReferenceEditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ModelEndpointReferenceEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(ModelEndpointReferenceEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001) {
			types.add(MIDElementTypes.ModelEndpointReference_2001);
			types.add(MIDElementTypes.MappingReference_2002);
			types.add(MIDElementTypes.MappingReference_2003);
			types.add(MIDElementTypes.ModelEndpointReference_2004);
			types.add(MIDElementTypes.ModelElementReference_3001);
			types.add(MIDElementTypes.ModelElementReference_3002);
			types.add(MIDElementTypes.ModelElementReference_3003);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((ModelEndpointReferenceEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(ModelEndpointReferenceEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((ModelEndpointReferenceEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(ModelEndpointReferenceEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001) {
			types.add(MIDElementTypes.ModelEndpointReference_2001);
			types.add(MIDElementTypes.MappingReference_2002);
			types.add(MIDElementTypes.MappingReference_2003);
			types.add(MIDElementTypes.ModelEndpointReference_2004);
			types.add(MIDElementTypes.ModelElementReference_3001);
			types.add(MIDElementTypes.ModelElementReference_3002);
			types.add(MIDElementTypes.ModelElementReference_3003);
		}
		return types;
	}

}
