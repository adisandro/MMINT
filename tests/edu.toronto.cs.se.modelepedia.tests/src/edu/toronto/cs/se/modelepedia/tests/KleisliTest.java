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
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
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
	private final static String SRC_MODELTYPE_NAME = "NECSIS14_DatabaseSchema";
	private final static String SRC_METAMODEL_NAME = SRC_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
	private final static String SRC_MODELTYPEENDPOINT_NAME = "DB";
	private final static String TGT_MODELTYPE_NAME = "NECSIS14_ClassDiagram";
	private final static String TGT_METAMODEL_NAME = TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
	private final static String TGT_MODELTYPEENDPOINT_NAME = "CD";
	private final static String KLEISLI_MODELRELTYPE_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";
	private final static String MODELRELTYPE_NAME = TGT_MODELTYPEENDPOINT_NAME + MMINT.BINARY_MODELREL_LINK_SEPARATOR + SRC_MODELTYPEENDPOINT_NAME;
	private final static String KLEISLI_TGT_METAMODEL_NAME = TGT_MODELTYPEENDPOINT_NAME + MMINT.ENDPOINT_SEPARATOR + TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
	private final static String[] SRC_METAMODELOBJ_NAMES = {
		"DatabaseSchema",
		"NamedElement/name",
		"Table",
		"DatabaseSchema/tables",
		"Column",
		"Table/columns",
		"Table/primaryKeys"
	};
	private final static String[] TGT_METAMODELOBJ_NAMES = {
		"ClassDiagram",
		"NamedElement/name",
		"_QTable",
		"ClassDiagram/_Qtables",
		"_QColumn",
		"_QTable/_Qcolumns",
		"_QTable/_QprimaryKeys"
	};
	private final static String TGT_MODELELEM_QUERYLANGUAGE = "KLEISLI";
	private final static String[] TGT_MODELELEM_OCLQUERIES = {
		null,
		null,
		"union classes := Class.allInstances()\nunion associations := Association.allInstances()->select(upperBound > 1 or upperBound = -1)",
		"origin.oclContainer()\norigin.oclContainer()",
		"union classes := Class.allInstances()\nunion subclasses := Class.allInstances()->select(not parent.oclIsUndefined())\nunion attributes := Attribute.allInstances()\nunion multiAssociations1 := Association.allInstances()->select(upperBound > 1 or upperBound = -1)\nunion multiAssociations2 := Association.allInstances()->select(upperBound > 1 or upperBound = -1)\nunion singleAssociations := Association.allInstances()->select(upperBound = 1)",
		"_QTable.classes->get(origin)\n_QTable.classes->get(origin.parent)\n_QTable.classes->get(origin.oclContainer())\n_QTable.associations->get(origin)\n_QTable.associations->get(origin)\n_QTable.classes->get(origin.target)",
		"_QTable.classes->get(origin)\nNULL\nNULL\n_QTable.associations->get(origin)\n_QTable.associations->get(origin)\nNULL"
	};
	private final static String TESTS_TEMPPROJECT = TESTS_BUNDLE_NAME;
	private final static String TESTS_TEMP_PROJECT_URI = IPath.SEPARATOR + TESTS_TEMPPROJECT + IPath.SEPARATOR;
	private final static String TESTS_INSTANCEMID_URI = TESTS_TEMP_PROJECT_URI + "instances" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;
	private final static String INPUT_MODEL_FILENAME = "cd" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION;
	private final static String INPUT_MODEL_URI = TESTS_TEMP_PROJECT_URI + INPUT_MODEL_FILENAME;
	private final static String OUTPUT_ORACLE_FILENAME = "cd_transformed" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION;
	private final static String OUTPUT_ORACLE_URI = TESTS_TEMP_PROJECT_URI + "oracle_" + OUTPUT_ORACLE_FILENAME;
	private final static String SCHEMALOCATION_PLACEHOLDER = "SCHEMALOCATION";
	private final static String KLEISLI_TRANSFORMATIONOPERATORTYPE_URI = "http://se.cs.toronto.edu/modelepedia/Operator_KleisliModelRelTypeTransformation";

	private ModelElementReference dropMetamodelObject(EPackage metamodelRootObj, String metamodelObjName, ModelEndpointReference containerModelTypeEndpointRef, ModelElement rootModelElemType) throws MMINTException {

		String[] names = metamodelObjName.split(MMINT.URI_SEPARATOR);
		EObject metamodelObj;
		if (names.length == 1) {
			metamodelObj = metamodelRootObj.getEClassifier(names[0]);
		}
		else {
			EClass metamodelObjContainer = (EClass) metamodelRootObj.getEClassifier(names[0]);
			metamodelObj = metamodelObjContainer.getEStructuralFeature(names[1]);
		}
		assertTrue(containerModelTypeEndpointRef.acceptModelElementType(metamodelObj));
		String modelElemTypeUri = MultiModelRegistry.getModelAndModelElementUris(metamodelObj, MIDLevel.TYPES)[1];
		EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo(metamodelObj, MIDLevel.TYPES);
		String newModelElemTypeName = MultiModelRegistry.getModelElementName(eInfo, metamodelObj, MIDLevel.TYPES);
		ModelElementReference newModelElemTypeRef = rootModelElemType.createSubtypeAndReference(null, modelElemTypeUri, newModelElemTypeName, eInfo, containerModelTypeEndpointRef);
		MMINT.createTypeHierarchy();

		return newModelElemTypeRef;
	}

	@Test
	public void test() throws Exception {

		MMINT.setPreference(MMINTConstants.PREFERENCE_TESTS_ENABLED, "true");
		Bundle testsBundle = Platform.getBundle(TESTS_BUNDLE_NAME);
		// model types
		Model rootModelType = MultiModelTypeRegistry.getType(MMINT.ROOT_MODEL_URI);
		Model srcModelType = rootModelType.createSubtype(SRC_MODELTYPE_NAME, null, null, true);
		MMINT.createTypeHierarchy();
		URL srcMetamodelUrl = testsBundle.findEntries(TESTS_BUNDLE_MODEL_DIR, SRC_METAMODEL_NAME, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(srcMetamodelUrl).getFile()), Paths.get(MultiModelUtils.prependStateToUri(SRC_METAMODEL_NAME)), StandardCopyOption.REPLACE_EXISTING);
		Model tgtModelType = rootModelType.createSubtype(TGT_MODELTYPE_NAME, null, null, true);
		MMINT.createTypeHierarchy();
		URL tgtMetamodelUrl = testsBundle.findEntries(TESTS_BUNDLE_MODEL_DIR, TGT_METAMODEL_NAME, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(tgtMetamodelUrl).getFile()), Paths.get(MultiModelUtils.prependStateToUri(TGT_METAMODEL_NAME)), StandardCopyOption.REPLACE_EXISTING);

		// model rel type
		KleisliModelRel kRootModelRelType = MultiModelTypeRegistry.getType(KLEISLI_MODELRELTYPE_URI);
		KleisliModelRel kModelRelType = (KleisliModelRel) kRootModelRelType.createSubtype(MODELRELTYPE_NAME, false, null, null);
		MMINT.createTypeHierarchy();
		KleisliModelEndpoint kRootModelTypeEndpoint = (KleisliModelEndpoint) kRootModelRelType.getModelEndpoints().get(0);
		ModelEndpointReference srcModelTypeEndpointRef = kRootModelTypeEndpoint.createSubtypeAndReference(SRC_MODELTYPEENDPOINT_NAME, srcModelType, false, kModelRelType);
		URL kTgtMetamodelUrl = testsBundle.findEntries(TESTS_BUNDLE_MODEL_DIR, KLEISLI_TGT_METAMODEL_NAME, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(kTgtMetamodelUrl).getFile()), Paths.get(MultiModelUtils.prependStateToUri(MODELRELTYPE_NAME + MMINT.URI_SEPARATOR + KLEISLI_TGT_METAMODEL_NAME)), StandardCopyOption.REPLACE_EXISTING);
		KleisliModelEndpointReference kTgtModelTypeEndpointRef = (KleisliModelEndpointReference) kRootModelTypeEndpoint.createSubtypeAndReference(TGT_MODELTYPEENDPOINT_NAME, tgtModelType, false, kModelRelType);
		// model element types and link types
		EPackage srcMetamodelRootObj = srcModelType.getEMFTypeRoot();
		EPackage kTgtMetamodelRootObj = ((KleisliModelEndpoint) kTgtModelTypeEndpointRef.getObject()).getExtendedTarget().getEMFTypeRoot();
		ModelElement rootModelElemType = MultiModelTypeRegistry.getType(MMINT.ROOT_MODELELEM_URI);
		Link rootLinkType = MultiModelTypeRegistry.getType(MMINT.ROOT_LINK_URI);
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeRegistry.getType(MMINT.ROOT_MODELELEMENDPOINT_URI);
		for (int i = 0; i < SRC_METAMODELOBJ_NAMES.length; i++) {
			ModelElementReference srcModelElemTypeRef = dropMetamodelObject(srcMetamodelRootObj, SRC_METAMODELOBJ_NAMES[i], srcModelTypeEndpointRef, rootModelElemType);
			ModelElementReference tgtModelElemTypeRef = dropMetamodelObject(kTgtMetamodelRootObj, TGT_METAMODELOBJ_NAMES[i], kTgtModelTypeEndpointRef, rootModelElemType);
			if (TGT_MODELELEM_OCLQUERIES[i] != null) {
				ExtendibleElementConstraint constraint = MIDFactory.eINSTANCE.createExtendibleElementConstraint();
				constraint.setLanguage(TGT_MODELELEM_QUERYLANGUAGE);
				constraint.setImplementation(TGT_MODELELEM_OCLQUERIES[i]);
				tgtModelElemTypeRef.getObject().setConstraint(constraint);
			}
			String newLinkTypeName = srcModelElemTypeRef.getObject().getName() + MMINT.BINARY_MODELREL_LINK_SEPARATOR + tgtModelElemTypeRef.getObject().getName();
			LinkReference linkTypeRef = rootLinkType.createSubtypeAndReference(null, newLinkTypeName, true, kModelRelType);
			MMINT.createTypeHierarchy();
			String srcModelElemTypeEndpointName = srcModelElemTypeRef.getObject().getName(), tgtModelElemTypeEndpointName = tgtModelElemTypeRef.getObject().getName();
			if (srcModelElemTypeEndpointName.equals(tgtModelElemTypeEndpointName)) {
				srcModelElemTypeEndpointName += srcModelTypeEndpointRef.getObject().getName();
				tgtModelElemTypeEndpointName += kTgtModelTypeEndpointRef.getObject().getName();
			}
			rootModelElemTypeEndpoint.createSubtypeAndReference(srcModelElemTypeEndpointName, srcModelElemTypeRef, false, linkTypeRef);
			rootModelElemTypeEndpoint.createSubtypeAndReference(tgtModelElemTypeEndpointName, tgtModelElemTypeRef, false, linkTypeRef);
		}

		// instances
		IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTS_TEMPPROJECT);
		tempProject.create(null);
		tempProject.open(null);
		MultiModel instanceMID = MIDFactory.eINSTANCE.createMultiModel();
		URL inputModelUrl = testsBundle.findEntries(TESTS_BUNDLE_MODEL_DIR, INPUT_MODEL_FILENAME, false).nextElement();
		MultiModelUtils.copyTextFileAndReplaceText(
			FileLocator.toFileURL(inputModelUrl).getFile().toString(),
			MultiModelUtils.prependWorkspaceToUri(INPUT_MODEL_URI),
			SCHEMALOCATION_PLACEHOLDER,
			"file:" + MultiModelUtils.prependStateToUri(TGT_METAMODEL_NAME),
			false
		);
		Model inputModel =  tgtModelType.createInstanceAndEditor(INPUT_MODEL_URI, ModelOrigin.CREATED, instanceMID);
		MultiModelUtils.createModelFile(instanceMID, TESTS_INSTANCEMID_URI, true); // this is needed for correct uris in the operator
		EList<Model> transformationParameters = new BasicEList<Model>();
		transformationParameters.add(kModelRelType);
		transformationParameters.add(inputModel);
		EList<Model> transformationOutput = MultiModelTypeRegistry.<Operator>getType(KLEISLI_TRANSFORMATIONOPERATORTYPE_URI).execute(transformationParameters);
		MultiModelUtils.createModelFile(instanceMID, TESTS_INSTANCEMID_URI, true);

		// test equivalence with oracle
		ResourceSet oracleResourceSet = new ResourceSetImpl();
		URI oracleResourceUri = URI.createPlatformPluginURI(TESTS_BUNDLE_NAME + IPath.SEPARATOR + TESTS_BUNDLE_MODEL_DIR + IPath.SEPARATOR + MultiModelUtils.getLastSegmentFromUri(TESTS_INSTANCEMID_URI), true);
		oracleResourceSet.getResource(oracleResourceUri, true);
		ResourceSet outputResourceSet = new ResourceSetImpl();
		outputResourceSet.getResource(URI.createPlatformResourceURI(TESTS_INSTANCEMID_URI, true), true);
		IComparisonScope scope = new DefaultComparisonScope(oracleResourceSet, outputResourceSet, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		assertTrue(comparison.getDifferences().isEmpty());
		URL outputModelUrl = testsBundle.findEntries(TESTS_BUNDLE_MODEL_DIR, OUTPUT_ORACLE_FILENAME, false).nextElement();
		MultiModelUtils.copyTextFileAndReplaceText(
			FileLocator.toFileURL(outputModelUrl).getFile().toString(),
			MultiModelUtils.prependWorkspaceToUri(OUTPUT_ORACLE_URI),
			SCHEMALOCATION_PLACEHOLDER,
			"file:" + MultiModelUtils.prependStateToUri(SRC_METAMODEL_NAME),
			false
		);
		oracleResourceSet = new ResourceSetImpl();
		oracleResourceUri = URI.createPlatformResourceURI(OUTPUT_ORACLE_URI, true);
		oracleResourceSet.getResource(oracleResourceUri, true);
		outputResourceSet = new ResourceSetImpl();
		outputResourceSet.getResource(URI.createPlatformResourceURI(transformationOutput.get(0).getUri(), true), true);
		scope = new DefaultComparisonScope(oracleResourceSet, outputResourceSet, null);
		comparison = EMFCompare.builder().build().compare(scope);
		assertTrue(comparison.getDifferences().isEmpty());
	}

}
