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
package edu.toronto.cs.se.mmint.mid.diagram.library;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;

public class ExtendibleElementEndpointLabelParser extends ExtendibleElementLabelParser {

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		ExtendibleElementEndpoint midElementEndpoint = (ExtendibleElementEndpoint) element.getAdapter(EObject.class);

		return super.getEndpointLabel(midElementEndpoint);
	}

}
