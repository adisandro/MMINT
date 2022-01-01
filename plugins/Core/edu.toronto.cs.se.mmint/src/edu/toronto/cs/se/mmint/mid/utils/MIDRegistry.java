/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
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

import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;

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

	/**
	 * Gets a reference to an extendible element in a list of references to
	 * extendible elements.
	 *
	 * @param elementUri
	 *            The uri of the extendible element.
	 * @param elementRefs
	 *            The list of references to extendible elements.
	 * @return The reference to the extendible element, null if it can't be
	 *         found.
	 */
	public static <T extends ExtendibleElementReference> T getReference(String elementUri, EList<T> elementRefs) {

		if (elementUri == null) {
			return null;
		}

		for (T elementRef : elementRefs) {
			if (elementUri.equals(elementRef.getUri())) {
				return elementRef;
			}
		}

		return null;
	}

	/**
	 * Gets a reference to an extendible element in a list of references to
	 * extendible elements.
	 *
	 * @param correspondingElementRef
	 *            The corresponding reference to extendible element, i.e. a
	 *            reference to an extendible element with the same uri of the
	 *            one to get.
	 * @param elementRefs
	 *            The list of references to extendible elements.
	 * @return The reference to the extendible element, null if it can't be
	 *         found.
	 */
	public static <T extends ExtendibleElementReference> T getReference(T correspondingElementRef, EList<T> elementRefs) {

		if (correspondingElementRef == null) {
			return null;
		}

		return getReference(correspondingElementRef.getUri(), elementRefs);
	}

	/**
	 * Gets the extendible element endpoints in a list of extendible element
	 * endpoints.
	 *
	 * @param targetUri
	 *            The uri of the extendible element which is the target of the
	 *            endpoint.
	 * @param endpoints
	 *            The list of extendible element endpoints.
	 * @return The extendible element endpoints.
	 */
	public static <T extends ExtendibleElementEndpoint> List<T> getEndpoints(String targetUri, EList<T> endpoints) {

		if (targetUri == null) {
			return null;
		}

		List<T> targetEndpoints = new ArrayList<>();
		for (T endpoint : endpoints) {
			if (targetUri.equals(endpoint.getTargetUri())) {
				targetEndpoints.add(endpoint);
			}
		}

		return targetEndpoints;
	}

	/**
	 * Gets the references to an extendible element endpoint in a list of
	 * references to extendible element endpoints.
	 *
	 * @param targetUri
	 *            The uri of the extendible element which is the target of the
	 *            endpoint.
	 * @param endpointRefs
	 *            The list of references to extendible element endpoints.
	 * @return The references to the extendible element endpoints.
	 */
	public static <T extends ExtendibleElementEndpointReference> List<T> getEndpointReferences(String targetUri, EList<T> endpointRefs) {

		if (targetUri == null) {
			return null;
		}

		List<T> targetEndpointRefs = new ArrayList<>();
		for (T endpointRef : endpointRefs) {
			if (targetUri.equals(endpointRef.getTargetUri())) {
				targetEndpointRefs.add(endpointRef);
			}
		}

		return targetEndpointRefs;
	}

	public static void addEndpointCardinality(String uri, Map<String, Integer> cardinalityTable) {

		var value = cardinalityTable.get(uri);
		Integer newValue = (value == null) ?
			new Integer(1) :
			new Integer(value.intValue()+1);
		cardinalityTable.put(uri, newValue);
	}

	public static void subtractEndpointCardinality(String uri, Map<String, Integer> cardinalityTable) throws MMINTException {

		var value = cardinalityTable.get(uri);
		if (value == null) {
			throw new MMINTException("Uri " + uri + " doesn't exist in the cardinality table");
		}
		cardinalityTable.put(uri, new Integer(value.intValue()-1));
	}

	public static boolean checkNewEndpointUpperCardinality(ExtendibleElementEndpoint typeEndpoint, Map<String, Integer> cardinalityTable) {

		var upperBound = typeEndpoint.getUpperBound();
		if (upperBound == -1) {
			return true;
		}
		var existingEndpoints = cardinalityTable.get(typeEndpoint.getUri());
		var numEndpoints = (existingEndpoints == null) ? 0 : existingEndpoints;
		if (numEndpoints < upperBound) {
			return true;
		}

		return false;
	}

	public static @NonNull String getModelUri(@NonNull String modelObjUri) {

	    var sep = modelObjUri.lastIndexOf(MMINTConstants.MODEL_URI_SEPARATOR);
	    if (sep == -1) {
	        return modelObjUri;
	    }

        return modelObjUri.substring(0, sep);
	}

	public static @NonNull String getModelUri(@NonNull EObject modelObj) {

		String modelUri;
		if (modelObj instanceof EClass || modelObj instanceof EStructuralFeature) { // MIDLevel.TYPES
			modelUri = ((EPackage) EcoreUtil.getRootContainer(modelObj)).getNsURI(); // safe against metamodels in state
		}
		else { // MIDLevel.INSTANCES
			if (modelObj instanceof PrimitiveEObjectWrapper) { // unwrap
				modelObj = ((PrimitiveEObjectWrapper) modelObj).getOwner();
			}
			var emfUri = EcoreUtil.getURI(modelObj).toString();
			if (emfUri.startsWith(MIDRegistry.RESOURCE_URI_PREFIX)) {
				emfUri = emfUri.substring(MIDRegistry.RESOURCE_URI_PREFIX.length());
			}
			modelUri = MIDRegistry.getModelUri(emfUri);
		}

		return modelUri;
	}

	public static @NonNull String getModelElementUri(@NonNull EObject modelObj) {

		String modelElemUri;
		var emfUri = EcoreUtil.getURI(modelObj).toString();
		if (modelObj instanceof EClass || modelObj instanceof EStructuralFeature) { // MIDLevel.TYPES
			String metamodelUri = MIDRegistry.getModelUri(modelObj);
			modelElemUri = metamodelUri + MMINTConstants.ECORE_MODEL_URI_SEPARATOR + emfUri.substring(emfUri.indexOf(MMINTConstants.ECORE_MODEL_URI_SEPARATOR)+MMINTConstants.ECORE_MODEL_URI_SEPARATOR.length());
		}
		else { // MIDLevel.INSTANCES
			String attributeFeatureName = null;
			if (modelObj instanceof PrimitiveEObjectWrapper) { // unwrap
				attributeFeatureName = ((PrimitiveEObjectWrapper) modelObj).getFeature().getName();
				modelObj = ((PrimitiveEObjectWrapper) modelObj).getOwner();
			}
			if (emfUri.startsWith(MIDRegistry.RESOURCE_URI_PREFIX)) {
				emfUri = emfUri.substring(MIDRegistry.RESOURCE_URI_PREFIX.length());
			}
			modelElemUri = emfUri;
			if (attributeFeatureName != null) {
				modelElemUri += MMINTConstants.URI_SEPARATOR + attributeFeatureName;
			}
		}

		return modelElemUri;
	}

	//TODO MMINT[OO] Remove when switching to ModelElementIntermediate owned by ModelElementReference
    public static @NonNull String getModelObjectUri(@NonNull ModelElement modelElem) {

        return modelElem.getUri().substring(0, modelElem.getUri().indexOf(MMINTConstants.ROLE_SEPARATOR));
    }

	//TODO MMINT[MODELELEMENT] some info here are redundant and/or misplaced, review EMFInfo
	//TODO MMINT[MODELELEMENT] add support for non-containment EReferences
	public static EMFInfo getModelElementEMFInfo(EObject modelObj, MIDLevel level) {

		var eInfo = MIDFactory.eINSTANCE.createEMFInfo();
		String className, featureName = null, relatedClassName = null;
		var isAttribute = false;
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
					featureName = MIDRegistry.ECORE_ROOT_FEATURE;
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
			ComposedAdapterFactory adapterFactory = GMFUtils.getAdapterFactory();
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
			name = eInfo.toInstanceString();
			if (modelObj instanceof PrimitiveEObjectWrapper) {
				name = name.replace(MMINTConstants.MODELELEMENT_PRIMITIVEVALUE_PLACEHOLDER, ((PrimitiveEObjectWrapper) modelObj).getValue().toString());
				name = name.replace(MMINTConstants.MODELELEMENT_EMFVALUE_PLACEHOLDER, labelProvider.getText(((PrimitiveEObjectWrapper) modelObj).getOwner()));
			}
			else {
				name = name.replace(MMINTConstants.MODELELEMENT_EMFVALUE_PLACEHOLDER, labelProvider.getText(modelObj));
			}
		}
		else {
			name = eInfo.toTypeString();
		}

		return name;
	}

	public static ModelElementReference getModelElementReference(ModelEndpointReference modelEndpointRef, EObject modelObj) {

		ModelElement modelElemType = MIDConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelObj);
		var modelElemUri = MIDRegistry.getModelElementUri(modelObj) + MMINTConstants.ROLE_SEPARATOR + modelElemType.getUri();

		return MIDRegistry.getReference(modelElemUri, modelEndpointRef.getModelElemRefs());
	}

	public static @Nullable Diagram getModelDiagram(@NonNull Model model) {

		Diagram modelDiagram;
		try {
			modelDiagram = (Diagram) model.getEditors().stream()
				.filter(editor -> editor instanceof Diagram)
				.findFirst()
				.get();
		}
		catch (NoSuchElementException e) {
			MMINTException.print(IStatus.WARNING, "No diagram registered for model " + model.getName() + ", returning null", e);
			modelDiagram = null;
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

  public static @NonNull LinkedHashMap<Model, String> getInputOutputWorkflowModels(@NonNull MID workflowMID) {

    var inoutWorkflowModels = new LinkedHashMap<Model, String>();
    for (var workflowModel : workflowMID.getModels()) {
      var isInput = MIDRegistry.getOutputOperators(workflowModel, workflowMID).isEmpty();
      var isOutput = MIDRegistry.getInputOperators(workflowModel, workflowMID).isEmpty();
      // 1) model that is in the workflow just as endpoint of input/output rels
      // 2) intermediate model/rel
      if ((isInput && isOutput) || (!isInput && !isOutput)) {
        continue;
      }
      // 3) input model/rel
      // 4) output model/rel
      var inout = (isInput) ?
        OperatorPackage.eINSTANCE.getOperator_Inputs().getName() :
        OperatorPackage.eINSTANCE.getOperator_Outputs().getName();
      inoutWorkflowModels.put(workflowModel, inout);
    }

    return inoutWorkflowModels;
  }

  public static Set<ModelRel> getConnectedModelRels(Model model, MID mid) {
    //TODO MMINT[OO] This is expensive, need a direct way to reach model rels from models
    return mid.getModelRels().stream()
      .filter(modelRel -> modelRel.getModelEndpoints().stream()
        .anyMatch(endpoint -> endpoint.getTarget() == model))
      .collect(Collectors.toSet());
  }

	public static Set<BinaryModelRel> getConnectedBinaryModelRels(Model model, MID mid) {
	  return getConnectedModelRels(model, mid).stream()
	    .filter(modelRel -> modelRel instanceof BinaryModelRel)
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

		final var WORKFLOW_ID_PREFIX = "w";
		TreeSet<String> x = new TreeSet<>(workflowMID.getExtendibleTable().keySet());
		var lastID = x.floor(WORKFLOW_ID_PREFIX + "9999");
		var numID = (lastID == null || !lastID.startsWith(WORKFLOW_ID_PREFIX)) ? -1 : Integer.parseInt(lastID.substring(1));
		var nextID = WORKFLOW_ID_PREFIX + (numID + 1);

		return nextID;
	}

}
