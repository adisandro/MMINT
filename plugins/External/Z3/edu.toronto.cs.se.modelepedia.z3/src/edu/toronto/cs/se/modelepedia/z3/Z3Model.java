/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.z3;

import com.microsoft.z3.Model;
import com.microsoft.z3.Status;

public class Z3Model {

	public enum Z3Result {

		SAT, UNSAT, UNKNOWN;

		public static Z3Result toZ3Result(Status z3Status) {

			switch (z3Status) {
				case UNSATISFIABLE:
					return UNSAT;
				case SATISFIABLE:
					return SAT;
				default:
					return UNKNOWN;
			}
		}

		public boolean isSAT() {

			switch(this) {
				case SAT:
					return true;
				case UNSAT:
				case UNKNOWN:
				default:
					return false;
			}
		}

	}

	private Z3Result z3Result;
	private Model z3InternalModel;

	public Z3Model(Z3Result z3Bool, Model z3InternalModel) {

		this.z3Result = z3Bool;
		this.z3InternalModel = z3InternalModel;
	}

	public Z3Model(Status z3Status, Model z3InternalModel) {

		this.z3Result = Z3Result.toZ3Result(z3Status);
		this.z3InternalModel = z3InternalModel;
	}

	public Z3Result getZ3Result() {

		return z3Result;
	}

	public Model getZ3InternalModel() {

		return z3InternalModel;
	}

}
