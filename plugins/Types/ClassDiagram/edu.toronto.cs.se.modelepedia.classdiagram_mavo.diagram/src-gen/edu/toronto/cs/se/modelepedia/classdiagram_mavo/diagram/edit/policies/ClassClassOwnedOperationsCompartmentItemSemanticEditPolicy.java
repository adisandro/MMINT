/*
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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ClassClassOwnedOperationsCompartmentItemSemanticEditPolicy
		extends
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.policies.ClassDiagram_MAVOBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClassOwnedOperationsCompartmentItemSemanticEditPolicy() {
		super(
				edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Operation_3002 == req
				.getElementType()) {
			return getGEFWrapper(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.commands.OperationCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

}
