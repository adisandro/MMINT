/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;

public class RandomModelToAlloy extends OperatorExecutableImpl {

	private static final String TXL_SCRIPT = "script/randommodel.txl";

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		URL url = RandomModelOperatorActivator.getDefault().getBundle().getEntry("/");
		String txlPath = FileLocator.toFileURL(url).getPath() + TXL_SCRIPT;
		String[] cmd = new String[] {
			"txl",
			"-l",
			workspaceUri + model.getUri(),
			txlPath
		};
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec(cmd);
		p.waitFor();

		return actualParameters;
	}

}
