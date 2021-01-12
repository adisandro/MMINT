/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.z3.operator.henshin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.trace.Trace;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

//TODO MMINT[OPERATOR] Move to appropriate package+feature when they're created for core operators
//TODO MMINT[OPERATOR] Use this as base for the lifted ones
public class HenshinTransformation extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "original";
	private final static @NonNull String OUT_MODEL = "transformed";
	private final static @NonNull String OUT_MODELREL = "trace";
	private final static @NonNull String PROPERTY_IN_HENSHINFILENAME = "henshinFileName";
	// constants
	private final static @NonNull String TRANSFORMED_MODEL_SUFFIX = "_transformed";

	// input
	private String henshinFileName;

    public static class Constraint implements IJavaOperatorConstraint {

        @Override
        public @NonNull Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName, @NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName) {

            Input input = new Input(inputsByName);
            Model transformedModel = outputsByName.get(OUT_MODEL);
            ModelRel traceRel = (ModelRel) outputsByName.get(OUT_MODELREL);
            Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
            List<Model> endpointModels = new ArrayList<>();
            endpointModels.add(input.original);
            endpointModels.add(transformedModel);
            validOutputs.put(traceRel, endpointModels);

            return validOutputs;
        }

    }

    private static class Input {

        private Model original;

        public Input(Map<String, Model> inputsByName) {

            this.original = inputsByName.get(IN_MODEL);
        }
    }

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		henshinFileName = MIDOperatorIOUtils.getStringProperty(inputProperties, PROPERTY_IN_HENSHINFILENAME);
	}

	private EObject transform(Model originalModel) throws MMINTException {

		// init
		String originalModelDirectoryUri = FileUtils.prependWorkspacePath(
			FileUtils.replaceLastSegmentInPath(originalModel.getUri(), ""));
		HenshinResourceSet hResourceSet = new HenshinResourceSet(originalModelDirectoryUri);
		Module hModule = hResourceSet.getModule(henshinFileName, false);
		Engine hEngine = new EngineImpl();
		hEngine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
		EGraph hGraph = new EGraphImpl(hResourceSet.getResource(FileUtils.getLastSegmentFromPath(
			originalModel.getUri())));
		// apply rules
		for (Unit hUnit : hModule.getUnits()) {
			if (!(hUnit instanceof Rule)) {
				// TODO MMINT[HENSHIN] Add support for other constructs
				continue;
			}
			Rule hRule = (Rule) hUnit;
			RuleApplication hApplication = new RuleApplicationImpl(hEngine);
			hApplication.setRule(hRule);
			hApplication.setEGraph(hGraph);
			for (Match hMatch : hEngine.findMatches(hRule, hGraph, null)) {
				hApplication.setCompleteMatch(hMatch);
				hApplication.execute(null);
			}
		}
		// get result
		EObject transformedRootModelObj = null;
		for (EObject hRoot : hGraph.getRoots()) {
			if (hRoot instanceof Trace) {
				continue;
			}
			transformedRootModelObj = hRoot;
		}
		if (transformedRootModelObj == null) {
			throw new MMINTException("Can't retrieve transformed root model object");
		}

		return transformedRootModelObj;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
	    Input input = new Input(inputsByName);

		// transform
		EObject transformedRootModelObj = transform(input.original);

		// output
		String transformedModelPath = FileUtils.getUniquePath(
			FileUtils.addFileNameSuffixInPath(input.original.getUri(), TRANSFORMED_MODEL_SUFFIX),
			true,
			false);
		Model transformedModelType = MIDTypeRegistry.getType(
			transformedRootModelObj.eClass().getEPackage().getNsURI());
		Model transformedModel = transformedModelType.createInstanceAndEditor(
			transformedRootModelObj,
			transformedModelPath,
			outputMIDsByName.get(OUT_MODEL));
		BinaryModelRel traceRel = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			OUT_MODELREL,
			input.original,
			transformedModel,
			outputMIDsByName.get(OUT_MODELREL));
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, transformedModel);
		outputsByName.put(OUT_MODELREL, traceRel);

		return outputsByName;
	}

}
