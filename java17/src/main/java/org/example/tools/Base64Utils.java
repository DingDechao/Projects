package org.example.tools;

public class Base64Utils {

    public static String encode(String input) {
        return java.util.Base64.getEncoder().encodeToString(input.getBytes());
    }

    public static String decode(String encodedInput) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(encodedInput);
        return new String(decodedBytes);
    }


    public static void main(String[] args) {
        String originalString = "admin:12345";
        String encodedString = encode(originalString);
        System.out.println("Original: " + originalString);
        System.out.println("Encoded: " + encodedString);

        String decodedString = decode(encodedString);
        System.out.println("Decoded: " + decodedString);
    }
}
