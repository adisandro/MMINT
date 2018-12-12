/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.primitive.file;

import edu.toronto.cs.se.mmint.mid.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * File version, represents a model to be opened with the system editor. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.primitive.file.FilePackage#getFileModel()
 * @model
 * @generated
 */
public interface FileModel extends Model {

	/**
     * <!-- begin-user-doc -->
	 * File version. {@inheritDoc}
	 * <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
     * @generated
     */
	void openInstance() throws Exception;

} // FileModel
