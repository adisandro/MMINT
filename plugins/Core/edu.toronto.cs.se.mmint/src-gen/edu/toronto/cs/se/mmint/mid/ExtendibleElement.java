/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


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
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='typeLevel'"
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The static metatype (types: always null; instances: an extendible element from the types).
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return MultiModelTypeRegistry.getType(getMetatypeUri());'"
	 * @generated
	 */
	ExtendibleElement getMetatype();

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
	 * <!-- begin-user-doc --> Gets the list of polymorphic runtime types for this instance.
	 * 
	 * @return The list of runtime types.
	 * @throws MMINTException
	 *             If this is a type. <!-- end-user-doc -->
	 * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	<T extends ExtendibleElement> EList<T> getRuntimeTypes() throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" typeRequired="true"
	 * @generated
	 */
	boolean validateInstanceType(ExtendibleElement type) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	boolean validateInstance() throws MMINTException;

} // ExtendibleElement
