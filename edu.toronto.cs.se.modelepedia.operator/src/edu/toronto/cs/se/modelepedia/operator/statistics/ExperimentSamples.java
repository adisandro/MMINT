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

	private static final int CRITICAL_INDEX = 30;
	private static final int CRITICAL_STEP = 10;
	private static final int INFINITE_INDEX = 120;
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
		2.086,
		2.080,
		2.074,
		2.069,
		2.064,
		2.060,
		2.056,
		2.052,
		2.048,
		2.045,
		2.042
	};
	private static final double[] T_STUDENT_95_CRITICAL = {
		2.021,
		2.009,
		2.000,
		1.990,
		1.990,
		1.984,
		1.984,
		1.980,
		1.980
	};
	private static final double T_STUDENT_95_INFINITE = 1.960;

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
		2.845,
		2.831,
		2.819,
		2.807,
		2.797,
		2.787,
		2.779,
		2.771,
		2.763,
		2.756,
		2.750
	};
	private static final double[] T_STUDENT_99_CRITICAL = {
		2.704,
		2.678,
		2.660,
		2.639,
		2.639,
		2.626,
		2.626,
		2.617,
		2.617
	};
	private static final double T_STUDENT_99_INFINITE = 2.576;

	private DistributionType distribution;
	private double[] samples;
	private int numSamples;
	private double sum;
	private double inf;
	private double min;
	private double sup;
	private double max;
	private double requestedConfidence;

	private double getDistributionValue(int index) {

		double value = Double.MAX_VALUE;
		if (index < CRITICAL_INDEX) {
			switch (distribution) {
				case T_STUDENT_95:
					value = T_STUDENT_95[index];
					break;
				case T_STUDENT_99:
					value = T_STUDENT_99[index];
					break;
			}
		}
		else if (index < INFINITE_INDEX) {
			switch (distribution) {
				case T_STUDENT_95:
					value = T_STUDENT_95_CRITICAL[(index-CRITICAL_INDEX) / CRITICAL_STEP];
					break;
				case T_STUDENT_99:
					value = T_STUDENT_99_CRITICAL[(index-CRITICAL_INDEX) / CRITICAL_STEP];
					break;
			}
		}
		else {
			switch (distribution) {
				case T_STUDENT_95:
					value = T_STUDENT_95_INFINITE;
					break;
				case T_STUDENT_99:
					value = T_STUDENT_99_INFINITE;
					break;
			}
		}

		return value;
	}

	public ExperimentSamples(int maxSamples, DistributionType distribution, double min, double max, double requestedConfidence) {

		samples = new double[maxSamples];
		numSamples = 0;
		sum = 0;
		inf = 0;
		sup = 0;
		this.min = min;
		this.max = max;
		this.requestedConfidence = requestedConfidence;
		this.distribution = distribution;
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
			inf = avg - getDistributionValue(numSamples-2) * Math.sqrt(diff / (numSamples*(numSamples-1)));
			sup = avg + getDistributionValue(numSamples-2) * Math.sqrt(diff / (numSamples*(numSamples-1)));
			inf = ((inf < min) ? min : ((inf > max) ? max : inf));
			sup = ((sup < min) ? min : ((sup > max) ? max : sup));
			if((sup - inf) <= (avg * requestedConfidence)) {
				return true;
			}
		}
		else {
			inf = min;
			sup = max;
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
