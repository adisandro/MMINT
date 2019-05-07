/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactType;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;
import edu.toronto.cs.se.modelepedia.safetycase.StatefulElement;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNAnnotateRel extends GSNAnnotate {

    // input-output
    private final static @NonNull String IN_REVISE = "revise";
    private final static @NonNull String IN_RECHECK_CONTENT = "recheck_content";
    private final static @NonNull String IN_RECHECK_STATE = "recheck_state";
    private final static @NonNull String OUT_GSN = "annotated";
    // constants
    private final static @NonNull String OUT_SUFFIX = "_annotated";

    private static class Input {

        private ModelRel reviseRel;
        private ModelRel recheckContentRel;
        private ModelRel recheckStateRel;
        private Model scModel;

        public Input(Map<String, Model> inputsByName) {

            this.reviseRel = (ModelRel) inputsByName.get(IN_REVISE);
			this.recheckContentRel = (ModelRel) inputsByName.get(IN_RECHECK_CONTENT);
			this.recheckStateRel = (ModelRel) inputsByName.get(IN_RECHECK_STATE);
			
            this.scModel = this.reviseRel.getModelEndpoints().get(0).getTarget();
            Model sameSCModelContent = this.recheckContentRel.getModelEndpoints().get(0).getTarget();
            Model sameSCModelState = this.recheckStateRel.getModelEndpoints().get(0).getTarget();
            if (
                !this.scModel.getUri().equals(sameSCModelContent.getUri()) ||
            	!this.scModel.getUri().equals(sameSCModelState.getUri())
            ) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static class Constraint implements IJavaOperatorConstraint {

        @Override
        public boolean isAllowedInput(@NonNull Map<String, Model> inputsByName) {

            try {
                new Input(inputsByName);
                return true;
            }
            catch (IllegalArgumentException e) {
                return false;
            }
        }
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        //TODO change to use model rels as input
        // Extract the model relationships that point to GSN elements requiring revision or rechecking.
        Input input = new Input(inputsByName);
        MID outputMID = outputMIDsByName.get(OUT_GSN);

        // annotate elements to be revised/rechecked/reused in the safety case model
        Model annotSCModel = annotate(input.scModel, input.reviseRel, input.recheckContentRel, input.recheckStateRel,
                                      outputMID);

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_GSN, annotSCModel);

        return outputsByName;
    }

}
