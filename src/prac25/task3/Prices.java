package prac25.task3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prices {
    public static ArrayList<String> validatePrices(Pattern pattern, String data){
        ArrayList<String> res = new ArrayList<>();
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            res.add(matcher.group());
        }
        return res;
    }


    public static void main(String[] args){
        String regex = "\\b\\d+\\.\\d+\\s?+(USD|EUR|RUB)\\b";
        Pattern pattern = Pattern.compile(regex);
        String data = "Цены: 25.98 USD, 26.00 EUR, 52.52 RUB ,неправильные: 26.23 UDS, 62.3 ERR, 23.23 RUU";
        System.out.println(data);
        ArrayList<String> res = validatePrices(pattern, data);
        System.out.println(res);
    }
}
