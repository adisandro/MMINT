/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MAVOModelImpl extends ModelImpl implements MAVOModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOMIDPackage.Literals.MAVO_MODEL;
	}

	/**
	 * @generated NOT
	 */
	public Model createSubtype(String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MMINTException.mustBeType(this);

		MAVOModel newMAVOModelType = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addSubtype(newMAVOModelType, newModelTypeName, constraintLanguage, constraintImplementation, isMetamodelExtension);

		return newMAVOModelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Model createInstance(String newModelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		MAVOModel newMAVOModel = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addInstance(newMAVOModel, newModelUri, ModelOrigin.CREATED, instanceMID);
		MAVOUtils.initializeMAVOModel(newMAVOModel.getEMFInstanceRoot(), newMAVOModel);

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Model createInstanceAndEditor(String newModelUri, MID instanceMID) throws MMINTException {

		MAVOModel newMAVOModel = (MAVOModel) this.createInstance(newModelUri, instanceMID);
		if (instanceMID != null) {
			newMAVOModel.createInstanceEditor();
		}

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	public Model importInstance(String modelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		MAVOModel newMAVOModel = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addInstance(newMAVOModel, modelUri, ModelOrigin.IMPORTED, instanceMID);
		MAVOUtils.initializeMAVOModel(newMAVOModel.getEMFInstanceRoot(), newMAVOModel);

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	public Model importInstanceAndEditor(String modelUri, MID instanceMID) throws MMINTException {

		MAVOModel newMAVOModel = (MAVOModel) this.importInstance(modelUri, instanceMID);
		if (instanceMID != null) {
			newMAVOModel.createInstanceEditor();
		}

		return newMAVOModel;
	}

} //MAVOModelImpl
