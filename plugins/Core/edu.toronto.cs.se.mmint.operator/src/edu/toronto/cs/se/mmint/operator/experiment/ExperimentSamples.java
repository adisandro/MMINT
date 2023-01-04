/*
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.experiment;

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
  private int minSamples;
  private int numSamples;
  private double sum;
  private double low;
  private double min;
  private double up;
  private double max;
  private double targetConfidence;
  private boolean doConfidence;

  private double getDistributionValue(int index) {
    double value = Double.MAX_VALUE;
    if (index < CRITICAL_INDEX) {
      switch (this.distribution) {
        case T_STUDENT_95:
          value = T_STUDENT_95[index];
          break;
        case T_STUDENT_99:
          value = T_STUDENT_99[index];
          break;
      }
    }
    else if (index < INFINITE_INDEX) {
      switch (this.distribution) {
        case T_STUDENT_95:
          value = T_STUDENT_95_CRITICAL[(index-CRITICAL_INDEX) / CRITICAL_STEP];
          break;
        case T_STUDENT_99:
          value = T_STUDENT_99_CRITICAL[(index-CRITICAL_INDEX) / CRITICAL_STEP];
          break;
      }
    }
    else {
      switch (this.distribution) {
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

  public ExperimentSamples(int minSamples, int maxSamples, DistributionType distribution, double min, double max, double targetConfidence, boolean doConfidence) {
    this.samples = new double[maxSamples];
    this.minSamples = minSamples;
    this.numSamples = 0;
    this.sum = 0;
    this.low = 0;
    this.up = 0;
    this.distribution = distribution;
    this.min = min;
    this.max = max;
    this.targetConfidence = targetConfidence;
    this.doConfidence = doConfidence;
  }

  public void addSample(double sample) {
    this.samples[this.numSamples] = sample;
    this.numSamples++;
    this.sum += sample;
    if (!this.doConfidence) {
      return;
    }

    if (this.numSamples > 1) {
      double avg = getAverage();
      double diff = 0;
      for (int i = 0; i < this.numSamples; i++) {
        diff += Math.pow(this.samples[i]-avg, 2);
      }
      double confidence = getDistributionValue(this.numSamples-2) * Math.sqrt(diff / (this.numSamples*(this.numSamples-1)));
      this.low = avg - confidence;
      this.up = avg + confidence;
      this.low = ((this.low < this.min) ? this.min : ((this.low > this.max) ? this.max : this.low));
      this.up = ((this.up < this.min) ? this.min : ((this.up > this.max) ? this.max : this.up));
    }
    else {
      this.low = this.min;
      this.up = this.max;
    }
  }

  public double getLowerConfidence() {
    return this.low;
  }

  public double getAverage() {
    return this.sum / this.numSamples;
  }

  public double getUpperConfidence() {
    return this.up;
  }

  public int getNumSamples() {
    return this.numSamples;
  }

  public boolean doConfidence() {
    return this.doConfidence;
  }

  public boolean isWithinTargetConfidence() {
    if (!this.doConfidence) {
      return true;
    }
    if (this.numSamples > 1 && this.numSamples >= this.minSamples &&
        (this.up - this.low) <= (getAverage() * this.targetConfidence)) {
      return true;
    }
    return false;
  }

}
