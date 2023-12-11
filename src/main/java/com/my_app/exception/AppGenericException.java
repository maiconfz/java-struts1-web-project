package com.my_app.exception;

/**
 * A custom runtime exception representing generic application-level errors.
 * 
 * This exception can be used to encapsulate various runtime issues that may occur
 * during the execution of the application. It extends the RuntimeException class,
 * providing constructors for creating instances with different types of information.
 * 
 */
public class AppGenericException extends RuntimeException {
    private static final long serialVersionUID = -8798179471741847116L;

    /**
     * Constructs a new AppGenericException with no detail message.
     */
    
    public AppGenericException() {
        super();
    }

    /**
     * Constructs a new AppGenericException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     */
    public AppGenericException(String message) {
        super(message);
    }

    /**
     * Constructs a new AppGenericException with the specified detail message
     * and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method). (A null value is permitted,
     *                and indicates that the cause is nonexistent or unknown.)
     */
    public AppGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new AppGenericException with the specified cause and a
     * detail message of (cause==null ? null : cause.toString()) (which
     * typically contains the class and detail message of cause).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method). (A null value is permitted,
     *              and indicates that the cause is nonexistent or unknown.)
     */
    public AppGenericException(Throwable cause) {
        super(cause);
    }
}

