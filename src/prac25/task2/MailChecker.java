package prac25.task2;


import java.util.regex.Pattern;

public class MailChecker {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        String[] mails = {
                "user@example.com",
                "root@localhost",
                "urod@@com.ru",
                "@balbes.ru",
                "Hello World!"
        };

        Pattern pattern = Pattern.compile(regex);

        for (String mail : mails) {
            boolean isValid = pattern.matcher(mail).matches();
            System.out.println(mail + " : " + (isValid ? "mail is valid" : "mail is invalid"));
        }
    }
}
