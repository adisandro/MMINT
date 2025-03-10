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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public abstract class ChangeStep<T> {
  protected T impacted;
  protected LinkedHashSet<EObject> trace;
  protected final static Properties properties = new Properties();
  public final static String PROPS_NAME = "Change";
  public final static String DEFAULT_KEY = "default";

  public ChangeStep(T impacted, LinkedHashSet<EObject> trace) {
    this.impacted = Objects.requireNonNull(impacted);
    this.trace = Objects.requireNonNull(trace);
  }

  public ChangeStep(T impacted) {
    this(impacted, new LinkedHashSet<>(0));
  }

  public T getImpacted() {
    return this.impacted;
  }

  public LinkedHashSet<EObject> getTrace() {
    return this.trace;
  }

  public static Properties getProperties() {
    return ChangeStep.properties;
  }

  public static Properties initProperties(EObject modelObj) {
    ChangeStep.properties.clear();
    var propsPath = FileUtils.prependWorkspacePath(
      FileUtils.replaceLastSegmentInPath(MIDRegistry.getModelUri(modelObj),
                                         ChangeStep.PROPS_NAME + MIDOperatorIOUtils.PROPERTIES_SUFFIX));
    try {
      ChangeStep.properties.load(new FileInputStream(propsPath));
    }
    catch (Exception e) {}

    return ChangeStep.properties;
  }

  public abstract void baselineImpact();
  public abstract List<? extends ChangeStep<T>> nextSteps();
  public abstract void impact() throws Exception;
  public abstract void repair() throws Exception;
}
