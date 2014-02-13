/**
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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmtf.mid.EMFInfo;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.RelationshipDiagramOutlineDropObject;

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
		MultiModel multiModel = MultiModelRegistry.getMultiModel((ModelEndpointReference) getElementToEdit());
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.createTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = MultiModelRegistry.getMultiModel((ModelEndpointReference) getElementToEdit());
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.createTypeHierarchy(multiModel);
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

	protected ModelElementReference doExecuteInstancesLevel() throws MMTFException {

		ModelEndpointReference modelEndpointRef = (ModelEndpointReference) getElementToEdit();
		EObject modelObj = dropObj.getModelObject();
		EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo(modelObj, true);
		String newModelElemName = MultiModelRegistry.getModelElementName(eInfo, modelObj, true);
		ModelElementReference newModelElemRef = dropObj.getModelElementType().createInstanceAndReference(dropObj.getModelElementUri(), newModelElemName, eInfo, modelEndpointRef);
		MAVOUtils.initializeMAVOModelElementReference(modelObj, newModelElemRef);

		return newModelElemRef;
	}

	protected ModelElementReference doExecuteTypesLevel() throws MMTFException {

		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) getElementToEdit();
		EObject modelObj = dropObj.getModelObject();
		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);

		// navigate metamodel hierarchy
		//TODO MMTF[MODELELEMENT] could this be in the drag part?
		ModelElement modelElemType = null;
		ModelElementReference modelElemTypeRef = null;
		if (modelObj instanceof EClass) {
supertypes:
			for (EClass modelObjSuper : ((EClass) modelObj).getEAllSuperTypes()) {
				String[] uris = MultiModelRegistry.getModelAndModelElementUris(modelObjSuper, false);
				String modelTypeUri = uris[0];
				String modelElemTypeUri = uris[1];
				List<ModelEndpointReference> modelTypeEndpointRefsOrModelTypeEndpointRefsSuper = MultiModelTypeHierarchy.getEndpointReferences(modelTypeUri, modelRelType.getModelEndpointRefs());
				if (modelTypeEndpointRefsOrModelTypeEndpointRefsSuper == null) {
					continue;
				}
				for (ModelEndpointReference modelTypeEndpointRefOrModelTypeEndpointRefSuper : modelTypeEndpointRefsOrModelTypeEndpointRefsSuper) {
					modelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeUri, modelTypeEndpointRefOrModelTypeEndpointRefSuper.getModelElemRefs());
					if (modelElemTypeRef != null) {
						modelElemType = modelElemTypeRef.getObject();
						break supertypes;
					}
				}
				//TODO MMTF[MODELELEMENT] store # supertype levels and trigger possible reorder of inheritance chain
			}
		}
		if (modelElemType == null) {
			String modelElemTypeUri = MMTF.ROOT_MODELELEM_URI;
			modelElemType = MultiModelRegistry.getExtendibleElement(modelElemTypeUri, multiModel);
		}

		EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo(modelObj, false);
		String newModelElemTypeName = MultiModelRegistry.getModelElementName(eInfo, modelObj, false);
		ModelElementReference newModelElemTypeRef = modelElemType.createSubtypeAndReference(modelElemTypeRef, dropObj.getModelElementUri(), newModelElemTypeName, eInfo, modelTypeEndpointRef);
		MAVOUtils.initializeMAVOModelElementReference(modelObj, newModelElemTypeRef);
		MMTF.createTypeHierarchy(multiModel);

		return newModelElemTypeRef;
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
			ModelElementReference newElement = (MultiModelConstraintChecker.isInstancesLevel((ModelRel) getElementToEdit().eContainer())) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model element reference created", e);
			return CommandResult.newErrorCommandResult("No model element reference created");
		}
	}

}
