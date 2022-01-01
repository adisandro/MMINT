/**
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
package edu.toronto.cs.se.mmint.mid.diagram.context;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class MIDContextCastTypeListener extends MIDContextMenuListener {

	private Model model;
	private Model newMetatype;
	private ITextAwareEditPart label;

	public MIDContextCastTypeListener(String menuLabel, Model model, Model newMetatype, ITextAwareEditPart label) {

		super(menuLabel);
		this.model = model;
		this.newMetatype = newMetatype;
		this.label = label;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MIDContextCastTypeCommand(
			TransactionUtil.getEditingDomain(this.model),
			this.menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
	}

	protected class MIDContextCastTypeCommand extends AbstractTransactionalCommand {

		public MIDContextCastTypeCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			MIDContextCastTypeListener.this.model.setMetatypeUri(MIDContextCastTypeListener.this.newMetatype.getUri());

			// change model relationship structure metatypes
			if (MIDContextCastTypeListener.this.model instanceof ModelRel) {
			    for (ModelEndpoint modelEndpoint : ((ModelRel) MIDContextCastTypeListener.this.model).getModelEndpoints()) {
			        modelEndpoint.setMetatypeUri(
			            MIDConstraintChecker.getAllowedModelEndpoints(
			                (ModelRel) MIDContextCastTypeListener.this.model, null, modelEndpoint.getTarget()).get(0));
			    }
				for (ModelEndpointReference modelEndpointRef : ((ModelRel) MIDContextCastTypeListener.this.model).getModelEndpointRefs()) {
					for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) {
						ModelElement modelElem = modelElemRef.getObject();
						ModelElement modelElemType = MIDConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelElem.getEMFInstanceObject());
						if (modelElemType != null) {
							modelElem.setMetatypeUri(modelElemType.getUri());
						}
					}
				}
				for (Mapping mapping : ((ModelRel) MIDContextCastTypeListener.this.model).getMappings()) {
					Mapping mappingType = MIDConstraintChecker.getAllowedMappingType(mapping);
					if (mappingType != null) {
						mapping.setMetatypeUri(mappingType.getUri());
					}
				}
			}

			MIDContextCastTypeListener.this.label.refresh();

			return CommandResult.newOKCommandResult();
		}

	}

}
