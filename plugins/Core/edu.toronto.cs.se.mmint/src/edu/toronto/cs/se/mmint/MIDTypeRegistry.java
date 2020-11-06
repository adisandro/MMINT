/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.reasoning.IOperatorConstraintTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.FileExtensionsDialogFilter;
import edu.toronto.cs.se.mmint.mid.ui.FilesOnlyDialogSelectionValidator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogLabelProvider;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.mmint.mid.ui.NewGenericTypeDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewMappingTypeReferenceDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelElementEndpointReferenceDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelEndpointDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelRelDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelRelTypeDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewModelTypeDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.ui.NewOperatorTypeDialogFilter;
import edu.toronto.cs.se.mmint.mid.ui.NewWorkflowModelDialogContentProvider;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

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

		return MMINT.cachedTypeMID.getExtendibleElement(typeUri);
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
		genericTypes.addAll(MIDTypeRegistry.getModelTypes());
		genericTypes.addAll(MIDTypeRegistry.getOperatorTypes());

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
	 * Gets the list of file extensions for all model types in the repository.
	 *
	 * @return The list of file extensions for model types.
	 */
	public static Set<String> getModelTypeFileExtensions() {

	  var modelStream = MIDTypeRegistry.getModelTypes().stream().map(Model::getFileExtension);
	  var editorStream = MIDTypeRegistry.getEditorTypes().stream()
	    .filter(e -> !(e instanceof Diagram))
	    .flatMap(e -> e.getFileExtensions().stream());
		return Stream.concat(modelStream, editorStream).collect(Collectors.toSet());
	}

	public static @Nullable Model getMIDModelType() {

		return MIDTypeRegistry.getType(MIDPackage.eNS_URI);
	}

	public static @Nullable Diagram getMIDDiagramType() {

		Model midModelType = MIDTypeRegistry.getMIDModelType();
		if (midModelType == null) {
			return null;
		}

		return MIDRegistry.getModelDiagram(midModelType);
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

		var dialog = new MIDTreeSelectionDialog(
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
			var newSrcUri = newSrcModelType.getUri();
			var newTgtUri = newTgtModelType.getUri();
			modelRelTypeUris = new ArrayList<>();

			for (ModelRel modelRelType : typeMID.getModelRels()) {
				// binary can only inherit from root or binary
				if (MIDTypeHierarchy.isRootType(modelRelType)) {
					modelRelTypeUris.add(modelRelType.getUri());
					continue;
				}
				if (!(modelRelType instanceof BinaryModelRel)) {
					continue;
				}
				var srcUri = modelRelType.getModelEndpoints().get(0).getTargetUri();
				var tgtUri = modelRelType.getModelEndpoints().get(1).getTargetUri();
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

		var dialog = new MIDTreeSelectionDialog(
			new MIDDialogLabelProvider(),
			new NewModelRelTypeDialogContentProvider(modelRelTypeUris),
			typeMID
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
			var typeMID = modelRelType.getMIDContainer();
			var newSrcUri = newSrcModelElemTypeRef.getUri();
			var newTgtUri = newTgtModelElemTypeRef.getUri();
			mappingTypeUris = new ArrayList<>();

			for (MappingReference mappingTypeRef : modelRelType.getMappingRefs()) {
				// binary can only inherit from root or binary
				if (!(mappingTypeRef instanceof BinaryMappingReference)) {
					continue;
				}
				var mappingType = ((BinaryMappingReference) mappingTypeRef).getObject();
				var srcUri = mappingType.getModelElemEndpoints().get(0).getTargetUri();
				var tgtUri = mappingType.getModelElemEndpoints().get(1).getTargetUri();
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

		var dialog = new MIDTreeSelectionDialog(
			new MIDDialogLabelProvider(),
			new NewMappingTypeReferenceDialogContentProvider(modelRelType, mappingTypeUris),
			modelRelType
		);

		return dialog;
	}

	public static MIDTreeSelectionDialog getOperatorTypeCreationDialog(MID typeMID) {

		var dialog = new MIDTreeSelectionDialog(
			new WorkbenchLabelProvider(),
			new BaseWorkbenchContentProvider(),
			ResourcesPlugin.getWorkspace().getRoot()
		);
		dialog.addFilter(new NewOperatorTypeDialogFilter(Set.of(MIDPackage.eNAME)));
		dialog.setValidator(new FilesOnlyDialogSelectionValidator("Workflow MID file selected",
		                                                          "Please select a Workflow MID file"));

		return dialog;
	}

	public static MIDTreeSelectionDialog getGenericTypeCreationDialog(GenericEndpoint genericSuperTypeEndpoint, EList<OperatorInput> inputs) {

		var operatorType = (Operator) genericSuperTypeEndpoint.eContainer();
		var typeMID = operatorType.getMIDContainer();
		var genericSuperType = genericSuperTypeEndpoint.getTarget();
		var genericTypes = MIDTypeHierarchy.getGenericSubtypes(genericSuperType);
		genericTypes.add(0, genericSuperType);
		var filteredGenericTypes = new HashSet<GenericElement>();
		for (var genericType : genericTypes) {
	    if (genericType.getUri().equals(MMINTConstants.ROOT_URI + MMINTConstants.URI_SEPARATOR +
	                                    WorkflowOperator.class.getSimpleName())) {
        continue;
	    }
			try {
			  var constraint = operatorType.getClosestTypeConstraint();
	      var reasoner = MIDConstraintChecker.getReasoner(constraint, IOperatorConstraintTrait.class,
	                                                      "operator constraint checking");
	      if (reasoner.isEmpty() ||
	          reasoner.get().checkOperatorGenericConstraint(constraint, genericSuperTypeEndpoint, genericType, inputs)) {
          filteredGenericTypes.add(genericType);
	      }
			}
			catch (Exception e) {
			  // continue
			}
		}

		var dialog = new MIDTreeSelectionDialog(
			new MIDDialogLabelProvider(),
			new NewGenericTypeDialogContentProvider(filteredGenericTypes),
			typeMID
		);

		return dialog;
	}

	public static MIDTreeSelectionDialog getMIDTreeTypeSelectionDialog(ILabelProvider labelProvider,
	                                                                   ITreeContentProvider contentProvider) {

        return new MIDTreeSelectionDialog(labelProvider, contentProvider, MMINT.cachedTypeMID);
	}

	/**
	 * Gets a tree dialog that shows all model files in the workspace, in order
	 * to import an existing model.
	 *
	 * @return The tree dialog to import an existing model.
	 */
	public static MIDTreeSelectionDialog getModelImportDialog() {

		var dialog = new MIDTreeSelectionDialog(
			new WorkbenchLabelProvider(),
			new BaseWorkbenchContentProvider(),
			ResourcesPlugin.getWorkspace().getRoot()
		);
		dialog.addFilter(new FileExtensionsDialogFilter(MIDTypeRegistry.getModelTypeFileExtensions()));
		dialog.setValidator(new FilesOnlyDialogSelectionValidator());

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

		var dialog = new MIDTreeSelectionDialog(
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

		var dialog = new MIDTreeSelectionDialog(
			new MIDDialogLabelProvider(),
			new NewModelEndpointDialogContentProvider(modelTypeEndpointUris),
			modelRel.getMetatype()
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

		var mappingType = mappingRef.getObject().getMetatype();
		var dialog = new MIDTreeSelectionDialog(
			new MIDDialogLabelProvider(),
			new NewModelElementEndpointReferenceDialogContentProvider(modelElemTypeEndpointUris),
			mappingType
		);

		return dialog;
	}

	public static MIDTreeSelectionDialog getWorkflowModelCreationDialog() {

		var dialog = new MIDTreeSelectionDialog(
			new MIDDialogLabelProvider(),
			new NewWorkflowModelDialogContentProvider(MMINT.cachedTypeMID),
			MMINT.cachedTypeMID
		);

		return dialog;
	}

	public static MIDTreeSelectionDialog getWorkflowModelRelCreationDialog(Model targetSrcModel, Model targetTgtModel) {

		return MIDTypeRegistry.getModelRelCreationDialog(targetSrcModel, targetTgtModel);
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
		var bundleName = MMINT.bundleTable.get(typeUri);
		if (bundleName != null) {
			return Platform.getBundle(bundleName);
		}

		return bundle;
	}

	private static String extractJarFile(String bundlePath, String relativeFilePath) throws Exception {
    var fileName = FileUtils.getLastSegmentFromPath(relativeFilePath);
    var tmpFilePath = Paths.get(System.getProperty("java.io.tmpdir") + File.separator + fileName);
    try (var bundleJar = new JarFile(new File(bundlePath))) {
      var bundleJarEntry = bundleJar.getEntry(relativeFilePath);
      if (bundleJarEntry == null) {
        throw new MMINTException("Can't find the " + fileName + "file");
      }
      Files.copy(bundleJar.getInputStream(bundleJarEntry), tmpFilePath, StandardCopyOption.REPLACE_EXISTING);
    }

    return tmpFilePath.toString();
	}

	public static String getFileBundlePath(ExtendibleElement typeInBundle, String relativeFilePath) throws Exception {
    var bundlePath = typeInBundle.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
    var fileName = FileUtils.getLastSegmentFromPath(relativeFilePath);
    String filePath;
    if (bundlePath.endsWith("jar")) { // binary installation
      // first attempt: find file in original jar
      try {
        filePath = extractJarFile(bundlePath, relativeFilePath);
      }
      catch (Exception e) {
        // do nothing
      }
      // second attempt: find file in source jar
      var separator = bundlePath.lastIndexOf("_");
      var srcBundlePath = bundlePath.substring(0, separator) + ".source" + bundlePath.substring(separator);
      if (!FileUtils.isFile(srcBundlePath, false)) {
        var errorMsg = "Can't find the " + fileName + "file";
        if (fileName.endsWith("java")) {
          errorMsg += " (try installing mmint.sdk)";
        }
        throw new MMINTException(errorMsg);
      }
      filePath = extractJarFile(srcBundlePath, relativeFilePath);
    }
    else { // running from the sources
      Bundle bundle = MIDTypeRegistry.getTypeBundle(typeInBundle.getUri());
      if (bundle == null) {
        throw new MMINTException("Can't find the bundle for " + typeInBundle.getName());
      }
      var bundleEntries = bundle.findEntries("/", fileName, true);
      if (bundleEntries == null || !bundleEntries.hasMoreElements()) {
        throw new MMINTException("Can't find the source file for " + fileName);
      }
      filePath = FileLocator.toFileURL(bundleEntries.nextElement()).getFile();
      if (Platform.getOS().equals(Platform.OS_WIN32)) {
        filePath = filePath.substring(1); // remove leading slash
      }
    }

    return filePath;
  }

	/**
	 * Gets the uri of the metamodel of a metamodel-extended "light" model type.
	 *
	 * @param modelType
	 *            The metamodel-extended "light" model type.
	 * @return The uri of the metamodel extension if it exists, null if it
	 *         doesn't exist or if the model type is not "light".
	 */
	public static String getExtendedMetamodelPath(Model modelType) {

		if (!modelType.isDynamic()) {
			return null;
		}
		var metamodelUri = modelType.getName() + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;

		return (FileUtils.isFileOrDirectoryInState(metamodelUri)) ?
			FileUtils.prependStatePath(metamodelUri) :
			null;
	}

	public static @Nullable IViewProvider getCachedMIDViewProvider() {

		return MMINT.cachedMIDViewProvider;
	}

	public static void setCachedMIDViewProvider(@Nullable IViewProvider midViewProvider) {

		MMINT.cachedMIDViewProvider = midViewProvider;
	}

}
