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
import edu.toronto.cs.se.mmint.mid.MIDLevel;
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

		if (!type.isTypesLevel()) {
			throw new MMINTException("Can't execute operation at the TYPES level on element at the " + type.getLevel() + " level");
		}
	}

	public static void mustBeType(ExtendibleElementReference typeRef) throws MMINTException {

		MMINTException.mustBeType(typeRef.getObject());
	}

	public static void mustBeInstance(ExtendibleElement instance) throws MMINTException {

		if (!instance.isInstancesLevel()) {
			throw new MMINTException("Can't execute operation at the INSTANCES level on element at the " + instance.getLevel() + " level");
		}
	}

	public static void mustBeInstance(ExtendibleElementReference instanceRef) throws MMINTException {

		MMINTException.mustBeInstance(instanceRef.getObject());
	}

	public static void mustBeWorkflow(ExtendibleElement workflowElem) throws MMINTException {

		if (!workflowElem.isWorkflowsLevel()) {
			throw new MMINTException("Can't execute operation at the WORKFLOWS level on element at the " + workflowElem.getLevel() + " level");
		}
	}

	public static void mustBeWorkflow(ExtendibleElementReference workflowElemRef) throws MMINTException {

		MMINTException.mustBeWorkflow(workflowElemRef.getObject());
	}

	public static void mustBeLevel(ExtendibleElement elem, MIDLevel midLevel) throws MMINTException {

		if (!elem.isLevel(midLevel)) {
			throw new MMINTException("Can't execute operation at the " + midLevel + " level on element at the " + elem.getLevel() + " level");
		}
	}

	public static void mustBeLevel(ExtendibleElementReference elemRef, MIDLevel midLevel) throws MMINTException {

		MMINTException.mustBeLevel(elemRef.getObject(), midLevel);
	}

}
