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
package edu.toronto.cs.se.modelepedia.tests;

import static org.junit.Assert.*;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraintLanguage;
import edu.toronto.cs.se.mmint.mid.MidFactory;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;

public class KleisliTest {

	private final static String TESTS_BUNDLE_NAME = "edu.toronto.cs.se.modelepedia.tests";
	private final static String TESTS_BUNDLE_MODEL_DIR= "model";
	private final static String TESTS_BUNDLE_TEST_DIR= "test";
	private final static String KLEISLI_MODELRELTYPE_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";
	private final static String KLEISLI_TRANSFORMATIONOPERATORTYPE_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";
	private final static String SRC_MODELTYPE_NAME = "Company";
	private final static String SRC_MODELTYPEENDPOINT_NAME = SRC_MODELTYPE_NAME;
	private final static String TGT_MODELTYPE_NAME = "Bank";
	private final static String TGT_MODELTYPEENDPOINT_NAME = TGT_MODELTYPE_NAME;
	private final static String MODELRELTYPE_NAME = SRC_MODELTYPE_NAME + MMINT.BINARY_MODELREL_LINK_SEPARATOR + TGT_MODELTYPE_NAME;
	private final static String[] SRC_METAMODELOBJ_NAMES = {"Company", "Student", "Businessman", "Company/clients", "Client/number"};
	private final static String[] TGT_METAMODELOBJ_NAMES = {"Bank", "_StudentAccount", "_BusinessAccount", "Bank/accounts", "Account/_number"};
	private final static String[] TGT_MODELELEM_OCLQUERIES = {null, "id.startsWith('S')", "id.startsWith('B')", null, "id.substring(2,2)"};
	private final static String TGT_MODELOBJ_METAMODELROOTCLASS = "Bank";
	private final static String TGT_MODELOBJ_METAMODELCLASSTOCREATE = "Account";
	private final static String TGT_MODELOBJ_METAMODELCONTAININGFEATURE = "accounts";
	private final static String TGT_MODELOBJ_METAMODELATTRIBUTETOCREATE = "id";
	private final static String[] TGT_MODELOBJ_ATTRIBUTEVALUES = {"S1", "B2", "A3"};

	private ModelElementReference dropMetamodelObject(EPackage metamodelRootObj, String metamodelObjName, ModelEndpointReference containerModelTypeEndpointRef, ModelElement rootModelElemType) throws MMINTException {

		String[] names = metamodelObjName.split("/");
		EObject metamodelObj;
		if (names.length == 1) {
			metamodelObj = metamodelRootObj.getEClassifier(names[0]);
		}
		else {
			EClass metamodelObjContainer = (EClass) metamodelRootObj.getEClassifier(names[0]);
			metamodelObj = metamodelObjContainer.getEStructuralFeature(names[1]);
		}
		assertTrue(containerModelTypeEndpointRef.acceptModelElementType(metamodelObj));
		String modelElemTypeUri = MultiModelRegistry.getModelAndModelElementUris(metamodelObj, MidLevel.TYPES)[1];
		EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo(metamodelObj, MidLevel.TYPES);
		String newModelElemTypeName = MultiModelRegistry.getModelElementName(eInfo, metamodelObj, MidLevel.TYPES);
		ModelElementReference newModelElemTypeRef = rootModelElemType.createSubtypeAndReference(null, modelElemTypeUri, newModelElemTypeName, eInfo, containerModelTypeEndpointRef);

		return newModelElemTypeRef;
	}

	@Test
	public void test() throws Exception {

		Bundle bundle = Platform.getBundle(TESTS_BUNDLE_NAME);
		// model types
		Model rootModelType = MultiModelTypeRegistry.getType(MMINT.ROOT_MODEL_URI);
		Model srcModelType = rootModelType.createSubtype(SRC_MODELTYPE_NAME, null, null, true);
		String srcMetamodelName = SRC_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		URL srcMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, srcMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(srcMetamodelUrl).toURI()), Paths.get(MultiModelUtils.prependStateToUri(srcMetamodelName)), StandardCopyOption.REPLACE_EXISTING);
		Model tgtModelType = rootModelType.createSubtype(TGT_MODELTYPE_NAME, null, null, true);
		String tgtMetamodelName = TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		URL tgtMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, tgtMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(tgtMetamodelUrl).toURI()), Paths.get(MultiModelUtils.prependStateToUri(tgtMetamodelName)), StandardCopyOption.REPLACE_EXISTING);

		// model rel type
		KleisliModelRel kRootModelRelType = MultiModelTypeRegistry.getType(KLEISLI_MODELRELTYPE_URI);
		KleisliModelRel kModelRelType = (KleisliModelRel) kRootModelRelType.createSubtype(MODELRELTYPE_NAME, false, null, null);
		KleisliModelEndpoint kRootModelTypeEndpoint = (KleisliModelEndpoint) kRootModelRelType.getModelEndpoints().get(0);
		//TODO MMINT[TESTS] here we need MMINT.isInitialized() to return false
		kRootModelTypeEndpoint.createSubtypeAndReference(null, SRC_MODELTYPEENDPOINT_NAME, srcModelType, false, kModelRelType);
		String kTgtMetamodelName = TGT_MODELTYPEENDPOINT_NAME + MMINT.ENDPOINT_SEPARATOR + TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		URL kTgtMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, kTgtMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(kTgtMetamodelUrl).toURI()), Paths.get(MultiModelUtils.prependStateToUri(MODELRELTYPE_NAME + MMINT.URI_SEPARATOR + kTgtMetamodelName)));
		kRootModelTypeEndpoint.createSubtypeAndReference(null, TGT_MODELTYPEENDPOINT_NAME, tgtModelType, false, kModelRelType);
		// model element types and link types
		ModelEndpointReference srcModelTypeEndpointRef = kModelRelType.getModelEndpointRefs().get(0);
		EPackage srcMetamodelRootObj = (EPackage) MultiModelUtils.getModelFileInState(srcMetamodelName);
		KleisliModelEndpointReference kTgtModelTypeEndpointRef = (KleisliModelEndpointReference) kModelRelType.getModelEndpointRefs().get(1);
		EPackage kTgtMetamodelRootObj = (EPackage) MultiModelUtils.getModelFileInState(kTgtMetamodelName);
		ModelElement rootModelElemType = MultiModelTypeRegistry.getType(MMINT.ROOT_MODELELEM_URI);
		Link rootLinkType = MultiModelTypeRegistry.getType(MMINT.ROOT_LINK_URI);
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeRegistry.getType(MMINT.ROOT_MODELELEMENDPOINT_URI);
		for (int i = 0; i < SRC_METAMODELOBJ_NAMES.length; i++) {
			ModelElementReference srcModelElemTypeRef = dropMetamodelObject(srcMetamodelRootObj, SRC_METAMODELOBJ_NAMES[i], srcModelTypeEndpointRef, rootModelElemType);
			ModelElementReference tgtModelElemTypeRef = dropMetamodelObject(kTgtMetamodelRootObj, TGT_METAMODELOBJ_NAMES[i], kTgtModelTypeEndpointRef, rootModelElemType);
			if (TGT_MODELELEM_OCLQUERIES[i] != null) {
				ExtendibleElementConstraint constraint = MidFactory.eINSTANCE.createExtendibleElementConstraint();
				constraint.setLanguage(ExtendibleElementConstraintLanguage.OCL);
				constraint.setImplementation(TGT_MODELELEM_OCLQUERIES[i]);
				tgtModelElemTypeRef.getObject().setConstraint(constraint);
			}
			String newLinkTypeName = srcModelElemTypeRef.getObject().getName() + MMINT.BINARY_MODELREL_LINK_SEPARATOR + tgtModelElemTypeRef.getObject().getName();
			LinkReference linkTypeRef = rootLinkType.createSubtypeAndReference(null, newLinkTypeName, true, kModelRelType);
			rootModelElemTypeEndpoint.createSubtypeAndReference(null, srcModelElemTypeRef.getObject().getName(), srcModelElemTypeRef, false, linkTypeRef);
			rootModelElemTypeEndpoint.createSubtypeAndReference(null, tgtModelElemTypeRef.getObject().getName(), tgtModelElemTypeRef, false, linkTypeRef);
		}

		// instances
		MultiModel instanceMID = MidFactory.eINSTANCE.createMultiModel();
		String newModelUri = TESTS_BUNDLE_TEST_DIR + IPath.SEPARATOR + TGT_MODELTYPE_NAME.toLowerCase() + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION;
		Model bankModel = tgtModelType.createInstanceAndEditor(newModelUri, ModelOrigin.CREATED, instanceMID);
		EObject rootModelObj = bankModel.getEMFInstanceRoot();
		EPackage tgtMetamodelRootObj = (EPackage) MultiModelUtils.getModelFileInState(tgtMetamodelName);
		EFactory tgtMetamodelFactory = tgtMetamodelRootObj.getEFactoryInstance();
		EStructuralFeature tgtMetamodelContainingFeature = ((EClass) tgtMetamodelRootObj.getEClassifier(TGT_MODELOBJ_METAMODELROOTCLASS)).getEStructuralFeature(TGT_MODELOBJ_METAMODELCONTAININGFEATURE);
		EClass tgtMetamodelClassToCreate = (EClass) tgtMetamodelRootObj.getEClassifier(TGT_MODELOBJ_METAMODELCLASSTOCREATE);
		EStructuralFeature tgtMetamodelAttributeToCreate = tgtMetamodelClassToCreate.getEStructuralFeature(TGT_MODELOBJ_METAMODELATTRIBUTETOCREATE);
		@SuppressWarnings("unchecked")
		EList<EObject> y = (EList<EObject>) rootModelObj.eGet(tgtMetamodelContainingFeature);
		for (String attributeValue : TGT_MODELOBJ_ATTRIBUTEVALUES) {
			EObject classValue = tgtMetamodelFactory.create(tgtMetamodelClassToCreate);
			classValue.eSet(tgtMetamodelAttributeToCreate, attributeValue);
			y.add(classValue);
		}
		MultiModelUtils.createModelFile(rootModelObj, newModelUri, true);
		EList<Model> transformationParameters = new BasicEList<Model>();
		transformationParameters.add(kModelRelType);
		transformationParameters.add(bankModel);
		MultiModelTypeRegistry.<Operator>getType(KLEISLI_TRANSFORMATIONOPERATORTYPE_URI).execute(transformationParameters);
		//TODO MMINT[TESTS] test that result model + model rel are fine
		fail("TODO");
	}

}
