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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
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
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException {

		ModelRel newModelRelType = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);
		try {
			MultiModelUtils.createDirectoryInState(newModelRelTypeName);
		}
		catch (Exception e) {
			super.deleteType();
			throw new MMTFException("Error creating directory for extended metamodels", e);
		}

		return newModelRelType;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void deleteType() throws MMTFException {

		super.deleteType();
		MultiModelUtils.deleteDirectoryInState(getName());
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ModelRel createInstance(String newModelRelUri, boolean isBinary, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException {

		ModelRel newModelRel = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		MultiModelInstanceFactory.addModel(newModelRel, this, newModelRelUri, origin, containerMultiModel);
		try {
			MultiModelUtils.createDirectory(MultiModelUtils.replaceLastSegmentInUri(getUri(), getName()));
		}
		catch (Exception e) {
			super.deleteInstance();
			throw new MMTFException("Error creating directory for extended models", e);
		}

		return newModelRel;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMTFException {

		super.deleteInstance();
		MultiModelUtils.deleteDirectory(MultiModelUtils.replaceLastSegmentInUri(getUri(), getName()));
	}

} //KleisliModelRelImpl
