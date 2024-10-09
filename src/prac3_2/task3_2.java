package prac3_2;

public class task3_2 {
    public static void main(String[] args){
        //1.
        Double x = Double.valueOf(3.14);
        Double y = Double.valueOf("52.0");
        System.out.println("X: " + x + " Y: " + y);
//2.
        String str = "785652";
        Double z = Double.parseDouble(str);
        System.out.println("Z: " + z);
//3.
        Double k = Double.valueOf(123.789);
        double a = k.doubleValue();
        int j = k.intValue();
        byte b = k.byteValue();
        short c = k.shortValue();
        long l = k.longValue();
        float f = k.floatValue();
        System.out.println("Double: " + a);
        System.out.println("Int: " + j);
        System.out.println("Byte: " + b);
        System.out.println("Short: " + c);
        System.out.println("Long: " + l);
        System.out.println("Float: " + f);
        //4.
        System.out.println("Double object: " + k);
        //5.
        String tostr = Double.toString(3.14);
        System.out.println("String: " + str);
    }
}
