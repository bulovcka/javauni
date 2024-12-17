package prac14.prac14_2;

import java.util.regex.*;

public class Task2 {
    public static void main(String[] args) {
        String regex = "\\babcdefghijklmnopqrstuv18340\\b";
        Pattern pattern = Pattern.compile(regex);
        String text1 = "abcdefghijklmnopqrstuv18340";
        String text2 = "abcdefghijklmnoasdfasdpqrstuv18340";
        System.out.println(text1 + "\n" + text2);
        if (validate(pattern, text1)){
            System.out.println("Text1 validates");
        }else{
            System.out.println("text1 is not valid");
        }
        if (validate(pattern, text2)){
            System.out.println("Text2 validates");
        }else{
            System.out.println("text2 is not valid");
        }
    }
    public static boolean validate(Pattern pattern, String text){
        Matcher matcher = pattern.matcher(text);
        if(matcher.matches()){
            return true;
        }else{
            return false;
        }
    }
}
