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
package edu.toronto.cs.se.modelepedia.kleisli;

import org.eclipse.emf.ecore.resource.ResourceSet;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Kleisli version, represents a model relationship where some of the models are extended. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getExtendedUri <em>Extended Uri</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelRel()
 * @model
 * @generated
 */
public interface KleisliModelRel extends ModelRel {
	/**
	 * Returns the value of the '<em><b>Extended Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of the directory that contains Kleisli extensions (types: state-relative; instances: workspace-relative).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Uri</em>' attribute.
	 * @see #setExtendedUri(String)
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelRel_ExtendedUri()
	 * @model required="true"
	 * @generated
	 */
	String getExtendedUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getExtendedUri <em>Extended Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Uri</em>' attribute.
	 * @see #getExtendedUri()
	 * @generated
	 */
	void setExtendedUri(String value);

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelTypeNameRequired="true" isBinaryRequired="true"
	 * @generated
	 */
	ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" origModelRelTypeRequired="true"
	 * @generated
	 */
	ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteType() throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	ResourceSet getOutlineResourceTypes() throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isBinaryRequired="true" originRequired="true"
	 * @generated
	 */
	ModelRel createInstance(String newModelRelUri, boolean isBinary, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteInstance() throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	ResourceSet getOutlineResourceInstances() throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void openType() throws Exception;

	/**
	 * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void openInstance() throws Exception;

} // KleisliModelRel
