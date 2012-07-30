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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;

/**
 * The command to create a model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelNewModelCommand extends ModelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public ModelNewModelCommand(CreateElementRequest req) {

		super(req);
	}

	/**
	 * Checks if a model can be created.
	 * 
	 * @return True if a model can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	protected Model doExecuteInstancesLevel() throws Exception {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		Editor newEditor = MidDiagramTrait.selectModelTypeToCreate();
		URI newModelUri = URI.createPlatformResourceURI(newEditor.getModelUri(), true);
		MultiModelInstanceFactory.assertModelUnique(multiModel, newModelUri);
		Model modelType = MultiModelTypeRegistry.getModelType(newEditor.getMetatype().getModelUri());
		Model newModel = MultiModelInstanceFactory.createModel(modelType, ModelOrigin.CREATED, multiModel, newModelUri);
		MultiModelInstanceFactory.addModelEditor(newEditor, multiModel);

		return newModel;
	}

	protected Model doExecuteTypesLevel() throws MMTFException {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		Model modelType = MidDiagramTrait.selectModelTypeToExtend(multiModel);
		String newModelTypeName = MidDiagramTrait.getStringInput("Create new light model type", "Insert new model type name");
		String constraint = MidDiagramTrait.getBigStringInput("Create new light model type", "Insert new model type constraint");
		Model newModelType = MultiModelTypeFactory.createLightModelType(modelType, newModelTypeName, constraint);
		MMTF.syncRepository(multiModel);

		return newModelType;
	}

	/**
	 * Creates a new model.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result, or the error result if the model could not be
	 *         created.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			Model newElement = (MultiModelConstraintChecker.isInstancesLevel((MultiModel) getElementToEdit())) ?
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
			MMTFException.print(MMTFException.Type.WARNING, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}
	}

}
