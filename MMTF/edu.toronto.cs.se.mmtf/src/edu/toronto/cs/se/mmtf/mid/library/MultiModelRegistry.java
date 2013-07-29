/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.library;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * The registry for querying a multimodel.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelRegistry {

	public final static String MODEL_URI_SEPARATOR = "#";
	public final static String ECORE_MODEL_URI_SEPARATOR = MODEL_URI_SEPARATOR + "//";
	public final static String MODEL_FILEEXTENSION_SEPARATOR = ".";
	public final static String RESOURCE_URI_PREFIX = "platform:/resource";

	public static void initEndpointCardinalities(String uri, HashMap<String, Integer> cardinalityTable) {

		Integer value = cardinalityTable.get(uri);
		Integer newValue = (value == null) ?
			new Integer(1) :
			new Integer(value.intValue()+1);
		cardinalityTable.put(uri, newValue);
	}

	public static boolean checkNewEndpointUpperCardinality(ExtendibleElementEndpoint typeEndpoint, HashMap<String, Integer> cardinalityTable) {

		int upperBound = typeEndpoint.getUpperBound();
		if (upperBound == -1) {
			return true;
		}
		Integer existingEndpoints = cardinalityTable.get(typeEndpoint.getUri());
		int numEndpoints = (existingEndpoints == null) ? 0 : existingEndpoints;
		if (numEndpoints < upperBound) {
			return true;
		}

		return false;
	}

	public static ModelElementCategory getModelElementCategory(EObject modelObj) {

		return (modelObj instanceof EReference) ?
			ModelElementCategory.RELATIONSHIP :
			ModelElementCategory.ENTITY;
	}

	public static String[] getModelAndModelElementUris(EObject modelObj, boolean isInstancesLevel) {

		URI uri = EcoreUtil.getURI(modelObj);
		String modelUri, modelElemUri;
		if (isInstancesLevel) {
			modelUri = uri.toPlatformString(true);
			modelElemUri = uri.toString();
			if (modelElemUri.startsWith(RESOURCE_URI_PREFIX)) {
				modelElemUri = uri.toString().substring(RESOURCE_URI_PREFIX.length());
			}
		}
		else {
			String[] pieces = uri.toString().split(ECORE_MODEL_URI_SEPARATOR);
			modelUri = pieces[0];
			modelElemUri = pieces[1];
		}

		return new String[] {modelUri, modelElemUri};
	}

	public static String getModelElementClassLiteral(EObject modelObj, boolean isInstancesLevel) {

		String classLiteral = null;
		if (isInstancesLevel) {
			//TODO MMTF: EReference is probably wrong here, since we can't even drop it
			classLiteral = (modelObj instanceof EReference) ?
				((EReference) modelObj).getEContainingClass().getName() + MMTF.URI_SEPARATOR + ((EReference) modelObj).getName() :
				modelObj.eClass().getName();
		}
		else {
			classLiteral = (modelObj instanceof EReference) ?
				((EClass) modelObj.eContainer()).getName() + MMTF.URI_SEPARATOR + ((EReference) modelObj).getName() :
				((EClass) modelObj).getName();
		}

		return classLiteral;
	}

	public static String getModelElementName(EObject modelObj, boolean isInstancesLevel) {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);

		return (labelProvider == null) ?
			getModelElementClassLiteral(modelObj, isInstancesLevel) :
			labelProvider.getText(modelObj);
	}

	/**
	 * Gets the multimodel that contains an extendible element.
	 * 
	 * @param element
	 *            The element contained in the multimodel.
	 * @return The multimodel that contains the element.
	 */
	public static MultiModel getMultiModel(ExtendibleElement element) {

		MultiModel multiModel = null;
		if (element instanceof Model || element instanceof ModelRel || element instanceof Editor || element instanceof Operator) {
			multiModel = (MultiModel) element.eContainer();
		}
		else if (element instanceof ModelElement || element instanceof Link || element instanceof ModelEndpoint) {
			multiModel = (MultiModel) element.eContainer().eContainer();
		}
		else if (element instanceof ModelElementEndpoint) {
			multiModel = (MultiModel) element.eContainer().eContainer().eContainer();
		}

		return multiModel;
	}

	/**
	 * Gets the multimodel that contains a reference to an extendible element.
	 * 
	 * @param elementRef
	 *            The reference to the element contained in the multimodel.
	 * @return The multimodel that contains the reference to the element.
	 */
	public static MultiModel getMultiModel(ExtendibleElementReference elementRef) {

		return getMultiModel(elementRef.getObject());
	}

	/**
	 * Gets an extendible element from a multimodel.
	 * 
	 * @param uri
	 *            The uri of the element.
	 * @param multiModel
	 *            The multimodel that contains the element.
	 * @return The element, null if the uri is not found or found not to be of
	 *         the desired class of elements.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ExtendibleElement> T getExtendibleElement(String uri, MultiModel multiModel) {

		ExtendibleElement element = multiModel.getExtendibleTable().get(uri);
		if (element == null) {
			return null;
		}

		try {
			return (T) element;
		}
		catch (ClassCastException e) {
			return null;
		}
	}

	public static ModelElementReference getModelElementReference(ModelEndpointReference modelEndpointRef, ModelElement modelElemType, EObject modelObj) {

		String modelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, true)[1] + MMTF.ROLE_SEPARATOR + modelElemType.getUri();

		return MultiModelTypeHierarchy.getReference(modelElemUri, modelEndpointRef.getModelElemRefs());
	}

	public static ModelElementReference getModelElementReference(ModelEndpointReference modelEndpointRef, EObject modelObj) {

		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelObj);

		return getModelElementReference(modelEndpointRef, modelElemType, modelObj);
	}

	/**
	 * Gets the models in a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel that contains the models.
	 * @return The list of models.
	 */
	public static EList<Model> getModels(MultiModel multiModel) {

		return multiModel.getModels();
	}

	/**
	 * Gets the model relationships in a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel that contains the model relationships.
	 * @return The list of model relationships.
	 */
	public static EList<ModelRel> getModelRels(MultiModel multiModel) {

		EList<ModelRel> modelRels = new BasicEList<ModelRel>();
		for (Model model : getModels(multiModel)) {
			if (model instanceof ModelRel) {
				modelRels.add((ModelRel) model);
			}
		}

		return modelRels;
	}

	/**
	 * Gets the list of registered operators in a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * 
	 * @return The list of registered operators.
	 */
	public static EList<Operator> getOperators(MultiModel multiModel) {
	
		return multiModel.getOperators();
	}

	/**
	 * Gets the list of registered editors in a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * 
	 * @return The list of registered editors.
	 */
	public static EList<Editor> getEditors(MultiModel multiModel) {
	
		return multiModel.getEditors();
	}

}
