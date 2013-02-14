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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getBody <em>Body</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getEngine <em>Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelConstraint()
 * @model
 * @generated
 */
public interface ModelConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The constraint definition, using the engine language.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelConstraint_Body()
	 * @model required="true"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Engine</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The engine used to evaluate the constraint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Engine</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine
	 * @see #setEngine(ModelConstraintEngine)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelConstraint_Engine()
	 * @model required="true"
	 * @generated
	 */
	ModelConstraintEngine getEngine();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getEngine <em>Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(ModelConstraintEngine value);

} // ModelConstraint
