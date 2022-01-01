/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.extensions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDHeavyTypeFactory;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;

/**
 * An edu.toronto.cs.se.mmint.types extension containing a "heavy" type.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ExtensionPointType {

	/** The uri of the extension type. */
	private String uri;
	/** The name of the extension type. */
	private String name;
	/** True if the extension type is abstract, false otherwise. */
	private boolean isAbstract;
	/** The uri of the supertype of the extension type. */
	private String supertypeUri;
	/** The factory of the extension type. */
	private MIDHeavyTypeFactory factory;
	/** The custom type for the extension type. */
	private ExtendibleElement newType;

	/**
	 * Constructor: reads the extension and gets the info for the extension
	 * type.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 */
	public ExtensionPointType(@NonNull IConfigurationElement extensionConfig) {

		IConfigurationElement typeConfig = extensionConfig.getChildren(MMINTConstants.CHILD_TYPE)[0];
		uri = typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_URI);
		name = typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_NAME);
		isAbstract = Boolean.parseBoolean(typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_ISABSTRACT));
		IConfigurationElement[] supertypeConfigs = typeConfig.getChildren(MMINTConstants.TYPE_CHILD_SUPERTYPE);
		supertypeUri = (supertypeConfigs.length == 0) ?
			null :
			supertypeConfigs[0].getAttribute(MMINTConstants.TYPE_SUPERTYPE_ATTR_URI);
	}

	/**
	 * Constructor: reads the extension and gets the info for the extension
	 * type.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @param defaultFactory
	 *            The default "heavy" type factory.
	 */
	public ExtensionPointType(@NonNull IConfigurationElement extensionConfig, @NonNull MIDHeavyTypeFactory defaultFactory) {

		this(extensionConfig);
		IConfigurationElement typeConfig = extensionConfig.getChildren(MMINTConstants.CHILD_TYPE)[0];
		if (typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_CLASS) == null) {
			factory = defaultFactory;
			newType = null;
		}
		else {
			try {
				Object object = typeConfig.createExecutableExtension(MMINTConstants.TYPE_ATTR_CLASS);
				if (object instanceof MIDHeavyTypeFactory) {
					factory = (MIDHeavyTypeFactory) object;
					newType = null;
				}
				else {
					factory = defaultFactory;
					newType = (ExtendibleElement) object;
				}
			}
			catch (Exception e) {
				factory = defaultFactory;
				newType = null;
			}
		}
	}

	/**
	 * Constructor: reads the extension and gets the info for the extension
	 * type, allowing for multiple inheritance.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @param multipleInheritanceTable
	 *            The table for multiple inheritance support.
	 * @param defaultFactory
	 *            The default "heavy" type factory.
	 */
	public ExtensionPointType(IConfigurationElement extensionConfig, Map<String, Set<String>> multipleInheritanceTable, MIDHeavyTypeFactory defaultFactory) {

		this(extensionConfig, defaultFactory);
		IConfigurationElement[] supertypeConfigs = extensionConfig.getChildren(MMINTConstants.CHILD_TYPE)[0].getChildren(MMINTConstants.TYPE_CHILD_SUPERTYPE);
		if (supertypeConfigs.length > 1) {
			for (int i = 1; i < supertypeConfigs.length; i++) {
				String multipleSupertypeUri = supertypeConfigs[i].getAttribute(MMINTConstants.TYPE_SUPERTYPE_ATTR_URI);
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
	 * Gets the uri of the extension type.
	 * 
	 * @return The uri of the extension type.
	 */
	public @Nullable String getUri() {

		return uri;
	}

	/**
	 * Gets the name of the extension type.
	 * 
	 * @return The name of the extension type.
	 */
	public @NonNull String getName() {

		return name;
	}

	/**
	 * Checks if the extension type is abstract.
	 * 
	 * @return True if the extension type is abstract, false otherwise.
	 */
	public boolean isAbstract() {

		return isAbstract;
	}

	/**
	 * Gets the uri of the supertype of the extension type.
	 * 
	 * @return The uri of the supertype of the extension type.
	 */
	public @Nullable String getSupertypeUri() {

		return supertypeUri;
	}

	/**
	 * Gets the factory of the extension type.
	 * 
	 * @return The factory of the extension type.
	 */
	public @Nullable MIDHeavyTypeFactory getFactory() {

		return factory;
	}

	/**
	 * Gets the custom type for the extension type.
	 * 
	 * @return The custom type for the extension type, null if the standard type
	 *         will be created by the factory.
	 */
	public @Nullable ExtendibleElement getNewType() {

		return newType;
	}

}