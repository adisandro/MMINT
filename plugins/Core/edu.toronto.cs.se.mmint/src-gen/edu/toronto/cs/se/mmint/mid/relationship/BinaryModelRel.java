/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;


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
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getSourceModel <em>Source Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getTargetModel <em>Target Model</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryModelRel()
 * @model
 * @generated
 */
public interface BinaryModelRel extends ModelRel {

    /**
   * Returns the value of the '<em><b>Source Model</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The source model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Source Model</em>' reference.
   * @see #setSourceModel(Model)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryModelRel_SourceModel()
   * @model required="true"
   * @generated
   */
    Model getSourceModel();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getSourceModel <em>Source Model</em>}' reference.
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
   * The target model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Target Model</em>' reference.
   * @see #setTargetModel(Model)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryModelRel_TargetModel()
   * @model required="true"
   * @generated
   */
    Model getTargetModel();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getTargetModel <em>Target Model</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Model</em>' reference.
   * @see #getTargetModel()
   * @generated
   */
    void setTargetModel(Model value);

    /**
   * <!-- begin-user-doc --> Adds the source or target model type to this
     * binary model relationship type.
     * 
     * @param modelType
     *            The model type that is the source or target of this binary
     *            model relationship type.
     * @param isBinarySrc
     *            True if the model type is the source in the binary model
     *            relationship type container, false otherwise.
     * @throws MMINTException
     *             If this is a model relationship instance.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelTypeRequired="true" isBinarySrcRequired="true"
   * @generated
   */
    void addModelType(Model modelType, boolean isBinarySrc) throws MMINTException;

} // BinaryModelRel
