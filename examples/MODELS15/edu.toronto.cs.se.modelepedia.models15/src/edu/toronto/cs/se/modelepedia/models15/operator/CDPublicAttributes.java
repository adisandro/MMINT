/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.models15.operator;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;

public class CDPublicAttributes implements IJavaModelConstraint {

  @Override
  public boolean check(Model model) {
    var cdRoot = (ClassDiagram) model.getEMFInstanceRoot();
    return cdRoot.getClasses().stream()
      .flatMap(c -> c.getOwnedAttributes().stream())
      .anyMatch(a -> a.isPublic());
  }
}
