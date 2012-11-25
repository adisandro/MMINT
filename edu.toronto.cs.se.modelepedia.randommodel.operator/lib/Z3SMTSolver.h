#ifndef Z3SMTSOLVER_H__
#define Z3SMTSOLVER_H__

typedef struct {
	int flag;
	char *model;
} Z3Result;

int checkSat(char *smtString);
Z3Result *checkSatAndGetModel(char *smtString);
void freeResult(Z3Result *result);

#endif  // Z3SMTSOLVER_H__
