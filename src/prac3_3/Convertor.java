package prac3_3;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
public class Convertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(new Locale("ru", "RU"));
        double eurRate = 106.1;
        double usdRate = 97.01;
        double cnyRate = 13.7;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        NumberFormat numberformat1 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat numberformat2 = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat numberformat3 = NumberFormat.getCurrencyInstance(Locale.CHINA);
        double d = 0;
        System.out.println("Enter amount of money: ");
        if (sc.hasNextDouble()) {
            d = sc.nextDouble();
            while (true){
                if (d < 0){
                    System.out.println("Money cannot be negative");
                    break;
                }
                System.out.println("Current locale: Russia, money in this locale: " + formatter.format(d));
                System.out.println("Enter currency: Euro, Usd, Cny");
                String country = sc.next().toUpperCase();
                switch(country){
                    case "EURO":
                        double res = d / eurRate;
                        System.out.println("RUB -> EUR: " + numberformat1.format(res));
                        break;
                    case "USD":
                        res = d / usdRate;
                        System.out.println("RUB -> USD: " + numberformat2.format(res));
                        break;
                    case "CNY":
                        res = d / cnyRate;
                        System.out.println("RUB -> CNY: " + numberformat3.format(res));
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            }
        }else{
            System.out.println("Wrong input");
        }
    }
}