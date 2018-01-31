/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid.impl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MAVOModelRelImpl extends ModelRelImpl implements MAVOModelRel {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MAVOModelRelImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return MAVOMIDPackage.Literals.MAVO_MODEL_REL;
    }

	/**
	 * @generated NOT
	 */
	@Override
	public Model copyInstance(Model origModelRel, String newModelRelName, MID instanceMID) throws MMINTException {

		MAVOModelRel newMAVOModelRel = (MAVOModelRel) super.copyInstance(origModelRel, newModelRelName, instanceMID);
		for (int i = 0; i < ((ModelRel) origModelRel).getMappingRefs().size(); i++) {
			MAVOMappingReference origMAVOMappingRef = (MAVOMappingReference) ((ModelRel) origModelRel).getMappingRefs().get(i);
			MAVOMappingReference newMAVOMappingRef = (MAVOMappingReference) ((ModelRel) newMAVOModelRel).getMappingRefs().get(i);
			MAVOUtils.copyMAVOElement(origMAVOMappingRef.getObject(), newMAVOMappingRef.getObject());
		}

		return newMAVOModelRel;
	}

} //MAVOModelRelImpl
