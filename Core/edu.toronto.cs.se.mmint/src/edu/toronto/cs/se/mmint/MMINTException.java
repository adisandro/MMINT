/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PlatformUI;

/**
 * Custom exception for MMINT.
 *
 * @author Alessio Di Sandro
 * 
 */
public class MMINTException extends Exception {

	/** Exception types. */
	public enum Type {WARNING, ERROR}

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
	public static void print(Type type, String message, Throwable e) {

		switch (type) {
			case WARNING:
				message = "WARNING: " + message;
				break;
			case ERROR:
				message = "ERROR: " + message;
				break;
			default:
				message = "UNKNOWN PROBLEM: " + message;
		}
		System.err.println(message);
		if (e != null) {
			System.err.println(" -> " + e.toString());
		}
		if (type == Type.ERROR) {
			IStatus status = (e == null) ?
				new Status(IStatus.ERROR, MMINTActivator.PLUGIN_ID, "") :
				new Status(IStatus.ERROR, MMINTActivator.PLUGIN_ID, e.toString());
			ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "MMINT Error", message, status);
		}
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

}
