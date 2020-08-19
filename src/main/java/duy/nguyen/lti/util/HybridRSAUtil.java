package duy.nguyen.lti.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

public class HybridRSAUtil {
    private static final int defaultAESKeySize = 128;
    private static final int defaultRSAKeySize = 2048;

    public static String[] encrypt(String plainText, String aesSecretKey, PrivateKey privateKey)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String encryptedText = encryptTextUsingAES(plainText, aesSecretKey);
        String encryptAESSecretKey = encryptAESKey(aesSecretKey, privateKey);

        return new String[] {encryptedText, encryptAESSecretKey};
    }

    public static String decrypt(String encryptedText, String encryptedAESSecretKey, PublicKey publicKey)
            throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String aesSecretKey = decryptAESKey(encryptedAESSecretKey, publicKey);
        return decryptTextUsingAES(encryptedText, aesSecretKey);
    }

    public static String generateAESSecretKey(int size) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(size);
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.encodeBase64String(secretKey.getEncoded());
    }

    public static String generateAESSecretKey() throws NoSuchAlgorithmException {
        return generateAESSecretKey(defaultAESKeySize);
    }

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
        return generateRSAKeyPair(defaultRSAKeySize);
    }

    // Encrypt text using AES key
    private static String encryptTextUsingAES(String plainText, String aesKeyString)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] decodedKey = Base64.decodeBase64(aesKeyString);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, originalKey);

        return Base64.encodeBase64String(aesCipher.doFinal(plainText.getBytes()));
    }

    // Decrypt text using AES key
    private static String decryptTextUsingAES(String encryptedText, String aesKeyString)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] decodedKey = Base64.decodeBase64(aesKeyString);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, originalKey);

        return new String(aesCipher.doFinal(Base64.decodeBase64(encryptedText)));
    }

    // Decrypt AES Key using RSA public key
    private static String decryptAESKey(String encryptedAESKey, PublicKey publicKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(Base64.decodeBase64(encryptedAESKey)));
    }

    // Encrypt AES Key using RSA private key
    private static String encryptAESKey(String plainAESKey, PrivateKey privateKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return Base64.encodeBase64String(cipher.doFinal(plainAESKey.getBytes()));
    }
}
