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
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
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
	 * @generated NOT
	 */
	@Override
	public void newType() throws Exception {

		String newModelTypeUriFragment = KleisliUtils.getExtendedModelTypeUriFragment(this);
		boolean isExtendedMetamodel = false;
		if (MultiModelUtils.isFileInState(newModelTypeUriFragment) == null) {
			isExtendedMetamodel = MidDiagramUtils.getBooleanInput("Create new Kleisli model relationship type", "Extend " + getTarget().getName() + " metamodel?");
		}
		if (isExtendedMetamodel) {
			EPackage rootModelTypeObj = (EPackage) MultiModelTypeIntrospection.getRoot(getTarget());
			rootModelTypeObj.setNsURI(KleisliUtils.getExtendedModelTypeUri(this));
			try {
				MultiModelUtils.createModelFileInState(rootModelTypeObj, newModelTypeUriFragment);
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "Error creating extended metamodel file, fallback to no extension", e);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteType() {

		String modelTypeUri = KleisliUtils.getExtendedModelTypeUri(this);
		MultiModelUtils.deleteFileInState(modelTypeUri);
	}

} //KleisliModelEndpointImpl
