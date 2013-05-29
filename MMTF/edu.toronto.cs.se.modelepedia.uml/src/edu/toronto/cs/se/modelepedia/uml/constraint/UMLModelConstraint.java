/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.repository.JavaModelConstraint;

public abstract class UMLModelConstraint extends JavaModelConstraint {

	private static final String NOTATION_FILEEXTENSION = "notation";
	protected static final String UML_CLASSDIAGRAM_TYPE = "PapyrusUMLClassDiagram";
	protected static final String UML_COMPONENTDIAGRAM_TYPE = "PapyrusUMLComponentDiagram";
	protected static final String UML_DEPLOYMENTDIAGRAM_TYPE = "PapyrusUMLDeploymentDiagram";

	protected boolean validate(String modelTypeName) {

		String notationFileUri = MultiModelRegistry.replaceFileExtensionInUri(model.getUri(), NOTATION_FILEEXTENSION);
		try {
			Diagram diagram = (Diagram) MultiModelTypeIntrospection.getRoot(notationFileUri);
			return diagram.getType().equals(modelTypeName);
		}
		catch (Exception e) {
			return false;
		}
	}

	public UMLModelConstraint(Model model) {

		super(model);
	}

}
