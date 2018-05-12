package hu.unideb.nursenotes.service.api.exception;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;

/**
 * Service exception class.
 */
public class ServiceException extends BaseException {

    /**
     * Inherits from superclass.
     */
    public ServiceException() {
        super();
    }

    /**
     * @param message from superclass.
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * @param message from superclass.
     * @param cause from superclass.
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
