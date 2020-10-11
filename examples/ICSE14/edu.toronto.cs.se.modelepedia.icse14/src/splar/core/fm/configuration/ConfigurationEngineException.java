package splar.core.fm.configuration;

import java.util.Map;

public class ConfigurationEngineException extends Exception {
	
	public ConfigurationEngineException(Throwable throwable) {
		super(throwable);
	}
	
	public ConfigurationEngineException(String errorMessage) {
		super(errorMessage);
	}
	
	public ConfigurationEngineException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}	
	
}
