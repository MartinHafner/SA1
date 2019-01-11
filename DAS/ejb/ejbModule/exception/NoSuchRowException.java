package exception;

public class NoSuchRowException extends Exception {

	private static final long serialVersionUID = 4387291494998343406L;

	public NoSuchRowException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NoSuchRowException(final String message) {
		super(message);
	}

}
