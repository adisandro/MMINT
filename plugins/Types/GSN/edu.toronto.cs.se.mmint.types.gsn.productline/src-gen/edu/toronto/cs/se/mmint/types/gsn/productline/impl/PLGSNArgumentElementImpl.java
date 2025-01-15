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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.productline.impl.ClassImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Argument Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PLGSNArgumentElementImpl extends ClassImpl implements PLGSNArgumentElement {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLGSNArgumentElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLGSNPackage.Literals.PLGSN_ARGUMENT_ELEMENT;
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate(PLGSNTemplate template) throws Exception {
    var title = "Instantiate placeholder text";
    //TODO abstract into function
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
   * @generated NOT
   */
  @Override
  public void validate(PLGSNTemplate template) throws Exception {
    var validAttrs = getAttributes().stream()
      .filter(a -> a.getType() == GSNPackage.eINSTANCE.getArgumentElement_Valid());
    if (getAttributes().stream()
          .filter(a -> a.getType() == GSNPackage.eINSTANCE.getArgumentElement_Description())
          .anyMatch(a -> GSNBuilder.findPattern(a.getValue()).isPresent())) {
      //TODO abstract into function
      var node = getType().getName() + " " +
                 String.join(",", getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id()));
      validAttrs.forEach(a -> a.setValue(Boolean.FALSE.toString()));
      throw new MMINTException(node + " description contains placeholder text to be instantiated");
    }
    validAttrs.forEach(a -> a.setValue(Boolean.TRUE.toString()));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___VALIDATE__PLGSNTEMPLATE:
        try {
          validate((PLGSNTemplate)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___INSTANTIATE__PLGSNTEMPLATE:
        try {
          instantiate((PLGSNTemplate)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

} //GSNPLArgumentElementImpl
