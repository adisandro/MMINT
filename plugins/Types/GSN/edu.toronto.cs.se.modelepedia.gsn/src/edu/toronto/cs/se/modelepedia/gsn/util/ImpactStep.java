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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public abstract class ImpactStep<T> {
  protected T impacted;
  protected List<EObject> trace;

  public ImpactStep(T impacted) {
    this.impacted = impacted;
    this.trace = new ArrayList<>();
  }

  public ImpactStep(T impacted, List<EObject> trace) {
    this.impacted = impacted;
    this.trace = trace;
  }

  public abstract List<? extends ImpactStep<T>> nextSteps(Object change);
  public abstract void impact(Object change) throws Exception;
}
