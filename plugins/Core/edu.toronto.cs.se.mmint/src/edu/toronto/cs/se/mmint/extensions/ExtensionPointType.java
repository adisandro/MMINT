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
package edu.toronto.cs.se.mmint.extensions;

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

		var typeConfig = extensionConfig.getChildren(MMINTConstants.CHILD_TYPE)[0];
		this.uri = typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_URI);
		this.name = typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_NAME);
		this.isAbstract = Boolean.parseBoolean(typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_ISABSTRACT));
		var supertypeConfigs = typeConfig.getChildren(MMINTConstants.TYPE_CHILD_SUPERTYPE);
		this.supertypeUri = (supertypeConfigs.length == 0) ?
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
		var typeConfig = extensionConfig.getChildren(MMINTConstants.CHILD_TYPE)[0];
		if (typeConfig.getAttribute(MMINTConstants.TYPE_ATTR_CLASS) == null) {
			this.factory = defaultFactory;
			this.newType = null;
		}
		else {
			try {
				var object = typeConfig.createExecutableExtension(MMINTConstants.TYPE_ATTR_CLASS);
				if (object instanceof MIDHeavyTypeFactory) {
					this.factory = (MIDHeavyTypeFactory) object;
					this.newType = null;
				}
				else {
					this.factory = defaultFactory;
					this.newType = (ExtendibleElement) object;
				}
			}
			catch (Exception e) {
				this.factory = defaultFactory;
				this.newType = null;
			}
		}
	}

	/**
	 * Gets the uri of the extension type.
	 *
	 * @return The uri of the extension type.
	 */
	public @Nullable String getUri() {

		return this.uri;
	}

	/**
	 * Gets the name of the extension type.
	 *
	 * @return The name of the extension type.
	 */
	public @NonNull String getName() {

		return this.name;
	}

	/**
	 * Checks if the extension type is abstract.
	 *
	 * @return True if the extension type is abstract, false otherwise.
	 */
	public boolean isAbstract() {

		return this.isAbstract;
	}

	/**
	 * Gets the uri of the supertype of the extension type.
	 *
	 * @return The uri of the supertype of the extension type.
	 */
	public @Nullable String getSupertypeUri() {

		return this.supertypeUri;
	}

	/**
	 * Gets the factory of the extension type.
	 *
	 * @return The factory of the extension type.
	 */
	public @Nullable MIDHeavyTypeFactory getFactory() {

		return this.factory;
	}

	/**
	 * Gets the custom type for the extension type.
	 *
	 * @return The custom type for the extension type, null if the standard type
	 *         will be created by the factory.
	 */
	public @Nullable ExtendibleElement getNewType() {

		return this.newType;
	}

}