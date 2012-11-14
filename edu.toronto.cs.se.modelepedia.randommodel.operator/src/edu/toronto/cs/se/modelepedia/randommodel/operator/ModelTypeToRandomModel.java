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

import java.util.Date;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

public class ModelTypeToRandomModel extends ConversionOperatorExecutableImpl {

	private static final String TYPEGRAPH_SUFFIX = "_typegraph";
	private Model newTypegraphModel;
	private boolean updateMid;
	/** Min number of instances in the random model. */
	private static final String PROPERTY_IN_MININSTANCES = "minInstances";
	/** Max number of instances in the random model. */
	private static final String PROPERTY_IN_MAXINSTANCES = "maxInstances";

	private int minInstances;
	private int maxInstances;

	private void readProperties(Properties properties) throws Exception {

		minInstances = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MININSTANCES);
		maxInstances = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MAXINSTANCES);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			model,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		if (minInstances > maxInstances) {
			throw new MMTFException("minInstances (" + minInstances + ") > maxInstances (" + maxInstances + ")");
		}

		// convert and serialize
		String modelType = ((EPackage) model.getMetatype().getRoot()).getName();
		String newLastSegmentUri = modelType + TYPEGRAPH_SUFFIX + (new Date()).getTime() + MultiModelRegistry.ECORE_MODEL_FILEEXTENSION_SEPARATOR + RandomModelPackage.eNAME;
		String subdir = MultiModelOperatorUtils.getSubdir(inputProperties);
		if (subdir != null) {
			// atl will take care of subdir creation
			newLastSegmentUri = subdir + MMTF.URI_SEPARATOR + newLastSegmentUri;
		}
		String newTypegraphModelUri = MultiModelRegistry.replaceLastSegmentInUri(model.getUri(), newLastSegmentUri);
		EcoreToRandomModel atl = new EcoreToRandomModel();
		atl.loadModels(model.getMetatype().getUri());
		atl.doEcoreToRandomModel(new NullProgressMonitor());
		atl.saveModels(newTypegraphModelUri);

		// create model
		EList<Model> result = new BasicEList<Model>();
		updateMid = MultiModelOperatorUtils.isUpdatingMid(inputProperties);
		MultiModel multiModel = (updateMid) ?
			MultiModelRegistry.getMultiModel(model) :
			null;
		newTypegraphModel = (updateMid) ?
			MultiModelMAVOInstanceFactory.createModelAndEditor(null, newTypegraphModelUri, ModelOrigin.CREATED, multiModel) :
			MultiModelMAVOInstanceFactory.createModel(null, newTypegraphModelUri, ModelOrigin.CREATED, null);
		result.add(newTypegraphModel);

		// set min and max number of instances and reserialize
		RandomModel root = (RandomModel) newTypegraphModel.getRoot();
		root.setDefaultMinimumNumberOfInstances(minInstances);
		root.setDefaultMaximumNumberOfInstances(maxInstances);
		MultiModelTypeIntrospection.writeRoot(root, newTypegraphModel.getUri(), true);

		return result;
	}

	@Override
	public void cleanup() throws Exception {

		if (newTypegraphModel != null) {
			if (updateMid) {
				MultiModelInstanceFactory.removeModel(newTypegraphModel);
			}
			IPath path = new Path(newTypegraphModel.getUri());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			file.delete(true, null);
			newTypegraphModel = null;
		}
	}

}
