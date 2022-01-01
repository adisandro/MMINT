/*
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;

public abstract class MIDDiagramLabelParser implements IParser {

	protected abstract IStatus updateValues(ExtendibleElement midElement, String newLabel);

	@Override
	public ICommand getParseCommand(IAdaptable element, final String newLabel, int flags) {

		final ExtendibleElement midElement = (ExtendibleElement) element.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(midElement);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		IFile affectedFile = WorkspaceSynchronizer.getFile(midElement.eResource());
		return new AbstractTransactionalCommand(
			editingDomain,
			"Set Values",
			affectedFile == null ? null : Collections.singletonList(affectedFile)
		) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				return new CommandResult(updateValues(midElement, newLabel));
			}
		};
	}

	@Override
	public boolean isAffectingEvent(Object event, int flags) {

		return true;
	}

	@Override
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {

		return null;
	}

}
