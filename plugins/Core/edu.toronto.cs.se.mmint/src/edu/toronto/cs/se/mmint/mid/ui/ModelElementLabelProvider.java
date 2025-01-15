/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.ui;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.PrimitiveEObjectWrapper;

public class ModelElementLabelProvider extends AdapterFactoryLabelProvider {

	private MIDLevel level;

	public ModelElementLabelProvider(AdapterFactory adapterFactory, MIDLevel level) {

		super(adapterFactory);
		this.level = level;
	}

	@Override
	public String getText(Object object) {

		String text;
		if (level == MIDLevel.INSTANCES && (object instanceof AttributeValueWrapperItemProvider || object instanceof EObject)) {
			if (object instanceof AttributeValueWrapperItemProvider) {
				object = new PrimitiveEObjectWrapper((AttributeValueWrapperItemProvider) object);
			}
			EMFInfo eInfo = MIDRegistry.getModelElementEMFInfo((EObject) object, MIDLevel.INSTANCES);
			text = eInfo.toInstanceString();
			if (object instanceof PrimitiveEObjectWrapper) {
				text = text.replace(MMINT.MODELELEMENT_PRIMITIVEVALUE_PLACEHOLDER, ((PrimitiveEObjectWrapper) object).getValue().toString());
				text = text.replace(MMINT.MODELELEMENT_EMFVALUE_PLACEHOLDER, super.getText(((PrimitiveEObjectWrapper) object).getOwner()));
			}
			else {
				text = text.replace(MMINT.MODELELEMENT_EMFVALUE_PLACEHOLDER, super.getText(object));
			}
		}
		else {
			text = super.getText(object);
		}

		return text;
	}

}
