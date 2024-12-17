package prac19_2;

public class User {
    String name;
    String inn;

    public User(String name, String inn) {
        this.name = name;
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public String getInn() {
        return inn;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                '}';
    }
}
