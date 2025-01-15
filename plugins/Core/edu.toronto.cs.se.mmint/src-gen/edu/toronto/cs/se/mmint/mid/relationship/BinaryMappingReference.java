/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a binary mapping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getSourceModelElemRef <em>Source Model Elem Ref</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getTargetModelElemRef <em>Target Model Elem Ref</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryMappingReference()
 * @model
 * @generated
 */
public interface BinaryMappingReference extends MappingReference {
    /**
   * Returns the value of the '<em><b>Source Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The source model element reference.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Source Model Elem Ref</em>' reference.
   * @see #setSourceModelElemRef(ModelElementReference)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryMappingReference_SourceModelElemRef()
   * @model required="true"
   * @generated
   */
    ModelElementReference getSourceModelElemRef();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getSourceModelElemRef <em>Source Model Elem Ref</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Model Elem Ref</em>' reference.
   * @see #getSourceModelElemRef()
   * @generated
   */
    void setSourceModelElemRef(ModelElementReference value);

    /**
   * Returns the value of the '<em><b>Target Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The target model element reference.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Target Model Elem Ref</em>' reference.
   * @see #setTargetModelElemRef(ModelElementReference)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryMappingReference_TargetModelElemRef()
   * @model required="true"
   * @generated
   */
    ModelElementReference getTargetModelElemRef();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getTargetModelElemRef <em>Target Model Elem Ref</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Model Elem Ref</em>' reference.
   * @see #getTargetModelElemRef()
   * @generated
   */
    void setTargetModelElemRef(ModelElementReference value);

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * {@inheritDoc}<br />
   * Gets the referenced binary mapping.
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    BinaryMapping getObject();

    /**
   * <!-- begin-user-doc --> Adds the source or target reference to model
     * element type to this reference to binary mapping type.
     * 
     * @param modelElemTypeRef
     *            The reference to model element type that is the source or
     *            target of this reference to binary mapping type.
     * @param isBinarySrc
     *            True if the model element type is the source in the binary
     *            mapping type container, false otherwise.
     * @throws MMINTException
     *             If this is a reference to mapping instance.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelElemTypeRefRequired="true" isBinarySrcRequired="true"
   * @generated
   */
    void addModelElementTypeReference(ModelElementReference modelElemTypeRef, boolean isBinarySrc) throws MMINTException;

} // BinaryMappingReference
