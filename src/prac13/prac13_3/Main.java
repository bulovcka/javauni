package prac13.prac13_3;

public class Main {
    public static void main(String[] args){
        String test1 = "Россия, Московская область, Москва, Красная площадь, 1, 1А, 101";
        String test2 = "США, Калифорния, Лос-Анджелес, ROSE AVENUE, 10700, B, 50";
        System.out.println("Тестирование с разделетелем ,");
        Adress adress1 = new Adress(test1);
        Adress adress2 = new Adress(test2);
        System.out.println(adress1);
        System.out.println(adress2);
        System.out.println("Тестирование с другими разделителями");
        String delims = ".;-";
        String test4 = "Франция. Ile de France. Париж. Rue de la Paix. 5. B. 12";
        String test5 = "UK; Scotland; Edinburgh; Princess Street; 56; A; 3";
        String test6 = "Australia-New South Wales-Sydney-Pitt Street-50-C-21";
        Adress adress4 = new Adress(test4, ".;-");
        Adress adress5 = new Adress(test5, delims);
        Adress adress6 = new Adress(test6, delims);
        System.out.println(adress4);
        System.out.println(adress5);
        System.out.println(adress6);
    }
}
