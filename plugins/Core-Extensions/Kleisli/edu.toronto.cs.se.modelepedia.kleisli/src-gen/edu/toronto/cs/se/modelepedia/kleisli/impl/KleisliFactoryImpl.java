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
package edu.toronto.cs.se.modelepedia.kleisli.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import edu.toronto.cs.se.modelepedia.kleisli.BinaryKleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KleisliFactoryImpl extends EFactoryImpl implements KleisliFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KleisliFactory init() {
		try {
			KleisliFactory theKleisliFactory = (KleisliFactory)EPackage.Registry.INSTANCE.getEFactory(KleisliPackage.eNS_URI);
			if (theKleisliFactory != null) {
				return theKleisliFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KleisliFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case KleisliPackage.KLEISLI_MODEL: return createKleisliModel();
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT: return createKleisliModelEndpoint();
			case KleisliPackage.KLEISLI_MODEL_REL: return createKleisliModelRel();
			case KleisliPackage.BINARY_KLEISLI_MODEL_REL: return createBinaryKleisliModelRel();
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT_REFERENCE: return createKleisliModelEndpointReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliModel createKleisliModel() {
		KleisliModelImpl kleisliModel = new KleisliModelImpl();
		return kleisliModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliModelRel createKleisliModelRel() {
		KleisliModelRelImpl kleisliModelRel = new KleisliModelRelImpl();
		return kleisliModelRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryKleisliModelRel createBinaryKleisliModelRel() {
		BinaryKleisliModelRelImpl binaryKleisliModelRel = new BinaryKleisliModelRelImpl();
		return binaryKleisliModelRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliModelEndpoint createKleisliModelEndpoint() {
		KleisliModelEndpointImpl kleisliModelEndpoint = new KleisliModelEndpointImpl();
		return kleisliModelEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliModelEndpointReference createKleisliModelEndpointReference() {
		KleisliModelEndpointReferenceImpl kleisliModelEndpointReference = new KleisliModelEndpointReferenceImpl();
		return kleisliModelEndpointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliPackage getKleisliPackage() {
		return (KleisliPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static KleisliPackage getPackage() {
		return KleisliPackage.eINSTANCE;
	}

} //KleisliFactoryImpl
