package prac25.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateChecker {
    public static void main(String[] args) {
        String regex = "\\b(0[0-9]|[12][0-9]|3[01])/(0[0-9]|1[0-2])/((19\\d{2})|(2\\d{3}))\\b";
        Pattern pattern = Pattern.compile(regex);
        String data = "Даты: 29/02/2000, 30/04/2003, 01/01/2003 неправильные: 29/02/2001, 30-04-2003, 1/1/1899";
        ArrayList<String> res = validate(pattern, data);
        System.out.println(res);
    }

    public static boolean isLogicalDate(Pattern pattern, String date){
        try{
            String[] parts = date.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            LocalDate.of(year, month, day);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static ArrayList<String> validate(Pattern pattern, String date){
        Matcher matcher = pattern.matcher(date);
        ArrayList<String> res = new ArrayList<>();
        while(matcher.find()){
            if (isLogicalDate(pattern, matcher.group())){
                res.add(matcher.group());
            }
        }
        return res;
    }

}
