/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.design.tools.CreateEdge;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNCreateEdge extends CreateEdge {

  @Override
  protected Command getCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
    return new PLCreateEdgeCommand(domain, srcClass, tgtClass, classType);
  }

  protected class PLCreateEdgeCommand extends CreateEdgeCommand {
    private GSNPackage gsn;

    public PLCreateEdgeCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
      super(domain, srcClass, tgtClass, classType);
      this.gsn = GSNPackage.eINSTANCE;
    }

    @Override
    protected @Nullable RefSpec getContainerSpec(Class edgeClass) {
      return switch (this.type) {
        default -> null;
      };
    }

    @Override
    protected @Nullable RefSpec getSrcSpec(Class edgeClass) {
      return switch (this.type) {
        case EClass e when this.gsn.getSupportedBy().isSuperTypeOf(e) ->
          new RefSpec(this.srcClass, this.gsn.getSupportable_SupportedBy(), edgeClass);
        case EClass e when this.gsn.getInContextOf().isSuperTypeOf(e) ->
          new RefSpec(this.srcClass, this.gsn.getContextualizable_InContextOf(), edgeClass);
        default -> null;
      };
    }

    @Override
    protected @Nullable RefSpec getTgtSpec(Class edgeClass) {
      return switch (this.type) {
        case EClass e when this.gsn.getSupportedBy().isSuperTypeOf(e) ->
          new RefSpec(edgeClass, this.gsn.getSupportedBy_Target(), this.tgtClass);
        case EClass e when this.gsn.getInContextOf().isSuperTypeOf(e) ->
          new RefSpec(edgeClass, this.gsn.getInContextOf_Context(), this.tgtClass);
        default -> null;
      };
    }
  }
}
