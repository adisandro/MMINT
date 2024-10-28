/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.operators;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.operators.bridge.ToProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNFactory;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class GSNToProductLine extends ToProductLine {

  @Override
  protected Class createPLClass(EObject modelObj, EClass plType, Map<String, Class> plClasses) {
    var plClass = switch (plType) {
      case EClass e when GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate().isSuperTypeOf(e) ->
        PLGSNFactory.eINSTANCE.createGSNPLAnalyticTemplate();
      case EClass e when GSNPackage.eINSTANCE.getTemplate().isSuperTypeOf(e) ->
        PLGSNFactory.eINSTANCE.createGSNPLTemplate();
      case EClass e when GSNPackage.eINSTANCE.getArgumentElement().isSuperTypeOf(e) ->
        PLGSNFactory.eINSTANCE.createGSNPLArgumentElement();
      default -> PLFactory.eINSTANCE.createClass();
    };
    addPLClass(plClass, modelObj, plType, plClasses);

    return plClass;
  }
}
