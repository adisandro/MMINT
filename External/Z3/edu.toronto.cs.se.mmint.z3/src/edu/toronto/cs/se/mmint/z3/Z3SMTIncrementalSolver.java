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
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.z3.Z3SMTUtils.Z3BoolResult;
import edu.toronto.cs.se.mmint.z3.Z3SMTUtils.Z3ModelResult;

public class Z3SMTIncrementalSolver {

	public enum Z3IncrementalBehavior {NORMAL, POP, POP_IF_UNSAT};

	private Context context;
	private Solver solver;
	private Model model;

	private Z3ModelResult runCheckSatAndGetModel(String smtEncoding, Z3IncrementalBehavior incBehavior) throws Z3Exception {

		BoolExpr expr;
		if (model != null) {
			// parse incremental encoding
			Sort[] sorts = model.getSorts();
			Symbol[] sortSymbols = new Symbol[sorts.length];
			for (int i = 0; i < sorts.length; i++) {
				sortSymbols[i] = sorts[i].getName();
			}
			FuncDecl[] decls = model.getDecls();
			Symbol[] declSymbols = new Symbol[decls.length];
			for (int i = 0; i < decls.length; i++) {
				declSymbols[i] = decls[i].getName();
			}
			expr = context.parseSMTLIB2String(smtEncoding, sortSymbols, sorts, declSymbols, decls);
		}
		else {
			// parse baseline encoding
			expr = context.parseSMTLIB2String(smtEncoding, null, null, null, null);
		}

		// check sat and get model
		solver.add(expr);
		Status status = solver.check();
		Model returnModel = null;
		if (status == Status.SATISFIABLE) {
			returnModel = solver.getModel();
			// store current model if encoding is piling up, or just keep the previous one
			if (incBehavior != Z3IncrementalBehavior.POP) {
				model = returnModel;
			}
		}

		return new Z3ModelResult(status, returnModel);
	}

	// first check sat and get model as baseline
	public Z3ModelResult firstCheckSatAndGetModel(String smtEncoding) {

		Map<String, String> config = new HashMap<String, String>();
		config.put("model", "true");
		try {
			context = new Context(config);
			solver = context.mkSolver();
			model = null;

			return runCheckSatAndGetModel(smtEncoding, Z3IncrementalBehavior.NORMAL);
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Z3 problem, returning unknown result", e);
			reset();
			return new Z3ModelResult(Status.UNKNOWN, null);
		}
	}

	// incremental check sat and get model
	public Z3ModelResult checkSatAndGetModel(String smtEncoding, Z3IncrementalBehavior incBehavior) {

		if (model == null) {
			MMINTException.print(Type.WARNING, "No incremental model found, invoking firstCheckSatAndGetModel() instead", null);
			return firstCheckSatAndGetModel(smtEncoding);
		}

		try {
			if (incBehavior != Z3IncrementalBehavior.NORMAL) {
				solver.push();
			}
			Z3ModelResult z3ModelResult = runCheckSatAndGetModel(smtEncoding, incBehavior);
			if (
				incBehavior == Z3IncrementalBehavior.POP ||
				(incBehavior == Z3IncrementalBehavior.POP_IF_UNSAT && z3ModelResult.getZ3BoolResult() != Z3BoolResult.SAT)
			) {
				solver.pop();
			}

			return z3ModelResult;
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Z3 problem, returning unknown result", e);
			reset();
			return new Z3ModelResult(Status.UNKNOWN, null);
		}
	}

	public void reset() {

		context = null;
		solver = null;
		model = null;
	}

}
