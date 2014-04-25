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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MidFactory;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelOpenEditorCommand;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelRelImpl#getExtendedUri <em>Extended Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KleisliModelRelImpl extends ModelRelImpl implements KleisliModelRel {
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
	protected KleisliModelRelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KleisliPackage.Literals.KLEISLI_MODEL_REL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI, oldExtendedUri, extendedUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI:
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
			case KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI:
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
			case KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI:
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
			case KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (extendedUri: ");
		result.append(extendedUri);
		result.append(')');
		return result.toString();
	}

	/**
	 * Gets the uri of a Kleisli model relationship type extension.
	 * 
	 * @param modelRelType
	 *            The Kleisli model relationship type.
	 * @return The uri of the Kleisli model relationship type extension.
	 * @generated NOT
	 */
	private String getModelRelTypeExtendedUri(KleisliModelRel modelRelType) {

		return modelRelType.getName();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		KleisliModelRel newModelRelType = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		super.addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);
		String newModelRelTypeExtendedUri = getModelRelTypeExtendedUri(newModelRelType);
		newModelRelType.setExtendedUri(newModelRelTypeExtendedUri);
		if (MultiModelUtils.isFileOrDirectoryInState(newModelRelTypeExtendedUri) == null) {
			try {
				MultiModelUtils.createDirectoryInState(newModelRelTypeExtendedUri);
			}
			catch (Exception e) {
				newModelRelType.deleteType();
				throw new MMINTException("Error creating directory for extended metamodels", e);
			}
		}

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException {

		ModelRel newModelRelType = super.copySubtype(origModelRelType);
		MultiModel multiModel = MultiModelRegistry.getMultiModel(newModelRelType);
		ExtendibleElementConstraint newConstraint, origConstraint;
		ModelElement newModelElemType;
		for (ModelEndpoint origModelTypeEndpoint : origModelRelType.getModelEndpoints()) {
			if (!(origModelTypeEndpoint instanceof KleisliModelEndpoint)) {
				continue;
			}
			for (ModelElement origModelElemType : origModelTypeEndpoint.getTarget().getModelElems()) {
				origConstraint = origModelElemType.getConstraint();
				if (origConstraint != null) {
					newConstraint = MidFactory.eINSTANCE.createExtendibleElementConstraint();
					newConstraint.setLanguage(origConstraint.getLanguage());
					newConstraint.setImplementation(origConstraint.getImplementation());
					newModelElemType = MultiModelRegistry.getExtendibleElement(origModelElemType.getUri(), multiModel);
					newModelElemType.setConstraint(newConstraint);
				}
			}
		}

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteType() throws MMINTException {

		super.deleteType();
		MultiModelUtils.deleteDirectoryInState(getExtendedUri());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ResourceSet getOutlineResourceTypes() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		List<Resource> resources = resourceSet.getResources();
		for (ModelEndpointReference modelTypeEndpointRef : getModelEndpointRefs()) {
			ModelEndpoint modelTypeEndpoint = modelTypeEndpointRef.getObject();
			Model modelType = (modelTypeEndpoint instanceof KleisliModelEndpoint) ?
				((KleisliModelEndpoint) modelTypeEndpoint).getExtendedTarget() :
				modelTypeEndpoint.getTarget();
			do {
				resources.add(modelType.getEMFTypeRoot().eResource());
				modelType = modelType.getSupertype();
			}
			while (modelType != null && !modelType.isAbstract());
		}

		return resourceSet;
	}

	/**
	 * Gets the uri of a Kleisli model relationship instance extension.
	 * 
	 * @param modelRel
	 *            The Kleisli model relationship.
	 * @return The uri of the Kleisli model relationship extension.
	 * @generated NOT
	 */
	private String getModelRelExtendedUri(KleisliModelRel modelRel) {

		String baseModelRelExtendedUri = MultiModelUtils.replaceLastSegmentInUri(MultiModelRegistry.getModelAndModelElementUris(modelRel, MidLevel.INSTANCES)[0], modelRel.getMetatype().getName());
		int iModelRelExtendedUri = -1;
		do {
			iModelRelExtendedUri++;
		}
		while (MultiModelUtils.isFileOrDirectory(baseModelRelExtendedUri + iModelRelExtendedUri, true) != null);

		return baseModelRelExtendedUri + iModelRelExtendedUri;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelRel createInstance(String newModelRelUri, boolean isBinary, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		KleisliModelRel newModelRel = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		super.addInstance(newModelRel, newModelRelUri, origin, containerMultiModel);
		String modelRelExtendedUri = getModelRelExtendedUri(newModelRel);
		newModelRel.setExtendedUri(modelRelExtendedUri);
		try {
			MultiModelUtils.createDirectory(modelRelExtendedUri, true);
		}
		catch (Exception e) {
			newModelRel.deleteInstance();
			throw new MMINTException("Error creating directory for extended models", e);
		}

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMINTException {

		super.deleteInstance();
		MultiModelUtils.deleteDirectory(getExtendedUri(), true);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ResourceSet getOutlineResourceInstances() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		List<Resource> resources = resourceSet.getResources();
		for (ModelEndpointReference modelEndpointRef : getModelEndpointRefs()) {
			ModelEndpoint modelEndpoint = modelEndpointRef.getObject();
			Model model = (modelEndpoint instanceof KleisliModelEndpoint) ?
				((KleisliModelEndpoint) modelEndpoint).getExtendedTarget() :
				modelEndpoint.getTarget();
			resources.add(model.getEMFInstanceRoot().eResource());
		}

		return resourceSet;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void openType() throws MMINTException {

		super.openType();

		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		for (ModelEndpoint modelTypeEndpoint : getModelEndpoints()) {
			if (!(modelTypeEndpoint instanceof KleisliModelEndpoint)) {
				continue;
			}
			String kModelTypeUri = MultiModelUtils.isFileOrDirectoryInState(((KleisliModelEndpoint) modelTypeEndpoint).getExtendedTargetUri());
			if (kModelTypeUri != null) { // the root KleisliModelRel has no extended metamodel to open
				URI kUri = URI.createFileURI(kModelTypeUri);
				try {
					activePage.openEditor(new URIEditorInput(kUri), ModelOpenEditorCommand.ECORE_EDITORID);
				}
				catch (PartInitException e) {
					MMINTException.print(Type.ERROR, "Error opening extended metamodel file", e);
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void openInstance() throws MMINTException {

		super.openInstance();

		// extend models (doing it at every open is robust against model change)
		for (ModelEndpoint modelEndpoint : getModelEndpoints()) {
			ModelEndpoint modelTypeEndpoint = modelEndpoint.getMetatype();
			if (!(modelTypeEndpoint instanceof KleisliModelEndpoint)) {
				continue;
			}
			KleisliModelEndpoint kModelTypeEndpoint = (KleisliModelEndpoint) modelTypeEndpoint;
			KleisliModelEndpoint kModelEndpoint = (KleisliModelEndpoint) modelEndpoint;
			try {
				EPackage kModelTypePackage = kModelTypeEndpoint.getExtendedTarget().getEMFTypeRoot();
				EFactory kModelTypeFactory = kModelTypePackage.getEFactoryInstance();
				ModelEndpointReference kModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(kModelTypeEndpoint.getUri(), ((ModelRel) kModelTypeEndpoint.eContainer()).getModelEndpointRefs());
				String kModelUri = kModelEndpoint.getExtendedTargetUri();
				MultiModelUtils.copyTextFileAndReplaceText(
					MultiModelUtils.prependWorkspaceToUri(kModelEndpoint.getTargetUri()),
					MultiModelUtils.prependWorkspaceToUri(kModelUri),
					MultiModelUtils.getLastSegmentFromUri(kModelTypeEndpoint.getTargetUri() + "." + EcorePackage.eNAME),
					kModelTypeEndpoint.getExtendedTargetUri()
				);
				EObject kRootModelObj = kModelEndpoint.getExtendedTarget().getEMFInstanceRoot();
				EMFInfo kModelElemTypeEInfo;
				ExtendibleElementConstraint kConstraint;
				// first pass: EClasses
				Map<EObject, EObject> kModelObjs1 = new HashMap<EObject, EObject>();
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					kConstraint = kModelElemTypeRef.getObject().getConstraint();
					if (
						kModelElemTypeEInfo.getFeatureName() != null ||
						kConstraint == null ||
						kConstraint.getImplementation().equals("")
					) {
						continue;
					}
					EClass kModelElemTypeClass = (EClass) kModelTypePackage.getEClassifier(kModelElemTypeEInfo.getClassName());
					TreeIterator<EObject> modelObjIter = kRootModelObj.eAllContents();
					while (modelObjIter.hasNext()) {
						EObject modelObj = modelObjIter.next();
						for (EClass kModelElemTypeClassSuper : kModelElemTypeClass.getESuperTypes()) {
							if (!kModelElemTypeClassSuper.getName().equals(modelObj.eClass().getName())) {
								continue;
							}
							if (MultiModelConstraintChecker.checkOCLConstraint(modelObj, kConstraint.getImplementation()) != MAVOTruthValue.TRUE) {
								continue;
							}
							EObject kModelObj = kModelTypeFactory.create(kModelElemTypeClass);
							kModelObjs1.put(kModelObj, modelObj);
						}
					}
				}
				for (Map.Entry<EObject, EObject> kModelObjEntry : kModelObjs1.entrySet()) {
					EObject modelObj = kModelObjEntry.getValue(), kModelObj = kModelObjEntry.getKey();
					for (EStructuralFeature feature : modelObj.eClass().getEAllStructuralFeatures()) {
						EStructuralFeature kFeature = kModelObj.eClass().getEStructuralFeature(feature.getName());
						kModelObj.eSet(kFeature, modelObj.eGet(feature));
					}
					EcoreUtil.replace(modelObj, kModelObj);
				}
				// second pass: EAttributes
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					Map<EObject, EObject> kModelObjs2 = new HashMap<EObject, EObject>();
					kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					kConstraint = kModelElemTypeRef.getObject().getConstraint();
					if (
						!kModelElemTypeEInfo.isAttribute() ||
						kConstraint == null ||
						kConstraint.getImplementation().equals("")
					) {
						continue;
					}
					TreeIterator<EObject> modelObjIter = kRootModelObj.eAllContents();
					while (modelObjIter.hasNext()) {
						EObject modelObj = modelObjIter.next();
						if (!modelObj.eClass().getName().equals(kModelElemTypeEInfo.getClassName()) && kModelObjs1.get(modelObj) == null) {
							continue;
						}
						if (kModelObjs1.get(modelObj) == null) {
							// need to make a copy from extended factory for the ocl derivation to work
							EObject kModelObj = kModelTypeFactory.create((EClass) kModelTypePackage.getEClassifier(kModelElemTypeEInfo.getClassName()));
							kModelObjs2.put(kModelObj, modelObj);
						}
						else {
							// modelObj was already a kModelObj
							kModelObjs2.put(modelObj, null);
						}
					}
					for (Map.Entry<EObject, EObject> kModelObjEntry : kModelObjs2.entrySet()) {
						EObject modelObj = kModelObjEntry.getValue(), kModelObj = kModelObjEntry.getKey();
						if (modelObj != null) {
							for (EStructuralFeature feature : modelObj.eClass().getEAllStructuralFeatures()) {
								EStructuralFeature kFeature = kModelObj.eClass().getEStructuralFeature(feature.getName());
								kModelObj.eSet(kFeature, modelObj.eGet(feature));
							}
							EcoreUtil.replace(modelObj, kModelObj);
						}
						Object kModelObjAttr = MultiModelConstraintChecker.deriveOCLConstraint(kModelObj, kConstraint.getImplementation());
						EStructuralFeature kFeature = kModelObj.eClass().getEStructuralFeature(kModelElemTypeEInfo.getFeatureName());
						kModelObj.eSet(kFeature, kModelObjAttr);
					}
				}
				// save the derived model
				MultiModelUtils.createModelFile(kRootModelObj, kModelUri, true);
			}
			catch (Exception e) {
				MMINTException.print(Type.WARNING, "Error creating extended model file, fallback to no extension", e);
			}
		}
	}

} //KleisliModelRelImpl
