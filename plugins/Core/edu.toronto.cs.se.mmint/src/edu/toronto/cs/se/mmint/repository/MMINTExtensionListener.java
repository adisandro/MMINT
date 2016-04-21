/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;

/**
 * A generic listener for dynamic installation/unistallation of MMINT extensions.
 * 
 * @author Alessio Di Sandro
 * 
 */
public abstract class MMINTExtensionListener implements IRegistryEventListener {

	@Override
	public abstract void added(IExtension[] extensions);

	@Override
	public abstract void removed(IExtension[] extensions);

	/**
	 * {@inheritDoc}
	 * This implementation does nothing and MMINT listeners do not need to
	 * override this.
	 */
	@Override
	public void added(IExtensionPoint[] extensionPoints) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * This implementation does nothing and MMINT listeners do not need to
	 * override this.
	 */
	@Override
	public void removed(IExtensionPoint[] extensionPoints) {
		// do nothing
	}

}
