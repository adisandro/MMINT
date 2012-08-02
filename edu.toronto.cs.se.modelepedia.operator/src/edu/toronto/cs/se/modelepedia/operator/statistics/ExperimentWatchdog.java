/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.statistics;

public class ExperimentWatchdog extends Thread {

	ExperimentDriver experiment;
	private double maxProcessingTime;
	private long startTime;

	public ExperimentWatchdog(ExperimentDriver experiment, double maxProcessingTime) {

		this.experiment = experiment;
		this.maxProcessingTime = maxProcessingTime;
		startTime = System.nanoTime();
	}

	public void run() {

		while (!this.isInterrupted()) {
			long now = System.nanoTime();
			if (((now - startTime) * 1.0e-9) > maxProcessingTime) {
				//experiment.notify();
				break;
			}
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				break;
			}
		}
	}

}
