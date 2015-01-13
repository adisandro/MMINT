/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

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
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Bool;

public class Z3IncrementalSolver {

	public enum Z3IncrementalBehavior {NORMAL, PUSH, POP, POP_IF_UNSAT};

	private Context context;
	private Solver solver;
	private List<Model> models;

	private void reset() {

		context = null;
		solver = null;
		models.clear();
	}

	private @NonNull Z3Model runCheckSatAndGetModel(@NonNull String smtEncoding) throws Z3Exception {

		BoolExpr expr;
		if (!models.isEmpty()) {
			// parse incremental encoding
			Model model = models.get(models.size()-1);
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
			models.add(returnModel);
		}

		return new Z3Model(status, returnModel);
	}

	// first check sat and get model as baseline
	public @NonNull Z3Model firstCheckSatAndGetModel(@NonNull String smtEncoding) {

		Map<String, String> config = new HashMap<String, String>();
		config.put("model", "true");
		try {
			context = new Context(config);
			solver = context.mkSolver();
			models = new ArrayList<Model>();

			return runCheckSatAndGetModel(smtEncoding);
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Z3 problem, returning unknown result and resetting the solver", e);
			reset();
			return new Z3Model(Status.UNKNOWN, null);
		}
	}

	// incremental check sat and get model
	public @NonNull Z3Model checkSatAndGetModel(@NonNull String smtEncoding, @NonNull Z3IncrementalBehavior incBehavior) {

		if (models.isEmpty()) {
			MMINTException.print(Type.WARNING, "No incremental model found, invoking firstCheckSatAndGetModel() instead", null);
			return firstCheckSatAndGetModel(smtEncoding);
		}

		try {
			// push
			if (incBehavior != Z3IncrementalBehavior.NORMAL) {
				solver.push();
			}
			// run
			Z3Model z3ModelResult = runCheckSatAndGetModel(smtEncoding);
			if (z3ModelResult.getZ3Bool() == Z3Bool.SAT) {
				switch (incBehavior) {
				case NORMAL:
				case POP_IF_UNSAT:
					models.remove(0); // keep current model
					break;
				case POP:
					models.remove(models.size()-1); // keep previous model
					break;
				case PUSH:
					// do nothing: keep previous and current models
				}
			}
			// pop
			if (
				incBehavior == Z3IncrementalBehavior.POP ||
				(incBehavior == Z3IncrementalBehavior.POP_IF_UNSAT && z3ModelResult.getZ3Bool() != Z3Bool.SAT)
			) {
				solver.pop();
			}

			return z3ModelResult;
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Z3 problem, returning unknown result and resetting the solver", e);
			reset();
			return new Z3Model(Status.UNKNOWN, null);
		}
	}

	// manual pop
	public void finalizePreviousPush() {

		//TODO MMINT[Z3] Will break if there is a POP_IF_UNSAT with SAT result between the PUSH and this
		models.remove(0);
	}

	// manual pop
	public void revertToPreviousPush() {

		//TODO MMINT[Z3] Will break if there is a POP_IF_UNSAT with SAT result between the PUSH and this
		try {
			solver.pop();
			models.remove(models.size()-1);
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Z3 problem, resetting the solver", e);
			reset();
		}
	}

}
