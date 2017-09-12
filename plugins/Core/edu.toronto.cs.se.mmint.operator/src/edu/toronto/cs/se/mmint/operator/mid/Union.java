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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDDiagramViewProvider;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Union extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MIDS = "mids";
	private final static @NonNull String OUT_MID = "unionMid";
	// constants
	private final static @NonNull String UNION_SEPARATOR = "+";

	private @NonNull MID union(@NonNull List<Model> inputMIDModels) throws MMINTException, IOException {

		MID unionMID = MIDFactory.eINSTANCE.createMID();
		unionMID.setLevel(MIDLevel.INSTANCES);
		// models only at first pass
		List<MID> inputMIDs = new ArrayList<MID>();
		for (Model inputMIDModel : inputMIDModels) {
			MID inputMID = (MID) inputMIDModel.getEMFInstanceRoot();
			inputMIDs.add(inputMID); // avoids to read the files again later
			for (Model model : inputMID.getModels()) {
				if (model instanceof ModelRel || unionMID.getExtendibleElement(model.getUri()) != null) {
					continue;
				}
				model.getMetatype().createInstanceAndEditor(null, model.getUri(), unionMID);
			}
		}
		// model rels at second pass
		for (MID inputMID : inputMIDs) {
			for (ModelRel rel : inputMID.getModelRels()) {
				rel.getMetatype().copyInstance(rel, rel.getName(), unionMID);
			}
		}

		return unionMID;
	}

	private void createModelShortcuts(MID unionMID, Model unionMIDModel) throws Exception {

		String unionMIDDiagramPath = null;
		Diagram unionMIDDiagramRoot = null;
		MIDDiagramViewProvider gmfViewProvider = null;
		Model midModelType = null;
		String midDiagramPluginId = null;
		for (ModelRel rel : unionMID.getModelRels()) {
			for (ModelEndpoint modelEndpoint : rel.getModelEndpoints()) {
				if (unionMID.getExtendibleElement(modelEndpoint.getTargetUri()) != null) {
					continue;
				}
				// create a model shortcut
				if (unionMIDDiagramPath == null) {
					unionMIDDiagramPath = MIDRegistry.getModelDiagram(unionMIDModel).getUri();
					unionMIDDiagramRoot = (Diagram) FileUtils.readModelFile(unionMIDDiagramPath, true);
					gmfViewProvider = new MIDDiagramViewProvider();
					midModelType = MIDTypeRegistry.getMIDModelType();
					midDiagramPluginId = MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName();
				}
				GMFUtils.createGMFNodeShortcut(
					modelEndpoint.getTarget(),
					unionMIDDiagramRoot,
					midDiagramPluginId,
					midModelType.getName(),
					gmfViewProvider);
			}
		}
		if (unionMIDDiagramPath != null) { // store the gmf diagram
			FileUtils.writeModelFile(unionMIDDiagramRoot, unionMIDDiagramPath, true);
		}
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		List<Model> inputMIDModels = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MIDS);
		MID instanceMID = outputMIDsByName.get(OUT_MID);

		// create union of input mids
		MID unionMID = this.union(inputMIDModels);

		// output
		String unionMIDModelName = inputMIDModels.stream()
			.map(Model::getName)
			.collect(Collectors.joining(UNION_SEPARATOR));
		String unionMIDModelPath = FileUtils.replaceFileNameInPath(
			MIDRegistry.getModelUri(instanceMID),
			unionMIDModelName);
		Model unionMIDModel = MIDTypeRegistry.getMIDModelType().createInstanceAndEditor(
			unionMID,
			unionMIDModelPath,
			instanceMID);
		this.createModelShortcuts(unionMID, unionMIDModel);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, unionMIDModel);

		return outputsByName;
	}

}
