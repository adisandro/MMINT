/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

public class RelationshipDiagramOutlineLabelProvider extends AdapterFactoryLabelProvider {

	private boolean isInstancesLevel;

	public RelationshipDiagramOutlineLabelProvider(AdapterFactory adapterFactory, boolean isInstancesLevel) {

		super(adapterFactory);
		this.isInstancesLevel = isInstancesLevel;
	}

	@Override
	public String getText(Object object) {

		String text = "";
		if (isInstancesLevel && (boolean) MMTF.getSetting(MMTFConstants.SETTING_MENU_ALTERNATIVE_MODEL_TREE_ENABLED) && (object instanceof AttributeValueWrapperItemProvider || object instanceof EObject)) {
			text += "[";
			if (object instanceof AttributeValueWrapperItemProvider) {
				text += ((AttributeValueWrapperItemProvider) object).getFeature().getName();
			}
			if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				text += (eObject.eContainingFeature() == null) ? "root" : eObject.eContainingFeature().getName();
			}
			text += "] ";
		}
		text += super.getText(object);

		return text;
	}

}
