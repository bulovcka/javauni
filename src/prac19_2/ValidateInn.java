package prac19_2;

public class ValidateInn {
    public static boolean isValid(String inn) {
        if (!inn.matches("\\d+")) {
            return false;
        }
        if (inn.length() == 10) {
            int[] weights = {2, 4, 10, 3, 5, 9, 4, 6, 8};
            int checksum = 0;
            for (int i = 0; i < 9; i++) {
                checksum += Character.getNumericValue(inn.charAt(i)) * weights[i];
            }
            checksum %= 11;
            if (checksum == 10) checksum %= 10;
            return checksum == Character.getNumericValue(inn.charAt(9));
        } else if (inn.length() == 12) {
            int[] weights1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
            int[] weights2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
            int checksum1 = 0, checksum2 = 0;
            for (int i = 0; i < 10; i++) {
                checksum1 += Character.getNumericValue(inn.charAt(i)) * weights1[i];
            }
            checksum1 %= 11;
            if (checksum1 == 10) checksum1 %= 10;

            for (int i = 0; i < 11; i++) {
                checksum2 += Character.getNumericValue(inn.charAt(i)) * weights2[i];
            }
            checksum2 %= 11;
            if (checksum2 == 10) checksum2 %= 10;

            return checksum1 == Character.getNumericValue(inn.charAt(10)) &&
                    checksum2 == Character.getNumericValue(inn.charAt(11));
        }
        return false;
    }
}
