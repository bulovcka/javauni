package prac13.prac13_4;

public class Shirt {
    public String id;
    public String name;
    public String color;
    public String size;

    public Shirt(String data) {
        String[] datamas = data.split(",");
        this.id = datamas[0];
        this.name = datamas[1];
        this.color = datamas[2];
        this.size = datamas[3];
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String[] data = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };
        Shirt[] newdata = new Shirt[data.length];
        for (int i = 0; i < data.length; i++) {
            newdata[i] = new Shirt(data[i]);
        }

        for (Shirt shirt : newdata) {
            System.out.println(shirt);
        }
    }

}
