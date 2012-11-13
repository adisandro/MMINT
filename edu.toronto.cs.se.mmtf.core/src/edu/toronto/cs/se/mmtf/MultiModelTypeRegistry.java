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
import java.util.HashSet;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
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
import edu.toronto.cs.se.mmtf.repository.ui.MidTypesDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.MultiModelTreeSelectionDialog;
import edu.toronto.cs.se.mmtf.repository.ui.RelationshipTypesDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogSelectionValidator;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryTypesDialogLabelProvider;

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

	private static HashMap<String, HashSet<String>> getSubstitutabilityTable(MultiModel multiModel) {

		return (multiModel == MMTF.repository) ?
			MMTF.substTable :
			MMTF.substTableMID;
	}

	private static HashMap<String, HashMap<String, EList<String>>> getConversionTable(MultiModel multiModel) {

		return (multiModel == MMTF.repository) ?
			MMTF.convTable :
			MMTF.convTableMID;
	}

	public static EList<String> getSupertypeUris(String subtypeUri) {

		return getSupertypeUris(MMTF.repository, subtypeUri);
	}

	public static EList<String> getSupertypeUris(MultiModel multiModel, String subtypeUri) {

		EList<String> supertypeUris = new BasicEList<String>();
		for (String supertypeUri : getSubstitutabilityTable(multiModel).get(subtypeUri)) {
			if (getConversionTable(multiModel).get(subtypeUri).get(supertypeUri).isEmpty()) {
				supertypeUris.add(supertypeUri);
			}
		}

		return supertypeUris;
	}

	public static boolean isSubtypeOf(String subtypeUri, String supertypeUri) {

		return isSubtypeOf(MMTF.repository, subtypeUri, supertypeUri);
	}

	public static boolean isSubtypeOf(MultiModel multiModel, String subtypeUri, String supertypeUri) {

		if (getSubstitutabilityTable(multiModel) == null) {
			return false;
		}

		return
			getSubstitutabilityTable(multiModel).get(subtypeUri).contains(supertypeUri) &&
			getConversionTable(multiModel).get(subtypeUri).get(supertypeUri).isEmpty();
	}

	public static EList<String> getSubtypeUris(ExtendibleElement type) {

		return getSubtypeUris(MMTF.repository, type);
	}

	public static EList<String> getSubtypeUris(MultiModel multiModel, ExtendibleElement type) {

		EList<String> subtypeUris = new BasicEList<String>();
		if (getSubstitutabilityTable(multiModel) == null) {
			return subtypeUris;
		}

		for (ExtendibleElement subtype : multiModel.getExtendibleTable().values()) {
			if (subtype.getClass() != type.getClass()) {
				continue;
			}
			if (isSubtypeOf(multiModel, subtype.getUri(), type.getUri())) {
				subtypeUris.add(subtype.getUri());
			}
		}

		return subtypeUris;
	}

	/**
	 * Gets an extendible element type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param elementTypeUri
	 *            The uri of the extendible element type.
	 * @return The extendible element type, or null if the uri is not found.
	 */
	public static ExtendibleElement getExtendibleElementType(String elementTypeUri) {

		return MultiModelRegistry.getExtendibleElement(MMTF.repository, elementTypeUri);
	}

	/**
	 * Gets a model type from the repository.
	 * 
	 * @param modelTypeUri
	 *            The uri of the model type.
	 * @return The model type, or null if its uri is not found or found not
	 *         to be a model type.
	 */
	public static Model getModelType(String modelTypeUri) {

		return MultiModelRegistry.getModel(MMTF.repository, modelTypeUri);
	}

	/**
	 * Gets a model relationship type from the repository.
	 * 
	 * @param modelRelTypeUri
	 *            The uri of the model relationship type.
	 * @return The model relationship type, or null if its uri is not found
	 *         or found not to be a model relationship type.
	 */
	public static ModelRel getModelRelType(String modelRelTypeUri) {

		return MultiModelRegistry.getModelRel(MMTF.repository, modelRelTypeUri);
	}

	/**
	 * Gets a model element type from the repository.
	 * 
	 * @param modelElemTypeUri
	 *            The uri of the model element type.
	 * @return The model element type, or null if its uri is not found or found
	 *         not to be a model element type.
	 */
	public static ModelElement getModelElementType(String modelElemTypeUri) {

		return MultiModelRegistry.getModelElement(MMTF.repository, modelElemTypeUri);
	}

	public static ModelEndpoint getModelTypeEndpoint(MultiModel multiModel, String modelTypeEndpointUri) {

		ExtendibleElement modelTypeEndpoint = MultiModelRegistry.getExtendibleElement(multiModel, modelTypeEndpointUri);
		if (modelTypeEndpoint instanceof ModelEndpoint) {
			return (ModelEndpoint) modelTypeEndpoint;
		}
		return null;
	}

	public static ModelEndpoint getModelTypeEndpoint(String modelTypeEndpointUri) {

		return getModelTypeEndpoint(MMTF.repository, modelTypeEndpointUri);
	}

	/**
	 * Gets a link type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param linkTypeUri
	 *            The uri of the link type.
	 * @return The link type, or null if its uri is not found or found
	 *         not to be a link type.
	 */
	public static Link getLinkType(MultiModel multiModel, String linkTypeUri) {

		ExtendibleElement element = MultiModelRegistry.getExtendibleElement(multiModel, linkTypeUri);
		if (element instanceof Link) {
			return (Link) element;
		}
		return null;
	}

	/**
	 * Gets a link type from the repository.
	 * 
	 * @param linkTypeUri
	 *            The uri of the link type.
	 * @return The link type, or null if its uri is not found or
	 *         found not to be a link type.
	 */
	public static Link getLinkType(String linkTypeUri) {

		return getLinkType(MMTF.repository, linkTypeUri);
	}

	public static ModelElementEndpoint getModelElementTypeEndpoint(MultiModel multiModel, String modelElemTypeEndpointUri) {

		ExtendibleElement modelElemTypeEndpoint = MultiModelRegistry.getExtendibleElement(multiModel, modelElemTypeEndpointUri);
		if (modelElemTypeEndpoint instanceof ModelElementEndpoint) {
			return (ModelElementEndpoint) modelElemTypeEndpoint;
		}
		return null;
	}

	public static ModelElementEndpoint getModelElementTypeEndpoint(String modelElemTypeEndpointUri) {

		return getModelElementTypeEndpoint(MMTF.repository, modelElemTypeEndpointUri);
	}

	/**
	 * Gets an editor type from the repository.
	 * 
	 * @param editorTypeUri
	 *            The uri of the editor type.
	 * @return The editor type, or null if its uri is not found or found not
	 *         to be an editor type.
	 */
	public static Editor getEditorType(String editorTypeUri) {

		return MultiModelRegistry.getEditorType(MMTF.repository, editorTypeUri);
	}

	/**
	 * Gets the list of registered operator types.
	 * 
	 * @return The list of registered operator types.
	 */
	public static EList<Operator> getOperatorTypes() {

		return getOperatorTypes(MMTF.repository);
	}
	
	/**
	 * Gets the list of registered operator types in the multimodel.
	 * 
	 * @return The list of registered operator types in the multimodel.
	 */
	public static EList<Operator> getOperatorTypes(MultiModel multiModel) {

		return multiModel.getOperators();
	}

	/**
	 * Gets an operator type from a multimodel.
	 * 
	 * @param operatorTypeUri
	 *            The uri of the operator type.
	 * @return The operator type, or null if its uri is not found or found
	 *         not to be an operator type.
	 */
	public static Operator getOperatorType(MultiModel multiModel, String operatorTypeUri) {

		ExtendibleElement operatorType = MultiModelRegistry.getExtendibleElement(multiModel, operatorTypeUri);
		if (operatorType instanceof Operator) {
			return (Operator) operatorType;
		}
		return null;
	}

	/**
	 * Gets an operator type from the repository.
	 * 
	 * @param operatorTypeUri
	 *            The uri of the operator type.
	 * @return The operator type, or null if its uri is not found or found
	 *         not to be an operator type.
	 */
	public static Operator getOperatorType(String operatorTypeUri) {

		return getOperatorType(MMTF.repository, operatorTypeUri);
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

		Model model = getModelType(modelTypeUri);
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
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(MMTF.repository, null, false, true, false, true),
			MMTF.repository
		);
		dialog.setValidator(new RepositoryDialogSelectionValidator());

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

		EList<String> modelRelTypeUris = null;

		if (newSrcModel != null && newTgtModel != null) {
			modelRelTypeUris = new BasicEList<String>();
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
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(MMTF.repository, modelRelTypeUris, true, false, true, false),
			MMTF.repository
		);

		return dialog;
	}

	public static MultiModelTreeSelectionDialog getModelEndpointCreationDialog(ModelRel modelRel, EList<String> modelTypeEndpointUris) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(MMTF.repository, modelTypeEndpointUris, false, false, false, false),
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
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(multiModel, null, true, true, false, false),
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

		EList<String> modelRelTypeUris = null;

		if (newSrcModelType != null && newTgtModelType != null) {
			String newSrcUri = newSrcModelType.getUri();
			String newTgtUri = newTgtModelType.getUri();
			EList<String> newSrcSupertypeUris = getSupertypeUris(multiModel, newSrcUri);
			EList<String> newTgtSupertypeUris = getSupertypeUris(multiModel, newTgtUri);
			modelRelTypeUris = new BasicEList<String>();

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
					(newSrcSupertypeUris.contains(srcUri) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && newTgtSupertypeUris.contains(tgtUri)) ||
					(newSrcSupertypeUris.contains(srcUri) && newTgtSupertypeUris.contains(tgtUri))
				) {
					modelRelTypeUris.add(modelRelType.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(multiModel, modelRelTypeUris, true, false, true, false),
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

		EList<String> linkTypeUris = null;
		ModelRel modelRelType = modelRel.getMetatype();

		if (newSrcModelElemRef != null && newTgtModelElemRef != null) {
			linkTypeUris = new BasicEList<String>();
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
			new RepositoryTypesDialogLabelProvider(),
			new RelationshipTypesDialogContentProvider(modelRelType, linkTypeUris, false),
			modelRelType
		);

		return dialog;
	}

	public static MultiModelTreeSelectionDialog getModelElementEndpointCreationDialog(LinkReference linkRef, EList<String> modelElemTypeEndpointUris) {

		Link linkType = linkRef.getObject().getMetatype();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new RelationshipTypesDialogContentProvider((ModelRel) linkType.eContainer(), modelElemTypeEndpointUris, false),
			linkType
		);

		return dialog;
	}

	public static MultiModelTreeSelectionDialog getLinkTypeReferenceCreationDialog(ModelRel modelRelType, ModelElementReference newSrcModelElemTypeRef, ModelElementReference newTgtModelElemTypeRef) {

		EList<String> linkTypeUris = null;

		if (newSrcModelElemTypeRef != null && newTgtModelElemTypeRef != null) {
			MultiModel multiModel = (MultiModel) modelRelType.eContainer();
			String newSrcUri = newSrcModelElemTypeRef.getUri();
			String newTgtUri = newTgtModelElemTypeRef.getUri();
			EList<String> newSrcSupertypeUris = getSupertypeUris(multiModel, newSrcUri);
			EList<String> newTgtSupertypeUris = getSupertypeUris(multiModel, newTgtUri);
			linkTypeUris = new BasicEList<String>();

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
					(newSrcSupertypeUris.contains(srcUri) && newTgtUri.equals(tgtUri)) ||
					(newSrcUri.equals(srcUri) && newTgtSupertypeUris.contains(tgtUri)) ||
					(newSrcSupertypeUris.contains(srcUri) && newTgtSupertypeUris.contains(tgtUri))
				) {
					linkTypeUris.add(linkTypeRef.getUri());
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
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

	private static EList<ConversionOperator> isEligibleParameter(Model actualParameter, Model formalParameter) {

		EList<String> actualUris = new BasicEList<String>();
		EList<ExtendibleElement> runtimeTypes = MultiModelTypeIntrospection.getRuntimeTypes(actualParameter);
		for (int i = 0; i < runtimeTypes.size(); i++) {
			actualUris.add(
				((Model) runtimeTypes.get(i)).getUri()
			);
		}

		String formalUri = formalParameter.getUri();
		EList<ConversionOperator> result = new BasicEList<ConversionOperator>();

		// substitutable type
		if (!actualUris.contains(formalUri)) {
nextRuntimeType:
			for (String actualUri : actualUris) {
				if (getSubstitutabilityTable(MMTF.repository).get(actualUri).contains(formalUri)) {
					// use first substitution found
					for (String conversionUri : getConversionTable(MMTF.repository).get(actualUri).get(formalUri)) {
						Operator operatorType = getOperatorType(conversionUri);
						if (operatorType == null || !(operatorType instanceof ConversionOperator)) {
							result.clear();
							continue nextRuntimeType;
						}
						result.add((ConversionOperator) operatorType);
					}
					break;
				}
			}
		}

		return result;
	}

	public static EList<Operator> getExecutableOperators(EList<Model> actualParameters, EList<HashMap<Integer, EList<ConversionOperator>>> conversions) {

		EList<Operator> executableOperators = new BasicEList<Operator>();

nextOperator:
		for (Operator operator : getOperatorTypes()) {
			int i = 0;
			HashMap<Integer, EList<ConversionOperator>> conversionMap = new HashMap<Integer, EList<ConversionOperator>>();
			for (Parameter parameter : operator.getInputs()) {
				// check 1: not enough actual parameters
				if (i >= actualParameters.size()) {
					continue nextOperator;
				}
				// check 2: type or substitutable types
				while (i < actualParameters.size()) {
					EList<ConversionOperator> conversionList = isEligibleParameter(actualParameters.get(i), parameter.getModel());
					if (conversionList == null) {
						continue nextOperator;
					}
					if (!conversionList.isEmpty()) {
						conversionMap.put(new Integer(i), conversionList);
					}
					i++;
					if (!parameter.isVararg()) {
						//TODO MMTF: introduce vararg with low multeplicity
						break;
					}
				}
			}
			// check 3: too many actual parameters
			if (i < actualParameters.size()) {
				continue nextOperator;
			}
			// checks passed
			executableOperators.add(operator);
			conversions.add(conversionMap);
		}

		return executableOperators;
	}

}
