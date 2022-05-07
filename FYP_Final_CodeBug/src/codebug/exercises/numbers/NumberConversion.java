/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
NumberConversion Class - Handles conversion of numbers between Binary, Octal, Decimal, and Hexadecimal
 */

package codebug.exercises.numbers;

public class NumberConversion {

    public NumberConversion() {

    }

    // Convert Binary number to Octal number
    public static String convertBinToOct(String num) {
        int binaryNum = Integer.parseInt(num, 2);
        return Integer.toOctalString(binaryNum);
    }

    // Convert Binary number to Decimal number
    public static String convertBinToDec(String num) {
        int binaryNum = Integer.parseInt(num, 2);
        return String.valueOf(binaryNum);
    }

    // Convert Binary number to Hexadecimal number
    public static String convertBinToHex(String num) {
        int binaryNum = Integer.parseInt(num, 2);
        return Integer.toHexString(binaryNum);
    }

    // Convert Octal number to Binary number
    public static String convertOctToBin(String num) {
        int octalNum = Integer.parseInt(num, 8);
        return Integer.toBinaryString(octalNum);
    }

    // Convert Octal number to Decimal number
    public static String convertOctToDec(String num) {
        int octalNum = Integer.parseInt(num, 8);
        return String.valueOf(octalNum);
    }

    // Convert Octal number to Hexadecimal number
    public static String convertOctToHex(String num) {
        int octalNum = Integer.parseInt(num, 8);
        return Integer.toHexString(octalNum);
    }

    // Convert Decimal number to Binary number
    public static String convertDecToBin(String num) {
        int decimalNum = Integer.parseInt(num);
        return Integer.toBinaryString(decimalNum);
    }

    // Convert Decimal number to Octal number
    public static String convertDecToOct(String num) {
        int decimalNum = Integer.parseInt(num);
        return Integer.toOctalString(decimalNum);
    }

    // Convert Decimal number to Hexadecimal number
    public static String convertDecToHex(String num) {
        int decimalNum = Integer.parseInt(num);
        return Integer.toHexString(decimalNum);
    }

    // Convert Hexadecimal number to Binary number
    public static String convertHexToBin(String num) {
        int hexadecimalNum = Integer.parseInt(num, 16);
        return Integer.toBinaryString(hexadecimalNum);
    }

    // Convery Hexadecimal number to Octal number
    public static String convertHexToOct(String num) {
        System.out.println(num);
        int hexadecimalNum = Integer.parseInt(num, 16);
        System.out.println(hexadecimalNum);
        return Integer.toOctalString(hexadecimalNum);
    }

    // Convert Hexadecimal number to Decimal number
    public static String convertHexToDec(String num) {
        int hexadecimalNum = Integer.parseInt(num, 16);
        return String.valueOf(hexadecimalNum);
    }
}
