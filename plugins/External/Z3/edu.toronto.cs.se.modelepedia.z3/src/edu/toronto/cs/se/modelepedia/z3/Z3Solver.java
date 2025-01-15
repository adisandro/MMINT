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

import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import com.microsoft.z3.Context;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import com.microsoft.z3.Z3Exception;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Result;

public class Z3Solver {
  private Context context;
  private Solver solver;

	private void loadSMTLIBEncoding(Map<String, String> config, String smtEncoding) throws Z3Exception {
		this.context = new Context(config);
		this.solver = this.context.mkSolver();
		var expr = this.context.parseSMTLIB2String(smtEncoding, null, null, null, null);
		this.solver.add(expr);
	}

	// check sat, no incremental
	public Z3Result checkSat(String smtEncoding) {
		try {
			loadSMTLIBEncoding(Map.<String, String>of(), smtEncoding);
			var status = this.solver.check();

			return Z3Result.toZ3Result(status);
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.INFO, "Z3 problem, returning unknown result", e);
			return Z3Result.UNKNOWN;
		}
		finally {
		  this.context.close();
		}
	}

	// check sat and get model, no incremental
	public Z3Model checkSatAndGetModel(String smtEncoding) {
		try {
			loadSMTLIBEncoding(Map.<String, String>of("model", "true"), smtEncoding);
			var status = this.solver.check();
			Model model = null;
			if (status == Status.SATISFIABLE) {
				model = this.solver.getModel();
			}

			return new Z3Model(status, model);
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.INFO, "Z3 problem, returning unknown result", e);
			return new Z3Model(Status.UNKNOWN, null);
		}
		finally {
		  this.context.close();
		}
	}

}
