/*
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.RulerGridPreferencePage;

import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramRulersAndGridPreferencePage extends RulerGridPreferencePage {

	/**
	 * @generated
	 */
	public DiagramRulersAndGridPreferencePage() {
		setPreferenceStore(IStarDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}
