#ifndef Z3SMTSOLVER_H__
#define Z3SMTSOLVER_H__

typedef struct {
	int flag;
	char *model;
} Z3Result;

Z3Result checkSat(char *smtString, int getModel);

#endif  // Z3SMTSOLVER_H__
