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
package edu.toronto.cs.se.mmint.operator.mid.merge;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public abstract class OverlapToOverlap extends OperatorImpl {

    protected @NonNull ModelRel convert(@NonNull ModelRel origRel, @NonNull String origType, @NonNull String convType,
                                        @Nullable MID instanceMID) throws Exception {

        ModelRel convRel = (ModelRel) origRel.getMetatype().copyInstance(origRel, origRel.getName(), instanceMID);
        convRel.setMetatypeUri(convRel.getMetatypeUri().replace(origType, convType));
        for (ModelEndpoint modelEndpoint : convRel.getModelEndpoints()) {
            modelEndpoint.setMetatypeUri(modelEndpoint.getMetatypeUri().replace(origType, convType));
        }
        for (Mapping mapping : convRel.getMappings()) {
            mapping.setMetatypeUri(mapping.getMetatypeUri().replace(origType, convType));
            for (ModelElementEndpoint modelElemEndpoint : mapping.getModelElemEndpoints()) {
                modelElemEndpoint.setMetatypeUri(modelElemEndpoint.getMetatypeUri().replace(origType, convType));
            }
        }

        return convRel;
    }

}
