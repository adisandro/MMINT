/*
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
package edu.toronto.cs.se.mmint.mid.diagram.contextmenu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class CastTypeListener extends SelectionAdapter {

	Model model;
	Model newMetatype;
	ITextAwareEditPart label;

	public CastTypeListener(Model model, Model newMetatype, ITextAwareEditPart label) {

		this.model = model;
		this.newMetatype = newMetatype;
		this.label = label;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent().getFile(new Path(diagramFile.getName().substring(0, diagramFile.getName().length() - MMINT.MID_DIAGRAM_SUFFIX.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		AbstractTransactionalCommand operatorCommand = new CastTypeCommand(
			TransactionUtil.getEditingDomain(model),
			"Type Cast",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operatorCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.WARNING, "Casting of " + model.getName() + " into " + newMetatype.getName() + " history execution error", ex);
		}
	}

	protected class CastTypeCommand extends AbstractTransactionalCommand {

		public CastTypeCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			model.setMetatypeUri(newMetatype.getUri());

			// change model relationship structure metatypes
			if (model instanceof ModelRel) {
				for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
					for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) {
						ModelElement modelElem = modelElemRef.getObject();
						ModelElement modelElemType;
						try {
							modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelElem.getEMFInstanceObject());
						}
						catch (MMINTException e) {
							MMINTException.print(MMINTException.Type.WARNING, "Can't get model object, skipping model element cast", e);
							continue;
						}
						if (modelElemType != null) {
							modelElem.setMetatypeUri(modelElemType.getUri());
						}
					}
				}
				for (Link link : ((ModelRel) model).getLinks()) {
					Link linkType = MultiModelConstraintChecker.getAllowedLinkType(link);
					if (linkType != null) {
						link.setMetatypeUri(linkType.getUri());
					}
				}
			}

			label.refresh();

			return CommandResult.newOKCommandResult();
		}

	}

}
