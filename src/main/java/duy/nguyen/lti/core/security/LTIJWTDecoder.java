package duy.nguyen.lti.core.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolver;

import java.security.Key;

public class LTIJWTDecoder {
    private static final long allowedClockSkewSeconds = 5 * 60; // 5 minutes

    public static Jws<Claims> decode(String token, String jwksEndpoint) {
        SigningKeyResolver signingKeyResolver = new LTISigningKeyResolver(jwksEndpoint);

        return Jwts.parser()
                .setSigningKeyResolver(signingKeyResolver)
                .setAllowedClockSkewSeconds(allowedClockSkewSeconds)
                .parseClaimsJws(token);
    }

    public static Jws<Claims> decode(String token, Key key) {
        return Jwts.parser()
                .setSigningKey(key)
                .setAllowedClockSkewSeconds(allowedClockSkewSeconds)
                .parseClaimsJws(token);
    }

    public static Jws<Claims> decode(String token, byte[] keyAsBytes) {
        return Jwts.parser()
                .setSigningKey(keyAsBytes)
                .setAllowedClockSkewSeconds(allowedClockSkewSeconds)
                .parseClaimsJws(token);
    }

    private LTIJWTDecoder() {}
}
