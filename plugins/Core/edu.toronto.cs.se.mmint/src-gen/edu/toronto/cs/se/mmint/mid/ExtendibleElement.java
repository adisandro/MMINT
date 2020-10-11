/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid;

import edu.toronto.cs.se.mmint.MMINTException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract basic element. It represents a unique type at the type level able to extend or be extended by other elements, or a typed element at the instance level.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getUri <em>Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getLevel <em>Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMetatypeUri <em>Metatype Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement()
 * @model abstract="true"
 * @generated
 */
public interface ExtendibleElement extends EObject {
    /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The unique uri identifier (types: EMF-like uri; instances: workspace-relative uri).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement_Uri()
   * @model required="true"
   * @generated
   */
    String getUri();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
    void setUri(String value);

    /**
   * Returns the value of the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The supertype (types: can be null; instances: always null).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Supertype</em>' reference.
   * @see #setSupertype(ExtendibleElement)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement_Supertype()
   * @model
   * @generated
   */
    ExtendibleElement getSupertype();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getSupertype <em>Supertype</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supertype</em>' reference.
   * @see #getSupertype()
   * @generated
   */
    void setSupertype(ExtendibleElement value);

    /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The name.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement_Name()
   * @model required="true"
   * @generated
   */
    String getName();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
    void setName(String value);

    /**
   * <!-- begin-user-doc --> Returns the static metatype: always null for types, a type for instances and workflows.
     * 
     * @return The static metatype. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    ExtendibleElement getMetatype();

    /**
   * <!-- begin-user-doc --> Returns the MID container.
     * 
     * @return The MID container, or null if this element is not contained in a MID. <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
    MID getMIDContainer();

    /**
   * <!-- begin-user-doc --> Checks whether this element is at the specified MID level.
     * 
     * @param midLevel
     *            The MID level to check against.
     * @return True if this element is at the specified MID level, false otherwise. <!-- end-user-doc -->
   * @model required="true" midLevelRequired="true"
   * @generated
   */
    boolean isLevel(MIDLevel midLevel);

    /**
   * <!-- begin-user-doc --> Checks whether this is a type.
     * 
     * @return True if this is a type, false otherwise. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    boolean isTypesLevel();

    /**
   * Returns the value of the '<em><b>Level</b></em>' attribute.
   * The literals are from the enumeration {@link edu.toronto.cs.se.mmint.mid.MIDLevel}.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The metalevel (types: TYPES; instances: INSTANCES).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Level</em>' attribute.
   * @see edu.toronto.cs.se.mmint.mid.MIDLevel
   * @see #setLevel(MIDLevel)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement_Level()
   * @model required="true"
   * @generated
   */
    MIDLevel getLevel();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getLevel <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Level</em>' attribute.
   * @see edu.toronto.cs.se.mmint.mid.MIDLevel
   * @see #getLevel()
   * @generated
   */
    void setLevel(MIDLevel value);

    /**
   * Returns the value of the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The static metatype uri (types: always empty).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Metatype Uri</em>' attribute.
   * @see #setMetatypeUri(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement_MetatypeUri()
   * @model
   * @generated
   */
    String getMetatypeUri();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMetatypeUri <em>Metatype Uri</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metatype Uri</em>' attribute.
   * @see #getMetatypeUri()
   * @generated
   */
    void setMetatypeUri(String value);

    /**
   * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * True if this element has been dinamically created at runtime through MMINT (types: true for light types, false for heavy types from extensions; instances: always true).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Dynamic</em>' attribute.
   * @see #setDynamic(boolean)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement_Dynamic()
   * @model required="true"
   * @generated
   */
    boolean isDynamic();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#isDynamic <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dynamic</em>' attribute.
   * @see #isDynamic()
   * @generated
   */
    void setDynamic(boolean value);

    /**
   * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The constraint associated with this element (types: element type; instances: element instance).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Constraint</em>' containment reference.
   * @see #setConstraint(ExtendibleElementConstraint)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElement_Constraint()
   * @model containment="true"
   * @generated
   */
    ExtendibleElementConstraint getConstraint();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getConstraint <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' containment reference.
   * @see #getConstraint()
   * @generated
   */
    void setConstraint(ExtendibleElementConstraint value);

    /**
   * <!-- begin-user-doc --> Creates a uri for a new subtype, using this type
     * as the base (the base uri + the possible uri fragment + the name of the
     * new type).
     * 
     * @param newTypeFragmentUri
     *            The uri fragment to be appended as part of the uri of the new
     *            type, can be null.
     * @param newTypeName
     *            The name of the new type.
     * @return The uri of the new type. <!-- end-user-doc -->
   * @model required="true" newTypeNameRequired="true"
   * @generated
   */
    String createSubtypeUri(String newTypeFragmentUri, String newTypeName);

    /**
   * <!-- begin-user-doc --> Adds a constraint to this type.
     * 
     * @param language
     *            The constraint language, null for an empty constraint.
     * @param implementation
     *            The constraint language, null for an empty constraint. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" languageRequired="true" implementationRequired="true"
   * @generated
   */
    void addTypeConstraint(String language, String implementation) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Checks whether this is an instance.
     * 
     * @return True if this is an instance, false otherwise. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    boolean isInstancesLevel();

    /**
   * <!-- begin-user-doc --> Gets the list of polymorphic runtime types for this instance.
     * 
     * @return The list of runtime types.
     * @throws MMINTException
     *             If this is not an instance. <!-- end-user-doc -->
   * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    <T extends ExtendibleElement> EList<T> getRuntimeTypes() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Gets the closest type constraint, searching from this type included up its supertypes.
     * 
     * @return The closest type constraint in the type inheritance, null if no constraint is found.
     * @throws MMINTException
     *             If this is not a type. <!-- end-user-doc -->
   * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    ExtendibleElementConstraint getClosestTypeConstraint() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Updates the id of this instance in the Workflow MID that contains it.
     * 
     * @param newInstanceId
     *            The new id of this instance.
     * @throws MMINTException
     *             If this is not an instance in a workflow, or if the new id is already registered in the Workflow MID.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newInstanceIdRequired="true"
   * @generated
   */
    void updateWorkflowInstanceId(String newInstanceId) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Validates this instance against a type.
     * 
     * @param type
     *            The type to be validated against.
     * @return True if the validation is successful, false otherwise.
     * @throws MMINTException
     *             If this is not an instance, or if the type to be validated aganst is not a type.<!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" typeRequired="true"
   * @generated
   */
    boolean validateInstanceType(ExtendibleElement type) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Validates this instance against its static type.
     * 
     * @return True if the validation is successful, false otherwise.
     * @throws MMINTException
     *             If this is not an instance.<!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    boolean validateInstance() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Validates this instance against its static type within an editor that suports EMF
     * validation.
     * 
     * @param context
     *            The editor context of the validation.
     * @return A status representing the validation result.
     * @throws MMINTException
     *             If this is not an instance.<!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.mmint.mid.IStatus" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" contextDataType="edu.toronto.cs.se.mmint.mid.IValidationContext" contextRequired="true"
   * @generated
   */
    IStatus validateInstanceInEditor(IValidationContext context) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Checks whether this is a workflow element.
     * 
     * @return True if this is a workflow element, false otherwise. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    boolean isWorkflowsLevel();

    /**
   * <!-- begin-user-doc --> Returns a string representation of this element for its MID custom label. It returns an
     * empty string by default and can be overridden.
     * 
     * @return The string representation. <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
    String toMIDCustomPrintLabel();

    /**
   * <!-- begin-user-doc --> Returns a string representation of this element for its MID custom label being edited. It
     * returns an empty string by default and can be overridden.
     * 
     * @return The string representation. <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
    String toMIDCustomEditLabel();

    /**
   * <!-- begin-user-doc --> Updates this element with the string inserted in its MID custom label. It does nothing by
     * default and can be overridden.
     * 
     * @param newLabel
     *            The string inserted in the MID custom label. <!-- end-user-doc -->
   * @model newLabelRequired="true"
   * @generated
   */
    void updateMIDCustomLabel(String newLabel);

} // ExtendibleElement
