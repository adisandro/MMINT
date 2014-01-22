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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelOpenEditorCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.library.KleisliUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
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
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl#getExtendedTarget <em>Extended Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl#getExtendedTargetUri <em>Extended Target Uri</em>}</li>
 * </ul>
 * </p>
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
			EPackage rootModelTypeObj = targetModelType.getEMFTypeRoot();
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
				EPackage rootModelTypeObj = targetModelType.getEMFTypeRoot();
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
