/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo;

import edu.toronto.cs.se.mavo.MAVORoot;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase#getTables <em>Tables</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getRelationalDatabase()
 * @model
 * @generated
 */
public interface RelationalDatabase extends MAVORoot {
	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getRelationalDatabase_Tables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Table> getTables();

} // RelationalDatabase
