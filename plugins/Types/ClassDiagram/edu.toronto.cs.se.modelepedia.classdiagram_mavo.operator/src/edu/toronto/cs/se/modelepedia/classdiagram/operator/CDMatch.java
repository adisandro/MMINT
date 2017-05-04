/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram.operator;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.operator.match.Match;

public class CDMatch extends Match {

	@Override
	protected void createMatchLinks(ModelRel matchRel, Map<String, Set<EObject>> modelObjAttrs, Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {

		Mapping rootMappingType = MIDTypeHierarchy.getRootMappingType();
		ModelElementEndpoint rootModelElemTypeEndpoint = MIDTypeHierarchy.getRootModelElementTypeEndpoint();
		for (Entry<String, Set<EObject>> entry : modelObjAttrs.entrySet()) {
			Set<EObject> modelObjs = entry.getValue();
			if (modelObjs.size() < 2) {
				continue;
			}
			String modelObjAttr = entry.getKey();
			boolean associations = modelObjs.stream().allMatch(modelObj -> modelObj instanceof Association);
			if (associations) {
				Association association = (Association) modelObjs.iterator().next();
				String srcAttr = (String) FileUtils.getModelObjectFeature(association.getSource(), matchAttribute);
				Set<EObject> srcMatch = modelObjAttrs.get(srcAttr);
				String tgtAttr = (String) FileUtils.getModelObjectFeature(association.getTarget(), matchAttribute);
				Set<EObject> tgtMatch = modelObjAttrs.get(tgtAttr);
				boolean endpointsCheck =
					modelObjs.stream()
					.map(modelObj -> ((Association) modelObj).getSource())
					.allMatch(clazz -> srcMatch.contains(clazz)) &&
					modelObjs.stream()
					.map(modelObj -> ((Association) modelObj).getTarget())
					.allMatch(clazz -> tgtMatch.contains(clazz));
				if (!endpointsCheck) {
					continue;
				}
			}
			// create link
			MappingReference matchMappingRef = rootMappingType.createInstanceAndReference((modelObjs.size() == 2), matchRel);
			matchMappingRef.getObject().setName(modelObjAttr);
			for (EObject modelObj : modelObjs) {
				ModelEndpointReference modelEndpointRef = modelObjTable.get(modelObj);
				// create model element
				ModelElementReference matchModelElemRef = modelEndpointRef.createModelElementInstanceAndReference(modelObj, null);
				// create model element endpoints
				rootModelElemTypeEndpoint.createInstanceAndReference(matchModelElemRef, matchMappingRef);
			}
		}
	}

}
