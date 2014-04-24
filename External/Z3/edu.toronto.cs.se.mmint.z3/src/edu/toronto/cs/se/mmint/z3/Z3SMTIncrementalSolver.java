package edu.toronto.cs.se.mmint.z3;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.z3.Context;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Z3Exception;

public class Z3SMTIncrementalSolver {

	private Context context;
	private Solver solver;
	private Model model;

	private void runCheckSatAndGetModel(String smtEncoding, boolean isTempAssertion) {

		try {
			if (false) {
				context.parseSMTLIB2String(smtEncoding, null, null, null, null);
			}
			else {
				context.parseSMTLIB2String(smtEncoding, null, null, null, null);
			}
		}
		catch (Z3Exception e) {
		}
	}

	// first check sat and get model as baseline
	public void firstCheckSatAndGetModel(String smtEncoding) {

		Map<String, String> config = new HashMap<String, String>();
		config.put("model", "true");
		config.put("model-completion", "true");
		try {
			context = new Context(config);
			solver = context.mkSolver();
			// first run is always piling up the initial assertion
			runCheckSatAndGetModel(smtEncoding, false);
		}
		catch (Z3Exception e) {
		}
	}

	// incremental check sat and get model
	public void checkSatAndGetModel(Context context, String smtEncoding, boolean isTempAssertion, boolean isTempIfUnsatAssertion) {

		
	}

}
