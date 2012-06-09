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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

/**
 * The command to add a model element reference to a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkAddModelElementReferenceCommand extends LinkElementRefsCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source link.
	 * @param target
	 *            The target model element reference.
	 */
	public LinkAddModelElementReferenceCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	/**
	 * Checks if a model element reference can be added.
	 * 
	 * @return True if a model element reference can be added, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() &&
			MultiModelConstraintChecker.isAllowedModelElementReference(getSource(), getTarget());
	}

}
