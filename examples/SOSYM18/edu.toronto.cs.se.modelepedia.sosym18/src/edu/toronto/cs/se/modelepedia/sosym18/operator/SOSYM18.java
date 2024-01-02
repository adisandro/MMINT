/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.sosym18.operator;

import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class SOSYM18 extends RandomOperatorImpl {

  private Output output;
  private final static @NonNull String PROP_IN_POLYTYPEID = "polyTypeId";
  private final static @NonNull String PROP_IN_OTHERTYPEID = "otherTypeId";
  private final static @NonNull String PROP_IN_NUMPOLYTYPES = "numPolyTypes";
  private final static @NonNull String PROP_IN_NUMSIGNATURESITES = "numSignatureSites";
  private final static @NonNull String PROP_IN_RATIOPOLYSITES = "ratioPolySites";
  private final static @NonNull String PROP_IN_MODE = "mode";
  private String polyTypeId;
  private String otherTypeId;
  private int numPolyTypes;
  private int numSignatureSites;
  private double ratioPolySites;
  private int numPolySites;
  private int numOtherSites;

  private static class Output {
    private final static @NonNull String OUT_MID = "polyMID";
    private final static @NonNull String POLY_NAME = "poly";
    private final static @NonNull String OTHER_NAME = "other";
    private final static @NonNull String PROP_OUT_NUMPOLYMODELS = "numPolyModels";
    private final static @NonNull String PROP_OUT_NUMOTHERMODELS = "numOtherModels";
    private MID polyMIDModelContainer;
    private Model polyMIDModel;
    private int numPolyModels;
    private int numOtherModels;

    public Output(@NonNull Map<String, MID> outputMIDsByName) {
      this.polyMIDModelContainer = outputMIDsByName.get(OUT_MID);
      this.numPolyModels = 0;
      this.numOtherModels = 0;
    }

    public @NonNull Map<String, Model> packed() {
      var outputsByName = new HashMap<String, Model>();
      outputsByName.put(OUT_MID, this.polyMIDModel);
      return outputsByName;
    }
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.polyTypeId = MIDOperatorIOUtils.getStringProperty(inputProperties, PROP_IN_POLYTYPEID);
    this.otherTypeId = MIDOperatorIOUtils.getStringProperty(inputProperties, PROP_IN_OTHERTYPEID);
    this.numPolyTypes = MIDOperatorIOUtils.getIntProperty(inputProperties, PROP_IN_NUMPOLYTYPES);
    this.numSignatureSites = MIDOperatorIOUtils.getIntProperty(inputProperties, PROP_IN_NUMSIGNATURESITES);
    this.ratioPolySites = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROP_IN_RATIOPOLYSITES);
  }

  private void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) {
    this.output = new Output(outputMIDsByName);
    this.numPolySites = Math.min(this.numSignatureSites, (int) Math.ceil(this.ratioPolySites * this.numSignatureSites));
    this.numOtherSites = this.numSignatureSites - this.numPolySites;
  }

  public void writeOutputProperties() throws Exception {
    var outProps = new Properties();
    outProps.setProperty(Output.PROP_OUT_NUMPOLYMODELS, String.valueOf(this.output.numPolyModels));
    outProps.setProperty(Output.PROP_OUT_NUMOTHERMODELS, String.valueOf(this.output.numOtherModels));
    MIDOperatorIOUtils.writeOutputProperties(this, outProps);
  }

  private Model generateModel(@NonNull Model modelType, @NonNull EFactory modelTypeFactory,
                              @NonNull EClass modelTypeRootObj, @NonNull String modelName,
                              @NonNull MID polyMID) throws Exception {
    var modelPath = Path.of(getWorkingPath(), MessageFormat.format("{0}.{1}", modelName, modelType.getFileExtension()));
    var model = modelType.createInstance(modelTypeFactory.create(modelTypeRootObj), modelPath.toString(), polyMID);
    if (modelName.contains(Output.POLY_NAME)) {
      this.output.numPolyModels++;
    }
    else {
      this.output.numOtherModels++;
    }

    return model;
  }

  private void generateModels(@NonNull MID polyMID) throws Exception {
    // poly types
    var polyModelTypes = new ArrayList<Model>();
    var polyEFactories = new ArrayList<EFactory>();
    var polyEClasses = new ArrayList<EClass>();
    for (var i = 0; i < this.numPolyTypes; i++) {
      Model polyModelType = MIDTypeRegistry.getType(this.polyTypeId + i);
      polyModelTypes.add(polyModelType);
      var polyEPackage = polyModelType.getEMFTypeRoot();
      polyEFactories.add(polyEPackage.getEFactoryInstance());
      polyEClasses.add((EClass) polyEPackage.eContents().get(0));
    }
    var polyIndex = getState().nextInt(this.numPolyTypes); // start from a random poly type
    for (var i = 0; i < this.numPolySites; i++) {
      generateModel(polyModelTypes.get(polyIndex), polyEFactories.get(polyIndex), polyEClasses.get(polyIndex),
                    Output.POLY_NAME + i, polyMID);
      polyIndex = (polyIndex + 1) % this.numPolyTypes; // uniformely distributed
    }
    // other types
    if (this.numOtherSites == 0) {
      return;
    }
    Model otherModelType = MIDTypeRegistry.getType(this.otherTypeId);
    var otherEPackage = otherModelType.getEMFTypeRoot();
    var otherEFactory = otherEPackage.getEFactoryInstance();
    var otherEClass = (EClass) otherEPackage.eContents().get(0);
    for (int i = 0; i < this.numOtherSites; i++) {
      generateModel(otherModelType, otherEFactory, otherEClass, Output.OTHER_NAME + i, polyMID);
    }
  }

  private ModelRel generateModelRel(@NonNull ModelRel relType, @NonNull Model modelType,
                                    @NonNull EFactory modelTypeFactory, @NonNull EClass modelTypeRootObj,
                                    @NonNull String baseName, @NonNull MID polyMID) throws Exception {
    var models = polyMID.getModels().stream()
      .filter(m -> m.getMetatypeUri().equals(modelType.getUri()))
      .collect(Collectors.toList());
    var numModels = models.size();
    int choices;
    if (numModels > 1) { // can pick at least two existing models
      choices = 3;
    }
    else if (numModels > 0) { // can pick at least one existing model
      choices = 2;
    }
    else { // can only create new models
      choices = 1;
    }
    Model model1, model2;
    switch (getState().nextInt(choices)) {
    case 0:
    default:
      // create new rel between 2 new models
      model1 = generateModel(modelType, modelTypeFactory, modelTypeRootObj, baseName + "a", polyMID);
      model2 = generateModel(modelType, modelTypeFactory, modelTypeRootObj, baseName + "b", polyMID);
      break;
    case 1:
      // create new rel between 1 existing model and 1 new model
      model1 = models.get(getState().nextInt(numModels));
      model2 = generateModel(modelType, modelTypeFactory, modelTypeRootObj, baseName + "b", polyMID);
      break;
    case 2:
      //create new rel between existing models
      model1 = models.get(getState().nextInt(numModels));
      model2 = models.get(getState().nextInt(numModels));
      break;
    }

    //TODO It creates with endpoint types of the abstract superclass
    return relType.createInstanceAndEndpoints(null, baseName, ECollections.asEList(model1, model2), polyMID);
  }

  private void generateModelRels(@NonNull MID polyMID) throws Exception {
    // poly types
    var polyRelTypes = new ArrayList<ModelRel>();
    var polyModelTypes = new ArrayList<Model>();
    var polyEFactories = new ArrayList<EFactory>();
    var polyEClasses = new ArrayList<EClass>();
    for (var i = 0; i < this.numPolyTypes; i++) {
      ModelRel polyRelType = MIDTypeRegistry.getType(this.polyTypeId + i);
      polyRelTypes.add(polyRelType);
      var polyModelType = polyRelType.getModelEndpoints().get(0).getTarget();
      polyModelTypes.add(polyModelType);
      var polyEPackage = polyModelType.getEMFTypeRoot();
      polyEFactories.add(polyEPackage.getEFactoryInstance());
      polyEClasses.add((EClass) polyEPackage.eContents().get(0));
    }
    var polyIndex = getState().nextInt(this.numPolyTypes); // start from a random poly type
    for (var i = 0; i < this.numPolySites; i++) {
      generateModelRel(polyRelTypes.get(polyIndex), polyModelTypes.get(polyIndex), polyEFactories.get(polyIndex),
                       polyEClasses.get(polyIndex), Output.POLY_NAME + i, polyMID);
      polyIndex = (polyIndex + 1) % this.numPolyTypes; // uniformely distributed
    }
    // other types
    if (this.numOtherSites == 0) {
      return;
    }
    ModelRel otherRelType = MIDTypeRegistry.getType(this.otherTypeId);
    var otherModelType = otherRelType.getModelEndpoints().get(0).getTarget();
    var otherEPackage = otherModelType.getEMFTypeRoot();
    var otherEFactory = otherEPackage.getEFactoryInstance();
    var otherEClass = (EClass) otherEPackage.eContents().get(0);
    for (int i = 0; i < this.numOtherSites; i++) {
      generateModelRel(otherRelType, otherModelType, otherEFactory, otherEClass, Output.OTHER_NAME + i, polyMID);
    }
  }

  private void generatePolyMID() throws Exception {
    var polyMID = MIDFactory.eINSTANCE.createMID();
    polyMID.setLevel(MIDLevel.INSTANCES);
    Model polyBaseType = MIDTypeRegistry.getType(this.polyTypeId);
    if (polyBaseType instanceof ModelRel) {
      generateModelRels(polyMID);
    }
    else {
      generateModels(polyMID);
    }
    var polyMIDPath = Path.of(getWorkingPath(), MessageFormat.format("{0}.{1}", Output.POLY_NAME, MIDPackage.eNAME));
    this.output.polyMIDModel = MIDTypeRegistry.getMIDModelType()
      .createInstanceAndEditor(polyMID, polyMIDPath.toString(), this.output.polyMIDModelContainer);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    generatePolyMID();
    writeOutputProperties();

    return this.output.packed();
  }

}
