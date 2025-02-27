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

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;

public abstract class ChangeStep<T> {
  protected T impacted;
  protected LinkedHashSet<EObject> trace;
  protected static Map<String, Object> data = new HashMap<>();
  public static String CHANGE_KEY = "change";

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

  public static Map<String, Object> getData() {
    return ChangeStep.data;
  }

  public abstract void baselineImpact();
  public abstract List<? extends ChangeStep<T>> nextSteps();
  public abstract void impact() throws Exception;
  public abstract void repair() throws Exception;
}
