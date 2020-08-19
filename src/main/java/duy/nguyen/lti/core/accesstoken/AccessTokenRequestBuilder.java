package duy.nguyen.lti.core.accesstoken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessTokenRequestBuilder {
    public static String build(AccessTokenRequest accessTokenRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(accessTokenRequest);
    }
}
