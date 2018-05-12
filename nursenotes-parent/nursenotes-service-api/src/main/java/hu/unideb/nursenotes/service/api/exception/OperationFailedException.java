package hu.unideb.nursenotes.service.api.exception;

/**
 * Operation failed exception class.
 */
public class OperationFailedException extends Exception {

    /**
     * @param message from superclass.
     */
    public OperationFailedException(final String message) {
        super(message);
    }

    /**
     * @param cause from superclass.
     */
    public OperationFailedException(final Throwable cause) {
        super(cause);
    }
}
