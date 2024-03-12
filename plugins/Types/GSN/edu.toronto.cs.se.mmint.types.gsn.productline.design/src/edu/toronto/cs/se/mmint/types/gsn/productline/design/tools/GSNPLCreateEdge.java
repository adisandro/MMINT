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
package edu.toronto.cs.se.mmint.types.gsn.productline.design.tools;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.design.tools.CreateEdge;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class GSNPLCreateEdge extends CreateEdge {

  @Override
  protected Command getCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
    return new PLCreateEdgeCommand(domain, srcClass, tgtClass, classType);
  }

  protected class PLCreateEdgeCommand extends CreateEdgeCommand {

    public PLCreateEdgeCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
      super(domain, srcClass, tgtClass, classType);
    }

    @Override
    protected @Nullable EReference getSrcReferenceType() {
      return switch (this.classType) {
        case "SupportedBy" -> GSNPackage.eINSTANCE.getSupportable_SupportedBy();
        case "InContextOf" -> GSNPackage.eINSTANCE.getContextualizable_InContextOf();
        default -> null;
      };
    }

    @Override
    protected @Nullable EReference getTgtReferenceType() {
      return switch (this.classType) {
        case "SupportedBy" -> GSNPackage.eINSTANCE.getSupportedBy_Target();
        case "InContextOf" -> GSNPackage.eINSTANCE.getInContextOf_Context();
        default -> null;
      };
    }
  }
}
