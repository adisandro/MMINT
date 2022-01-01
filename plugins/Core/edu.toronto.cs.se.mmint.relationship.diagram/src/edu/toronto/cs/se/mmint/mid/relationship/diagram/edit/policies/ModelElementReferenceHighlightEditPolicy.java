/*
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

/**
 * The highlight edit policy (a drag policy) for model element references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceHighlightEditPolicy extends NonResizableEditPolicy {

	/**
	 * Disallow dragging, so that the model element reference is just
	 * highlighted.
	 * 
	 * @return False.
	 */
	public boolean isDragAllowed() {

		return false;
	}

}
