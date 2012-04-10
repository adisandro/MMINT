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
package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import edu.toronto.cs.se.mmtf.repository.Metamodel;

/**
 * The selection validator for the repository tree dialog.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RepositoryDialogSelectionValidator implements ISelectionStatusValidator {

	/**
	 * {@inheritDoc}
	 * The selection of a metamodel is not allowed, only its editors.
	 */
	@Override
	public IStatus validate(Object[] selection) {

		for (Object object : selection) {
			if (object instanceof Metamodel) {
				return new Status(IStatus.ERROR, "edu.toronto.cs.se.mmtf", "Please select an editor");
			}
		}

		return new Status(IStatus.OK, "edu.toronto.cs.se.mmtf", "");
	}

}
