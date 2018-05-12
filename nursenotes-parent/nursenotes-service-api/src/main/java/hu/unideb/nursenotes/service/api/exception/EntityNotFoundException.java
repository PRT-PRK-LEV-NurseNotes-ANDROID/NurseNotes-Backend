package hu.unideb.nursenotes.service.api.exception;

/**
 * Entity not found exception class.
 */
public class EntityNotFoundException extends ServiceException {

    /**
     * Inherits from superclass.
     */
    public EntityNotFoundException() {
        super();
    }

    /**
     *
     * @param message of superclass exception.
     */
    public EntityNotFoundException(final String message) {
        super(message);
    }

    /**
     *
     * @param message of superclass exception.
     * @param cause of superclass exception.
     */
    public EntityNotFoundException(final String message,
                                   final Throwable cause) {
        super(message, cause);
    }
}
