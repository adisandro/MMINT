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
package edu.toronto.cs.se.mmint.mavo.mavomid;

import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.MMINTException;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAVO Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MAVO version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage#getMAVOModel()
 * @model
 * @generated
 */
public interface MAVOModel extends Model, MAVORoot {
	/**
	 * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelUriRequired="true"
	 * @generated
	 */
	Model createInstance(String newModelUri, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelUriRequired="true"
	 * @generated
	 */
	Model importInstance(String modelUri, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model dataType="edu.toronto.cs.se.mmint.mid.IStatus" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" contextDataType="edu.toronto.cs.se.mmint.mid.IValidationContext" contextRequired="true"
	 * @generated
	 */
	IStatus validateInstanceInEditor(IValidationContext context) throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String toMIDCustomPrintLabel();

	/**
	 * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String toMIDCustomEditLabel();

	/**
	 * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model newLabelRequired="true"
	 * @generated
	 */
	void updateMIDCustomLabel(String newLabel);

} // MAVOModel
