/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;

public class ExtensionType implements MMTFConstants {

	private String uri;
	private String name;
	private String supertypeUri;

	public ExtensionType(IConfigurationElement extensionConfig) {

		IConfigurationElement typeConfig = extensionConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
		uri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
		name = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
		IConfigurationElement[] supertypeConfigs = typeConfig.getChildren(EXTENDIBLETYPE_CHILD_SUPERTYPE);
		supertypeUri = (supertypeConfigs.length == 0) ?
			null :
			supertypeConfigs[0].getAttribute(EXTENDIBLETYPE_SUPERTYPE_ATTR_URI);
	}

	public ExtensionType(IConfigurationElement extensionConfig, Map<String, Set<String>> multipleInheritanceTable) {

		this(extensionConfig);
		IConfigurationElement[] supertypeConfigs = extensionConfig.getChildren(CHILD_EXTENDIBLETYPE)[0].getChildren(EXTENDIBLETYPE_CHILD_SUPERTYPE);
		if (supertypeConfigs.length > 1) {
			for (int i = 1; i < supertypeConfigs.length; i++) {
				String multipleSupertypeUri = supertypeConfigs[i].getAttribute(EXTENDIBLETYPE_SUPERTYPE_ATTR_URI);
				Set<String> supertypes = multipleInheritanceTable.get(multipleSupertypeUri);
				if (supertypes == null) {
					supertypes = new HashSet<String>();
					multipleInheritanceTable.put(multipleSupertypeUri, supertypes);
				}
				supertypes.add(uri);
			}
		}
	}

	public String getUri() {

		return uri;
	}

	public String getName() {

		return name;
	}

	public String getSupertypeUri() {

		return supertypeUri;
	}

}