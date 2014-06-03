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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MidFactory;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.MidPackage;
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
import edu.toronto.cs.se.mmint.repository.MMINTConstants;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;

public class KleisliTest {

	private final static String TESTS_BUNDLE_NAME = "edu.toronto.cs.se.modelepedia.tests";
	private final static String TESTS_BUNDLE_MODEL_DIR= "model/kleisli";
	private final static String KLEISLI_MODELRELTYPE_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";
	private final static String KLEISLI_TRANSFORMATIONOPERATORTYPE_URI = "http://se.cs.toronto.edu/modelepedia/Operator_KleisliModelRelTypeTransformation";
	private final static String SRC_MODELTYPE_NAME = "Company";
	private final static String SRC_MODELTYPEENDPOINT_NAME = SRC_MODELTYPE_NAME;
	private final static String TGT_MODELTYPE_NAME = "Bank";
	private final static String TGT_MODELTYPEENDPOINT_NAME = TGT_MODELTYPE_NAME;
	private final static String MODELRELTYPE_NAME = SRC_MODELTYPE_NAME + MMINT.BINARY_MODELREL_LINK_SEPARATOR + TGT_MODELTYPE_NAME;
	private final static String[] SRC_METAMODELOBJ_NAMES = {"Company", "Student", "Businessman", "Company/clients", "Client/number"};
	private final static String[] TGT_METAMODELOBJ_NAMES = {"Bank", "_StudentAccount", "_BusinessAccount", "Bank/accounts", "Account/_number"};
	private final static String TGT_MODELELEM_QUERYLANGUAGE = "OCL";
	private final static String[] TGT_MODELELEM_OCLQUERIES = {null, "accounts->select(id.startsWith('S'))", "accounts->select(id.startsWith('B'))", null, "id.substring(2,2)"};
	private final static String TGT_MODELOBJ_METAMODELROOTCLASS = "Bank";
	private final static String TGT_MODELOBJ_METAMODELCLASSTOCREATE = "Account";
	private final static String TGT_MODELOBJ_METAMODELCONTAININGFEATURE = "accounts";
	private final static String TGT_MODELOBJ_METAMODELATTRIBUTETOCREATE = "id";
	private final static String[] TGT_MODELOBJ_ATTRIBUTEVALUES = {"S1", "B2", "A3"};
	private final static String TESTS_TEMPPROJECT = TESTS_BUNDLE_NAME;
	private final static String TESTS_INSTANCEMID_FILENAME = "instances" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MidPackage.eNAME;

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
		MMINT.createTypeHierarchy();

		return newModelElemTypeRef;
	}

	@Test
	public void test() throws Exception {

		MMINT.setPreference(MMINTConstants.PREFERENCE_TESTS_ENABLED, "true");
		Bundle bundle = Platform.getBundle(TESTS_BUNDLE_NAME);
		// model types
		Model rootModelType = MultiModelTypeRegistry.getType(MMINT.ROOT_MODEL_URI);
		Model srcModelType = rootModelType.createSubtype(SRC_MODELTYPE_NAME, null, null, true);
		MMINT.createTypeHierarchy();
		String srcMetamodelName = SRC_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		URL srcMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, srcMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(srcMetamodelUrl).getFile()), Paths.get(MultiModelUtils.prependStateToUri(srcMetamodelName)), StandardCopyOption.REPLACE_EXISTING);
		Model tgtModelType = rootModelType.createSubtype(TGT_MODELTYPE_NAME, null, null, true);
		MMINT.createTypeHierarchy();
		String tgtMetamodelName = TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		URL tgtMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, tgtMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(tgtMetamodelUrl).getFile()), Paths.get(MultiModelUtils.prependStateToUri(tgtMetamodelName)), StandardCopyOption.REPLACE_EXISTING);

		// model rel type
		KleisliModelRel kRootModelRelType = MultiModelTypeRegistry.getType(KLEISLI_MODELRELTYPE_URI);
		KleisliModelRel kModelRelType = (KleisliModelRel) kRootModelRelType.createSubtype(MODELRELTYPE_NAME, false, null, null);
		MMINT.createTypeHierarchy();
		KleisliModelEndpoint kRootModelTypeEndpoint = (KleisliModelEndpoint) kRootModelRelType.getModelEndpoints().get(0);
		kRootModelTypeEndpoint.createSubtypeAndReference(SRC_MODELTYPEENDPOINT_NAME, srcModelType, false, kModelRelType);
		String kTgtMetamodelName = TGT_MODELTYPEENDPOINT_NAME + MMINT.ENDPOINT_SEPARATOR + TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		URL kTgtMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, kTgtMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(kTgtMetamodelUrl).getFile()), Paths.get(MultiModelUtils.prependStateToUri(MODELRELTYPE_NAME + MMINT.URI_SEPARATOR + kTgtMetamodelName)), StandardCopyOption.REPLACE_EXISTING);
		kRootModelTypeEndpoint.createSubtypeAndReference(TGT_MODELTYPEENDPOINT_NAME, tgtModelType, false, kModelRelType);
		// model element types and link types
		ModelEndpointReference srcModelTypeEndpointRef = kModelRelType.getModelEndpointRefs().get(0);
		EPackage srcMetamodelRootObj = (EPackage) MultiModelUtils.getModelFileInState(srcMetamodelName);
		KleisliModelEndpointReference kTgtModelTypeEndpointRef = (KleisliModelEndpointReference) kModelRelType.getModelEndpointRefs().get(1);
		EPackage kTgtMetamodelRootObj = (EPackage) MultiModelUtils.getModelFileInState(MODELRELTYPE_NAME + MMINT.URI_SEPARATOR + kTgtMetamodelName);
		ModelElement rootModelElemType = MultiModelTypeRegistry.getType(MMINT.ROOT_MODELELEM_URI);
		Link rootLinkType = MultiModelTypeRegistry.getType(MMINT.ROOT_LINK_URI);
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeRegistry.getType(MMINT.ROOT_MODELELEMENDPOINT_URI);
		for (int i = 0; i < SRC_METAMODELOBJ_NAMES.length; i++) {
			ModelElementReference srcModelElemTypeRef = dropMetamodelObject(srcMetamodelRootObj, SRC_METAMODELOBJ_NAMES[i], srcModelTypeEndpointRef, rootModelElemType);
			ModelElementReference tgtModelElemTypeRef = dropMetamodelObject(kTgtMetamodelRootObj, TGT_METAMODELOBJ_NAMES[i], kTgtModelTypeEndpointRef, rootModelElemType);
			if (TGT_MODELELEM_OCLQUERIES[i] != null) {
				ExtendibleElementConstraint constraint = MidFactory.eINSTANCE.createExtendibleElementConstraint();
				constraint.setLanguage(TGT_MODELELEM_QUERYLANGUAGE);
				constraint.setImplementation(TGT_MODELELEM_OCLQUERIES[i]);
				tgtModelElemTypeRef.getObject().setConstraint(constraint);
			}
			String newLinkTypeName = srcModelElemTypeRef.getObject().getName() + MMINT.BINARY_MODELREL_LINK_SEPARATOR + tgtModelElemTypeRef.getObject().getName();
			LinkReference linkTypeRef = rootLinkType.createSubtypeAndReference(null, newLinkTypeName, true, kModelRelType);
			MMINT.createTypeHierarchy();
			rootModelElemTypeEndpoint.createSubtypeAndReference(srcModelElemTypeRef.getObject().getName(), srcModelElemTypeRef, false, linkTypeRef);
			rootModelElemTypeEndpoint.createSubtypeAndReference(tgtModelElemTypeRef.getObject().getName(), tgtModelElemTypeRef, false, linkTypeRef);
		}

		// instances
		IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTS_TEMPPROJECT);
		tempProject.create(null);
		tempProject.open(null);
		String tempProjectUri = IPath.SEPARATOR + TESTS_TEMPPROJECT + IPath.SEPARATOR;
		String instanceMIDUri = tempProjectUri + TESTS_INSTANCEMID_FILENAME;
		MultiModel instanceMID = MidFactory.eINSTANCE.createMultiModel();
		EPackage tgtMetamodelRootObj = (EPackage) MultiModelUtils.getModelFileInState(tgtMetamodelName);
		EFactory tgtMetamodelFactory = tgtMetamodelRootObj.getEFactoryInstance();
		EObject rootModelObj = tgtMetamodelFactory.create((EClass) tgtMetamodelRootObj.getEClassifiers().get(0));
		String bankModelUri = tempProjectUri + TGT_MODELTYPE_NAME.toLowerCase() + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION;
		Model bankModel = tgtModelType.createInstanceAndEditor(bankModelUri, ModelOrigin.CREATED, instanceMID);
		EStructuralFeature tgtMetamodelContainingFeature = ((EClass) tgtMetamodelRootObj.getEClassifier(TGT_MODELOBJ_METAMODELROOTCLASS)).getEStructuralFeature(TGT_MODELOBJ_METAMODELCONTAININGFEATURE);
		EClass tgtMetamodelClassToCreate = (EClass) tgtMetamodelRootObj.getEClassifier(TGT_MODELOBJ_METAMODELCLASSTOCREATE);
		EStructuralFeature tgtMetamodelAttributeToCreate = tgtMetamodelClassToCreate.getEStructuralFeature(TGT_MODELOBJ_METAMODELATTRIBUTETOCREATE);
		@SuppressWarnings("unchecked")
		EList<EObject> rootModelObjContainment = (EList<EObject>) rootModelObj.eGet(tgtMetamodelContainingFeature);
		for (String attributeValue : TGT_MODELOBJ_ATTRIBUTEVALUES) {
			EObject classValue = tgtMetamodelFactory.create(tgtMetamodelClassToCreate);
			classValue.eSet(tgtMetamodelAttributeToCreate, attributeValue);
			rootModelObjContainment.add(classValue);
		}
		MultiModelUtils.createModelFile(rootModelObj, bankModelUri, true);
		MultiModelUtils.createModelFile(instanceMID, instanceMIDUri, true); // this is needed for correct uris in the operator
		EList<Model> transformationParameters = new BasicEList<Model>();
		transformationParameters.add(kModelRelType);
		transformationParameters.add(bankModel);
		EList<Model> transformationResult = MultiModelTypeRegistry.<Operator>getType(KLEISLI_TRANSFORMATIONOPERATORTYPE_URI).execute(transformationParameters);
		MultiModelUtils.createModelFile(instanceMID, instanceMIDUri, true);

		// test equivalence with oracle
		ResourceSet oracleResourceSet = new ResourceSetImpl();
		URI oracleResourceUri = URI.createPlatformPluginURI(TESTS_BUNDLE_NAME + IPath.SEPARATOR + TESTS_BUNDLE_MODEL_DIR + IPath.SEPARATOR + MultiModelUtils.getLastSegmentFromUri(instanceMIDUri), true);
		oracleResourceSet.getResource(oracleResourceUri, true);
		ResourceSet testedResourceSet = new ResourceSetImpl();
		testedResourceSet.getResource(URI.createPlatformResourceURI(instanceMIDUri, true), true);
		IComparisonScope scope = EMFCompare.createDefaultScope(oracleResourceSet, testedResourceSet);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		assertTrue(comparison.getDifferences().isEmpty());
		oracleResourceSet = new ResourceSetImpl();
		oracleResourceUri = URI.createPlatformPluginURI(TESTS_BUNDLE_NAME + IPath.SEPARATOR + TESTS_BUNDLE_MODEL_DIR + IPath.SEPARATOR + MultiModelUtils.getLastSegmentFromUri(transformationResult.get(0).getUri()), true);
		oracleResourceSet.getResource(oracleResourceUri, true);
		testedResourceSet = new ResourceSetImpl();
		testedResourceSet.getResource(URI.createPlatformResourceURI(transformationResult.get(0).getUri(), true), true);
		scope = EMFCompare.createDefaultScope(oracleResourceSet, testedResourceSet);
		comparison = EMFCompare.builder().build().compare(scope);
		assertTrue(comparison.getDifferences().isEmpty());
	}

}
