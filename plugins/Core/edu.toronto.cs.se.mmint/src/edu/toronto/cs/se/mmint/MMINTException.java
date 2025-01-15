/*******************************************************************************
 * Copyright (c) 2012, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
	public static void print(int severity, @NonNull String message, @Nullable Throwable e) {
		var status = (e == null) ?
			new Status(severity, MMINTActivator.PLUGIN_ID, message) :
			new Status(severity, MMINTActivator.PLUGIN_ID, message, e);
		var style = switch (severity) {
		  case IStatus.INFO -> StatusManager.LOG;
      case IStatus.WARNING -> StatusManager.SHOW | StatusManager.LOG;
      case IStatus.ERROR -> StatusManager.BLOCK | StatusManager.LOG;
      default -> StatusManager.LOG;
    };
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

	public static void mustNotBeLevel(ExtendibleElement elem, MIDLevel midLevel) throws MMINTException {
		if (elem.isLevel(midLevel)) {
			throw new MMINTException("Can't execute operation forbidden at the " + midLevel + " level");
		}
	}

	public static void mustNotBeLevel(ExtendibleElementReference elemRef, MIDLevel midLevel) throws MMINTException {
		MMINTException.mustNotBeLevel(elemRef.getObject(), midLevel);
	}
}
