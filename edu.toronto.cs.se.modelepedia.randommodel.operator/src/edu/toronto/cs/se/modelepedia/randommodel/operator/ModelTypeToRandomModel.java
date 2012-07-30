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

import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.OperatorUtils;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandommodelPackage;

public class ModelTypeToRandomModel extends ConversionOperatorExecutableImpl {

	private static final String TYPEGRAPH_SUFFIX = "_typegraph_";
	private Model newElement;
	/** Min number of instances in the random model. */
	private static final String PROPERTY_MININSTANCES = "minInstances";
	/** Max number of instances in the random model. */
	private static final String PROPERTY_MAXINSTANCES = "maxInstances";

	private int minInstances;
	private int maxInstances;

	private void readProperties(Properties properties) throws Exception {

		minInstances = OperatorUtils.getIntProperty(properties, PROPERTY_MININSTANCES);
		maxInstances = OperatorUtils.getIntProperty(properties, PROPERTY_MAXINSTANCES);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// convert and serialize
		Model model = actualParameters.get(0);
		Properties inputProperties = OperatorUtils.getInputPropertiesFile(this, model, null, false);
		readProperties(inputProperties);
		String baseUri = model.getUri().substring(0, model.getUri().lastIndexOf(IPath.SEPARATOR)+1);
		String typegraphUri =
			baseUri +
			model.getType() +
			TYPEGRAPH_SUFFIX +
			(new Date()).getTime() +
			"." + RandommodelPackage.eNAME;
		EcoreToRandomModel atl = new EcoreToRandomModel();
		atl.loadModels(model.getMetatype().getUri());
		atl.doEcoreToRandomModel(new NullProgressMonitor());
		atl.saveModels(typegraphUri);

		EList<Model> result = new BasicEList<Model>();
		if (!OperatorUtils.isUpdatingMid(inputProperties)) {
			return result;
		}

		// create model
		URI modelUri = URI.createPlatformResourceURI(typegraphUri, true);
		MultiModel owner = (MultiModel) model.eContainer();
		MultiModelInstanceFactory.assertModelUnique(owner, modelUri);
		newElement = MultiModelInstanceFactory.createModel(null, ModelOrigin.CREATED, owner, modelUri);
		Editor editor = MultiModelInstanceFactory.createEditor(newElement);
		if (editor != null) {
			MultiModelInstanceFactory.addModelEditor(editor, owner);
		}
		result.add(newElement);

		// set min and max number of instances
		RandomModel root = (RandomModel) newElement.getRoot();
		root.setDefaultMinimumNumberOfInstances(minInstances);
		root.setDefaultMaximumNumberOfInstances(maxInstances);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(newElement.getUri(), true));
		resource.getContents().add(root);
		FileOutputStream out = new FileOutputStream(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + newElement.getUri());
		resource.save(out, null);

		return result;
	}

	@Override
	public void cleanup() throws Exception {

		if (newElement != null) {
			MultiModelInstanceFactory.removeModel(newElement);
			((MultiModel) newElement.eContainer()).getModels().remove(newElement);
			IPath path = new Path(newElement.getUri());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			file.delete(true, null);
			newElement = null;
		}
	}

}
