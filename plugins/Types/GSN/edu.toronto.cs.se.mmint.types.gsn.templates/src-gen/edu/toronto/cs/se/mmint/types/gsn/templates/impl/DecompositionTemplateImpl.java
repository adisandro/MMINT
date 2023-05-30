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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decomposition Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DecompositionTemplateImpl extends TemplateImpl implements DecompositionTemplate {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DecompositionTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.DECOMPOSITION_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void decompose(Goal decomposed, GSNTemplatesBuilder builder) throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER:
        try {
          decompose((Goal)arguments.get(0), (GSNTemplatesBuilder)arguments.get(1));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * @generated NOT
   */
  @Override
  public GSNBuilder instantiate(SafetyCase safetyCase, EList<EObject> selection) throws Exception {
    var builder = new GSNTemplatesBuilder(safetyCase);
    if (selection.size() > 1) {
      throw new MMINTException("Only one goal must be selected in a goal decomposition");
    }
    var selected = selection.get(0);
    if (!(selected instanceof Goal goal)) {
      throw new MMINTException("The selected element to be decomposed is not a goal");
    }
    decompose(goal, builder);

    return builder;
  }

} //DecompositionTemplateImpl
