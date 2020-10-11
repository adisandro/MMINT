/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.library;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;

public class ExtendibleElementEndpointReferenceLabelParser extends ExtendibleElementReferenceLabelParser {

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		ExtendibleElementEndpointReference midElementEndpointRef = (ExtendibleElementEndpointReference) element.getAdapter(EObject.class);

		return super.getEndpointLabel(midElementEndpointRef.getObject());
	}

}
