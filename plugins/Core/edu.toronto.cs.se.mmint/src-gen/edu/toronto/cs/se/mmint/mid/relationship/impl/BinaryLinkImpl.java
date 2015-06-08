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

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BinaryLinkImpl extends LinkImpl implements BinaryLink {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.BINARY_LINK;
	}

	/**
	 * @generated NOT
	 */
	public LinkReference createTypeReference(LinkReference linkTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		BinaryLinkReference newLinkTypeRef = RelationshipFactory.eINSTANCE.createBinaryLinkReference();
		super.addTypeReference(newLinkTypeRef, linkTypeRef, isModifiable, containerModelRelType);

		return newLinkTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public LinkReference createInstanceReference(ModelRel containerModelRel) throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		BinaryLinkReference newLinkRef = RelationshipFactory.eINSTANCE.createBinaryLinkReference();
		addInstanceReference(newLinkRef, containerModelRel);

		return newLinkRef;
	}

} //BinaryLinkImpl
