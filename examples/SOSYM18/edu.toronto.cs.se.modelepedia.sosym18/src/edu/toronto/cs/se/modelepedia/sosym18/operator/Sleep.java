/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.sosym18.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class Sleep extends OperatorImpl {

    private final static @NonNull String PROPERTY_IN_MILLISECONDS = "ms";
    private final static @NonNull int PROPERTY_IN_MILLISECONDS_DEFAULT = 0;
    private int ms;

    @Override
    public void readInputProperties(Properties inputProperties) throws MMINTException {

        this.ms = MIDOperatorIOUtils.getOptionalIntProperty(inputProperties, PROPERTY_IN_MILLISECONDS,
                                                            PROPERTY_IN_MILLISECONDS_DEFAULT);
    }

	private void sleep() {

		try {
			Thread.sleep(this.ms);
		}
		catch (InterruptedException e) {
			// continue
		}
	}

	@Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

		sleep();

		return new HashMap<>();
    }

}
