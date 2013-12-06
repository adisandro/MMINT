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
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.library.KleisliUtils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class KleisliModelEndpointImpl extends ModelEndpointImpl implements KleisliModelEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KleisliModelEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KleisliPackage.Literals.KLEISLI_MODEL_ENDPOINT;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ModelEndpointReference createSubtypeAndReference(ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		String newModelTypeUriFragment = KleisliUtils.getExtendedModelTypeUriFragment(this);
		boolean isKleisli = (MultiModelUtils.isFileInState(newModelTypeUriFragment) != null);
		boolean extendMetamodel = false;
		if (!isKleisli) {
			extendMetamodel = MidDiagramUtils.getBooleanInput("Create new Kleisli model relationship type", "Extend " + getTarget().getName() + " metamodel?");
			isKleisli = extendMetamodel;
		}
		if (extendMetamodel) {
			EPackage rootModelTypeObj = (EPackage) MultiModelTypeIntrospection.getRoot(getTarget());
			rootModelTypeObj.setNsURI(KleisliUtils.getExtendedModelTypeUri(this));
			try {
				MultiModelUtils.createModelFileInState(rootModelTypeObj, newModelTypeUriFragment);
			}
			catch (Exception e) {
				throw new MMTFException("Error creating extended metamodel file");
			}
		}

		ModelEndpointReference newModelTypeEndpointRef;
		if (isKleisli) {
			ModelEndpoint newModelTypeEndpoint = KleisliFactory.eINSTANCE.createKleisliModelEndpoint();
			newModelTypeEndpointRef = addSubtypeAndReference(newModelTypeEndpoint, modelTypeEndpointRef, newModelTypeEndpointName, newModelType, isBinarySrc, containerModelRelType);
		}
		else {
			newModelTypeEndpointRef = super.createSubtypeAndReference(modelTypeEndpointRef, newModelTypeEndpointName, newModelType, isBinarySrc, containerModelRelType);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void deleteTypeAndReference(boolean isFullDelete) throws MMTFException {

		super.deleteTypeAndReference(isFullDelete);
		MultiModelUtils.deleteFileInState(KleisliUtils.getExtendedModelTypeUri(this));
	}

} //KleisliModelEndpointImpl
