package prac4_1_2;

public class Main {
    public static void main(String args[]){
        Phone iphone = new Phone("89018834217", 200, "Iphone");
        Phone samsung = new Phone("89017473457", "Samsung");
        Phone xiaomi = new Phone();
        iphone.recieveCall("John Pork");
        iphone.recieveCall("John Pork", "82281337147");
        iphone.sendMessage("12298347", "9328429834");
        System.out.println(xiaomi.toString());
    }
}
