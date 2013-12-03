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
package edu.toronto.cs.se.modelepedia.kleisli.impl;

import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class KleisliModelRelImpl extends ModelRelImpl implements KleisliModelRel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KleisliModelRelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KleisliPackage.Literals.KLEISLI_MODEL_REL;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void newType() throws Exception {

		MultiModelUtils.createDirectoryInState(getName());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteType() {

		MultiModelUtils.deleteDirectoryInState(getName());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void newInstance() throws Exception {

		MultiModelUtils.createDirectory(MultiModelUtils.replaceLastSegmentInUri(getUri(), getName()));
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() {

		MultiModelUtils.deleteDirectory(MultiModelUtils.replaceLastSegmentInUri(getUri(), getName()));
	}

} //KleisliModelRelImpl
