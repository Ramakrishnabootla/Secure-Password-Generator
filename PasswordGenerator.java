import java.util.*;
import java.security.*;
public class PasswordGenerator{
      public static String strongPassword (int length){
        String upper ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower=upper.toLowerCase();
        String digits="1234567890";
        String symbols = "!@#$%^&*()-_=+[];,/.*-+.{}|:<>?`~";
        String allChars=upper+lower+digits+symbols;
        SecureRandom random = new SecureRandom();
        List<Character> passChar = new ArrayList<>();
        passChar.add(upper.charAt(random.nextInt(upper.length())));
        passChar.add(lower.charAt(random.nextInt(lower.length())));
        passChar.add(digits.charAt(random.nextInt(digits.length())));
        passChar.add(symbols.charAt(random.nextInt(symbols.length())));
        for(int i=4;i<=length;i++){
            passChar.add(allChars.charAt(random.nextInt(allChars.length())));
        }
        Collections.shuffle(passChar);
        StringBuilder password = new StringBuilder();
        for(char ch:passChar){
            password.append(ch);
        }
        return password.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int length;
        while (true) {
            System.out.println("Enter The length of the Password:   ");
            length=sc.nextInt();
            if(length>=8){
                break;
            }else{
                System.out.println("The length of password must be greaterthan or equal to 8:   ");
                length=sc.nextInt();
                if (length>=8) {
                    break;
                }
            }
        }
        String Password = strongPassword(length);
        System.out.println("\n  The generated password with length "+length+" is : \n   \n"+Password);
        String input;
        do {
            System.out.println("Do you Want another password? yes / no:    ");
            input = sc.next();
            if (input.equalsIgnoreCase("yes")) {
                Password = strongPassword(length);
                System.out.println("New password is:  \n" + Password);
            }
        } while (input.equalsIgnoreCase("yes"));
        System.out.println("Thank you!");
    }
}