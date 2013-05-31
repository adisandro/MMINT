/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.library;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;

public class ExtendibleElementEndpointLabelParser extends ExtendibleElementLabelParser {

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		EObject modelObj = (EObject) element.getAdapter(EObject.class);

		return MultiModelRegistry.getEndpointLabel((ExtendibleElementEndpoint) modelObj);
	}

}
