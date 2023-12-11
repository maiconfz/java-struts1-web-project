package com.my_app.exception;

public class AppGenericException extends RuntimeException {
    private static final long serialVersionUID = -8798179471741847116L;
    
    public AppGenericException() {
        super();
    }

    public AppGenericException(String message) {
        super(message);
    }

    public AppGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppGenericException(Throwable cause) {
        super(cause);
    }
}

