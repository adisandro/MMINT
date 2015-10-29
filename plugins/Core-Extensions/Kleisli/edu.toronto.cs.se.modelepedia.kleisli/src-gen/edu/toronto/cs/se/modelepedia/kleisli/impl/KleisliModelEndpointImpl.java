/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.impl.ModelEndpointImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl#getExtendedTarget <em>Extended Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl#getExtendedTargetUri <em>Extended Target Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KleisliModelEndpointImpl extends ModelEndpointImpl implements KleisliModelEndpoint {
	/**
	 * The cached value of the '{@link #getExtendedTarget() <em>Extended Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedTarget()
	 * @generated
	 * @ordered
	 */
	protected KleisliModel extendedTarget;
	/**
	 * The cached setting delegate for the '{@link #getExtendedTargetUri() <em>Extended Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedTargetUri()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate EXTENDED_TARGET_URI__ESETTING_DELEGATE = ((EStructuralFeature.Internal)KleisliPackage.Literals.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET_URI).getSettingDelegate();
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
	public KleisliModel getExtendedTarget() {
		return extendedTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendedTarget(KleisliModel newExtendedTarget, NotificationChain msgs) {
		KleisliModel oldExtendedTarget = extendedTarget;
		extendedTarget = newExtendedTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET, oldExtendedTarget, newExtendedTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedTarget(KleisliModel newExtendedTarget) {
		if (newExtendedTarget != extendedTarget) {
			NotificationChain msgs = null;
			if (extendedTarget != null)
				msgs = ((InternalEObject)extendedTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET, null, msgs);
			if (newExtendedTarget != null)
				msgs = ((InternalEObject)newExtendedTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET, null, msgs);
			msgs = basicSetExtendedTarget(newExtendedTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET, newExtendedTarget, newExtendedTarget));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET:
				return basicSetExtendedTarget(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET:
				return getExtendedTarget();
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET_URI:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET:
				setExtendedTarget((KleisliModel)newValue);
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
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET:
				setExtendedTarget((KleisliModel)null);
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
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET:
				return extendedTarget != null;
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET_URI:
				return EXTENDED_TARGET_URI__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelEndpointReference createSubtypeAndReference(String newModelTypeEndpointName, Model targetModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMINTException {

		MMINTException.mustBeType(this);
		if (containerModelRelType instanceof BinaryModelRel) {
			if (containerModelRelType.getModelEndpoints().size() == 2) {
				throw new MMINTException("Can't add more than 2 model type endpoints to a binary model relationship type");
			}
			if (MultiModelTypeHierarchy.getOverriddenModelTypeEndpoint(containerModelRelType, targetModelType) != this) {
				throw new MMINTException("Invalid overriding of this model type endpoint");
			}
		}

		boolean isK =
			MultiModelUtils.isFileOrDirectoryInState(
				KleisliModelImpl.getModelTypeExtendedUri((KleisliModelRel) containerModelRelType, targetModelType, newModelTypeEndpointName)
			);
		boolean extendMetamodel = false;
		if (!isK && MMINT.isInitialized() && !Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_TESTS_ENABLED))) {
			extendMetamodel = MultiModelDiagramUtils.getBooleanInput("Create new Kleisli model type endpoint", "Extend " + targetModelType.getName() + " metamodel?");
			isK = extendMetamodel;
		}
		ModelEndpointReference newModelTypeEndpointRef;
		if (isK) {
			KleisliModelEndpoint newModelTypeEndpoint = super.createThisEClass();
			newModelTypeEndpointRef = super.addSubtypeAndReference(newModelTypeEndpoint, newModelTypeEndpointName, targetModelType, isBinarySrc, containerModelRelType);
			KleisliModel kModelType;
			try {
				kModelType = getExtendedTarget().kleisliCreateType(newModelTypeEndpoint);
			}
			catch (MMINTException e) {
				newModelTypeEndpoint.deleteTypeAndReference(true);
				throw new MMINTException("Error creating extended model type");
			}
			if (extendMetamodel) {
				URI kUri = URI.createFileURI(MultiModelUtils.prependStateToUri(kModelType.getUri()));
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				Model ecoreModelType = MultiModelTypeRegistry.getType(EcorePackage.eNS_URI);
				Editor ecoreEditorType = ecoreModelType.getEditors().get(0);
				try {
					activePage.openEditor(new URIEditorInput(kUri), ecoreEditorType.getId());
				}
				catch (PartInitException e) {
					MMINTException.print(IStatus.ERROR, "Error opening extended metamodel file", e);
				}
			}
		}
		else {
			ModelEndpoint newModelTypeEndpoint = MIDFactory.eINSTANCE.createModelEndpoint();
			newModelTypeEndpointRef = super.addSubtypeAndReference(newModelTypeEndpoint, newModelTypeEndpointName, targetModelType, isBinarySrc, containerModelRelType);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType) throws MMINTException {

		super.replaceSubtypeAndReference(oldModelTypeEndpoint, newModelTypeEndpointName, targetModelType);

		// keep choice of kleisli model type endpoint, there is no mixing problem like for instances
		if (oldModelTypeEndpoint instanceof KleisliModelEndpoint) {
			try {
				getExtendedTarget().kleisliCreateType((KleisliModelEndpoint) oldModelTypeEndpoint);
			}
			catch (MMINTException e) {
				oldModelTypeEndpoint.deleteTypeAndReference(true);
				throw new MMINTException("Error creating extended model type");
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteTypeAndReference(boolean isFullDelete) throws MMINTException {

		super.deleteTypeAndReference(isFullDelete);
		getExtendedTarget().deleteType();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelEndpointReference createInstanceAndReference(Model targetModel, ModelRel containerModelRel) throws MMINTException {

		MMINTException.mustBeType(this);
		if ((containerModelRel instanceof BinaryModelRel) && (containerModelRel.getModelEndpoints().size() == 2)) {
			throw new MMINTException("Can't add more than 2 model endpoints to a binary model relationship");
		}

		KleisliModelEndpoint newModelEndpoint = super.createThisEClass();
		ModelEndpointReference newModelEndpointRef = super.addInstanceAndReference(newModelEndpoint, targetModel, containerModelRel);
		getExtendedTarget().kleisliCreateInstance(newModelEndpoint);

		return newModelEndpointRef;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void replaceInstanceAndReference(ModelEndpoint oldModelEndpoint, Model targetModel) throws MMINTException {

		// can't transform non-kleisli into kleisli
		if (!(oldModelEndpoint instanceof KleisliModelEndpoint)) {
			throw new MMINTException("Can't replace a native model endpoint with a Kleisli one");
		}
		super.replaceInstanceAndReference(oldModelEndpoint, targetModel);
		getExtendedTarget().kleisliCreateInstance((KleisliModelEndpoint) oldModelEndpoint);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstanceAndReference(boolean isFullDelete) throws MMINTException {

		super.deleteInstanceAndReference(isFullDelete);
		getExtendedTarget().deleteInstance();
	}

} //KleisliModelEndpointImpl
