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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.modelepedia.z3.Z3Solver;

public class ToProduct extends OperatorImpl {
  private Input input;
  private Output output;
  private Z3Solver solver;

  private static class Input {
    public final static String MODEL = "productLine";
    public Model plModel;
    public ProductLine pl;

    public Input(Map<String, Model> inputsByName) {
      this.plModel = inputsByName.get(Input.MODEL);
      this.pl = (ProductLine) this.plModel.getEMFInstanceRoot();
    }
  }

  private static class Output {
    public final static String MODEL = "product";
    public Model productModelType;
    public EObject product;
    public String productPath;
    public MID mid;

    public Output(Map<String, MID> outputMIDsByName, String workingPath, Input input) {
      this.productModelType = MIDTypeRegistry.<Model>getType(input.pl.getMetamodel().getNsURI());
      this.productPath = workingPath + IPath.SEPARATOR + input.plModel.getName() + "." +
                         this.productModelType.getFileExtension();
      this.mid = outputMIDsByName.get(Output.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var plModel = this.productModelType.createInstanceAndEditor(this.product, this.productPath, this.mid);

      return Map.of(Output.MODEL, plModel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName, getWorkingPath(), this.input);
    this.solver = new Z3Solver();
  }

  private void toProduct() throws TimeoutException {
    //TODO ask for variable values, check that getFeatures is sat, then check vars with each presence condition
    var productModelObjs = new HashMap<String, EObject>();
    var productFactory = this.input.pl.getMetamodel().getEFactoryInstance();
    for (var plClass : this.input.pl.getClasses()) {
      if (this.solver.checkSat("(assert true)").isSAT()) {
        var productModelObj = productFactory.create(plClass.getType());
        for (var plAttribute : plClass.getAttributes()) {

        }
      }
    }
    for (var plReference : this.input.pl.getReferences()) {

    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProduct();

    return this.output.packed();
  }

}
