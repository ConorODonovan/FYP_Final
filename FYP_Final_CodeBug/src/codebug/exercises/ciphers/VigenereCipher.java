/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
VigenereCipher - Contains methods for Vigenere Cipher encryption and decryption
 */

package codebug.exercises.ciphers;

public class VigenereCipher {

    public static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Encrypt method - takes plaintext and key and returns ciphertext
    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);

            if (c == ' ') {
                res += (char)(' ');
                continue;
            }

            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    // Decrypt method - takes ciphertext and key and returns plaintext
    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);

            if (c == ' ') {
                res += (char)(' ');
                continue;
            }

            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
}