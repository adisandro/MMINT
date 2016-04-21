/**
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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.part;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

public class RelationshipDiagramOutlineDropObject {

	private EObject modelObj;
	private MIDLevel level;
	private ModelEndpointReference modelEndpointRef;
	private ModelElement modelElemType;
	private String modelElemUri;

	public RelationshipDiagramOutlineDropObject(EObject modelObj, MIDLevel level, ModelEndpointReference modelEndpointRef, ModelElement modelElementType, String modelElemUri) {

		this.modelObj = modelObj;
		this.level = level;
		this.modelEndpointRef = modelEndpointRef;
		this.modelElemType = modelElementType;
		this.modelElemUri = modelElemUri;
	}

	public EObject getModelObject() {

		return modelObj;
	}

	public boolean isInstancesLevel() {

		return (level == MIDLevel.INSTANCES);
	}

	public ModelEndpointReference getModelEndpointReference() {

		return modelEndpointRef;
	}

	public ModelElement getModelElementType() {

		return modelElemType;
	}

	public String getModelElementUri() {

		return modelElemUri;
	}

}
