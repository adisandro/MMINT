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

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.match.Match;
import edu.toronto.cs.se.modelepedia.classdiagram.Association;

public class CDMatch extends Match {

    @Override
    protected void createMatchLinks(ModelRel overlapRel, Map<String, Set<EObject>> modelObjAttrs, Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {

        Iterator<Entry<String, Set<EObject>>> iter = modelObjAttrs.entrySet().iterator();
        while (iter.hasNext()) {
            Set<EObject> modelObjs = iter.next().getValue();
            if (modelObjs.size() < 2) {
                continue;
            }
            boolean areAssociations = modelObjs.stream().allMatch(modelObj -> modelObj instanceof Association);
            if (!areAssociations) {
                continue;
            }
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
                iter.remove();
            }
        }
        super.createMatchLinks(overlapRel, modelObjAttrs, modelObjTable);
    }

}
