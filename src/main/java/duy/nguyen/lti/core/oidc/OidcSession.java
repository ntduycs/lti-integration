package duy.nguyen.lti.core.oidc;

public interface OidcSession {
    void setState(String state);
    void setNonce(String nonce);
    void setTargetLinkUri(String targetLinkUri);

    String getState();
    String getNonce();
    String getTargetLinkUri();
}
