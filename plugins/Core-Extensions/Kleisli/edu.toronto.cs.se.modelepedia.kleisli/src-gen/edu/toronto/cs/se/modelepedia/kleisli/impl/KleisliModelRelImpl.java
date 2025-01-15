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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ui.IEditorPart;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.ocl.reasoning.OCLReasoner;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;
import edu.toronto.cs.se.modelepedia.kleisli.reasoning.KleisliReasoner;

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
	protected String extendedUri = KleisliModelRelImpl.EXTENDED_URI_EDEFAULT;

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
	@Override
    public String getExtendedUri() {
    return this.extendedUri;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
    public void setExtendedUri(String newExtendedUri) {
    var oldExtendedUri = this.extendedUri;
    this.extendedUri = newExtendedUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KleisliPackage.KLEISLI_MODEL_REL__EXTENDED_URI, oldExtendedUri, this.extendedUri));
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
        setExtendedUri(KleisliModelRelImpl.EXTENDED_URI_EDEFAULT);
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
        return KleisliModelRelImpl.EXTENDED_URI_EDEFAULT == null ? this.extendedUri != null : !KleisliModelRelImpl.EXTENDED_URI_EDEFAULT.equals(this.extendedUri);
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

    var result = new StringBuilder(super.toString());
    result.append(" (extendedUri: ");
    result.append(this.extendedUri);
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
	 * Kleisli version. {@inheritDoc}
	 *
	 * @generated NOT
	 */
	@Override
	protected void addSubtype(Model newModelRelType, String newModelRelTypeName, boolean isMetamodelExtension) throws MMINTException {

		super.addSubtype(newModelRelType, newModelRelTypeName, false);
		var newModelRelTypeExtendedUri = getModelRelTypeExtendedUri((KleisliModelRel) newModelRelType);
		((KleisliModelRel) newModelRelType).setExtendedUri(newModelRelTypeExtendedUri);
		if (!FileUtils.isFileOrDirectoryInState(newModelRelTypeExtendedUri)) {
			try {
				FileUtils.createDirectoryInState(newModelRelTypeExtendedUri);
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
	public ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException {

		var newModelRelType = super.copySubtype(origModelRelType);
		var typeMID = newModelRelType.getMIDContainer();
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
					newModelElemType = typeMID.getExtendibleElement(origModelElemTypeRef.getUri());
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
		FileUtils.deleteDirectoryInState(getExtendedUri());
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
			var modelTypeEndpoint = modelTypeEndpointRef.getObject();
			var modelType = (modelTypeEndpoint instanceof KleisliModelEndpoint) ?
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
	 * Kleisli version. {@inheritDoc}
	 *
	 * @generated NOT
	 */
	@Override
	protected void addInstance(@NonNull Model newModelRel, @Nullable String newModelRelId, @NonNull String newModelRelName, @NonNull ModelOrigin origin, @NonNull String fileExtension, @NonNull MIDLevel midLevel, @Nullable MID instanceMID) throws MMINTException {

		super.addInstance(newModelRel, newModelRelId, newModelRelName, origin, fileExtension, midLevel, instanceMID);
		String baseModelRelExtendedUri = FileUtils.replaceLastSegmentInPath(MIDRegistry.getModelUri(newModelRel), getName());
		String modelRelExtendedUri = FileUtils.getUniquePath(baseModelRelExtendedUri, true, true);
		((KleisliModelRel) newModelRel).setExtendedUri(modelRelExtendedUri);
		try {
			FileUtils.createDirectory(modelRelExtendedUri, true);
		}
		catch (Exception e) {
			newModelRel.deleteInstance();
			throw new MMINTException("Error creating directory for extended models", e);
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMINTException {

		super.deleteInstance();
		FileUtils.deleteDirectory(getExtendedUri(), true);
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
			var modelEndpoint = modelEndpointRef.getObject();
			var model = (modelEndpoint instanceof KleisliModelEndpoint) ?
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

		Model ecoreModelType = MIDTypeRegistry.getType(EcorePackage.eNS_URI);
		var ecoreEditorType = ecoreModelType.getEditors().get(0);
		for (ModelEndpoint modelTypeEndpoint : getModelEndpoints()) {
			if (!(modelTypeEndpoint instanceof KleisliModelEndpoint)) {
				continue;
			}
			var kModelTypeUriRelative = ((KleisliModelEndpoint) modelTypeEndpoint).getExtendedTargetUri();
			var kModelTypeUri = (FileUtils.isFileOrDirectoryInState(kModelTypeUriRelative)) ?
				kModelTypeUriRelative:
				null;
			if (kModelTypeUri != null) { // the root KleisliModelRel has no extended metamodel to open
				var kModelTypeDiagramUri = (FileUtils.isFileOrDirectoryInState(kModelTypeUriRelative + GMFUtils.DIAGRAM_SUFFIX)) ?
					kModelTypeUriRelative + GMFUtils.DIAGRAM_SUFFIX:
					null;
				var kUri = (kModelTypeDiagramUri == null) ? kModelTypeUri : kModelTypeDiagramUri;
				//TODO MMINT[ECORE] Try to open ecore diagram
				var editorId = (kModelTypeDiagramUri == null) ? ecoreEditorType.getId() : ecoreEditorType.getId();
				try {
					FileUtils.openEclipseEditorInState(kUri, editorId);
				}
				catch (MMINTException e) {
					MMINTException.print(IStatus.ERROR, "Error opening extended metamodel file", e);
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public IEditorPart openInstance() throws Exception {
		var editorPart = super.openInstance();

		// extend models (doing it at every open is robust against model change)
		var oclReasoner = new OCLReasoner();
		var kReasoner = new KleisliReasoner();
		for (ModelEndpoint modelEndpoint : getModelEndpoints()) {
			var modelTypeEndpoint = modelEndpoint.getMetatype();
			if (!(modelTypeEndpoint instanceof KleisliModelEndpoint kModelTypeEndpoint)) {
				continue;
			}
			var kModelEndpoint = (KleisliModelEndpoint) modelEndpoint;
			try {
				var kModelTypePackage = kModelTypeEndpoint.getExtendedTarget().getEMFTypeRoot();
				var kModelTypeFactory = kModelTypePackage.getEFactoryInstance();
				var kModelTypeEndpointRef = (KleisliModelEndpointReference) MIDRegistry.getReference(kModelTypeEndpoint.getUri(), ((ModelRel) kModelTypeEndpoint.eContainer()).getModelEndpointRefs());
				var modelUri = kModelEndpoint.getTargetUri();
				var kModelUri = kModelEndpoint.getExtendedTargetUri();
				var extendedMetamodelUri = MIDTypeRegistry.getExtendedMetamodelPath(kModelTypeEndpoint.getTarget());
				if (extendedMetamodelUri != null) { // xmi model file
					var kModelUriTemp = kModelUri + "temp";
					var deleteText =
						"xsi:schemaLocation=\"" +
						kModelTypeEndpoint.getTargetUri() +
						" file:" +
						extendedMetamodelUri +
						"\"";
					FileUtils.copyTextFileAndReplaceText(
						modelUri,
						kModelUriTemp,
						deleteText,
						"",
						true
					);
					modelUri = kModelUriTemp;
				}
				var newText =
					kModelTypeEndpoint.getTargetUri() +
					KleisliReasoner.KLEISLI_MODELTYPE_URI_SUFFIX +
					"\" xsi:schemaLocation=\"" +
					kModelTypeEndpoint.getTargetUri() +
					KleisliReasoner.KLEISLI_MODELTYPE_URI_SUFFIX +
					" file:" +
					FileUtils.prependStatePath(kModelTypeEndpoint.getExtendedTargetUri()) +
					"\"";
				FileUtils.copyTextFileAndReplaceText(
					modelUri,
					kModelUri,
					kModelTypeEndpoint.getTargetUri() + "\"",
					newText,
					true
				);
				var kRootModelObj = kModelEndpoint.getExtendedTarget().getEMFInstanceRoot();
				Map<String, Map<String, Map<EObject, EObject>>> queryMap = new HashMap<>();
				// first pass: EClasses
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					var kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					var kConstraint = kModelElemTypeRef.getObject().getConstraint();
					if (
						kModelElemTypeEInfo.getFeatureName() != null ||
						kConstraint == null ||
						kConstraint.getImplementation().equals("")
					) {
						continue;
					}
					Map<String, Map<EObject, EObject>> queryUnion = new LinkedHashMap<>();
					queryMap.put(kModelElemTypeEInfo.getClassName(), queryUnion);
					var kModelElemTypeClass = (EClass) kModelTypePackage.getEClassifier(kModelElemTypeEInfo.getClassName());
					kReasoner.evaluateEClassQuery(kConstraint.getImplementation(), oclReasoner, kRootModelObj, kModelElemTypeClass, kModelTypeFactory, queryUnion);
				}
				// second pass: EReferences
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					var kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					var kConstraint = kModelElemTypeRef.getObject().getConstraint();
					if (
						kModelElemTypeEInfo.getFeatureName() == null ||
						kModelElemTypeEInfo.isAttribute() ||
						kConstraint == null ||
						kConstraint.getImplementation().equals("")

					) {
						continue;
					}
					var queryUnion = queryMap.get(kModelElemTypeEInfo.getRelatedClassName());
					if (queryUnion == null) {
						continue;
					}
					kReasoner.evaluateEReferenceQuery(kConstraint.getImplementation(), oclReasoner, kModelElemTypeEInfo, queryUnion, queryMap);
				}
				// third pass: EAttributes
				for (ModelElementReference kModelElemTypeRef : kModelTypeEndpointRef.getModelElemRefs()) {
					var kModelElemTypeEInfo = kModelElemTypeRef.getObject().getEInfo();
					var kConstraint = kModelElemTypeRef.getObject().getConstraint();
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
				FileUtils.writeModelFile(kRootModelObj, kModelUri, null, true);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.INFO, "Error creating extended model file, fallback to no extension", e);
			}
		}

		return editorPart;
	}

} //KleisliModelRelImpl
