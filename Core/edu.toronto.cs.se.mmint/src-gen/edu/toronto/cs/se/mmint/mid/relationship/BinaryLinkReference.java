/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Link Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a binary link.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference#getSourceModelElemRef <em>Source Model Elem Ref</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference#getTargetModelElemRef <em>Target Model Elem Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryLinkReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isBinaryLinkRef binaryLinkType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot isBinaryLinkRef='modelElemEndpointRefs->size() = 2' binaryLinkType='object.oclIsKindOf(BinaryLink)'"
 * @generated
 */
public interface BinaryLinkReference extends LinkReference {
	/**
	 * Returns the value of the '<em><b>Source Model Elem Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source model element reference endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Model Elem Ref</em>' reference.
	 * @see #setSourceModelElemRef(ModelElementReference)
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryLinkReference_SourceModelElemRef()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if modelElemEndpointRefs->size() < 1 then null else modelElemEndpointRefs->at(1).modelElemRef endif'"
	 * @generated
	 */
	ModelElementReference getSourceModelElemRef();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference#getSourceModelElemRef <em>Source Model Elem Ref</em>}' reference.
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
	 * The target model element reference endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Model Elem Ref</em>' reference.
	 * @see #setTargetModelElemRef(ModelElementReference)
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryLinkReference_TargetModelElemRef()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if modelElemEndpointRefs->size() < 2 then null else modelElemEndpointRefs->at(2).modelElemRef endif'"
	 * @generated
	 */
	ModelElementReference getTargetModelElemRef();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference#getTargetModelElemRef <em>Target Model Elem Ref</em>}' reference.
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
	 * Gets the referenced binary link.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement object = super.getObject();\nreturn (object == null) ? null : (BinaryLink) object;'"
	 * @generated
	 */
	BinaryLink getObject();

} // BinaryLinkReference
