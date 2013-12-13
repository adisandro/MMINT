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
package edu.toronto.cs.se.mmtf.mid;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element type of a model type or an element instance of a model instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getClassLiteral <em>Class Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Class Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class literal (types: the literal of the class or structural feature in the metamodel package; instances: currently unused TODO).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Literal</em>' attribute.
	 * @see #setClassLiteral(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElement_ClassLiteral()
	 * @model required="true"
	 * @generated
	 */
	String getClassLiteral();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getClassLiteral <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Literal</em>' attribute.
	 * @see #getClassLiteral()
	 * @generated
	 */
	void setClassLiteral(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model element type of this model element instance.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (ModelElement) metatype;'"
	 * @generated
	 */
	ModelElement getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model element supertype of this model element type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (ModelElement) supertype;'"
	 * @generated
	 */
	ModelElement getSupertype();

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model element
	 * type and a reference to it to the Type MID.
	 * 
	 * @param modelElemTypeRef
	 *            The reference to the supertype of the new model element type,
	 *            null if such reference doesn't exist in the model type
	 *            endpoint reference container.
	 * @param newModelElemTypeName
	 *            The name of the new model element type.
	 * @param classLiteral
	 *            The class name of the new model element type.
	 * @param modelTypeEndpointRef
	 *            The reference to the model type endpoint that will contain the
	 *            new reference to the new model element type.
	 * @return The created reference to the new model element type.
	 * @throws MMTFException
	 *             If this is a model element instance, or if the uri of the new
	 *             model element type is already registered in the Type MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelElemTypeNameRequired="true" classLiteralRequired="true" containerModelTypeEndpointRefRequired="true"
	 * @generated
	 */
	ModelElementReference createSubtypeAndReference(ModelElementReference modelElemTypeRef, String newModelElemTypeName, String classLiteral, ModelEndpointReference containerModelTypeEndpointRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model element instance of this
	 * model element type and a reference to it to an Instance MID.
	 * 
	 * @param newModelElemUri
	 *            The uri of the new model element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param classLiteral
	 *            The class literal of the new model element.
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the new model element.
	 * @return The created reference to the new model element.
	 * @throws MMTFException
	 *             If this is a model element instance, or if the uri of the new
	 *             model element is already registered in the Instance MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelElemUriRequired="true" newModelElemNameRequired="true" classLiteralRequired="true" containerModelEndpointRefRequired="true"
	 * @generated
	 */
	ModelElementReference createInstanceAndReference(String newModelElemUri, String newModelElemName, String classLiteral, ModelEndpointReference containerModelEndpointRef) throws MMTFException;

} // ModelElement
