/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class KleisliModelImpl extends ModelImpl implements KleisliModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KleisliModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KleisliPackage.Literals.KLEISLI_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case KleisliPackage.KLEISLI_MODEL___KLEISLI_CREATE_TYPE__KLEISLIMODELENDPOINT:
				try {
					return kleisliCreateType((KleisliModelEndpoint)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case KleisliPackage.KLEISLI_MODEL___KLEISLI_CREATE_INSTANCE__KLEISLIMODELENDPOINT:
				try {
					return kleisliCreateInstance((KleisliModelEndpoint)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Gets the uri of a Kleisli model type extension.
	 * 
	 * @param modelRelType
	 *            The Kleisli model relationship.
	 * @param modelType
	 *            The model type to be extended.
	 * @param modelTypeEndpointName
	 *            The name of the Kleisli model type endpoint whose target is to
	 *            be extended.
	 * @return The uri of the Kleisli model type extension.
	 * @generated NOT
	 */
	public static String getModelTypeExtendedUri(KleisliModelRel modelRelType, Model modelType, String modelTypeEndpointName) {

		return
			modelRelType.getExtendedUri() +
			MMTF.URI_SEPARATOR +
			modelTypeEndpointName +
			MMTF.ENDPOINT_SEPARATOR +
			modelType.getName() + "." + EcorePackage.eNAME;
	}

	/**
	 * Gets the uri of a Kleisli model type extension.
	 * 
	 * @param modelTypeEndpoint
	 *            The Kleisli model type endpoint whose target is to be
	 *            extended.
	 * @return The uri of the Kleisli model type extension.
	 * @generated NOT
	 */
	private String getModelTypeExtendedUri(KleisliModelEndpoint modelTypeEndpoint) {

		return getModelTypeExtendedUri((KleisliModelRel) modelTypeEndpoint.eContainer(), modelTypeEndpoint.getTarget(), modelTypeEndpoint.getName());
	}

	/**
	 * @generated NOT
	 */
	public KleisliModel kleisliCreateType(KleisliModelEndpoint containerModelTypeEndpoint) throws MMTFException {

		//TODO MMTF[KLEISLI] should try to emulate normal api structure
		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Model origModelType = containerModelTypeEndpoint.getTarget();
		String kModelTypeUri = getModelTypeExtendedUri(containerModelTypeEndpoint);
		if (MultiModelUtils.isFileOrDirectoryInState(kModelTypeUri) == null) {
			try {
				MultiModelUtils.createModelFileInState(origModelType.getEMFTypeRoot(), kModelTypeUri);
			}
			catch (Exception e) {
				throw new MMTFException("Error creating extended metamodel file");
			}
		}

		KleisliModel kModelType = KleisliFactory.eINSTANCE.createKleisliModel();
		kModelType.setUri(kModelTypeUri);
		kModelType.setName(origModelType.getName());
		kModelType.setLevel(MidLevel.TYPES);
		kModelType.setSupertype(origModelType.getSupertype());
		kModelType.setDynamic(true);
		kModelType.setAbstract(origModelType.isAbstract());
		ExtendibleElementConstraint origConstraint = origModelType.getConstraint();
		if (origConstraint != null) {
			ExtendibleElementConstraint kConstraint = MidFactory.eINSTANCE.createExtendibleElementConstraint();
			kConstraint.setLanguage(origConstraint.getLanguage());
			kConstraint.setImplementation(origConstraint.getImplementation());
			kModelType.setConstraint(kConstraint);
		}
		kModelType.setOrigin(ModelOrigin.CREATED);
		kModelType.setFileExtension(origModelType.getFileExtension());
		containerModelTypeEndpoint.setExtendedTarget(kModelType);

		return kModelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteType() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModelUtils.deleteFileInState(getUri());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public EPackage getEMFTypeRoot() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		try {
			return (EPackage) MultiModelUtils.getModelFileInState(getUri());
		}
		catch (Exception e) {
			throw new MMTFException("Error accessing the extended metamodel file for model type" + getUri(), e);
		}
	}

	/**
	 * Gets the uri of a Kleisli model instance extension.
	 * 
	 * @param modelEndpoint
	 *            The Kleisli model endpoint whose target is to be extended.
	 * @return The uri of the Kleisli model extension.
	 * @generated NOT
	 */
	private String getModelExtendedUri(KleisliModelEndpoint modelEndpoint) {

		return
			((KleisliModelRel) modelEndpoint.eContainer()).getExtendedUri() +
			MMTF.URI_SEPARATOR +
			modelEndpoint.getMetatype().getName() +
			MMTF.ENDPOINT_SEPARATOR +
			modelEndpoint.getTarget().getName() + "." + modelEndpoint.getTarget().getFileExtension();
	}

	/**
	 * @generated NOT
	 */
	public KleisliModel kleisliCreateInstance(KleisliModelEndpoint containerModelEndpoint) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Model origModel = containerModelEndpoint.getTarget();
		KleisliModel kModel = KleisliFactory.eINSTANCE.createKleisliModel();
		kModel.setUri(getModelExtendedUri(containerModelEndpoint));
		kModel.setName(origModel.getName());
		kModel.setLevel(MidLevel.INSTANCES);
		kModel.setDynamic(true);
		kModel.setSupertype(null);
		kModel.setMetatypeUri(origModel.getMetatypeUri());
		kModel.setOrigin(ModelOrigin.CREATED);
		kModel.setFileExtension(origModel.getFileExtension());
		containerModelEndpoint.setExtendedTarget(kModel);

		return kModel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		MultiModelUtils.deleteFile(getUri(), true);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public EObject getEMFRoot() throws MMTFException {

		return super.getEMFRoot();
	}

} //KleisliModelImpl
