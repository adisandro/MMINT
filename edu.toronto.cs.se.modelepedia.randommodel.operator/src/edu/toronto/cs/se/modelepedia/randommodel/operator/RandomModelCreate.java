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

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.modelepedia.randommodel.RandommodelPackage;

public class RandomModelCreate extends OperatorExecutableImpl {

	private static final String FILE_SUFFIX = "_typegraph_";

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);
		Model modelType = model.getMetatype();
		EPackage modelTypePackage = (EPackage) modelType.getRoot();
		String uri = model.getUri();
		uri = uri.substring(0, uri.lastIndexOf(IPath.SEPARATOR)+1) +
			modelTypePackage.getName() +
			FILE_SUFFIX +
			(new Date()).getTime() +
			"." + RandommodelPackage.eNAME;

		EcoreToRandomModel atl = new EcoreToRandomModel();
		atl.loadModels(modelType.getUri());
		atl.doEcoreToRandomModel(new NullProgressMonitor());
		atl.saveModels(uri);

		return null;
	}

}
