/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.mavo.diagram.outline.context.MAVODiagramOutlineContextMenu;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;

public class MAVODiagramOutlinePage extends ContentOutlinePage {

	private MAVORoot mavoRootModelObj;
	protected TreeViewer contentOutlineViewer;
	protected ComposedAdapterFactory adapterFactory;

	public MAVODiagramOutlinePage(Diagram diagram) {

		super();
		mavoRootModelObj = (MAVORoot) diagram.getElement();
		adapterFactory = GMFUtils.getAdapterFactory();
	}

	@Override
	public void createControl(Composite parent) {

		super.createControl(parent);

		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);
		contentOutlineViewer.setContentProvider(new MAVODiagramOutlineContentProvider(adapterFactory));
		contentOutlineViewer.setLabelProvider(new MAVODiagramOutlineLabelProvider(adapterFactory));
		MenuManager menuManager = new MenuManager();
		Menu contextMenu = menuManager.createContextMenu(contentOutlineViewer.getControl());
		contentOutlineViewer.getControl().setMenu(contextMenu);
		menuManager.add(new MAVODiagramOutlineContextMenu(contentOutlineViewer));
		contentOutlineViewer.setInput(mavoRootModelObj.eResource());
	}

	public void refresh() {

		contentOutlineViewer.refresh();
	}

}
