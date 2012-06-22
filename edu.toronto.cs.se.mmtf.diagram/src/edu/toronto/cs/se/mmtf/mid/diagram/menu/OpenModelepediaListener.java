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
package edu.toronto.cs.se.mmtf.mid.diagram.menu;

import java.net.URL;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;

public class OpenModelepediaListener extends SelectionAdapter {

	private final static String WIKI_WWW = "http://mango.cs.toronto.edu:4139/w/index.php/Special:FormEdit";
	private Model modelType;

	public OpenModelepediaListener(Model modelType) {

		this.modelType = modelType;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();
		String url = WIKI_WWW + modelType.getName();
		try {
			IWebBrowser browser = support.createBrowser("MMTF Wiki");
			browser.openURL(new URL(url));
		}
		catch (Exception ex) {
			MMTFException.print(MMTFException.Type.WARNING, "Error opening wiki page " + url, ex);
		}
	}

}
