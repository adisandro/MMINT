/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public abstract class ChangeStep<T> {

  public final static String PROPS_NAME = "Change";
  public final static String RUN_EVIDENCE_ANALYSES_KEY = "runEvidenceAnalyses";
  public final static boolean RUN_EVIDENCE_ANALYSES_DEFAULT = false;
  protected final static Map<String, Object> data = new HashMap<>();
  protected T impacted;
  protected LinkedHashSet<EObject> forwardTrace;
  protected List<List<? extends ChangeStep<T>>> backwardTrace;

  public static void resetData() {
    ChangeStep.data.clear();
  }

  public static Properties initData(EObject modelObj) {
    // load new properties
    resetData();
    var propsPath = FileUtils.prependWorkspacePath(
      FileUtils.replaceLastSegmentInPath(MIDRegistry.getModelUri(modelObj),
                                         ChangeStep.PROPS_NAME + MIDOperatorIOUtils.PROPERTIES_SUFFIX));
    var props = new Properties();
    try {
      props.load(new FileInputStream(propsPath));
    }
    catch (Exception e) {}
    // read into vars
    var runEvdAnalyses = MIDOperatorIOUtils.getOptionalBoolProperty(props, ChangeStep.RUN_EVIDENCE_ANALYSES_KEY,
                                                                    ChangeStep.RUN_EVIDENCE_ANALYSES_DEFAULT);
    ChangeStep.data.put(ChangeStep.RUN_EVIDENCE_ANALYSES_KEY, runEvdAnalyses);

    return props;
  }

  public static Map<String, Object> getData() {
    return ChangeStep.data;
  }

  public ChangeStep(T impacted, LinkedHashSet<EObject> forwardTrace) {
    this.impacted = Objects.requireNonNull(impacted);
    this.forwardTrace = Objects.requireNonNull(forwardTrace);
    this.backwardTrace = new ArrayList<>();
  }

  public ChangeStep(T impacted) {
    this(impacted, new LinkedHashSet<>(0));
  }

  public T getImpacted() {
    return this.impacted;
  }

  public LinkedHashSet<EObject> getForwardTrace() {
    return this.forwardTrace;
  }

  public List<List<? extends ChangeStep<T>>> getBackwardTrace() {
    return this.backwardTrace;
  }

  public abstract List<? extends ChangeStep<T>> nextSteps();
  public abstract void baselineImpact();

  /**
   * Steps propagate top down (forward) from the initial change, but impact is assigned bottom up (backward) from the
   * solution leafs. Impact can be assigned during the step propagation phase (usually by a template), overriding bottom
   * up impact with top down. impact() is the overall procedure, nextSteps() is the top down forward step propagation,
   * baselineImpact() is the bottom up backward impact assignment.
   */
  public abstract void impact() throws Exception;
  public abstract void repair() throws Exception;
}
