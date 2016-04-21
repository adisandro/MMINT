/*
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class ClassReferenceCreateCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final EObject source;

	/**
	* @generated
	*/
	private final EObject target;

	/**
	* @generated
	*/
	private final edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline container;

	/**
	* @generated
	*/
	public ClassReferenceCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null
				&& false == source instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) {
			return false;
		}
		if (target != null
				&& false == target instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.policies.ICSE15_SequenceDiagram_MAVOBaseItemSemanticEditPolicy
				.getLinkConstraints().canCreateClassReference_4001(getContainer(), getSource(), getTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference newElement = edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOFactory.eINSTANCE
				.createClassReference();
		getContainer().getClass_().add(newElement);
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);

	}

	/**
	* @generated
	*/
	protected void doConfigure(edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference newElement,
			IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	* @generated
	*/
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline getSource() {
		return (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) source;
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class getTarget() {
		return (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class) target;
	}

	/**
	* @generated
	*/
	public edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline getContainer() {
		return container;
	}

	/**
	* Default approach is to traverse ancestors of the source to find instance of container.
	* Modify with appropriate logic.
	* @generated
	*/
	private static edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline deduceContainer(EObject source,
			EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) {
				return (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) element;
			}
		}
		return null;
	}

}
