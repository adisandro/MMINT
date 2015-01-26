/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Initial implementation.
 *    Alessio Di Sandro - Refactoring and fixes.
 */
package edu.toronto.cs.se.mmint.mavo.diagram.outline;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.diagram.outline.context.MAVODiagramOutlineContextMenu;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVODiagramOutlinePage extends ContentOutlinePage {

	private MAVOModel mavoRootModelObj;
	protected TreeViewer contentOutlineViewer;
	protected ComposedAdapterFactory adapterFactory;

	public MAVODiagramOutlinePage(Diagram diagram) {

		super();
		mavoRootModelObj = (MAVOModel) diagram.getElement();
		adapterFactory = GMFDiagramUtils.getAdapterFactory();
	}

	@Override
	public void createControl(Composite parent) {

		super.createControl(parent);

		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);
		contentOutlineViewer.setContentProvider(new MAVODiagramOutlineContentProvider(adapterFactory));
		contentOutlineViewer.setLabelProvider(new MAVODiagramOutlineLabelProvider(adapterFactory));
		//TODO MMINT[MU-MMINT] Review
		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				manager.add(new MAVODiagramOutlineContextMenu(contentOutlineViewer));
			}
		});
		contentOutlineViewer.getControl().setMenu(manager.createContextMenu(contentOutlineViewer.getControl()));
		contentOutlineViewer.setInput(mavoRootModelObj.eResource());
	}

	//TODO MMINT[MU-MMINT] Review the need for refresh, if not needed just remove the function
	public void selectionChanged(SelectionChangedEvent event) {

		super.selectionChanged(event);
		contentOutlineViewer.refresh();
	}

}
