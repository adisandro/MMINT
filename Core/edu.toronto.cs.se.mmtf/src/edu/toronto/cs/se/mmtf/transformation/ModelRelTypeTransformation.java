/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.transformation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.library.PrimitiveEObjectWrapper;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class ModelRelTypeTransformation extends ConversionOperatorExecutableImpl {

	protected static final String TRANSFORMATION_SUFFIX = "_transformed";

	protected EObject tgtRootModelObj;
	protected String tgtModelUri;

	protected void init() {

		tgtRootModelObj = null;
	}

	@SuppressWarnings("unchecked")
	protected EObject transformModelObj(EObject srcModelObj, Map<EObject, ModelElementReference> srcModelObjs, Map<EObject, EObject> tgtModelObjs) throws MMTFException {

		ModelElementReference tgtModelElemTypeRef = srcModelObjs.get(srcModelObj);
		EClass tgtModelTypeObj = (EClass) tgtModelElemTypeRef.getObject().getEMFTypeObject();
		EObject tgtModelObj = tgtModelTypeObj.getEPackage().getEFactoryInstance().create(tgtModelTypeObj);
		EObject srcContainerModelObj = srcModelObj.eContainer();
		if (srcContainerModelObj == null) { // root found
			tgtRootModelObj = tgtModelObj;
		}
		else {
			/*TODO MMTF[TRANSFORMATION] this assumes that the model rel type is well defined with respect to the containment hierarchy:
			 * symmetric containment -> EReference model elements
			 * just one containing EStructuralFeature of the right type -> EReference model elements
			 */
			EObject tgtContainerModelObj = tgtModelObjs.get(srcContainerModelObj);
			if (tgtContainerModelObj == null) {
				// recursion
				tgtContainerModelObj = transformModelObj(srcContainerModelObj, srcModelObjs, tgtModelObjs);
			}
			EReference containmentReference = null;
			for (EReference containment : tgtContainerModelObj.eClass().getEAllContainments()) {
				if (MultiModelConstraintChecker.instanceofEMFClass(tgtModelObj, containment.getEType().getName())) {
					containmentReference = containment;
					break;
				}
			}
			Object containment = tgtContainerModelObj.eGet(containmentReference);
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

	protected EObject transformModelObjFeature(EObject srcModelObj, String srcFeatureClassLiteral, EObject tgtModelObj, String tgtFeatureClassLiteral, Map<PrimitiveEObjectWrapper, PrimitiveEObjectWrapper> tempTgtModelObjs) {

		EStructuralFeature srcFeature = srcModelObj.eClass().getEStructuralFeature(srcFeatureClassLiteral), tgtFeature = tgtModelObj.eClass().getEStructuralFeature(tgtFeatureClassLiteral);
		Object value = srcModelObj.eGet(srcFeature);
		tgtModelObj.eSet(tgtFeature, value);
		PrimitiveEObjectWrapper tgtModelObjValue = new PrimitiveEObjectWrapper(tgtModelObj, tgtFeature, value);
		tempTgtModelObjs.put(new PrimitiveEObjectWrapper(srcModelObj, srcFeature, value), tgtModelObjValue);

		return tgtModelObjValue;
	}

	protected void transform(BinaryModelRel traceModelRel, Model srcModel, int srcIndex, int tgtIndex) throws Exception {

		ModelRel traceModelRelType = traceModelRel.getMetatype();
		ModelEndpointReference srcModelTypeEndpointRef = traceModelRelType.getModelEndpointRefs().get(srcIndex);
		Map<EObject, ModelElementReference> srcModelObjs = new HashMap<EObject, ModelElementReference>();
		TreeIterator<EObject> srcModelObjsIter = EcoreUtil.getAllContents(srcModel.getEMFInstanceRoot().eResource(), true);
		// first pass: get model objects to be transformed
		while (srcModelObjsIter.hasNext()) {
			EObject srcModelObj = srcModelObjsIter.next();
			ModelElement srcModelElemType = MultiModelConstraintChecker.getAllowedModelElementType(traceModelRel.getModelEndpointRefs().get(0), srcModelObj);
			if (srcModelElemType == null) {
				continue;
			}
			ModelElementReference srcModelElemTypeRef = MultiModelTypeHierarchy.getReference(srcModelElemType.getUri(), srcModelTypeEndpointRef.getModelElemRefs());
			ModelElementReference tgtModelElemTypeRef = ((LinkReference) srcModelElemTypeRef.getModelElemEndpointRefs().get(0).eContainer()).getModelElemEndpointRefs().get(tgtIndex).getModelElemRef();
			srcModelObjs.put(srcModelObj, tgtModelElemTypeRef);
		}
		// second pass: transform
		//TODO MMTF[TRANSFORMATION] order of elements in lists should be preserved
		Map<EObject, EObject> tgtModelObjs = new HashMap<EObject, EObject>();
		for (EObject srcModelObj : srcModelObjs.keySet()) {
			if (tgtModelObjs.get(srcModelObj) != null) { // already transformed
				continue;
			}
			transformModelObj(srcModelObj, srcModelObjs, tgtModelObjs);
		}
		// third pass: attributes
		Map<PrimitiveEObjectWrapper, PrimitiveEObjectWrapper> tempTgtModelObjs = new HashMap<PrimitiveEObjectWrapper, PrimitiveEObjectWrapper>();
		for (ModelElementReference srcModelElemTypeRef : srcModelTypeEndpointRef.getModelElemRefs()) {
			String srcClassLiteral = srcModelElemTypeRef.getObject().getClassLiteral();
			if (!srcClassLiteral.contains(MMTF.URI_SEPARATOR)) {
				continue;
			}
			String[] srcClassLiterals = srcClassLiteral.split(MMTF.URI_SEPARATOR);
			ModelElementReference tgtModelElemTypeRef = ((LinkReference) srcModelElemTypeRef.getModelElemEndpointRefs().get(0).eContainer()).getModelElemEndpointRefs().get(tgtIndex).getModelElemRef();
			String[] tgtClassLiterals = tgtModelElemTypeRef.getObject().getClassLiteral().split(MMTF.URI_SEPARATOR);
			for (Map.Entry<EObject, EObject> tgtModelObjsEntry : tgtModelObjs.entrySet()) {
				EObject srcModelObj = tgtModelObjsEntry.getKey();
				if (!MultiModelConstraintChecker.instanceofEMFClass(srcModelObj, srcClassLiterals[0])) {
					continue;
				}
				transformModelObjFeature(srcModelObj, srcClassLiterals[1], tgtModelObjsEntry.getValue(), tgtClassLiterals[1], tempTgtModelObjs);
			}
			//TODO MMTF[TRANSFORMATION] do non-containment references
		}
		for (Map.Entry<PrimitiveEObjectWrapper, PrimitiveEObjectWrapper> tempTgtModelObjsEntry : tempTgtModelObjs.entrySet()) {
			tgtModelObjs.put(tempTgtModelObjsEntry.getKey(), tempTgtModelObjsEntry.getValue());
		}
		// fourth pass: create model elements and links
		MultiModelUtils.createModelFile(tgtRootModelObj, tgtModelUri, true);
		for (Map.Entry<EObject, EObject> tgtModelObjEntry : tgtModelObjs.entrySet()) {
			EList<ModelElementReference> targetModelElemRefs = new BasicEList<ModelElementReference>();
			ModelElementReference srcModelElemRef = ModelElementImpl.createInstanceAndReference(tgtModelObjEntry.getKey(), null, traceModelRel.getModelEndpointRefs().get(0));
			targetModelElemRefs.add(srcModelElemRef);
			ModelElementReference tgtModelElemRef = ModelElementImpl.createInstanceAndReference(tgtModelObjEntry.getValue(), null, traceModelRel.getModelEndpointRefs().get(1));
			targetModelElemRefs.add(tgtModelElemRef);
			Link linkType = MultiModelTypeRegistry.getType(MultiModelConstraintChecker.getAllowedLinkTypeReferences(traceModelRelType, srcModelElemRef, tgtModelElemRef).get(0));
			LinkReference newLinkRef = linkType.createInstanceAndReferenceAndEndpointsAndReferences(true, targetModelElemRefs);
			newLinkRef.getObject().setName(srcModelElemRef.getObject().getName() + MMTF.BINARY_MODELREL_LINK_SEPARATOR + tgtModelElemRef.getObject().getName());
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		ModelRel traceModelRelType = (ModelRel) actualParameters.get(0);
		Model srcModel = actualParameters.get(1);
		MultiModel multiModel = MultiModelRegistry.getMultiModel(srcModel);
		init();

		int srcIndex = (
			traceModelRelType instanceof BinaryModelRel ||
			MultiModelConstraintChecker.isAllowedModelEndpoint(traceModelRelType.getModelEndpointRefs().get(0), srcModel, new HashMap<String, Integer>())
		) ?
			0 : 1;
		int tgtIndex = 1 - srcIndex;
		Model tgtModelType = traceModelRelType.getModelEndpointRefs().get(tgtIndex).getObject().getTarget();
		tgtModelUri = MultiModelUtils.replaceFileExtensionInUri(
			MultiModelUtils.addFileNameSuffixInUri(srcModel.getUri(), TRANSFORMATION_SUFFIX),
			tgtModelType.getFileExtension()
		);
		Model tgtModel = tgtModelType.createInstanceAndEditor(tgtModelUri, ModelOrigin.CREATED, multiModel);
		BinaryModelRel traceModelRel = (BinaryModelRel) traceModelRelType.createInstance(null, true, ModelOrigin.CREATED, multiModel);
		traceModelRel.setName(srcModel.getName() + MMTF.BINARY_MODELREL_LINK_SEPARATOR + tgtModel.getName());
		traceModelRelType.getModelEndpointRefs().get(srcIndex).getObject().createInstanceAndReference(srcModel, false, traceModelRel);
		traceModelRelType.getModelEndpointRefs().get(tgtIndex).getObject().createInstanceAndReference(tgtModel, false, traceModelRel);
		transform(traceModelRel, srcModel, srcIndex, tgtIndex);

		EList<Model> result = new BasicEList<Model>();
		result.add(tgtModel);
		result.add(traceModelRel);
		return result;
	}

}
