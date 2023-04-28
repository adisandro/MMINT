/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.kotlin;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmint.kotlin.structs.MkTree;
import edu.toronto.cs.se.mmint.kotlin.structs.Object;
import edu.toronto.cs.se.mmint.kotlin.structs.Tree;
import edu.toronto.cs.se.mmint.kotlin.structs.VarObj;
import edu.toronto.cs.se.mmint.kotlin.utils.KotlinConverter;
import edu.toronto.cs.se.mmint.productline.PLElement;

public class PLKotlinConverter extends KotlinConverter {

  @Override
  protected EObject kTreeToEObject(Tree<? extends Object> kTree, EPackage modelPackage) {
    var modelObj = super.kTreeToEObject(kTree, modelPackage);
    var kObj = ((MkTree<? extends Object>) kTree).getNode();
    if (kObj instanceof VarObj kVarObj) {
      var pc = kVarObj.getPcond();
      if (pc != null && !pc.isBlank()) {
        ((PLElement) modelObj).setPresenceCondition(pc);
      }
    }

    return modelObj;
  }

}
