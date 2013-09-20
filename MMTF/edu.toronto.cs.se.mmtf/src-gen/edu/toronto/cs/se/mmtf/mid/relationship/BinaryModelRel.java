/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship;

import edu.toronto.cs.se.mmtf.mid.Model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A binary model relationship type or a binary model relationship instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getSourceModel <em>Source Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getTargetModel <em>Target Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getBinaryModelRel()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isBinaryModelRel'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot isBinaryModelRel='modelEndpoints->size() = 2'"
 * @generated
 */
public interface BinaryModelRel extends ModelRel {

	/**
	 * Returns the value of the '<em><b>Source Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source model endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Model</em>' reference.
	 * @see #setSourceModel(Model)
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getBinaryModelRel_SourceModel()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if modelEndpoints->size() < 1 then null else modelEndpoints->at(1).target.oclAsType(mid::Model) endif'"
	 * @generated
	 */
	Model getSourceModel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getSourceModel <em>Source Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Model</em>' reference.
	 * @see #getSourceModel()
	 * @generated
	 */
	void setSourceModel(Model value);

	/**
	 * Returns the value of the '<em><b>Target Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target model endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Model</em>' reference.
	 * @see #setTargetModel(Model)
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getBinaryModelRel_TargetModel()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if modelEndpoints->size() < 2 then null else modelEndpoints->at(2).target.oclAsType(mid::Model) endif'"
	 * @generated
	 */
	Model getTargetModel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getTargetModel <em>Target Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Model</em>' reference.
	 * @see #getTargetModel()
	 * @generated
	 */
	void setTargetModel(Model value);
} // BinaryModelRel
