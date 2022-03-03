package codebug.exercises.numbers;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    public RandomNumberGenerator() {

    }

    public static String randomBinaryNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        return Integer.toBinaryString(randomNum);
    }

    public static String randomOctalNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        return Integer.toOctalString(randomNum);
    }

    public static String randomDecimalNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        return Integer.toString(randomNum);
    }

    public static String randomHexadecimalNumber(int minSize, int maxSize) {
        int randomNum = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        String hexString = Integer.toHexString(randomNum);
        return hexString.toUpperCase();
    }
}
