package duy.nguyen.lti.core.oidc;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ntduycs
 * When a user wants to launch into a Tool, the Platform will start the OIDC flow
 * by redirecting the User Agent (UA) to the 3rd party initiated login end point with the payload
 */
public class OidcLoginRequest {
    // The following attributes are required

    @JsonProperty("iss")
    private String iss; //The issuer identifier identifying the learning platform.

    @JsonProperty("login_hint")
    private String loginHint;

    @JsonProperty("target_link_uri")
    private String targetLinkUri; // The actual end-point should be executed at the end of the OIDC authentication flow.

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getLoginHint() {
        return loginHint;
    }

    public void setLoginHint(String loginHint) {
        this.loginHint = loginHint;
    }

    public String getTargetLinkUri() {
        return targetLinkUri;
    }

    public void setTargetLinkUri(String targetLinkUri) {
        this.targetLinkUri = targetLinkUri;
    }
}
