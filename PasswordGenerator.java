import java.util.*;
import java.security.*;

public class PasswordGenerator {

    public static String strongPassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "1234567890";
        String symbols = "!@#$%^&*()-_=+[];,/.*-+.{}|:<>?`~";
        String allChars = upper + lower + digits + symbols;
        SecureRandom random = new SecureRandom();
        List<Character> passChar = new ArrayList<>();
        passChar.add(upper.charAt(random.nextInt(upper.length())));
        passChar.add(lower.charAt(random.nextInt(lower.length())));
        passChar.add(digits.charAt(random.nextInt(digits.length())));
        passChar.add(symbols.charAt(random.nextInt(symbols.length())));
        for (int i = 4; i < length; i++) {
            passChar.add(allChars.charAt(random.nextInt(allChars.length())));
        }
        Collections.shuffle(passChar);
        StringBuilder password = new StringBuilder();
        for (char ch : passChar) {
            password.append(ch);
        }
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length;
        while (true) {
            System.out.println("🔢 Enter the length of the Password (min 8): ");
            length = sc.nextInt();
            if (length >= 8) {
                break;
            } else {
                System.out.println("❌ Password length must be at least 8 characters.");
            }
        }
        String Password = strongPassword(length);
        System.out.println("\n✅ The generated password of length " + length + " is:\n\n🔐 " + Password);
        String input;
        do {
            System.out.println("\n🔁 Do you want another password? (yes / no): ");
            input = sc.next();
            if (input.equalsIgnoreCase("yes")) {
                Password = strongPassword(length);
                System.out.println("🆕 New password:\n🔐 " + Password);
            }
        } while (input.equalsIgnoreCase("yes"));
        System.out.println("\n👋 Thank you for using the Password Generator!");
        sc.close();
    }
}
