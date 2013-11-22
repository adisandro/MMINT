/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * The command to create a model element reference from a dropped object.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceDropCommand extends ModelElementReferenceCreateCommand {

	String newModelUri;
	String newModelElemUri;
	EObject newModelObj;
	ModelElement modelElemType;

	/**
	 * Constructor: initialises the superclass and the dropped element.
	 * 
	 * @param req
	 *            The request.
	 * @param newModelObj
	 *            The dropped element.
	 */
	public ModelElementReferenceDropCommand(CreateElementRequest req, String newModelUri, String newModelElemUri, EObject newModelObj) {

		super(req);
		this.newModelUri = newModelUri;
		this.newModelElemUri = newModelElemUri;
		this.newModelObj = newModelObj;
		this.modelElemType = null;
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

		return
			super.canExecute() && (
				!MultiModelConstraintChecker.isInstancesLevel((ModelRel) getElementToEdit().eContainer()) || (
					(modelElemType = MultiModelConstraintChecker.getAllowedModelElementType((ModelEndpointReference) getElementToEdit(), newModelObj)) != null &&
					MultiModelRegistry.getModelElementReference((ModelEndpointReference) getElementToEdit(), modelElemType, newModelObj) == null
				)
			);
	}

	protected ModelElementReference doExecuteInstancesLevel() throws MMTFException {

		ModelEndpointReference modelEndpointRef = (ModelEndpointReference) getElementToEdit();
		String classLiteral = MultiModelRegistry.getModelElementClassLiteral(newModelObj, true); // class literal == type name
		String newModelElemName = MultiModelRegistry.getModelElementName(newModelObj, true);
		ModelElementReference newModelElemRef = MultiModelInstanceFactory.createModelElementAndModelElementReference(
			modelElemType,
			newModelElemUri,
			newModelElemName,
			classLiteral,
			modelEndpointRef
		);
		MAVOUtils.initializeMAVOModelElementReference(newModelObj, newModelElemRef);

		return newModelElemRef;
	}

	protected ModelElementReference doExecuteTypesLevel() throws MMTFException {

		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) getElementToEdit();
		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);

		// navigate metamodel hierarchy
		ModelElement modelElemType = null;
		ModelElementReference modelElemTypeRef = null;
		if (newModelObj instanceof EClass) {
supertypes:
			for (EClass droppedEObject : ((EClass) newModelObj).getEAllSuperTypes()) {
				String[] uris = MultiModelRegistry.getModelAndModelElementUris(droppedEObject, false);
				String modelTypeUri = uris[0];
				String modelElemTypeUri = uris[1];
				List<ModelEndpointReference> modelTypeEndpointRefsOrModelTypeEndpointRefsSuper = MultiModelTypeHierarchy.getEndpointReferences(modelTypeUri, modelRelType.getModelEndpointRefs());
				if (modelTypeEndpointRefsOrModelTypeEndpointRefsSuper == null) {
					continue;
				}
				for (ModelEndpointReference modelTypeEndpointRefOrModelTypeEndpointRefSuper : modelTypeEndpointRefsOrModelTypeEndpointRefsSuper) {
					modelElemTypeUri = MultiModelLightTypeFactory.createNewLightTypeUri(modelTypeEndpointRefOrModelTypeEndpointRefSuper.getObject(), null, modelElemTypeUri);
					modelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeUri, modelTypeEndpointRefOrModelTypeEndpointRefSuper.getModelElemRefs());
					if (modelElemTypeRef != null) {
						modelElemType = modelElemTypeRef.getObject();
						break supertypes;
					}
				}
				//TODO MMTF: store # supertype levels and trigger possible reorder of inheritance chain
			}
		}
		if (modelElemType == null) {
			String modelElemTypeUri = MMTF.ROOT_MODELELEM_URI;
			modelElemType = MultiModelRegistry.getExtendibleElement(modelElemTypeUri, multiModel);
			//TODO MMTF: move getXType into a generic type registry, I need those functions for instances too (only the ones with a multiModel argument)
			//TODO MMTF: clean things in instances (order of arguments like in types, URI instead of String uri, name as argument)
			//TODO MMTF: write a todo somewhere to remember to handle the import of a model rel instance
		}

		String classLiteral = newModelElemUri; // class literal == name
		ModelElementReference newModelElemTypeRef = MultiModelLightTypeFactory.createLightModelElementTypeAndModelElementTypeReference(
			modelElemType,
			modelElemTypeRef,
			newModelElemUri,
			classLiteral,
			modelTypeEndpointRef
		);
		MAVOUtils.initializeMAVOModelElementReference(newModelObj, newModelElemTypeRef);
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
