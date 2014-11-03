/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.library;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;

public class MIDContextMenuListener extends SelectionAdapter {

	protected String menuLabel;

	public MIDContextMenuListener(String menuLabel) {

		this.menuLabel = menuLabel;
	}

	protected void runListenerCommand(AbstractTransactionalCommand command) {

		try {
			OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR, menuLabel + " command execution error", ex);
		}
	}

}
