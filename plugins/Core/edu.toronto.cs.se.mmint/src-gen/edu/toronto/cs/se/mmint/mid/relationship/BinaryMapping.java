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
package edu.toronto.cs.se.mmint.mid.relationship;

import edu.toronto.cs.se.mmint.MMINTException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A binary mapping type or a binary mapping instance.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getBinaryMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isBinaryMapping'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot isBinaryMapping='modelElemEndpoints->size() = 2'"
 * @generated
 */
public interface BinaryMapping extends Mapping {

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this binary mapping
	 * type to the Type MID.
	 * 
	 * @param mappingTypeRef
	 *            The reference to the supertype of the mapping type, null if such
	 *            reference doesn't exist in the model relationship type
	 *            container.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced mapping type, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the mapping type.
	 * @return The created reference to the binary mapping type.
	 * @throws MMINTException
	 *             If this is a mapping instance. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isModifiableRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	MappingReference createTypeReference(MappingReference mappingTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this binary mapping
	 * instance to an Instance MID.
	 * 
	 * @param containerModelRel
	 *            The model relationship that will contain the new reference to
	 *            the mapping.
	 * @return The created reference to the binary mapping.
	 * @throws MMINTException
	 *             If this is a mapping type. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" containerModelRelRequired="true"
	 * @generated
	 */
	MappingReference createInstanceReference(ModelRel containerModelRel) throws MMINTException;

} // BinaryMapping
