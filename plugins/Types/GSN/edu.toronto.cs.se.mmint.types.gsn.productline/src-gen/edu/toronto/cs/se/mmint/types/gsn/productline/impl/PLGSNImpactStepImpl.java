/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.impl.ClassImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNImpactStep;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PLGSNImpactStepImpl extends ClassImpl implements PLGSNImpactStep {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLGSNImpactStepImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLGSNPackage.Literals.PLGSN_IMPACT_STEP;
  }

  /**
   * @generated NOT
   */
  private EList<Class> getPreviousImpacts(Object change) {
    return getStreamOfReference(GSNPackage.eINSTANCE.getImpactStep_Trace())
      .filter(o -> o instanceof PLGSNArgumentElement)
      .map(o -> o.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status()))
      .findFirst()
      .orElseGet(() -> {
        var c = PLFactory.eINSTANCE.createClass();
        c.setType(GSNPackage.eINSTANCE.getImpactAnnotation());
        c.addAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type(), ImpactType.RECHECK.toString()); //TODO: derive from change
        return ECollections.asEList(c);
      });
  }

  /**
   * @generated NOT
   */
  @Override
  public void impact(Object change) throws Exception {
    var impacted = getReference(GSNPackage.eINSTANCE.getImpactStep_Impacted()).get(0);
    var currImpacts = impacted.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status());
    var prevImpacts = getPreviousImpacts(change);
    // stop condition: already impacted with equal or more priority
    if (!currImpacts.isEmpty()) {
      var stop = true;
      for (var currImpact : currImpacts) {
        //TODO MMINT[PL-GSN] Use presence conditions to decide which previous impact should be compared with
        var prevImpact = prevImpacts.get(0).getAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type()).get(0);
        var currentType = currImpact.getAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type()).get(0);
        if (ImpactType.valueOf(currentType).compareTo(ImpactType.valueOf(prevImpact)) < 0) {
          stop = false;
          break;
        }
      }
      if (stop) {
        return;
      }
    }
    if (currImpacts.isEmpty()) {
      var clazz = PLFactory.eINSTANCE.createClass();
      clazz.setType(GSNPackage.eINSTANCE.getImpactAnnotation());
      impacted.addReference(GSNPackage.eINSTANCE.getArgumentElement_Status(), clazz);
      currImpacts = ECollections.asEList(clazz);
    }
    // separate syntactic vs semantic (template) behavior
    for (var currImpact : currImpacts) {
      List<PLGSNImpactStep> nextSteps = null;
//      for (var nextStep : nextSteps) {
//        nextStep.impact(change);
//      }
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLGSNPackage.PLGSN_IMPACT_STEP___IMPACT__OBJECT:
        try {
          impact(arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

} //PLGSNImpactStepImpl
