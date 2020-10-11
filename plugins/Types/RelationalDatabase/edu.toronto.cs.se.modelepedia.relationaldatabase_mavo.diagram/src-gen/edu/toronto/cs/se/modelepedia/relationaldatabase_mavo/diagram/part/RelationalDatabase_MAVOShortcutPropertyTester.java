/*
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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class RelationalDatabase_MAVOShortcutPropertyTester extends PropertyTester {

	/**
	* @generated
	*/
	protected static final String SHORTCUT_PROPERTY = "isShortcut"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
		if (false == receiver instanceof View) {
			return false;
		}
		View view = (View) receiver;
		if (SHORTCUT_PROPERTY.equals(method)) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.MODEL_ID
						.equals(annotation.getDetails().get("modelID")); //$NON-NLS-1$
			}
		}
		return false;
	}

}
