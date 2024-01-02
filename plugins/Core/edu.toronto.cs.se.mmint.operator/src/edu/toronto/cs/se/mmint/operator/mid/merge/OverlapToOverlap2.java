/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class OverlapToOverlap2 extends OverlapToOverlap {

    // input-output
    private final static @NonNull String IN_MODELREL = "overlap";
    private final static @NonNull String OUT_MODELREL = "overlap2";

    @Override
    protected @NonNull ModelRel convert(@NonNull ModelRel origRel, @NonNull String origType, @NonNull String convType,
                                        @Nullable MID instanceMID) throws Exception {

        ModelRel convRel = super.convert(origRel, origType, convType, instanceMID);
        MappingReference extraMappingRef = convRel.getMetatype().getMappings().get(1)
            .createInstanceAndReference(false, convRel);
        extraMappingRef.getObject().setName("extra");

        return convRel;
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        // input
        ModelRel overlapRel = (ModelRel) inputsByName.get(IN_MODELREL);
        MID instanceMID = outputMIDsByName.get(OUT_MODELREL);

        // convert Overlap to Overlap2
        ModelRel overlapRel2 = this.convert(overlapRel, "Overlap", "Overlap2", instanceMID);

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MODELREL, overlapRel2);

        return outputsByName;
    }

}
