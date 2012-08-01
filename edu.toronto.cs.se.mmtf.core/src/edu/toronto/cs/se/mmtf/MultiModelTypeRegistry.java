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

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.repository.ui.MidTypesDialogContentProvider;
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
		else if (type instanceof ModelElement) {
			if (((ModelElement) type).getCategory() == ModelElementCategory.ENTITY) {
				rootUri = MMTF.ROOT_MODELELEMENT_ENTITY_URI;
			}
			else if (((ModelElement) type).getCategory() == ModelElementCategory.RELATIONSHIP) {
				rootUri = MMTF.ROOT_MODELELEMENT_RELATIONSHIP_URI;
			}
		}
		else if (type instanceof Link) {
			rootUri = MMTF.ROOT_MODELREL_LINK_URI;
		}
		//TODO MMTF: root text editor and operator?

		return rootUri;
	}

	public static EList<String> getSupertypeUris(String subtypeUri) {

		EList<String> supertypeUris = new BasicEList<String>();
		for (String supertypeUri : MMTF.substitutabilityTable.get(subtypeUri)) {
			if (MMTF.conversionTable.get(subtypeUri).get(supertypeUri).isEmpty()) {
				supertypeUris.add(supertypeUri);
			}
		}

		return supertypeUris;
	}

	public static boolean isSubtypeOf(String subtypeUri, String supertypeUri) {

		return
			MMTF.substitutabilityTable.get(subtypeUri).contains(supertypeUri) &&
			MMTF.conversionTable.get(subtypeUri).get(supertypeUri).isEmpty();
	}

	public static EList<String> getSubtypeUris(ExtendibleElement type) {

		EList<String> subtypeUris = new BasicEList<String>();
		for (ExtendibleElement subtype : MMTF.repository.getExtendibleTable().values()) {
			if (subtype.getClass() != type.getClass()) {
				continue;
			}
			if (isSubtypeOf(subtype.getUri(), type.getUri())) {
				subtypeUris.add(subtype.getUri());
			}
		}

		return subtypeUris;
	}

	/**
	 * Gets an extendible type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param uri
	 *            The uri of the extendible type.
	 * @return The extendible type, or null if uri is not found.
	 */
	public static ExtendibleElement getExtendibleType(MultiModel multiModel, String uri) {

		return multiModel.getExtendibleTable().get(uri);
	}

	/**
	 * Gets an extendible type from the repository.
	 * 
	 * @param uri
	 *            The uri of the extendible type.
	 * @return The extendible type, or null if uri is not found.
	 */
	public static ExtendibleElement getExtendibleType(String uri) {

		return getExtendibleType(MMTF.repository, uri);
	}

	/**
	 * Gets a model type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param modelTypeUri
	 *            The uri of the model type.
	 * @return The model type, or null if its uri is not found or found not
	 *         to be a model type.
	 */
	public static Model getModelType(MultiModel multiModel, String modelTypeUri) {

		ExtendibleElement modelType = getExtendibleType(multiModel, modelTypeUri);
		if (modelType instanceof Model) {
			return (Model) modelType;
		}
		return null;
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

		return getModelType(MMTF.repository, modelTypeUri);
	}

	/**
	 * Gets a model relationship type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param modelRelTypeUri
	 *            The uri of the model relationship type.
	 * @return The model relationship type, or null if its uri is not found
	 *         or found not to be a model relationship type.
	 */
	public static ModelRel getModelRelType(MultiModel multiModel, String modelRelTypeUri) {

		ExtendibleElement modelRelType = getExtendibleType(multiModel, modelRelTypeUri);
		if (modelRelType instanceof ModelRel) {
			return (ModelRel) modelRelType;
		}
		return null;
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

		return getModelRelType(MMTF.repository, modelRelTypeUri);
	}

	/**
	 * Gets a model element type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param modelElemTypeUri
	 *            The uri of the model element type.
	 * @return The model element type, or null if its uri is not found or found
	 *         not to be a model element type.
	 */
	public static ModelElement getModelElementType(MultiModel multiModel, String modelElemTypeUri) {

		ExtendibleElement element = getExtendibleType(modelElemTypeUri);
		if (element instanceof ModelElement) {
			return (ModelElement) element;
		}
		return null;
	}

	/**
	 * Gets a model element type from the repository.
	 * 
	 * @param modelElemTypeUri
	 *            The uri of the model element type.
	 * @return The model element type, or null if its uri is not found or
	 *         found not to be a model element type.
	 */
	public static ModelElement getModelElementType(String modelElemTypeUri) {

		return getModelElementType(MMTF.repository, modelElemTypeUri);
	}

	/**
	 * Gets an editor type.
	 * 
	 * @param editorTypeUri
	 *            The uri of the editor type.
	 * @return The editor type, or null if its uri is not found or found
	 *         not to be an editor.
	 */
	public static Editor getEditorType(String editorTypeUri) {

		ExtendibleElement editorType = getExtendibleType(editorTypeUri);
		if (editorType instanceof Editor) {
			return (Editor) editorType;
		}
		return null;
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

		ExtendibleElement operatorType = getExtendibleType(multiModel, operatorTypeUri);
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

		return MMTF.repository.getModels();
	}

	/**
	 * Gets the list of registered model relationship types.
	 * 
	 * @return The list of registered model relationship types.
	 */
	public static EList<ModelRel> getModelRelTypes() {

		EList<ModelRel> modelRels = new BasicEList<ModelRel>();
		for (Model model : getModelTypes()) {
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
	public static ElementTreeSelectionDialog getModelCreationDialog() {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(MMTF.repository, null, false, true, false, true)
		);
		dialog.setValidator(new RepositoryDialogSelectionValidator());
		dialog.setInput(MMTF.repository);

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered model relationship
	 * types that can fit model source and target (are both null in case of
	 * nary model relationship).
	 * 
	 * @return The tree dialog.
	 */
	public static ElementTreeSelectionDialog getModelRelCreationDialog(Model source, Model target) {

		EList<String> modelRelTypeUris = null;

		if (source != null && target != null) {

			String sourceTypeUri = source.getMetatypeUri();
			EList<String> sourceSupertypeUris = getSupertypeUris(sourceTypeUri);
			String targetTypeUri = target.getMetatypeUri();
			EList<String> targetSupertypeUris = getSupertypeUris(targetTypeUri);
			modelRelTypeUris = new BasicEList<String>();

			for (ModelRel modelRelType : getModelRelTypes()) {

				// check cardinality
				if (!(modelRelType.isUnbounded() || modelRelType instanceof BinaryModelRel)) {
					continue;
				}
				// check allowed model types
				boolean okSource = false;
				boolean okTarget = false;
				for (Model modelType : modelRelType.getModels()) {
					String modelTypeUri = modelType.getUri();
					if (!okSource && (modelTypeUri.equals(sourceTypeUri) || sourceSupertypeUris.contains(modelTypeUri))) {
						okSource = true;
					}
					if (!okTarget && (modelTypeUri.equals(targetTypeUri) || targetSupertypeUris.contains(modelTypeUri))) {
						okTarget = true;
					}
					if (okSource && okTarget) {
						modelRelTypeUris.add(modelRelType.getUri());
						break;
					}
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(MMTF.repository, modelRelTypeUris, true, false, true, false)
		);
		dialog.setInput(MMTF.repository);

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered link types that can fit
	 * model element reference source and target (are both null in case of
	 * nary link).
	 * 
	 * @return The tree dialog.
	 */
	public static ElementTreeSelectionDialog getLinkCreationDialog(ModelRel modelRel, ModelElementReference source, ModelElementReference target) {

		EList<String> linkTypeUris = null;
		ModelRel modelRelType = modelRel.getMetatype();

		if (source != null && target != null) {

			//TODO MMTF: supertypes are not computed yet for model elements and links, do I really need them?
			String sourceTypeUri = source.getObject().getMetatypeUri();
			EList<String> sourceSupertypeUris = new BasicEList<String>();
			//EList<String> sourceSupertypeUris = getSupertypeUris(sourceTypeUri);
			String targetTypeUri = target.getObject().getMetatypeUri();
			EList<String> targetSupertypeUris = new BasicEList<String>();
			//EList<String> targetSupertypeUris = getSupertypeUris(targetTypeUri);
			linkTypeUris = new BasicEList<String>();

			for (Link linkType : getLinkTypes(modelRelType)) {

				// check cardinality
				if (!(linkType.isUnbounded() || linkType instanceof BinaryLink)) {
					continue;
				}
				// check allowed model element types
				//TODO MMTF: here I shoud check direction and actual endpoint for binary differently than nary
				boolean okSource = false;
				boolean okTarget = false;
				for (ModelElementReference elementTypeRef : linkType.getElementRefs()) {
					String elementTypeUri = elementTypeRef.getObject().getUri();
					if (!okSource && (elementTypeUri.equals(sourceTypeUri) || sourceSupertypeUris.contains(elementTypeUri))) {
						okSource = true;
					}
					if (!okTarget && (elementTypeUri.equals(targetTypeUri) || targetSupertypeUris.contains(elementTypeUri))) {
						okTarget = true;
					}
					if (okSource && okTarget) {
						linkTypeUris.add(linkType.getUri());
						break;
					}
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new RelationshipTypesDialogContentProvider(modelRelType, linkTypeUris, true)
		);
		dialog.setInput(modelRelType);

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered model types.
	 * 
	 * @return The tree dialog.
	 */
	public static ElementTreeSelectionDialog getModelTypeCreationDialog(MultiModel multiModel) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(multiModel, null, true, true, false, false)
		);
		dialog.setInput(multiModel);

		return dialog;
	}

	/**
	 * Gets a tree dialog to select among registered model relationship
	 * types.
	 * 
	 * @return The tree dialog.
	 */
	public static ElementTreeSelectionDialog getModelRelTypeCreationDialog(MultiModel multiModel, String srcModelTypeUri, String tgtModelTypeUri) {

		EList<String> modelRelTypeUris = null;

		if (srcModelTypeUri != null && tgtModelTypeUri != null) {

			EList<String> srcSupertypeUris = getSupertypeUris(srcModelTypeUri);
			EList<String> tgtSupertypeUris = getSupertypeUris(tgtModelTypeUri);
			modelRelTypeUris = new BasicEList<String>();

			for (ModelRel modelRelType : getModelRelTypes()) {

				// check cardinality
				if (!(modelRelType.isUnbounded() || modelRelType instanceof BinaryModelRel)) {
					continue;
				}
				// check allowed model types
				boolean okSrc = false;
				boolean okTgt = false;
				for (Model modelType : modelRelType.getModels()) {
					String modelTypeUri = modelType.getUri();
					if (!okSrc && (modelTypeUri.equals(srcModelTypeUri) || srcSupertypeUris.contains(modelTypeUri))) {
						okSrc = true;
					}
					if (!okTgt && (modelTypeUri.equals(tgtModelTypeUri) || tgtSupertypeUris.contains(modelTypeUri))) {
						okTgt = true;
					}
					if (okSrc && okTgt) {
						modelRelTypeUris.add(modelRelType.getUri());
						break;
					}
				}
			}
		}

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
			shell,
			new RepositoryTypesDialogLabelProvider(),
			new MidTypesDialogContentProvider(multiModel, modelRelTypeUris, true, false, true, false)
		);
		dialog.setInput(multiModel);

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
		for (int i = 0; i < actualParameter.getRuntimeMetatypes().size(); i++) {
			actualUris.add(
				((Model) actualParameter.getRuntimeMetatypes().get(i)).getUri()
			);
		}
		String formalUri = formalParameter.getUri();
		EList<ConversionOperator> result = null;

		// exact type
		if (actualUris.contains(formalUri)) {
			result = new BasicEList<ConversionOperator>();
		}
		// substitutable type
		else {
			for (String actualUri : actualUris) {
				if (MMTF.substitutabilityTable.get(actualUri).contains(formalUri)) {
					// use first substitution found
					result = MMTF.conversionTable.get(actualUri).get(formalUri);
					break;
				}
			}
		}

		return result;
	}

	public static EList<Operator> getExecutableOperators(EList<Model> actualParameters, EList<HashMap<Integer, EList<ConversionOperator>>> conversions) {

		EList<Operator> executableOperators = new BasicEList<Operator>();

nextOperator:
		for (Operator operator : MMTF.repository.getOperators()) {
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

	public static EObject getModelTypeMetamodelElement(Model modelType, String metamodelFragment) {

		String[] literals = metamodelFragment.split("/");
		EObject elemPointer = ((EPackage) modelType.getRoot()).getEClassifier(literals[0]);
		if (literals.length > 1) {
			elemPointer = ((EClass) elemPointer).getEStructuralFeature(literals[1]);
		}

		return elemPointer;
	}

	public static String getDroppedElementClassLiteral(MidLevel level, EObject droppedElement) {

		String classLiteral;
		if (level == MidLevel.TYPES) {
			classLiteral = (droppedElement instanceof EReference) ?
				((EReference) droppedElement).getEContainingClass().getName() + "/" + ((EReference) droppedElement).getName() :
				((EClass) droppedElement).getName();
		}
		else {
			//TODO MMTF: EReference is probably wrong here, we should try
			classLiteral = (droppedElement instanceof EReference) ?
				((EReference) droppedElement).getEContainingClass().getName() + "/" + ((EReference) droppedElement).getName() :
				droppedElement.eClass().getName();
		}

		return classLiteral;
	}

}
