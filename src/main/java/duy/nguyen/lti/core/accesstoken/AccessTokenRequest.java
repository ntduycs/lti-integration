package duy.nguyen.lti.core.accesstoken;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AccessTokenRequest implements Serializable {
    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("client_assertion_type")
    private String clientAssertionType;

    @JsonProperty("client_assertion")
    private String clientAssertion;

    @JsonProperty("scope")
    private String scope; // whitespace-separated string list
}
