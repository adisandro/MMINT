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

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;

public class KleisliTest {

	private final static String TESTS_BUNDLE_NAME = "edu.toronto.cs.se.modelepedia.tests";
	private final static String TESTS_BUNDLE_MODEL_DIR= "model";
	private final static String TESTS_BUNDLE_TEST_DIR= "test";
	private final static String KLEISLI_MODELRELTYPE_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";
	private final static String SRC_MODELTYPE_NAME = "Bank";
	private final static String SRC_MODELTYPEENDPOINT_NAME = SRC_MODELTYPE_NAME;
	private final static String TGT_MODELTYPE_NAME = "Company";
	private final static String TGT_MODELTYPEENDPOINT_NAME = TGT_MODELTYPE_NAME;
	private final static String MODELRELTYPE_NAME = SRC_MODELTYPE_NAME + MMTF.BINARY_MODELREL_LINK_SEPARATOR + TGT_MODELTYPE_NAME;
	private final static String OCL_QUERY_1 = "id.substring(2,2)";
	private final static String OCL_QUERY_2 = "id.startsWith('S')";
	private final static String OCL_QUERY_3 = "id.startsWith('B')";

	@Test
	public void test() throws Exception {

		Bundle bundle = Platform.getBundle(TESTS_BUNDLE_NAME);
		//TODO MMTF[TESTS] MMTF has to run before this, with dynamic types from previous run discarded
		// model types
		Model rootModelType = MultiModelTypeRegistry.getType(MMTF.ROOT_MODEL_URI);
		Model srcModelType = rootModelType.createSubtype(SRC_MODELTYPE_NAME, null, null, true);
		String srcMetamodelName = SRC_MODELTYPE_NAME + "." + EcorePackage.eNAME;
		URL srcMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, srcMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(srcMetamodelUrl).toURI()), Paths.get(MultiModelUtils.prependStateToUri(srcMetamodelName)));
		Model tgtModelType = rootModelType.createSubtype(TGT_MODELTYPE_NAME, null, null, true);
		String tgtMetamodelName = TGT_MODELTYPE_NAME + "." + EcorePackage.eNAME;
		URL tgtMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, tgtMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(tgtMetamodelUrl).toURI()), Paths.get(MultiModelUtils.prependStateToUri(tgtMetamodelName)));

		// model rel type
		KleisliModelRel kRootModelRelType = MultiModelTypeRegistry.getType(KLEISLI_MODELRELTYPE_URI);
		KleisliModelRel kModelRelType = (KleisliModelRel) kRootModelRelType.createSubtype(MODELRELTYPE_NAME, false, null, null);
		KleisliModelEndpoint kRootModelTypeEndpoint = (KleisliModelEndpoint) kRootModelRelType.getModelEndpoints().get(0);
		String kSrcMetamodelName = SRC_MODELTYPEENDPOINT_NAME + MMTF.ENDPOINT_SEPARATOR + SRC_MODELTYPE_NAME + "." + EcorePackage.eNAME;
		URL kSrcMetamodelUrl = bundle.findEntries(TESTS_BUNDLE_MODEL_DIR, kSrcMetamodelName, false).nextElement();
		Files.copy(Paths.get(FileLocator.toFileURL(kSrcMetamodelUrl).toURI()), Paths.get(MultiModelUtils.prependStateToUri(MODELRELTYPE_NAME + MMTF.URI_SEPARATOR + kSrcMetamodelName)));
		kRootModelTypeEndpoint.createSubtypeAndReference(null, SRC_MODELTYPEENDPOINT_NAME, srcModelType, false, kModelRelType);
		//TODO MMTF[TESTS] here we need MMTF.isInitialized() to return false
		kRootModelTypeEndpoint.createSubtypeAndReference(null, TGT_MODELTYPEENDPOINT_NAME, tgtModelType, false, kModelRelType);
		//TODO MMTF[TESTS] create model element types, ocl queries and link types

		// instances
		MultiModel instanceMID = MidFactory.eINSTANCE.createMultiModel();
		//TODO MMTF[TESTS] should try to mimic things in gmf command or this is all?
		Model bankModel = srcModelType.createInstanceAndEditor(TESTS_BUNDLE_TEST_DIR + IPath.SEPARATOR + SRC_MODELTYPE_NAME.toLowerCase() + "." + MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION, ModelOrigin.CREATED, instanceMID);
		EList<Model> transformationParameters = new BasicEList<Model>();
		transformationParameters.add(kModelRelType);
		transformationParameters.add(bankModel);
		kModelRelType.getTypeTransformationOperator(bankModel).execute(transformationParameters);
		//TODO MMTF[TESTS] test that result model + model rel are fine
		fail("TODO");
	}

}
