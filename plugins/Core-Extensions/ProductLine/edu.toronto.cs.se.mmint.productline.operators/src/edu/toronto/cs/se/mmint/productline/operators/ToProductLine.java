/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.productline.operators;

import java.io.IOException;
import java.util.Map;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;

public class ToProductLine extends OperatorImpl {
  private Input input;
  private Output output;

  private static class Input {
    public final static String MODEL = "product";
    public Model productModel;

    public Input(Map<String, Model> inputsByName) {
      this.productModel = inputsByName.get(Input.MODEL);
    }
  }

  private static class Output {
    public static final String MODEL_TYPE_ID = "model://edu.toronto.cs.se.mmint.productline";
    public final static String MODEL = "productLine";
    public Model plModelType;
    public ProductLine productLine;
    public String plPath;
    public MID mid;

    public Output(Map<String, MID> outputMIDsByName, String workingPath, Input input) {
      this.plModelType = MIDTypeRegistry.<Model>getType(Output.MODEL_TYPE_ID);
      this.productLine = ProductLineFactory.eINSTANCE.createProductLine();
      this.plPath = workingPath + input.productModel.getName() + "." + this.plModelType.getFileExtension();
      this.mid = outputMIDsByName.get(Output.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var plModel = this.plModelType.createInstanceAndEditor(this.productLine, this.plPath, this.mid);

      return Map.of(Output.MODEL, plModel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName, getWorkingPath(), this.input);
  }

  private void toProductLine() {
    // pass 1: classes and attributes
    var product = this.input.productModel.getEMFInstanceRoot();
    for (var iter = product.eAllContents(); iter.hasNext();) {
      var pModelObj = iter.next();
      var pType = pModelObj.eClass();
      var plClass = ProductLineFactory.eINSTANCE.createClass();
      plClass.setPresenceCondition("true");
      plClass.setType(pType);
      for (var pAttribute : pType.getEAllAttributes()) {
        var plAttribute = ProductLineFactory.eINSTANCE.createAttribute();
        plClass.getAttributes().add(plAttribute);
        plAttribute.setType(pAttribute);
        plAttribute.setPresenceCondition("true");
        plAttribute.setValue(pModelObj.eGet(pAttribute).toString());
      }
    }
    // pass 2: references
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProductLine();

    return this.output.packed();
  }

}
