package br.com.algaecommerce.exception;

public class MyEntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MyEntityNotFoundException(String message) {
        super(message);
    }

    public MyEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}