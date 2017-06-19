/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.match;


import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.Model;

public class Match extends UntypedMatch {

	public static class Constraint extends UntypedMatch.Constraint {

		@Override
		public boolean isAllowedInput(@NonNull Map<String, Model> inputsByName) {

		    boolean isAllowed = super.isAllowedInput(inputsByName);
		    if (!isAllowed) {
		        return false;
		    }
		    UntypedMatch.Input input = new UntypedMatch.Input(inputsByName);
			if (!input.model1.getMetatypeUri().equals(input.model2.getMetatypeUri())) {
			    //TODO MMINT[MATCH] Use instanceOf when it's optimized (automatic caching of runtime types)
			    return false;
			}

			return true;
		}
	}

}
