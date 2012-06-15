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
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class EditModelepediaListener extends SelectionAdapter {

	private final static String MODELEPEDIA_WWW = "http://192.168.72.19:4139/modelepedia/index.php/Special:FormEdit";
	private Model modelType;
	private final static String prefix = "MMTF:";
	
	public EditModelepediaListener(Model modelType) {

		this.modelType = modelType;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		String formType = "/Model_Type/";
		String args = "?";
		String cardinality = "";
		int i = 1;
				
		if (modelType.getName() != null)
			args = args + "name=" + modelType.getName();
		if (modelType.getSupertype() != null)
			args = args + "&supertype=" + prefix + modelType.getSupertype().getName();
			
		if (modelType instanceof ModelRel) {
			formType = "/Relationship_Type/";
			
			ModelRel modelRelType = (ModelRel) modelType;
			
			if (! modelRelType.getModels().isEmpty())
				args = args + "&arguments=";
			if (modelRelType.isUnbounded()) {
				cardinality = "*";
			} else {
				cardinality = Integer.toString(modelRelType.getModels().size());
			}
			
			for (Model model : modelRelType.getModels()) {
				if (i != 1)
					args = args + ", ";
				args = args + prefix + model.getName() + ";" + cardinality;
				i++;
			}
		}
		
		
		IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();
		String url = MODELEPEDIA_WWW + formType + prefix + modelType.getName() + args;
		try {
			IWebBrowser browser = support.createBrowser("Modelepedia");
			browser.openURL(new URL(url));
		}
		catch (Exception ex) {
			MMTFException.print(MMTFException.Type.WARNING, "Error opening Modelepedia page " + url, ex);
		}
	}

}
