package splar.apps.generator;

public interface FMGeneratorEngineListener {
	public void generatingModel(String modelName);
	public void doneGeneratingModel(String modelName);
	public void modelAccepted(String modelName);
	public void modelRejected(String modelName, String reason);
	public void modelGenerationStarted();	
	public void modelGenerationEnded();	
	public void modelIsUnsat(String modelName);	
	public void modelIsSat(String modelName);	
	public void errorDuringGeneration(String modelName, String errorMessage);	
	public void generationCanceled();	
}
