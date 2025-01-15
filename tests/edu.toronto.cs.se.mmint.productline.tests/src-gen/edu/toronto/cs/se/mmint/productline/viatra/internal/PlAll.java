/**
 * 
 *   Copyright (c) 2021, 2025 Alessio Di Sandro.
 *  
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License 2.0 which is available at
 *   https://www.eclipse.org/legal/epl-2.0/
 *  
 *   SPDX-License-Identifier: EPL-2.0
 *  
 *   Contributors:
 *       Alessio Di Sandro - Implementation
 *  
 */
package edu.toronto.cs.se.mmint.productline.viatra.internal;

import edu.toronto.cs.se.mmint.productline.viatra.Attribute;
import edu.toronto.cs.se.mmint.productline.viatra.ClassType;
import edu.toronto.cs.se.mmint.productline.viatra.Reference;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all patterns defined in pl.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package edu.toronto.cs.se.mmint.productline.viatra, the group contains the definition of the following patterns: <ul>
 * <li>superType</li>
 * <li>classType</li>
 * <li>reference</li>
 * <li>attribute</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class PlAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static PlAll instance() {
    if (INSTANCE == null) {
        INSTANCE = new PlAll();
    }
    return INSTANCE;
  }

  private static PlAll INSTANCE;

  private PlAll() {
    querySpecifications.add(SuperType.instance());
    querySpecifications.add(ClassType.instance());
    querySpecifications.add(Reference.instance());
    querySpecifications.add(Attribute.instance());
  }
}
