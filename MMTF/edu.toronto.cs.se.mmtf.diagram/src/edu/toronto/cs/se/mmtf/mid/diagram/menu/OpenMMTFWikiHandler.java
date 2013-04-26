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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

import edu.toronto.cs.se.mmtf.MMTFException;

public class OpenMMTFWikiHandler extends AbstractHandler {
	
	private final static String WIKI_WWW = "http://www.cs.toronto.edu:40404/modelepedia_local/index.php";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();
		try {
			IWebBrowser browser = support.createBrowser("MMTF Wiki");
			browser.openURL(new URL(WIKI_WWW));
		}
		catch (Exception ex) {
			MMTFException.print(MMTFException.Type.WARNING, "Error opening wiki page " + WIKI_WWW, ex);
		}

		return null;
	}
}
