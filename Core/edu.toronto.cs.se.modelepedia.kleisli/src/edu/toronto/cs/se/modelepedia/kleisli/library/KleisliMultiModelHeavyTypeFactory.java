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
package edu.toronto.cs.se.modelepedia.kleisli.library;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelHeavyTypeFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;

/**
 * The factory to create/modify/remove Kleisli "heavy" types, i.e. Kleisli types
 * from extensions.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class KleisliMultiModelHeavyTypeFactory extends MultiModelHeavyTypeFactory {

	/**
	 * Creates and adds a Kleisli "heavy" model relationship type to the
	 * repository.
	 * 
	 * @param newModelRelTypeUri
	 *            The uri of the new model relationship type.
	 * @param modelRelTypeUri
	 *            The uri of the supertype of the new model relationship type,
	 *            null if the root model relationship type should be used as
	 *            supertype.
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param isAbstract
	 *            True if the new model relationship type is abstract, false
	 *            otherwise.
	 * @param isBinary
	 *            True if the new model relationship type is binary, false
	 *            otherwise.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model relationship type, null if no constraint is
	 *            associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model relationship type, null if no constraint is
	 *            associated.
	 * @return The created model relationship type.
	 * @throws MMTFException
	 *             If the package of the new model relationship type is not
	 *             registered through a org.eclipse.emf.ecore.generated_package
	 *             extension, or if the uri of the new model relationship type
	 *             is already registered in the repository.
	 */
	public ModelRel createHeavyModelRelType(String newModelRelTypeUri, String modelRelTypeUri, String newModelRelTypeName, boolean isAbstract, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException {

		ModelRel newModelRelType = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		addHeavyModelRelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, isAbstract, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * Creates and adds a Kleisli "heavy" model type endpoint and a reference to
	 * it to the repository.
	 * 
	 * @param newModelTypeEndpointUri
	 *            The uri of the new model type endpoint.
	 * @param modelTypeEndpointUri
	 *            The uri of the supertype of the new model type endpoint, null
	 *            if the root model type endpoint should be used as supertype.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the repository.
	 */
	public ModelEndpointReference createHeavyModelTypeEndpointAndModelTypeEndpointReference(String newModelTypeEndpointUri, String modelTypeEndpointUri, String newModelTypeEndpointName, Model newModelType, ModelRel modelRelType) throws MMTFException {

		ModelEndpoint newModelTypeEndpoint = KleisliFactory.eINSTANCE.createKleisliModelEndpoint();
		ModelEndpointReference newModelTypeEndpointRef = addHeavyModelTypeEndpointAndModelTypeEndpointReference(newModelTypeEndpoint, newModelTypeEndpointUri, modelTypeEndpointUri, newModelTypeEndpointName, newModelType, modelRelType);

		return newModelTypeEndpointRef;
	}

}
