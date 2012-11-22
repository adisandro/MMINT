#include <z3.h>
#include "Z3SMTSolver.h"

int checkSat(char *smtString) {

	Z3_config config = Z3_mk_config();
	Z3_context context = Z3_mk_context(config);
	Z3_del_config(config);
	Z3_solver solver = Z3_mk_solver(context);
	Z3_solver_inc_ref(context, solver);
	Z3_ast assert = Z3_parse_smtlib2_string(context, smtString, 0, 0, 0, 0, 0, 0);
	Z3_solver_assert(context, solver, assert);
	int result = Z3_solver_check(context, solver);
	Z3_solver_dec_ref(context, solver);
	Z3_del_context(context);

	return result;
}
