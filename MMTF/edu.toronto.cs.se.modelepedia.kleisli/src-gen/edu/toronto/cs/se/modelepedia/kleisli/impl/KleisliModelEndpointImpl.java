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
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelOpenEditorCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliExtendibleElement;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.library.KleisliUtils;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl#getExtendedUri <em>Extended Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KleisliModelEndpointImpl extends ModelEndpointImpl implements KleisliModelEndpoint {
	/**
	 * The default value of the '{@link #getExtendedUri() <em>Extended Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedUri()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENDED_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExtendedUri() <em>Extended Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedUri()
	 * @generated
	 * @ordered
	 */
	protected String extendedUri = EXTENDED_URI_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtendedUri() {
		return extendedUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedUri(String newExtendedUri) {
		String oldExtendedUri = extendedUri;
		extendedUri = newExtendedUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_URI, oldExtendedUri, extendedUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_URI:
				return getExtendedUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_URI:
				setExtendedUri((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_URI:
				setExtendedUri(EXTENDED_URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_URI:
				return EXTENDED_URI_EDEFAULT == null ? extendedUri != null : !EXTENDED_URI_EDEFAULT.equals(extendedUri);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == KleisliExtendibleElement.class) {
			switch (derivedFeatureID) {
				case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_URI: return KleisliPackage.KLEISLI_EXTENDIBLE_ELEMENT__EXTENDED_URI;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == KleisliExtendibleElement.class) {
			switch (baseFeatureID) {
				case KleisliPackage.KLEISLI_EXTENDIBLE_ELEMENT__EXTENDED_URI: return KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_URI;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (extendedUri: ");
		result.append(extendedUri);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelEndpointReference createTypeReference(ModelEndpointReference modelTypeEndpointRef, boolean isModifiable, boolean isBinarySrc, ModelRel containerModelRelType) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		KleisliModelEndpointReference newModelTypeEndpointRef = KleisliFactory.eINSTANCE.createKleisliModelEndpointReference();
		super.addTypeReference(newModelTypeEndpointRef, modelTypeEndpointRef, isModifiable, isBinarySrc, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelEndpointReference createInstanceReference(boolean isBinarySrc, ModelRel containerModelRel) throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		KleisliModelEndpointReference newModelEndpointRef = KleisliFactory.eINSTANCE.createKleisliModelEndpointReference();
		super.addInstanceReference(newModelEndpointRef, isBinarySrc, containerModelRel);

		return newModelEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelEndpointReference createSubtypeAndReference(ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model targetModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		String newModelTypeEndpointExtendedUri = KleisliUtils.getModelTypeEndpointExtendedUri(targetModelType, (KleisliModelRel) containerModelRelType);
		boolean isKleisli = (MultiModelUtils.isFileOrDirectoryInState(newModelTypeEndpointExtendedUri) != null);
		boolean extendMetamodel = false;
		if (!isKleisli) {
			extendMetamodel = MidDiagramUtils.getBooleanInput("Create new Kleisli model type endpoint", "Extend " + targetModelType.getName() + " metamodel?");
			isKleisli = extendMetamodel;
		}
		if (extendMetamodel) {
			EPackage rootModelTypeObj = (EPackage) MultiModelTypeIntrospection.getRoot(targetModelType);
			try {
				MultiModelUtils.createModelFileInState(rootModelTypeObj, newModelTypeEndpointExtendedUri);
			}
			catch (Exception e) {
				throw new MMTFException("Error creating extended metamodel file");
			}
		}

		ModelEndpointReference newModelTypeEndpointRef;
		if (isKleisli) {
			KleisliModelEndpoint newModelTypeEndpoint = KleisliFactory.eINSTANCE.createKleisliModelEndpoint();
			newModelTypeEndpointRef = super.addSubtypeAndReference(newModelTypeEndpoint, modelTypeEndpointRef, newModelTypeEndpointName, targetModelType, isBinarySrc, containerModelRelType);
			newModelTypeEndpoint.setExtendedUri(newModelTypeEndpointExtendedUri);
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			URI uri = URI.createFileURI(MultiModelUtils.isFileOrDirectoryInState(newModelTypeEndpointExtendedUri));
			try {
				activePage.openEditor(new URIEditorInput(uri), ModelOpenEditorCommand.ECORE_EDITORID);
			}
			catch (PartInitException e) {
				MMTFException.print(Type.WARNING, "Error opening extended metamodel file", e);
			}
		}
		else {
			newModelTypeEndpointRef = super.createSubtypeAndReference(modelTypeEndpointRef, newModelTypeEndpointName, targetModelType, isBinarySrc, containerModelRelType);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model targetModelType, ModelRel containerModelRelType) throws MMTFException {

		super.replaceSubtypeAndReference(oldModelTypeEndpoint, modelTypeEndpointRef, newModelTypeEndpointName, targetModelType, containerModelRelType);

		// keep choice of kleisli model type endpoint, there is no mixing problem like for instances
		if (oldModelTypeEndpoint instanceof KleisliModelEndpoint) {
			String newModelTypeEndpointExtendedUri = KleisliUtils.getModelTypeEndpointExtendedUri(targetModelType, (KleisliModelRel) containerModelRelType);
			((KleisliModelEndpoint) oldModelTypeEndpoint).setExtendedUri(newModelTypeEndpointExtendedUri);
			if (MultiModelUtils.isFileOrDirectoryInState(newModelTypeEndpointExtendedUri) == null) {
				EPackage rootModelTypeObj = (EPackage) MultiModelTypeIntrospection.getRoot(targetModelType);
				try {
					MultiModelUtils.createModelFileInState(rootModelTypeObj, newModelTypeEndpointExtendedUri);
				}
				catch (Exception e) {
					oldModelTypeEndpoint.deleteTypeAndReference(true);
					throw new MMTFException("Error creating extended metamodel file");
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteTypeAndReference(boolean isFullDelete) throws MMTFException {

		super.deleteTypeAndReference(isFullDelete);
		MultiModelUtils.deleteFileInState(getExtendedUri());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelEndpointReference createInstanceAndReference(Model targetModel, boolean isBinarySrc, ModelRel containerModelRel) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		KleisliModelEndpoint newModelEndpoint = KleisliFactory.eINSTANCE.createKleisliModelEndpoint();
		ModelEndpointReference newModelEndpointRef = super.addInstanceAndReference(newModelEndpoint, targetModel, isBinarySrc, containerModelRel);
		newModelEndpoint.setExtendedUri(KleisliUtils.getModelEndpointExtendedUri(newModelEndpoint));

		return newModelEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void replaceInstanceAndReference(ModelEndpoint oldModelEndpoint, Model targetModel) throws MMTFException {

		// can't transform non-kleisli into kleisli
		if (!(oldModelEndpoint instanceof KleisliModelEndpoint)) {
			throw new MMTFException("Can't replace a native model endpoint with a Kleisli one");
		}
		super.replaceInstanceAndReference(oldModelEndpoint, targetModel);
		((KleisliModelEndpoint) oldModelEndpoint).setExtendedUri(KleisliUtils.getModelEndpointExtendedUri((KleisliModelEndpoint) oldModelEndpoint));
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstanceAndReference(boolean isFullDelete) throws MMTFException {

		super.deleteInstanceAndReference(isFullDelete);
		MultiModelUtils.deleteFile(getExtendedUri(), true);
	}

} //KleisliModelEndpointImpl
