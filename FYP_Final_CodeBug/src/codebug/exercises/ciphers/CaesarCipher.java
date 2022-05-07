/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
CaesarCipher - Contains methods for Caesar Cipher encryption and decryption
 */

package codebug.exercises.ciphers;

public class CaesarCipher {

    // All allowed characters
    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Caesar encrypt method - takes plaintext and shift amount and returns ciphertext
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

    // Caesar decrypt method - takes ciphertext and shift amount and returns plaintext
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