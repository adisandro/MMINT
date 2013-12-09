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

import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;
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
 * </p>
 *
 * @generated
 */
public class KleisliModelRelImpl extends ModelRelImpl implements KleisliModelRel {
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
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel newModelRelType = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		addSubtype(newModelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);
		try {
			MultiModelUtils.createDirectoryInState(newModelRelTypeName);
		}
		catch (Exception e) {
			newModelRelType.deleteType();
			throw new MMTFException("Error creating directory for extended metamodels", e);
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
		MultiModelUtils.deleteDirectoryInState(getName());
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

		ModelRel newModelRel = (isBinary) ?
			KleisliFactory.eINSTANCE.createKleisliBinaryModelRel() :
			KleisliFactory.eINSTANCE.createKleisliModelRel();
		MultiModelInstanceFactory.addModel(newModelRel, this, newModelRelUri, origin, containerMultiModel);

		return newModelRel;
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMTFException {

		String kleisliDirectoryUri = MultiModelUtils.replaceLastSegmentInUri(MultiModelRegistry.getModelAndModelElementUris(this, true)[0], getName());
		super.deleteInstance();
		MultiModelUtils.deleteDirectory(MultiModelUtils.prependWorkspaceToUri(kleisliDirectoryUri));
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
			String newModelTypeUriFragment = KleisliUtils.getExtendedModelTypeUriFragment(modelTypeEndpoint.getTarget(), (KleisliModelRel) this);
			URI uri = URI.createFileURI(MultiModelUtils.isFileInState(newModelTypeUriFragment));
			try {
				activePage.openEditor(new URIEditorInput(uri), ModelOpenEditorCommand.ECORE_EDITORID);
			}
			catch (PartInitException e) {
				MMTFException.print(Type.WARNING, "Error opening extended metamodel file", e);
			}
		}

		//TODO MMTF[KLEISLI] init outline with augmented ones
	}

	/**
	 * Kleisli version. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void openInstance() throws MMTFException {

		super.openInstance();

		// create directory if it doesn't exist
		try {
			//TODO
			String kleisliDirectoryUri = MultiModelUtils.replaceLastSegmentInUri(MultiModelRegistry.getModelAndModelElementUris(this, true)[0], getName());
			MultiModelUtils.createDirectory(MultiModelUtils.prependWorkspaceToUri(kleisliDirectoryUri));
		}
		catch (FileAlreadyExistsException fe) {
			// continue
		}
		catch (Exception e) {
			throw new MMTFException("Error creating directory for extended models", e);
		}

		// extend models
		for (ModelEndpoint modelEndpoint : getModelEndpoints()) {
			ModelEndpoint modelTypeEndpoint = modelEndpoint.getMetatype();
			if (!(modelTypeEndpoint instanceof KleisliModelEndpoint)) {
				continue;
			}
			try {
				String extendedMetamodelUriFragment = KleisliUtils.getExtendedModelTypeUriFragment(modelTypeEndpoint.getTarget(), (KleisliModelRel) getMetatype());
				EPackage modelTypePackage = (EPackage) MultiModelUtils.getModelFileInState(extendedMetamodelUriFragment);
				EFactory modelTypeFactory = modelTypePackage.getEFactoryInstance();
				ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpoint.getUri(), ((ModelRel) modelTypeEndpoint.eContainer()).getModelEndpointRefs());
				String newModelUri = KleisliUtils.getExtendedModelUri((KleisliModelEndpoint) modelEndpoint);
				MultiModelUtils.copyTextFileAndReplaceText(
					MultiModelUtils.prependWorkspaceToUri(modelEndpoint.getTargetUri()),
					MultiModelUtils.prependWorkspaceToUri(newModelUri),
					MultiModelUtils.getLastSegmentFromUri(extendedMetamodelUriFragment),
					extendedMetamodelUriFragment
				);
				EObject rootModelObj = MultiModelUtils.getModelFile(newModelUri, true);
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
					EClass h = (EClass) modelTypePackage.getEClassifier(classLiteral);
					TreeIterator<EObject> modelObjIter = rootModelObj.eAllContents();
					while (modelObjIter.hasNext()) {
						EObject modelObj = modelObjIter.next();
						for (EClass hh : h.getESuperTypes()) {
							if (!hh.getName().equals(modelObj.eClass().getName())) {
								continue;
							}
							if (MultiModelConstraintChecker.checkOCLConstraint(modelObj, constraint.getImplementation()) != MAVOTruthValue.TRUE) {
								continue;
							}
							EObject modelObjReplacement = modelTypeFactory.create(h);
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
					//TODO MMTF[KLEISLI] check how it works with containments
				}
				// second pass: EAttributes
				String[] classLiterals;
				for (ModelElementReference modelElemTypeRef : modelTypeEndpointRef.getModelElemRefs()) {
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
						Object modelObjAttrDerived = MultiModelConstraintChecker.deriveOCLConstraint(modelObj, constraint.getImplementation());
						modelObj.eSet((EStructuralFeature) MultiModelTypeIntrospection.getPointer(modelElemTypeRef.getObject()), modelObjAttrDerived);
					}
				}
				// save the derived model
				MultiModelUtils.createModelFile(rootModelObj, newModelUri, true);
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "Error creating extended model file, fallback to no extension", e);
			}
		}

		//TODO MMTF[KLEISLI] eattributes pass should look also for previous replacements
		//TODO MMTF[KLEISLI] derive ocl fails
		//TODO MMTF[KLEISLI] init outline starts before this
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
					resources.add(MultiModelUtils.getModelFileInState(KleisliUtils.getExtendedModelTypeUriFragment(modelType, this)).eResource());
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Error getting extended metamodel file", e);
					continue;
				}
			}
			else {
				do {
					resources.add(MultiModelTypeIntrospection.getRoot(modelType).eResource());
					modelType = modelType.getSupertype(); // types only
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
					resources.add(MultiModelUtils.getModelFile(KleisliUtils.getExtendedModelUri((KleisliModelEndpoint) modelEndpointRef.getObject()), true).eResource());
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
