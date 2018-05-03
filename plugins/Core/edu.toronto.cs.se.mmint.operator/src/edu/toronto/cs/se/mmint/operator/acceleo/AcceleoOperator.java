/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.acceleo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public abstract class AcceleoOperator extends OperatorImpl {

    protected List<Object> acceleoArgs;
    protected File folder;
    protected AbstractAcceleoGenerator acceleoGen;

    protected void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) throws Exception {

        AcceleoPreferences.switchForceDeactivationNotifications(true);
        AcceleoPreferences.switchNotifications(false);
        this.acceleoArgs = new ArrayList<>();
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        init(inputsByName, outputMIDsByName);
        this.acceleoGen.doGenerate(new BasicMonitor());

        return null;
    }

}
