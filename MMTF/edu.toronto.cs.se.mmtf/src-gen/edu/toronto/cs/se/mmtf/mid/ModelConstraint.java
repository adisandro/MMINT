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
package edu.toronto.cs.se.mmtf.mid;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A constraint for a model type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelConstraint()
 * @model
 * @generated
 */
public interface ModelConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The constraint implementation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelConstraint_Implementation()
	 * @model required="true"
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.ModelConstraintLanguage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The language used to evaluate the constraint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraintLanguage
	 * @see #setLanguage(ModelConstraintLanguage)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelConstraint_Language()
	 * @model required="true"
	 * @generated
	 */
	ModelConstraintLanguage getLanguage();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraintLanguage
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(ModelConstraintLanguage value);

} // ModelConstraint
