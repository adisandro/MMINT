/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to an extendible element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getContainedObject <em>Contained Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getSupertypeRef <em>Supertype Ref</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isModifiable <em>Modifiable</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getExtendibleElementReference()
 * @model abstract="true"
 * @generated
 */
public interface ExtendibleElementReference extends EObject {
    /**
   * Returns the value of the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The referenced element, when owned by some other entity.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Referenced Object</em>' reference.
   * @see #setReferencedObject(ExtendibleElement)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getExtendibleElementReference_ReferencedObject()
   * @model
   * @generated
   */
    ExtendibleElement getReferencedObject();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getReferencedObject <em>Referenced Object</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Object</em>' reference.
   * @see #getReferencedObject()
   * @generated
   */
    void setReferencedObject(ExtendibleElement value);

    /**
   * Returns the value of the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The referenced element, when owned by this reference itself.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Contained Object</em>' containment reference.
   * @see #setContainedObject(ExtendibleElement)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getExtendibleElementReference_ContainedObject()
   * @model containment="true"
   * @generated
   */
    ExtendibleElement getContainedObject();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getContainedObject <em>Contained Object</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contained Object</em>' containment reference.
   * @see #getContainedObject()
   * @generated
   */
    void setContainedObject(ExtendibleElement value);

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The referenced element. It can be owned by some other entity or by this reference itself, but not both.
   * <!-- end-model-doc -->
   * @model kind="operation"
   * @generated
   */
    ExtendibleElement getObject();

    /**
   * Returns the value of the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The reference to the supertype of the referenced element.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Supertype Ref</em>' reference.
   * @see #setSupertypeRef(ExtendibleElementReference)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getExtendibleElementReference_SupertypeRef()
   * @model
   * @generated
   */
    ExtendibleElementReference getSupertypeRef();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getSupertypeRef <em>Supertype Ref</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supertype Ref</em>' reference.
   * @see #getSupertypeRef()
   * @generated
   */
    void setSupertypeRef(ExtendibleElementReference value);

    /**
   * Returns the value of the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * True if the referenced element can be modified through this reference.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Modifiable</em>' attribute.
   * @see #setModifiable(boolean)
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getExtendibleElementReference_Modifiable()
   * @model required="true"
   * @generated
   */
    boolean isModifiable();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isModifiable <em>Modifiable</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifiable</em>' attribute.
   * @see #isModifiable()
   * @generated
   */
    void setModifiable(boolean value);

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The uri of the referenced element.
   * <!-- end-model-doc -->
   * @model kind="operation"
   * @generated
   */
    String getUri();

    /**
   * <!-- begin-user-doc --> Returns the MID container.
     * 
     * @return The MID container, or null if this references an element that is not contained in a MID.
     * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
    MID getMIDContainer();

    /**
   * <!-- begin-user-doc --> Checks whether this is a reference to a type.
     * 
     * @return True if this is a reference to a type, false otherwise. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    boolean isTypesLevel();

    /**
   * <!-- begin-user-doc --> Checks whether this is a reference to an instance.
     * 
     * @return True if this is a reference to an instance, false otherwise. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    boolean isInstancesLevel();

    /**
   * <!-- begin-user-doc --> Checks whether this is a reference to a workflow element.
     * 
     * @return True if this is a reference to a workflow element, false otherwise. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    boolean isWorkflowsLevel();

} // ExtendibleElementReference
