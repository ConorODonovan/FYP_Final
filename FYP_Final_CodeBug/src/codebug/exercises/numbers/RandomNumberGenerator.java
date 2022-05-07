/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
RandomNumberGenerator Class - Generates random Binary, Octal, Decimal, and Hexadecimal numbers
 */

package codebug.exercises.numbers;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    public RandomNumberGenerator() {

    }

    // Generate random Binary number
    public static String randomBinaryNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        return Integer.toBinaryString(randomNum);
    }

    // Generate random Octal number
    public static String randomOctalNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        return Integer.toOctalString(randomNum);
    }

    // Generate random Decimal number
    public static String randomDecimalNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        return Integer.toString(randomNum);
    }

    // Generate random Hexadecimal number
    public static String randomHexadecimalNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        String hexString = Integer.toHexString(randomNum);
        return hexString.toUpperCase();
    }
}
