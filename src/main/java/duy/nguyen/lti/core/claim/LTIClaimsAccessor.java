package duy.nguyen.lti.core.claim;

public interface LTIClaimsAccessor {
    /**
     * @param claims name of the claim to get
     * @param clazz type of targeted claim
     * @return object of type T with claim's content or null if not found/not presented
     */
    <T> T get(LTIClaims claims, Class<T> clazz);
}
