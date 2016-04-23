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
package edu.toronto.cs.se.mmint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;

/**
 * Custom exception for MMINT.
 *
 * @author Alessio Di Sandro
 * 
 */
public class MMINTException extends Exception {

	/** Default serial version. */
	private static final long serialVersionUID = 1L;

	/**
	 * Prints an exception.
	 * 
	 * @param message
	 *            The exception message.
	 * @param e
	 *            The exception or error.
	 */
	public static void print(int severity, String message, Throwable e) {

		IStatus status = (e == null) ?
			new Status(severity, MMINTActivator.PLUGIN_ID, message) :
			new Status(severity, MMINTActivator.PLUGIN_ID, message, e);
		int style;
		switch (severity) {
			case IStatus.WARNING:
				style = StatusManager.LOG;
				break;
			case IStatus.ERROR:
				style = StatusManager.BLOCK | StatusManager.LOG;
				break;
			default:
				style = StatusManager.LOG;
		}
		StatusManager.getManager().handle(status, style);
	}

	/**
	 * Constructor: initializes superclass.
	 * 
	 * @param message
	 *            The message that explains the exception.
	 */
	public MMINTException(String message) {

		super(message);
	}

	/**
	 * Constructor: initializes superclass with a chained
	 * exception.
	 * 
	 * @param message
	 *            The message that explains the exception.
	 * @param cause
	 *            The exception that caused this exception.
	 */
	public MMINTException(String message, Throwable cause) {

		super(message, cause);
	}

	public static void mustBeType(ExtendibleElement type) throws MMINTException {

		if (MIDConstraintChecker.isInstancesLevel(type)) {
			throw new MMINTException("Can't execute operation at the TYPES level on element at the INSTANCES level");
		}
	}

	public static void mustBeType(ExtendibleElementReference typeRef) throws MMINTException {

		mustBeType(typeRef.getObject());
	}

	public static void mustBeInstance(ExtendibleElement instance) throws MMINTException {

		if (!MIDConstraintChecker.isInstancesLevel(instance)) {
			throw new MMINTException("Can't execute operation at the INSTANCES level on element at the TYPES level");
		}
	}

	public static void mustBeInstance(ExtendibleElementReference instanceRef) throws MMINTException {

		mustBeInstance(instanceRef.getObject());
	}

}
