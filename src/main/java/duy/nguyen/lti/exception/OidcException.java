package duy.nguyen.lti.exception;

public class OidcException extends RuntimeException {
    public OidcException(String message) {
        super(message);
    }

    public OidcException(String message, Throwable cause) {
        super(message, cause);
    }
}
