/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Rick Salay.
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
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class SOSYM18 extends OperatorImpl {

  private Output output;
  private final static @NonNull String PROP_IN_POLYTYPEID = "polyTypeId";
  private final static @NonNull String PROP_IN_OTHERTYPEID = "otherTypeId";
  private final static @NonNull String PROP_IN_NUMPOLYTYPES = "numPolyTypes";
  private final static @NonNull String PROP_IN_NUMAPPLICATIONSITES = "numApplicationSites";
  private final static @NonNull String PROP_IN_NUMNONAPPLICATIONSITES = "numNonApplicationSites";
  private final static @NonNull String PROP_IN_MODE = "mode";
  private String polyTypeId;
  private String otherTypeId;
  private int numPolyTypes;
  private int numApplicationSites;
  private int numNonApplicationSites;
  private String mode;

  private static class Output {
    private final static @NonNull String OUT_MID = "polyMID";
    private final static @NonNull String POLY_NAME = "poly";
    private final static @NonNull String OTHER_NAME = "other";
    private MID polyMIDModelContainer;
    private Model polyMIDModel;

    public Output(@NonNull Map<String, MID> outputMIDsByName) {
      this.polyMIDModelContainer = outputMIDsByName.get(OUT_MID);
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
    this.numApplicationSites = MIDOperatorIOUtils.getIntProperty(inputProperties, PROP_IN_NUMAPPLICATIONSITES);
    this.numNonApplicationSites = MIDOperatorIOUtils.getIntProperty(inputProperties, PROP_IN_NUMNONAPPLICATIONSITES);
    this.mode = MIDOperatorIOUtils.getStringProperty(inputProperties, PROP_IN_MODE);
  }

  private void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) {
      this.output = new Output(outputMIDsByName);
  }

  private void generate() throws Exception {
    var polyMID = MIDFactory.eINSTANCE.createMID();
    polyMID.setLevel(MIDLevel.INSTANCES);
    switch (this.mode) {
    case "model":
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
      var polyIndex = 0;
      for (var i = 0; i < this.numApplicationSites; i++) {
        var polyModelType = polyModelTypes.get(polyIndex);
        var polyModelPath = Path.of(getInputSubdir(), MessageFormat.format("{0}{1}.{2}", Output.POLY_NAME, i,
                                                                           polyModelType.getFileExtension()));
        polyModelType.createInstance(polyEFactories.get(polyIndex).create(polyEClasses.get(polyIndex)),
                                     polyModelPath.toString(), polyMID);
        polyIndex = (polyIndex + 1) % this.numPolyTypes;
      }
      // other types
      if (this.numNonApplicationSites == 0) {
        break;
      }
      Model otherModelType = MIDTypeRegistry.getType(this.otherTypeId);
      var otherEPackage = otherModelType.getEMFTypeRoot();
      var otherEFactory = otherEPackage.getEFactoryInstance();
      var otherEClass = (EClass) otherEPackage.eContents().get(0);
      for (int i = 0; i < this.numNonApplicationSites; i++) {
        var otherModelPath = Path.of(getInputSubdir(), MessageFormat.format("{0}{1}.{2}", Output.OTHER_NAME, i,
                                                                            otherModelType.getFileExtension()));
        otherModelType.createInstance(otherEFactory.create(otherEClass), otherModelPath.toString(), polyMID);
      }
      break;
    case "rel":
      break;
    }
    var polyMIDPath = Path.of(getInputSubdir(), MessageFormat.format("{0}.{1}", Output.POLY_NAME, MIDPackage.eNAME));
    this.output.polyMIDModel = MIDTypeRegistry.getMIDModelType()
      .createInstanceAndEditor(polyMID, polyMIDPath.toString(), this.output.polyMIDModelContainer);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    //TODO are 0 inputs ok to create a workflow?
    //TODO are the polyMID and all the models not going to be serialized because this.output.polyMIDModelContainer is null within the experiment?
    //TODO Sleep(Model) can be applied to OtherType
    init(inputsByName, outputMIDsByName);
    generate();

    return this.output.packed();
  }

}
