/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.mid.utils;

import java.io.IOException;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.common.util.BasicMonitor;

public class AcceleoUtils {

  public static void runAcceleo(AbstractAcceleoGenerator acceleoGenerator) throws IOException {
    AcceleoPreferences.switchForceDeactivationNotifications(true);
    AcceleoPreferences.switchNotifications(false);
    acceleoGenerator.doGenerate(new BasicMonitor());
  }

}
