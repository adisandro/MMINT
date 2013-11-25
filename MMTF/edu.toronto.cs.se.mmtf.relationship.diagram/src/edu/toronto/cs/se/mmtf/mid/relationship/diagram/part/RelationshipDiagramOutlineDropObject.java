/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;

public class RelationshipDiagramOutlineDropObject {

	private Object modelObj;
	private boolean isInstancesLevel;
	private ModelEndpointReference modelEndpointRef;
	private ModelElement modelElementType;

	public RelationshipDiagramOutlineDropObject(Object modelObj, boolean isInstancesLevel, ModelElement modelElementType, ModelEndpointReference modelEndpointRef) {

		this.modelObj = modelObj;
		this.isInstancesLevel = isInstancesLevel;
		this.modelElementType = modelElementType;
		this.modelEndpointRef = modelEndpointRef;
	}

	public Object getDropObject() {

		return modelObj;
	}

	public boolean isInstancesLevel() {

		return isInstancesLevel;
	}

	public ModelElement getModelElementType() {

		return modelElementType;
	}

	public ModelEndpointReference getModelEndpointReference() {

		return modelEndpointRef;
	}

}
