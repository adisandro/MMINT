/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.randommodel.operator;

import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

public class RandomModelGenerate extends OperatorExecutableImpl {

	private static final String RANDOM_SUFFIX = "_random";
	private static final String MAVOELEMS_FILEEXTENSION = "mavoelems";
	private static final String PYTHON_SCRIPT = "script/graph_gen.py";
	/** % of annotated elements in the random model. */
	private static final String PROPERTY_IN_ANNOTATIONS = "annotations";
	/** % of may elements among the annotated elements. */
	private static final String PROPERTY_IN_MAY = "may";
	/** % of set elements among the annotated elements. */
	private static final String PROPERTY_IN_SET = "set";
	/** % of var elements among the annotated elements. */
	private static final String PROPERTY_IN_VAR = "var";
	/** The initial seed for the pseudorandom generator. */
	private static final String PROPERTY_IN_SEED = "seed";
	/** The default initial seed for the pseudorandom generator. */
	private static final String PROPERTY_IN_SEED_DEFAULT = null;
	/** The file name for loading/saving the random generator internal state. */
	private static final String PROPERTY_IN_STATE = "state";
	/** The default file name for loading/saving the random generator internal state. */
	private static final String PROPERTY_IN_STATE_DEFAULT = null;

	private double annotations;
	private double may;
	private double set;
	private double var;
	private String seed;
	private String state;

	private void readProperties(Properties properties) throws Exception {

		annotations = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_ANNOTATIONS);
		may = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_MAY);
		set = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_SET);
		var = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_VAR);
		seed = MultiModelOperatorUtils.getOptionalStringProperty(properties, PROPERTY_IN_SEED, PROPERTY_IN_SEED_DEFAULT);
		state = MultiModelOperatorUtils.getOptionalStringProperty(properties, PROPERTY_IN_STATE, PROPERTY_IN_STATE_DEFAULT);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model typegraphModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			typegraphModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);

		// create random instance
		String modelType = ((RandomModel) MultiModelTypeIntrospection.getRoot(typegraphModel)).getName();
		String newLastSegmentUri = modelType + RANDOM_SUFFIX + (new Date()).getTime() + MultiModelRegistry.ECORE_MODEL_FILEEXTENSION_SEPARATOR + RandomModelPackage.eNAME;
		String subdir = MultiModelOperatorUtils.getSubdir(inputProperties);
		if (subdir != null) {
			newLastSegmentUri = subdir + MMTF.URI_SEPARATOR + newLastSegmentUri;
		}
		String newRandommodelModelUri = MultiModelRegistry.replaceLastSegmentInUri(typegraphModel.getUri(), newLastSegmentUri);
		String newMavoElemsFileUri = MultiModelRegistry.replaceFileExtensionInUri(newRandommodelModelUri, MAVOELEMS_FILEEXTENSION); 
		URL url = RandomModelOperatorActivator.getDefault().getBundle().getEntry("/");
		String pythonPath = FileLocator.toFileURL(url).getPath() + PYTHON_SCRIPT;
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		String[] cmd = new String[] {
			"python",
			pythonPath,
			"-input",
			workspaceUri + typegraphModel.getUri(),
			"-outgraph",
			workspaceUri + newRandommodelModelUri,
			"-outmavoelems",
			workspaceUri + newMavoElemsFileUri,
			"-instname",
			newRandommodelModelUri,
			"-annotated",
			String.valueOf(annotations),
			"-may",
			String.valueOf(may),
			"-set",
			String.valueOf(set),
			"-var",
			String.valueOf(var)
		};
		if (seed != null) {
			String[] cmd2 = new String[cmd.length+2];
			System.arraycopy(cmd, 0, cmd2, 0, cmd.length);
			System.arraycopy(new String[] {"-seed", seed}, 0, cmd2, cmd.length, 2);
			cmd = cmd2;
		}
		if (state != null) {
			String[] cmd2 = new String[cmd.length+2];
			System.arraycopy(cmd, 0, cmd2, 0, cmd.length);
			System.arraycopy(new String[] {"-state", state}, 0, cmd2, cmd.length, 2);
			cmd = cmd2;
		}
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec(cmd);
		rt.exec(cmd);
		p.waitFor();

		// create model
		EList<Model> result = new BasicEList<Model>();
		boolean updateMid = MultiModelOperatorUtils.isUpdatingMid(inputProperties);
		MultiModel multiModel = (updateMid) ?
			MultiModelRegistry.getMultiModel(typegraphModel) :
			null;
		Model newRandommodelModel = (updateMid) ?
			MultiModelMAVOInstanceFactory.createModelAndEditor(null, newRandommodelModelUri, ModelOrigin.CREATED, multiModel) :
			MultiModelMAVOInstanceFactory.createModel(null, newRandommodelModelUri, ModelOrigin.CREATED, null);
		result.add(newRandommodelModel);

		return result;
	}

}
