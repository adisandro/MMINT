/*******************************************************************************
 * Copyright (c) 2026, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.reasoning;

import java.util.List;
import java.util.Map;

public interface IAnalysisData<T> {
  default void impactNew(int newIndex, Map<String, T> templateElems, Object... params) {}
  default void repairNew(int newIndex, Map<String, T> templateElems, Object... params) {}
  default boolean isSame(IAnalysisData<T> oldDatum) {
    return this.equals(oldDatum);
  }
  default void impactSame(IAnalysisData<T> oldDatum, int oldIndex, int newIndex, Map<String, T> templateElems,
                          Object... params) {}
  default void repairSame(IAnalysisData<T> oldDatum, int oldIndex, int newIndex, Map<String, T> templateElems,
                          Object... params) {}
  default boolean isDel(List<? extends IAnalysisData<T>> oldData) {
    return oldData.stream().anyMatch(this::isSame); // counter intuitive but correct in changeLoop logic
  }
  default void impactDel(int oldIndex, Map<String, T> templateElems, Object... params) {}
  default void repairDel(int oldIndex, Map<String, T> templateElems, Object... params) {}
}
