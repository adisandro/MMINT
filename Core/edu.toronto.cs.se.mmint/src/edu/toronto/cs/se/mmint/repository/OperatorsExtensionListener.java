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
package edu.toronto.cs.se.mmint.repository;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Operators extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class OperatorsExtensionListener extends MMINTExtensionListener {

	/**
	 * {@inheritDoc}
	 * Installs a new Operators extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		IConfigurationElement[] configs;
		for (IExtension extension : extensions) {
			configs = extension.getConfigurationElements();
			for (IConfigurationElement config : configs) {
				try {
					Operator newOperatorType = MMINT.createOperatorType(config);
					MMINT.createOperatorTypeParameters(config, newOperatorType);
					if (newOperatorType instanceof ConversionOperator) {
						MultiModelTypeFactory.createOperatorTypeConversion((ConversionOperator) newOperatorType);
					}
				}
				catch (MMINTException e) {
					MMINTException.print(Type.ERROR, "Operator type can't be created in " + config.getContributor().getName(), e);
				}
			}
		}
		MMINT.storeRepository();
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls an Operators extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		IConfigurationElement[] configs;
		for (IExtension extension : extensions) {
			configs = extension.getConfigurationElements();
			for (IConfigurationElement config : configs) {
				String uri = config.getAttribute(MMINT.TYPE_ATTR_URI);
				Operator operatorType = MultiModelTypeRegistry.getType(uri);
				if (operatorType != null) {
					try {
						operatorType.deleteType();
					}
					catch (MMINTException e) {
						// never happens by construction
					}
				}
			}
		}
		MMINT.storeRepository();
	}

}
