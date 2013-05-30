/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
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
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.repository.ui.MultiModelTreeSelectionDialog;
import edu.toronto.cs.se.mmtf.repository.ui.NewModelDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.NewModelEndpointDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.NewModelRelDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.NewModelRelTypeDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.NewModelTypeDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.RelationshipTypesDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.NewModelDialogSelectionValidator;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogLabelProvider;

/**
 * The MMTF registry, to be queried by extensions to get info about the
 * repository.
 * 
 * @author Alessio Di Sandro
 * 
 */
/**
 * The registry for queries to the type multimodel.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeRegistry {

	public static MultiModel getTypeMidRepository() throws Exception {

		String path = MMTFActivator.getDefault().getStateLocation().toOSString();
		MultiModel root = (MultiModel) MultiModelTypeIntrospection.getRoot(
			URI.createFileURI(path + IPath.SEPARATOR + MMTF.TYPE_MID_FILENAME)
		);

		return root;
	}

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
			ModelElementCategory category = ((ModelElement) type).getCategory();
			if (category == null || category == ModelElementCategory.ENTITY) {
				rootUri = MMTF.ROOT_MODELELEMENT_ENTITY_URI;
			}
			else if (category == ModelElementCategory.RELATIONSHIP) {
				rootUri = MMTF.ROOT_MODELELEMENT_RELATIONSHIP_URI;
			}
		}
		else if (type instanceof Link) {
			rootUri = MMTF.ROOT_MODELREL_LINK_URI;
		}
		else if (type instanceof ModelElementEndpoint) {
			ModelElement target = ((ModelElementEndpoint) type).getTarget();
			if (target == null || target.getCategory() == ModelElementCategory.ENTITY) {
				rootUri = MMTF.ROOT_MODELREL_LINKENDPOINT_ENTITY_URI;
			}
			else if (target.getCategory() == ModelElementCategory.RELATIONSHIP) {
				rootUri = MMTF.ROOT_MODELREL_LINKENDPOINT_RELATIONSHIP_URI;
			}
		}
		//TODO MMTF: root text editor and operator?

		return rootUri;
	}

	public static boolean isRootType(ExtendibleElement type) {

		return type.getUri().equals(getRootTypeUri(type));
	}

	/**
	 * Gets an extendible element type from the repository.
	 * 
	 * @param typeUri
	 *            The uri of the extendible element type.
	 * @return The extendible element type, or null if the uri is not found or
	 *         found not to be of the desired class.
	 */
	public static <T extends ExtendibleElement> T getExtendibleElementType(String typeUri) {

		return MultiModelRegistry.getExtendibleElement(MMTF.repository, typeUri);
	}

	/**
	 * Gets the list of registered operator types.
	 * 
	 * @return The list of registered operator types.
	 */
	public static List<Operator> getOperatorTypes() {

		return getOperatorTypes(MMTF.repository);
	}

	/**
	 * Gets the list of registered operator types in the multimodel.
	 * 
	 * @return The list of registered operator types in the multimodel.
	 */
	public static List<Operator> getOperatorTypes(MultiModel multiModel) {

		return multiModel.getOperators();
	}

	/**
	 * Gets the list of registered model types.
	 * 
	 * @return The list of registered model types.
	 */
	public static EList<Model> getModelTypes() {

		return getModelTypes(MMTF.repository);
	}

	/**
	 * Gets the list of registered model types in the multimodel.
	 * 
	 * @return The list of registered model types in the multimodel.
	 */
	public static EList<Model> getModelTypes(MultiModel multiModel) {

		return multiModel.getModels();
	}

	/**
	 * Gets the list of registered model relationship types.
	 * 
	 * @return The list of registered model relationship types.
	 */
	public static EList<ModelRel> getModelRelTypes() {

		return getModelRelTypes(MMTF.repository);
	}

	/**
	 * Gets the list of registered model relationship types in multimodel.
	 * 
	 * @return The list of registered model relationship types in multimodel.
	 */
	public static EList<ModelRel> getModelRelTypes(MultiModel multiModel) {

		EList<ModelRel> modelRels = new BasicEList<ModelRel>();
		for (Model model : getModelTypes(multiModel)) {
			if (model instanceof ModelRel) {
				modelRels.add((ModelRel) model);
			}
		}

		return modelRels;
	}

	/**
	 * Gets the list of registered editor types.
	 * 
	 * @return The list of registered editor types.
	 */
	public static EList<Editor> getEditorTypes() {

		return MMTF.repository.getEditors();
	}

	/**
	 * Gets the list of registered link types for a model relationship type.
	 * 
	 * @param modelRelType
	 *            The model relationship type.
	 * 
	 * @return The list of registered link types for a model relationship
	 *         type.
	 */
	public static EList<Link> getLinkTypes(ModelRel modelRelType) {

		return modelRelType.getLinks();
	}

	public static EList<LinkReference> getLinkTypeReferences(ModelRel modelRelType) {

		return modelRelType.getLinkRefs();
	}

	/**
	 * Gets the list of registered model element types for a model type.
	 * 
	 * @param modelType
	 *            The model type.
	 * 
	 * @return The list of registered model element types for a model type.
	 */
	public static EList<ModelElement> getModelElementTypes(Model modelType) {

		return modelType.getElements();
	}

	/**
	 * Gets the list of registered file extensions for all model types.
	 * 
	 * @return The list of registered file extensions.
	 */
	public static ArrayList<String> getModelTypeFileExtensions() {

		ArrayList<String> filenames = new ArrayList<String>();
		for (Model model : MMTF.repository.getModels()) {
			filenames.add(model.getFileExtension());
		}

		return filenames;
	}

	/**
	 * Gets the list of registered editors for a model type (identified by
	 * its uri).
	 * 
	 * @param modelTypeUri
	 *            The model type uri.
	 * @return The list of registered editors.
	 */
	public static EList<Editor> getModelTypeEditors(String modelTypeUri) {

		Model model = getExtendibleElementType(modelTypeUri);
		if (model != null) {
			return model.getEditors();
		}
		else {
			return ECollections.emptyEList();
		}
	}

	/**
	 * Gets a tree dialog to select among registered model types' editors.
	 * 
	 * @return The tree dialog.
	 */
	public static MultiModelTreeSelectionDialog getModelCreationDialog() {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryDialogLabelProvider(),
			new NewModelDialogContentProvider(MMTF.repository),
			MMTF.repository
		);
		dialog.setValidator(new NewModelDialogSelectionValidator());

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered model relationship
	 * types that can fit model source and target (are both null in case of
	 * nary model relationship).
	 * 
	 * @return The tree dialog.
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
			new RepositoryDialogLabelProvider(),
			new NewModelRelDialogContentProvider(modelRelTypeUris),
			MMTF.repository
		);

		return dialog;
	}

	public static MultiModelTreeSelectionDialog getModelEndpointCreationDialog(ModelRel modelRel, List<String> modelTypeEndpointUris) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryDialogLabelProvider(),
			new NewModelEndpointDialogContentProvider(modelTypeEndpointUris),
			modelRel.getMetatype()
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered model types.
	 * 
	 * @return The tree dialog.
	 */
	public static MultiModelTreeSelectionDialog getModelTypeCreationDialog(MultiModel multiModel) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryDialogLabelProvider(),
			new NewModelTypeDialogContentProvider(),
			multiModel
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered model relationship
	 * types.
	 * 
	 * @return The tree dialog.
	 */
	public static MultiModelTreeSelectionDialog getModelRelTypeCreationDialog(MultiModel multiModel, Model newSrcModelType, Model newTgtModelType) {

		List<String> modelRelTypeUris = null;

		if (newSrcModelType != null && newTgtModelType != null) {
			String newSrcUri = newSrcModelType.getUri();
			String newTgtUri = newTgtModelType.getUri();
			modelRelTypeUris = new ArrayList<String>();

			for (ModelRel modelRelType : getModelRelTypes(multiModel)) {
				// binary can only inherit from binary
				if (!(modelRelType instanceof BinaryModelRel)) {
					continue;
				}
				String srcUri = modelRelType.getModelEndpoints().get(0).getTargetUri();
				String tgtUri = modelRelType.getModelEndpoints().get(1).getTargetUri();
				// new model rel type with same endpoints or overriding one or two endpoints
				if (
					(newSrcUri.equals(srcUri) && newTgtUri.equals(tgtUri)) ||
					(MultiModelTypeHierarchy.isSubtypeOf(multiModel, newSrcUri, srcUri) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && MultiModelTypeHierarchy.isSubtypeOf(multiModel, newTgtUri, tgtUri)) ||
					(MultiModelTypeHierarchy.isSubtypeOf(multiModel, newSrcUri, srcUri) && MultiModelTypeHierarchy.isSubtypeOf(multiModel, newTgtUri, tgtUri))
				) {
					modelRelTypeUris.add(modelRelType.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryDialogLabelProvider(),
			new NewModelRelTypeDialogContentProvider(modelRelTypeUris),
			multiModel
		);

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered link types that can fit
	 * model element reference source and target (are both null in case of
	 * nary link).
	 * 
	 * @return The tree dialog.
	 */
	public static MultiModelTreeSelectionDialog getLinkReferenceCreationDialog(ModelRel modelRel, ModelElementReference newSrcModelElemRef, ModelElementReference newTgtModelElemRef) {

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
			new RepositoryDialogLabelProvider(),
			new RelationshipTypesDialogContentProvider(modelRelType, linkTypeUris, false),
			modelRelType
		);

		return dialog;
	}

	public static MultiModelTreeSelectionDialog getModelElementEndpointCreationDialog(LinkReference linkRef, List<String> modelElemTypeEndpointUris) {

		Link linkType = linkRef.getObject().getMetatype();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryDialogLabelProvider(),
			new RelationshipTypesDialogContentProvider((ModelRel) linkType.eContainer(), modelElemTypeEndpointUris, false),
			linkType
		);

		return dialog;
	}

	public static MultiModelTreeSelectionDialog getLinkTypeReferenceCreationDialog(ModelRel modelRelType, ModelElementReference newSrcModelElemTypeRef, ModelElementReference newTgtModelElemTypeRef) {

		List<String> linkTypeUris = null;

		if (newSrcModelElemTypeRef != null && newTgtModelElemTypeRef != null) {
			MultiModel multiModel = (MultiModel) modelRelType.eContainer();
			String newSrcUri = newSrcModelElemTypeRef.getUri();
			String newTgtUri = newTgtModelElemTypeRef.getUri();
			linkTypeUris = new ArrayList<String>();

			for (LinkReference linkTypeRef : modelRelType.getLinkRefs()) {
				// binary can only inherit from binary
				if (!(linkTypeRef instanceof BinaryLinkReference)) {
					continue;
				}
				BinaryLink linkType = ((BinaryLinkReference) linkTypeRef).getObject();
				String srcUri = linkType.getModelElemEndpoints().get(0).getTargetUri();
				String tgtUri = linkType.getModelElemEndpoints().get(1).getTargetUri();
				// new link type with same endpoints or overriding one or two endpoints
				if (
					(newSrcUri.equals(srcUri) && newTgtUri.equals(tgtUri)) ||
					(MultiModelTypeHierarchy.isSubtypeOf(multiModel, newSrcUri, srcUri) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && MultiModelTypeHierarchy.isSubtypeOf(multiModel, newTgtUri, tgtUri)) ||
					(MultiModelTypeHierarchy.isSubtypeOf(multiModel, newSrcUri, srcUri) && MultiModelTypeHierarchy.isSubtypeOf(multiModel, newTgtUri, tgtUri))
				) {
					linkTypeUris.add(linkTypeRef.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryDialogLabelProvider(),
			new RelationshipTypesDialogContentProvider(modelRelType, linkTypeUris, true),
			modelRelType
		);

		return dialog;
	}

	/**
	 * Gets a parameter's signature.
	 * 
	 * @param parameter
	 *            The parameter.
	 * @return The parameter's signature.
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
	 * Gets an operator's signature.
	 * 
	 * @param operator
	 *            The operator.
	 * @return The operator's signature.
	 */
	public static String getOperatorSignature(Operator operator) {

		// output parameters
		String signature = "[";
		for (Parameter parameter : operator.getOutputs()) {
			signature += getParameterSignature(parameter) + ", ";
		}
		if (operator.getOutputs().size() > 0) {
			signature = signature.substring(0, signature.length() - 2);
		}
		signature += "] ";

		// operator name
		signature += operator.getName() + "(";

		// input parameters
		for (Parameter parameter : operator.getInputs()) {
			signature += getParameterSignature(parameter) + ", ";
		}
		if (operator.getInputs().size() > 0) {
			signature = signature.substring(0, signature.length() - 2);
		}
		signature += ")";

		return signature;
	}

	public static Bundle getTypeBundle(String typeUri) {

		Bundle bundle = null;
		String bundleName = MMTF.bundleTable.get(typeUri);
		if (bundleName != null) {
			return Platform.getBundle(bundleName);
		}

		return bundle;
	}

}
