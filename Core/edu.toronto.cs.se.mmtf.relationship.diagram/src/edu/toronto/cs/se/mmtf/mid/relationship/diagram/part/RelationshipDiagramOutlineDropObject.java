/**
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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;

public class RelationshipDiagramOutlineDropObject {

	private EObject modelObj;
	private boolean isInstancesLevel;
	private ModelEndpointReference modelEndpointRef;
	private ModelElement modelElemType;
	private String modelElemUri;

	public RelationshipDiagramOutlineDropObject(EObject modelObj, boolean isInstancesLevel, ModelEndpointReference modelEndpointRef, ModelElement modelElementType, String modelElemUri) {

		this.modelObj = modelObj;
		this.isInstancesLevel = isInstancesLevel;
		this.modelEndpointRef = modelEndpointRef;
		this.modelElemType = modelElementType;
		this.modelElemUri = modelElemUri;
	}

	public EObject getModelObject() {

		return modelObj;
	}

	public boolean isInstancesLevel() {

		return isInstancesLevel;
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
