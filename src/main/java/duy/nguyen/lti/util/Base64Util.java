package duy.nguyen.lti.util;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class Base64Util {
    public static String encode(byte[] data) {
        return DatatypeConverter.printBase64Binary(data);
    }

    public static String encode(String data) {
        return encode(data.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] decodeAsBytes(String base64) {
        return DatatypeConverter.parseBase64Binary(base64);
    }

    public static String decodeAsString(String base64) {
        return new String(decodeAsBytes(base64), StandardCharsets.UTF_8);
    }
}
