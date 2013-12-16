package fr.ece.tweetstats.core.exception;

import org.sculptor.framework.errorhandling.ApplicationException;

public class SearchNotFoundException extends ApplicationException {
	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = SearchNotFoundException.class.getSimpleName();
	private static final String CLASS_FULL_NAME = SearchNotFoundException.class.getName();

	public SearchNotFoundException(String m, java.io.Serializable... messageParameter) {
		super(CLASS_FULL_NAME, m);
		setMessageParameters(messageParameter);
	}

	public SearchNotFoundException(int errorCode, String m, java.io.Serializable... messageParameter) {
		super(String.format("%1$s-%3$04d", CLASS_FULL_NAME, CLASS_NAME, errorCode), m);
		setMessageParameters(messageParameter);
	}
}
