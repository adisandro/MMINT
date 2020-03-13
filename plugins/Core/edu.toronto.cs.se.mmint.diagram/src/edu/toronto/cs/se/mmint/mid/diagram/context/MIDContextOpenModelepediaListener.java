/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;

public class MIDContextOpenModelepediaListener extends SelectionAdapter {

	private final static String WIKI_WWW = "http://www.cs.toronto.edu:40404/modelepedia_local/index.php/";
	private Model modelType;

	public MIDContextOpenModelepediaListener(Model modelType) {

		this.modelType = modelType;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();
		String url = WIKI_WWW + modelType.getName();
		try {
			IWebBrowser browser = support.createBrowser("MMINT Wiki");
			browser.openURL(new URL(url));
		}
		catch (Exception ex) {
			MMINTException.print(IStatus.ERROR, "Error opening wiki page " + url, ex);
		}
	}

}
