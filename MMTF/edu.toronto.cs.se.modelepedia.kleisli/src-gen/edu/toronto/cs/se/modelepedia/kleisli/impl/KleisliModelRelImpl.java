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
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.library.KleisliUtils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel newModelRelType = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);
		try {
			MultiModelUtils.createDirectoryInState(newModelRelTypeName);
		}
		catch (Exception e) {
			newModelRelType.deleteType();
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

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel newModelRel = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		MultiModelInstanceFactory.addModel(newModelRel, this, newModelRelUri, origin, containerMultiModel);
		try {
			MultiModelUtils.createDirectory(MultiModelUtils.replaceLastSegmentInUri(getUri(), getName()));
		}
		catch (Exception e) {
			newModelRel.deleteInstance();
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

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void openType() throws MMTFException {

		super.openType();

		//TODO open metamodels for endpoints
		//TODO init outline with augmented ones
		//TODO what about the previous wizard dialog class thing?
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void openInstance() throws MMTFException {

		super.openInstance();

		for (ModelEndpoint modelEndpoint : getModelEndpoints()) {
			ModelEndpoint modelTypeEndpoint = modelEndpoint.getMetatype();
			if (MultiModelUtils.isFileInState(KleisliUtils.getExtendedModelTypeUri(modelTypeEndpoint)) != null) {
				String newModelUri = KleisliUtils.getExtendedModelUri(modelEndpoint);
				try {
					MultiModelUtils.copyTextFileAndReplaceText(modelEndpoint.getTargetUri(), newModelUri, modelEndpoint.getTarget().getMetatypeUri(), modelTypeEndpoint.getUri());
					EObject rootModelObj = MultiModelUtils.getModelFile(newModelUri, true);
					//TODO derive the augmented model
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Error creating extended model file, fallback to no extension", e);
				}
			}
		}
		//TODO init outline with augmented ones
	}

} //KleisliModelRelImpl
