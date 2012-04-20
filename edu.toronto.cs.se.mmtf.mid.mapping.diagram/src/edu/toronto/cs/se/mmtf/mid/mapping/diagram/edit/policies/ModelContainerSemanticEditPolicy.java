/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceDelModelCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelContainerEditPart;

/**
 * The semantic edit policy for model containers.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelContainerSemanticEditPolicy extends ModelContainerItemSemanticEditPolicy {

	/**
	 * Gets the command to delete a model container.
	 * 
	 * @param request
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		ModelContainerEditPart editPart = (ModelContainerEditPart) getHost();
		ModelContainer container = (ModelContainer) ((View) editPart.getModel()).getElement();
		MappingReference mappingRef = (MappingReference) container.eContainer();
		Command command = null;

		if (container.getContainedModel() == null && mappingRef instanceof BinaryMappingReference) {
			// a binary mapping which is not standalone can be only modified through the MID
			command = UnexecutableCommand.INSTANCE;
		}
		else {
			// this is equivalent to delete a model of a mapping reference in the MID
			EReference containing = (EReference) mappingRef.eClass().getEStructuralFeature(MappingPackage.MAPPING_REFERENCE__MODELS);
			DestroyReferenceRequest destroyReq = new DestroyReferenceRequest(editPart.getEditingDomain(), mappingRef, containing, container.getModel(), false);
			command = getGEFWrapper(new MappingReferenceDelModelCommand(destroyReq));
			//TODO una binary mapping reference standalone invece non deve distruggere anche model0 e model1? faccio il mio comando che estende quello sopra?
			//TODO delinput nella outline
		}

		return command;
	}

}
