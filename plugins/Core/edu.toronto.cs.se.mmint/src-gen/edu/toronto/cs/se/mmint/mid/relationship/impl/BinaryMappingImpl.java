/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BinaryMappingImpl extends MappingImpl implements BinaryMapping {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BinaryMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RelationshipPackage.Literals.BINARY_MAPPING;
    }

    /**
     * Creates and adds a reference to this binary mapping type to the Type MID.
     * 
     * @param mappingTypeRef
     *            The reference to the supertype of the mapping type, null if such reference doesn't exist in the model
     *            relationship type container.
     * @param isModifiable
     *            True if the new reference will allow modifications of the referenced mapping type, false otherwise.
     * @param containerModelRelType
     *            The model relationship type that will contain the new reference to the mapping type.
     * @return The created reference to the binary mapping type.
     * @throws MMINTException
     *             If this is a mapping instance.
     * @generated NOT
     */
    @Override
    public MappingReference createTypeReference(MappingReference mappingTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException {

        MMINTException.mustBeType(this);

        BinaryMappingReference newMappingTypeRef = super.createThisReferenceEClass();
        super.addTypeReference(newMappingTypeRef, mappingTypeRef, isModifiable, containerModelRelType);

        return newMappingTypeRef;
    }

    /**
     * Creates and adds a reference to this binary mapping instance to an Instance MID.
     * 
     * @param containerModelRel
     *            The model relationship that will contain the new reference to the mapping.
     * @return The created reference to the binary mapping.
     * @throws MMINTException
     *             If this is a mapping type.
     * @generated NOT
     */
    @Override
    public MappingReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

        MMINTException.mustBeInstance(this);

        BinaryMappingReference newLinkRef = super.createThisReferenceEClass();
        addInstanceReference(newLinkRef, containerModelRel);

        return newLinkRef;
    }

} //BinaryMappingImpl
