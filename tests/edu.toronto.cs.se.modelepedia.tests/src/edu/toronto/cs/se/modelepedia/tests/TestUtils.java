/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;

public class TestUtils {

	//TODO MMINT[TESTS] Think about structuring tests in multiple project/packages
	public final static @NonNull String TESTS_BUNDLE_NAME = "edu.toronto.cs.se.modelepedia.tests";
	private final static @NonNull String TESTS_TESTPROJECT = "edu.toronto.cs.se.modelepedia.tests";
	private final static @NonNull String TESTS_INSTANCEMID_URI = IPath.SEPARATOR + TESTS_TESTPROJECT + IPath.SEPARATOR + "instances" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;

	public static @NonNull IProject createTestProject() throws CoreException {

		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTS_TESTPROJECT);
		testProject.create(null);
		testProject.open(null);

		return testProject;
	}

	public static @NonNull MultiModel createInstanceMID() throws Exception {

		createTestProject();
		MultiModel instanceMID = MIDFactory.eINSTANCE.createMultiModel();
		MultiModelUtils.createModelFile(instanceMID, TESTS_INSTANCEMID_URI, true);

		return instanceMID;
	}

	public static @NonNull Model addInputModel(MultiModel instanceMID, Bundle testBundle, String bundleDir, String bundleFilename) throws Exception {

		URL bundleModelUrl = testBundle.findEntries(bundleDir, bundleFilename, false).nextElement();
		String inputModelUri = IPath.SEPARATOR + TESTS_TESTPROJECT + IPath.SEPARATOR + bundleFilename;
		MultiModelUtils.copyTextFileAndReplaceText(
			FileLocator.toFileURL(bundleModelUrl).getFile().toString(),
			MultiModelUtils.prependWorkspaceToUri(inputModelUri),
			null,
			null,
			false
		);
		Model inputModel =  MultiModelTypeHierarchy.getRootModelType().createInstanceAndEditor(inputModelUri, ModelOrigin.CREATED, instanceMID);
		MultiModelUtils.createModelFile(instanceMID, TESTS_INSTANCEMID_URI, true);

		return inputModel;
	}

}
