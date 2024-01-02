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
package edu.toronto.cs.se.mmint.operator.patch;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.AcceleoUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class ModelRelToText extends OperatorImpl {

    private Input input;
    private Output output;
    private ModelRelToText_M2T textGenerator;

    private static class Input {

        private final static @NonNull String IN_MODELREL = "rel";
        private ModelRel rel;
        private Model firstModel;

        public Input(@NonNull Map<String, Model> inputsByName) {

            this.rel = (ModelRel) inputsByName.get(Input.IN_MODELREL);
            if (this.rel.getModelEndpoints().size() == 0) {
                // rel must have endpoints
                throw new IllegalArgumentException();
            }
            this.firstModel = this.rel.getModelEndpoints().get(0).getTarget();
        }
    }

    private static class Output {

        public Output(@NonNull Map<String, MID> outputMIDsByName) {}

        public @NonNull Map<String, Model> packed() {

            return Map.of();
        }
    }

    public static class Constraint implements IJavaOperatorConstraint {

        @Override
        public boolean checkInputs(Map<String, Model> inputsByName) {

            try {
                new Input(inputsByName);
                return true;
            }
            catch (IllegalArgumentException e) {
                return false;
            }
        }
    }

    protected void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) throws Exception {

        this.input = new Input(inputsByName);
        this.output = new Output(outputMIDsByName);
        var folder = (new File(FileUtils.prependWorkspacePath(this.input.firstModel.getUri()))).getParentFile();
        this.textGenerator = new ModelRelToText_M2T(this.input.rel, folder, List.of());
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        init(inputsByName, outputMIDsByName);
        AcceleoUtils.runAcceleo(this.textGenerator);

        return this.output.packed();
    }

}
