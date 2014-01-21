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
	 * Kleisli version. {@inheritDoc}
	 */
	@Override
	public ModelRel createHeavyModelRelType(String newModelRelTypeUri, String modelRelTypeUri, String newModelRelTypeName, boolean isAbstract, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException {

		ModelRel newModelRelType = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		addHeavyModelRelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, isAbstract, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 */
	@Override
	public ModelEndpointReference createHeavyModelTypeEndpointAndModelTypeEndpointReference(String newModelTypeEndpointUri, String modelTypeEndpointUri, String newModelTypeEndpointName, Model newModelType, ModelRel modelRelType) throws MMTFException {

		ModelEndpoint newModelTypeEndpoint = KleisliFactory.eINSTANCE.createKleisliModelEndpoint();
		ModelEndpointReference newModelTypeEndpointRef = addHeavyModelTypeEndpointAndModelTypeEndpointReference(newModelTypeEndpoint, newModelTypeEndpointUri, modelTypeEndpointUri, newModelTypeEndpointName, newModelType, modelRelType);

		return newModelTypeEndpointRef;
	}

}
