/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

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

public class Z3IncrementalSolver {
	public enum Z3IncrementalBehavior {NORMAL, PUSH, POP, POP_IF_UNSAT};
	private Context context;
	private Solver solver;
	private Deque<Set<Sort>> sorts;
	private Deque<Set<FuncDecl>> decls;

	private void reset() {
	  this.context.close();
		this.context = null;
		this.solver = null;
		this.sorts.clear();
		this.decls.clear();
	}

	private boolean isValidSymbol(String smtSymbol) {
		if (smtSymbol.contains(Z3Utils.Z3_MODEL_SEPARATOR)) {
			return false;
		}
		try {
			Integer.parseInt(smtSymbol);
			return false;
		}
		catch (NumberFormatException e) {
			return true;
		}
	}

	private Z3Model runCheckSatAndGetModel(String smtEncoding) throws Z3Exception {
		BoolExpr[] expr;
		if (this.sorts.isEmpty() || this.decls.isEmpty()) {
			// parse baseline encoding
			expr = this.context.parseSMTLIB2String(smtEncoding, null, null, null, null);
		}
		else {
			// parse incremental encoding
			var lastSorts = this.sorts.getLast();
			var lastDecls = this.decls.getLast();
			expr = this.context.parseSMTLIB2String(
				smtEncoding,
				lastSorts.stream().map(Sort::getName).toArray(size -> new Symbol[size]),
				lastSorts.toArray(new Sort[0]),
				lastDecls.stream().map(FuncDecl::getName).toArray(size -> new Symbol[size]),
				lastDecls.toArray(new FuncDecl[0]));
		}

		// check sat and get model
		this.solver.add(expr);
		var status = this.solver.check();
		Model returnModel = null;
		if (status == Status.SATISFIABLE) {
			returnModel = this.solver.getModel();
			var returnSorts = (this.sorts.isEmpty()) ? new HashSet<Sort>() : new HashSet<>(this.sorts.getLast());
			var returnDecls = (this.decls.isEmpty()) ? new HashSet<FuncDecl>() : new HashSet<>(this.decls.getLast());
			for (var returnSort : returnModel.getSorts()) {
				if (!isValidSymbol(returnSort.getName().toString()) || returnSorts.contains(returnSort)) {
					continue;
				}
				returnSorts.add(returnSort);
			}
			for (var returnDecl : returnModel.getDecls()) {
				if (!isValidSymbol(returnDecl.getName().toString()) || returnDecls.contains(returnDecl)) {
					continue;
				}
				returnDecls.add(returnDecl);
			}
			this.sorts.add(returnSorts);
			this.decls.add(returnDecls);
		}

		return new Z3Model(status, returnModel);
	}

	// first check sat and get model as baseline
	public Z3Model firstCheckSatAndGetModel(String smtEncoding) {
		var config = new HashMap<String, String>();
		config.put("model", "true");
		try {
			this.context = new Context(config);
			this.solver = this.context.mkSolver();
			this.sorts = new ArrayDeque<>();
			this.decls = new ArrayDeque<>();

			return runCheckSatAndGetModel(smtEncoding);
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.INFO, "Z3 problem, returning unknown result and resetting the solver", e);
			reset();
			return new Z3Model(Status.UNKNOWN, null);
		}
	}

	// incremental check sat and get model
	public Z3Model checkSatAndGetModel(String smtEncoding, Z3IncrementalBehavior incBehavior) {

		if (this.sorts.isEmpty() || this.decls.isEmpty()) {
			MMINTException.print(IStatus.INFO, "No incremental model found, invoking firstCheckSatAndGetModel() instead", null);
			return firstCheckSatAndGetModel(smtEncoding);
		}

		try {
			// push
			if (incBehavior != Z3IncrementalBehavior.NORMAL) {
				this.solver.push();
			}
			// run
			var z3Model = runCheckSatAndGetModel(smtEncoding);
			if (z3Model.getZ3Result().isSAT()) {
				switch (incBehavior) {
					case NORMAL:
					case POP_IF_UNSAT:
						// keep current model
						this.sorts.removeFirst();
						this.decls.removeFirst();
						break;
					case POP:
						// keep previous model
						this.sorts.removeLast();
						this.decls.removeLast();
						break;
					case PUSH:
						// do nothing: keep previous and current models
				}
			}
			// pop
			if (
				incBehavior == Z3IncrementalBehavior.POP ||
				(incBehavior == Z3IncrementalBehavior.POP_IF_UNSAT && !z3Model.getZ3Result().isSAT())
			) {
				this.solver.pop();
			}

			return z3Model;
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.INFO, "Z3 problem, returning unknown result and resetting the solver", e);
			reset();
			return new Z3Model(Status.UNKNOWN, null);
		}
	}

	// manual pop
	public void finalizePreviousPush() {

		//TODO MMINT[Z3] Will break if there is a POP_IF_UNSAT with SAT result between the PUSH and this
		this.sorts.removeFirst();
		this.decls.removeFirst();
	}

	// manual pop
	public void revertToPreviousPush() {

		//TODO MMINT[Z3] Will break if there is a POP_IF_UNSAT with SAT result between the PUSH and this
		try {
			this.sorts.removeLast();
			this.decls.removeLast();
			this.solver.pop();
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.INFO, "Z3 problem, resetting the solver", e);
			reset();
		}
	}

}
