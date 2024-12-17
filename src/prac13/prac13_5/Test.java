package prac13.prac13_5;

public class Test {
    public static void main(String[] args) {
        NumberFormat phone1 = new NumberFormat("+74952214356");
        NumberFormat phone2 = new NumberFormat("84952214356");
        NumberFormat phone3 = new NumberFormat("+104952214356");
        System.out.println(phone1.formatNumber());
        System.out.println(phone2.formatNumber());
        System.out.println(phone3.formatNumber());
    }
}
