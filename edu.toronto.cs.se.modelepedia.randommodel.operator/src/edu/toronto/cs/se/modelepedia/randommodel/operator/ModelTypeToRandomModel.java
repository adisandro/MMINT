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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;
import edu.toronto.cs.se.modelepedia.randommodel.RandommodelPackage;

public class ModelTypeToRandomModel extends ConversionOperatorExecutableImpl {

	private static final String FILE_SUFFIX = "_typegraph_";
	private Model newElement;

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		if (actualParameters.size() != 1 || !(actualParameters.get(0) instanceof Model)) {
			throw new MMTFException("Bad operator parameters");
		}

		// convert and serialize
		Model model = actualParameters.get(0);
		String uri = model.getUri();
		uri = uri.substring(0, uri.lastIndexOf(IPath.SEPARATOR)+1) +
			model.getType() +
			FILE_SUFFIX +
			(new Date()).getTime() +
			"." + RandommodelPackage.eNAME;
		EcoreToRandomModel atl = new EcoreToRandomModel();
		atl.loadModels(model.getMetatype().getUri());
		atl.doEcoreToRandomModel(new NullProgressMonitor());
		atl.saveModels(uri);

		// create model
		URI modelUri = URI.createPlatformResourceURI(uri, true);
		MultiModel owner = (MultiModel) model.eContainer();
		MultiModelFactoryUtils.assertModelUnique(owner, modelUri);
		newElement = MultiModelFactoryUtils.createModel(null, ModelOrigin.CREATED, owner, modelUri);
		Editor editor = MultiModelFactoryUtils.createEditor(newElement);
		if (editor != null) {
			MultiModelFactoryUtils.addModelEditor(editor, owner);
		}

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
