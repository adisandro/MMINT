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
package edu.toronto.cs.se.mmtf.mid.diagram.contextmenu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.OnConnectionLocator;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.gef.ui.internal.figures.RelativeToBorderLocator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

public class ValidateListener extends SelectionAdapter {

	Model model;
	GraphicalEditPart editPart;

	public ValidateListener(Model model, GraphicalEditPart editPart) {

		this.model = model;
		this.editPart = editPart;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		files.add((IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class));
		//TODO MMTF: need domain file too?
		AbstractTransactionalCommand operatorCommand = new ValidateCommand(
			TransactionUtil.getEditingDomain(model),
			"Validate",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operatorCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMTFException.print(Type.WARNING, "Validation of " + model.getName() + " history execution error", ex);
		}
	}

	protected class ValidateCommand extends AbstractTransactionalCommand {

		public ValidateCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			// remove previous decorations
			List<Decoration> decorations = new ArrayList<Decoration>();
			for (Object decoration : editPart.getViewer().getVisualPartMap().keySet()) {
				if (decoration instanceof Decoration) {
					decorations.add((Decoration) decoration);
				}
			}
			for (Decoration decoration : decorations) {
				((IFigure) decoration).getParent().remove((IFigure) decoration);
				editPart.getViewer().getVisualPartMap().remove(decoration);
			}

			// check constraint
            boolean result = MultiModelConstraintChecker.checkConstraint(model, model.getMetatype().getConstraint());

            // add error decoration
			if (result == false) {
				Image image = MidDiagramEditorPlugin.getInstance().getBundledImage("icons/failedValidation.gif");
				if (editPart instanceof ShapeEditPart) {
					IMapMode mm = MapModeUtil.getMapMode(editPart.getFigure());
					ImageFigureEx figure = new ImageFigureEx();
					figure.setImage(image);
					figure.setSize(mm.DPtoLP(image.getBounds().width), mm.DPtoLP(image.getBounds().height));
					Decoration decoration = new Decoration();
					decoration.add(figure);
					decoration.setSize(figure.getSize());
		            decoration.setOwnerFigure(editPart.getFigure());
					decoration.setLocator(new RelativeToBorderLocator(editPart.getFigure(), PositionConstants.CENTER, 0));
		            editPart.getViewer().getVisualPartMap().put(decoration, editPart);
					IFigure pane = LayerManager.Helper.find(editPart).getLayer(DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);
					pane.add(decoration);
				}
				else if (editPart instanceof ConnectionEditPart) {
					IMapMode mm = MapModeUtil.getMapMode(editPart.getFigure());
					ImageFigureEx figure = new ImageFigureEx();
					figure.setImage(image);
					figure.setSize(mm.DPtoLP(image.getBounds().width), mm.DPtoLP(image.getBounds().height));
					Decoration decoration = new Decoration();
					decoration.add(figure);
					decoration.setSize(figure.getSize());
			        decoration.setOwnerFigure(editPart.getFigure());
					decoration.setLocator(new OnConnectionLocator((Connection) editPart.getFigure(), 50));
					editPart.getViewer().getVisualPartMap().put(decoration, editPart);
					IFigure pane = LayerManager.Helper.find(editPart).getLayer(DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);
					pane.add(decoration);
				}
			}

			return CommandResult.newOKCommandResult();
		}

	}

}
