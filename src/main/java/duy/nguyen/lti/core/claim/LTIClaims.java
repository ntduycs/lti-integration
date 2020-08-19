package duy.nguyen.lti.core.claim;

public enum LTIClaims {
    // JOSE Header. The Consumer MUST also add a second, header element, referred to as the JOSE header,
    // that defines the algorithm it used to sign the token.
    TYPE("typ"),
    ALG("alg"),

    // JWT payload requires at least the following claims
    ISS("iss"), // A unique identifier for the entity that issued the JWT
    SUB("sub"), // "client_id" of the OAuth Consumer
    AUD("aud"), // Authorization server identifier (s)
    IAT("iat"), // Timestamp for when the JWT was created
    EXP("exp"), // Timestamp for when the JWT should be treated as having expired
    JTI("jti"), // A unique (potentially reusable) identifier for the token
    AZP("azp"),

    MESSAGE_TYPE("https://purl.imsglobal.org/spec/lti/claim/message_type"),
    VERSION("https://purl.imsglobal.org/spec/lti/claim/version"),

    NAME("name"),
    GIVEN_NAME("given_name"),
    FAMILY_NAME("family_name"),
    MIDDLE_NAME("middle_name"),
    PICTURE("picture"),
    EMAIL("email"),
    LOCALE("locale"),

    NONCE("nonce"),

    DEPLOYMENT_ID("https://purl.imsglobal.org/spec/lti/claim/deployment_id"),

    RESOURCE_LINK("https://purl.imsglobal.org/spec/lti/claim/resource_link"),
    CONTEXT("https://purl.imsglobal.org/spec/lti/claim/context"),
    ROLES("https://purl.imsglobal.org/spec/lti/claim/roles"),
    TOOL_PLATFORM("https://purl.imsglobal.org/spec/lti/claim/tool_platform"),
    ASSIGNMENT_GRADE_SERVICE("https://purl.imsglobal.org/spec/lti-ags/claim/endpoint"),
    NAMES_ROLE_SERVICE("https://purl.imsglobal.org/spec/lti-nrps/claim/namesroleservice"),
    CALIPER_SERVICE("https://purl.imsglobal.org/spec/lti-ces/claim/caliper-endpoint-service"),
    PRESENTATION("https://purl.imsglobal.org/spec/lti/claim/launch_presentation"),
    CUSTOM("https://purl.imsglobal.org/spec/lti/claim/custom"),
    TARGET_LINK_URI("https://purl.imsglobal.org/spec/lti/claim/target_link_uri"),
    ROLE_SCOPE_MENTOR("https://purlimsglobal.org/spec/lti/claim/role_scope_mentor"),

    // deep linking claims
    DEEP_LINKING_SETTINGS("https://purl.imsglobal.org/spec/lti-dl/claim/deep_linking_settings"),
    DEEP_LINKING_CONTENT_ITEMS("https://purl.imsglobal.org/spec/lti-dl/claim/content_items"),
    DEEP_LINKING_MESSAGE("https://purl.imsglobal.org/spec/lti-dl/claim/msg"),
    DEEP_LINKING_LOG("https://purl.imsglobal.org/spec/lti-dl/claim/log"),
    DEEP_LINKING_ERROR_MESSAGE("https://purl.imsglobal.org/spec/lti-dl/claim/errormsg"),
    DEEP_LINKING_ERROR_LOG("https://purl.imsglobal.org/spec/lti-dl/claim/errorlog"),
    DEEP_LINKING_DATA("https://purl.imsglobal.org/spec/lti-dl/claim/data")

    ;
    private final String claim;

    LTIClaims(String claim) {
        this.claim = claim;
    }

    public String getClaim() {
        return claim;
    }
}
