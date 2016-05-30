/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.ImportModelDialogFilter;
import edu.toronto.cs.se.mmint.mid.ui.ImportModelDialogSelectionValidator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogLabelProvider;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.mmint.mid.ui.NewGenericTypeDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewMappingReferenceDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewMappingTypeReferenceDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelDialogSelectionValidator;
import edu.toronto.cs.se.mmint.mid.ui.NewModelElementEndpointReferenceDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelEndpointDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelRelDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelRelTypeDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelTypeDialogContentProvider;

/**
 * The registry for querying the types.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDTypeRegistry {

	/**
	 * Gets a type from the repository.
	 * 
	 * @param typeUri
	 *            The uri of the type.
	 * @return The type, null if the uri is not found or found not to be of the
	 *         desired class of types.
	 */
	public static <T extends ExtendibleElement> @Nullable T getType(@NonNull String typeUri) {

		return MIDRegistry.getExtendibleElement(typeUri, MMINT.cachedTypeMID);
	}

	/**
	 * Gets the list of operator types in the repository.
	 * 
	 * @return The list of operator types in the repository.
	 */
	public static List<Operator> getOperatorTypes() {

		return MMINT.cachedTypeMID.getOperators();
	}

	/**
	 * Gets the list of model types in the repository.
	 * 
	 * @return The list of model types in the repository.
	 */
	public static List<Model> getModelTypes() {

		return MMINT.cachedTypeMID.getModels();
	}

	/**
	 * Gets the list of generic types in the repository.
	 * 
	 * @return The list of generic types in the repository.
	 */
	public static List<GenericElement> getGenericTypes() {

		List<GenericElement> genericTypes = new ArrayList<>();
		genericTypes.addAll(getModelTypes());
		genericTypes.addAll(getOperatorTypes());

		return genericTypes;
	}

	/**
	 * Gets the list of editor types in the repository.
	 * 
	 * @return The list of editor types in the repository.
	 */
	public static EList<Editor> getEditorTypes() {

		return MMINT.cachedTypeMID.getEditors();
	}

	/**
	 * Gets the list of model relationship types in the repository.
	 * 
	 * @return The list of model relationship types in the repository.
	 */
	public static EList<ModelRel> getModelRelTypes() {

		return MMINT.cachedTypeMID.getModelRels();
	}

	/**
	 * Gets the list of mapping types in a model relationship type.
	 * 
	 * @param modelRelType
	 *            The model relationship type that contains the mapping types.
	 * @return The list of mapping types in the model relationship type.
	 */
	public static EList<Mapping> getMappingTypes(ModelRel modelRelType) {

		return modelRelType.getMappings();
	}

	/**
	 * Gets the list of references to mapping types in a model relationship type.
	 * 
	 * @param modelRelType
	 *            The model relationship type that contains the references to
	 *            mapping types.
	 * @return The list of references to mapping types in the model relationship
	 *         type.
	 */
	public static EList<MappingReference> getMappingTypeReferences(ModelRel modelRelType) {

		return modelRelType.getMappingRefs();
	}

	/**
	 * Gets the list of model element types in a model type.
	 * 
	 * @param modelType
	 *            The model type that contains the model element types.
	 * 
	 * @return The list of model element types in the model type.
	 */
	public static EList<ModelElement> getModelElementTypes(Model modelType) {

		return modelType.getModelElems();
	}

	/**
	 * Gets the list of file extensions for all model types in the repository.
	 * 
	 * @return The list of file extensions for model types.
	 */
	public static List<String> getModelTypeFileExtensions() {

		List<String> fileExtensions = MMINT.cachedTypeMID.getModels().stream()
			.map(Model::getFileExtension)
			.collect(Collectors.toList());

		return fileExtensions;
	}

	/**
	 * Gets the list of editor types in the repository for a model type.
	 * 
	 * @param modelTypeUri
	 *            The uri of the model type.
	 * @return The list of editor types in the repository for the model type.
	 */
	public static EList<Editor> getModelTypeEditors(String modelTypeUri) {

		Model model = getType(modelTypeUri);
		if (model != null) {
			return model.getEditors();
		}
		else {
			return ECollections.emptyEList();
		}
	}

	/**
	 * Gets a tree dialog that shows all model types in the repository and their
	 * editor types, in order to create a new model.
	 * 
	 * @return The tree dialog to create a new model.
	 */
	public static MIDTreeSelectionDialog getModelCreationDialog() {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewModelDialogContentProvider(MMINT.cachedTypeMID),
			MMINT.cachedTypeMID
		);
		dialog.setValidator(new NewModelDialogSelectionValidator());

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model files in the workspace, in order
	 * to import an existing model.
	 * 
	 * @return The tree dialog to import an existing model.
	 */
	public static MIDTreeSelectionDialog getModelImportDialog() {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new WorkbenchLabelProvider(),
			new BaseWorkbenchContentProvider(),
			ResourcesPlugin.getWorkspace().getRoot()
		);
		dialog.addFilter(new ImportModelDialogFilter());
		dialog.setValidator(new ImportModelDialogSelectionValidator());

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model relationship types in the
	 * repository, in order to create a new model relationship.
	 * 
	 * @param targetSrcModel
	 *            The model that is going to be the target of the source model
	 *            endpoint, null if the model relationship to be created is not
	 *            binary.
	 * @param targetTgtModel
	 *            The model that is going to be the target of the target model
	 *            endpoint, null if the model relationship to be created is not
	 *            binary.
	 * @return The tree dialog to create a new model relationship.
	 */
	public static MIDTreeSelectionDialog getModelRelCreationDialog(Model targetSrcModel, Model targetTgtModel) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewModelRelDialogContentProvider(MIDConstraintChecker.getAllowedModelRelTypes(targetSrcModel, targetTgtModel)),
			MMINT.cachedTypeMID
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model type endpoints in a model
	 * relationship type, in order to create a new model endpoint.
	 * 
	 * @param modelRel
	 *            The model relationship that will contain the model endpoint to
	 *            be created.
	 * @param modelTypeEndpointUris
	 *            The list of allowed uris of the model type endpoints, can be
	 *            null if all are allowed.
	 * @return The tree dialog to create a new model endpoint.
	 */
	public static MIDTreeSelectionDialog getModelEndpointCreationDialog(ModelRel modelRel, List<String> modelTypeEndpointUris) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewModelEndpointDialogContentProvider(modelTypeEndpointUris),
			modelRel.getMetatype()
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model types in the Type MID, in order
	 * to create a new "light" model type.
	 * 
	 * @param typeMID
	 *            The Type MID.
	 * @return The tree dialog to create a new "light" model type.
	 */
	public static MIDTreeSelectionDialog getModelTypeCreationDialog(MID typeMID) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewModelTypeDialogContentProvider(),
			typeMID
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model relationship types in the Type MID, in order to create a new "light"
	 * model relationship type.
	 * 
	 * @param newSrcModelType
	 *            The model type that is going to be the target of the source
	 *            model type endpoint, null if the model relationship type to be
	 *            created is not binary.
	 * @param newTgtModelType
	 *            The model type that is going to be the target of the target
	 *            model type endpoint, null if the model relationship type to be
	 *            created is not binary.
	 * @param typeMID
	 *            The Type MID.
	 * 
	 * @return The tree dialog to create a new "light" model relationship type.
	 */
	public static MIDTreeSelectionDialog getModelRelTypeCreationDialog(Model newSrcModelType, Model newTgtModelType, MID typeMID) {

		List<String> modelRelTypeUris = null;

		if (newSrcModelType != null && newTgtModelType != null) {
			String newSrcUri = newSrcModelType.getUri();
			String newTgtUri = newTgtModelType.getUri();
			modelRelTypeUris = new ArrayList<String>();

			for (ModelRel modelRelType : typeMID.getModelRels()) {
				// binary can only inherit from root or binary
				if (MIDTypeHierarchy.isRootType(modelRelType)) {
					modelRelTypeUris.add(modelRelType.getUri());
					continue;
				}
				if (!(modelRelType instanceof BinaryModelRel)) {
					continue;
				}
				String srcUri = modelRelType.getModelEndpoints().get(0).getTargetUri();
				String tgtUri = modelRelType.getModelEndpoints().get(1).getTargetUri();
				// new model rel type with same endpoints or overriding one or two endpoints
				if (
					(newSrcUri.equals(srcUri) && newTgtUri.equals(tgtUri)) ||
					(MIDTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, typeMID) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && MIDTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, typeMID)) ||
					(MIDTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, typeMID) && MIDTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, typeMID))
				) {
					modelRelTypeUris.add(modelRelType.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewModelRelTypeDialogContentProvider(modelRelTypeUris),
			typeMID
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all mapping types in a model relationship
	 * type, in order to create a new mapping and a reference to it.
	 * 
	 * @param targetSrcModelElemRef
	 *            The reference to the model element that is going to be the
	 *            target of the source model element endpoint, null if the mapping
	 *            to be created is not binary.
	 * @param targetTgtModelElemRef
	 *            The reference to the model element that is going to be the
	 *            target of the target model element endpoint, null if the mapping
	 *            to be created is not binary.
	 * @param modelRel
	 *            The model relationship that will contain the mapping to be
	 *            created.
	 * @return The tree dialog to create a new mapping.
	 */
	public static MIDTreeSelectionDialog getMappingReferenceCreationDialog(ModelElementReference targetSrcModelElemRef, ModelElementReference targetTgtModelElemRef, ModelRel modelRel) {

		ModelRel modelRelType = modelRel.getMetatype();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewMappingReferenceDialogContentProvider(MIDConstraintChecker.getAllowedMappingTypeReferences(modelRelType, targetSrcModelElemRef, targetTgtModelElemRef)),
			modelRelType
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model element type endpoints in a mapping
	 * type, in order to create a new model element endpoint.
	 * 
	 * @param mappingRef
	 *            The reference to the mapping that will contain the model element
	 *            endpoint to be created.
	 * @param modelElemTypeEndpointUris
	 *            The list of allowed uris of the model element type endpoints,
	 *            can be null if all are allowed.
	 * @return The tree dialog to create a new model element endpoint.
	 */
	public static MIDTreeSelectionDialog getModelElementEndpointCreationDialog(MappingReference mappingRef, List<String> modelElemTypeEndpointUris) {

		Mapping mappingType = mappingRef.getObject().getMetatype();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewModelElementEndpointReferenceDialogContentProvider(modelElemTypeEndpointUris),
			mappingType
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all mapping types in a model relationship
	 * type, in order to create a new "light" mapping type and a reference to it.
	 * 
	 * @param newSrcModelElemTypeRef
	 *            The reference to the model element type that is going to be
	 *            the target of the source model element type endpoint, null if
	 *            the mapping type to be created is not binary.
	 * @param newTgtModelElemTypeRef
	 *            The reference to the model element type that is going to be
	 *            the target of the target model element type endpoint, null if
	 *            the mapping type to be created is not binary.
	 * @param modelRelType
	 *            The model relationship type that contains the mapping types.
	 * @return The tree dialog to create a new "light" mapping type.
	 */
	public static MIDTreeSelectionDialog getMappingTypeReferenceCreationDialog(ModelElementReference newSrcModelElemTypeRef, ModelElementReference newTgtModelElemTypeRef, ModelRel modelRelType) {

		List<String> mappingTypeUris = null;

		if (newSrcModelElemTypeRef != null && newTgtModelElemTypeRef != null) {
			MID typeMID = modelRelType.getMIDContainer();
			String newSrcUri = newSrcModelElemTypeRef.getUri();
			String newTgtUri = newTgtModelElemTypeRef.getUri();
			mappingTypeUris = new ArrayList<String>();

			for (MappingReference mappingTypeRef : modelRelType.getMappingRefs()) {
				// binary can only inherit from root or binary
				if (!(mappingTypeRef instanceof BinaryMappingReference)) {
					continue;
				}
				BinaryMapping mappingType = ((BinaryMappingReference) mappingTypeRef).getObject();
				String srcUri = mappingType.getModelElemEndpoints().get(0).getTargetUri();
				String tgtUri = mappingType.getModelElemEndpoints().get(1).getTargetUri();
				// new link type with same endpoints or overriding one or two endpoints
				if (
					(newSrcUri.equals(srcUri) && newTgtUri.equals(tgtUri)) ||
					(MIDTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, typeMID) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && MIDTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, typeMID)) ||
					(MIDTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, typeMID) && MIDTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, typeMID))
				) {
					mappingTypeUris.add(mappingTypeRef.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewMappingTypeReferenceDialogContentProvider(modelRelType, mappingTypeUris),
			modelRelType
		);

		return dialog;
	}

	public static MIDTreeSelectionDialog getGenericTypeCreationDialog(GenericEndpoint genericSuperTypeEndpoint, EList<OperatorInput> inputs) {

		Operator operatorType = (Operator) genericSuperTypeEndpoint.eContainer();
		MID typeMID = operatorType.getMIDContainer();
		GenericElement genericSuperType = genericSuperTypeEndpoint.getTarget();
		List<GenericElement> genericTypes = MIDTypeHierarchy.getGenericSubtypes(genericSuperType);
		genericTypes.add(0, genericSuperType);
		Set<GenericElement> filteredGenericTypes = new HashSet<>();
		for (GenericElement genericType : genericTypes) {
			try {
				if (genericType.isAbstract()) {
					continue;
				}
				if (!operatorType.isAllowedGeneric(genericSuperTypeEndpoint, genericType, inputs)) {
					//TODO MMINT[GENERICS] Can we check that the generic type is consistent with the input, or is it always done by the operator itself?
					continue;
				}
				filteredGenericTypes.add(genericType);
			}
			catch (MMINTException e) {
				continue;
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDTreeSelectionDialog dialog = new MIDTreeSelectionDialog(
			shell,
			new MIDDialogLabelProvider(),
			new NewGenericTypeDialogContentProvider(filteredGenericTypes),
			typeMID
		);

		return dialog;
	}

	/**
	 * Gets the bundle (Eclipse plugin) that declares a type.
	 * 
	 * @param typeUri
	 *            The uri of the type.
	 * @return The bundle that declares a type, null if it can't be found.
	 */
	public static @Nullable Bundle getTypeBundle(@NonNull String typeUri) {

		Bundle bundle = null;
		String bundleName = MMINT.bundleTable.get(typeUri);
		if (bundleName != null) {
			return Platform.getBundle(bundleName);
		}

		return bundle;
	}

	/**
	 * Gets the uri of the metamodel of a metamodel-extended "light" model type.
	 * 
	 * @param modelType
	 *            The metamodel-extended "light" model type.
	 * @return The uri of the metamodel extension if it exists, null if it
	 *         doesn't exist or if the model type is not "light".
	 */
	public static String getExtendedMetamodelUri(Model modelType) {

		if (!modelType.isDynamic()) {
			return null;
		}
		String metamodelUri = modelType.getName() + "." + EcorePackage.eNAME;

		return (MIDUtils.isFileOrDirectoryInState(metamodelUri)) ?
			MIDUtils.prependStateToUri(metamodelUri) :
			null;
	}

}
