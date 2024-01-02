/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.PrimitiveEObjectWrapper;

public class ModelRelTypeTransformation extends ConversionOperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "src";
	public final static @NonNull String OUT_MODEL = "tgt";
	protected final static @NonNull String OUT_MODELREL = "trace";
	private final static @NonNull String GENERIC_MODELRELTYPE = "MR";
	// constants
	protected final static @NonNull String TRANSFORMATION_SUFFIX = "_transformed";

	protected EObject tgtRootModelObj;
	protected String tgtModelPath;

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean checkGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, List<OperatorInput> inputs) {

			var modelRelType = (ModelRel) genericType;
			// check 1: satisfies transformation constraint
			if (!(new ModelRelTypeTransformationConstraint().check(modelRelType))) {
				return false;
			}
			var srcModel = inputs.get(0).getModel();
			// check 2: allowed source model
			if (
				!MIDConstraintChecker.isAllowedModelEndpoint(modelRelType.getModelEndpointRefs().get(0), srcModel, new HashMap<String, Integer>()) && (
					modelRelType instanceof BinaryModelRel || // mandatory direction
					!MIDConstraintChecker.isAllowedModelEndpoint(modelRelType.getModelEndpointRefs().get(1), srcModel, new HashMap<String, Integer>())
				)
			) {
				return false;
			}

			return true;
		}
	}

	private void init() {

		// state
		this.tgtRootModelObj = null;
	}

	@SuppressWarnings("unchecked")
	protected EObject transformModelObj(ModelEndpointReference srcModelTypeEndpointRef, EObject srcModelObj, Map<EObject, ModelElementReference> srcModelObjs, ModelEndpointReference tgtModelTypeEndpointRef, Map<EObject, EObject> tgtModelObjs) throws MMINTException {

		var tgtModelElemTypeRef = srcModelObjs.get(srcModelObj);
		var tgtModelTypeObj = (EClass) tgtModelElemTypeRef.getObject().getEMFTypeObject();
		var tgtModelObj = tgtModelTypeObj.getEPackage().getEFactoryInstance().create(tgtModelTypeObj);
		var srcContainerModelObj = srcModelObj.eContainer();
		if (srcContainerModelObj == null) { // root found
			this.tgtRootModelObj = tgtModelObj;
		}
		else {
			var tgtContainerModelObj = tgtModelObjs.get(srcContainerModelObj);
			if (tgtContainerModelObj == null) {
				// recursion
				tgtContainerModelObj = transformModelObj(srcModelTypeEndpointRef, srcContainerModelObj, srcModelObjs, tgtModelTypeEndpointRef, tgtModelObjs);
			}
			// find containment based on model element types first, then fallback to first one available
			String srcModelElemTypeContainmentUri = MIDRegistry.getModelElementUri(srcModelObj.eContainingFeature());
			ModelElementReference srcModelElemTypeContainment = MIDRegistry.getReference(srcModelElemTypeContainmentUri, srcModelTypeEndpointRef.getModelElemRefs());
			EReference containmentReference = null, fallbackContainmentReference = null;
			for (EReference containment : tgtContainerModelObj.eClass().getEAllContainments()) {
				if (MIDConstraintChecker.instanceofEMFClass(tgtModelObj, containment.getEType().getName())) {
					String tgtModelElemTypeContainmentUri = MIDRegistry.getModelElementUri(containment);
					ModelElementReference tgtModelElemTypeContainment = MIDRegistry.getReference(tgtModelElemTypeContainmentUri, tgtModelTypeEndpointRef.getModelElemRefs());
					if (
						tgtModelElemTypeContainment == null ||
						srcModelElemTypeContainment.getModelElemEndpointRefs().get(0).eContainer() != tgtModelElemTypeContainment.getModelElemEndpointRefs().get(0).eContainer()
					) {
						if (fallbackContainmentReference == null) {
							fallbackContainmentReference = containment;
						}
						continue;
					}
					containmentReference = containment;
					break;
				}
			}
			if (containmentReference == null) {
				containmentReference = fallbackContainmentReference;
			}
			var containment = tgtContainerModelObj.eGet(containmentReference);
			if (containment instanceof EList) {
				((EList<EObject>) containment).add(tgtModelObj);
			}
			else {
				tgtContainerModelObj.eSet(containmentReference, tgtModelObj);
			}
		}
		tgtModelObjs.put(srcModelObj, tgtModelObj);

		return tgtModelObj;
	}

	@SuppressWarnings("unchecked")
	protected void transformModelObjFeature(EObject srcModelObj, String srcFeatureName, EObject tgtModelObj, String tgtFeatureName, List<PrimitiveEObjectWrapper> primitiveSrcModelObjs, List<PrimitiveEObjectWrapper> primitiveTgtModelObjs, Map<EObject, EObject> tgtModelObjs) {

		EStructuralFeature srcFeature = srcModelObj.eClass().getEStructuralFeature(srcFeatureName), tgtFeature = tgtModelObj.eClass().getEStructuralFeature(tgtFeatureName);
		if (srcFeature instanceof EReference && ((EReference) srcFeature).isContainment()) {
			return;
		}
		try {
			var value = srcModelObj.eGet(srcFeature);
			if (srcFeature instanceof EReference) {
				if (value instanceof EList<?>) {
					for (EObject srcRefModelObj : (EList<EObject>) value) {
						var tgtRefModelObj = tgtModelObjs.get(srcRefModelObj);
						if (tgtRefModelObj == null) {
							continue;
						}
						FileUtils.setModelObjectFeature(tgtModelObj, tgtFeatureName, tgtRefModelObj);
					}
				}
				else {
					var srcRefModelObj = (EObject) value;
					var tgtRefModelObj = tgtModelObjs.get(srcRefModelObj);
					if (tgtRefModelObj != null) {
						FileUtils.setModelObjectFeature(tgtModelObj, tgtFeatureName, tgtRefModelObj);
					}
				}
			}
			else { // srcFeature instanceof EAttribute
				FileUtils.setModelObjectFeature(tgtModelObj, tgtFeatureName, value);
				primitiveSrcModelObjs.add(new PrimitiveEObjectWrapper(srcModelObj, srcFeature, value));
				primitiveTgtModelObjs.add(new PrimitiveEObjectWrapper(tgtModelObj, tgtFeature, value));
			}
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.INFO, "Error transforming model object feature, skipping it", e);
		}
	}

	protected void transform(BinaryModelRel traceModelRel, Model srcModel, int srcIndex, int tgtIndex) throws Exception {

		var traceModelRelType = traceModelRel.getMetatype();
		var srcModelTypeEndpointRef = traceModelRelType.getModelEndpointRefs().get(srcIndex);
		var tgtModelTypeEndpointRef = traceModelRelType.getModelEndpointRefs().get(tgtIndex);
		Map<EObject, ModelElementReference> srcModelObjs = new LinkedHashMap<>();
		var srcModelObjsIter = srcModel.getEMFInstanceRoot().eResource().getAllContents();
		// first pass: get model objects to be transformed
		while (srcModelObjsIter.hasNext()) {
			var srcModelObj = srcModelObjsIter.next();
			ModelElement srcModelElemType = MIDConstraintChecker.getAllowedModelElementType(traceModelRel.getModelEndpointRefs().get(0), srcModelObj);
			if (srcModelElemType == null) {
				continue;
			}
			ModelElementReference srcModelElemTypeRef = MIDRegistry.getReference(srcModelElemType.getUri(), srcModelTypeEndpointRef.getModelElemRefs());
			var tgtModelElemTypeRef = ((MappingReference) srcModelElemTypeRef.getModelElemEndpointRefs().get(0).eContainer()).getModelElemEndpointRefs().get(tgtIndex).getModelElemRef();
			srcModelObjs.put(srcModelObj, tgtModelElemTypeRef);
		}
		// second pass: transform
		Map<EObject, EObject> tgtModelObjs = new LinkedHashMap<>();
		for (EObject srcModelObj : srcModelObjs.keySet()) {
			if (tgtModelObjs.get(srcModelObj) != null) { // already transformed
				continue;
			}
			transformModelObj(srcModelTypeEndpointRef, srcModelObj, srcModelObjs, tgtModelTypeEndpointRef, tgtModelObjs);
		}
		// third pass: EAttributes and non-containment EReferences
		List<PrimitiveEObjectWrapper> primitiveSrcModelObjs = new ArrayList<>(), primitiveTgtModelObjs = new ArrayList<>();
		for (Map.Entry<EObject, EObject> tgtModelObjsEntry : tgtModelObjs.entrySet()) {
			EObject srcModelObj = tgtModelObjsEntry.getKey(), tgtModelObj = tgtModelObjsEntry.getValue();
			for (ModelElementReference srcModelElemTypeRef : srcModelTypeEndpointRef.getModelElemRefs()) {
				var srcModelElemTypeEInfo = srcModelElemTypeRef.getObject().getEInfo();
				if (
					srcModelElemTypeEInfo.getFeatureName() == null ||
					!MIDConstraintChecker.instanceofEMFClass(srcModelObj, srcModelElemTypeEInfo.getClassName())
				) {
					continue;
				}
				var tgtModelElemTypeRef = ((MappingReference) srcModelElemTypeRef.getModelElemEndpointRefs().get(0).eContainer()).getModelElemEndpointRefs().get(tgtIndex).getModelElemRef();
				var tgtModelElemTypeEInfo = tgtModelElemTypeRef.getObject().getEInfo();
				transformModelObjFeature(srcModelObj, srcModelElemTypeEInfo.getFeatureName(), tgtModelObj, tgtModelElemTypeEInfo.getFeatureName(), primitiveSrcModelObjs, primitiveTgtModelObjs, tgtModelObjs);
			}
		}
		for (var i = 0; i < primitiveSrcModelObjs.size(); i++) { // needed to avoid concurrent modification of tgtModelObjs
			tgtModelObjs.put(primitiveSrcModelObjs.get(i), primitiveTgtModelObjs.get(i));
		}
		// fourth pass: create model elements and links
		FileUtils.writeModelFile(this.tgtRootModelObj, this.tgtModelPath, null, true);
		for (Map.Entry<EObject, EObject> tgtModelObjEntry : tgtModelObjs.entrySet()) {
			EList<ModelElementReference> targetModelElemRefs = new BasicEList<>();
			var srcModelElemRef = traceModelRel.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(tgtModelObjEntry.getKey(), null);
			targetModelElemRefs.add(srcModelElemRef);
			var tgtModelElemRef = traceModelRel.getModelEndpointRefs().get(1).createModelElementInstanceAndReference(tgtModelObjEntry.getValue(), null);
			targetModelElemRefs.add(tgtModelElemRef);
			Mapping mappingType = MIDConstraintChecker.getAllowedMappingTypes(traceModelRelType, srcModelElemRef, tgtModelElemRef).get(0);
			var newMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, targetModelElemRefs);
			newMappingRef.getObject().setName(srcModelElemRef.getObject().getName() + MMINTConstants.BINARY_MODELREL_SEPARATOR + tgtModelElemRef.getObject().getName());
		}
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MID> outputMIDsByName)
		throws Exception {

		// input
		var traceModelRelType = (ModelRel) genericsByName.get(ModelRelTypeTransformation.GENERIC_MODELRELTYPE);
		var srcModel = inputsByName.get(ModelRelTypeTransformation.IN_MODEL);
		this.init();

		var srcIndex = (
			traceModelRelType instanceof BinaryModelRel ||
			MIDConstraintChecker.isAllowedModelEndpoint(traceModelRelType.getModelEndpointRefs().get(0), srcModel, new HashMap<String, Integer>())
		) ?
			0 : 1;
		var tgtIndex = 1 - srcIndex;
		var tgtModelType = traceModelRelType.getModelEndpointRefs().get(tgtIndex).getObject().getTarget();
		this.tgtModelPath = FileUtils.getUniquePath(
			FileUtils.replaceFileExtensionInPath(
				FileUtils.addFileNameSuffixInPath(srcModel.getUri(), ModelRelTypeTransformation.TRANSFORMATION_SUFFIX),
				tgtModelType.getFileExtension()),
			true,
			false);
		var tgtModel = tgtModelType.createInstance(null, this.tgtModelPath, outputMIDsByName.get(ModelRelTypeTransformation.OUT_MODEL));
		var traceModelRel = traceModelRelType.createBinaryInstance(
			null,
			srcModel.getName() + MMINTConstants.BINARY_MODELREL_SEPARATOR + tgtModel.getName(),
			outputMIDsByName.get(ModelRelTypeTransformation.OUT_MODELREL));
		traceModelRelType.getModelEndpointRefs().get(srcIndex).getObject().createInstance(srcModel, traceModelRel);
		traceModelRelType.getModelEndpointRefs().get(tgtIndex).getObject().createInstance(tgtModel, traceModelRel);
		transform(traceModelRel, srcModel, srcIndex, tgtIndex);
		tgtModel.createInstanceEditor(true);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(ModelRelTypeTransformation.OUT_MODEL, tgtModel);
		outputsByName.put(ModelRelTypeTransformation.OUT_MODELREL, traceModelRel);

		return outputsByName;
	}

}
