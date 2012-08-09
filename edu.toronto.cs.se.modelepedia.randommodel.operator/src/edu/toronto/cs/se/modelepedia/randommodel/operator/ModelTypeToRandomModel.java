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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandommodelPackage;

public class ModelTypeToRandomModel extends ConversionOperatorExecutableImpl {

	private static final String TYPEGRAPH_SUFFIX = "_typegraph_";
	private Model newElement;
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

		// convert and serialize
		Model model = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			model,
			null,
			false,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		String baseUri = model.getUri().substring(0, model.getUri().lastIndexOf(IPath.SEPARATOR)+1);
		String modelType = ((EPackage) model.getMetatype().getRoot()).getName();
		String typegraphUri =
			baseUri +
			modelType +
			TYPEGRAPH_SUFFIX +
			(new Date()).getTime() +
			"." + RandommodelPackage.eNAME;
		EcoreToRandomModel atl = new EcoreToRandomModel();
		atl.loadModels(model.getMetatype().getUri());
		atl.doEcoreToRandomModel(new NullProgressMonitor());
		atl.saveModels(typegraphUri);

		// create model
		EList<Model> result = new BasicEList<Model>();
		updateMid = MultiModelOperatorUtils.isUpdatingMid(inputProperties);
		URI modelUri = URI.createPlatformResourceURI(typegraphUri, true);
		MultiModel owner;
		if (updateMid) {
			owner = (MultiModel) model.eContainer();
			MultiModelInstanceFactory.assertModelUnique(owner, modelUri);
		}
		else {
			owner = null;
		}
		newElement = MultiModelInstanceFactory.createModel(null, ModelOrigin.CREATED, owner, modelUri);
		if (updateMid) {
			Editor editor = MultiModelInstanceFactory.createEditor(newElement);
			if (editor != null) {
				MultiModelInstanceFactory.addModelEditor(editor, owner);
			}
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
			if (updateMid) {
				MultiModelInstanceFactory.removeModel(newElement);
				((MultiModel) newElement.eContainer()).getModels().remove(newElement);
			}
			IPath path = new Path(newElement.getUri());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			file.delete(true, null);
			newElement = null;
		}
	}

}
