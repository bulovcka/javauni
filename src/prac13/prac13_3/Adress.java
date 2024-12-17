package prac13.prac13_3;

import java.util.StringTokenizer;

public class Adress {
    String country;
    String region;
    String city;
    String street;
    String number;
    String building;
    String room;

    public Adress(String adress){
        parseUsingSplit(adress);
    }

    public Adress(String adress, String delims){
        parseUsingStringTokenizer(adress, delims);
    }

    public void parseUsingSplit(String adress){
        String[] text = adress.split(",");
        if (text.length != 7){
            throw new IllegalArgumentException("Invalid adress");
        }

        this.country = text[0].trim();
        this.region = text[1].trim();
        this.city = text[2].trim();
        this.street = text[3].trim();
        this.number = text[4].trim();
        this.building = text[5].trim();
        this.room = text[6].trim();
    }

    public void parseUsingStringTokenizer(String adress, String delimiters){
        StringTokenizer tk = new StringTokenizer(adress, delimiters);
        String[] mas = new String[7];
        int index = 0;
        while (tk.hasMoreTokens() && index < 7) {
            mas[index] = tk.nextToken().trim();
            index++;
        }

        if (index != 7){
            throw new IllegalArgumentException("Invalid adress");
        }
        this.country = mas[0].trim();
        this.region = mas[1].trim();
        this.city = mas[2].trim();
        this.street = mas[3].trim();
        this.number = mas[4].trim();
        this.building = mas[5].trim();
        this.room = mas[6].trim();


    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
