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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.design.tools.CreateNode;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNCreateNode extends CreateNode {

  @Override
  protected Command getCommand(TransactionalEditingDomain domain, EObject container, String classType) {
    return new PLCreateNodeCommand(domain, container, classType);
  }

  protected class PLCreateNodeCommand extends CreateNodeCommand {
    private GSNPackage gsn;

    public PLCreateNodeCommand(TransactionalEditingDomain domain, EObject container, String classType) {
      super(domain, container, classType);
      this.gsn = GSNPackage.eINSTANCE;
    }

    @Override
    protected Class getContainer() {
      return switch (this.classType) {
        case EClass e when this.gsn.getRelationshipDecorator().isSuperTypeOf(e) ->
          (Class) this.container;
        default -> this.productLine.getRoot(this.gsn.getSafetyCase());
      };
    }

    @Override
    protected Class createClass() {
      return switch (this.classType) {
        case EClass e when this.gsn.getRelationshipDecorator().isSuperTypeOf(e) ->
          PLGSNFactory.eINSTANCE.createPLGSNRelationshipDecorator();
        case EClass e when this.gsn.getArgumentElement().isSuperTypeOf(e) ->
          PLGSNFactory.eINSTANCE.createPLGSNArgumentElement();
        default -> super.createClass();
      };
    }

    @Override
    protected @Nullable EReference getContainmentType() {
      return switch (this.classType) {
        case EClass e when this.gsn.getGoal().isSuperTypeOf(e) ->
          this.gsn.getSafetyCase_Goals();
        case EClass e when this.gsn.getStrategy().isSuperTypeOf(e) ->
          this.gsn.getSafetyCase_Strategies();
        case EClass e when this.gsn.getSolution().isSuperTypeOf(e) ->
          this.gsn.getSafetyCase_Solutions();
        case EClass e when this.gsn.getContext().isSuperTypeOf(e) ->
          this.gsn.getSafetyCase_Contexts();
        case EClass e when this.gsn.getJustification().isSuperTypeOf(e) ->
          this.gsn.getSafetyCase_Justifications();
        case EClass e when this.gsn.getAssumption().isSuperTypeOf(e) ->
          this.gsn.getSafetyCase_Assumptions();
        case EClass e when this.gsn.getRelationshipDecorator().isSuperTypeOf(e) ->
          this.gsn.getDecoratable_Decorators();
        default -> null;
      };
    }
  }
}
