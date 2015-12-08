/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.HashMap;
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;

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

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		henshinFileName = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_HENSHINFILENAME);
	}

	private EObject transform(Model originalModel) throws MMINTException {

		// init
		String originalModelDirectoryUri = MultiModelUtils.prependWorkspaceToUri(
			MultiModelUtils.replaceLastSegmentInUri(originalModel.getUri(), ""));
		HenshinResourceSet hResourceSet = new HenshinResourceSet(originalModelDirectoryUri);
		Module hModule = hResourceSet.getModule(henshinFileName, false);
		Engine hEngine = new EngineImpl();
		hEngine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
		EGraph hGraph = new EGraphImpl(hResourceSet.getResource(MultiModelUtils.getLastSegmentFromUri(
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
		Model origModel = inputsByName.get(IN_MODEL);

		// transform
		EObject transformedRootModelObj = transform(origModel);

		// output
		String transformedModelUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.addFileNameSuffixInUri(origModel.getUri(), TRANSFORMED_MODEL_SUFFIX),
			true,
			false);
		MultiModelUtils.writeModelFile(transformedRootModelObj, transformedModelUri, true);
		Model transformedModelType = MultiModelTypeRegistry.getType(
			transformedRootModelObj.eClass().getEPackage().getNsURI());
		Model transformedModel = transformedModelType.createInstanceAndEditor(
			transformedModelUri,
			outputMIDsByName.get(OUT_MODEL));
		BinaryModelRel traceRel = MultiModelTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpointsAndReferences(
			null,
			origModel,
			transformedModel,
			outputMIDsByName.get(OUT_MODELREL));
		traceRel.setName(OUT_MODELREL);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, transformedModel);
		outputsByName.put(OUT_MODELREL, traceRel);

		return outputsByName;
	}

}
