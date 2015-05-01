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
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.ImportModelDialogFilter;
import edu.toronto.cs.se.mmint.mid.ui.ImportModelDialogSelectionValidator;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDialogLabelProvider;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelTreeSelectionDialog;
import edu.toronto.cs.se.mmint.mid.ui.NewGenericTypeDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewLinkReferenceDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewLinkTypeReferenceDialogContentProvider;
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
public class MultiModelTypeRegistry {

	/**
	 * Gets a type from the repository.
	 * 
	 * @param typeUri
	 *            The uri of the type.
	 * @return The type, null if the uri is not found or found not to be of the
	 *         desired class of types.
	 */
	public static <T extends ExtendibleElement> @Nullable T getType(@NonNull String typeUri) {

		return MultiModelRegistry.getExtendibleElement(typeUri, MMINT.cachedTypeMID);
	}

	/**
	 * Gets the list of operator types in the repository.
	 * 
	 * @return The list of operator types in the repository.
	 */
	public static List<Operator> getOperatorTypes() {

		return MultiModelRegistry.getOperators(MMINT.cachedTypeMID);
	}

	/**
	 * Gets the list of model types in the repository.
	 * 
	 * @return The list of model types in the repository.
	 */
	public static EList<Model> getModelTypes() {

		return MultiModelRegistry.getModels(MMINT.cachedTypeMID);
	}

	/**
	 * Gets the list of generic types in the repository.
	 * 
	 * @return The list of generic types in the repository.
	 */
	public static List<GenericElement> getGenericTypes() {

		List<GenericElement> genericTypes = new ArrayList<>();
		genericTypes.addAll(getModelTypes());
		genericTypes.addAll(getModelRelTypes());
		genericTypes.addAll(getOperatorTypes());

		return genericTypes;
	}

	/**
	 * Gets the list of editor types in the repository.
	 * 
	 * @return The list of editor types in the repository.
	 */
	public static EList<Editor> getEditorTypes() {

		return MultiModelRegistry.getEditors(MMINT.cachedTypeMID);
	}

	/**
	 * Gets the list of model relationship types in the repository.
	 * 
	 * @return The list of model relationship types in the repository.
	 */
	public static EList<ModelRel> getModelRelTypes() {

		return MultiModelRegistry.getModelRels(MMINT.cachedTypeMID);
	}

	/**
	 * Gets the list of link types in a model relationship type.
	 * 
	 * @param modelRelType
	 *            The model relationship type that contains the link types.
	 * @return The list of link types in the model relationship type.
	 */
	public static EList<Link> getLinkTypes(ModelRel modelRelType) {

		return modelRelType.getLinks();
	}

	/**
	 * Gets the list of references to link types in a model relationship type.
	 * 
	 * @param modelRelType
	 *            The model relationship type that contains the references to
	 *            link types.
	 * @return The list of references to link types in the model relationship
	 *         type.
	 */
	public static EList<LinkReference> getLinkTypeReferences(ModelRel modelRelType) {

		return modelRelType.getLinkRefs();
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
	public static MultiModelTreeSelectionDialog getModelCreationDialog() {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
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
	public static MultiModelTreeSelectionDialog getModelImportDialog() {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
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
	public static MultiModelTreeSelectionDialog getModelRelCreationDialog(Model targetSrcModel, Model targetTgtModel) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewModelRelDialogContentProvider(MultiModelConstraintChecker.getAllowedModelRelTypes(targetSrcModel, targetTgtModel)),
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
	public static MultiModelTreeSelectionDialog getModelEndpointCreationDialog(ModelRel modelRel, List<String> modelTypeEndpointUris) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewModelEndpointDialogContentProvider(modelTypeEndpointUris),
			modelRel.getMetatype()
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model types in a multimodel, in order
	 * to create a new "light" model type.
	 * 
	 * @param multiModel
	 *            The multimodel that contains the model types.
	 * @return The tree dialog to create a new "light" model type.
	 */
	public static MultiModelTreeSelectionDialog getModelTypeCreationDialog(MultiModel multiModel) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewModelTypeDialogContentProvider(),
			multiModel
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model relationship types in a
	 * multimodel, in order to create a new "light" model relationship type.
	 * 
	 * @param newSrcModelType
	 *            The model type that is going to be the target of the source
	 *            model type endpoint, null if the model relationship type to be
	 *            created is not binary.
	 * @param newTgtModelType
	 *            The model type that is going to be the target of the target
	 *            model type endpoint, null if the model relationship type to be
	 *            created is not binary.
	 * @param multiModel
	 *            The multimodel that contains the model relationship types.
	 * 
	 * @return The tree dialog to create a new "light" model relationship type.
	 */
	public static MultiModelTreeSelectionDialog getModelRelTypeCreationDialog(Model newSrcModelType, Model newTgtModelType, MultiModel multiModel) {

		List<String> modelRelTypeUris = null;

		if (newSrcModelType != null && newTgtModelType != null) {
			String newSrcUri = newSrcModelType.getUri();
			String newTgtUri = newTgtModelType.getUri();
			modelRelTypeUris = new ArrayList<String>();

			for (ModelRel modelRelType : MultiModelRegistry.getModelRels(multiModel)) {
				// binary can only inherit from root or binary
				if (MultiModelTypeHierarchy.isRootType(modelRelType)) {
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
					(MultiModelTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, multiModel) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && MultiModelTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, multiModel)) ||
					(MultiModelTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, multiModel) && MultiModelTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, multiModel))
				) {
					modelRelTypeUris.add(modelRelType.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewModelRelTypeDialogContentProvider(modelRelTypeUris),
			multiModel
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all link types in a model relationship
	 * type, in order to create a new link and a reference to it.
	 * 
	 * @param targetSrcModelElemRef
	 *            The reference to the model element that is going to be the
	 *            target of the source model element endpoint, null if the link
	 *            to be created is not binary.
	 * @param targetTgtModelElemRef
	 *            The reference to the model element that is going to be the
	 *            target of the target model element endpoint, null if the link
	 *            to be created is not binary.
	 * @param modelRel
	 *            The model relationship that will contain the link to be
	 *            created.
	 * @return The tree dialog to create a new link.
	 */
	public static MultiModelTreeSelectionDialog getLinkReferenceCreationDialog(ModelElementReference targetSrcModelElemRef, ModelElementReference targetTgtModelElemRef, ModelRel modelRel) {

		ModelRel modelRelType = modelRel.getMetatype();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewLinkReferenceDialogContentProvider(MultiModelConstraintChecker.getAllowedLinkTypeReferences(modelRelType, targetSrcModelElemRef, targetTgtModelElemRef)),
			modelRelType
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model element type endpoints in a link
	 * type, in order to create a new model element endpoint.
	 * 
	 * @param linkRef
	 *            The reference to the link that will contain the model element
	 *            endpoint to be created.
	 * @param modelElemTypeEndpointUris
	 *            The list of allowed uris of the model element type endpoints,
	 *            can be null if all are allowed.
	 * @return The tree dialog to create a new model element endpoint.
	 */
	public static MultiModelTreeSelectionDialog getModelElementEndpointCreationDialog(LinkReference linkRef, List<String> modelElemTypeEndpointUris) {

		Link linkType = linkRef.getObject().getMetatype();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewModelElementEndpointReferenceDialogContentProvider(modelElemTypeEndpointUris),
			linkType
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all link types in a model relationship
	 * type, in order to create a new "light" link type and a reference to it.
	 * 
	 * @param newSrcModelElemTypeRef
	 *            The reference to the model element type that is going to be
	 *            the target of the source model element type endpoint, null if
	 *            the link type to be created is not binary.
	 * @param newTgtModelElemTypeRef
	 *            The reference to the model element type that is going to be
	 *            the target of the target model element type endpoint, null if
	 *            the link type to be created is not binary.
	 * @param modelRelType
	 *            The model relationship type that contains the link types.
	 * @return The tree dialog to create a new "light" link type.
	 */
	public static MultiModelTreeSelectionDialog getLinkTypeReferenceCreationDialog(ModelElementReference newSrcModelElemTypeRef, ModelElementReference newTgtModelElemTypeRef, ModelRel modelRelType) {

		List<String> linkTypeUris = null;

		if (newSrcModelElemTypeRef != null && newTgtModelElemTypeRef != null) {
			MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
			String newSrcUri = newSrcModelElemTypeRef.getUri();
			String newTgtUri = newTgtModelElemTypeRef.getUri();
			linkTypeUris = new ArrayList<String>();

			for (LinkReference linkTypeRef : modelRelType.getLinkRefs()) {
				// binary can only inherit from root or binary
				if (!(linkTypeRef instanceof BinaryLinkReference)) {
					continue;
				}
				BinaryLink linkType = ((BinaryLinkReference) linkTypeRef).getObject();
				String srcUri = linkType.getModelElemEndpoints().get(0).getTargetUri();
				String tgtUri = linkType.getModelElemEndpoints().get(1).getTargetUri();
				// new link type with same endpoints or overriding one or two endpoints
				if (
					(newSrcUri.equals(srcUri) && newTgtUri.equals(tgtUri)) ||
					(MultiModelTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, multiModel) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && MultiModelTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, multiModel)) ||
					(MultiModelTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, multiModel) && MultiModelTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, multiModel))
				) {
					linkTypeUris.add(linkTypeRef.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewLinkTypeReferenceDialogContentProvider(modelRelType, linkTypeUris),
			modelRelType
		);

		return dialog;
	}

	public static MultiModelTreeSelectionDialog getGenericTypeCreationDialog(GenericEndpoint genericSuperTypeEndpoint, EList<OperatorInput> inputs) {

		Operator operatorType = (Operator) genericSuperTypeEndpoint.eContainer();
		MultiModel TypeMID = MultiModelRegistry.getMultiModel(operatorType);
		GenericElement genericSuperType = genericSuperTypeEndpoint.getTarget();
		List<GenericElement> genericTypes = MultiModelTypeHierarchy.getSubtypes(genericSuperType);
		genericTypes.add(0, genericSuperType);
		Set<GenericElement> filteredGenericTypes = new HashSet<>();
		for (GenericElement genericType : genericTypes) {
			try {
				if (genericType.isAbstract()) {
					continue;
				}
				if (!operatorType.isAllowedTargetGeneric(genericSuperTypeEndpoint, genericType, inputs)) {
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
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewGenericTypeDialogContentProvider(filteredGenericTypes),
			TypeMID
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

		return (MultiModelUtils.isFileOrDirectoryInState(metamodelUri)) ?
			MultiModelUtils.prependStateToUri(metamodelUri) :
			null;
	}

}
