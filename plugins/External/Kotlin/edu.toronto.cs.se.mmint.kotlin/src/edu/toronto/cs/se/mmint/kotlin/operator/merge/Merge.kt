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
package edu.toronto.cs.se.mmint.kotlin.operator.merge

import edu.toronto.cs.se.mmint.mid.Model
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel
import org.eclipse.emf.ecore.EObject

class Merge {
  fun merge(model1: Model, model2: Model, overlap: ModelRel): EObject {
    val rootModelObj1 = model1.getEMFInstanceRoot();
    val modelFactory = rootModelObj1.eClass().getEPackage().getEFactoryInstance();
    val rootMergedModelObj = modelFactory.create(rootModelObj1.eClass());
    return rootMergedModelObj
  }
}
