/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conversion Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ConversionOperatorImpl extends OperatorImpl implements ConversionOperator {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ConversionOperatorImpl() {
        super();
    }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return OperatorPackage.Literals.CONVERSION_OPERATOR;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case OperatorPackage.CONVERSION_OPERATOR___CLEANUP:
        try {
          cleanup();
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
    public String toString() {

        return "[conv] " + super.toString();
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteType() throws MMINTException {

        super.deleteType();
        getInputs().get(0).getTarget().getConversionOperators().remove(this);
    }

    /**
     * @generated NOT
     */
    public void cleanup() throws Exception {

        //TODO MMINT[OPERATOR] Integrate better with new apis, e.g. a transformation output now can be a model rel and it implies the converted model
        // do nothing
    }

} //ConversionOperatorImpl
