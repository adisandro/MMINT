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

import java.net.URL;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class EditModelepediaListener extends SelectionAdapter {

	private final static String WIKI_WWW = "http://www.cs.toronto.edu:40404/modelepedia_local/index.php/Special:FormEdit";
	private Model modelType;
	
	public EditModelepediaListener(Model modelType) {

		this.modelType = modelType;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		String formType = "/Model_Type/";
		String args = "?";
		int i = 1;
				
		if (modelType.getName() != null)
			args = args + "name=" + modelType.getName();
		if (modelType.getSupertype() != null)
			args = args + "&supertype=" + modelType.getSupertype().getName();
			
		if (modelType instanceof ModelRel) {
			formType = "/Relationship_Type/";
			
			ModelRel modelRelType = (ModelRel) modelType;
			
			if (!modelRelType.getModelEndpoints().isEmpty())
				args = args + "&arguments=";
			
			for (ModelEndpoint modelEndpoint : modelRelType.getModelEndpoints()) {
				if (i != 1)
					args = args + ", ";
				args = args + modelEndpoint.getName() + ";" + modelEndpoint.getTarget().getName();
				i++;
			}
		}
		
		
		IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();
		String url = WIKI_WWW + formType + modelType.getName() + args;
		try {
			IWebBrowser browser = support.createBrowser("MMTF Wiki");
			browser.openURL(new URL(url));
		}
		catch (Exception ex) {
			MMTFException.print(MMTFException.Type.WARNING, "Error opening wiki page " + url, ex);
		}
	}

}
