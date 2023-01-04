/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.mid.Model;

public class CDNoPublicAttributes extends CDPublicAttributes {

  @Override
  public boolean check(Model model) {
    return !super.check(model);
  }
}
