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

public class ExperimentSamples {

	/** Distribution types. */
	public enum DistributionType {T_STUDENT_95, T_STUDENT_99};

	// index = degrees of freedom -1 (remember that array index starts from 0 though), 95% confidence
	private static final double[] T_STUDENT_95 = {
		12.71,
		4.303,
		3.182,
		2.776,
		2.571,
		2.447,
		2.365,
		2.306,
		2.262,
		2.228,
		2.201,
		2.179,
		2.160,
		2.145,
		2.131,
		2.120,
		2.110,
		2.101,
		2.093,
		2.086
	};

	// index = degrees of freedom -1 (remember that array index starts from 0 though), 99% confidence
	private static final double[] T_STUDENT_99 = {
		63.66,
		9.925,
		5.841,
		4.604,
		4.032,
		3.707,
		3.499,
		3.355,
		3.250,
		3.169,
		3.106,
		3.055,
		3.012,
		2.977,
		2.947,
		2.921,
		2.898,
		2.878,
		2.861,
		2.845
	};

	private final double[] DISTRIBUTION;
	private double[] samples;
	private int numSamples;
	private double sum;
	private double inf;
	private double min;
	private double sup;
	private double max;
	private double requestedConfidence;

	public ExperimentSamples(int maxSamples, DistributionType distribution, double min, double max, double requestedConfidence) {

		samples = new double[maxSamples];
		numSamples = 0;
		this.min = min;
		this.max = max;
		this.requestedConfidence = requestedConfidence;
		switch (distribution) {
			case T_STUDENT_99:
				DISTRIBUTION = T_STUDENT_99;
				break;
			case T_STUDENT_95:
			default:
				DISTRIBUTION = T_STUDENT_95;
				break;
		}
	}

	public boolean addSample(double sample) {

		samples[numSamples] = sample;
		numSamples++;
		sum += sample;

		double avg = sum / numSamples;
		double diff = 0;
		for (int i = 0; i < numSamples; i++) {
			diff += Math.pow(samples[i]-avg, 2);
		}

		if (numSamples > 1) {
			inf = avg - DISTRIBUTION[numSamples-2] * Math.sqrt(diff / (numSamples*(numSamples-1)));
			sup = avg + DISTRIBUTION[numSamples-2] * Math.sqrt(diff / (numSamples*(numSamples-1)));
			inf = ((inf < min) ? min : ((inf > max) ? max : inf));
			sup = ((sup < min) ? min : ((sup > max) ? max : sup));
			if((sup - inf) <= (avg * requestedConfidence)) {
				return true;
			}
		}
		else {
			inf = min;
			sup= max;
		}

		return false;
	}

	public double getLowerConfidence() {

		return inf;
	}

	public double getAverage() {

		return sum / numSamples;
	}

	public double getUpperConfidence() {

		return sup;
	}

}
