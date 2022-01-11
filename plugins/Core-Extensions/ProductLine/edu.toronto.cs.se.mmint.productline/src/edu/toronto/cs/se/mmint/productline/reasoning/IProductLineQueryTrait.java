/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.reasoning;

import java.util.Set;
import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.productline.PLElement;

/**
 * The specification of a reasoning trait to query product lines.
 *
 * @author Alessio Di Sandro
 */
public interface IProductLineQueryTrait extends IQueryTrait {

  interface AggregatorLambda {
    Object apply(Object a, Object b);
  }

  default Set<String> getPresenceConditions(Set<PLElement> plElements) {
    return plElements.stream()
      .map(e -> e.getPresenceCondition())
      .filter(pc -> pc != null && !pc.strip().equals("true"))
      .collect(Collectors.toSet());
  }

  /**
   * Checks whether a set of product line elements are in a same product, according to their presence conditions and the
   * product line feature model.
   *
   * @param plElements
   *          The set of product line elements, within the same product line.
   * @throws MMINTException
   *           If a reasoner to check product line feature constraints is not available.
   * @return True if all the elements are in a same product, false otherwise.
   */
  boolean areInAProduct(Set<PLElement> plElements) throws MMINTException;
}
