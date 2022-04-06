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
package edu.toronto.cs.se.modelepedia.tests;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Assert;
import org.junit.Test;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;

//TODO MMINT[TRAVIS] Run test as part of the build
public class KleisliTest extends MMINTTest {

	private final static String TESTS_BUNDLE_MODEL_DIR= "model/kleisli";
	private final static String SRC_MODELTYPE_NAME = "NECSIS14_DatabaseSchema";
	private final static String SRC_METAMODEL_NAME = KleisliTest.SRC_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
	private final static String SRC_MODELTYPEENDPOINT_NAME = "DB";
	private final static String TGT_MODELTYPE_NAME = "NECSIS14_ClassDiagram";
	private final static String TGT_METAMODEL_NAME = KleisliTest.TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
	private final static String TGT_MODELTYPEENDPOINT_NAME = "CD";
	private final static String KLEISLI_MODELRELTYPE_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";
	private final static String MODELRELTYPE_NAME = KleisliTest.TGT_MODELTYPEENDPOINT_NAME + MMINT.BINARY_MODELREL_SEPARATOR + KleisliTest.SRC_MODELTYPEENDPOINT_NAME;
	private final static String KLEISLI_TGT_METAMODEL_NAME = KleisliTest.TGT_MODELTYPEENDPOINT_NAME + MMINT.ENDPOINT_SEPARATOR + KleisliTest.TGT_MODELTYPE_NAME + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
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
	private final static String TGT_MODELELEM_QUERYLANGUAGE = "kleisli";
	private final static String[] TGT_MODELELEM_OCLQUERIES = {
		null,
		null,
		"union classes := classes\nunion associations := associations->select(upperBound > 1 or upperBound = -1)",
		"origin.oclContainer()\norigin.oclContainer()",
		"union classes := classes\nunion subclasses := classes->select(not parent.oclIsUndefined())\nunion attributes := classes->collect(attributes)\nunion multiAssociations1 := associations->select(upperBound > 1 or upperBound = -1)\nunion multiAssociations2 := associations->select(upperBound > 1 or upperBound = -1)\nunion singleAssociations := associations->select(upperBound = 1)",
		"_QTable.classes->get(origin)\n_QTable.classes->get(origin.parent)\n_QTable.classes->get(origin.oclContainer())\n_QTable.associations->get(origin)\n_QTable.associations->get(origin)\n_QTable.classes->get(origin.target)",
		"_QTable.classes->get(origin)\nNULL\nNULL\n_QTable.associations->get(origin)\n_QTable.associations->get(origin)\nNULL"
	};
	private final static String TESTS_TEMPPROJECT = MMINTTest.TESTS_BUNDLE_NAME;
	private final static String TESTS_TEMP_PROJECT_URI = IPath.SEPARATOR + KleisliTest.TESTS_TEMPPROJECT + IPath.SEPARATOR;
	private final static String TESTS_INSTANCEMID_URI = KleisliTest.TESTS_TEMP_PROJECT_URI + "instances" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;
	private final static String INPUT_MODEL_FILENAME = "cd" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION;
	private final static String INPUT_MODEL_PATH = KleisliTest.TESTS_TEMP_PROJECT_URI + KleisliTest.INPUT_MODEL_FILENAME;
	private final static String OUTPUT_ORACLE_FILENAME = "cd_transformed" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION;
	private final static String OUTPUT_ORACLE_URI = KleisliTest.TESTS_TEMP_PROJECT_URI + "oracle_" + KleisliTest.OUTPUT_ORACLE_FILENAME;
	private final static String SCHEMALOCATION_PLACEHOLDER = "SCHEMALOCATION";
	private final static String KLEISLI_TRANSFORMATIONOPERATORTYPE_URI = "http://se.cs.toronto.edu/modelepedia/Operator_KleisliModelRelTypeTransformation";

	private ModelElementReference dropMetamodelObject(EPackage metamodelRootObj, String metamodelObjName, ModelEndpointReference containerModelTypeEndpointRef, ModelElement rootModelElemType) throws MMINTException {

		var names = metamodelObjName.split(MMINTConstants.URI_SEPARATOR);
		EObject metamodelObj;
		if (names.length == 1) {
			metamodelObj = metamodelRootObj.getEClassifier(names[0]);
		}
		else {
			var metamodelObjContainer = (EClass) metamodelRootObj.getEClassifier(names[0]);
			metamodelObj = metamodelObjContainer.getEStructuralFeature(names[1]);
		}
		Assert.assertTrue(containerModelTypeEndpointRef.acceptModelElementType(metamodelObj));
		String modelElemTypeUri = MIDRegistry.getModelElementUri(metamodelObj);
		EMFInfo eInfo = MIDRegistry.getModelElementEMFInfo(metamodelObj, MIDLevel.TYPES);
		String newModelElemTypeName = MIDRegistry.getModelElementName(eInfo, metamodelObj, MIDLevel.TYPES);
		var newModelElemTypeRef = rootModelElemType.createSubtypeAndReference(null, modelElemTypeUri, newModelElemTypeName, eInfo, containerModelTypeEndpointRef);
		MMINT.createTypeHierarchy();

		return newModelElemTypeRef;
	}

	@Test
	public void necsis14() throws Exception {

		var testBundle = Platform.getBundle(MMINTTest.TESTS_BUNDLE_NAME);
		// model types
		Model rootModelType = MIDTypeRegistry.getType(MMINTConstants.ROOT_MODEL_URI);
		var srcModelType = rootModelType.createSubtype(KleisliTest.SRC_MODELTYPE_NAME, true);
		MMINT.createTypeHierarchy();
		var srcMetamodelUrl = testBundle.findEntries(KleisliTest.TESTS_BUNDLE_MODEL_DIR, KleisliTest.SRC_METAMODEL_NAME, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(srcMetamodelUrl).getFile()), Paths.get(FileUtils.prependStatePath(KleisliTest.SRC_METAMODEL_NAME)), StandardCopyOption.REPLACE_EXISTING);
		var tgtModelType = rootModelType.createSubtype(KleisliTest.TGT_MODELTYPE_NAME, true);
		MMINT.createTypeHierarchy();
		var tgtMetamodelUrl = testBundle.findEntries(KleisliTest.TESTS_BUNDLE_MODEL_DIR, KleisliTest.TGT_METAMODEL_NAME, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(tgtMetamodelUrl).getFile()), Paths.get(FileUtils.prependStatePath(KleisliTest.TGT_METAMODEL_NAME)), StandardCopyOption.REPLACE_EXISTING);

		// model rel type
		KleisliModelRel kRootModelRelType = MIDTypeRegistry.getType(KleisliTest.KLEISLI_MODELRELTYPE_URI);
		var kModelRelType = (KleisliModelRel) kRootModelRelType.createSubtype(KleisliTest.MODELRELTYPE_NAME, false);
		MMINT.createTypeHierarchy();
		var kRootModelTypeEndpoint = (KleisliModelEndpoint) kRootModelRelType.getModelEndpoints().get(0);
		var srcModelTypeEndpointRef = kRootModelTypeEndpoint.createSubtype(KleisliTest.SRC_MODELTYPEENDPOINT_NAME, srcModelType, false, kModelRelType);
		var kTgtMetamodelUrl = testBundle.findEntries(KleisliTest.TESTS_BUNDLE_MODEL_DIR, KleisliTest.KLEISLI_TGT_METAMODEL_NAME, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(kTgtMetamodelUrl).getFile()), Paths.get(FileUtils.prependStatePath(KleisliTest.MODELRELTYPE_NAME + MMINTConstants.URI_SEPARATOR + KleisliTest.KLEISLI_TGT_METAMODEL_NAME)), StandardCopyOption.REPLACE_EXISTING);
		var kTgtModelTypeEndpointRef = (KleisliModelEndpointReference) kRootModelTypeEndpoint.createSubtype(KleisliTest.TGT_MODELTYPEENDPOINT_NAME, tgtModelType, false, kModelRelType);
		// model element types and link types
		var srcMetamodelRootObj = srcModelType.getEMFTypeRoot();
		var kTgtMetamodelRootObj = ((KleisliModelEndpoint) kTgtModelTypeEndpointRef.getObject()).getExtendedTarget().getEMFTypeRoot();
		ModelElement rootModelElemType = MIDTypeHierarchy.getRootModelElementType();
		Mapping rootMappingType = MIDTypeHierarchy.getRootMappingType();
		ModelElementEndpoint rootModelElemTypeEndpoint = MIDTypeHierarchy.getRootModelElementTypeEndpoint();
		for (var i = 0; i < KleisliTest.SRC_METAMODELOBJ_NAMES.length; i++) {
			var srcModelElemTypeRef = dropMetamodelObject(srcMetamodelRootObj, KleisliTest.SRC_METAMODELOBJ_NAMES[i], srcModelTypeEndpointRef, rootModelElemType);
			var tgtModelElemTypeRef = dropMetamodelObject(kTgtMetamodelRootObj, KleisliTest.TGT_METAMODELOBJ_NAMES[i], kTgtModelTypeEndpointRef, rootModelElemType);
			if (KleisliTest.TGT_MODELELEM_OCLQUERIES[i] != null) {
				var constraint = MIDFactory.eINSTANCE.createExtendibleElementConstraint();
				constraint.setLanguage(KleisliTest.TGT_MODELELEM_QUERYLANGUAGE);
				constraint.setImplementation(KleisliTest.TGT_MODELELEM_OCLQUERIES[i]);
				tgtModelElemTypeRef.getObject().setConstraint(constraint);
			}
			var newLinkTypeName = srcModelElemTypeRef.getObject().getName() + MMINTConstants.BINARY_MODELREL_SEPARATOR + tgtModelElemTypeRef.getObject().getName();
			var mappingTypeRef = rootMappingType.createSubtypeAndReference(null, newLinkTypeName, true, kModelRelType);
			MMINT.createTypeHierarchy();
			String srcModelElemTypeEndpointName = srcModelElemTypeRef.getObject().getName(), tgtModelElemTypeEndpointName = tgtModelElemTypeRef.getObject().getName();
			if (srcModelElemTypeEndpointName.equals(tgtModelElemTypeEndpointName)) {
				srcModelElemTypeEndpointName += srcModelTypeEndpointRef.getObject().getName();
				tgtModelElemTypeEndpointName += kTgtModelTypeEndpointRef.getObject().getName();
			}
			rootModelElemTypeEndpoint.createSubtypeAndReference(srcModelElemTypeEndpointName, srcModelElemTypeRef, false, mappingTypeRef);
			rootModelElemTypeEndpoint.createSubtypeAndReference(tgtModelElemTypeEndpointName, tgtModelElemTypeRef, false, mappingTypeRef);
		}

		// instances
		createTestProject();
		var instanceMID = MIDFactory.eINSTANCE.createMID();
		var inputModelUrl = testBundle.findEntries(KleisliTest.TESTS_BUNDLE_MODEL_DIR, KleisliTest.INPUT_MODEL_FILENAME, false).nextElement();
		FileUtils.copyTextFileAndReplaceText(
			FileLocator.toFileURL(inputModelUrl).getFile().toString(),
			FileUtils.prependWorkspacePath(KleisliTest.INPUT_MODEL_PATH),
			KleisliTest.SCHEMALOCATION_PLACEHOLDER,
			"file:" + FileUtils.prependStatePath(KleisliTest.TGT_METAMODEL_NAME),
			false
		);
		var inputModel =  tgtModelType.createInstanceAndEditor(null, KleisliTest.INPUT_MODEL_PATH, instanceMID);
		FileUtils.writeModelFile(instanceMID, KleisliTest.TESTS_INSTANCEMID_URI, null, true); // this is needed for correct uris in the operator
		Operator transformationOperator = MIDTypeRegistry.<Operator>getType(KleisliTest.KLEISLI_TRANSFORMATIONOPERATORTYPE_URI);
		EList<Model> transformationInputModels = new BasicEList<>();
		transformationInputModels.add(inputModel);
		var transformationInputs = transformationOperator.checkAllowedInputs(transformationInputModels);
		EList<OperatorGeneric> transformationGenerics = new BasicEList<>();
		var transformationGeneric = OperatorFactory.eINSTANCE.createOperatorGeneric();
		transformationGeneric.setGenericSuperTypeEndpoint(transformationOperator.getGenerics().get(0));
		transformationGeneric.setGeneric(kModelRelType);
		transformationGenerics.add(transformationGeneric);
		Map<String, MID> outputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(transformationOperator, instanceMID);
		var transformationOutput = transformationOperator.startInstance(transformationInputs, null, transformationGenerics, outputMIDsByName, instanceMID).getOutputsByName();
		FileUtils.writeModelFile(instanceMID, KleisliTest.TESTS_INSTANCEMID_URI, null, true);

		// test equivalence with oracle
		ResourceSet oracleResourceSet = new ResourceSetImpl();
		var oracleResourceUri = URI.createPlatformPluginURI(MMINTTest.TESTS_BUNDLE_NAME + IPath.SEPARATOR + KleisliTest.TESTS_BUNDLE_MODEL_DIR + IPath.SEPARATOR + FileUtils.getLastSegmentFromPath(KleisliTest.TESTS_INSTANCEMID_URI), true);
		oracleResourceSet.getResource(oracleResourceUri, true);
		ResourceSet outputResourceSet = new ResourceSetImpl();
		outputResourceSet.getResource(URI.createPlatformResourceURI(KleisliTest.TESTS_INSTANCEMID_URI, true), true);
		IComparisonScope scope = new DefaultComparisonScope(oracleResourceSet, outputResourceSet, null);
		var comparison = EMFCompare.builder().build().compare(scope);
		Assert.assertTrue(comparison.getDifferences().isEmpty());
		var outputModelUrl = testBundle.findEntries(KleisliTest.TESTS_BUNDLE_MODEL_DIR, KleisliTest.OUTPUT_ORACLE_FILENAME, false).nextElement();
		FileUtils.copyTextFileAndReplaceText(
			FileLocator.toFileURL(outputModelUrl).getFile().toString(),
			FileUtils.prependWorkspacePath(KleisliTest.OUTPUT_ORACLE_URI),
			KleisliTest.SCHEMALOCATION_PLACEHOLDER,
			"file:" + FileUtils.prependStatePath(KleisliTest.SRC_METAMODEL_NAME),
			false
		);
		oracleResourceSet = new ResourceSetImpl();
		oracleResourceUri = URI.createPlatformResourceURI(KleisliTest.OUTPUT_ORACLE_URI, true);
		oracleResourceSet.getResource(oracleResourceUri, true);
		outputResourceSet = new ResourceSetImpl();
		outputResourceSet.getResource(URI.createPlatformResourceURI(transformationOutput.get(0).getUri(), true), true);
		scope = new DefaultComparisonScope(oracleResourceSet, outputResourceSet, null);
		comparison = EMFCompare.builder().build().compare(scope);
		Assert.assertTrue(comparison.getDifferences().isEmpty());
	}

}
