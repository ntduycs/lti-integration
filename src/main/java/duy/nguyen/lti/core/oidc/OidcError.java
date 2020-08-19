package duy.nguyen.lti.core.oidc;

/**
 * @see <a href="https://openid.net/specs/openid-connect-core-1_0.html#AuthError">See here</a> for more details
 */
public enum OidcError {
    INTERACTION_REQUIRED("interaction_required"),
    LOGIN_REQUIRED("login_required"),
    ACCOUNT_SELECTION_REQUIRED("account_selection_required"),
    CONSENT_REQUIRED("consent_required"),
    INVALID_REQUEST_URI("invalid_request_uri"),
    INVALID_REQUEST_OBJECT("invalid_request_object"),
    REQUEST_NOT_SUPPORTED("request_not_supported"),
    REQUEST_URI_NOT_SUPPORTED("request_uri_not_supported"),
    REGISTRATION_NOT_SUPPORTED("registration_not_supported"),
    ;

    private final String error;

    OidcError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
