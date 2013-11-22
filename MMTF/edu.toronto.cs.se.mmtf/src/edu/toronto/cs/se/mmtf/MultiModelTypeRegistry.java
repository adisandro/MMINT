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
package edu.toronto.cs.se.mmtf;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.ui.MultiModelTreeSelectionDialog;
import edu.toronto.cs.se.mmtf.mid.ui.NewLinkReferenceDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.NewLinkTypeReferenceDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.NewModelDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.NewModelDialogSelectionValidator;
import edu.toronto.cs.se.mmtf.mid.ui.NewModelElementEndpointReferenceDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.NewModelEndpointDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.NewModelRelDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.NewModelRelTypeDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.NewModelTypeDialogContentProvider;
import edu.toronto.cs.se.mmtf.mid.ui.MultiModelDialogLabelProvider;

/**
 * The registry for querying the types.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeRegistry {

	/**
	 * Gets the multimodel from the Type MID file.
	 * 
	 * @return The multimodel from the Type MID file.
	 * @throws Exception
	 *             If the Type MID file doesn't exist.
	 */
	public static MultiModel getTypeMidRepository() throws Exception {

		String path = MMTFActivator.getDefault().getStateLocation().toOSString();
		MultiModel root = (MultiModel) MultiModelTypeIntrospection.getRoot(
			URI.createFileURI(path + IPath.SEPARATOR + MMTF.TYPE_MID_FILENAME)
		);

		return root;
	}

	/**
	 * Gets the uri of the root type for a certain class of types.
	 * 
	 * @param type
	 *            The type from which to understand the class of types.
	 * @return The uri of the root type.
	 */
	public static String getRootTypeUri(ExtendibleElement type) {

		String rootUri = "";
		if (type instanceof ModelRel) {
			rootUri = MMTF.ROOT_MODELREL_URI;
		}
		else if (type instanceof Model) {
			rootUri = MMTF.ROOT_MODEL_URI;
		}
		else if (type instanceof ModelEndpoint) {
			rootUri = MMTF.ROOT_MODELENDPOINT_URI;
		}
		else if (type instanceof ModelElement) {
			rootUri = MMTF.ROOT_MODELELEM_URI;
		}
		else if (type instanceof Link) {
			rootUri = MMTF.ROOT_LINK_URI;
		}
		else if (type instanceof ModelElementEndpoint) {
			rootUri = MMTF.ROOTMODELELEMENDPOINT_URI;
		}
		//TODO MMTF: root text editor and operator?

		return rootUri;
	}

	/**
	 * Checks if the given type is the root type for its class.
	 * 
	 * @param type
	 *            The type to be checked.
	 * @return True if the given type is the root type, false otherwise.
	 */
	public static boolean isRootType(ExtendibleElement type) {

		return type.getUri().equals(getRootTypeUri(type));
	}

	/**
	 * Gets a type from the repository.
	 * 
	 * @param typeUri
	 *            The uri of the type.
	 * @return The type, null if the uri is not found or found not to be of the
	 *         desired class of types.
	 */
	public static <T extends ExtendibleElement> T getType(String typeUri) {

		return MultiModelRegistry.getExtendibleElement(typeUri, MMTF.repository);
	}

	/**
	 * Gets the list of operator types in the repository.
	 * 
	 * @return The list of operator types in the repository.
	 */
	public static List<Operator> getOperatorTypes() {

		return MultiModelRegistry.getOperators(MMTF.repository);
	}

	/**
	 * Gets the list of model types in the repository.
	 * 
	 * @return The list of model types in the repository.
	 */
	public static EList<Model> getModelTypes() {

		return MultiModelRegistry.getModels(MMTF.repository);
	}

	/**
	 * Gets the list of model relationship types in the repository.
	 * 
	 * @return The list of model relationship types in the repository.
	 */
	public static EList<ModelRel> getModelRelTypes() {

		return MultiModelRegistry.getModelRels(MMTF.repository);
	}

	/**
	 * Gets the list of editor types in the repository.
	 * 
	 * @return The list of editor types in the repository.
	 */
	public static EList<Editor> getEditorTypes() {

		return MultiModelRegistry.getEditors(MMTF.repository);
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
	public static ArrayList<String> getModelTypeFileExtensions() {

		ArrayList<String> filenames = new ArrayList<String>();
		for (Model model : MMTF.repository.getModels()) {
			filenames.add(model.getFileExtension());
		}

		return filenames;
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
			new NewModelDialogContentProvider(MMTF.repository),
			MMTF.repository
		);
		dialog.setValidator(new NewModelDialogSelectionValidator());

		return dialog;
	}

	/**
	 * Gets a tree dialog that shows all model relationship types in the
	 * repository, in order to create a new model relationship.
	 * 
	 * @param newSrcModel
	 *            The model that is going to be the target of the source model
	 *            endpoint, null if the model relationship to be created is not
	 *            binary.
	 * @param newTgtModel
	 *            The model that is going to be the target of the target model
	 *            endpoint, null if the model relationship to be created is not
	 *            binary.
	 * @return The tree dialog to create a new model relationship.
	 */
	public static MultiModelTreeSelectionDialog getModelRelCreationDialog(Model newSrcModel, Model newTgtModel) {

		List<String> modelRelTypeUris = null;

		if (newSrcModel != null && newTgtModel != null) {
			modelRelTypeUris = new ArrayList<String>();
			for (ModelRel modelRelType : getModelRelTypes()) {
				boolean okSrc = false, okTgt = false;
				HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
				//TODO MMTF: consider direction for binary?
				for (ModelEndpointReference modelTypeEndpointRef : modelRelType.getModelEndpointRefs()) {
					if (!okSrc) {
						okSrc = MultiModelConstraintChecker.isAllowedModelEndpoint(modelTypeEndpointRef, newSrcModel, cardinalityTable);
						if (okSrc) {
							MultiModelRegistry.initEndpointCardinalities(modelTypeEndpointRef.getUri(), cardinalityTable);
						}
					}
					if (!okTgt) {
						okTgt = MultiModelConstraintChecker.isAllowedModelEndpoint(modelTypeEndpointRef, newTgtModel, cardinalityTable);
						if (okTgt) {
							MultiModelRegistry.initEndpointCardinalities(modelTypeEndpointRef.getUri(), cardinalityTable);
						}
					}
					if (okSrc && okTgt) {
						modelRelTypeUris.add(modelRelType.getUri());
						break;
					}
				}
			}

			// check for overrides
			for (String modelRelTypeUri : modelRelTypeUris) {
				//TODO MMTF: if one model rel type points to another one in this list through its override pointer, then delete it
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewModelRelDialogContentProvider(modelRelTypeUris),
			MMTF.repository
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
				if (isRootType(modelRelType)) {
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
	 * @param newSrcModelElemRef
	 *            The reference to the model element that is going to be the
	 *            target of the source model element endpoint, null if the link
	 *            to be created is not binary.
	 * @param newTgtModelElemRef
	 *            The reference to the model element that is going to be the
	 *            target of the target model element endpoint, null if the link
	 *            to be created is not binary.
	 * @param modelRel
	 *            The model relationship that will contain the link to be
	 *            created.
	 * @return The tree dialog to create a new link.
	 */
	public static MultiModelTreeSelectionDialog getLinkReferenceCreationDialog(ModelElementReference newSrcModelElemRef, ModelElementReference newTgtModelElemRef, ModelRel modelRel) {

		List<String> linkTypeUris = null;
		ModelRel modelRelType = modelRel.getMetatype();

		if (newSrcModelElemRef != null && newTgtModelElemRef != null) {
			linkTypeUris = new ArrayList<String>();
			for (LinkReference linkTypeRef : modelRelType.getLinkRefs()) {
				boolean okSrc = false, okTgt = false;
				Link linkType = linkTypeRef.getObject();
				HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
				//TODO MMTF: consider direction for binary?
				for (ModelElementEndpointReference modelElemTypeEndpointRef : linkType.getModelElemEndpointRefs()) {
					if (!okSrc) {
						okSrc = MultiModelConstraintChecker.isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), newSrcModelElemRef, cardinalityTable);
						if (okSrc) {
							MultiModelRegistry.initEndpointCardinalities(modelElemTypeEndpointRef.getUri(), cardinalityTable);
						}
					}
					if (!okTgt) {
						okTgt = MultiModelConstraintChecker.isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), newTgtModelElemRef, cardinalityTable);
						if (okTgt) {
							MultiModelRegistry.initEndpointCardinalities(modelElemTypeEndpointRef.getUri(), cardinalityTable);
						}
					}
					if (okSrc && okTgt) {
						linkTypeUris.add(linkType.getUri());
						break;
					}
				}
			}

			// check for overrides
			for (String linkTypeUri : linkTypeUris) {
				//TODO MMTF: if one link type points to another one in this list through its override pointer, then delete it
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new MultiModelDialogLabelProvider(),
			new NewLinkReferenceDialogContentProvider(linkTypeUris),
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

	/**
	 * Gets the signature of an operator type's parameter.
	 * 
	 * @param parameter
	 *            The parameter of an operator type.
	 * @return The signature of the parameter.
	 */
	private static String getParameterSignature(Parameter parameter) {

		String signature = parameter.getModel().getName();
		if (parameter.isVararg()) {
			signature += "...";
		}
		signature += " " + parameter.getName();

		return signature;
	}

	/**
	 * Gets the signature of an operator type.
	 * 
	 * @param operatorType
	 *            The operator type.
	 * @return The signature of the operator type.
	 */
	public static String getOperatorSignature(Operator operatorType) {

		// output parameters
		String signature = "[";
		for (Parameter parameter : operatorType.getOutputs()) {
			signature += getParameterSignature(parameter) + ", ";
		}
		if (operatorType.getOutputs().size() > 0) {
			signature = signature.substring(0, signature.length() - 2);
		}
		signature += "] ";

		// operator name
		signature += operatorType.getName() + "(";

		// input parameters
		for (Parameter parameter : operatorType.getInputs()) {
			signature += getParameterSignature(parameter) + ", ";
		}
		if (operatorType.getInputs().size() > 0) {
			signature = signature.substring(0, signature.length() - 2);
		}
		signature += ")";

		return signature;
	}

	/**
	 * Gets the bundle (Eclipse plugin) that declares a type.
	 * 
	 * @param typeUri
	 *            The uri of the type.
	 * @return The bundle that declares a type, null if it can't be found.
	 */
	public static Bundle getTypeBundle(String typeUri) {

		Bundle bundle = null;
		String bundleName = MMTF.bundleTable.get(typeUri);
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
		String mmtfUri = MMTFActivator.getDefault().getStateLocation().toOSString();
		String metamodelUri = mmtfUri + IPath.SEPARATOR + modelType.getName().toLowerCase() + "." + EcorePackage.eNAME;
		Path metamodelPath = Paths.get(metamodelUri);
		if (!Files.exists(metamodelPath)) {
			return null;
		}

		return metamodelUri;
	}

}
