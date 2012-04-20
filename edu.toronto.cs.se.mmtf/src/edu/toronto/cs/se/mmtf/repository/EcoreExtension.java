/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.repository;

/**
 * The built-in Ecore extension.
 * 
 * @author Vivien Suen, Alessio Di Sandro
 * 
 */
public class EcoreExtension {

	/** The Ecore metamodel uri. */
	private final static String ECORE_METAMODEL_URI = "http://www.eclipse.org/emf/2002/Ecore";
	/** The Ecore metamodel file extension. */
	private final static String ECORE_METAMODEL_FILE_EXTENSION = "ecore";
	/** The Ecore editors id. */
	private final static String[] ECORE_EDITORS_ID = {
		"org.eclipse.emf.ecore.presentation.EcoreEditorID", 
		"org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorID"
	};
	/** The Ecore editors type. */
	private final static boolean[] ECORE_EDITORS_IS_DIAGRAM = {
		false,
		true
	};
	/** The Ecore editors wizard id. */
	private final static String[] ECORE_EDITORS_WIZARD_ID = {
		"org.eclipse.emf.ecore.presentation.EcoreModelWizardID",
		"org.eclipse.emf.ecoretools.diagram.part.EcoreCreationWizardID"
	};
	/** The Ecore editors name. */
	private final static String[] ECORE_EDITORS_NAME = {
		"Sample Ecore Editor",
		"Ecore Diagram Editing"
	};
	/** The Ecore editors file extension. */
	private final static String[] ECORE_EDITORS_FILE_EXTENSION = {
		"ecore",
		"ecorediag"
	};
	/** The repository of registered extensions. */
	private Repository repository;

	/**
	 * Adds the Ecore metamodel to the repository.
	 * 
	 * @return The created metamodel.
	 */
	private Metamodel addEcoreMetamodel() {

		Metamodel ecoreMetamodel = RepositoryFactory.eINSTANCE.createMetamodel();
		ecoreMetamodel.setName("Ecore metamodel");
		ecoreMetamodel.setUri(ECORE_METAMODEL_URI);
		ecoreMetamodel.setFileExtension(ECORE_METAMODEL_FILE_EXTENSION);		
		repository.getMetamodels().put(ECORE_METAMODEL_URI, ecoreMetamodel);

		return ecoreMetamodel;
	}

	/**
	 * Adds an Ecore editor to the repository.
	 * 
	 * @param i
	 *            The Ecore editor index.
	 * @return The created editor.
	 */
	private Editor addEcoreEditor(int i) {

		Editor editor;
		if (ECORE_EDITORS_IS_DIAGRAM[i]) {
			editor = RepositoryFactory.eINSTANCE.createDiagram();
		}
		else {
			editor = RepositoryFactory.eINSTANCE.createEditor();
		}
		editor.setName(ECORE_EDITORS_NAME[i]);
		editor.setMetamodelUri(ECORE_METAMODEL_URI);
		editor.setEditorId(ECORE_EDITORS_ID[i]);
		editor.setWizardId(ECORE_EDITORS_WIZARD_ID[i]);
		repository.getEditors().put(ECORE_EDITORS_ID[i], editor);

		return editor;
	}

	/**
	 * Constructor: initialises the repository.
	 * 
	 * @param repository
	 *            The repository of registered extensions.
	 */
	public EcoreExtension(Repository repository) {

		this.repository = repository;
	}

	/**
	 * Adds Ecore as a registered extension.
	 */
	public void addToRepository() {

		Metamodel ecoreMetamodel = addEcoreMetamodel();
		for (int i = 0; i < ECORE_EDITORS_ID.length; i++) {
			Editor ecoreEditor = addEcoreEditor(i);
			ecoreMetamodel.getEditors().add(ecoreEditor);
			ecoreEditor.getFileExtensions().add(ECORE_EDITORS_FILE_EXTENSION[i]);
		}
	}

}
