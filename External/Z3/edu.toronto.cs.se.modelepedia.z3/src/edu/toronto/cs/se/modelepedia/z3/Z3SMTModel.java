package edu.toronto.cs.se.modelepedia.z3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.FuncInterp;
import com.microsoft.z3.Model;
import com.microsoft.z3.Status;
import com.microsoft.z3.Z3Exception;
import com.microsoft.z3.FuncInterp.Entry;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;

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

	private Map<String, Integer> getZ3ModelElements(Map<Integer, String> smtEncodingElems, String functionName) {

		Map<String, Integer> z3ModelElems = new HashMap<String, Integer>();
		try {
			for (FuncDecl decl : z3InternalModel.getFuncDecls()) {
				// filter function
				String declName = decl.getName().toString();
				int subfuncIndex = declName.indexOf(Z3SMTUtils.Z3_MODEL_SEPARATOR);
				if (subfuncIndex != -1) {
					declName = declName.substring(0, subfuncIndex);
				}
				if (!functionName.equals(declName)) {
					continue;
				}
				FuncInterp interp = z3InternalModel.getFuncInterp(decl);
				if (interp.getEntries().length == 0) {// function that calls another function
					continue;
				}
				// parse entries
				boolean mayOnly = (interp.getEntries()[0].getNumArgs() == 1); // may-only encoding
				boolean elseValue = Boolean.parseBoolean(interp.getElse().toString());
				if (elseValue) { // entries are false
					if (mayOnly) {
						Set<Integer> smtElems = smtEncodingElems.keySet();
						Map<String, Integer> funcZ3ModelElems = new HashMap<String, Integer>();
						for (Integer smtElem : smtElems) { // add all
							funcZ3ModelElems.put(smtElem.toString(), new Integer(smtElem));
						}
						for (Entry entry : interp.getEntries()) { // remove false entries
							funcZ3ModelElems.remove(entry.getArgs()[0].toString());
						}
						z3ModelElems.putAll(funcZ3ModelElems);
					}
					else {
						//TODO MMINT[TOSEM] is this branch ever going to be a use case?
	//					for (Expr concretization : z3InternalModel.getSortUniverse(entriesSort)) {
	//						
	//					}
					}
				}
				else { // entries are true
					for (Entry entry : interp.getEntries()) {
						if (mayOnly) {
							z3ModelElems.put(entry.getArgs()[0].toString(), new Integer(entry.getArgs()[0].toString()));
						}
						else {
							z3ModelElems.put(entry.getArgs()[1].toString(), new Integer(entry.getArgs()[0].toString()));
						}
					}
				}
			}
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Can't parse Z3 model elements, returning elements so far (possibly none)", e);
		}

		return z3ModelElems;
	}

	public Map<String, Integer> getZ3ModelNodes(Map<Integer, String> smtEncodingNodes) {

		return getZ3ModelElements(smtEncodingNodes, Z3SMTUtils.SMTLIB_NODE);
	}

	public Map<String, Integer> getZ3ModelEdges(Map<Integer, String> smtEncodingEdges) {

		return getZ3ModelElements(smtEncodingEdges, Z3SMTUtils.SMTLIB_EDGE);
	}

}
