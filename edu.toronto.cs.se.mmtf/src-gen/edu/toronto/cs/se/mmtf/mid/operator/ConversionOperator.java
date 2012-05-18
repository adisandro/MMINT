/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.operator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conversion Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getConversionOperator()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='coercion'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot coercion='inputs->size() = 1 and outputs->size() = 2 and inputs->forAll(oclIsKindOf(ModelParameter)) and outputs->forAll(oclIsKindOf(ModelParameter)) and inputs->at(1).oclAsType(ModelParameter).model.supertype = outputs->at(1).oclAsType(ModelParameter).model'"
 * @generated
 */
public interface ConversionOperator extends Operator {
} // ConversionOperator
