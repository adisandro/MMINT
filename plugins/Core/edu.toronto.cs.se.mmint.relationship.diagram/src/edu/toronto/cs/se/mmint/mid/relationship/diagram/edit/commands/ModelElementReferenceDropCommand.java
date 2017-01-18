/**
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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.RelationshipDiagramOutlineDropObject;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * The command to create a model element reference from a dropped object.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceDropCommand extends ModelElementReferenceCreateCommand {

	RelationshipDiagramOutlineDropObject dropObj;

	/**
	 * Constructor: initialises the superclass and the dropped element.
	 * 
	 * @param req
	 *            The request.
	 * @param newModelObj
	 *            The dropped element.
	 */
	public ModelElementReferenceDropCommand(CreateElementRequest req, RelationshipDiagramOutlineDropObject dropObj) {

		super(req);
		this.dropObj = dropObj;
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MID mid = ((ModelEndpointReference) getElementToEdit()).getMIDContainer();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MID mid = ((ModelEndpointReference) getElementToEdit()).getMIDContainer();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

	/**
	 * Checks if a model element reference can be created.
	 * 
	 * @return True if a model element reference can be created, false
	 *         otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	protected ModelElementReference doExecuteTypesLevel() throws MMINTException {

		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) getElementToEdit();
		EObject metamodelObj = dropObj.getModelObject();
		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		MID typeMID = modelRelType.getMIDContainer();

		// navigate metamodel hierarchy
		//TODO MMINT[MODELELEMENT] could this be in the drag part?
		ModelElement modelElemType = null;
		ModelElementReference modelElemTypeRef = null;
		if (metamodelObj instanceof EClass) {
supertypes:
			for (EClass modelObjSuper : ((EClass) metamodelObj).getEAllSuperTypes()) {
				String[] uris = MIDRegistry.getModelAndModelElementUris(modelObjSuper, MIDLevel.TYPES);
				String modelTypeUri = uris[0];
				String modelElemTypeUri = uris[1];
				List<ModelEndpointReference> modelTypeEndpointRefsOrModelTypeEndpointRefsSuper = MIDRegistry.getEndpointReferences(modelTypeUri, modelRelType.getModelEndpointRefs());
				if (modelTypeEndpointRefsOrModelTypeEndpointRefsSuper == null) {
					continue;
				}
				for (ModelEndpointReference modelTypeEndpointRefOrModelTypeEndpointRefSuper : modelTypeEndpointRefsOrModelTypeEndpointRefsSuper) {
					modelElemTypeRef = MIDRegistry.getReference(modelElemTypeUri, modelTypeEndpointRefOrModelTypeEndpointRefSuper.getModelElemRefs());
					if (modelElemTypeRef != null) {
						modelElemType = modelElemTypeRef.getObject();
						break supertypes;
					}
				}
				//TODO MMINT[MODELELEMENT] store # supertype levels and trigger possible reorder of inheritance chain
			}
		}
		if (modelElemType == null) {
			String modelElemTypeUri = MMINT.ROOT_MODELELEM_URI;
			modelElemType = typeMID.getExtendibleElement(modelElemTypeUri);
		}

		EMFInfo eInfo = MIDRegistry.getModelElementEMFInfo(metamodelObj, MIDLevel.TYPES);
		String newModelElemTypeName = MIDRegistry.getModelElementName(eInfo, metamodelObj, MIDLevel.TYPES);
		ModelElementReference newModelElemTypeRef = modelElemType.createSubtypeAndReference(modelElemTypeRef, dropObj.getModelElementUri(), newModelElemTypeName, eInfo, modelTypeEndpointRef);
		MMINT.createTypeHierarchy(typeMID);

		return newModelElemTypeRef;
	}

	protected ModelElementReference doExecuteInstancesLevel() throws MMINTException {

		ModelEndpointReference modelEndpointRef = (ModelEndpointReference) getElementToEdit();
		ModelElementReference newModelElemRef = modelEndpointRef.createModelElementInstanceAndReference(dropObj.getModelObject(), null);

		return newModelElemRef;
	}

	/**
	 * Creates a new model element reference from a dropped object.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			ModelElementReference newElement;
			switch (((ModelEndpointReference) getElementToEdit()).getObject().getLevel()) {
				case TYPES:
					newElement = this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					newElement = this.doExecuteInstancesLevel();
					break;
				case WORKFLOWS:
					throw new MMINTException("The WORKFLOWS level is not allowed");
				default:
					throw new MMINTException("The MID level is missing");
			}
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "No model element reference created", e);
			return CommandResult.newErrorCommandResult("No model element reference created");
		}
	}

}
