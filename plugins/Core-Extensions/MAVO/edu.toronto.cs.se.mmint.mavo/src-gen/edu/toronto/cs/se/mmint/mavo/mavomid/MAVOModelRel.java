/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAVO Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MAVO version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage#getMAVOModelRel()
 * @model
 * @generated
 */
public interface MAVOModelRel extends ModelRel {

	/**
   * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" origModelRequired="true" newModelNameRequired="true" instanceMIDRequired="true"
   * @generated
   */
	Model copyInstance(Model origModel, String newModelName, MID instanceMID) throws MMINTException;
} // MAVOModelRel
