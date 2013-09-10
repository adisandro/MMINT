#include <z3.h>
#include <stdlib.h>
#include <string.h>
#include "Z3SMTSolver.h"

int checkSat(char *smtEncoding) {

	// check sat, no incremental
	Z3_config config = Z3_mk_config();
	Z3_context context = Z3_mk_context_rc(config);
	Z3_del_config(config);
	Z3_solver solver = Z3_mk_solver(context);
	Z3_solver_inc_ref(context, solver);
	Z3_ast assert = Z3_parse_smtlib2_string(context, smtEncoding, 0, 0, 0, 0, 0, 0);
	Z3_inc_ref(context, assert);
	Z3_solver_assert(context, solver, assert);
	Z3_dec_ref(context, assert);
	int result = Z3_solver_check(context, solver);
	Z3_solver_dec_ref(context, solver);
	Z3_del_context(context);

	return result;
}

Z3Result *checkSatAndGetModel(char *smtEncoding) {

	Z3Result *result = (Z3Result*) calloc(1, sizeof(Z3Result));
	if (result == NULL) {
		return NULL;
	}
	// check sat and get model, no incremental
	Z3_config config = Z3_mk_config();
	Z3_set_param_value(config, "MODEL", "true");
	Z3_set_param_value(config, "MODEL_COMPLETION", "true");
	Z3_context context = Z3_mk_context_rc(config);
	Z3_del_config(config);
	Z3_solver solver = Z3_mk_solver(context);
	Z3_solver_inc_ref(context, solver);
	Z3_ast assert = Z3_parse_smtlib2_string(context, smtEncoding, 0, 0, 0, 0, 0, 0);
	Z3_inc_ref(context, assert);
	Z3_solver_assert(context, solver, assert);
	Z3_dec_ref(context, assert);
	result->flag = Z3_solver_check(context, solver);
	if (result->flag == 1) {
		Z3_model model = Z3_solver_get_model(context, solver);
		Z3_model_inc_ref(context, model);
		Z3_string modelString = Z3_model_to_string(context, model);
		Z3_model_dec_ref(context, model);
		int modelLen = strlen(modelString) + 1;
		result->model = (char*) calloc(modelLen, sizeof(char));
		if (result->model == NULL) {
			result->flag = 0;
		}
		else {
			strncpy(result->model, modelString, modelLen);
		}
	}
	Z3_solver_dec_ref(context, solver);
	Z3_del_context(context);

	return result;
}

void freeResult(Z3Result *result) {

	// free structures
	if (result->model != NULL) {
		free(result->model);
	}
	free(result);
}

static void runCheckSatAndGetModelIncremental(Z3IncResult *incResult, char *smtEncoding, int isTempAssertion) {

	Z3_context context = incResult->contextPointer;
	Z3_solver solver = incResult->solverPointer;
	Z3_model model;
	Z3_ast assert;
	if (incResult->modelPointer != NULL) {
		// parse incremental assert
		model = incResult->modelPointer;
		int numConsts = Z3_model_get_num_consts(context, model);
		int numFuncs = Z3_model_get_num_funcs(context, model);
		int numSorts = Z3_model_get_num_sorts(context, model);
		Z3_symbol funcSymbols[numConsts + numFuncs];
		Z3_func_decl funcDecls[numConsts + numFuncs];
		Z3_symbol sortSymbols[numSorts];
		Z3_sort sorts[numSorts];
		int i;
		for (i = 0; i < numConsts; i++) {
			funcDecls[i] = Z3_model_get_const_decl(context, model, i);
			funcSymbols[i] = Z3_get_decl_name(context, funcDecls[i]);
		}
		int j;
		for (j = 0; j < numFuncs; j++) {
			funcDecls[i+j] = Z3_model_get_func_decl(context, model, j);
			funcSymbols[i+j] = Z3_get_decl_name(context, funcDecls[i+j]);
		}
		int k;
		for (k = 0; k < numSorts; k++) {
			sorts[k] = Z3_model_get_sort(context, model, k);
			sortSymbols[k] = Z3_get_sort_name(context, sorts[k]);
		}
		assert = Z3_parse_smtlib2_string(context, smtEncoding, numSorts, sortSymbols, sorts, numConsts + numFuncs, funcSymbols, funcDecls);
	}
	else {
		// parse baseline assert
		assert = Z3_parse_smtlib2_string(context, smtEncoding, 0, 0, 0, 0, 0, 0);
	}
	Z3_inc_ref(context, assert);
	Z3_solver_assert(context, solver, assert);
	Z3_dec_ref(context, assert);

	// check sat and get model
	incResult->flag = Z3_solver_check(context, solver);
	if (incResult->flag == 1) {
		// get rid of previous model if assertions are piling up
		if (isTempAssertion == 0 && incResult->modelPointer != NULL) {
			Z3_model_dec_ref(context, model);
			incResult->modelPointer = NULL;
		}
		// get rid of previous model string, always
		if (incResult->model != NULL) {
			free(incResult->model);
			incResult->model = NULL;
		}
		model = Z3_solver_get_model(context, solver);
		Z3_model_inc_ref(context, model);
		Z3_string modelString = Z3_model_to_string(context, model);
		int modelLen = strlen(modelString) + 1;
		incResult->model = (char*) calloc(modelLen, sizeof(char));
		if (incResult->model == NULL) {
			incResult->flag = 0;
			Z3_model_dec_ref(context, model);
		}
		else {
			strncpy(incResult->model, modelString, modelLen);
			// store current model if assertions are piling up
			if (isTempAssertion == 0) {
				incResult->modelPointer = model;
			}
			// keep the previous model if assertions are not piling up, throw the current one
			else {
				Z3_model_dec_ref(context, model);
			}
		}
	}
}

Z3IncResult *firstCheckSatAndGetModelIncremental(char *smtEncoding) {

	Z3IncResult *incResult = (Z3IncResult*) calloc(1, sizeof(Z3IncResult));
	if (incResult == NULL) {
		return NULL;
	}
	// first check sat and get model as baseline
	Z3_config config = Z3_mk_config();
	Z3_set_param_value(config, "MODEL", "true");
	Z3_set_param_value(config, "MODEL_COMPLETION", "true");
	Z3_context context = Z3_mk_context_rc(config);
	Z3_del_config(config);
	Z3_solver solver = Z3_mk_solver(context);
	Z3_solver_inc_ref(context, solver);
	incResult->contextPointer = context;
	incResult->solverPointer = solver;
	// first run is always piling up the initial assertion
	runCheckSatAndGetModelIncremental(incResult, smtEncoding, 0);

	return incResult;
}

void checkSatAndGetModelIncremental(Z3IncResult *incResult, char *smtEncoding, int isTempAssertion, int isTempIfUnsatAssertion) {

	// incremental check sat and get model
	Z3_context context = incResult->contextPointer;
	Z3_solver solver = incResult->solverPointer;
	if (isTempAssertion == 1 || isTempIfUnsatAssertion == 1) {
		Z3_solver_push(context, solver);
	}
	runCheckSatAndGetModelIncremental(incResult, smtEncoding, isTempAssertion);
	if (isTempAssertion == 1 || (isTempIfUnsatAssertion == 1 && incResult->flag == -1)) {
		Z3_solver_pop(context, solver, 1);
	}
}

void freeResultIncremental(Z3IncResult *incResult) {

	// free incremental structures
	Z3_context context = incResult->contextPointer;
	Z3_solver solver = incResult->solverPointer;
	if (incResult->modelPointer != NULL) {
		Z3_model_dec_ref(context, incResult->modelPointer);
	}
	Z3_solver_dec_ref(context, solver);
	Z3_del_context(context);
	if (incResult->model != NULL) {
		free(incResult->model);
	}
	free(incResult);
}

