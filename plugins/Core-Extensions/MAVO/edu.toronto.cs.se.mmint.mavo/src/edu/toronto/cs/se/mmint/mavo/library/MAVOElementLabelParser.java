/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.library;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTActivator;

//TODO MMINT[MAVO] Unify with MAVOMID cases + write javadoc
public class MAVOElementLabelParser implements IParser {

	private IStatus updateValues(EObject modelObj, String newLabel) {

		MAVOUtils.setMAVOElementLabel((MAVOElement) modelObj, newLabel);

		return Status.OK_STATUS;
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {

		EObject modelObj = (EObject) element.getAdapter(EObject.class);

		return MAVOUtils.getMAVOElementLabel((MAVOElement) modelObj, false);
	}

	@Override
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {

		MAVOElement mavoElement = (MAVOElement) element.getAdapter(edu.toronto.cs.se.mavo.MAVOElement.class);
		if (mavoElement.getCollections().size() > 0) {
			return new ParserEditStatus(
				MMINTActivator.PLUGIN_ID, ParserEditStatus.UNEDITABLE, "Please use MAVO menus to modify the element");
		}

		return ParserEditStatus.EDITABLE_STATUS;
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, final String newLabel, int flags) {

		final EObject modelObj = (EObject) element.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(modelObj);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		IFile affectedFile = WorkspaceSynchronizer.getFile(modelObj.eResource());
		return new AbstractTransactionalCommand(
			editingDomain,
			"Set Values",
			affectedFile == null ? null : Collections.singletonList(affectedFile)
		) { 
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				return new CommandResult(updateValues(modelObj, newLabel));
			}
		};
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		EObject modelObj = (EObject) element.getAdapter(EObject.class);

		return MAVOUtils.getMAVOElementLabel((MAVOElement) modelObj, true);
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
