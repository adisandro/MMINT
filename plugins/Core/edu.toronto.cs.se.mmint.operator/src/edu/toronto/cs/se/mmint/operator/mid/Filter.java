/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class Filter extends OperatorImpl {

  private Input input;
  private Output output;
  private final static @NonNull String PROP_OUT_TIMEOVERHEAD = "timeOverhead";
  private boolean timeOverheadEnabled;
  private long timeOverhead;
  private long timeCheckpoint;

  private static class Input {
    private final static @NonNull String IN_MID = "mid";
    private final static @NonNull String GENERIC_MODELTYPE = "TYPE";
    private Model midModel;
    private Model filterType;
    private EList<Model> polyFilterTypes;
    private boolean isRelFilter;
    private boolean isUnaryRelFilter;

    public Input(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName) {
      this.midModel = inputsByName.get(Input.IN_MID);
      this.filterType = (Model) genericsByName.get(Input.GENERIC_MODELTYPE);
      this.isRelFilter = this.filterType instanceof ModelRel;
      // a unary rel filter is a special type of model filter, where the model constraint is contained in the rel type
      this.isUnaryRelFilter =
        this.isRelFilter &&
        ((ModelRel) this.filterType).getModelEndpointRefs().size() == 1 &&
        ((ModelRel) this.filterType).getModelEndpointRefs().get(0).getObject().getUpperBound() == 1 &&
        ((ModelRel) this.filterType).getMappingRefs().size() == 0;
      this.polyFilterTypes = (Boolean.parseBoolean(
        MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED))) ?
          ECollections.asEList(MIDTypeHierarchy.getSubtypes(this.filterType)) :
          ECollections.newBasicEList();
      this.polyFilterTypes.add(this.filterType);
    }
  }

  private static class Output {
    private final static @NonNull String OUT_MID = "filteredMid";
    private final static @NonNull String FILTERED_MID_NAME = "filtered";
    private Model filteredMIDModel;
    private MID mid;

    public Output(@NonNull Map<String, MID> outputMIDsByName) {
      this.mid = outputMIDsByName.get(Output.OUT_MID);
    }

    public @NonNull Map<String, Model> packed() {
      Map<String, Model> outputsByName = new HashMap<>();
      outputsByName.put(Output.OUT_MID, this.filteredMIDModel);
      return outputsByName;
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType,
                                    List<OperatorInput> inputs) {
      final var FILTER_URI = "http://se.cs.toronto.edu/mmint/Operator_Filter";
      final var FILTERNOT_URI = "http://se.cs.toronto.edu/mmint/Operator_FilterNot";
      final var MAP_URI = "http://se.cs.toronto.edu/mmint/Operator_Map";
      final var REDUCE_URI = "http://se.cs.toronto.edu/mmint/Operator_Reduce";
      var genericTypeUri = genericType.getUri();
      if (
        genericTypeUri.equals(FILTER_URI) || genericTypeUri.equals(FILTERNOT_URI) ||
        genericTypeUri.equals(MAP_URI) || genericTypeUri.equals(REDUCE_URI)
      ) {
        return false;
      }

      return true;
    }

    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                 Map<String, Model> inputsByName,
                                                                 Map<String, Model> outputsByName) {
      final var MIDREL_ID = "http://se.cs.toronto.edu/mmint/MIDRel";
      var input = new Input(inputsByName, genericsByName);
      if (input.midModel.getMetatypeUri().equals(MIDREL_ID) && input.isRelFilter && !input.isUnaryRelFilter) {
        var filteredMIDModel = outputsByName.get(Output.OUT_MID);
        filteredMIDModel.setMetatypeUri(MIDREL_ID);
      }
      return Map.of();
    }
  }

  @Override
  public void readInputProperties(Properties inputProps) throws MMINTException {
    this.timeOverheadEnabled = MIDOperatorIOUtils.getOptionalBoolProperty(
                                 inputProps, Filter.PROP_OUT_TIMEOVERHEAD+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX, false);
  }

  private void init(@NonNull Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                    @NonNull Map<String, MID> outputMIDsByName) {
    if (this.timeOverheadEnabled) {
      this.timeCheckpoint = System.nanoTime();
    }
    this.input = new Input(inputsByName, genericsByName);
    this.output = new Output(outputMIDsByName);
  }

  public void writeOutputProperties() throws Exception {
    var outProps = new Properties();
    outProps.setProperty(Filter.PROP_OUT_TIMEOVERHEAD, String.valueOf(this.timeOverhead));
    MIDOperatorIOUtils.writeOutputProperties(this, outProps);
  }

  protected boolean isFiltered(@NonNull Model model) {

    var polyIter = MIDTypeHierarchy.getInverseTypeHierarchyIterator(this.input.polyFilterTypes);
    while (polyIter.hasNext()) { // start from the most specialized filter backwards
      var polyFilterType = polyIter.next();
      var filterTypeUri = (this.input.isUnaryRelFilter) ?
        ((ModelRel) polyFilterType).getModelEndpointRefs().get(0).getTargetUri() :
        polyFilterType.getUri();
      if (!MIDTypeHierarchy.instanceOf(model, filterTypeUri, false)) {
        continue;
      }
      try {
        return model.validateInstanceType(polyFilterType);
      }
      catch (Exception e) {
        continue;
      }
    }

    return false;
  }

  // filter mid models based on property attached to type
  protected void filter() throws Exception {

    var filteredMID = (MID) this.input.midModel.getEMFInstanceRoot();
    Set<Model> modelsToDelete = new HashSet<>();
    for (Model model : filteredMID.getModels()) {
      // check constraint only if types are: Model and Model, Model and unary ModelRel, ModelRel and ModelRel
      var isRel = model instanceof ModelRel;
      if (
        (!isRel && this.input.isRelFilter && !this.input.isUnaryRelFilter) ||
        (isRel && this.input.isRelFilter && this.input.isUnaryRelFilter) ||
        (isRel && !this.input.isRelFilter)
      ) {
        continue;
      }
      if (this.isFiltered(model)) {
        continue;
      }
      modelsToDelete.add(model);
    }
    //TODO MMINT[FILTER] Should it be more selective, keeping only models/rels connected to filtered rels/models?
    for (Model modelToDelete : modelsToDelete) {
      if (modelToDelete.getMIDContainer() == null) {
        // already deleted as side effect of another deletion e.g. model delete that triggers model rel delete
        continue;
      }
      modelToDelete.deleteInstance();
    }

    var filteredMIDModelPath = FileUtils.getUniquePath(
      FileUtils.replaceFileNameInPath(this.input.midModel.getUri(), Output.FILTERED_MID_NAME), true, false);
    this.output.filteredMIDModel = MIDTypeRegistry.getMIDModelType()
      .createInstanceAndEditor(filteredMID, filteredMIDModelPath, this.output.mid);
    // reset input mid's cached EMF fields, or they will point to the filtered ones
    this.input.midModel.setEMFInstanceResource(null);
    this.input.midModel.setEMFInstanceRoot(null);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {

    init(inputsByName, genericsByName, outputMIDsByName);
    filter();
    if (this.timeOverheadEnabled) {
      this.timeOverhead = System.nanoTime() - this.timeCheckpoint;
      writeOutputProperties();
    }

    return this.output.packed();
  }

}
