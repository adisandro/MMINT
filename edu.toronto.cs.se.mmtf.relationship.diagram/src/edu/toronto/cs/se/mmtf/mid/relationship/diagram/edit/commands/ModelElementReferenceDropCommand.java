/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.trait.MAVOUtils;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelHierarchyUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;

/**
 * The command to create a model element reference from a dropped object.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceDropCommand extends ModelElementReferenceCreateCommand {

	String newModelUri;
	String newModelElemUri;
	EObject newDroppedEObject;
	ModelElement modelElemType;

	/**
	 * Constructor: initialises the superclass and the dropped element.
	 * 
	 * @param req
	 *            The request.
	 * @param newDroppedEObject
	 *            The dropped element.
	 */
	public ModelElementReferenceDropCommand(CreateElementRequest req, String newModelUri, String newModelElemUri, EObject newDroppedEObject) {

		super(req);
		this.newModelUri = newModelUri;
		this.newModelElemUri = newModelElemUri;
		this.newDroppedEObject = newDroppedEObject;
		this.modelElemType = null;
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit().eContainer().eContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.initTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit().eContainer().eContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.initTypeHierarchy(multiModel);
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
				!MultiModelConstraintChecker.isInstancesLevel((ModelRel) getElementToEdit().eContainer()) ||
				(modelElemType = MultiModelConstraintChecker.getAllowedModelElementType((ModelEndpointReference) getElementToEdit(), newDroppedEObject)) != null
			);
	}

	protected ModelElementReference doExecuteInstancesLevel() {

		ModelEndpointReference modelEndpointRef = (ModelEndpointReference) getElementToEdit();
		String classLiteral = MultiModelRegistry.getEObjectClassLiteral(newDroppedEObject, true); // class literal == type name
		String newModelElemName = MultiModelRegistry.getEObjectLabel(newDroppedEObject, true);
		ModelElementCategory category = MultiModelRegistry.getEObjectCategory(newDroppedEObject);
		ModelElementReference newModelElemRef = MultiModelInstanceFactory.createModelElementAndModelElementReference(
			modelEndpointRef,
			modelElemType,
			newModelElemUri,
			newModelElemName,
			category,
			classLiteral
		);
		MAVOUtils.annotateMAVODroppedEObject(newDroppedEObject, newModelElemRef);

		return newModelElemRef;
	}

	protected ModelElementReference doExecuteTypesLevel() throws MMTFException {

		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) getElementToEdit();
		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();

		// navigate metamodel hierarchy
		ModelElement modelElemType = null;
		ModelElementReference modelElemTypeRef = null;
		if (newDroppedEObject instanceof EClass) {
			for (EClass droppedEObject : ((EClass) newDroppedEObject).getEAllSuperTypes()) {
				URI uri = EcoreUtil.getURI(droppedEObject);
				String[] pieces = uri.toString().split(MultiModelRegistry.ECORE_METAMODEL_URI_SEPARATOR);
				String modelTypeUri = pieces[0];
				String modelElemTypeUri = pieces[1];
				ModelEndpointReference modelTypeEndpointRefOrModelTypeEndpointRefSuper = MultiModelHierarchyUtils.getEndpointReference(modelTypeUri, modelRelType.getModelEndpointRefs());
				if (modelTypeEndpointRefOrModelTypeEndpointRefSuper == null) {
					continue;
				}
				modelElemTypeUri = MultiModelLightTypeFactory.getNewExtendibleTypeUri(modelTypeEndpointRefOrModelTypeEndpointRefSuper.getObject(), null, modelElemTypeUri);
				modelElemTypeRef = MultiModelHierarchyUtils.getReference(modelElemTypeUri, modelTypeEndpointRefOrModelTypeEndpointRefSuper.getModelElemRefs());
				if (modelElemTypeRef == null) {
					continue;
				}
				modelElemType = modelElemTypeRef.getObject();
				break;
				//TODO MMTF: store # supertype levels and trigger possible reorder of inheritance chain
			}
		}
		if (modelElemType == null) {
			String modelElemTypeUri = (newDroppedEObject instanceof EReference) ?
				MMTF.ROOT_MODELELEMENT_RELATIONSHIP_URI :
				MMTF.ROOT_MODELELEMENT_ENTITY_URI;
			modelElemType = MultiModelTypeRegistry.getModelElementType(multiModel, modelElemTypeUri);
			//TODO MMTF: move getXType into a generic type registry, I need those functions for instances too (only the ones with a multiModel argument)
			//TODO MMTF: clean things in instances (order of arguments like in types, URI instead of String uri, name as argument)
			//TODO MMTF: write a todo somewhere to remember to handle the import of a model rel instance
		}

		ModelElementCategory category = MultiModelRegistry.getEObjectCategory(newDroppedEObject);
		String classLiteral = newModelElemUri; // class literal == name
		ModelElementReference newModelElemTypeRef = MultiModelLightTypeFactory.createLightModelElementTypeAndModelElementTypeReference(
			modelTypeEndpointRef,
			modelElemType,
			modelElemTypeRef,
			newModelElemUri,
			category,
			classLiteral
		);
		MAVOUtils.annotateMAVODroppedEObject(newDroppedEObject, newModelElemTypeRef);
		MMTF.initTypeHierarchy(multiModel);

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
