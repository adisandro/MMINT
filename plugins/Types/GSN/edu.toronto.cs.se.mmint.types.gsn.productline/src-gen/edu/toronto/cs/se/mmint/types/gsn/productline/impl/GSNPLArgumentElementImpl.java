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

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.productline.impl.ClassImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Argument Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GSNPLArgumentElementImpl extends ClassImpl implements GSNPLArgumentElement {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GSNPLArgumentElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPLPackage.Literals.GSNPL_ARGUMENT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void validate(GSNPLTemplate template) throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate(GSNPLTemplate template) throws Exception {
    var title = "Instantiate placeholder text";
    var node = getType().getName() + " " + String.join(",", getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id()));
    for (var attr : getAttributes()) {
      if (attr.getType() != GSNPackage.eINSTANCE.getArgumentElement_Description()) {
        continue;
      }
      while (true) {
        var desc = attr.getValue();
        var pattern = GSNBuilder.findPattern(desc);
        if (pattern.isEmpty()) {
          break;
        }
        var toReplace = pattern.get();
        var msg = "Replace '" + toReplace + "' in " + node + " with:";
        var replacement = MIDDialogs.getStringInput(title, msg, null);
        attr.setValue(desc.replace(GSNBuilder.PATTERN1 + toReplace + GSNBuilder.PATTERN2, replacement));
      }
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
      case GSNPLPackage.GSNPL_ARGUMENT_ELEMENT___VALIDATE__GSNPLTEMPLATE:
        try {
          validate((GSNPLTemplate)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNPLPackage.GSNPL_ARGUMENT_ELEMENT___INSTANTIATE__GSNPLTEMPLATE:
        try {
          instantiate((GSNPLTemplate)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

} //GSNPLArgumentElementImpl
