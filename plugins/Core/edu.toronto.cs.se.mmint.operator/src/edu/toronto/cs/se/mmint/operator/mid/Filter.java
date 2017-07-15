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
package edu.toronto.cs.se.mmint.operator.mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class Filter extends OperatorImpl {

    // input-output
    protected final static @NonNull String IN_MID = "mid";
    protected final static @NonNull String OUT_MID = "filteredMid";
    protected final static @NonNull String GENERIC_MODELTYPE = "TYPE";
    // constants
    protected final static @NonNull String FILTERED_MID_SUFFIX = "_filter";

    public static class Constraint implements IJavaOperatorConstraint {

        @Override
        public boolean isAllowedGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType,
                                        List<OperatorInput> inputs) {

            final String FILTER_URI = "http://se.cs.toronto.edu/mmint/Operator_Filter";
            final String FILTERNOT_URI = "http://se.cs.toronto.edu/mmint/Operator_FilterNot";
            final String MAP_URI = "http://se.cs.toronto.edu/mmint/Operator_Map";
            final String REDUCE_URI = "http://se.cs.toronto.edu/mmint/Operator_Reduce";
            if (
                genericType.getUri().equals(FILTER_URI) || genericType.getUri().equals(FILTERNOT_URI) ||
                genericType.getUri().equals(MAP_URI) || genericType.getUri().equals(REDUCE_URI)
            ) {
                return false;
            }

            return true;
        }
    }

    protected boolean isFiltered(@NonNull Model model, @NonNull Model filterModelType) {

        if ( // check constraint
            MIDTypeHierarchy.instanceOf(model, filterModelType.getUri(), false) &&
            MIDConstraintChecker.checkModelConstraint(model, filterModelType.getConstraint())
        ) {
            return true;
        }

        return false;
    }

    protected @NonNull MID filter(@NonNull Model inputMIDModel, @NonNull Model filterModelType)
                                  throws MMINTException {

        MID filteredMID = (MID) inputMIDModel.getEMFInstanceRoot();
        Set<Model> modelsToDelete = new HashSet<>();
        for (Model model : filteredMID.getModels()) {
            // check constraint only if types match (Model and Model, or ModelRel and ModelRel)
            if ((model instanceof ModelRel) != (filterModelType instanceof ModelRel)) {
                continue;
            }
            if (this.isFiltered(model, filterModelType)) {
                continue;
            }
            modelsToDelete.add(model);
        }
        for (Model modelToDelete : modelsToDelete) {
            if (modelToDelete.getMIDContainer() == null) {
                // already deleted as side effect of another deletion e.g. model delete that triggers model rel delete
                continue;
            }
            modelToDelete.deleteInstance();
        }

        return filteredMID;
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        // input
        Model inputMIDModel = inputsByName.get(IN_MID);
        Model filterModelType = (Model) genericsByName.get(GENERIC_MODELTYPE);
        MID instanceMID = outputMIDsByName.get(OUT_MID);

        // filter mid models based on property attached to type
        MID filteredMID = filter(inputMIDModel, filterModelType);

        // output
        String filteredMIDModelPath = FileUtils.getUniquePath(
            FileUtils.addFileNameSuffixInPath(inputMIDModel.getUri(), FILTERED_MID_SUFFIX),
            true,
            false);
        Model filteredMIDModel = MIDTypeRegistry.getMIDModelType()
            .createInstanceAndEditor(filteredMID, filteredMIDModelPath, instanceMID);
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MID, filteredMIDModel);

        return outputsByName;
    }

}
