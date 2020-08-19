package duy.nguyen.lti.core.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import duy.nguyen.lti.exception.OidcException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;

import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.text.ParseException;

public class LTISigningKeyResolver extends SigningKeyResolverAdapter {
    private final String jwksEndpoint;

    public LTISigningKeyResolver(String jwksEndpoint) {
        this.jwksEndpoint = jwksEndpoint;
    }

    @Override
    public Key resolveSigningKey(JwsHeader header, Claims claims) {
        String kid = header.getKeyId();

        if (kid == null) {
            throw new OidcException("KID header not passed in JWT token");
        }

        try {
            JWKSet jwkSet = JWKSet.load(new URL(jwksEndpoint));
            JWK jwk = jwkSet.getKeyByKeyId(kid);

            if (jwk == null) {
                throw new OidcException("Incorrect KID header passed in JWT token");
            }

            return jwk.toRSAKey().toPublicKey();
        } catch (ParseException | JOSEException | IOException e) {
            throw new OidcException("Unexpected error when trying to load and parse Platform's public key.", e);
        }
    }
}
