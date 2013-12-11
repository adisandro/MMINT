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
package edu.toronto.cs.se.modelepedia.kleisli;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Kleisli version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelRel()
 * @model
 * @generated
 */
public interface KleisliModelRel extends ModelRel, KleisliExtendibleElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelRelTypeNameRequired="true" isBinaryRequired="true"
	 * @generated
	 */
	ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteType() throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isBinaryRequired="true" originRequired="true"
	 * @generated
	 */
	ModelRel createInstance(String newModelRelUri, boolean isBinary, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteInstance() throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void openType() throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void openInstance() throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	ResourceSet getOutlineResourceTypes() throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	ResourceSet getOutlineResourceInstances() throws MMTFException;

} // KleisliModelRel
