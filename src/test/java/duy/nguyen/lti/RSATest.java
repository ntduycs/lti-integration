package duy.nguyen.lti;

import duy.nguyen.lti.util.HybridRSAUtil;
import duy.nguyen.lti.util.RSAUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Map;
import java.util.UUID;

public class RSATest {
    @Test
    public void usingOriginalRSA() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String plainText = "Hello World";

        Map<String, Key> keyPair = RSAUtil.generateRSAKeyPair();

        String encryptedText = RSAUtil.encrypt(plainText, (PrivateKey) keyPair.get("privateKey"));

        Assert.assertEquals(plainText, RSAUtil.decrypt(encryptedText, (PublicKey) keyPair.get("publicKey")));
    }

    @Test
    public void usingHybridRSA() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String plainText = "Hello World";

        Map<String, Key> rsaKeyPair = HybridRSAUtil.generateRSAKeyPair();

        String aesSecretKey = HybridRSAUtil.generateAESSecretKey();

        String[] encryptedPayload = HybridRSAUtil.encrypt(plainText, aesSecretKey, (PrivateKey) rsaKeyPair.get("privateKey"));

        String encryptedText = encryptedPayload[0];
        String encryptedAESSecretKey = encryptedPayload[1];

        Assert.assertEquals(plainText, HybridRSAUtil.decrypt(encryptedText, encryptedAESSecretKey, (PublicKey) rsaKeyPair.get("publicKey")));
    }

    @Test
    public void convertToJWK() throws NoSuchAlgorithmException {
        Map<String, Key> keyPair = RSAUtil.generateRSAKeyPair();

        System.out.println(RSAUtil.publicKeyToJwk(keyPair.get("publicKey")));
        System.out.println(RSAUtil.publicKeyToJwk(keyPair.get("publicKey"), keyPair.get("privateKey"), UUID.randomUUID().toString()));
    }
}
