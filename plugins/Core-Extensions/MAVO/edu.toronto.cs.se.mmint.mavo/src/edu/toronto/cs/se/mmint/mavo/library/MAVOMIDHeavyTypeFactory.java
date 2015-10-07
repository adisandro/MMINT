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
package edu.toronto.cs.se.mmint.mavo.library;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelHeavyTypeFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.repository.ExtensionType;

public class MAVOMIDHeavyTypeFactory extends MultiModelHeavyTypeFactory {

	/**
	 * MAVO version. {@inheritDoc}
	 */
	@Override
	public Model createHeavyModelType(ExtensionType extensionType, String constraintLanguage, String constraintImplementation) throws MMINTException {

		MAVOModel newMAVOModelType = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addHeavyModelType(newMAVOModelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), extensionType.isAbstract(), constraintLanguage, constraintImplementation);

		return newMAVOModelType;
	}

	/**
	 * MAVO version. {@inheritDoc}
	 */
	@Override
	public ModelElement createHeavyModelElementType(ExtensionType extensionType, EMFInfo eInfo, Model modelType) throws MMINTException {

		MAVOModelElement newMAVOModelElemType = MAVOMIDFactory.eINSTANCE.createMAVOModelElement();
		ModelElement modelElemType = super.getSupertype(newMAVOModelElemType, extensionType.getUri(), extensionType.getSupertypeUri());
		super.addHeavyType(newMAVOModelElemType, modelElemType, extensionType.getUri(), extensionType.getName());
		super.addModelElementType(newMAVOModelElemType, eInfo, modelType);

		return newMAVOModelElemType;
	}

}
