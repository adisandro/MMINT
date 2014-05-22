package edu.toronto.cs.se.modelepedia.z3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.FuncInterp;
import com.microsoft.z3.Model;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Status;
import com.microsoft.z3.Z3Exception;
import com.microsoft.z3.FuncInterp.Entry;

public class Z3SMTModel {

	public enum Z3SMTBool {
	
		SAT, UNSAT, UNKNOWN;
	
		public static Z3SMTBool toZ3Bool(Status z3Status) {
	
			switch (z3Status) {
				case UNSATISFIABLE:
					return UNSAT;
				case SATISFIABLE:
					return SAT;
				default:
					return UNKNOWN;
			}
		}
	
	}

	private Z3SMTBool z3Bool;
	private Model z3InternalModel;

	public Z3SMTModel(Z3SMTBool z3Bool, Model z3InternalModel) {
		this.z3Bool = z3Bool;
		this.z3InternalModel = z3InternalModel;
	}

	public Z3SMTModel(Status z3Status, Model z3InternalModel) {
		this.z3Bool = Z3SMTBool.toZ3Bool(z3Status);
		this.z3InternalModel = z3InternalModel;
	}

	public Z3SMTBool getZ3Bool() {
		return z3Bool;
	}

	public Model getZ3InternalModel() {
		return z3InternalModel;
	}

	private Map<String, Integer> getZ3ModelElements(Set<String> functionNames) throws Z3Exception {

		/*TODO
		 * the else continue needs to be thought (depends if the result contains only true elements)
		 * the entries won't have the sort concretization getArgs()[1], but only the integer, to be unified
		 */
		Map<String, Integer> z3ModelElems = new HashMap<String, Integer>();
		for (FuncDecl decl : z3InternalModel.getFuncDecls()) {
			String funcName = decl.getName().toString();
			int subfuncIndex = funcName.indexOf(Z3SMTUtils.Z3_MODEL_SEPARATOR);
			if (subfuncIndex != -1) {
				funcName = funcName.substring(0, subfuncIndex);
			}
			if (!functionNames.contains(funcName)) {
				continue;
			}
			FuncInterp interp = z3InternalModel.getFuncInterp(decl);
			if (interp.getEntries().length == 0) {// function that calls another function
				continue;
			}
			if (Boolean.parseBoolean(interp.getElse().toString())) { // nodes will be false
				continue;
			}
			for (Entry entry : interp.getEntries()) {
				z3ModelElems.put(entry.getArgs()[1].toString(), new Integer(entry.getArgs()[0].toString()));
			}


//			Sort entriesSort = interp.getEntries()[0].getArgs()[0].getSort(); // same for all entries
//			boolean mayOnly = entriesSort.toString().equals(Z3SMTUtils.SMTLIB_TYPE_INT); // may-only encoding
//			boolean elseValue = Boolean.parseBoolean(interp.getElse().toString());
//			if (elseValue) { // entries are false
//				if (mayOnly) {
//					Set<Integer> smtElems = new HashSet<Integer>();//TODO from listener
//				}
//				else {
//					for (Expr concretization : z3InternalModel.getSortUniverse(entriesSort)) {
//						//TODO try this branch and see what it needs
//					}
//				}
//			}
//			else { // entries are true
//				for (Entry entry : interp.getEntries()) {
//					if (mayOnly) {
//						z3ModelElems.put(entry.getArgs()[0].toString(), new Integer(entry.getArgs()[0].toString()));
//					}
//					else {
//						z3ModelElems.put(entry.getArgs()[1].toString(), new Integer(entry.getArgs()[0].toString()));
//					}
//				}
//			}
		}

		return z3ModelElems;
	}

	public Map<String, Integer> getZ3ModelNodes() throws Z3Exception {

		Set<String> functionNames = new HashSet<String>();
		functionNames.add(Z3SMTUtils.SMTLIB_NODE);

		return getZ3ModelElements(functionNames);
	}

	public Map<String, Integer> getZ3ModelEdges() throws Z3Exception {

		Set<String> functionNames = new HashSet<String>();
		functionNames.add(Z3SMTUtils.SMTLIB_EDGE);

		return getZ3ModelElements(functionNames);
	}

	public Map<String, Integer> getZ3ModelNodesAndEdges() throws Z3Exception {

		Set<String> functionNames = new HashSet<String>();
		functionNames.add(Z3SMTUtils.SMTLIB_NODE);
		functionNames.add(Z3SMTUtils.SMTLIB_EDGE);

		return getZ3ModelElements(functionNames);
	}

}
