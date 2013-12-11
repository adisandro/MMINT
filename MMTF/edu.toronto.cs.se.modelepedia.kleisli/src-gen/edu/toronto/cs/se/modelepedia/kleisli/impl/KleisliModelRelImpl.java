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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelOpenEditorCommand;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliExtendibleElement;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.library.KleisliUtils;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == KleisliExtendibleElement.class) {
			switch (derivedFeatureID) {
				case KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI: return KleisliPackage.KLEISLI_EXTENDIBLE_ELEMENT__EXTENDED_URI;
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
				case KleisliPackage.KLEISLI_EXTENDIBLE_ELEMENT__EXTENDED_URI: return KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI;
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
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		KleisliModelRel newModelRelType = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);
		String newModelRelTypeExtendedUri = KleisliUtils.getModelRelTypeExtendedUri(newModelRelType);
		newModelRelType.setExtendedUri(newModelRelTypeExtendedUri);
		if (MultiModelUtils.isFileOrDirectoryInState(newModelRelTypeExtendedUri) == null) {
			try {
				MultiModelUtils.createDirectoryInState(newModelRelTypeExtendedUri);
			}
			catch (Exception e) {
				newModelRelType.deleteType();
				throw new MMTFException("Error creating directory for extended metamodels", e);
			}
		}

		return newModelRelType;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void deleteType() throws MMTFException {

		super.deleteType();
		MultiModelUtils.deleteDirectoryInState(getExtendedUri());
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ModelRel createInstance(String newModelRelUri, boolean isBinary, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		KleisliModelRel newModelRel = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		MultiModelInstanceFactory.addModel(newModelRel, this, newModelRelUri, origin, containerMultiModel);
		String modelRelExtendedUri = KleisliUtils.getModelRelExtendedUri(newModelRel);
		newModelRel.setExtendedUri(modelRelExtendedUri);
		try {
			MultiModelUtils.createDirectory(modelRelExtendedUri, true);
		}
		catch (Exception e) {
			newModelRel.deleteInstance();
			throw new MMTFException("Error creating directory for extended models", e);
		}

		return newModelRel;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMTFException {

		super.deleteInstance();
		MultiModelUtils.deleteDirectory(getExtendedUri(), true);
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void openType() throws MMTFException {

		super.openType();

		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		for (ModelEndpoint modelTypeEndpoint : getModelEndpoints()) {
			URI uri = URI.createFileURI(MultiModelUtils.isFileOrDirectoryInState(((KleisliModelEndpoint) modelTypeEndpoint).getExtendedUri()));
			try {
				activePage.openEditor(new URIEditorInput(uri), ModelOpenEditorCommand.ECORE_EDITORID);
			}
			catch (PartInitException e) {
				MMTFException.print(Type.WARNING, "Error opening extended metamodel file", e);
			}
		}
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void openInstance() throws MMTFException {

		super.openInstance();

		// extend models (doing it at every open is robust against model change)
		for (ModelEndpoint modelEndpoint : getModelEndpoints()) {
			ModelEndpoint modelTypeEndpoint = modelEndpoint.getMetatype();
			if (!(modelTypeEndpoint instanceof KleisliModelEndpoint)) {
				continue;
			}
			try {
				String modelTypeEndpointExtendedUri = ((KleisliModelEndpoint) modelTypeEndpoint).getExtendedUri();
				EPackage modelTypeExtendedPackage = (EPackage) MultiModelUtils.getModelFileInState(modelTypeEndpointExtendedUri);
				EFactory modelTypeExtendedFactory = modelTypeExtendedPackage.getEFactoryInstance();
				ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpoint.getUri(), ((ModelRel) modelTypeEndpoint.eContainer()).getModelEndpointRefs());
				String modelEndpointExtendedUri = ((KleisliModelEndpoint) modelEndpoint).getExtendedUri();
				MultiModelUtils.copyTextFileAndReplaceText(
					MultiModelUtils.prependWorkspaceToUri(modelEndpoint.getTargetUri()),
					MultiModelUtils.prependWorkspaceToUri(modelEndpointExtendedUri),
					MultiModelUtils.getLastSegmentFromUri(modelTypeEndpointExtendedUri),
					modelTypeEndpointExtendedUri
				);
				EObject rootModelObj = MultiModelUtils.getModelFile(modelEndpointExtendedUri, true);
				String classLiteral;
				ExtendibleElementConstraint constraint;
				// first pass: EClasses
				Map<EObject, EObject> modelObjReplacements = new HashMap<EObject, EObject>();
				for (ModelElementReference modelElemTypeRef : modelTypeEndpointRef.getModelElemRefs()) {
					classLiteral = modelElemTypeRef.getObject().getClassLiteral();
					constraint = modelElemTypeRef.getObject().getConstraint();
					if (
						classLiteral.contains(MMTF.URI_SEPARATOR) ||
						constraint == null ||
						constraint.getImplementation().equals("")
					) {
						continue;
					}
					EClass modelElemTypeClass = (EClass) modelTypeExtendedPackage.getEClassifier(classLiteral);
					TreeIterator<EObject> modelObjIter = rootModelObj.eAllContents();
					while (modelObjIter.hasNext()) {
						EObject modelObj = modelObjIter.next();
						for (EClass modelElemTypeClassSuper : modelElemTypeClass.getESuperTypes()) {
							if (!modelElemTypeClassSuper.getName().equals(modelObj.eClass().getName())) {
								continue;
							}
							if (MultiModelConstraintChecker.checkOCLConstraint(modelObj, constraint.getImplementation()) != MAVOTruthValue.TRUE) {
								continue;
							}
							EObject modelObjReplacement = modelTypeExtendedFactory.create(modelElemTypeClass);
							modelObjReplacements.put(modelObjReplacement, modelObj);
						}
					}
				}
				for (Map.Entry<EObject, EObject> modelObjReplacementEntry : modelObjReplacements.entrySet()) {
					EObject modelObjReplaced = modelObjReplacementEntry.getValue(), modelObjReplacement = modelObjReplacementEntry.getKey();
					for (EStructuralFeature replacedFeature : modelObjReplaced.eClass().getEAllStructuralFeatures()) {
						EStructuralFeature replacementFeature = modelObjReplacement.eClass().getEStructuralFeature(replacedFeature.getName());
						modelObjReplacement.eSet(replacementFeature, modelObjReplaced.eGet(replacedFeature));
					}
					EcoreUtil.replace(modelObjReplaced, modelObjReplacement);
				}
				// second pass: EAttributes
				String[] classLiterals;
				for (ModelElementReference modelElemTypeRef : modelTypeEndpointRef.getModelElemRefs()) {
					Map<EObject, EObject> modelObjCopies = new HashMap<EObject, EObject>();
					classLiteral = modelElemTypeRef.getObject().getClassLiteral();
					constraint = modelElemTypeRef.getObject().getConstraint();
					if (
						!classLiteral.contains(MMTF.URI_SEPARATOR) ||
						constraint == null ||
						constraint.getImplementation().equals("")
					) {
						continue;
					}
					classLiterals = classLiteral.split(MMTF.URI_SEPARATOR);
					TreeIterator<EObject> modelObjIter = rootModelObj.eAllContents();
					while (modelObjIter.hasNext()) {
						EObject modelObj = modelObjIter.next();
						if (!modelObj.eClass().getName().equals(classLiterals[0]) && modelObjReplacements.get(modelObj) == null) {
							continue;
						}
						if (modelObjReplacements.get(modelObj) == null) {
							// need to make a copy from extended factory for the ocl derivation to work
							EObject modelObjCopy = modelTypeExtendedFactory.create((EClass) modelTypeExtendedPackage.getEClassifier(classLiterals[0]));
							modelObjCopies.put(modelObjCopy, modelObj);
						}
						else {
							modelObjCopies.put(modelObj, null);
						}
					}
					for (Map.Entry<EObject, EObject> modelObjCopyEntry : modelObjCopies.entrySet()) {
						EObject modelObjCopied = modelObjCopyEntry.getValue(), modelObjCopy = modelObjCopyEntry.getKey();
						if (modelObjCopied != null) {
							for (EStructuralFeature copiedFeature : modelObjCopied.eClass().getEAllStructuralFeatures()) {
								EStructuralFeature copyFeature = modelObjCopy.eClass().getEStructuralFeature(copiedFeature.getName());
								modelObjCopy.eSet(copyFeature, modelObjCopied.eGet(copiedFeature));
							}
							EcoreUtil.replace(modelObjCopied, modelObjCopy);
						}
						Object derivedModelObjAttr = MultiModelConstraintChecker.deriveOCLConstraint(modelObjCopy, constraint.getImplementation());
						EStructuralFeature derivedFeature = modelObjCopy.eClass().getEStructuralFeature(classLiterals[1]);
						modelObjCopy.eSet(derivedFeature, derivedModelObjAttr);
					}
				}
				// save the derived model
				MultiModelUtils.createModelFile(rootModelObj, modelEndpointExtendedUri, true);
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "Error creating extended model file, fallback to no extension", e);
			}
		}

		//TODO MMTF[KLEISLI] drop doesn't work, it should use extendedUri
		//TODO MMTF[KLEISLI] persistence still misses model elements (KleisliModelElement?)
		//TODO MMTF[KLEISLI] KleisliModelElement and KleisliModel could be used to extend getRoot and getPointer, in order to use them here
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ResourceSet getOutlineResourceTypes() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		List<Resource> resources = resourceSet.getResources();
		for (ModelEndpointReference modelTypeEndpointRef : getModelEndpointRefs()) {
			Model modelType = modelTypeEndpointRef.getObject().getTarget();
			if (modelTypeEndpointRef.getObject() instanceof KleisliModelEndpoint) {
				try {
					resources.add(MultiModelUtils.getModelFileInState(((KleisliModelEndpoint) modelTypeEndpointRef.getObject()).getExtendedUri()).eResource());
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Error getting extended metamodel file", e);
					continue;
				}
			}
			else {
				do {
					resources.add(MultiModelTypeIntrospection.getRoot(modelType).eResource());
					modelType = modelType.getSupertype();
				}
				while (modelType != null && !modelType.isAbstract());
			}
		}

		return resourceSet;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ResourceSet getOutlineResourceInstances() throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		List<Resource> resources = resourceSet.getResources();
		for (ModelEndpointReference modelEndpointRef : getModelEndpointRefs()) {
			Model model = modelEndpointRef.getObject().getTarget();
			if (modelEndpointRef.getObject() instanceof KleisliModelEndpoint) {
				try {
					resources.add(MultiModelUtils.getModelFile(((KleisliModelEndpoint) modelEndpointRef.getObject()).getExtendedUri(), true).eResource());
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Error getting extended model file", e);
					continue;
				}
			}
			else {
				resources.add(MultiModelTypeIntrospection.getRoot(model).eResource());
			}
		}

		return resourceSet;
	}

} //KleisliModelRelImpl
