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
package edu.toronto.cs.se.modelepedia.primitive.file.library;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDHeavyTypeFactory;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.repository.ExtensionType;
import edu.toronto.cs.se.modelepedia.primitive.file.FileFactory;

/**
 * The factory to create/modify/remove File "heavy" types.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class FileMIDHeavyTypeFactory extends MIDHeavyTypeFactory {

	/**
	 * File version. {@inheritDoc}
	 */
	@Override
	public Model createHeavyModelType(ExtensionType extensionType, String constraintLanguage, String constraintImplementation) throws MMINTException {

		Model newModelType = FileFactory.eINSTANCE.createFileModel();
		super.addHeavyModelType(newModelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), extensionType.isAbstract(), constraintLanguage, constraintImplementation);

		return newModelType;
	}

}
