#include <z3.h>
#include "Z3SMTSolver.h"

int checkSat(char *smtString) {

	Z3_config cfg = Z3_mk_config();
	Z3_context ctx = Z3_mk_context(cfg);
	Z3_del_config(cfg);

	return 0;
}
