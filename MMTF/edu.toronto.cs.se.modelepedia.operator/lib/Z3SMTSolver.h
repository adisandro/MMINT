#ifndef Z3SMTSOLVER_H__
#define Z3SMTSOLVER_H__

typedef struct {
	int flag;
	char *model;
} Z3Result;

typedef struct {
	int flag;
	char *model;
	Z3_context contextPointer;
	Z3_solver solverPointer;
	Z3_model modelPointer;
} Z3IncResult;

int checkSat(char *smtEncoding);
Z3Result *checkSatAndGetModel(char *smtEncoding);
void freeResult(Z3Result *result);
static void runCheckSatAndGetModelIncremental(Z3IncResult *incResult, char *smtEncoding, int removeLastAssertion);
Z3IncResult *firstCheckSatAndGetModelIncremental(char *smtEncoding);
void checkSatAndGetModelIncremental(Z3IncResult *incResult, char *smtEncoding, int removeLastAssertion);
void freeResultIncremental(Z3IncResult *incResult);

#endif  // Z3SMTSOLVER_H__
