/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.annotation.NonNull;
import org.junit.BeforeClass;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public abstract class MMINTTest {

	//TODO MMINT[TESTS] Think about structuring tests in multiple project/packages
	protected final static @NonNull String TESTS_BUNDLE_NAME = "edu.toronto.cs.se.modelepedia.tests";
	private final static @NonNull String TEST_PROJECT = "edu.toronto.cs.se.modelepedia.tests";
	protected final static @NonNull String TEST_INSTANCEMID_URI = IPath.SEPARATOR + TEST_PROJECT + IPath.SEPARATOR + "instances" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;

	protected @NonNull IProject createTestProject() throws CoreException {

		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject(TEST_PROJECT);
		if (!testProject.exists()) {
			testProject.create(null);
		}
		testProject.open(null);

		return testProject;
	}

	protected @NonNull MID createInstanceMID() throws Exception {

		createTestProject();
		MID instanceMID = MIDFactory.eINSTANCE.createMID();
		FileUtils.writeModelFile(instanceMID, TEST_INSTANCEMID_URI, true);

		return instanceMID;
	}

	protected @NonNull Model addInputModel(MID instanceMID, Bundle testBundle, String bundleDir, String bundleFilename) throws Exception {

		URL bundleModelUrl = testBundle.findEntries(bundleDir, bundleFilename, false).nextElement();
		String inputModelPath = IPath.SEPARATOR + TEST_PROJECT + IPath.SEPARATOR + bundleFilename;
		Path bundlePath = Paths.get(FileLocator.toFileURL(bundleModelUrl).getFile().toString());
		Path inputPath = Paths.get(FileUtils.prependWorkspacePath(inputModelPath));
		Files.copy(bundlePath, inputPath, StandardCopyOption.REPLACE_EXISTING);
		Model inputModel =  MIDTypeHierarchy.getRootModelType().createInstance(null, inputModelPath, instanceMID);
		FileUtils.writeModelFile(instanceMID, TEST_INSTANCEMID_URI, true);

		return inputModel;
	}

	@BeforeClass
	public static void init() throws CoreException {

		//TODO MMINT[TESTS] Run it just once
		//TODO MMINT[TESTS] Warm-up z3
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceDescription description = workspace.getDescription();
		description.setAutoBuilding(false);
		workspace.setDescription(description);
		MMINT.setPreference(MMINTConstants.PREFERENCE_TESTS_ENABLED, "true");
	}

}
