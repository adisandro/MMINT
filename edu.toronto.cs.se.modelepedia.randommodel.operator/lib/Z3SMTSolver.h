#ifndef Z3SMTSOLVER_H__
#define Z3SMTSOLVER_H__

typedef struct {
	int flag;
	char *model;
} Z3Result;

int checkSat(char *smtEncoding);
Z3Result *checkSatAndGetModel(char *smtEncoding, char **mayModelObjs);
void freeResult(Z3Result *result);

#endif  // Z3SMTSOLVER_H__
