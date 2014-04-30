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
package edu.toronto.cs.se.mmint.z3;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import com.microsoft.z3.Z3Exception;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.z3.Z3SMTUtils.Z3BoolResult;
import edu.toronto.cs.se.mmint.z3.Z3SMTUtils.Z3ModelResult;

public class Z3SMTSolver {

	private Solver loadSMTEncoding(Map<String, String> config, String smtEncoding) throws Z3Exception {

		Context context = new Context(config);
		Solver solver = context.mkSolver();
		BoolExpr expr = context.parseSMTLIB2String(smtEncoding, null, null, null, null);
		solver.add(expr);

		return solver;
	}

	// check sat, no incremental
	public Z3BoolResult checkSat(String smtEncoding) {

		Map<String, String> config = new HashMap<String, String>();
		try {
			Solver solver = loadSMTEncoding(config, smtEncoding);
			Status status = solver.check();

			return Z3BoolResult.toZ3BoolResult(status);
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Z3 problem, returning unknown result", e);
			return Z3BoolResult.UNKNOWN;
		}
	}

	// check sat and get model, no incremental
	public Z3ModelResult checkSatAndGetModel(String smtEncoding) {

		Map<String, String> config = new HashMap<String, String>();
		config.put("model", "true");
		try {
			Solver solver = loadSMTEncoding(config, smtEncoding);
			Status status = solver.check();
			Model model = null;
			if (status == Status.SATISFIABLE) {
				model = solver.getModel();
			}

			return new Z3ModelResult(status, model);
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Z3 problem, returning unknown result", e);
			return new Z3ModelResult(Status.UNKNOWN, null);
		}
	}

}
