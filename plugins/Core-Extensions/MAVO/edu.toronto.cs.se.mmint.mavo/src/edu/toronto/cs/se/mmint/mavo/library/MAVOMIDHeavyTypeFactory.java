/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.library;

import org.eclipse.jdt.annotation.NonNull;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.extensions.ExtensionPointType;
import edu.toronto.cs.se.mmint.MIDHeavyTypeFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class MAVOMIDHeavyTypeFactory extends MIDHeavyTypeFactory {

	/**
	 * MAVO version. {@inheritDoc}
	 */
	@Override
	public Model createHeavyModelType(ExtensionPointType extensionType) throws MMINTException {

		MAVOModel newMAVOModelType = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addHeavyModelType(newMAVOModelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), extensionType.isAbstract());

		return newMAVOModelType;
	}

	/**
	 * MAVO version. {@inheritDoc}
	 */
	@Override
	public ModelElement createHeavyModelElementType(ExtensionPointType extensionType, EMFInfo eInfo, Model modelType) throws MMINTException {

		MAVOModelElement newMAVOModelElemType = MAVOMIDFactory.eINSTANCE.createMAVOModelElement();
		ModelElement modelElemType = super.getSupertype(newMAVOModelElemType, extensionType.getUri(), extensionType.getSupertypeUri());
		super.addHeavyType(newMAVOModelElemType, modelElemType, extensionType.getUri(), extensionType.getName());
		super.addModelElementType(newMAVOModelElemType, eInfo, modelType);

		return newMAVOModelElemType;
	}

	/**
	 * MAVO version. {@inheritDoc}
	 */
	@Override
	public @NonNull ModelRel createHeavyModelRelType(@NonNull ExtensionPointType extensionType, boolean isBinary) throws MMINTException {

		MAVOModelRel newMAVOModelRelType = (isBinary) ?
			MAVOMIDFactory.eINSTANCE.createBinaryMAVOModelRel() :
			MAVOMIDFactory.eINSTANCE.createMAVOModelRel();
		super.addHeavyModelRelType(newMAVOModelRelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), extensionType.isAbstract());

		return newMAVOModelRelType;
	}

	/**
	 * MAVO version. {@inheritDoc}
	 */
	@Override
	public @NonNull ModelEndpointReference createHeavyModelTypeEndpointAndModelTypeEndpointReference(@NonNull ExtensionPointType extensionType, @NonNull Model targetModelType, boolean isBinarySrc, @NonNull ModelRel containerModelRelType) throws MMINTException {

		MAVOModelEndpoint newMAVOModelTypeEndpoint = MAVOMIDFactory.eINSTANCE.createMAVOModelEndpoint();
		MAVOModelEndpointReference newMAVOModelTypeEndpointRef = (MAVOModelEndpointReference) super.addHeavyModelTypeEndpointAndModelTypeEndpointReference(newMAVOModelTypeEndpoint, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), targetModelType, isBinarySrc, containerModelRelType);

		return newMAVOModelTypeEndpointRef;
	}

	/**
	 * MAVO version. {@inheritDoc}
	 */
	@Override
	public @NonNull MappingReference createHeavyMappingTypeAndMappingTypeReference(@NonNull ExtensionPointType extensionType, boolean isBinary, @NonNull ModelRel containerModelRelType) throws MMINTException {

		MAVOMapping newMAVOMappingType = (isBinary) ?
			MAVOMIDFactory.eINSTANCE.createBinaryMAVOMapping() :
			MAVOMIDFactory.eINSTANCE.createMAVOMapping();
		MAVOMappingReference newMAVOMappingTypeRef = (MAVOMappingReference) super.addHeavyMappingTypeAndMappingTypeReference(newMAVOMappingType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), containerModelRelType);

		return newMAVOMappingTypeRef;
	}

}
