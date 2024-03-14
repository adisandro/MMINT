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
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.impl.ClassImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GSNPLTemplateImpl extends ClassImpl implements GSNPLTemplate {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GSNPLTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPLPackage.Literals.GSNPL_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void validate() throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * @generated NOT
   */
  @Override
  public void import_(ProductLine productLine) throws Exception {
    var templatePL = this.getProductLine();
    var plSC = productLine.getClasses().stream()
      .filter(c -> c.getType() == GSNPackage.eINSTANCE.getSafetyCase())
      .findFirst().get();
    var templatePLSC = templatePL.getClasses().stream()
      .filter(c -> c.getType() == GSNPackage.eINSTANCE.getSafetyCase())
      .findFirst().get();
    plSC.getReferences().addAll(templatePLSC.getReferences());
    templatePL.getClasses().remove(templatePLSC);
    productLine.getClasses().addAll(templatePL.getClasses());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void instantiate() throws Exception {
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
      case GSNPLPackage.GSNPL_TEMPLATE___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNPLPackage.GSNPL_TEMPLATE___IMPORT____PRODUCTLINE:
        try {
          import_((ProductLine)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNPLPackage.GSNPL_TEMPLATE___INSTANTIATE:
        try {
          instantiate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

} //GSNPLTemplateImpl
