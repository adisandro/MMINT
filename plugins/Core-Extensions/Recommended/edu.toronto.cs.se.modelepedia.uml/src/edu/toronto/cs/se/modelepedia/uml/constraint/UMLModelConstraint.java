/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.uml.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.notation.Diagram;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public abstract class UMLModelConstraint implements IJavaModelConstraint {

	private static final String NOTATION_FILEEXTENSION = "notation";
	protected static final String UML_CLASSDIAGRAM_TYPE = "PapyrusUMLClassDiagram";
	protected static final String UML_COMPONENTDIAGRAM_TYPE = "PapyrusUMLComponentDiagram";
	protected static final String UML_DEPLOYMENTDIAGRAM_TYPE = "PapyrusUMLDeploymentDiagram";

	protected boolean check(Model model, String modelTypeName) {

		String notationFileUri = FileUtils.replaceFileExtensionInPath(model.getUri(), NOTATION_FILEEXTENSION);
		try {
			Diagram diagram = (Diagram) FileUtils.readModelFile(notationFileUri, null, true);
			return diagram.getType().equals(modelTypeName);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't get diagram root, skipping validation", e);
			return false;
		}
	}

}
