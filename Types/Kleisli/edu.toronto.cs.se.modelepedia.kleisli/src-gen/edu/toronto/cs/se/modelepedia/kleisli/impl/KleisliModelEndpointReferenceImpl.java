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
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelEndpointReferenceImpl;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointReferenceImpl#getExtendedTargetUri <em>Extended Target Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KleisliModelEndpointReferenceImpl extends ModelEndpointReferenceImpl implements KleisliModelEndpointReference {
	/**
	 * The cached setting delegate for the '{@link #getExtendedTargetUri() <em>Extended Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedTargetUri()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate EXTENDED_TARGET_URI__ESETTING_DELEGATE = ((EStructuralFeature.Internal)KleisliPackage.Literals.KLEISLI_MODEL_ENDPOINT_REFERENCE__EXTENDED_TARGET_URI).getSettingDelegate();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KleisliModelEndpointReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KleisliPackage.Literals.KLEISLI_MODEL_ENDPOINT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtendedTargetUri() {
		return (String)EXTENDED_TARGET_URI__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT_REFERENCE__EXTENDED_TARGET_URI:
				return getExtendedTargetUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT_REFERENCE__EXTENDED_TARGET_URI:
				return EXTENDED_TARGET_URI__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean acceptModelElementType(EObject metamodelObj) throws MMINTException {

		//TODO MMINT[KLEISLI] do we need to do something here?
		return super.acceptModelElementType(metamodelObj);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelElement acceptModelElementInstance(EObject modelObj) throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		String[] uris = MultiModelRegistry.getModelAndModelElementUris(modelObj, MidLevel.INSTANCES);
		String modelUri = uris[0];
		String modelElemUri = uris[1];
		if (!modelUri.equals(getExtendedTargetUri())) { // different extended model
			return null;
		}
		// filter unallowed model element types
		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(this, modelObj);
		if (modelElemType == null) {
			return null;
		}
		// filter duplicates
		if (MultiModelTypeHierarchy.getReference(modelElemUri + MMINT.ROLE_SEPARATOR + modelElemType.getUri(), getModelElemRefs()) != null) {
			return null;
		}

		return modelElemType;
	}

} //KleisliModelEndpointReferenceImpl
