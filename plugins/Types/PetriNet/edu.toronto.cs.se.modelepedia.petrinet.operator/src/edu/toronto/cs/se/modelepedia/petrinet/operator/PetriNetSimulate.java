/*
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
package edu.toronto.cs.se.modelepedia.petrinet.operator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.modelepedia.petrinet.PetriNet;

public class PetriNetSimulate extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "petrinet";

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		PetriNet petrinet = (PetriNet) inputsByName.get(IN_MODEL).getEMFInstanceRoot();

		// simulate
		boolean goodResult = !petrinet.getNodes().isEmpty();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		int dialogType = (goodResult) ? MessageDialog.INFORMATION : MessageDialog.ERROR;
		String dialogMessage = (goodResult) ? "Good simulation result" : "Bad simulation result";
		MessageDialog dialog = new MessageDialog(
			shell,
			"Simulation results",
			null,
			dialogMessage,
			dialogType,
			new String[] {"Ok"},
			0
		);
		dialog.open();

		return new HashMap<>();
	}

}
