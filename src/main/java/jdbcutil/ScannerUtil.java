package jdbcutil;

import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputString() {
        return SCANNER.nextLine().trim().replaceAll("\\s{2,}"," ");
    }

    public static int inputInteger() {
        while (true) {
            try {
                String input = inputString();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Yêu cầu nhập số nguyên");
                System.err.println("Nhập lại");
            }
        }

    }

    public static String inputEmail() {
        while (true) {
            String email = SCANNER.nextLine();// equals(); so sanh gtri,   == so sánh địa chỉ ,  biểu thức chính quy, matches(): so sánh  theo quy tắc
            if (email == null || !email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {// a@b
                System.out.print("Nhập lại: ");
            } else {
                return email;
            }
        }
    }

    public static String inputPassword() {
        while (true) {
            String input = inputString();
            int length = input.length();
            if (length < 6 || length > 12) {
                System.err.println("Yêu cầu password từ 6 đến 12 kí tự.");
                System.err.println("Nhập lại");
            } else if (hasAnyUpperCaseCharacter(input)) {
                return input;
            } else {
                System.err.println("Yêu cầu password có ít nhất 1 kí tự viết hoa.");
                System.err.println("Nhập lại");
            }
        }
    }
    private static boolean hasAnyUpperCaseCharacter(String s) {
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

}
