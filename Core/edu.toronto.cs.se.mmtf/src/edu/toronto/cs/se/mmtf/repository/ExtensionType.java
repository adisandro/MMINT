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
package edu.toronto.cs.se.mmtf.repository;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * An extendible type created from an edu.toronto.cs.se.mmtf.extendibles
 * extension.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ExtensionType {

	/** The uri of the extendible type. */
	private String uri;
	/** The name of the extendible type. */
	private String name;
	/** The uri of the supertype of the extendible type. */
	private String supertypeUri;

	/**
	 * Constructor: reads the extension and gets the info for the extendible
	 * type.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 */
	public ExtensionType(IConfigurationElement extensionConfig) {

		IConfigurationElement typeConfig = extensionConfig.getChildren(MMTFConstants.CHILD_EXTENDIBLETYPE)[0];
		uri = typeConfig.getAttribute(MMTFConstants.EXTENDIBLETYPE_ATTR_URI);
		name = typeConfig.getAttribute(MMTFConstants.EXTENDIBLETYPE_ATTR_NAME);
		IConfigurationElement[] supertypeConfigs = typeConfig.getChildren(MMTFConstants.EXTENDIBLETYPE_CHILD_SUPERTYPE);
		supertypeUri = (supertypeConfigs.length == 0) ?
			null :
			supertypeConfigs[0].getAttribute(MMTFConstants.EXTENDIBLETYPE_SUPERTYPE_ATTR_URI);
	}

	/**
	 * Constructor: reads the extension and gets the info for the extendible
	 * type, allowing for multiple inheritance.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @param multipleInheritanceTable
	 *            The table for multiple inheritance support.
	 */
	public ExtensionType(IConfigurationElement extensionConfig, Map<String, Set<String>> multipleInheritanceTable) {

		this(extensionConfig);
		IConfigurationElement[] supertypeConfigs = extensionConfig.getChildren(MMTFConstants.CHILD_EXTENDIBLETYPE)[0].getChildren(MMTFConstants.EXTENDIBLETYPE_CHILD_SUPERTYPE);
		if (supertypeConfigs.length > 1) {
			for (int i = 1; i < supertypeConfigs.length; i++) {
				String multipleSupertypeUri = supertypeConfigs[i].getAttribute(MMTFConstants.EXTENDIBLETYPE_SUPERTYPE_ATTR_URI);
				Set<String> supertypes = multipleInheritanceTable.get(multipleSupertypeUri);
				if (supertypes == null) {
					supertypes = new HashSet<String>();
					multipleInheritanceTable.put(multipleSupertypeUri, supertypes);
				}
				supertypes.add(uri);
			}
		}
	}

	/**
	 * Gets the uri of the extendible type.
	 * 
	 * @return The uri of the extendible type.
	 */
	public String getUri() {

		return uri;
	}

	/**
	 * Gets the name of the extendible type.
	 * 
	 * @return The name of the extendible type.
	 */
	public String getName() {

		return name;
	}

	/**
	 * Gets the uri of the supertype of the extendible type.
	 * 
	 * @return The uri of the supertype of the extendible type.
	 */
	public String getSupertypeUri() {

		return supertypeUri;
	}

}