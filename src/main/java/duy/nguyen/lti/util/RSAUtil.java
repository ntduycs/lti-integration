package duy.nguyen.lti.util;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RSAUtil {
    private static final int defaultKeySize = 2048;

    public static Map<String, Key> generateRSAKeyPair(int size) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(size);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Map<String, Key> keys = new HashMap<>();
        keys.put("publicKey", keyPair.getPublic());
        keys.put("privateKey", keyPair.getPrivate());

        return keys;
    }

    public static Map<String, Key> generateRSAKeyPair() throws NoSuchAlgorithmException {
        return generateRSAKeyPair(defaultKeySize);
    }

    public static String decrypt(String encryptedText, PublicKey publicKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(Base64.decodeBase64(encryptedText)));
    }

    public static String encrypt(String plainText, PrivateKey privateKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return Base64.encodeBase64String(cipher.doFinal(plainText.getBytes()));
    }

    public static JWK publicKeyToJwk(Key key) {
        return publicKeyToJwk(key, UUID.randomUUID().toString());
    }

    public static JWK publicKeyToJwk(Key publicKey, String kid) {
        return new RSAKey.Builder((RSAPublicKey) publicKey)
                .keyID(kid)
                .keyUse(KeyUse.SIGNATURE)
                .build();
    }

    public static JWK publicKeyToJwk(Key publicKey, Key privateKey, String kid) {
        return new RSAKey.Builder((RSAPublicKey) publicKey)
                .privateKey((PrivateKey) privateKey)
                .keyID(kid)
                .keyUse(KeyUse.SIGNATURE)
                .build();
    }


}
