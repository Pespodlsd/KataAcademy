import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите вычесляемое выражение.");
        String input = scan.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        String[] massOfValues;
        String[] romeNumbers;
        String value = null;
        int result = 0;
        if (input.contains("+")) {
            massOfValues = input.split("\\+");
            if (isNumeric(massOfValues[0]) && isNumeric(massOfValues[1])) {
                if (isTrue(Integer.parseInt(massOfValues[0]),Integer.parseInt(massOfValues[1]))) {
                    result = Integer.parseInt(massOfValues[0]) + Integer.parseInt(massOfValues[1]);
                } else {
                    throw new Exception();
                }
                value = Integer.toString(result);
            } else if ((isNumeric(massOfValues[0]) || isNumeric(massOfValues[1]))) {
                throw new Exception();
            } else {
                romeNumbers = romeToArab(massOfValues);
                if (isTrue(Integer.parseInt(romeNumbers[0]),Integer.parseInt(romeNumbers[1]))) {
                    result = Integer.parseInt(romeNumbers[0]) + Integer.parseInt(romeNumbers[1]);
                } else {
                    throw new Exception();
                }
                value = arabToRome(result);
            }
        } else if (input.contains("-")) {
            massOfValues = input.split("-");
            if (isNumeric(massOfValues[0]) && isNumeric(massOfValues[1])) {
                if (isTrue(Integer.parseInt(massOfValues[0]),Integer.parseInt(massOfValues[1]))) {
                    result = Integer.parseInt(massOfValues[0]) - Integer.parseInt(massOfValues[1]);
                } else {
                    throw new Exception();
                }
                value = Integer.toString(result);
            } else if ((isNumeric(massOfValues[0]) || isNumeric(massOfValues[1]))) {
                throw new Exception();
            } else {
                romeNumbers = romeToArab(massOfValues);
                if (isTrue(Integer.parseInt(romeNumbers[0]),Integer.parseInt(romeNumbers[1]))) {
                    result = Integer.parseInt(romeNumbers[0]) - Integer.parseInt(romeNumbers[1]);
                } else {
                    throw new Exception();
                }
                value = arabToRome(result);
            }
        } else if (input.contains("*")) {
            massOfValues = input.split("\\*");
            if (isNumeric(massOfValues[0]) && isNumeric(massOfValues[1])) {
                if (isTrue(Integer.parseInt(massOfValues[0]),Integer.parseInt(massOfValues[1]))) {
                    result = Integer.parseInt(massOfValues[0]) * Integer.parseInt(massOfValues[1]);
                } else {
                    throw new Exception();
                }
                value = Integer.toString(result);
            } else if ((isNumeric(massOfValues[0]) || isNumeric(massOfValues[1]))) {
                throw new Exception();
            } else {
                romeNumbers = romeToArab(massOfValues);
                if (isTrue(Integer.parseInt(romeNumbers[0]),Integer.parseInt(romeNumbers[1]))) {
                    result = Integer.parseInt(romeNumbers[0]) * Integer.parseInt(romeNumbers[1]);
                } else {
                    throw new Exception();
                }
                value = arabToRome(result);
            }
        } else if (input.contains("/")) {
            massOfValues = input.split("/");
            if (isNumeric(massOfValues[0]) && isNumeric(massOfValues[1])) {
                if (isTrue(Integer.parseInt(massOfValues[0]),Integer.parseInt(massOfValues[1]))) {
                    result = Integer.parseInt(massOfValues[0]) / Integer.parseInt(massOfValues[1]);
                } else {
                    throw new Exception();
                }
                value = Integer.toString(result);
            } else if ((isNumeric(massOfValues[0]) || isNumeric(massOfValues[1]))) {
                throw new Exception();
            } else {
                romeNumbers = romeToArab(massOfValues);
                if (isTrue(Integer.parseInt(romeNumbers[0]),Integer.parseInt(romeNumbers[1]))) {
                    result = Integer.parseInt(romeNumbers[0]) / Integer.parseInt(romeNumbers[1]);
                } else {
                    throw new Exception();
                }
                value = arabToRome(result);
            }
        } else {
            throw new Exception();
        }
        return value;
    }
    public static boolean isTrue (int i, int j) {
        return i > 0 && i <= 10 && j > 0 && j <= 10;
    }
    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String[] romeToArab(String[] strings) throws Exception {
        String[] values = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            char[] ch = strings[i].toCharArray();
            int value = 0;
            if (ch.length == 1) {
                value = getArabic(ch[0]);
            } else if (ch.length == 2) {
                if (ch[0] == ch[1] || getArabic(ch[0]) > getArabic(ch[1])) {
                    value = getArabic(ch[0]) + getArabic(ch[1]);
                } else {
                    value = getArabic(ch[1]) - getArabic(ch[0]);
                }
            } else if (ch.length == 3) {
                value = getArabic(ch[0]) + getArabic(ch[1]) + getArabic(ch[2]);
            } else if (ch.length == 4 && ch[0] != ch[1]) {
                value = getArabic(ch[0]) + getArabic(ch[1]) + getArabic(ch[2]) + getArabic(ch[3]);
            } else {
                throw new Exception();
            }
            values[i] = Integer.toString(value);
        }
        return values;
    }
    public static String arabToRome (int num) throws Exception {
        String value = null;
        if (num > 0) {
            if (num == 1 || num == 5 || num == 10 || num == 50 || num == 100){
                value = getRome(num);
            } else {
                int unit = num % 10;
                int dozen = num - unit;
                value = romeNumber(dozen) + romeNumber(unit);
            }
        } else {
            throw new Exception();
        }
        return value;
    }
    public static int getArabic(char ch) {
        int value = switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            default -> 0;
        };
        return value;
    }
    public static String getRome (int i) {
        String value = switch (i) {
            case (1) -> "I";
            case (5) -> "V";
            case (10) -> "X";
            case (50) -> "L";
            case (100) -> "C";
            default -> "";
        };
        return value;
    }
    public static String romeNumber (int i) {
        String number = switch (i) {
            case (20) -> "XX";
            case (30) -> "XXX";
            case (40) -> "XL";
            case (60) -> "LX";
            case (70) -> "LXX";
            case (80) -> "LXXX";
            case (90) -> "XC";
            case (2) -> "II";
            case (3) -> "III";
            case (4) -> "IV";
            case (6) -> "VI";
            case (7) -> "VII";
            case (8) -> "VIII";
            case (9) -> "IX";
            default -> "";
        };
        return number;
    }
}