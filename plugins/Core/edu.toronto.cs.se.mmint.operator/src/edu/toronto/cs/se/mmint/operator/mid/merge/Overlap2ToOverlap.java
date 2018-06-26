/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Overlap2ToOverlap extends OverlapToOverlap {

    // input-output
    private final static @NonNull String IN_MODELREL = "overlap2";
    private final static @NonNull String OUT_MODELREL = "overlap";

    @Override
    protected @NonNull ModelRel convert(@NonNull ModelRel origRel, @NonNull String origType, @NonNull String convType,
                                        @Nullable MID instanceMID) throws Exception {

        ModelRel convRel = super.convert(origRel, origType, convType, instanceMID);
        convRel.getMappingRefs().get(convRel.getMappingRefs().size()-1).deleteInstanceAndReference();

        return convRel;
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        // input
        ModelRel overlapRel2 = (ModelRel) inputsByName.get(IN_MODELREL);
        MID instanceMID = outputMIDsByName.get(OUT_MODELREL);

        // convert Overlap2 to Overlap
        ModelRel overlapRel = this.convert(overlapRel2, "Overlap2", "Overlap", instanceMID);

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MODELREL, overlapRel);

        return outputsByName;
    }

}
