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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
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
	 * @generated NOT
	 */
	public MappingReference createTypeReference(MappingReference mappingTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException {

		MMINTException.mustBeType(this);

		BinaryMappingReference newLinkTypeRef = RelationshipFactory.eINSTANCE.createBinaryMappingReference();
		super.addTypeReference(newLinkTypeRef, mappingTypeRef, isModifiable, containerModelRelType);

		return newLinkTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public MappingReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

		MMINTException.mustBeInstance(this);

		BinaryMappingReference newLinkRef = RelationshipFactory.eINSTANCE.createBinaryMappingReference();
		addInstanceReference(newLinkRef, containerModelRel);

		return newLinkRef;
	}

} //BinaryMappingImpl
