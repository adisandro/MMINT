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
package edu.toronto.cs.se.modelepedia.uml.constraint;

import org.eclipse.gmf.runtime.notation.Diagram;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.JavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.reasoning.Z3SMTUtils.MAVOTruthValue;

public abstract class UMLModelConstraint extends JavaModelConstraint {

	private static final String NOTATION_FILEEXTENSION = "notation";
	protected static final String UML_CLASSDIAGRAM_TYPE = "PapyrusUMLClassDiagram";
	protected static final String UML_COMPONENTDIAGRAM_TYPE = "PapyrusUMLComponentDiagram";
	protected static final String UML_DEPLOYMENTDIAGRAM_TYPE = "PapyrusUMLDeploymentDiagram";

	protected MAVOTruthValue validate(String modelTypeName) {

		String notationFileUri = MultiModelUtils.replaceFileExtensionInUri(model.getUri(), NOTATION_FILEEXTENSION);
		try {
			Diagram diagram = (Diagram) MultiModelUtils.getModelFile(notationFileUri, true);
			return (diagram.getType().equals(modelTypeName)) ? MAVOTruthValue.TRUE : MAVOTruthValue.FALSE;
		}
		catch (Exception e) {
			return MAVOTruthValue.FALSE;
		}
	}

	public UMLModelConstraint(Model model) {

		super(model);
	}

}
