/**
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
package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Operators extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class OperatorsExtensionListener extends MMTFExtensionListener {

	/**
	 * {@inheritDoc}
	 * Installs a new Operators extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		MultiModel multiModel;
		try {
			multiModel = MultiModelTypeRegistry.getTypeMidRepository();
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Could not locate Type MID", e);
			return;
		}

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				MMTF.createOperatorType(multiModel, elem);
				MMTF.syncRepository(multiModel);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls an Operators extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		MultiModel multiModel;
		try {
			multiModel = MultiModelTypeRegistry.getTypeMidRepository();
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Could not locate Type MID", e);
			return;
		}

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				String uri = elem.getAttribute(MMTF.EXTENDIBLEELEMENT_ATTR_URI);
				Operator operatorType = MultiModelTypeRegistry.getOperatorType(multiModel, uri);
				if (operatorType != null) {
					operatorType = MultiModelTypeFactory.removeOperatorType(operatorType);
					MMTF.syncRepository(multiModel);
				}
			}
		}
	}

}
