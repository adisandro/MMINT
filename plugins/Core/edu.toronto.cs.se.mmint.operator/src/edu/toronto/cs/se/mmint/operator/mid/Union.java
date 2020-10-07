/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
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

  private Input input;
  private Output output;
	// constants
	private final static @NonNull String UNION_SEPARATOR = "+";

  private static class Input {
    private final static String IN_MIDS = "mids";
    private List<Model> midModels;

    public Input(Map<String, Model> inputsByName) {
      this.midModels = MIDOperatorIOUtils.getVarargs(inputsByName, Input.IN_MIDS);
    }
  }

  private static class Output {
    private final static String OUT_MID = "unionMid";
    private final static String UNION_NAME = "union";
    private MID instanceMID;
    private MID unionMID;
    private Model unionMIDModel;

    public Output(Input input, Map<String, MID> outputMIDsByName) throws MMINTException {
      this.instanceMID = outputMIDsByName.get(Output.OUT_MID);
      this.unionMID = MIDFactory.eINSTANCE.createMID();
      this.unionMID.setLevel(MIDLevel.INSTANCES);
    }

    public Map<String, Model> packed() {
      return Map.of(Output.OUT_MID, this.unionMIDModel);
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                        Map<String, Model> inputsByName, Map<String, Model> outputsByName) {
      final var MIDREL_ID = "http://se.cs.toronto.edu/mmint/MIDRel";
      var input = new Input(inputsByName);
      if (input.midModels.stream().allMatch(m -> m.getMetatypeUri().equals(MIDREL_ID))) {
        var unionMIDModel = outputsByName.get(Output.OUT_MID);
        unionMIDModel.setMetatypeUri(MIDREL_ID);
      }
      return Map.of();
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.input = new Input(inputsByName);
    this.output = new Output(this.input, outputMIDsByName);
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
          unionMIDDiagramRoot = (Diagram) FileUtils.readModelFile(unionMIDDiagramPath, null, true);
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
        unionMID.getExtendibleTable().put(modelEndpoint.getTargetUri(), modelEndpoint.getTarget());
      }
    }
    if (unionMIDDiagramPath != null) { // store the gmf diagram
      FileUtils.writeModelFile(unionMIDDiagramRoot, unionMIDDiagramPath, true);
    }
  }

	private void union() throws Exception {

		// models only at first pass
		var inputMIDs = new ArrayList<MID>();
		for (var inputMIDModel : this.input.midModels) {
			var inputMID = (MID) inputMIDModel.getEMFInstanceRoot();
			inputMIDs.add(inputMID); // avoids to read the files again later
			for (var model : inputMID.getModels()) {
				if (model instanceof ModelRel || this.output.unionMID.getExtendibleElement(model.getUri()) != null) {
					continue;
				}
				model.getMetatype().createInstanceAndEditor(null, model.getUri(), this.output.unionMID);
			}
		}
		// model rels at second pass
		for (var inputMID : inputMIDs) {
			for (ModelRel rel : inputMID.getModelRels()) {
				rel.getMetatype().copyInstance(rel, rel.getName(), this.output.unionMID);
			}
		}
    // output
    var unionMIDModelPath = FileUtils.getUniquePath(FileUtils.replaceFileNameInPath(
      MIDRegistry.getModelUri(this.output.instanceMID), Output.UNION_NAME), true, false);
    this.output.unionMIDModel = MIDTypeRegistry.getMIDModelType().createInstanceAndEditor(this.output.unionMID,
                                                                                          unionMIDModelPath,
                                                                                          this.output.instanceMID);
    createModelShortcuts(this.output.unionMID, this.output.unionMIDModel);
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			                          Map<String, MID> outputMIDsByName) throws Exception {
	  init(inputsByName, outputMIDsByName);
		union();
		return this.output.packed();
	}

}
