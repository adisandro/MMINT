#include <z3.h>
#include <stdlib.h>
#include <string.h>
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

Z3Result *checkSatAndGetModel(char *smtString) {

	Z3_config config = Z3_mk_config();
	Z3_set_param_value(config, "MODEL", "true");
	Z3_context context = Z3_mk_context(config);
	Z3_del_config(config);
	Z3_solver solver = Z3_mk_solver(context);
	Z3_solver_inc_ref(context, solver);
	Z3_ast assert = Z3_parse_smtlib2_string(context, smtString, 0, 0, 0, 0, 0, 0);
	Z3_solver_assert(context, solver, assert);
	Z3Result *result = malloc(sizeof(Z3Result));
	result->flag = Z3_solver_check(context, solver);
	if (result->flag == 1) {
		Z3_model model = Z3_solver_get_model(context, solver);
		Z3_model_inc_ref(context, model);
		Z3_string modelString = Z3_model_to_string(context, model);
		Z3_model_dec_ref(context, model);
		int modelLen = sizeof(char) * (strlen(modelString) + 1);
		result->model = malloc(modelLen);
		strncpy(result->model, modelString, modelLen);
	}
	Z3_solver_dec_ref(context, solver);
	Z3_del_context(context);

	return result;
}

void freeResult(Z3Result *result) {

	if (result->model != NULL) {
		free(result->model);
	}
	free(result);
}
