package duy.nguyen.lti.core.oidc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author ntduycs
 * The tool, after receiving the {@link OidcLoginRequest}, must then perform an authentication request
 * over a form POST to Platform's OIDC Authentication Endpoint
 */
public class OidcAuthenticationRequest implements Serializable {
    @JsonProperty("scope")
    private final String scope;

    @JsonProperty("response_type")
    private final String responseType;

    @JsonProperty("client_id")
    private String clientId;

    /**
     * The URI that the Platform will send the {@link OidcAuthenticationResponse} to, once validated successfully
     */
    @JsonProperty("redirect-uri")
    private String redirectUri; // one of the registered redirect URIs

    @JsonProperty("login_hint")
    private String loginHint;

    @JsonProperty("state")
    private String state; // maintain state between the request and callback and provide CSRF mitigation.

    @JsonProperty("response_mode")
    private final String responseMode;

    @JsonProperty("nonce")
    private String nonce; // used to associate a Client session with an ID Token, and to mitigate replay attacks.

    @JsonProperty("prompt")
    private final String prompt;

    public String getScope() {
        return scope;
    }

    public String getResponseType() {
        return responseType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getLoginHint() {
        return loginHint;
    }

    public String getState() {
        return state;
    }

    public String getResponseMode() {
        return responseMode;
    }

    public String getNonce() {
        return nonce;
    }

    public String getPrompt() {
        return prompt;
    }

    private OidcAuthenticationRequest() {
        this.scope = "openid";
        this.responseType = "id_token";
        this.responseMode = "form_post";
        this.prompt = "none";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final OidcAuthenticationRequest instance = new OidcAuthenticationRequest();

        public Builder withClientId(String clientId) {
            instance.clientId = clientId;
            return this;
        }

        public Builder withRedirectUri(String redirectUri) {
            instance.redirectUri = redirectUri;
            return this;
        }

        public Builder withLoginHint(String loginHint) {
            instance.loginHint = loginHint;
            return this;
        }

        public Builder withState(String state) {
            instance.state = state;
            return this;
        }

        public Builder withNonce(String nonce) {
            instance.nonce = nonce;
            return this;
        }

        public OidcAuthenticationRequest build() {
            return instance;
        }
    }
}
