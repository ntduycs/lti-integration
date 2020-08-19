package duy.nguyen.lti.core.oidc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OidcAuthenticationResponse implements Serializable {
    @JsonProperty("state")
    private String state;

    @JsonProperty("id_token")
    private String idToken;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
