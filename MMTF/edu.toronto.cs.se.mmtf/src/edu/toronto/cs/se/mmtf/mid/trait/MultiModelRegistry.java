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
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.HashMap;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class MultiModelRegistry {

	public final static String EXTELEM_NULLTYPE = "NOTYPE";
	public final static String ECORE_METAMODEL_URI_SEPARATOR = "#//";
	public final static String ECORE_MODEL_FILEEXTENSION_SEPARATOR = ".";
	public final static String RESOURCE_URI_PREFIX = "platform:/resource";

	public static String getElementLabel(ExtendibleElement element) {

		String label = (element.getName() == null) ? "" : element.getName();
		if (MultiModelConstraintChecker.isInstancesLevel(element)) {
			ExtendibleElement type = element.getMetatype();
			String typeLabel = (type == null) ? EXTELEM_NULLTYPE : type.getName();
			label += " : " + typeLabel;
		}

		return label;
	}

	public static String getEndpointLabel(ExtendibleElementEndpoint endpoint) {

		String label = getElementLabel(endpoint);

		int low = endpoint.getLowerBound();
		int up = endpoint.getUpperBound();
		if (low == 0 && up == 1) {
			label += " [?]";
		}
		else if (low == 1 && up == 1) {
			// default
		}
		else if (low == 0 && up == -1) {
			label += " [*]";
		}
		else if (low == 1 && up == -1) {
			label += " [+]";
		}
		else {
			String up2 = (up == -1) ? "*" : Integer.toString(up);
			label += " [" + low + "," + up2 + "]";
		}

		return label;
	}

	public static String editElementLabel(ExtendibleElement element) {

		String name = element.getName();
		if (name == null) {
			name = "";
		}

		return name;
	}

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

	public static ModelElementCategory getEObjectCategory(EObject eObject) {

		return (eObject instanceof EReference) ?
			ModelElementCategory.RELATIONSHIP :
			ModelElementCategory.ENTITY;
	}

	public static String[] getModelAndModelElementUris(EObject eObject, boolean isInstancesLevel) {

		URI uri = EcoreUtil.getURI(eObject);
		String modelUri, modelElemUri;
		if (isInstancesLevel) {
			modelUri = uri.toPlatformString(true);
			modelElemUri = uri.toString();
			if (modelElemUri.startsWith(RESOURCE_URI_PREFIX)) {
				modelElemUri = uri.toString().substring(RESOURCE_URI_PREFIX.length());
			}
		}
		else {
			String[] pieces = uri.toString().split(ECORE_METAMODEL_URI_SEPARATOR);
			modelUri = pieces[0];
			modelElemUri = pieces[1];
		}

		return new String[] {modelUri, modelElemUri};
	}

	public static String getEObjectClassLiteral(EObject eObject, boolean isInstancesLevel) {

		String classLiteral = null;
		if (isInstancesLevel) {
			//TODO MMTF: EReference is probably wrong here, since we can't even drop it
			classLiteral = (eObject instanceof EReference) ?
				((EReference) eObject).getEContainingClass().getName() + MMTF.URI_SEPARATOR + ((EReference) eObject).getName() :
				eObject.eClass().getName();
		}
		else {
			classLiteral = (eObject instanceof EReference) ?
				((EClass) eObject.eContainer()).getName() + MMTF.URI_SEPARATOR + ((EReference) eObject).getName() :
				((EClass) eObject).getName();
		}

		return classLiteral;
	}

	public static String getEObjectLabel(EObject eObject, boolean isInstancesLevel) {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);

		return (labelProvider == null) ?
			getEObjectClassLiteral(eObject, isInstancesLevel) :
			labelProvider.getText(eObject);
	}

	private static String getLastSegmentFromUri(String uri) {

		return uri.substring(uri.lastIndexOf(MMTF.URI_SEPARATOR) + 1, uri.length());
	}

	public static String getFileNameFromUri(String uri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return lastSegmentUri.substring(0, lastSegmentUri.lastIndexOf(ECORE_MODEL_FILEEXTENSION_SEPARATOR));
	}

	public static String getFileExtensionFromUri(String uri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return lastSegmentUri.substring(lastSegmentUri.lastIndexOf(ECORE_MODEL_FILEEXTENSION_SEPARATOR) + 1, lastSegmentUri.length());
	}

	public static String replaceLastSegmentInUri(String uri, String newLastSegmentUri) {

		String lastSegmentUri = getLastSegmentFromUri(uri);

		return uri.replace(lastSegmentUri, newLastSegmentUri);
	}

	public static String replaceFileExtensionInUri(String uri, String newFileExtension) {

		String fileExtension = getFileExtensionFromUri(uri);

		return uri.replace(fileExtension, newFileExtension);
	}

	public static String addFileNameSuffixInUri(String uri, String newFileNameSuffix) {

		String fileExtension = getFileExtensionFromUri(uri);

		return uri.replace(ECORE_MODEL_FILEEXTENSION_SEPARATOR + fileExtension, newFileNameSuffix + ECORE_MODEL_FILEEXTENSION_SEPARATOR + fileExtension);
	}

	public static String prependWorkspaceToUri(String uri) {

		return ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + uri;
	}

	public static MultiModel getMultiModel(ExtendibleElement element) {

		MultiModel multiModel = null;
		if (element instanceof Model || element instanceof ModelRel || element instanceof Editor) {
			multiModel = (MultiModel) element.eContainer();
		}
		else if (element instanceof ModelElement || element instanceof Link) {
			multiModel = (MultiModel) element.eContainer().eContainer();
		}
		//TODO MMTF: to be continued..

		return multiModel;
	}

	public static MultiModel getMultiModel(ExtendibleElementReference elementRef) {

		return getMultiModel(elementRef.getObject());
	}

	/**
	 * Gets an extendible element (type or instance) from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param elementUri
	 *            The uri of the extendible element.
	 * @return The extendible element, or null if the uri is not found or found
	 *         not to be of the desired class.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ExtendibleElement> T getExtendibleElement(MultiModel multiModel, String elementUri) {

		ExtendibleElement element = multiModel.getExtendibleTable().get(elementUri);
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

}
