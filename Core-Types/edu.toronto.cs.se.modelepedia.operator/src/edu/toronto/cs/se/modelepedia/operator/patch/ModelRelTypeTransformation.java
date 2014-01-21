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
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class ModelRelTypeTransformation extends OperatorExecutableImpl {

	private static final String TRANSFORMATION_SUFFIX = "_transformed";

	private void transform() {

		
	}

	private void transform(ModelRel traceModelRelType, ModelRel traceModelRel, Model srcModel, int srcIndex, int tgtIndex) throws MMTFException {

		ModelEndpointReference srcModelTypeEndpointRef = traceModelRelType.getModelEndpointRefs().get(srcIndex);
		ModelEndpointReference tgtModelTypeEndpointRef = traceModelRelType.getModelEndpointRefs().get(tgtIndex);
		ModelEndpointReference srcModelEndpointRef = traceModelRel.getModelEndpointRefs().get(0);
		ModelEndpointReference tgtModelEndpointRef = traceModelRel.getModelEndpointRefs().get(1);
		Map<EObject, ModelElementReference> srcModelObjs = new HashMap<EObject, ModelElementReference>();
		TreeIterator<EObject> srcModelObjsIter = EcoreUtil.getAllContents(MultiModelTypeIntrospection.getRoot(srcModel), true);
		// first pass: get model objects to be transformed
		while (srcModelObjsIter.hasNext()) {
			EObject srcModelObj = srcModelObjsIter.next();
			ModelElement srcModelElemType = MultiModelConstraintChecker.getAllowedModelElementType(srcModelEndpointRef, srcModelObj);
			if (srcModelElemType == null) {
				continue;
			}
			ModelElementReference srcModelElemTypeRef = MultiModelTypeHierarchy.getReference(srcModelElemType.getUri(), srcModelTypeEndpointRef.getModelElemRefs());
			ModelElementReference tgtModelElemTypeRef = ((Link) srcModelElemTypeRef.getModelElemEndpointRefs().get(0).eContainer()).getModelElemEndpointRefs().get(tgtIndex).getModelElemRef();
			srcModelObjs.put(srcModelObj, tgtModelElemTypeRef);
		}
		// second pass : transform
		EPackage tgtModelTypePackage = (EPackage) MultiModelTypeIntrospection.getRoot(tgtModelTypeEndpointRef.getObject().getTarget());
		EFactory tgtModelTypeFactory = tgtModelTypePackage.getEFactoryInstance();
		for (Map.Entry<EObject, ModelElementReference> srcModelObjsEntry : srcModelObjs.entrySet()) {
			EObject srcModelObj = srcModelObjsEntry.getKey();
			ModelElementReference tgtModelElemTypeRef = srcModelObjsEntry.getValue();
			EObject tgtModelObj = tgtModelTypeFactory.create((EClass) MultiModelTypeIntrospection.getPointer(tgtModelElemTypeRef.getObject()));
			ModelElementImpl.createInstanceAndReference(srcModelObj, null, srcModelEndpointRef);
			ModelElementImpl.createInstanceAndReference(tgtModelObj, null, tgtModelEndpointRef);
			//TODO MMTF[TRANSFORMATION] finish from here
			// create instance link
			// detect container
		}
		// references and attributes pass
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model srcModel = actualParameters.get(0);
		ModelRel traceModelRelType = (ModelRel) actualParameters.get(1);
		MultiModel multiModel = MultiModelRegistry.getMultiModel(srcModel);
		//TODO MMTF[TRANSFORMATION] move this check out of the operator
		if (traceModelRelType.getModelEndpointRefs().size() != 2) {
			throw new MMTFException("The model relationship type must have 2 model endpoints");
		}

		int srcIndex = (
			traceModelRelType instanceof BinaryModelRel ||
			srcModel.getMetatypeUri().equals(traceModelRelType.getModelEndpointRefs().get(0).getTargetUri())
		) ?
			0 : 1;
		int tgtIndex = 1 - srcIndex;
		Model tgtModelType = traceModelRelType.getModelEndpointRefs().get(tgtIndex).getObject().getTarget();
		String tgtModelUri = MultiModelUtils.replaceFileExtensionInUri(
			MultiModelUtils.addFileNameSuffixInUri(srcModel.getUri(), TRANSFORMATION_SUFFIX),
			tgtModelType.getFileExtension()
		);
		Model tgtModel = tgtModelType.createInstanceAndEditor(tgtModelUri, ModelOrigin.CREATED, multiModel);
		ModelRel traceModelRel = traceModelRelType.createInstance(null, true, ModelOrigin.CREATED, multiModel);
		traceModelRelType.getModelEndpointRefs().get(srcIndex).getObject().createInstanceAndReference(srcModel, false, traceModelRel);
		traceModelRelType.getModelEndpointRefs().get(tgtIndex).getObject().createInstanceAndReference(tgtModel, false, traceModelRel);
		transform(traceModelRelType, traceModelRel, srcModel, srcIndex, tgtIndex);
		//TODO MMTF[KLEISLI] make it work, i.e. make all operations invoked here transparent to the user (getRoot, getPointer, etc..)

		EList<Model> result = new BasicEList<Model>();
		result.add(tgtModel);
		result.add(traceModelRel);
		return result;
	}

}
