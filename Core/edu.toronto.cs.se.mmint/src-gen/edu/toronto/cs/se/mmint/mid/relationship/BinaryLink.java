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

import edu.toronto.cs.se.mmint.MMINTException;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A binary link type or a binary link instance.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryLink()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isBinaryLink'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot isBinaryLink='modelElemEndpoints->size() = 2'"
 * @generated
 */
public interface BinaryLink extends Link {

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this binary link
	 * type to the Type MID.
	 * 
	 * @param linkTypeRef
	 *            The reference to the supertype of the link type, null if such
	 *            reference doesn't exist in the model relationship type
	 *            container.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced link type, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the link type.
	 * @return The created reference to the binary link type.
	 * @throws MMINTException
	 *             If this is a link instance. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isModifiableRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	LinkReference createTypeReference(LinkReference linkTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this binary link
	 * instance to an Instance MID.
	 * 
	 * @param containerModelRel
	 *            The model relationship that will contain the new reference to
	 *            the link.
	 * @return The created reference to the binary link.
	 * @throws MMINTException
	 *             If this is a link type. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" containerModelRelRequired="true"
	 * @generated
	 */
	LinkReference createInstanceReference(ModelRel containerModelRel) throws MMINTException;
} // BinaryLink
