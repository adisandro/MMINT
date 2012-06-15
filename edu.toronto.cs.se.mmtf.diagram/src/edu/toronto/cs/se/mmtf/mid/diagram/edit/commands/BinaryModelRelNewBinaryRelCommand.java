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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

/**
 * The command to create a binary model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryModelRelNewBinaryRelCommand extends BinaryModelRelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source model.
	 * @param target
	 *            The target model.
	 */
	public BinaryModelRelNewBinaryRelCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	/**
	 * Checks if a binary model relationship can be created.
	 * 
	 * @return True if a binary model relationship can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	protected BinaryModelRel doExecuteInstancesLevel() throws Exception {

		ModelRel modelRelType = MidDiagramTrait.selectModelRelTypeToCreate(getSource(), getTarget());
		BinaryModelRel newModelRel = (BinaryModelRel) MultiModelFactoryUtils.createModelRel(
			modelRelType,
			ModelOrigin.CREATED,
			getContainer(),
			null,
			RelationshipPackage.eINSTANCE.getBinaryModelRel()
		);
		newModelRel.getModels().add(getSource());
		newModelRel.getModels().add(getTarget());
		MultiModelFactoryUtils.createModelReference(newModelRel, getSource());
		MultiModelFactoryUtils.createModelReference(newModelRel, getTarget());

		return newModelRel;
	}

	protected BinaryModelRel doExecuteTypesLevel() throws MMTFException {

		MultiModel multiModel = (MultiModel) getContainer();
		ModelRel modelRelType = MidDiagramTrait.selectModelRelTypeToExtend(multiModel, getSource().getUri(), getTarget().getUri());
		String newModelRelTypeName = MidDiagramTrait.getStringInput("Create new light binary model relationship type", "Insert new binary model relationship type name");
		String constraint = MidDiagramTrait.getStringInput("Create new light binary model relationship type", "Insert new binary model relationship type constraint");
		//TODO MMTF: much more complicated actually, supertype is fine but actual model endpoints are src and tgt
		BinaryModelRel newModelRelType = (BinaryModelRel) MMTFRegistry.createLightModelRelType(
			modelRelType,
			newModelRelTypeName,
			constraint,
			RelationshipPackage.eINSTANCE.getBinaryModelRel()
		);
		MMTFRegistry.updateRepository(multiModel);
		//TODO MMTF: everything should go into createlightmodelreltype
//		newModelRelType2.getModels().add(getSource());
//		newModelRelType2.getModels().add(getTarget());
//		newModelRelType2.getModelRefs().get(0).setReferencedObject(getSource());
//		newModelRelType2.getModelRefs().get(1).setReferencedObject(getTarget());
//		for (ModelElementReference newModelElemTypeRef2 : newModelRelType2.getModelRefs().get(0).getElementRefs()) {
//			for (ModelElement modelElemType2 : getSource().getElements()) {
//				if (modelElemType2.getUri().equals(((ModelElement) newModelElemTypeRef2.getObject()).getUri())) {
//					newModelElemTypeRef2.setReferencedObject(modelElemType2);
//					break;
//				}
//			}
//		}
//		for (ModelElementReference newModelElemTypeRef2 : newModelRelType2.getModelRefs().get(1).getElementRefs()) {
//			for (ModelElement modelElemType2 : getTarget().getElements()) {
//				if (modelElemType2.getUri().equals(((ModelElement) newModelElemTypeRef2.getObject()).getUri())) {
//					newModelElemTypeRef2.setReferencedObject(modelElemType2);
//					break;
//				}
//			}
//		}

		return newModelRelType;
	}

	/**
	 * Creates a new binary model relationship.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If this command can't be executed.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}

		try {
			BinaryModelRel newElement = (MultiModelConstraintChecker.isInstancesLevel((MultiModel) getContainer())) ?
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
			MMTFException.print(MMTFException.Type.WARNING, "No binary model relationship created", e);
			return CommandResult.newErrorCommandResult("No binary model relationship created");
		}
	}

}
