/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.ui;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.mid.EMFInfo;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.PrimitiveEObjectWrapper;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

public class ModelElementLabelProvider extends AdapterFactoryLabelProvider {

	private MidLevel level;

	public ModelElementLabelProvider(AdapterFactory adapterFactory, MidLevel level) {

		super(adapterFactory);
		this.level = level;
	}

	@Override
	public String getText(Object object) {

		String text;
		if (level == MidLevel.INSTANCES && (boolean) MMTF.getSetting(MMTFConstants.SETTING_MENU_ALTERNATIVE_MODEL_TREE_ENABLED) && (object instanceof AttributeValueWrapperItemProvider || object instanceof EObject)) {
			if (object instanceof AttributeValueWrapperItemProvider) {
				object = new PrimitiveEObjectWrapper((AttributeValueWrapperItemProvider) object);
			}
			EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo((EObject) object, MidLevel.INSTANCES);
			text = eInfo.toInstanceString();
			if (object instanceof PrimitiveEObjectWrapper) {
				text = text.replace(MMTF.MODELELEMENT_PRIMITIVEVALUE_PLACEHOLDER, ((PrimitiveEObjectWrapper) object).getValue().toString());
				text = text.replace(MMTF.MODELELEMENT_EMFVALUE_PLACEHOLDER, super.getText(((PrimitiveEObjectWrapper) object).getOwner()));
			}
			else {
				text = text.replace(MMTF.MODELELEMENT_EMFVALUE_PLACEHOLDER, super.getText(object));
			}
		}
		else {
			text = super.getText(object);
		}

		return text;
	}

}
