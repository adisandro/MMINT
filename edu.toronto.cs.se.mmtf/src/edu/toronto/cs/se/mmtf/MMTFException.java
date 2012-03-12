package edu.toronto.cs.se.mmtf;

public class MMTFException extends Exception {

	public enum Type {WARNING, ERROR}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MMTFException(String message) {

		super(message);
	}

	public MMTFException(String message, Throwable cause) {

		super(message, cause);
	}

	public static void print(Type type, Exception e, String message) {

		switch (type) {
			case WARNING:
				message = "WARNING:" + message;
				break;
			case ERROR:
			default:
				message = "ERROR:" + message;
				break;
		}
		System.err.println(message);
		e.printStackTrace();
	}

}
