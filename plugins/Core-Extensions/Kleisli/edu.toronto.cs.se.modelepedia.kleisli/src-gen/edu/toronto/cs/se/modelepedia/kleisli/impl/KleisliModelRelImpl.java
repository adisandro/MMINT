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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.reasoning.KleisliReasoningEngine;
import edu.toronto.cs.se.modelepedia.ocl.reasoning.OCLReasoningEngine;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelRelImpl#getExtendedUri <em>Extended Uri</em>}</li>
 * </ul>
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case KleisliPackage.KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN:
				try {
					return createSubtype((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (Boolean)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case KleisliPackage.KLEISLI_MODEL_REL___CREATE_INSTANCE__STRING_MID:
				try {
					return createInstance((String)arguments.get(0), (MID)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
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
	protected void addSubtype(ModelRel newModelRelType, String newModelRelTypeName, String constraintLanguage, String constraintImplementation) throws MMINTException {

		super.addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);
		String newModelRelTypeExtendedUri = getModelRelTypeExtendedUri((KleisliModelRel) newModelRelType);
		((KleisliModelRel) newModelRelType).setExtendedUri(newModelRelTypeExtendedUri);
		if (!MultiModelUtils.isFileOrDirectoryInState(newModelRelTypeExtendedUri)) {
			try {
				MultiModelUtils.createDirectoryInState(newModelRelTypeExtendedUri);
			}
			catch (Exception e) {
				newModelRelType.deleteType();
				throw new MMINTException("Error creating directory for extended metamodels", e);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Model createSubtype(String newModelRelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MMINTException.mustBeType(this);

		KleisliModelRel newModelRelType = KleisliFactory.eINSTANCE.createKleisliModelRel();
		this.addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public BinaryModelRel createBinarySubtype(String newModelRelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MMINTException.mustBeType(this);

		KleisliBinaryModelRel newModelRelType = KleisliFactory.eINSTANCE.createKleisliBinaryModelRel();
		this.addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException {

		ModelRel newModelRelType = super.copySubtype(origModelRelType);
		MID typeMID = MultiModelRegistry.getMultiModel(newModelRelType);
		ExtendibleElementConstraint newConstraint, origConstraint;
		ModelElement newModelElemType;
		for (ModelEndpointReference origModelTypeEndpointRef : origModelRelType.getModelEndpointRefs()) {
			if (!(origModelTypeEndpointRef instanceof KleisliModelEndpointReference)) {
				continue;
			}
			for (ModelElementReference origModelElemTypeRef : origModelTypeEndpointRef.getModelElemRefs()) {
				if (!origModelElemTypeRef.isModifiable()) {
					continue;
				}
				origConstraint = origModelElemTypeRef.getObject().getConstraint();
				if (origConstraint != null) {
					newConstraint = MIDFactory.eINSTANCE.createExtendibleElementConstraint();
					newConstraint.setLanguage(origConstraint.getLanguage());
					newConstraint.setImplementation(origConstraint.getImplementation());
					newModelElemType = MultiModelRegistry.getExtendibleElement(origModelElemTypeRef.getUri(), typeMID);
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

		MMINTException.mustBeType(this);

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
	 * @generated NOT
	 */
	@Override
	protected void addInstance(Model newModel, String newModelUri, ModelOrigin origin, MID instanceMID) throws MMINTException {

		super.addInstance(newModel, newModelUri, ModelOrigin.CREATED, instanceMID);
		String baseModelRelExtendedUri = MultiModelUtils.replaceLastSegmentInUri(MultiModelRegistry.getModelAndModelElementUris(newModel, MIDLevel.INSTANCES)[0], getName());
		String modelRelExtendedUri = MultiModelUtils.getUniqueUri(baseModelRelExtendedUri, true, true);
		((KleisliModelRel) newModel).setExtendedUri(modelRelExtendedUri);
		try {
			MultiModelUtils.createDirectory(modelRelExtendedUri, true);
		}
		catch (Exception e) {
			newModel.deleteInstance();
			throw new MMINTException("Error creating directory for extended models", e);
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Model createInstance(String newModelRelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		KleisliModelRel newModelRel = KleisliFactory.eINSTANCE.createKleisliModelRel();
		this.addInstance(newModelRel, newModelRelUri, ModelOrigin.CREATED, instanceMID);

		return newModelRel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public BinaryModelRel createBinaryInstance(String newModelRelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		KleisliBinaryModelRel newModelRel = KleisliFactory.eINSTANCE.createKleisliBinaryModelRel();
		this.addInstance(newModelRel, newModelRelUri, ModelOrigin.CREATED, instanceMID);

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

		MMINTException.mustBeInstance(this);

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
	public void openType() throws Exception {

		super.openType();

		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		Model ecoreModelType = MultiModelTypeRegistry.getType(EcorePackage.eNS_URI);
		Editor ecoreEditorType = ecoreModelType.getEditors().get(0);
		for (ModelEndpoint modelTypeEndpoint : getModelEndpoints()) {
			if (!(modelTypeEndpoint instanceof KleisliModelEndpoint)) {
				continue;
			}
			String kModelTypeUriRelative = ((KleisliModelEndpoint) modelTypeEndpoint).getExtendedTargetUri();
			String kModelTypeUri = (MultiModelUtils.isFileOrDirectoryInState(kModelTypeUriRelative)) ?
				MultiModelUtils.prependStateToUri(kModelTypeUriRelative):
				null;
			if (kModelTypeUri != null) { // the root KleisliModelRel has no extended metamodel to open
				String kModelTypeDiagramUri = (MultiModelUtils.isFileOrDirectoryInState(kModelTypeUriRelative + GMFDiagramUtils.DIAGRAM_SUFFIX)) ?
					MultiModelUtils.prependStateToUri(kModelTypeUriRelative + GMFDiagramUtils.DIAGRAM_SUFFIX):
					null;
				URI kUri = (kModelTypeDiagramUri == null) ? URI.createFileURI(kModelTypeUri) : URI.createFileURI(kModelTypeDiagramUri);
				//TODO MMINT[ECORE] Try to open ecore diagram
				String editorId = (kModelTypeDiagramUri == null) ? ecoreEditorType.getId() : ecoreEditorType.getId();
				try {
					activePage.openEditor(new URIEditorInput(kUri), editorId);
				}
				catch (PartInitException e) {
					MMINTException.print(IStatus.ERROR, "Error opening extended metamodel file", e);
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void openInstance() throws Exception {

		super.openInstance();

		// extend models (doing it at every open is robust against model change)
		OCLReasoningEngine oclReasoner = new OCLReasoningEngine();
		KleisliReasoningEngine kReasoner = new KleisliReasoningEngine();
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
				KleisliModelEndpointReference kModelTypeEndpointRef = (KleisliModelEndpointReference) MultiModelTypeHierarchy.getReference(kModelTypeEndpoint.getUri(), ((ModelRel) kModelTypeEndpoint.eContainer()).getModelEndpointRefs());
				String modelUri = kModelEndpoint.getTargetUri();
				String kModelUri = kModelEndpoint.getExtendedTargetUri();
				String extendedMetamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(kModelTypeEndpoint.getTarget());
				if (extendedMetamodelUri != null) { // xmi model file
					String kModelUriTemp = kModelUri + "temp";
					String deleteText =
						"xsi:schemaLocation=\"" +
						kModelTypeEndpoint.getTargetUri() +
						" file:" +
						extendedMetamodelUri +
						"\"";
					MultiModelUtils.copyTextFileAndReplaceText(
						modelUri,
						kModelUriTemp,
						deleteText,
						"",
						true
					);
					modelUri = kModelUriTemp;
				}
				String newText =
					kModelTypeEndpoint.getTargetUri() +
					KleisliReasoningEngine.KLEISLI_MODELTYPE_URI_SUFFIX +
					"\" xsi:schemaLocation=\"" +
					kModelTypeEndpoint.getTargetUri() +
					KleisliReasoningEngine.KLEISLI_MODELTYPE_URI_SUFFIX +
					" file:" +
					MultiModelUtils.prependStateToUri(kModelTypeEndpoint.getExtendedTargetUri()) +
					"\"";
				MultiModelUtils.copyTextFileAndReplaceText(
					modelUri,
					kModelUri,
					kModelTypeEndpoint.getTargetUri() + "\"",
					newText,
					true
				);
				EObject kRootModelObj = kModelEndpoint.getExtendedTarget().getEMFInstanceRoot();
				Map<String, Map<String, Map<EObject, EObject>>> queryMap = new HashMap<String, Map<String, Map<EObject, EObject>>>();
				// first pass: EClasses
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					EMFInfo kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					ExtendibleElementConstraint kConstraint = kModelElemTypeRef.getObject().getConstraint();
					if (
						kModelElemTypeEInfo.getFeatureName() != null ||
						kConstraint == null ||
						kConstraint.getImplementation().equals("")
					) {
						continue;
					}
					Map<String, Map<EObject, EObject>> queryUnion = new LinkedHashMap<String, Map<EObject, EObject>>();
					queryMap.put(kModelElemTypeEInfo.getClassName(), queryUnion);
					EClass kModelElemTypeClass = (EClass) kModelTypePackage.getEClassifier(kModelElemTypeEInfo.getClassName());
					kReasoner.evaluateEClassQuery(kConstraint.getImplementation(), oclReasoner, kRootModelObj, kModelElemTypeClass, kModelTypeFactory, queryUnion);
				}
				// second pass: EReferences
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					EMFInfo kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					ExtendibleElementConstraint kConstraint = kModelElemTypeRef.getObject().getConstraint();
					if (
						kModelElemTypeEInfo.getFeatureName() == null ||
						kModelElemTypeEInfo.isAttribute() ||
						kConstraint == null ||
						kConstraint.getImplementation().equals("")

					) {
						continue;
					}
					Map<String, Map<EObject, EObject>> queryUnion = queryMap.get(kModelElemTypeEInfo.getRelatedClassName());
					if (queryUnion == null) {
						continue;
					}
					kReasoner.evaluateEReferenceQuery(kConstraint.getImplementation(), oclReasoner, kModelElemTypeEInfo, queryUnion, queryMap);
				}
				// third pass: EAttributes
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					EMFInfo kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					ExtendibleElementConstraint kConstraint = kModelElemTypeRef.getObject().getConstraint();
					if (
						!kModelElemTypeEInfo.isAttribute() ||
						kConstraint == null ||
						kConstraint.getImplementation().equals("")
					) {
						continue;
					}
					kReasoner.evaluateEAttributeQuery(kConstraint.getImplementation(), oclReasoner, kRootModelObj, kModelElemTypeEInfo);
				}
				// save the derived model
				MultiModelUtils.createModelFile(kRootModelObj, kModelUri, true);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Error creating extended model file, fallback to no extension", e);
			}
		}
	}

} //KleisliModelRelImpl
