/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.productline.PLElement;
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
      this.plRemoved = EcoreUtil.copy((ProductLine) in.plModel.getEMFInstanceRoot());
      this.path = workingPath + IPath.SEPARATOR + in.plModel.getName() + Out.SUFFIX + "." +
                  in.plModel.getFileExtension();
      this.mid = outputMIDsByName.get(Out.MODEL);
    }

    public Map<String, Model> packed() throws Exception {
      var plRemovedModel = this.plModelType.createInstanceAndEditor(this.plRemoved,
                                                                    FileUtils.getUniquePath(this.path, true, false),
                                                                    this.mid);
      return Map.of(Out.MODEL, plRemovedModel);
    }
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    this.in = new In(inputsByName);
    this.out = new Out(outputMIDsByName, getWorkingPath(), this.in);
  }

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    this.featureSubstitute = MIDOperatorIOUtils.getBoolProp(inputProperties, In.PROP_FEATURESUB,
                                                            Optional.of(In.PROP_FEATURESUB_DEFAULT));
  }

  protected void remove() throws Exception {
    var feature = MIDDialogs.getStringInput("Remove feature", "Insert the feature to remove", null);
    var featureValues = Map.of(feature, this.featureSubstitute);
    var reasoner = this.out.plRemoved.getReasoner();
    var featureLiteral = (this.featureSubstitute) ? reasoner.getTrueLiteral() : reasoner.getFalseLiteral();
    // remove from feature model
    var featureConstraint = this.out.plRemoved.getFeaturesConstraint();
    if (featureConstraint.contains(feature)) {
      if (!reasoner.checkConsistency(featureConstraint, featureValues)) {
        throw new MMINTException("Feature model '" + featureConstraint + "' is unsatisfiable when removing feature '" +
                                 feature + "'");
      }
      featureConstraint = reasoner.simplify(featureConstraint.replace(feature, featureLiteral));
      this.out.plRemoved.setFeaturesConstraint(featureConstraint);
    }
    // remove from presence conditions
    var toRemove = new HashSet<PLElement>();
    for (var plIter = this.out.plRemoved.eAllContents(); plIter.hasNext();) {
      var plModelObj = (PLElement) plIter.next();
      var pc = plModelObj.getPresenceCondition();
      if (pc.contains(feature)) {
        if (reasoner.checkConsistency(pc, featureValues)) {
          pc = reasoner.simplify(pc.replace(feature, featureLiteral));
          plModelObj.setPresenceCondition(pc);
        }
        else {
          toRemove.add(plModelObj);
        }
      }
    }
    EcoreUtil.deleteAll(toRemove, false);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    remove();

    return this.out.packed();
  }
}
