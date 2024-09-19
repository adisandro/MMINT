/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.operators.variability;

import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public class RemoveFeature extends OperatorImpl {
  protected In in;
  protected Out out;
  private boolean featureSubstitute;

  protected static class In {
    public final static String PROP_FEATURESUB = "featureSubstitute";
    public final static boolean PROP_FEATURESUB_DEFAULT = false;
    public final static String MODEL = "pl";
    public Model plModel;

    public In(Map<String, Model> inputsByName) {
      this.plModel = inputsByName.get(In.MODEL);
    }
  }

  protected static class Out {
    public final static String MODEL = "plRemoved";
    public static final String SUFFIX = "_removed";
    public Model plModelType;
    public ProductLine plRemoved;
    public String path;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) {
      this.plModelType = in.plModel.getMetatype();
      this.plRemoved = (ProductLine) in.plModel.getEMFInstanceRoot();
      this.path = workingPath + IPath.SEPARATOR + in.plModel.getName() + Out.SUFFIX + "." +
                  in.plModel.getFileExtension();
      this.mid = outputMIDsByName.get(Out.MODEL);
    }

    public Map<String, Model> packed() throws Exception {
      var plRemovedModel = this.plModelType.createInstanceAndEditor(this.plRemoved,
                                                                    FileUtils.getUniquePath(this.path, true, false),
                                                                    this.mid);;
      return Map.of(Out.MODEL, plRemovedModel);
    }
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    this.in = new In(inputsByName);
    this.out = new Out(outputMIDsByName, getWorkingPath(), this.in);
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.featureSubstitute = MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, In.PROP_FEATURESUB,
                                                                        In.PROP_FEATURESUB_DEFAULT);
  }

  protected void remove() throws Exception {
    for (var plIter = this.out.plRemoved.eAllContents(); plIter.hasNext();) {
      var plElem = plIter.next();
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    remove();

    return this.out.packed();
  }
}
