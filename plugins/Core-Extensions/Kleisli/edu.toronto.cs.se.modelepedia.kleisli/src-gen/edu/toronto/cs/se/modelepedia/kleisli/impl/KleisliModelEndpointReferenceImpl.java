/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelEndpointReferenceImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.reasoning.KleisliReasoner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointReferenceImpl#getExtendedTargetUri <em>Extended Target Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KleisliModelEndpointReferenceImpl extends ModelEndpointReferenceImpl implements KleisliModelEndpointReference {
	/**
   * The default value of the '{@link #getExtendedTargetUri() <em>Extended Target Uri</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getExtendedTargetUri()
   * @generated
   * @ordered
   */
	protected static final String EXTENDED_TARGET_URI_EDEFAULT = null;
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
	@Override
  public String getExtendedTargetUri() {
    // TODO: implement this method to return the 'Extended Target Uri' attribute
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
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
        return EXTENDED_TARGET_URI_EDEFAULT == null ? getExtendedTargetUri() != null : !EXTENDED_TARGET_URI_EDEFAULT.equals(getExtendedTargetUri());
    }
    return super.eIsSet(featureID);
  }

	/**
	 * @generated NOT
	 */
	@Override
	public boolean acceptModelElementType(EObject metamodelObj) throws MMINTException {

		MMINTException.mustBeType(this);

		MID typeMID = this.getMIDContainer();
		String modelTypeUri = MIDRegistry.getModelUri(metamodelObj).replace(KleisliReasoner.KLEISLI_MODELTYPE_URI_SUFFIX, ""); // remove uri suffix
		String modelElemTypeUri = MIDRegistry.getModelElementUri(metamodelObj);
		if (
			!modelTypeUri.equals(getTargetUri()) && // different model type
			!MIDTypeHierarchy.isSubtypeOf(getTargetUri(), modelTypeUri, typeMID) // different light model type with no metamodel extension
		) {
			return false;
		}
		// filter duplicates
		if (MIDRegistry.getReference(modelElemTypeUri, getModelElemRefs()) != null) {
			return false;
		}
		//TODO MMINT[MODELELEMENT] if (metamodelObj instanceof EStructuralFeature) drop only if target type (or any subtype) is already dropped

		return true;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelElement acceptModelElementInstance(EObject modelObj) throws MMINTException {

		MMINTException.mustBeInstance(this);

		String modelUri = MIDRegistry.getModelUri(modelObj);
		String modelElemUri = MIDRegistry.getModelElementUri(modelObj);
		if (!modelUri.equals(getExtendedTargetUri())) { // different extended model
			return null;
		}
		// filter unallowed model element types
		ModelElement modelElemType = MIDConstraintChecker.getAllowedModelElementType(this, modelObj);
		if (modelElemType == null) {
			return null;
		}
		// filter duplicates
		if (MIDRegistry.getReference(modelElemUri + MMINT.ROLE_SEPARATOR + modelElemType.getUri(), getModelElemRefs()) != null) {
			return null;
		}

		return modelElemType;
	}

} //KleisliModelEndpointReferenceImpl
