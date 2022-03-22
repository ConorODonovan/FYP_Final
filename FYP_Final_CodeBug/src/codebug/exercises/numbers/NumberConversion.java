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

    public static String convertOctToDec(String num) {
        int octalNum = Integer.parseInt(num, 8);
        return String.valueOf(octalNum);
    }

    public static String convertOctToHex(String num) {
        int octalNum = Integer.parseInt(num, 8);
        return Integer.toHexString(octalNum);
    }

    public static String convertDecToBin(String num) {
        int decimalNum = Integer.parseInt(num);
        return Integer.toBinaryString(decimalNum);
    }

    public static String convertDecToOct(String num) {
        int decimalNum = Integer.parseInt(num);
        return Integer.toOctalString(decimalNum);
    }

    public static String convertDecToHex(String num) {
        int decimalNum = Integer.parseInt(num);
        return Integer.toHexString(decimalNum);
    }

    public static String convertHexToBin(String num) {
        int hexadecimalNum = Integer.parseInt(num, 16);
        return Integer.toBinaryString(hexadecimalNum);
    }

    public static String convertHexToOct(String num) {
        System.out.println(num);
        int hexadecimalNum = Integer.parseInt(num, 16);
        System.out.println(hexadecimalNum);
        return Integer.toOctalString(hexadecimalNum);
    }

    public static String convertHexToDec(String num) {
        int hexadecimalNum = Integer.parseInt(num, 16);
        return String.valueOf(hexadecimalNum);
    }
}
