package codebug.exercises.numbers;

public class NumberConversion {

    public NumberConversion() {

    }

    public static String convertBinToOct(String num) {
        int binaryNum = Integer.parseInt(num, 2);
        return Integer.toOctalString(binaryNum);
    }

    public static String convertBinToDec(String num) {
        int binaryNum = Integer.parseInt(num, 2);
        return String.valueOf(binaryNum);
    }

    public static String convertBinToHex(String num) {
        int binaryNum = Integer.parseInt(num, 2);
        return Integer.toHexString(binaryNum);
    }

    public static String convertOctToBin(String num) {
        int octalNum = Integer.parseInt(num, 8);
        return Integer.toBinaryString(octalNum);
    }

    public static String convertDecToBin(String num) {
        int decimalNum = Integer.parseInt(num);
        return Integer.toBinaryString(decimalNum);
    }

    public static String convertHexToBin(String num) {
        int hexadecimalNum = Integer.parseInt(num, 16);
        return Integer.toBinaryString(hexadecimalNum);
    }
}
