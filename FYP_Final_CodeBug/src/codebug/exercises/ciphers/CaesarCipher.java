package codebug.exercises.ciphers;

public class CaesarCipher {

    public static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String plainText, int shiftKey) {
        plainText = plainText.toUpperCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) == ' ') {
                cipherText += " ";
                continue;
            }

            int charPosition = alpha.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = alpha.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toUpperCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            if (cipherText.charAt(i) == ' ') {
                plainText += " ";
                continue;
            }

            int charPosition = alpha.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = alpha.length() + keyVal;
            }
            char replaceVal = alpha.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
}