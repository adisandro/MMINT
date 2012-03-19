package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import edu.toronto.cs.se.mmtf.repository.Metamodel;

public class RepositoryDialogSelectionValidator implements ISelectionStatusValidator {

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
