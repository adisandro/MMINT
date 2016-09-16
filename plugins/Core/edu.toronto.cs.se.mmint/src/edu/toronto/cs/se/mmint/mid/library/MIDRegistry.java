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
package edu.toronto.cs.se.mmint.mid.library;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mmint.reasoning.MIDConstraintChecker;

/**
 * The registry for querying a multimodel.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDRegistry {

	public final static String RESOURCE_URI_PREFIX = "platform:/resource";
	public final static String ECORE_EREFERENCE_URI_PREFIX = "@";
	public final static String ECORE_ROOT_FEATURE = "root";

	public static void addEndpointCardinality(String uri, Map<String, Integer> cardinalityTable) {

		Integer value = cardinalityTable.get(uri);
		Integer newValue = (value == null) ?
			new Integer(1) :
			new Integer(value.intValue()+1);
		cardinalityTable.put(uri, newValue);
	}

	public static void subtractEndpointCardinality(String uri, Map<String, Integer> cardinalityTable) throws MMINTException {

		Integer value = cardinalityTable.get(uri);
		if (value == null) {
			throw new MMINTException("Uri " + uri + " doesn't exist in the cardinality table");
		}
		cardinalityTable.put(uri, new Integer(value.intValue()-1));
	}

	public static boolean checkNewEndpointUpperCardinality(ExtendibleElementEndpoint typeEndpoint, Map<String, Integer> cardinalityTable) {

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

	public static String[] getModelAndModelElementUris(EObject modelObj, MIDLevel level) {

		String modelUri, modelElemUri;
		String attributeFeatureName = null;
		if (level == MIDLevel.INSTANCES && modelObj instanceof PrimitiveEObjectWrapper) {
			attributeFeatureName = ((PrimitiveEObjectWrapper) modelObj).getFeature().getName();
			modelObj = ((PrimitiveEObjectWrapper) modelObj).getOwner();
		}
		URI emfUri = EcoreUtil.getURI(modelObj);
		String uri = emfUri.toString();
		if (level == MIDLevel.INSTANCES) {
			modelElemUri = (uri.startsWith(RESOURCE_URI_PREFIX)) ? uri.substring(RESOURCE_URI_PREFIX.length()) : uri;
			modelUri = modelElemUri.substring(0, modelElemUri.indexOf(MMINT.ECORE_MODEL_URI_SEPARATOR));
			if (attributeFeatureName != null) {
				modelElemUri += MMINT.URI_SEPARATOR + attributeFeatureName;
			}
		}
		else {
			modelUri = ((EPackage) EcoreUtil.getRootContainer(modelObj)).getNsURI(); // safe against metamodels in state
			modelElemUri = modelUri + MMINT.ECORE_MODEL_URI_SEPARATOR + uri.substring(uri.indexOf(MMINT.ECORE_MODEL_URI_SEPARATOR)+MMINT.ECORE_MODEL_URI_SEPARATOR.length());
		}

		return new String[] {modelUri, modelElemUri};
	}

	//TODO MMINT[MODELELEMENT] some info here are redundant and/or misplaced, review EMFInfo
	//TODO MMINT[MODELELEMENT] add support for non-containment EReferences
	public static EMFInfo getModelElementEMFInfo(EObject modelObj, MIDLevel level) {

		EMFInfo eInfo = MIDFactory.eINSTANCE.createEMFInfo();
		String className, featureName = null, relatedClassName = null;
		boolean isAttribute = false;
		if (level == MIDLevel.INSTANCES) {
			if (modelObj instanceof PrimitiveEObjectWrapper) {
				className = ((PrimitiveEObjectWrapper) modelObj).getOwner().eClass().getName();
				featureName = ((PrimitiveEObjectWrapper) modelObj).getFeature().getName();
				isAttribute = true;
			}
			else {
				className = modelObj.eClass().getName();
				if (modelObj.eContainer() != null) {
					featureName = modelObj.eContainingFeature().getName();
					relatedClassName = modelObj.eContainer().eClass().getName();
				}
				else {
					featureName = ECORE_ROOT_FEATURE;
				}
			}
		}
		else {
			if (modelObj instanceof EStructuralFeature) {
				className = ((EClass) modelObj.eContainer()).getName();
				featureName = ((EStructuralFeature) modelObj).getName();
				isAttribute = (modelObj instanceof EAttribute);
				if (modelObj instanceof EReference) {
					relatedClassName = ((EReference) modelObj).getEType().getName();
				}
			}
			else {
				className = ((EClass) modelObj).getName();
			}
		}
		eInfo.setClassName(className);
		eInfo.setFeatureName(featureName);
		eInfo.setRelatedClassName(relatedClassName);
		eInfo.setAttribute(isAttribute);

		return eInfo;
	}

	public static String getModelElementName(EMFInfo eInfo, EObject modelObj, MIDLevel level) {

		String name;
		if (level == MIDLevel.INSTANCES) {
			ComposedAdapterFactory adapterFactory = GMFDiagramUtils.getAdapterFactory();
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
			name = eInfo.toInstanceString();
			if (modelObj instanceof PrimitiveEObjectWrapper) {
				name = name.replace(MMINT.MODELELEMENT_PRIMITIVEVALUE_PLACEHOLDER, ((PrimitiveEObjectWrapper) modelObj).getValue().toString());
				name = name.replace(MMINT.MODELELEMENT_EMFVALUE_PLACEHOLDER, labelProvider.getText(((PrimitiveEObjectWrapper) modelObj).getOwner()));
			}
			else {
				name = name.replace(MMINT.MODELELEMENT_EMFVALUE_PLACEHOLDER, labelProvider.getText(modelObj));
			}
		}
		else {
			name = eInfo.toTypeString();
		}

		return name;
	}

	/**
	 * Gets an extendible element from a MID.
	 * 
	 * @param uri
	 *            The uri of the element.
	 * @param mid
	 *            The MID that contains the element.
	 * @return The element, null if the uri is not found or found not to be of
	 *         the desired class of elements.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ExtendibleElement> @Nullable T getExtendibleElement(@NonNull String uri, @NonNull MID mid) {

		ExtendibleElement element = mid.getExtendibleTable().get(uri);
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

	public static ModelElementReference getModelElementReference(ModelEndpointReference modelEndpointRef, EObject modelObj) {

		ModelElement modelElemType = MIDConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelObj);
		String modelElemUri = MIDRegistry.getModelAndModelElementUris(modelObj, MIDLevel.INSTANCES)[1] + MMINT.ROLE_SEPARATOR + modelElemType.getUri();

		return MIDTypeHierarchy.getReference(modelElemUri, modelEndpointRef.getModelElemRefs());
	}

	public static @Nullable Diagram getModelDiagram(@NonNull Model model) {

		Diagram modelDiagram = null;
		for (Editor modelEditor : model.getEditors()) {
			if (modelEditor instanceof Diagram) {
				modelDiagram = (Diagram) modelEditor;
				break;
			}
		}

		return modelDiagram;
	}

	public static Set<Operator> getInputOperators(Model model, MID mid) {

		return mid.getOperators().stream()
			.filter(operator ->
				operator.getInputs().stream()
					.anyMatch(input -> input.getTarget() == model))
			.collect(Collectors.toSet());
	}

	public static Set<Operator> getOutputOperators(Model model, MID mid) {

		return mid.getOperators().stream()
			.filter(operator ->
				operator.getOutputs().stream()
					.anyMatch(output -> output.getTarget() == model))
			.collect(Collectors.toSet());
	}

	public static Set<Operator> getInputOutputOperators(Model model, MID mid) {

		Set<Operator> ioOperators = new HashSet<>();
		ioOperators.addAll(MIDRegistry.getInputOperators(model, mid));
		ioOperators.addAll(MIDRegistry.getOutputOperators(model, mid));

		return ioOperators;
	}

	public static Set<BinaryModelRel> getConnectedBinaryModelRels(Model model, MID mid) {

		return mid.getModelRels().stream()
			.filter(modelRel -> modelRel instanceof BinaryModelRel)
			.filter(modelRel -> modelRel.getModelEndpoints().stream()
				.anyMatch(endpoint -> endpoint.getTarget() == model))
			.map(modelRel -> (BinaryModelRel) modelRel)
			.collect(Collectors.toSet());
	}

	public static Set<ModelEndpoint> getConnectedNaryModelRelEndpoints(Model model, MID mid) {

		return mid.getModelRels().stream()
			.filter(modelRel -> !(modelRel instanceof BinaryModelRel))
			.flatMap(modelRel -> modelRel.getModelEndpoints().stream())
			.filter(endpoint -> endpoint.getTarget() == model)
			.collect(Collectors.toSet());
	}

	public static String getNextWorkflowID(MID workflowMID) {

		final String WORKFLOW_ID_PREFIX = "w";
		TreeSet<String> x = new TreeSet<>(workflowMID.getExtendibleTable().keySet());
		String lastID = x.floor(WORKFLOW_ID_PREFIX + "9999");
		int numID = (lastID == null || !lastID.startsWith(WORKFLOW_ID_PREFIX)) ? -1 : Integer.parseInt(lastID.substring(1));
		String nextID = WORKFLOW_ID_PREFIX + (numID + 1);

		return nextID;
	}

}
