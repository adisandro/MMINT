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
package edu.toronto.cs.se.mmtf.mid.editor;

import edu.toronto.cs.se.mmtf.MMTFException;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A diagram type or a diagram instance.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.editor.EditorPackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends Editor {

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this diagram type
	 * to the Type MID.
	 * 
	 * @param newEditorTypeFragmentUri
	 *            The uri fragment to be appended as part of the uri of the new
	 *            diagram type.
	 * @param newEditorTypeName
	 *            The name of the new diagram type.
	 * @param modelTypeUri
	 *            The uri of the model type handled by the new diagram type.
	 * @param editorId
	 *            The id of the corresponding Eclipse editor.
	 * @param wizardId
	 *            The wizard id of the corresponding Eclipse editor.
	 * @param wizardDialogClassName
	 *            The fully qualified name of a Java class that handles the
	 *            creation of the model type through the new diagram type.
	 * @return The created editor type.
	 * @throws MMTFException
	 *             If this is a diagram instance, or if the uri of the new
	 *             diagram type is already registered in the Type MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newEditorTypeFragmentUriRequired="true" newEditorTypeNameRequired="true" modelTypeUriRequired="true" editorIdRequired="true" wizardIdRequired="true" wizardDialogClassNameRequired="true"
	 * @generated
	 */
	Editor createSubtype(String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMTFException;

} // Diagram
