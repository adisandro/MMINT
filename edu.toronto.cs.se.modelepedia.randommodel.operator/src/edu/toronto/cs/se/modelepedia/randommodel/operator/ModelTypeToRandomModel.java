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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;
import edu.toronto.cs.se.modelepedia.randommodel.RandommodelPackage;

public class ModelTypeToRandomModel extends ConversionOperatorExecutableImpl {

	private static final String TYPEGRAPH_SUFFIX = "_typegraph_";
	private static final String RANDOM_SUFFIX = "_random_";
	private static final String PYTHON_SCRIPT = "/python/graph_gen.py";
	private Model newElement;

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// convert and serialize
		Model model = actualParameters.get(0);
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

		// create model
		URI modelUri = URI.createPlatformResourceURI(typegraphUri, true);
		MultiModel owner = (MultiModel) model.eContainer();
		MultiModelFactoryUtils.assertModelUnique(owner, modelUri);
		newElement = MultiModelFactoryUtils.createModel(null, ModelOrigin.CREATED, owner, modelUri);
		Editor editor = MultiModelFactoryUtils.createEditor(newElement);
		if (editor != null) {
			MultiModelFactoryUtils.addModelEditor(editor, owner);
		}

		// create random instance
		String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		String randomUri =
			baseUri +
			model.getType() +
			RANDOM_SUFFIX +
			(new Date()).getTime() +
			"." + RandommodelPackage.eNAME;
		URL url = RandomModelOperatorActivator.getDefault().getBundle().getEntry(PYTHON_SCRIPT);
		String pythonPath = FileLocator.toFileURL(url).toString().substring(5); // cuts "file:/"
		String[] cmd = new String[] {
			"python",
			pythonPath,
			"-input",
			workspace + typegraphUri,
			"-output",
			workspace + randomUri,
			"-instname",
			randomUri
		};
		Runtime rt = Runtime.getRuntime();
		rt.exec(cmd);
		//TODO MMTF: get supported example metamodels, call refresh

		EList<Model> result = new BasicEList<Model>();
		result.add(newElement);

		return result;
	}

	@Override
	public void cleanup() throws Exception {

		if (newElement != null) {
			MultiModelFactoryUtils.removeModel(newElement);
			((MultiModel) newElement.eContainer()).getModels().remove(newElement);
			IPath path = new Path(newElement.getUri());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			file.delete(true, null);
			newElement = null;
		}
	}

}
