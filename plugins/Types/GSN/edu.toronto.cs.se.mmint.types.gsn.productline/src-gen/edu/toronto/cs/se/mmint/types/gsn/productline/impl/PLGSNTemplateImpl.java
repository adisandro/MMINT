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
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.impl.ClassImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PLGSNTemplateImpl extends ClassImpl implements PLGSNTemplate {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLGSNTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLGSNPackage.Literals.PLGSN_TEMPLATE;
  }

  /**
   * @generated NOT
   */
  @Override
  public Map<String, PLGSNArgumentElement> getElementsById() {
    return getStreamOfReference(GSNPackage.eINSTANCE.getTemplate_Elements())
             .filter(e -> e instanceof PLGSNArgumentElement &&
                          !e.getAttribute(GSNPackage.eINSTANCE.getArgumentElement_TemplateId()).isEmpty())
             .collect(Collectors.toMap(e -> e.getAttribute(GSNPackage.eINSTANCE.getArgumentElement_TemplateId()).get(0),
                                       e -> (PLGSNArgumentElement) e));
  }

  /**
   * @generated NOT
   */
  @Override
  public void import_(ProductLine productLine) throws Exception {
    var templatePL = this.getProductLine();
    var rootType = GSNPackage.eINSTANCE.getSafetyCase();
    var plSC = productLine.getRoot(rootType);
    var templatePLSC = templatePL.getRoot(rootType);
    plSC.getReferences().addAll(templatePLSC.getReferences());
    templatePL.getClasses().remove(templatePLSC);
    productLine.getClasses().addAll(templatePL.getClasses());
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var plElements = getStreamOfReference(GSNPackage.eINSTANCE.getTemplate_Elements())
      .filter(e -> e instanceof PLGSNArgumentElement)
      .map(e -> (PLGSNArgumentElement) e)
      .collect(Collectors.toList());
    for (var plElement : plElements) {
      if (plElement.getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Valid()).stream()
            .allMatch(v -> Boolean.valueOf(v)) ||
          plElement.instanceOf(GSNPackage.eINSTANCE.getRelationshipDecorator()) ||
          plElement.eContainer() == null) {
        continue;
      }
      plElement.instantiate();
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    var plElements = getStreamOfReference(GSNPackage.eINSTANCE.getTemplate_Elements())
      .filter(e -> e instanceof PLGSNArgumentElement)
      .map(e -> (PLGSNArgumentElement) e)
      .collect(Collectors.toList());
    for (var plElement : plElements) {
      if (plElement.eContainer() == null) { // == deleted
        continue;
      }
      plElement.validate();
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<PLGSNChangeStep> nextImpactSteps(PLGSNChangeStep step) throws Exception {
    return ECollections.asEList(step.nextSteps());
  }

  /**
   * @generated NOT
   */
  @Override
  public void impact(PLGSNChangeStep step) throws Exception {
    step.baselineImpact();
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<PLGSNChangeStep> nextRepairSteps(PLGSNChangeStep step) throws Exception {
    return ECollections.asEList(step.nextSteps());
  }

  /**
   * @generated NOT
   */
  @Override
  public void repair(PLGSNChangeStep step) throws Exception {
    step.baselineRepair();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLGSNPackage.PLGSN_TEMPLATE___GET_ELEMENTS_BY_ID:
        return getElementsById();
      case PLGSNPackage.PLGSN_TEMPLATE___IMPORT____PRODUCTLINE:
        try {
          import_((ProductLine)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_TEMPLATE___INSTANTIATE:
        try {
          instantiate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_TEMPLATE___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_TEMPLATE___NEXT_IMPACT_STEPS__PLGSNCHANGESTEP:
        try {
          return nextImpactSteps((PLGSNChangeStep)arguments.get(0));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_TEMPLATE___IMPACT__PLGSNCHANGESTEP:
        try {
          impact((PLGSNChangeStep)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_TEMPLATE___NEXT_REPAIR_STEPS__PLGSNCHANGESTEP:
        try {
          return nextRepairSteps((PLGSNChangeStep)arguments.get(0));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_TEMPLATE___REPAIR__PLGSNCHANGESTEP:
        try {
          repair((PLGSNChangeStep)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

} //GSNPLTemplateImpl
