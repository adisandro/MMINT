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

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.reasoning.KleisliReasoningEngine;

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
			MMINT.URI_SEPARATOR +
			modelTypeEndpointName +
			MMINT.ENDPOINT_SEPARATOR +
			modelType.getName() + "." + EcorePackage.eNAME;
	}

	/**
	 * @generated NOT
	 */
	public KleisliModel kleisliCreateType(KleisliModelEndpoint containerModelTypeEndpoint) throws MMINTException {

		//TODO MMINT[KLEISLI] should try to emulate normal api structure
		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Model origModelType = containerModelTypeEndpoint.getTarget();
		String kModelTypeUri = getModelTypeExtendedUri((KleisliModelRel) containerModelTypeEndpoint.eContainer(), origModelType, containerModelTypeEndpoint.getName());
		if (!MultiModelUtils.isFileOrDirectoryInState(kModelTypeUri)) {
			try {
				EPackage origRootModelTypeObj = origModelType.getEMFTypeRoot();
				String origModelTypeUri = origRootModelTypeObj.getNsURI();
				origRootModelTypeObj.setNsURI(origModelTypeUri + KleisliReasoningEngine.KLEISLI_MODELTYPE_URI_SUFFIX);
				MultiModelUtils.createModelFileInState(origRootModelTypeObj, kModelTypeUri);
				origRootModelTypeObj.setNsURI(origModelTypeUri); // restore original for packages coming from the registry
			}
			catch (Exception e) {
				throw new MMINTException("Error creating extended metamodel file");
			}
		}

		KleisliModel kModelType = KleisliFactory.eINSTANCE.createKleisliModel();
		kModelType.setUri(kModelTypeUri);
		kModelType.setName(origModelType.getName());
		kModelType.setLevel(MIDLevel.TYPES);
		kModelType.setSupertype(origModelType.getSupertype());
		kModelType.setDynamic(true);
		kModelType.setAbstract(origModelType.isAbstract());
		ExtendibleElementConstraint origConstraint = origModelType.getConstraint();
		if (origConstraint != null) {
			ExtendibleElementConstraint kConstraint = MIDFactory.eINSTANCE.createExtendibleElementConstraint();
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
	public void deleteType() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModelUtils.deleteFileInState(getUri());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public EPackage getEMFTypeRoot() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		try {
			return (EPackage) MultiModelUtils.getModelFileInState(getUri());
		}
		catch (Exception e) {
			throw new MMINTException("Error accessing the extended metamodel file for model type" + getUri(), e);
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
			MMINT.URI_SEPARATOR +
			modelEndpoint.getMetatype().getName() +
			MMINT.ENDPOINT_SEPARATOR +
			modelEndpoint.getTarget().getName() + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION;
	}

	/**
	 * @generated NOT
	 */
	public KleisliModel kleisliCreateInstance(KleisliModelEndpoint containerModelEndpoint) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Model origModel = containerModelEndpoint.getTarget();
		KleisliModel kModel = KleisliFactory.eINSTANCE.createKleisliModel();
		kModel.setUri(getModelExtendedUri(containerModelEndpoint));
		kModel.setName(origModel.getName());
		kModel.setLevel(MIDLevel.INSTANCES);
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
	public void deleteInstance() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		MultiModelUtils.deleteFile(getUri(), true);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public EObject getEMFInstanceRoot() throws MMINTException {

		return super.getEMFInstanceRoot();
	}

} //KleisliModelImpl
