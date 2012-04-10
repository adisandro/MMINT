/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;

import edu.toronto.cs.se.mmtf.MMTF;

/**
 * A generic listener for dynamic installation/unistallation of MMTF extensions.
 * 
 * @author Alessio Di Sandro
 * 
 */
public abstract class MMTFExtensionListener implements IRegistryEventListener {

	/** The MMTF instance. */
	protected MMTF mmtf;

	/**
	 * Constructor: initializes the MMTF instance.
	 * 
	 * @param mmtf
	 *            The MMTF instance.
	 */
	public MMTFExtensionListener(MMTF mmtf) {

		this.mmtf = mmtf;
	}

	@Override
	public abstract void added(IExtension[] extensions);

	@Override
	public abstract void removed(IExtension[] extensions);

	/**
	 * {@inheritDoc}
	 * This implementation does nothing and MMTF listeners do not need to
	 * override this.
	 */
	@Override
	public void added(IExtensionPoint[] extensionPoints) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * This implementation does nothing and MMTF listeners do not need to
	 * override this.
	 */
	@Override
	public void removed(IExtensionPoint[] extensionPoints) {
		// do nothing
	}

}
