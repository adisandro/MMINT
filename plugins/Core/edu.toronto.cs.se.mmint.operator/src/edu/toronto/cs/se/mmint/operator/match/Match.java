/**
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
package edu.toronto.cs.se.mmint.operator.match;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Match extends UntypedMatch {

    // constants
    private final static @NonNull String OVERLAP_TYPE_URI = "http://se.cs.toronto.edu/mmint/Overlap";

    public static class Constraint extends UntypedMatch.Constraint {

        @Override
        public boolean checkInputs(@NonNull Map<String, Model> inputsByName) {

            boolean isAllowed = super.checkInputs(inputsByName);
            if (!isAllowed) {
                return false;
            }
            UntypedMatch.Input input = new UntypedMatch.Input(inputsByName);
            if (!input.model1.getMetatypeUri().equals(input.model2.getMetatypeUri())) {
                //TODO MMINT[POLY] Use instanceOf when it's optimized (automatic caching of runtime types)
                return false;
            }

            return true;
        }
    }

    @Override
    protected void init() {

        this.modelRelType = MIDTypeRegistry.getType(OVERLAP_TYPE_URI);
        this.modelTypeEndpoint = this.modelRelType.getModelEndpoints().get(0);
        this.mappingType = this.modelRelType.getMappings().get(0);
        this.modelElemTypeEndpoint = this.mappingType.getModelElemEndpoints().get(0);
    }

    @Override
    protected void createMatchLinks(ModelRel overlapRel, Map<String, Set<EObject>> modelObjAttrs, Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {

        Iterator<Entry<String, Set<EObject>>> iter = modelObjAttrs.entrySet().iterator();
        while (iter.hasNext()) {
            Set<EObject> modelObjs = iter.next().getValue();
            if (modelObjs.size() < 2) {
                continue;
            }
            EClass modelObjClass = null;
            for (EObject modelObj : modelObjs) {
                if (modelObjClass == null) {
                    modelObjClass = modelObj.eClass();
                }
                else if (modelObjClass != modelObj.eClass()) { // remove entries that don't share the same type
                    iter.remove();
                    break;
                }
            }
        }
        super.createMatchLinks(overlapRel, modelObjAttrs, modelObjTable);
    }

}
